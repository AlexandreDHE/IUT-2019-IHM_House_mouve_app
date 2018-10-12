import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class Cartons extends JPanel{
	private JPanel pan;
	private CardLayout cc;
	public Cartons(Fenetre i){
		super();
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		String[] choix = new String[]{"Salle a manger","Cuisine","Chambre1","Chambre2","Chambre3","Salle de bain","Toilettes","Salon"};
		this.cc = new CardLayout();
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 1.0f;
		c.weighty = 1.0f;
		c.fill=GridBagConstraints.BOTH;
		Img ret = new Img("<.png");
		ret.addMouseListener(new Movve(ret));
		ret.addMouseListener(new Move(i));
		ret.setHorizontalAlignment(JLabel.LEFT);
		this.add(ret,c);
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 1.0f;
		c.weighty = 1.0f;
		c.fill=GridBagConstraints.BOTH;
		this.add(new Img("carto.png"),c);
		c.gridx = 2;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 1.0f;
		c.weighty = 1.0f;
		c.fill=GridBagConstraints.BOTH;
		this.add(new JPanel(),c);
		this.pan = new JPanel();
		this.pan.setLayout(this.cc);
		this.add(this.pan,c);
		c.gridx = 1;
		c.gridy = 1;
		AllCarton u = new AllCarton("Cuisine");
		this.add(u,c);
		c.gridx = 1;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 1.0f;
		c.weighty = 1.0f;
		c.fill=GridBagConstraints.BOTH;
		this.add(new JPanel(),c);
		JButton[] boutons = new JButton[choix.length];
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 3;
		c.gridheight = 1;
		c.weightx = 1.0f;
		c.weighty = 0.2f;
		c.fill=GridBagConstraints.BOTH;
		JPanel yup = new JPanel();
		yup.setLayout(new GridLayout(1,8));
		for(int j=0;j<8;j++){
			boutons[j] = new JButton(""+choix[j]);
			yup.add(boutons[j]);
		}
		this.add(yup,c);
	}
}