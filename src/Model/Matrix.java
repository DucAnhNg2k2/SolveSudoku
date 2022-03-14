package Model;

import java.util.Scanner;

/**
 *
 * @author Acer
 */
public class Matrix {
    /* demo 
0 0 0 0 1 8 0 6 0 
0 0 0 3 0 0 0 5 0 
0 6 0 0 0 0 0 4 0
0 0 0 0 5 0 0 0 8
6 0 0 0 0 3 0 0 0
0 7 9 0 4 0 2 0 0
0 4 0 0 0 0 3 0 0
5 0 0 0 0 2 0 1 6
0 2 3 6 0 0 0 0 0
    */
    private Scanner sc = new Scanner(System.in);
    public int matrix[][] = new int[10][10];
    public Matrix() {
    }
    public void Nhap() {
        for(int i = 1; i <= 9 ;i++ ) {
            for(int j = 1; j <= 9; j++ ) {
                matrix[i][j] = sc.nextInt();
            }
        }
    }
    public void In() {
        if( matrix == null ) {
            System.out.println("\nNo Answer!");
            return;
        }
        System.out.println("\nAnswer Sudoku 9x9:\n");
        for(int i = 1; i <= 9 ;i++ ) {
            for(int j = 1; j <= 9; j++ ) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public int[][] getMatrix() {
        return matrix;
    }
}
