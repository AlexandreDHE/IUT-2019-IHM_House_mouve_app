import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Scroll extends JScrollPane{
	public Scroll(Meuble[] meuble){
		this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		JPanel pan = new JPanel();
		pan.setPreferredSize(new Dimension(200,50));
		for(int i=0;i<meuble.length;i++){
			pan.add(new JLabel("Nom : "+meuble[i].getNom()));
			pan.add(new JLabel("Longueur : "+meuble[i].getLong()));
			pan.add(new JLabel("Largeur : "+meuble[i].getLarg()));
			pan.add(new JLabel("Hauteur : "+meuble[i].getHaut()));
			pan.add(new JLabel("Element : "+meuble[i].getElt()));
		}
		this.setViewportView(pan);
	}
}