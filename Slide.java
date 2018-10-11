import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class Slide extends JSlider{
	public Slide(int b, int c, int d){
		this.setOrientation(JSlider.HORIZONTAL);
		this.setMinimum(b);
		this.setMaximum(c);
		this.setValue(d);
	}
}