package tutorial;
import java.util.Scanner;
public class LabAssignment {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);

		String [][] gameBoard = {{"*","*","*"},{"*","*","*"},{"*","*","*"}};

		int turns = 0;
		displayBoard(gameBoard);

		System.out.println("Player 1: Enter your token (X or O)");
		String token1 = in.nextLine();
		String token2 = "";
		if(token1 == "X") {
		token2 = "O";
		System.out.println("Player 2: Your token is " + token2);
		}
		else {
		token2 = "X";
		System.out.println("Player 2: Your token is " + token2);
		}
		

		while(turns<9 && (checkWinner(gameBoard, token1, token2) == " ")) {
		Player1(gameBoard, token1);
		turns++;
		Player2(gameBoard, token2);
		turns++;
		}
		
		if (checkWinner(gameBoard, token1, token2).equals(token1)) {
			System.out.println("Conratulations Player 1!");
		}
		else if (checkWinner(gameBoard, token1, token2).equals(token2)) {
			System.out.println("Congratulations Player 2!");
		}
		else if(turns >= 9) {
			System.out.println("It's a TIE! Game over!");
		}

		in.close();
	}

	public static void displayBoard(String [][] gameBoard) {
		int rows = gameBoard.length;
		int columns = gameBoard[0].length;
		for (int i =0; i<rows; i++) {
			for (int j =0; j<columns; j++) {
				System.out.print("   " + gameBoard[i][j]);
			}
		System.out.println("");
		}
	}

	public static int validate(int numb, int min, int max) {
		Scanner in = new Scanner(System.in);

		while ((numb < min) || (numb > max)) {
			System.out.println("Invalid entry! Please enter another number:");
			numb = in.nextInt();
		}
		return numb;
	}

	public static void Player1(String [][] gameBoard, String token1) {

		Scanner in = new Scanner(System.in);

		System.out.println("Player 1: \nEnter the row number on the board where you would like to place your token:");
		int row = in.nextInt();
		row = validate(row, 0, 2);
		System.out.println("Enter the column number on the board where you would like to place your token:");
		int col = in.nextInt();
		col = validate(col, 0, 2);

		gameBoard[row][col] = token1;
		displayBoard(gameBoard);
	}

	public static void Player2(String [][] gameBoard, String token2) {

		Scanner in = new Scanner(System.in);

		System.out.println("Player 2: \nEnter the row number on the board where you would like to place your token:");
		int row = in.nextInt();
		row = validate(row, 0, 2);
		System.out.println("Enter the column number on the board where you would like to place your token:");
		int col = in.nextInt();
		col = validate(col, 0, 2);

		gameBoard[row][col] = token2;
		displayBoard(gameBoard);
	}

	public static String checkWinner(String [][] gameBoard, String token1, String token2) {

		for (int a = 0; a < 8; a++) {
		String line = null;

		switch (a) {
			case 0:
				line = gameBoard[0][0] + gameBoard[0][1] + gameBoard[0][2];
				break;
			case 1:
				line = gameBoard[1][0] + gameBoard[1][1] + gameBoard[1][2];
				break;
			case 2:
				line = gameBoard[2][0] + gameBoard[2][1] + gameBoard[2][2];
				break;
			case 3:
				line = gameBoard[0][0] + gameBoard[1][0] + gameBoard[2][0];
				break;
			case 4:
				line = gameBoard[0][1] + gameBoard[1][1] + gameBoard[2][1];
				break;
			case 5:
				line = gameBoard[0][2] + gameBoard[1][2] + gameBoard[2][2];
				break;
			case 6:
				line = gameBoard[0][0] + gameBoard[1][1] + gameBoard[2][2];
				break;
			case 7:
				line = gameBoard[0][2] + gameBoard[1][1] + gameBoard[2][0];
				break;
			}
			if (line.equals(token1 + token1 + token1)) {
				return token1;
			} 
			else if (line.equals(token2 + token2 + token2)) {
				return token2;
			}
		}
		return " ";
	}
		// public static void checkDiagonal(String [][] gameBoard, String token1) {
		// String start = gameBoard[0][0];
		// boolean winnerFound = true;
		// 
		// for(int i = 1; i<gameBoard.length-1; i++) {
		// if(gameBoard[i][i] != start || gameBoard[i][i] == "*")
		// winnerFound = false;
		// else {
		// start = gameBoard[i][i];
		// }
		// }
		// if (winnerFound == true) {
		// if (start == "X" && token1 == "X") {
		// System.out.println("Congratulations Player 1!");
		// }
		// else System.out.println("Congratulations Player 2!");
		// }
		// else System.out.println("Sorry! Better luck next time!");
		// }
}

