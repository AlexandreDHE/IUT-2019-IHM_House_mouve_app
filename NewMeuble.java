import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NewMeuble extends JPanel{
	public Fenetre y;
	public NewMeuble(Fenetre b){
		this.y=b;
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 1.0f;
		c.weighty = 1.0f;
		c.fill=GridBagConstraints.BOTH;
		Img ret = new Img("<.png");
		ret.addMouseListener(new Mouse(b));
		ret.addMouseListener(new Movve(ret));
		this.add(ret,c);
		c.gridx = 1;
		c.gridy = 0;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.weightx = 1.0f;
		c.weighty = 1.0f;
		c.fill = GridBagConstraints.BOTH;
		Img a = new Img("nouveau.png");
		this.add(a,c);
		c.gridx = 2;
		c.gridy = 0;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.weightx = 1.0f;
		c.weighty = 1.0f;
		c.fill = GridBagConstraints.BOTH;
		this.add(new JPanel(),c);
		c.gridx = 1;
		c.gridy = 1;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.weightx = 1.0f;
		c.weighty = 1.0f;
		c.fill = GridBagConstraints.BOTH;
		NewPanMeuble bb = new NewPanMeuble(b);
		this.add(bb,c);
	}
	public void retour(){
		this.y.next();
	}
}