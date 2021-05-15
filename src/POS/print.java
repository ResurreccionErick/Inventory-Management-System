package POS;

import java.awt.print.PrinterException;
import javax.swing.table.TableModel;


public class print extends javax.swing.JFrame {

    
    public print() {
        initComponents();
    }

    String lsub;
    String lpay;
    String lbal;
    
    
    print(String sub, String pay, String bal, TableModel tableModel) throws PrinterException {
        initComponents();
        this.lsub = sub;
        this.lpay = pay;
        this.lbal = bal;
        
      jTextArea1.setText(jTextArea1.getText()+ "********************************************************\n");
       jTextArea1.setText(jTextArea1.getText()+ "****************    POINT OF SALE    ****************\n");
       jTextArea1.setText(jTextArea1.getText()+ "\n");
       jTextArea1.setText(jTextArea1.getText()+ "Product" + "\t" + "Price" + "\t" + "Total" + "\n");
       
       for(int i = 0; i < tableModel.getRowCount(); i++)
       {
       String product = (String) tableModel.getValueAt(i, 1);
       String price = (String) tableModel.getValueAt(i, 2);
       int total = (int) tableModel.getValueAt(i, 4);
       
       jTextArea1.setText(jTextArea1.getText()+ product + "\t" + price + "\t" + total + "\n");
       }
       jTextArea1.setText(jTextArea1.getText()+ "\n");
       jTextArea1.setText(jTextArea1.getText()+ "\n");
       jTextArea1.setText(jTextArea1.getText()+ "\t                            " + "Subtotal:" + sub + "\n");
       jTextArea1.setText(jTextArea1.getText()+ "\t                            " + "Pay:" + pay + "\n");
       jTextArea1.setText(jTextArea1.getText()+ "\t                            " + "Balance:" + bal + "\n");
       jTextArea1.setText(jTextArea1.getText()+ "\n");
       jTextArea1.setText(jTextArea1.getText()+ "\n");
       jTextArea1.setText(jTextArea1.getText()+ "********************************************************\n");
       jTextArea1.setText(jTextArea1.getText()+ "************    THANKYOU COME AGAIN    ***********\n");
       jTextArea1.print();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
    public static void main(String args[]) {
        
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(print.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(print.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(print.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(print.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new print().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
