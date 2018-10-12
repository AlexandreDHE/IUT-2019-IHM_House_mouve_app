import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Estimation extends JPanel{
    private GridBagLayout gridbag = new GridBagLayout();
    private GridBagConstraints c = new GridBagConstraints();
    private JPanel grid = new JPanel();
    private Bdd bdd;
    private String[] cara;
    private String[] tabcara;
    private String[] title;
    private Auditeur aud;
    int compteur = 0;
    JComboBox<String> box;
    JTextField txt;
    LinkedList<Ligne> list = new LinkedList<Ligne>();

    public Estimation(Auditeur aud, Bdd bdd){
    	super();
    	Color C =new Color(255, 166, 77);
      	this.setBackground(C);
    	this.aud = aud;
    	bdd.Ouverture();

    	JPanel up = new JPanel();
    	up.setLayout(new GridLayout(2, 1));
    	
    	JPanel top = new JPanel();
    	JLabel t = new JLabel("Choisissez vos pieces");
    	t.setFont(new Font("", Font.PLAIN, 20));
    	//Pièce d'une maison basic
    	String[] choix = new String[]{"Salle a manger","Cuisine","Chambre1","Chambre2","Chambre3","Salle de bain","Toilettes","Salon"};
    	box = new JComboBox<>(choix);
    	JButton bt = new JButton("Ajouter");
    	top.add(t);
    	top.add(box);
    	top.add(bt);
    	top.setBackground(C);
        up.add(top);

        JPanel top1 = new JPanel();
    	txt = new JTextField(5);
    	JLabel t1 = new JLabel("Ajouter vos pieces");
    	t1.setFont(new Font("", Font.PLAIN, 20));
    	JButton add = new JButton("Ajouter piece");
    	top1.add(t1);
    	top1.add(txt);
    	top1.add(add);
    	top1.setBackground(C);
        up.add(top1);
        this.add(up, BorderLayout.NORTH);

		cara = new String[]{"Petits","Moyens","Barrel","Penderie","Tableaux",};
	    tabcara = new String[]{"35x27x30","55x35x30","45x45x75","120x50x50","100x15x90"};
    	grid.setLayout(gridbag);
	    c.fill = GridBagConstraints.VERTICAL;
	    c.weightx = 0.1;
	    grid.setBackground(C);

	    for(int i=0;i<this.cara.length;i++) {
	    	GridBagConstraints o = new GridBagConstraints();
	    	o.gridy = 0;
	    	o.gridx = i+1;
	    	o.ipadx = 15;
	    	o.ipady = 30;
	    	JLabel label = new JLabel(cara[i]);
	        label.setFont(new Font("", Font.PLAIN, 16));
	    	grid.add(label,o);
	    }
	    for(int i=0;i<cara.length;i++) {
	    	GridBagConstraints o = new GridBagConstraints();
	    	o.gridy = 1;
	    	o.gridx = i+1;
	    	o.ipadx = 15;
	    	o.ipady = 30;
	    	JLabel label = new JLabel(tabcara[i]);
	        label.setFont(new Font("", Font.PLAIN, 16));
	    	grid.add(label,o);
	    }
	    bt.addActionListener(aud);
    	box.addActionListener(aud);
    	add.addActionListener(aud);
    	txt.addActionListener(aud);
	    this.add(grid, BorderLayout.CENTER);
	    JButton bt1 = new JButton("Finaliser");
	    bt1.addActionListener(aud);
	    this.add(bt1, BorderLayout.SOUTH);
	    
	    this.setVisible(true);
	}
	public void affichage(String s) {
	    for(int i = 0; i<list.size(); i++){
	    	if(list.get(i).nom.equals(s)){
	    		return;
	    	}
	    }
	    GridBagConstraints o = new GridBagConstraints();
	   	JSpinner j1 = new JSpinner();
	    JSpinner j2 = new JSpinner();
	    JSpinner j3 = new JSpinner();
	    JSpinner j4 = new JSpinner();
	    JSpinner j5 = new JSpinner();
	    Ligne l;
	    o.gridy = 2+this.compteur;
	    o.gridx = 0;
	    o.ipadx = 15;
	    o.ipady = 30;
	    JLabel label = new JLabel(s);
       	label.setFont(new Font("", Font.BOLD, 20));
	    grid.add(label,o);

	    addJspinner(j1,0,o);
	    addJspinner(j2,1,o);
	    addJspinner(j3,2,o);
	    addJspinner(j4,3,o);
	    addJspinner(j5,4,o);

	    l = new Ligne(s,j1,j2,j3,j4,j5);

	    list.add(l);

    	this.compteur++;
    	this.setVisible(true);
	}

	public void addJspinner(JSpinner j, int i, GridBagConstraints o){
		
		JSpinner.NumberEditor spinnerEditor = new JSpinner.NumberEditor(j);
        j.setEditor(spinnerEditor);
        spinnerEditor.getModel().setMinimum(0);
        o.gridy = 2+this.compteur;
	   	o.gridx = i+1;
	    o.ipadx = 15;
	    o.ipady = 15;
	    grid.add(j,o);
	}
}
