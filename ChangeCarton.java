import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class ChangeCarton implements ChangeListener{
	private NewNewCarton m;
	public ChangeCarton(NewNewCarton v){
		this.m = v;
	}
	public void stateChanged(ChangeEvent e){
		this.m.change();
	}
}