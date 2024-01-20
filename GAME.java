import java.util.Random;
import java.util.Scanner;

public class GAME {
    public static void main(String[] args) {
        
        char[][] gameBoard = {{' ', '|', ' ', '|', ' '},          //creating a 2d gameboard
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        for(int i = 0 ; i < 4;i++)  {                           // You will have your turns 4 times  maximum . if you dont win under 4 turns , it's a tie
            if(gameEndedByComputer(gameBoard))  {                //check if the computer has won
                System.out.println("BETTER LUCK NEXT TIME!!!");
                break;
            }
            
            System.out.println("Enter the pos: ");                //Ask the user to play his turn and update the gameBoard
            int pos = sc.nextInt();
            placePiece(gameBoard,pos,"Player");
            printBoard(gameBoard);
            
            System.out.println(" ");
            
            if(gameEndedByUser(gameBoard))  {                    //check if the game is won by user
                System.out.println("CONGRATULATIONS YOU WON!!!");
                break;
            }

            while(true)  {                                       //if cpu chose a right place then validate the turn and update the gameBoard
                int cpuPos = rand.nextInt(9) + 1;
                if(placePiece(gameBoard,cpuPos,"computer"))  {
                    break;
                }
            }

            printBoard(gameBoard);
        }
        if(!gameEndedByComputer(gameBoard) && !gameEndedByUser(gameBoard))  {      //if nobody wins, its a tie!
            System.out.println("IT'S A TIE!!!");
        }



    }

    public static void printBoard(char[][] gameBoard) {                          //this method shows the gameBoard
        for (char[] row : gameBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static boolean placePiece(char[][] gameBoard, int pos, String user)  {    //this method place the piece on the board on correct places
        char Symbol = ' ';
        if(user.equals("Player"))  {
            Symbol = 'X';
        }  else if(user.equals("computer"))  {
            Symbol = 'O';
        }

        switch(pos)  {
            case 1:
                if(gameBoard[0][0] != ' ')  {
                    return false;
                }
                gameBoard[0][0] = Symbol;
                break;
            case 2:
                if(gameBoard[0][2] != ' ')  {
                    return false;
                }
                gameBoard[0][2] = Symbol;
                break;
            case 3:
                if(gameBoard[0][4] != ' ')  {
                    return false;
                }
                gameBoard[0][4] = Symbol;
                break;
            case 4:
                if(gameBoard[2][0] != ' ')  {
                    return false;
                }
                gameBoard[2][0] = Symbol;
                break;
            case 5:
                if(gameBoard[2][2] != ' ')  {
                    return false;
                }
                gameBoard[2][2] = Symbol;
                break;
            case 6:
                if(gameBoard[2][4] != ' ')  {
                    return false;
                }
                gameBoard[2][4] = Symbol;
                break;
            case 7:
                if(gameBoard[4][0] != ' ')  {
                    return false;
                }
                gameBoard[4][0] = Symbol;
                break;
            case 8:
                if(gameBoard[4][2] != ' ')  {
                    return false;
                }
                gameBoard[4][2] = Symbol;
                break;
            case 9:
                if(gameBoard[4][4] != ' ')  {
                    return false;
                }
                gameBoard[4][4] = Symbol;
                break;
            default:
                break;
        }
        return true;
    }

    public static boolean gameEndedByUser(char[][] gameBoard) {                //checks if the game is won by user by tictactoe rules
        if ((gameBoard[0][0] == 'X' && gameBoard[0][2] == 'X' && gameBoard[0][4] == 'X')
                || (gameBoard[2][0] == 'X' && gameBoard[2][2] == 'X' && gameBoard[2][4] == 'X')
                || (gameBoard[4][0] == 'X' && gameBoard[4][2] == 'X' && gameBoard[4][4] == 'X')
                || (gameBoard[0][0] == 'X' && gameBoard[2][2] == 'X' && gameBoard[4][4] == 'X')
                || (gameBoard[0][4] == 'X' && gameBoard[2][2] == 'X' && gameBoard[4][0] == 'X')
                || (gameBoard[0][0] == 'X' && gameBoard[2][0] == 'X' && gameBoard[4][0] == 'X')
                || (gameBoard[0][2] == 'X' && gameBoard[2][2] == 'X' && gameBoard[4][2] == 'X')
                || (gameBoard[0][4] == 'X' && gameBoard[2][4] == 'X' && gameBoard[4][4] == 'X')) {
            return true;
        }
        return false;
    }


    public static boolean gameEndedByComputer ( char[][] gameBoard){         //checks if the game is won by computer by tictactoe rules
            if ((gameBoard[0][0] == 'O' && gameBoard[0][2] == 'O' && gameBoard[0][4] == 'O')
                    || (gameBoard[2][0] == 'O' && gameBoard[2][2] == 'O' && gameBoard[2][4] == 'O')
                    || (gameBoard[4][0] == 'O' && gameBoard[4][2] == 'O' && gameBoard[4][4] == 'O')
                    || (gameBoard[0][0] == 'O' && gameBoard[2][2] == 'O' && gameBoard[4][4] == 'O')
                    || (gameBoard[0][4] == 'O' && gameBoard[2][2] == 'O' && gameBoard[4][0] == 'O')
                    || (gameBoard[0][0] == 'O' && gameBoard[2][0] == 'O' && gameBoard[4][0] == 'O')
                    || (gameBoard[0][2] == 'O' && gameBoard[2][2] == 'O' && gameBoard[4][2] == 'O')
                    || (gameBoard[0][4] == 'O' && gameBoard[2][4] == 'O' && gameBoard[4][4] == 'O')) {
                return true;
            }
            return false;

        }
}

