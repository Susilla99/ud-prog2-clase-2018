package tema05;

import java.util.*;

import javax.swing.JFrame;

public class DudaArrayList {

	public static void main(String[] args) {
		Vector v = new Vector();
		v.add( new String() );
		v.add( new JFrame() );
		for (Object o : v) {
			if (o instanceof JFrame) {
				// incorrecto o.setVisible( true );
				JFrame f = (JFrame)o;
				f.setVisible( true );
			} else if (o instanceof String) {
				
			}
		}
		Vector<JFrame> v2 = new Vector<JFrame>();
		// v2.add( "a");  // Error
	}

}
