package Model;
import Controller.ManagerMatrix;
import java.util.Scanner;

public class Matrix {
    private Scanner sc = new Scanner(System.in);
    private int matrix[][] = new int[10][10];
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
        for(int i = 1; i <= 9 ;i++ ) {
            for(int j = 1; j <= 9; j++ ) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public int get(int x,int y) {
        return matrix[x][y];
    }
    public void set(int x,int y,int value) {
        matrix[x][y] = value;
    }
    public int[][] getMatrix() {
        return matrix;
    }
}
