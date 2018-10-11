import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class Desc extends JLabel{
	public Desc(int v){
		this.setText(""+v);
	}
	public void change(int y){
		this.setText(""+y);
	}
}