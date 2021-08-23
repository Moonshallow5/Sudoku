import java.util.ArrayList;

import java.util.Scanner;



/**
 * Sudoku
 */

public class Sudoku {
    static char player='X';
    static int[][] board=new int[4][4];

    public static void initial() {
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board.length; column++) {
                board[row][column]=0;
            }
             
         }
         
     }
     public static boolean isMoveValid(int row, int column, int number ) {
        if(!concede(row, column, number)){
            if(number>4 || number<0 ){
                return false;
            }
            if(row>3 || row<0){
                return false;
            }if(column>3 || column<0){
                return false;
            }
            if(board[row][column]!=0){
                System.out.println("why");
                return false;
            }
        }
         return true;
         
     }
     static Scanner scanncer=new Scanner(System.in);
    public static void pick(){
        
        System.out.print("Enter a row number: ");
        int x=scanncer.nextInt();
        if(concede(x, 0,0)){
            System.out.println("Good game");
            
      }
        else{
            System.out.print("Enter a column number: ");
            int y=scanncer.nextInt();
            if(concede(0, y,0)){
                System.out.println("Good game");
          } else{
                System.out.println("Enter a number from 1-4");
                int z=scanncer.nextInt();
                
                if(!isMoveValid(x,y,z)){
                    System.err.println("Please enter correct values");
                    System.out.print("Enter a row number: ");
                    x=scanncer.nextInt();
                    if(concede(x, 0,0)){
                        
                        
                }
                    else{
                        System.out.print("Enter a column number: ");
                        y=scanncer.nextInt();
                        if(concede(0, y, 0)){

                        }
                    else{

                        System.out.println("Enter a number from 1-4");
                        z=scanncer.nextInt();
                    }
                    }
                    isMoveValid(x,y,z);
                }
                if(concede(x, y, z)){
                    System.out.println("Good game");
                    

                }
                else{
                    board[x][y]=z;
                }
            }
        }

    }
    public static boolean concede(int x, int y, int number) {
        if(x==-1 || y==-1 ||number==-1){
            vertical=true;
            horizontal=true;
            box=true;
            return true;

        }return false;
        
    }


    public static void main(String[] args) {
        System.out.println("Enter -1 to concede");
        initial();
        display();
        start();
        while (!vertical && !box && !horizontal) {
            pick();

            isWinnerBox();
            isWinnerVertical();
            isWnnnerHorizontal();
            
            displayBoard();
        }
        if(vertical && horizontal && box){
            System.out.println("Well done you won");
        }
    }
    static boolean vertical=false;
    public static boolean isWinnerVertical() {
        ArrayList<Integer> ss=new ArrayList<>();
        ArrayList<Integer> ss2=new ArrayList<>();
        ArrayList<Integer> ss3=new ArrayList<>();
        ArrayList<Integer> ss4=new ArrayList<>();
        for (int i = 0; i < board.length; i++) {

            if( board[i][0]!=0 && !ss.contains(board[i][0])){
                ss.add(board[i][0]);
                
            }
            else{
                
                vertical=false;
                return false;
            }
            if( board[i][1]!=0 && !ss2.contains(board[i][1])){
                ss2.add(board[i][1]);
               
            }
            else{
                return false;
            }
            if( board[i][2]!=0 && !ss3.contains(board[i][2])){
                
                ss3.add(board[i][2]);
            }
            else{
                return false;
            }
            if( board[i][3]!=0 && !ss4.contains(board[i][3])){
                ss4.add(board[i][3]);
                
            }
            else{
                return false;
            }
        }
        vertical=true;
        return true;
    
    }
    static int x;
    public static void start() {
        Scanner scanner =new Scanner(System.in);
        System.out.println("Enter 1 to pick first board and 2 for the other one");
        x=scanner.nextInt();
        
        first();
        
        
    }
    static boolean horizontal=false;
    public static boolean isWnnnerHorizontal() {
        ArrayList<Integer> ss=new ArrayList<>();
        ArrayList<Integer> ss2=new ArrayList<>();
        ArrayList<Integer> ss3=new ArrayList<>();
        ArrayList<Integer> ss4=new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            if(board[0][i]!=0 && !ss.contains(board[0][i])){
                ss.add(board[0][i]);
            }
            else{
                horizontal=false;
                
                return false;
            }
            if( board[1][i]!=0 && !ss2.contains(board[1][i])){
                ss2.add(board[1][i]);
               
            }
            else{
                horizontal=false;
                return false;
            }
            if( board[2][i]!=0 && !ss3.contains(board[2][i])){
                
                ss3.add(board[2][i]);
            }
            else{
                horizontal=false;
                return false;
            }
            if( board[3][i]!=0 && !ss4.contains(board[3][i])){
                ss4.add(board[3][i]);
                
            }
            else{
                horizontal=false;
                return false;
            }
            
            
        }horizontal=true;
        return true;
        
    }
    static boolean box=false;
    public static void first() {
        if(x==1){
            initial();
            some();
        }else{
            initial();
            some2();
        }
        displayBoard();

     }
     public static void display() {
         initial();
         some();
         displayBoard();
         System.out.println();
         initial();
         some2();
         displayBoard();
         
     }

    public static boolean isWinnerBox() {
        ArrayList<Integer> ss=new ArrayList<>();
        ArrayList<Integer> ss2=new ArrayList<>();
        ArrayList<Integer> ss3=new ArrayList<>();
        ArrayList<Integer> ss4=new ArrayList<>();
        ss.add(board[0][0]);
        ss.add(board[0][1]);
        ss.add(board[1][0]);
        ss.add(board[1][1]);
        ss2.add(board[0][2]);
        ss2.add(board[0][3]);
        ss2.add(board[1][2]);
        ss2.add(board[1][3]);
        ss3.add(board[2][0]);
        ss3.add(board[2][1]);
        ss3.add(board[3][0]);
        ss3.add(board[3][1]);
        ss4.add(board[2][2]);
        ss4.add(board[2][3]);
        ss4.add(board[3][2]);
        ss4.add(board[3][3]);
        if(ss.contains(0) || ss2.contains(0)|| ss3.contains(0) || ss4.contains(0)){
           

        }
        else if(ss.contains(1) && ss.contains(2) && ss.contains(3) && ss.contains(4) && ss2.contains(1) && ss2.contains(2) && ss2.contains(3) && ss2.contains(4) && ss3.contains(1) && ss3.contains(2) && ss3.contains(3) && ss3.contains(4) && ss4.contains(1) && ss4.contains(2) && ss4.contains(3) && ss4.contains(4) ){
            box=true;
            return true;

        }box=false;
        return false;

            
    }

    public static void some() {
        board[0][0]=3;
        board[1][1]=1;
        board[2][1]=4;
        board[3][0]=2;
        board[0][2]=2;
        board[2][3]=3;
        board[1][3]=2;
        board[0][2]=4;
        board[3][2]=1;
        
    }
    public static void some2() {
        board[0][0]=4;
        board[1][1]=1;
        board[0][3]=1;
        board[1][2]=3;
        board[2][1]=4;
        board[2][2]=1;
        board[3][0]=1;
        board[3][3]=3;

        
    }
    public static void displayBoard() {
    
        
        
        for (int row = 0; row < board.length; row++) {
            System.out.print("| ");
            
            for (int column = 0; column < board[0].length; column++) {
                
                System.out.print(board[row][column]);
                if(column==0 || column==2){
                    System.out.print(" ");
                }else{
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if(row==1){
                System.out.println("-------------");
            }
        
        }
        
        System.out.println();

    }
}