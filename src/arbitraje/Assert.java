package arbitraje;

import static org.junit.Assert.*;

public class Assert {
	
	//comprueba que los dos arrays sean identicos.
	public static boolean equals (int[] array , int[]otroArray) {
		assertTrue(array.length == otroArray.length);
		
		for (int i = 0; i < otroArray.length; i++) {
			if (array[i] != otroArray[i])
				return false;
		}
		return true;
	}
}
