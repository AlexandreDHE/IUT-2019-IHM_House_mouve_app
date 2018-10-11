import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Meuble {
	private String nom;
	private int longueur;
	private int largeur;
	private int hauteur;
	private int element;
	private int longg;
	private int largg;
	private int hautt;
	private ImageIcon image;
	private boolean demont;
	public void setNom(String a){
		this.nom = a;
	}
	public void setImg(String a){
		this.image = new ImageIcon(a);
	}
	public void setLong(int a){
		this.longueur = a;
	}
	public void setLongg(int a){
		this.longg = a;
	}
	public void setHautt(int a){
		this.hautt = a;
	}
	public void setLargg(int a){
		this.largg = a;
	}
	public void setDemont(boolean a){
		this.demont = a;
	}
	public void setLarg(int a){
		this.largeur = a;
	}
	public void setHaut(int a){
		this.hauteur = a;
	}
	public void setElt(int a){
		this.element = a;
	}
	public String getNom(){
		return this.nom;
	}
	public ImageIcon getImg(){
		return this.image;
	}
	public boolean getDemont(){
		return this.demont;
	}
	public int getLong(){
		return this.longueur;
	}
	public int getLarg(){
		return this.largeur;
	}
	public int getHaut(){
		return this.hauteur;
	}
	public int getHautt(){
		return this.hautt;
	}
	public int getElt(){
		return this.element;
	}
	public int getLongg(){
		return this.longg;
	}
	public int getLargg(){
		return this.largg;
	}
}