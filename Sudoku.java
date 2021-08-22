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
     static Scanner scanncer=new Scanner(System.in);
    public static void pick(){
         
        System.out.print(player+" Enter a row number: ");
        int x=scanncer.nextInt();
        System.out.print(player+" Enter a column number: ");
        int y=scanncer.nextInt();
        System.out.println("Enter a number from 1-4");
        int z=scanncer.nextInt();
        board[x][y]=z;

    }
    public static void switchPlayers(){
        if(player=='X'){
            player='Y';
        }else{
            player='X';
        }
    }


    public static void main(String[] args) {
        initial();
        displayBoard();
        int count=0;
        while(count<16){
            pick();
            System.out.println( isWinnerVertical());
            System.out.println(isWnnnerHorizontal());
            System.out.println(isWinnerBox());
            
            displayBoard();
            count++;
        }
    
        

    }
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
        return true;
    
    }
    public static boolean isWnnnerHorizontal() {
        ArrayList<Integer> ss=new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            if(board[0][i]!=0 && !ss.contains(board[0][i])){
                ss.add(board[0][i]);
                

            }
            else{
                
                return false;
            }
            
        }return true;
        
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
            System.out.println(ss);
            System.out.println(ss2);
            System.out.println(ss3);
            System.out.println(ss4);
            return true;

        }return false;

            
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
        
        }System.out.println();
    }
}