package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;

import Controller.Controller;
import Controller.ManagerMatrix;
import javax.swing.JOptionPane;

public class JFrame extends javax.swing.JFrame {
    private ManagerMatrix mnMatrix = ManagerMatrix.getInstance();
    private Controller controller = Controller.getInstance(); 
    public JFrame() {
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        InitJFrame();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ButtonReset = new javax.swing.JButton();
        ButtonRun = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sudoku 9x9");
        setResizable(false);
        setSize(new java.awt.Dimension(600, 600));

        ButtonReset.setText("Reset");
        ButtonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonResetActionPerformed(evt);
            }
        });

        ButtonRun.setText("Run");
        ButtonRun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRunActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(ButtonReset, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 240, Short.MAX_VALUE)
                .addComponent(ButtonRun, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(513, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonReset, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonRun, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonRunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRunActionPerformed
        for(int i = 0; i < 9; i++ ) {
            for(int j = 0; j < 9; j++ ) {
                String s = inputMatrix[i][j].getText();
                if( s.length() > 1 || (s.equals("")!= true&&(s.compareTo("1")< 0||s.compareTo("9")>0))) {
                    JOptionPane.showMessageDialog(rootPane, "Không hợp lệ!");
                    return;
                }
            }
        }
        Run();
    }//GEN-LAST:event_ButtonRunActionPerformed

    private void ButtonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonResetActionPerformed
        Reset();
    }//GEN-LAST:event_ButtonResetActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonReset;
    private javax.swing.JButton ButtonRun;
    // End of variables declaration//GEN-END:variables

    private TextField inputMatrix[][] = new TextField[9][9];
    private void setMatrix() {
        final int size = 45;
        int height = 40, width = 98;
        for(int i = 0 ; i< 9 ;i++) {
            for(int j = 0; j < 9; j++) {
              inputMatrix[i][j] = new TextField("");
              inputMatrix[i][j].setVisible(true);
              inputMatrix[i][j].setSize(size,size);
              inputMatrix[i][j].setLocation(i*size+width, j*size+height);
              inputMatrix[i][j].setFont(new Font("SansSerif",Font.BOLD,25));
              this.add(inputMatrix[i][j]);
            }
        }
    }
    private void InitJFrame() {
        setMatrix();
    }
    private void Reset() {
        for(int i = 0 ; i< 9 ;i++) {
            for(int j = 0; j < 9; j++) {
              inputMatrix[i][j].setText("");
              inputMatrix[i][j].setForeground(Color.BLACK);
            }
        }
    }
    private void Run() {
        controller.changeTextToMatrix(inputMatrix);
        controller.solve();
        if( mnMatrix.answer == true ) {
            controller.changeMatrixToText(inputMatrix);
        }
        else {
            JOptionPane.showMessageDialog(rootPane, "Không tồn tại !");
        }
    }
}
