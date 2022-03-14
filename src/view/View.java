package view;

import Controller.ManagerMatrix;

/**
 *
 * @author Acer
 */
public class View {
    ManagerMatrix managerMatrix = new ManagerMatrix();
    public void Run() {
       managerMatrix.EnterMatrix();
       managerMatrix.solve();
       managerMatrix.PrintfMatrix();
    }
}
