import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class Cartons extends JPanel{
	
	public Cartons(Fenetre i){
		super();
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
		ret.addMouseListener(new Movve(ret));
		ret.setHorizontalAlignment(JLabel.LEFT);
		this.add(ret,c);
	}
}