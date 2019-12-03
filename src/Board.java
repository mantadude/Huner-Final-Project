import java.io.*;


public class Board {

	int[] Stones = new int[13]; 
	

public void BlankBoard(int[] a) {
	for(int i=0; i<=a.length;i++) {
		a[i] = 4;
	}
	a[6] = 0;
	a[13] = 0;
}
}
	
	




