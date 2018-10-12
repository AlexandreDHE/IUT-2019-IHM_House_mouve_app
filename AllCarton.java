import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AllCarton extends JPanel{
	public AllCarton(String room){
		this.setLayout(new GridBagLayout());
		GridBagConstraints cc = new GridBagConstraints();
		Model x = new Model();
		ObCarton c = x.getCarton(room);
		cc.gridx = 1;
		cc.gridy = 0;
		cc.gridheight = 1;
		cc.gridwidth = 1;
		cc.weightx = 1.0f;
		cc.weighty = 1.0f;
		cc.fill = GridBagConstraints.BOTH;
		this.add(new JLabel(c.getNom()),cc);
		String[] cara = new String[]{"Petits","Moyens","Barrel","Penderie","Tableaux",};
		String[] tabcara = new String[]{"35x27x30","55x35x30","45x45x75","120x50x50","100x15x90"};
		for(int i=1;i<6;i++){
			cc.gridx = 0;
			cc.gridy = i;
			this.add(new JLabel(""+cara[i-1]+"\n"+tabcara[i-1]),cc);
		}
		cc.gridx = 1;
		cc.gridy = 1;
		this.add(new JLabel(""+c.getPetit()),cc);
		cc.gridy = 2;
		this.add(new JLabel(""+c.getMoyen()),cc);
		cc.gridy = 3;
		this.add(new JLabel(""+c.getBarrel()),cc);
		cc.gridy = 4;
		this.add(new JLabel(""+c.getPenderie()),cc);
		cc.gridy = 5;
		this.add(new JLabel(""+c.getTableau()),cc);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
	}
}