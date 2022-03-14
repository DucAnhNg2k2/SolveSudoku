package Controller;

import java.util.Arrays;

/**
 *
 * @author Acer
 */
public class Solve {
    int matrix[][] = null;
    int matrixSolve[][] = null;
    public Solve(int matrix[][]) {
        this.matrix = Arrays.copyOfRange(matrix, 0, matrix.length);
    }
    public int [][] Answer() {
        Init();
        Try(1,1);
        return this.matrixSolve;
    }
    private boolean check = false;
    private boolean vsFull3x3[][][] = new boolean[10][10][10];
    private boolean vsRow[][] = new boolean[10][10];
    private boolean vsLine[][] = new boolean[10][10];
    private int countNumbers[] = new int [10];
    private void Init() {
        for(int i = 1; i <= 9; i++) {
            for(int j = 1; j<= 9 ;j++) {
                for(int k = 1; k <= 9; k++) {
                    vsFull3x3[i][j][k] = false;
                }
            }
        }
        for(int i = 1; i <= 9; i++ ) {
            for(int j = 1; j <= 9; j++ ) {
                vsRow[i][j] = false;
                vsLine[i][j] = false;
            }
        }
        for(int i = 1; i <= 9; i++ ) {
            for(int j = 1; j <= 9; j++ ) {
                if( matrix[i][j] != 0 ) {
                    int num = matrix[i][j];
                    vsRow[i][num] = true;
                    vsLine[j][num] = true;
                    vsFull3x3[change(i)][change(j)][num] = true;
                }
            }
        }
        for(int i = 1; i <= 9; i++ ) {
            countNumbers[i] = 0;
        }
        check = false;
    }
    private int change(int n) {
        if( n >= 1 && n <= 3 ) n = 1;
        else if( n >= 4 && n <= 6 ) n = 4;
        else n = 7;
        return n;
    }
    private void Try(int x,int y) {
        if( check == true) {
            return;
        }
        if( matrix[x][y] == 0 ) {
            int X = change(x), Y = change(y);
            for(int num = 1; num <= 9 ; num++ ) {
                if( vsFull3x3[X][Y][num] == false && vsRow[x][num] == false && vsLine[y][num] == false && countNumbers[num] < 9) {
                    vsFull3x3[X][Y][num] = true;
                    vsRow[x][num] = true;
                    vsLine[y][num] = true;
                    countNumbers[num]++;
                    matrix[x][y] = num;
                    
                    Try(x,y);
                    
                    vsFull3x3[X][Y][num] = false;
                    vsRow[x][num] = false;
                    vsLine[y][num] = false;
                    countNumbers[num]--;
                    matrix[x][y] = 0;
                }     
            }
        }
        else {
            if( y%3 != 0) {
                Try(x,y+1);
            }
            else if( x%3 != 0) {
                Try(x+1,y-2);
            }
            else {
                if( x == 9 && y == 9 ) {
                // Coppy array
                matrixSolve = new int[10][10];
                    for(int i = 1; i <= 9; i++) {
                        for(int j = 1; j <= 9; j++ ) {
                            matrixSolve[i][j] = matrix[i][j]; 
                        }
                    } 
                // Coppy array
                    check = true;
		}
                else if( y < 9 ) {
                    Try(x-2,y+1);
                }
		else {
                    Try(x+1,1);
		}
            }
        }
    }
}
