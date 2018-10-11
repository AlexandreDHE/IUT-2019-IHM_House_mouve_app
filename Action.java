import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Action implements ActionListener {
	private Inventaire a;
	private NewPanMeuble meub;
	private JTextField y;
	public Action(Inventaire b){
		this.a=b;
	}
	public Action(NewPanMeuble v,JTextField b){
		this.meub = v;
		this.y=b;
	}
	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand().equals("+")){
			this.a.plus();
		}else if(e.getActionCommand().equals("-")){
			this.a.moins();
		}
		else if(e.getActionCommand().equals("Ajouter")){
			this.a.ajout();
		}
		else if(e.getActionCommand().equals("Ajouter le meuble")){
			this.meub.ecrit(this.y.getText());
		}
	}
}