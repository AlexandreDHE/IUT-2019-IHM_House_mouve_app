import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BoutListen implements ActionListener {
	private Cartons a;
	public BoutListen(Cartons b){
		this.a=b;
	}
	@Override
	public void actionPerformed(ActionEvent e){
		this.a.showCarton(e.getActionCommand());
	}
}