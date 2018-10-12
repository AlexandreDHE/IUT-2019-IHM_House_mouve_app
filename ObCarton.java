import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ObCarton {
	private String nom;
	private int petit;
	private int moyen;
	private int barrel;
	private int penderie;
	private int tableau;
	public void setNom(String a){
		this.nom = a;
	}
	public void setPetit(int a){
		this.petit = a;
	}
	public void setMoyen(int a){
		this.moyen = a;
	}
	public void setBarrel(int a){
		this.barrel = a;
	}
	public void setPenderie(int a){
		this.penderie = a;
	}
	public void setTableau(int a){
		this.tableau = a;
	}
	public String getNom(){
		return this.nom;
	}
	public int getPetit(){
		return this.petit;
	}
	public int getMoyen(){
		return this.moyen;
	}
	public int getBarrel(){
		return this.barrel;
	}
	public int getPenderie(){
		return this.penderie;
	}
	public int getTableau(){
		return this.tableau;
	}
}