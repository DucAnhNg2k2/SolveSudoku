package Controller;
import Model.Matrix;
        
public class ManagerMatrix {
    private Matrix matrix = new Matrix();
    public void EnterMatrix() {
       matrix.Nhap();
    }
    public void PrintfMatrix() {
        matrix.In();
        System.out.println("\n");
    }
    public void solve() {
          matrix.matrix = new Solve(this.matrix.getMatrix()).Answer();
    }
}
