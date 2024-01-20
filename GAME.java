import java.util.Random;
import java.util.Scanner;

public class GAME {
    public static void main(String[] args) {

        char[][] gameBoard = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        for(int i = 0 ; i < 4;i++)  {
            if(gameEndedByComputer(gameBoard))  {
                System.out.println("BETTER LUCK NEXT TIME!!!");
                break;
            }
            System.out.println("Enter the pos: ");
            int pos = sc.nextInt();
            placePiece(gameBoard,pos,"Player");
            printBoard(gameBoard);
            System.out.println(" ");
            if(gameEndedByUser(gameBoard))  {
                System.out.println("CONGRATULATIONS YOU WON!!!");
                break;
            }


            while(true)  {
                int cpuPos = rand.nextInt(9) + 1;
                if(placePiece(gameBoard,cpuPos,"computer"))  {
                    break;
                }
            }

            printBoard(gameBoard);
        }
        if(!gameEndedByComputer(gameBoard) && !gameEndedByUser(gameBoard))  {
            System.out.println("IT'S A TIE!!!");
        }



    }

    public static void printBoard(char[][] gameBoard) {
        for (char[] row : gameBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static boolean placePiece(char[][] gameBoard, int pos, String user)  {
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

    public static boolean gameEndedByUser(char[][] gameBoard) {
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


    public static boolean gameEndedByComputer ( char[][] gameBoard){
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

