package tema05;

import java.util.*;

public class ComparaAlReves implements Comparator<Integer> {
	@Override
	public int compare(Integer o1, Integer o2) {
		// o1 con o2 --> neg si o1 anterior o2, 
		// + revés, 0 si son =
		return -o1.compareTo( o2 );
	}
}
