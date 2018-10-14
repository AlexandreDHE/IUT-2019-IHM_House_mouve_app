import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Model extends JComponent{
	private Connection connec;
	private int nbmb=0;
	private Meuble[] mb;
	private int v=1;
	private Inventaire a;
	public Model(){
		try{
			Class.forName("org.mariadb.jdbc.Driver");
			try{
				Connection connect = DriverManager.getConnection("jdbc:mariadb://dwarves.iut-fbleau.fr/baaziz","baaziz","baaziz");
				this.connec = connect;
				this.Lecture();
			}catch(SQLException e){
				System.err.println("Erreur de connexion a la base de donnée");
				System.exit(1);
			}
		}catch(ClassNotFoundException e){
			System.err.println("Erreur de chargement du pilote");
			System.exit(1);
		}
	}
	public Model(Inventaire b){
		this.a=b;
		try{
			Class.forName("org.mariadb.jdbc.Driver");
			try{
				Connection connect = DriverManager.getConnection("jdbc:mariadb://dwarves.iut-fbleau.fr/baaziz","baaziz","baaziz");
				this.connec = connect;
				this.Lecture();
			}catch(SQLException e){
				System.err.println("Erreur de connexion a la base de donnée");
				System.exit(1);
			}
		}catch(ClassNotFoundException e){
			System.err.println("Erreur de chargement du pilote");
			System.exit(1);
		}
	}
	public void paintComponent(Graphics pinceau){
		this.Lecture();
		Graphics secondPinceau = pinceau.create();
		if (this.isOpaque()) {
		  secondPinceau.setColor(this.getBackground());
		  secondPinceau.fillRect(0, 0, this.getWidth(), this.getHeight());
		}
		secondPinceau.setFont(new Font("Arial",Font.PLAIN,30));
		if(this.nbmb!=0){
			secondPinceau.drawString(this.v+"/"+this.nbmb+" Meubles",(this.getWidth()/2)-70,this.getHeight()/2);
		}else{
			secondPinceau.drawString(this.v+"/"+this.nbmb+" Meuble",(this.getWidth()/2)-70,this.getHeight()/2);
		}
	}
	public void Lecture(){
		this.nbmb=0;
		try{
			PreparedStatement statement = this.connec.prepareStatement("SELECT * FROM Meuble;");
			ResultSet res = statement.executeQuery();
			if(res.first()){
				this.nbmb++;
				while(res.next()){
					this.nbmb++;
				}
				res.first();
				this.mb = new Meuble[this.nbmb];
				for(int i=0;i<this.nbmb;i++){
					this.mb[i] = new Meuble();
					this.mb[i].setNom(res.getString(1));
					this.mb[i].setLong(res.getInt(2));
					this.mb[i].setLarg(res.getInt(3));
					this.mb[i].setHaut(res.getInt(4));
					this.mb[i].setDemont(res.getBoolean(5));
					this.mb[i].setElt(res.getInt(6));
					this.mb[i].setLongg(res.getInt(7));
					this.mb[i].setLargg(res.getInt(8));
					this.mb[i].setHautt(res.getInt(9));
					res.next();
				}
			}
			res.close();
		}catch(SQLException e){
			System.err.println("Erreur de lecture");
			System.exit(1);
		}
	}
	public Meuble[] getMeuble(){
		return this.mb;
	}
	public void setVal(int a){
		this.v=a;
		this.repaint();
	}
	public void deleteMeuble(String a){
		try{
			PreparedStatement statement = this.connec.prepareStatement("DELETE FROM Meuble WHERE nom=?");
			statement.setString(1,a);
			statement.executeUpdate();
		}catch(SQLException e){
			System.err.println("Erreur de suppression");
			System.exit(1);
		}
	}
	public void deleteCarton(String a){
		String[] x = this.getRooms();
		int i=0;
		while(i<x.length){
			i++;
		}
		if(i>1){
			try{
				PreparedStatement statement = this.connec.prepareStatement("DELETE FROM Carton WHERE chambre=?");
				statement.setString(1,a);
				statement.executeUpdate();
			}catch(SQLException e){
				System.err.println("Erreur de suppression");
				System.exit(1);
			}
		}else{
			JOptionPane.showMessageDialog(null, "Un Carton doit etre declare");
		}
	}
	public boolean changeValCarton(String u,AllCarton t,int curseur,int valeur){
		String x=null;
		if(curseur==0){
			x="petit";
		}else if(curseur==1){
			x="moyen";
		}else if(curseur==2){
			x="barrel";
		}else if(curseur==3){
			x="penderie";
		}else if(curseur==4){
			x="tableau";
		}
		if(valeur>=0 && valeur<=20){
			try{
				PreparedStatement statement = this.connec.prepareStatement("UPDATE `Carton` SET "+x+"=? WHERE `chambre`=?");
				statement.setInt(1,valeur);
				statement.setString(2,u);
				statement.executeUpdate();
				return true;
			}catch(SQLException e){
				JOptionPane.showMessageDialog(t, "Inserer une valeur valide");
			}
		}else{
			JOptionPane.showMessageDialog(t, "Inserer une valeur comprise entre 0 et 20");
		}
		return false;
	}
	public String[] getRooms(){
		int x=0;
		String[] room = null;
		try{
			PreparedStatement statement = this.connec.prepareStatement("SELECT chambre FROM Carton;");
			ResultSet res = statement.executeQuery();
			if(res.first()){
				x++;
				while(res.next()){
					x++;
				}
				res.first();
				room = new String[x];
				for(int i=0;i<x;i++){
					room[i] = res.getString(1);
					res.next();
				}
			}
			res.close();
		}catch(SQLException e){
			System.err.println("Erreur de lecture");
			System.exit(1);
		}
		return room;
	}
	public void Ecriture(NewPanMeuble j,Meuble a){
		if(a.getDemont()){
			try{
				PreparedStatement statement = this.connec.prepareStatement("INSERT INTO `Meuble`(`nom`, `longueur`, `larg`, `haut`, `demontable`, `elt`, `longu`, `large`, `hautt`) VALUES (?,?,?,?,?,?,?,?,?);");
				statement.setString(1,a.getNom());
				statement.setInt(2,a.getLong());
				statement.setInt(3,a.getLarg());
				statement.setInt(4,a.getHaut());
				statement.setBoolean(5,a.getDemont());
				statement.setInt(6,a.getElt());
				statement.setInt(7,a.getLongg());
				statement.setInt(8,a.getLargg());
				statement.setInt(9,a.getHautt());
				statement.executeQuery();
			}catch(SQLException e){
				JOptionPane.showMessageDialog(j, "Ce meuble existe deja");
			}
		}else{
			try{
				PreparedStatement statement = this.connec.prepareStatement("INSERT INTO `Meuble`(`nom`, `longueur`, `larg`, `haut`, `demontable`) VALUES (?,?,?,?,?)");
				statement.setString(1,a.getNom());
				statement.setInt(2,a.getLong());
				statement.setInt(3,a.getLarg());
				statement.setInt(4,a.getHaut());
				statement.setBoolean(5,a.getDemont());
				statement.executeQuery();
			}catch(SQLException e){
				JOptionPane.showMessageDialog(j, "Ce meuble existe deja");
			}
		}
	}
	public void Ecriture(NewNewCarton j,ObCarton a){
		try{
			PreparedStatement statement = this.connec.prepareStatement("INSERT INTO `Carton`(`chambre`, `petit`, `moyen`, `barrel`, `penderie`, `tableau`) VALUES (?,?,?,?,?,?)");
			System.out.println(a.getNom());
			System.out.println(a.getPetit());
			System.out.println(a.getMoyen());
			System.out.println(a.getBarrel());
			System.out.println(a.getPenderie());
			System.out.println(a.getTableau());
			statement.setString(1,a.getNom());
			statement.setInt(2,a.getPetit());
			statement.setInt(3,a.getMoyen());
			statement.setInt(4,a.getBarrel());
			statement.setInt(5,a.getPenderie());
			statement.setInt(6,a.getTableau());
			statement.executeQuery();
		}catch(SQLException e){
			JOptionPane.showMessageDialog(j, "Cette chambre existe deja");			
		}
	}
	public ObCarton getCarton(String a){
		ObCarton cart = new ObCarton();
		try{
			PreparedStatement statement = this.connec.prepareStatement("SELECT * FROM Carton WHERE chambre=?;");
			statement.setString(1,a);
			ResultSet res = statement.executeQuery();
			if(res.first()){
				cart.setNom(res.getString(1));
				cart.setPetit(res.getInt(2));
				cart.setMoyen(res.getInt(3));
				cart.setBarrel(res.getInt(4));
				cart.setPenderie(res.getInt(5));
				cart.setTableau(res.getInt(6));
			}
			res.close();
		}catch(SQLException e){
			System.err.println("Erreur de lecture");
			System.exit(1);
		}
		return cart;
	}
}