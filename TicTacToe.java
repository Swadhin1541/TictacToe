import java.util.*;

public class TicTacToe {



public static void displayGame(String[][] gameBoard)

    {



     for(int row=0;row<3;row++)

       {



       for(int column=0;column<3;column++)



     {



      System.out.print(gameBoard[row][column]+"  ");



      }



    System.out.println("");



    }

    }



    public static int[] getCoordinates(int playerChoice,String[][] gameBoard){

     playerChoice=playerChoice-1;



     int[] coordinates=new int[2];



    coordinates[0]=(playerChoice/3);



    coordinates[1]=(playerChoice%3);



    boolean result=check(coordinates[0],coordinates[1],gameBoard);

         if(result==true){



    return coordinates;



    }

    else{

     int [] invalidcoordinates=new int [2];

     invalidcoordinates[0]=3;

     invalidcoordinates[1]=3;

     return invalidcoordinates;

    }



    }



    public static boolean setPlayer(int turnCount)

    {



    if(turnCount%2==1)

       {



       return true;



    }



    else

       {



     return false;



     }

    }

    public static boolean check(int coordinates1,int coordinates2,String[][]gameBoard){

     int flags=1;

           if((gameBoard[coordinates1][coordinates2]=="x")||(gameBoard[coordinates1][coordinates2]=="o")){

                   flags=0;



           }





       if(flags==0)

       return false;

       else

       return true;

    }

    public static String checkWinner(String [][] gameboard,String p,String q,String b,String c) {

         String result="";



           for (int line = 0; line < 8; line++) {

               String wincheck = null;

                switch (line) 
                {
                    case 0:

                    wincheck = gameboard[0][0] + gameboard[0][1] + gameboard[0][2];

                    break;

                    case 1:

                    wincheck = gameboard[1][0] + gameboard[1][1] + gameboard[1][2];

                    break;

                    case 2:

                    wincheck = gameboard[2][0] + gameboard[2][1] + gameboard[2][2];

                    break;

                    case 3:

                    wincheck = gameboard[0][0] + gameboard[1][1] + gameboard[2][2];

                    break;

                    case 4:

                    wincheck = gameboard[0][1] + gameboard[1][1] + gameboard[2][1];

                    break;

                    case 5:

                    wincheck = gameboard[0][2] + gameboard[1][2] + gameboard[2][2];

                    break;

                    case 6:

                    wincheck = gameboard[0][0] + gameboard[1][1] + gameboard[2][2];

                    break;

                    case 7:

                    wincheck = gameboard[0][2] + gameboard[1][1] + gameboard[2][0];

                    break;

               }

               if ((wincheck.equals("xxx"))) {

                   displayGame(gameboard);
                   if(b=="x")
                   {
                        result=p+" Wins the Game!";
                   }
                   else
                   {
                        result=q+" Wins the Game!";
                   }
                   //System.exit(0);

               }

               else if((wincheck.equals("ooo"))) {

                   displayGame(gameboard);
                   if(b=="o")
                   {
                        result=p+" Wins the Game!";
                   }
                   else
                   {
                        result=q+" Wins the Game!";
                   }
                   //System.exit(0);



               }

           }

        return result;
}





    public static void main(String args[]) {



    Scanner s=new Scanner(System.in);
    System.out.println("RULES-\n1.2 Player Game.\n2.Any 1 Row,Column,Diagonal with same 'x' or 'o' wins the game\n3.Enter your mark('x' or 'o') in empty place\n4.When asked enter 'y' to start a newgame.\n5.When asked enter 'n' to exit.\n");
    boolean z=true;
    while(z==true)
    {
    String b="",c="";
    System.out.println("Enter Player-1 name");
    String p=s.next();
    System.out.println("Enter Player-2 name");
    String q=s.next();
    if (Math.random() < 0.5)
    {
        System.out.println(p+" will choose the character ('x' or 'o')");
        b=s.next();
        if(b.equals("x"))
        {
            c="o";
        }
        else 
        {
            c="x";
        }

    }
    else
    {
        System.out.println(q +"will choose the character ('x' or 'o')");
        c=s.next();
        if(c.equals("x"))
        {
            b="o";
        }
        else 
        {
            b="x";
        }
    }

    String[][] gameBoard={{"1","2","3"},{"4","5","6"},{"7","8","9"}};

int turnCount;

     for(turnCount=1;turnCount<10;turnCount++)

       {



      boolean flag=setPlayer(turnCount);



      displayGame(gameBoard);



      System.out.println(((flag)?p:q)+"'s turn");



         int playerChoice=s.nextInt();

         if(playerChoice>=1&&playerChoice<=9){



     int[] coordinates=getCoordinates(playerChoice,gameBoard);

        if(coordinates[0]<3&&coordinates[1]<3)

       {

       gameBoard[coordinates[0]][coordinates[1]]=((flag)?b:c);

       }

       else{

         System.out.println("the place is already occupied");

         turnCount=turnCount-1;

       }



         }

         else if(playerChoice>=10||playerChoice<1){

           System.out.println("Invalid input");

           turnCount=turnCount-1;

         }

         String out="";

         out = checkWinner(gameBoard,p,q,b,c);
         System.out.println(out);
        

         if(out!="") {
            System.out.println("Want to play one more game(click 'y')");
            System.out.println("Want to Quit (click 'n')");
            String m=s.next();
            if(m.equals("y"))
            {
                z=true;
                break;
            }
            else
            {
               z=false;
               System.exit(0);
            }

             

         }

    }

     //checkWinner(gameBoard)

     if(turnCount==10) {

         System.out.print("Match draw\n");

     }

    displayGame(gameBoard);
    /* System.out.println("Want to play one more game(y/n)");
     String m=s.next();
     if(m.equals("y"))
     {
         z=true;
     }
     else
     {
        z=false;
     }*/
    }

    }
    }