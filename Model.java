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
			secondPinceau.drawString(this.v+"/"+this.nbmb+" Meubles",this.getWidth()/2,this.getHeight()/2);
		}else{
			secondPinceau.drawString(this.v+"/"+this.nbmb+" Meuble",this.getWidth()/2,this.getHeight()/2);
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
	public void delete(Meuble a){
		try{
			PreparedStatement statement = this.connec.prepareStatement("DELETE FROM Meuble WHERE nom=? AND longueur=? AND larg=? AND haut=? AND demontable=? AND elt=? AND longu=? AND large=? AND hautt=?");
			System.out.println(a.getNom());
			System.out.println(a.getLong());
			System.out.println(a.getLarg());
			System.out.println(a.getHaut());
			System.out.println(a.getDemont());
			System.out.println(a.getElt());
			System.out.println(a.getLongg());
			System.out.println(a.getLargg());
			System.out.println(a.getHautt());
			statement.setString(1,a.getNom());
			statement.setInt(2,a.getLong());
			statement.setInt(3,a.getLarg());
			statement.setInt(4,a.getHaut());
			statement.setBoolean(5,a.getDemont());
			statement.setInt(6,a.getElt());
			statement.setInt(7,a.getLongg());
			statement.setInt(8,a.getLargg());
			statement.setInt(9,a.getHautt());
			statement.executeUpdate();
		}catch(SQLException e){
			System.err.println("Erreur de suppression");
			System.exit(1);
		}
		this.Lecture();
		this.repaint();
	}
	public void Ecriture(Meuble a){
		try{
			PreparedStatement statement = this.connec.prepareStatement("INSERT INTO `Meuble`(`nom`, `longueur`, `larg`, `haut`, `demontable`, `elt`, `longu`, `large`, `hautt`) VALUES (?,?,?,?,?,?,?,?,?)");
			statement.setString(1,a.getNom());
			statement.setInt(2,a.getLong());
			statement.setInt(3,a.getLarg());
			statement.setInt(4,a.getHaut());
			statement.setBoolean(5,a.getDemont());
			statement.setInt(6,a.getElt());
			statement.setInt(7,a.getLongg());
			statement.setInt(8,a.getLargg());
			statement.setInt(9,a.getHautt());
			statement.setInt(9,a.getHautt());
			statement.executeQuery();
		}catch(SQLException e){
			System.err.println("Erreur d'ajout");
			System.exit(1);
		}
	}
	public void actu(){
		this.a.actu();
	}
}