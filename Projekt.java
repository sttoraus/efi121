import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int[][] spielfeld = intBoard(2);
		printBoard(spielfeld);
		Scanner scan = new Scanner(System.in);
		while (!ende(spielfeld)) {
			int eingabe = scan.nextInt();
			if (erlaubt(eingabe, spielfeld)) {
				spielfeld = swapFields(eingabe, spielfeld);
			} else
				System.out.println("ungültiger Zug");
			printBoard(spielfeld);
		}
		System.out.println("Ende");
	}

	private static boolean ende(int[][] feld) {

		int counter = 1;
		int counter2=1;
		for (int y = 0; y < feld.length; y++) {
			for (int x = 0; x < feld.length; x++) {
				if (feld[y][x] == counter2) {
					counter++;
				}
				counter2++;
			}
		}

		return counter == feld.length * feld.length;
	}

	private static boolean erlaubt(int i, int[][] feld) {
		int[] neu = getFieldIndex(i, feld);
		int[] alt = getFieldIndex(0,feld);
		
		return Math.abs(neu[0]-alt[0])+Math.abs(neu[1]-alt[1])==1;
	}

	private static int[][] swapFields(int i, int[][] feld) {
		int[] neu = getFieldIndex(i, feld);
		int[] alt = getFieldIndex(0,feld);
		int tmp = feld[neu[0]][neu[1]];
		feld[neu[0]][neu[1]] = feld[alt[0]][alt[1]];
		feld[alt[0]][alt[1]] = tmp;
		return feld;

	}

	private static int[] getFieldIndex(int i, int[][] feld) {
		int[] index = new int[2];
		for (int y = 0; y < feld.length; y++) {
			for (int x = 0; x < feld.length; x++) {
				if (feld[y][x] == i) {
					index[0] = y;
					index[1] = x;
					return index;
				}
			}
		}
		return index;
	}


	private static void printBoard(int[][] feld) {
		for (int y = 0; y < feld.length; y++) {
			for (int x = 0; x < feld.length; x++) {
				if (feld[y][x] == 0)
					System.out.print("     ");
				else
					System.out.printf("%5d", feld[y][x]);
			}
			System.out.println();

		}

	}

	private static int[][] intBoard(int anz) {
		// TODO Auto-generated method stub
		int[][] feld = new int[anz][anz];
		ArrayList<Integer> randomList = new ArrayList<Integer>();
		for (int i = 0; i < (anz * anz); i++)
			randomList.add(i);
		Collections.shuffle(randomList);
		int counter = 0;
		for (int y = 0; y < anz; y++) {
			for (int x = 0; x < anz; x++) {
				feld[x][y] = randomList.get(counter);
				counter++;
			}
		}
		return feld;
	}

}
