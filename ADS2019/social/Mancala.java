import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

/**
 * Mancala
 */
public class Mancala {

    Board board;

    public Mancala() {
        int[] boardArray = new int[14];
        for(int i=0; i<boardArray.length; i++) {
            boardArray[i] = 4;
        }
        boardArray[6] = 0;
        boardArray[13] = 0;

        board = new Board(boardArray);
    }

    /*char checkBoard(Board board) {
        // 1. Base case
        if(board.isDone()) {
            return board.getWinner();
        }
        // 2. Recursive step
        char currentPlayer = board.xTurn ? 'X' : 'O';
        boolean tie = false;
        ArrayList<Board> children = board.getChildren();
        for(int i=0; i<children.size(); i++) {
            char result = checkBoard(children.get(i));
            if(result == currentPlayer) {
                return currentPlayer;
            } else if(result == ' ') {
                tie = true;
            }
        }
        if(tie) {
            return ' ';
        } else {
            return board.xTurn ? 'O' : 'X';
        }
    }*/

    public int[] computerMove() {
        char currentPlayer = board.xTurn ? 'X' : 'O';

        Random rand = new Random();
        int[] randomOptions = new int[] {7, 8, 9, 10, 11, 12};
        int randomMove = randomOptions[rand.nextInt(6)];
        if(randomMove == 7) {
            board = board.move(7);
        } else if(randomMove == 8) {
            board = board.move(8);
        } else if(randomMove == 9) {
            board = board.move(9);
        } else if(randomMove == 10) {
            board = board.move(10);
        } else if(randomMove == 11) {
            board = board.move(11);
        } else {
            board = board.move(12);
        }


    }

   int[] userMove(Scanner scanner) {
        System.out.print("Make a move: ");
        int move = scanner.nextInt();
        if(move == 0) {
            board = board.move(0);
        } else if(move == 1) {
            board = board.move(1);
        } else if(move == 2) {
            board = board.move(2);
        } else if(move == 3) {
            board = board.move(3);
        } else if(move == 4) {
            board = board.move(4);
        } else {
            board = board.move(5);
        }



    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        // Stop when done
        // 1. Filled (no more moves)
        // 2. Someone wins
        while(!board.isDone()) {
            // See board
            System.out.println(board.toString());
            // Make a move
            int[] move;
            if(!board.xturn) {
                move = userMove(scanner);
            } else {
                move = computerMove;
            }
            board = board.move(move[0], move[1]);

            System.out.println();

        }
        //char winner = board.getWinner();
        System.out.println(board.toString());
        /*if(winner == ' ') {
            System.out.println("It's a tie.  Boo.");
        } else {
            System.out.println(winner + " won!");
        }
        scanner.close();*/
    }

    private class Board {

        int[] board;
        boolean xTurn;
        //int[] lastMove;

        public Board(int[] board, boolean xTurn) {
            this.board = board;
            this.xTurn = xTurn;
        }

        public String toString() {
            String rv = "";
            rv += "-----------------\n";
            rv += "| |" + board[12] + "|" + board[11] + "|" + board[10] + "|" + board[9] + "|" + board[8] + "|" + board[7] + "| |\n";
            rv += "|" + board[13] + "-------------" + board[6] + "|\n";
            rv += "| |" + board[0] + "|" + board[1] + "|" + board[2] + "|" + board[3] + "|" + board[4] + "|" + board[5] + "| |\n";
            rv += "-----------------\n";
            rv += "   " + 0 + " " + 1 + " " + 2 + " " + 3 + " " + 4 + " " + 5 + " " + "    ";
            return rv;
        }

        /*public boolean equals(Board other) {
            return board == other.board && xTurn == other.xTurn;
        }*/




       /*public Board move(int x, int y) {
            // add piece
            if(this.board[x][y] == ' ') {
                char[][] board = new char[3][3];
                for(int i=0; i<board.length; i++) {
                    board[i] = this.board[i].clone();
                }
                board[x][y] = xTurn ? 'X' : 'O';
                // change player
                Board rv = new Board(board, !xTurn);
                // add lastMove for computerMove()
                rv.lastMove = new int[]{x, y};
                return rv;
            }
            return this;
        }*/

        public Board move(int a) {
            // move stones
            for (int i=board[a]; i!=0; i--){
                board[a + i] = board[a + i] + 1;
            }
            return this;
        }

        boolean isDone() {
            if(board[0] + board[1] + board[2] + board[3] + board[4] + board[5] == 0 || board[7] + board[8] + board[9] + board[10] + board[11] + board[12] == 0) {
            return true;
            } else {
                return false;
            }
        }

       /*boolean isWinner(char player) {
            if(board[0][0] == player && board[0][1] == player && board[0][2] == player) {
                return true; // Top row
            } else if(board[1][0] == player && board[1][1] == player && board[1][2] == player) {
                return true; // Middle row
            } else if(board[2][0] == player && board[2][1] == player && board[2][2] == player) {
                return true; // Bottom row
            } else if(board[0][0] == player && board[1][0] == player && board[2][0] == player) {
                return true; // Left column
            } else if(board[0][1] == player && board[1][1] == player && board[2][1] == player) {
                return true; // Middle column
            } else if(board[0][2] == player && board[1][2] == player && board[2][2] == player) {
                return true; // Right column
            } else if(board[0][2] == player && board[1][1] == player && board[2][0] == player) {
                return true; // Slash
            } else if(board[0][0] == player && board[1][1] == player && board[2][2] == player) {
                return true; // Backslash
            }
            return false;
        }*/

        /*char getWinner() {
            if(isWinner('X')) {
                return 'X';
            } else if(isWinner('O')) {
                return 'O';
            } else {
                return ' ';
            }
        }*/

    }

}