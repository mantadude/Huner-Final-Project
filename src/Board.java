import java.util.ArrayList;


public class Board {

	int[] Stones = new int[13]; 
	

public void BlankBoard(int[] a) {
	for(int i=0; i<=a.length;i++) {
		a[i] = 4;
	}
	a[6] = 0;
	a[13] = 0;
}

public void BoardPrinter(int [] Rocks) {
	String line1 = "-----------------";
	String line2 = "| |" + Rocks[12] + "|" + Rocks[11] + "|" + Rocks[10] + "|" + Rocks[9] + "|" + Rocks[8] + "|" + Rocks[7] + "| |";
	String line3 = "|" + Rocks[13] + "-------------" + Rocks[6] + "|";
	String line4 = "| |" + Rocks[0] + "|" + Rocks[1] + "|" + Rocks[2] + "|" + Rocks[3] + "|" + Rocks[4] + "|" + Rocks[5] + "| |";
	String line5 = "-----------------";
	String line6 = "   " + 0 + " " + 1 + " " + 2 + " " + 3 + " " + 4 + " " + 5 + "   ";
	
	String CompleteBoard = line1 + "\n" + line2 + "\n" + line3 + "\n" + line4 + "\n" + line5 + "\n" + line6; 
	System.out.print(CompleteBoard);
}
}


	
	




