import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class Labb extends JLabel{
	public Labb(String b){
		super(b);
		this.setHorizontalAlignment(JLabel.CENTER);
	}
	public void changeText(String b){
		this.setText(b);
	}
}