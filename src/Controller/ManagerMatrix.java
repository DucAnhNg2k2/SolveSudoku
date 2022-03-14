package Controller;
import Model.Matrix;
        
public class ManagerMatrix {
    public static boolean answer = false;
    public static Matrix matrixIn = null;
    public static Matrix matrixOut = null;
    private static ManagerMatrix singleton = null;
    private ManagerMatrix() {
        
    }
    public static ManagerMatrix getInstance() {
        if( singleton == null) {
            singleton = new ManagerMatrix();
            matrixIn = new Matrix();
            matrixOut = new Matrix();
        }
        return singleton;
    }
}
