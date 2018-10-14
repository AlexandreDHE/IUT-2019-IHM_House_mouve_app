import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Action implements ActionListener {
	private Inventaire a;
	private NewPanMeuble meub;
	private JTextField y;
	private NewNewCarton ty;
	private Fenetre uu;
	private String hh;
	private Meuble ziak;
	public Action(Inventaire b){
		this.a=b;
	}
	public Action(Fenetre b){
		this.uu=b;
	}
	public Action(Fenetre b,String bn){
		this.uu=b;
		this.hh = bn;
	}
	public Action(Fenetre b,Meuble bn){
		this.uu=b;
		this.ziak = bn;
	}
	public Action(NewPanMeuble v){
		this.meub = v;
	}
	public Action(NewNewCarton v){
		this.ty = v;
	}
	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand().equals("+")){
			this.a.plus();
		}else if(e.getActionCommand().equals("-")){
			this.a.moins();
		}
		else if(e.getActionCommand().equals("Ajouter")){
			this.uu.newCarton();
		}
		else if(e.getActionCommand().equals("Supprimer")){
			Model j = new Model();
			j.deleteMeuble(this.ziak.getNom());
			this.uu.nInventaire();
		}
		else if(e.getActionCommand().equals("Ajouter le meuble")){
			this.meub.ecrit();
		}
		else if(e.getActionCommand().equals("Ajouter un Carton")){
			this.uu.ncarton();
		}
		else if(e.getActionCommand().equals("Supprimer ce Carton")){
			Model j = new Model();
			j.deleteCarton(this.hh);
			this.uu.nCarton(j.getRooms());
		}
		else if(e.getActionCommand().equals("Rajouter la piece")){
			this.ty.ecrit();
		}
	}
}