import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PanMeuble extends JPanel{
	public PanMeuble(Meuble meuble){
		this.setLayout(new GridBagLayout());
		JLabel[] lab = new JLabel[9];
		lab[0] = new JLabel(""+meuble.getNom());
		lab[1] = new JLabel(""+meuble.getLong());
		lab[2] = new JLabel(""+meuble.getLarg());
		lab[3] = new JLabel(""+meuble.getHaut());
		this.setBackground(new Color(185, 172, 136));
		if(meuble.getDemont()){
			lab[4] = new JLabel("Oui");
		}else{
			lab[4] = new JLabel("Non");
		}
		lab[5] = new JLabel(""+meuble.getElt());
		lab[6] = new JLabel(""+meuble.getLongg());
		lab[7] = new JLabel(""+meuble.getLargg());
		lab[8] = new JLabel(""+meuble.getHautt());
		for(int i=0;i<9;i++)lab[i].setFont(new Font("Arial",Font.PLAIN,25));
		String[] chaines = new String[]{"Nom  :","Longueur :","Largeur :","Hauteur :","Demontable :","Elements :","Longueur + :","Largeur + :","Hauteur + :"};
		JLabel[] chaine = new JLabel[9];
		for(int i=0;i<9;i++)chaine[i] = new JLabel(chaines[i]);
		for(int i=0;i<9;i++)chaine[i].setFont(new Font("Arial",Font.PLAIN,25));
		GridBagConstraints c = new GridBagConstraints();
		for(int i=0;i<9;i++){
			if(i==5 && !meuble.getDemont()){
				break;
			}
			c.gridx = 0;
			c.gridy = i;
			c.gridheight = 1;
			c.gridwidth = 1;
			c.ipadx =10;
			c.ipady = 10;
			this.add(chaine[i],c);
		}
		for(int i=0;i<9;i++){
			if(i==5 && !meuble.getDemont()){
				break;
			}
			c.gridx = 1;
			c.gridy = i;
			c.gridheight = 1;
			c.gridwidth = 1;
			c.ipadx =10;
			c.ipady = 10;
			this.add(lab[i],c);
		}
		
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
	}
}