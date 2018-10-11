import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class JCheck implements ItemListener{
	private NewPanMeuble a;
	private boolean b=true;
	public JCheck(NewPanMeuble b){
		this.a=b;
	}
	@Override
	public void itemStateChanged(ItemEvent e){
		if(!b){
			this.a.demont();
			this.b=true;
		}else{
			this.a.unmount();
			this.b=false;
		}
	}
}