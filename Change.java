import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class Change implements ChangeListener{
	private NewPanMeuble m;
	public Change(NewPanMeuble v){
		this.m = v;
	}
	public void stateChanged(ChangeEvent e){
		this.m.change();
	}
}