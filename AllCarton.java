import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AllCarton extends JPanel{
	private JTextField[] field;
	private ObCarton c;
	private JLabel[] m;
	public AllCarton(String room){
		this.setLayout(new GridBagLayout());
		GridBagConstraints cc = new GridBagConstraints();
		this.field = new JTextField[5];
		Model x = new Model();
		this.c = x.getCarton(room);
		cc.gridx = 1;
		cc.gridy = 0;
		cc.gridheight = 1;
		cc.gridwidth = 1;
		cc.weightx = 1.0f;
		cc.weighty = 1.0f;
		cc.fill = GridBagConstraints.BOTH;
		JPanel[] pan = new JPanel[5];
		JLabel h = new JLabel(this.c.getNom());
		h.setFont(new Font("Arial",Font.PLAIN,25));
		h.setHorizontalAlignment(JLabel.CENTER);
		h.setVerticalAlignment(JLabel.CENTER);
		h.setBorder(BorderFactory.createMatteBorder(0, 3, 0,0, Color.BLACK));
		String[] cara = new String[]{"Petits","Moyens","Barrel","Penderie","Tableaux",};
		String[] tabcara = new String[]{"35x27x30cm","55x35x30cm","45x45x75cm","120x50x50cm","100x15x90cm"};
		this.add(h,cc);
		for(int i=1;i<6;i++){
			cc.gridx = 0;
			cc.gridy = i;
			JLabel lab = new JLabel("<html>"+cara[i-1]+"<br>"+tabcara[i-1]+"</html>");
			lab.setHorizontalAlignment(JLabel.CENTER);
			lab.setVerticalAlignment(JLabel.CENTER);
			lab.setFont(new Font("Arial",Font.PLAIN,25));
			lab.setBorder(BorderFactory.createMatteBorder(3, 0, 0, 3, Color.BLACK));
			this.add(lab,cc);
		}
		cc.gridx = 1;
		this.m= new JLabel[5];
		for(int j=0;j<5;j++){
			cc.gridy = j+1;
			this.m[j] = new JLabel(""+this.retValue(j));
			this.m[j].setHorizontalAlignment(JLabel.CENTER);
			this.m[j].setVerticalAlignment(JLabel.CENTER);
			this.m[j].setFont(new Font("Arial",Font.PLAIN,20));
			pan[j] = new JPanel();
			pan[j].setBorder(BorderFactory.createMatteBorder(3, 0, 0, 0, Color.BLACK));
			pan[j].setLayout(new GridLayout(1,2));
			pan[j].add(this.m[j]);
			this.field[j] = new JTextField(1);
			this.field[j].addActionListener(new ActionText(this.c.getNom(),j,this,this.field[j],this.m[j]));
			pan[j].add(this.field[j]);
			this.add(pan[j],cc);
		}
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
	}
	public int retValue(int cur){
		switch(cur){
			case 0: return this.c.getPetit();
			case 1: return this.c.getMoyen();
			case 2: return this.c.getBarrel();
			case 3: return this.c.getPenderie();
			case 4: return this.c.getTableau();
		}
		return 0;
	}
}