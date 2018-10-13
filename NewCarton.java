import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NewCarton extends JPanel{
	public NewCarton(Fenetre m){
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 1.0f;
		c.weighty = 1.0f;
		c.fill=GridBagConstraints.BOTH;
		Img ret = new Img("ret1.png");
		ret.addMouseListener(new Mousse(m));
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
		NewNewCarton yu = new NewNewCarton(m);
		this.add(yu,c);
		c.gridx = 1;
		c.gridy = 2;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.weightx = 1.0f;
		c.weighty = 1.0f;
		c.fill = GridBagConstraints.NONE;
		JButton crea = new JButton("Rajouter la piece");
		crea.addActionListener(new Action(yu));
		this.add(crea,c);
	}
}