package Controller;

import Model.Matrix;
import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;
import java.util.Scanner;

/**
 *
 * @author Acer
 */
public class Controller {
    private static Controller singleton = null;
    private Scanner sc = new Scanner(System.in);
    private ManagerMatrix mnMatrix = ManagerMatrix.getInstance();
    private Controller() {
        
    }
    public static Controller getInstance() {
        if( singleton == null) {
            singleton = new Controller();
        }
        return singleton;
    }
    public void InputMatrix(Matrix matrix) {
        try {
            for(int i = 1 ; i <= 9; i++ ) {
                for(int j = 1; j <= 9; j++ ) {
                    int value = sc.nextInt();
                    matrix.set(j, j, value);
                }
            }
        } catch (Exception e) {
            System.out.println("Nhập ma trận null");
        }
    }
    public void OutputMatrix(Matrix matrix) {
        try {
            for(int i = 1 ; i <= 9; i++ ) {
                for(int j = 1; j <= 9; j++ ) {
                    System.out.print(matrix.get(i, j) + " ");
                }
                System.out.println("");
            }
        } catch (Exception e) {
            System.out.println("In ma trận null");
        }
    }
    public void solve() {
    // Input
        System.out.println("\nInput sudoku:");
        OutputMatrix(mnMatrix.matrixIn);
    // Solve
        new Solve().Answer();
    // Output
        if(ManagerMatrix.getInstance().answer == false ) {
            System.out.println("!!No answer!!");
        }
        else {
            System.out.println("\nAnswer sudoku 9x9:");
            OutputMatrix(mnMatrix.matrixOut);
        }
      
    }
    public void changeTextToMatrix(TextField textMatrix[][]) {
        for(int i = 0; i < 9; i++ ){
            for(int j = 0; j < 9 ;j++ ) {
                String s = textMatrix[i][j].getText();
                if( s.equals("") == true ) {
                    mnMatrix.matrixIn.set(j+1, i+1, 0);
                }
                else {
                    mnMatrix.matrixIn.set(j+1, i+1, Integer.parseInt(s));
                }
            }
        }
    }
    public void changeMatrixToText(TextField textMatrix[][]) {
        ManagerMatrix temp = ManagerMatrix.getInstance();
        for(int i = 0; i < 9; i++ ){
            for(int j = 0; j < 9 ;j++ ) {
                int Data = temp.matrixOut.get(j+1, i+1);
                int Value = temp.matrixIn.get(j+1, i+1);
                textMatrix[i][j].setText(String.valueOf(Data));
                if( Value != 0) {
                    textMatrix[i][j].setForeground(Color.BLACK);
                }
                else {
                    textMatrix[i][j].setForeground(Color.RED);
                }
            }  
        }
    }
}
