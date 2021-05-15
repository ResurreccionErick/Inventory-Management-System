package POS;
import java.sql.*;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class product extends javax.swing.JFrame {

 public product() {
 initComponents();
 table_update();
 category();
 brand();
 jButton_edit.setEnabled(false);
 jButton_delete.setEnabled(false);
    }
 
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
        
    public class CategoryItem{
        int id;
        String name;
    
    public CategoryItem(int id, String name){
        this.id = id;
        this.name = name;
    }
   public String toString(){
       return name;
        }
    }
    
    public class BrandItem{
        int id;
        String name;
    
    public BrandItem(int id, String name){
        this.id = id;
        this.name = name;
    }
   public String toString(){
       return name;
        }
    }
    
    private void table_update(){
       try
       {
           String sql = "SELECT p.id, p.product, p.description,  c.category, b.brand, p.cost_price, p.retail_price, p.quantity, p.barcode, p.status "
             + "from product p, category c, brand b WHERE p.category_id = c.id and p.brand_id = b.id";
       conn = DriverManager.getConnection("jdbc:mysql://localhost/superpos?useUnicode=true&useJDBCCompliantTimezoneShift=tr"
               + "ue&useLegacyDatetimeCode=false&serverTimezone=UTC","dev","123");
       
       ps = conn.prepareStatement(sql);
       rs = ps.executeQuery();
       
       ResultSetMetaData rsd = rs.getMetaData();
       int c = rsd.getColumnCount();
       
           DefaultTableModel d = (DefaultTableModel)jTable1.getModel();
           d.setRowCount(0);
           while(rs.next()){

               Vector v2 = new Vector();
               for(int i=1; i <= c; i++){
                   v2.add(rs.getString("id"));
                   v2.add(rs.getString("product"));
                   v2.add(rs.getString("description"));
                   v2.add(rs.getString("category"));
                   v2.add(rs.getString("brand"));
                   v2.add(rs.getString("cost_price"));
                   v2.add(rs.getString("retail_price"));
                   v2.add(rs.getString("quantity"));
                   v2.add(rs.getString("barcode"));
                   v2.add(rs.getString("status"));    
               }
               d.addRow(v2);
           }
        
    }catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
        }
    }
    
   
  

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jComboBox_status = new javax.swing.JComboBox<>();
        jTextField_product = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea_description = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jComboBox_category = new javax.swing.JComboBox();
        jComboBox_brand = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextField_quantity = new javax.swing.JTextField();
        jTextField_barcode = new javax.swing.JTextField();
        jTextField_retail = new javax.swing.JTextField();
        jTextField_cost = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton_edit = new javax.swing.JButton();
        jButton_delete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 255, 204));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Category");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Brand");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Product");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Pos");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Sitka Text", 1, 15)); // NOI18N
        jButton1.setText("CASHIER");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addGap(30, 30, 30)
                .addComponent(jLabel3)
                .addGap(30, 30, 30)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        jLabel6.setFont(new java.awt.Font("Stencil", 1, 35)); // NOI18N
        jLabel6.setText("INVENTORY SYSTEM");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)), "Category", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 20), new java.awt.Color(0, 102, 102))); // NOI18N

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel7.setText("Product:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel8.setText("Status:");

        jComboBox_status.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jComboBox_status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Inactive" }));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel9.setText("Description:");

        jTextArea_description.setColumns(20);
        jTextArea_description.setRows(5);
        jScrollPane2.setViewportView(jTextArea_description);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel10.setText("Category:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel11.setText("Brand:");

        jComboBox_category.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox_brand.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel14.setText("Quantity:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel15.setText("Bar code:");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel16.setText("Cost price:");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel17.setText("Retail price:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox_category, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox_brand, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_product, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 170, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_retail, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_cost, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel14)
                            .addGap(18, 18, 18)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextField_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField_barcode, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox_status, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(184, 184, 184)))))
                .addGap(45, 45, 45))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField_product, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_cost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jComboBox_category, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jComboBox_brand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_retail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(20, 20, 20)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(jComboBox_status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jTextField_barcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(30, 30, 30))
        );

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton2.setText("Add");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton_edit.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton_edit.setText("Edit");
        jButton_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_editActionPerformed(evt);
            }
        });

        jButton_delete.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton_delete.setText("Delete");
        jButton_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_deleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(297, 297, 297)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton_edit)
                .addGap(18, 18, 18)
                .addComponent(jButton_delete)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton_edit)
                    .addComponent(jButton_delete))
                .addGap(20, 20, 20))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Product", "Description", "Category", "Brand", "Cost price", "Retail price", "Quantity", "Bar code", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(2).setResizable(false);
        }

        jPanel4.setBackground(new java.awt.Color(0, 102, 102));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 45)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 102, 102));
        jLabel5.setText("x");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel5)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addContainerGap(40, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
 private void category(){
        try{
            
       String sql = "SELECT * FROM category";
       conn = DriverManager.getConnection("jdbc:mysql://localhost/superpos?useUnicode=true&useJDBCCompliantTimezoneShift=tr"
               + "ue&useLegacyDatetimeCode=false&serverTimezone=UTC","dev","123");
       ps = conn.prepareStatement(sql);
       rs = ps.executeQuery();
       jComboBox_category.removeAllItems();
       
       while(rs.next()){
           
           jComboBox_category.addItem(new CategoryItem(rs.getInt(1),rs.getString(2)));
           
       }

       }catch(Exception e){
           JOptionPane.showMessageDialog(this, e);
        }
    }
 
  private void brand(){
        try{
            
       String sql = "SELECT * FROM brand";
       conn = DriverManager.getConnection("jdbc:mysql://localhost/superpos?useUnicode=true&useJDBCCompliantTimezoneShift=tr"
               + "ue&useLegacyDatetimeCode=false&serverTimezone=UTC","dev","123");
       ps = conn.prepareStatement(sql);
       rs = ps.executeQuery();
       jComboBox_brand.removeAllItems();
       
       while(rs.next()){
           
           jComboBox_brand.addItem(new BrandItem(rs.getInt(1),rs.getString(2)));
           
       }

       }catch(Exception e){
           JOptionPane.showMessageDialog(this, e);
        }
    }
 
 
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       try{
        String sql = "INSERT INTO product(product, description, category_id, brand_id, cost_price, retail_price, quantity, barcode, status) VALUES (?,?,?,?,?,?,?,?,?)";
       conn = DriverManager.getConnection("jdbc:mysql://localhost/superpos?useUnicode=true&useJDBCCompliantTimezoneShift=tr"
               + "ue&useLegacyDatetimeCode=false&serverTimezone=UTC","dev","123");
       
       CategoryItem c_item = (CategoryItem)jComboBox_category.getSelectedItem();
       BrandItem b_item = (BrandItem)jComboBox_brand.getSelectedItem();
       
       ps = conn.prepareStatement(sql);
       ps.setString(1, jTextField_product.getText());
       ps.setString(2, jTextArea_description.getText());
       ps.setInt(3,c_item.id);
       ps.setInt(4, b_item.id);
       ps.setString(5, jTextField_cost.getText());
       ps.setString(6, jTextField_retail.getText());
       ps.setString(7, jTextField_quantity.getText());
       ps.setString(8, jTextField_barcode.getText());
       ps.setString(9, jComboBox_status.getSelectedItem().toString());

       
       
       
       ps.executeUpdate();
           JOptionPane.showMessageDialog(null, "Product Successfully added");
           table_update();
           jTextField_product.setText("");
           jTextArea_description.setText("");
           jTextField_barcode.setText("");
           jTextField_cost.setText("");
           jTextField_product.setText("");
           jTextField_quantity.setText("");
           jTextField_retail.setText("");
           jComboBox_category.setSelectedIndex(-1);
           jComboBox_brand.setSelectedIndex(-1);
           jComboBox_status.setSelectedIndex(-1);
           jTextField_product.requestFocus();
       }catch(Exception e){
           System.out.println(e);
           
       }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        jButton_edit.setEnabled(true);
        jButton_delete.setEnabled(true);
        DefaultTableModel d1 = (DefaultTableModel)jTable1.getModel();
        int selectedIndex = jTable1.getSelectedRow();
        
        jTextField_product.setText(d1.getValueAt(selectedIndex, 1).toString());
        jTextArea_description.setText(d1.getValueAt(selectedIndex, 2).toString());
        jComboBox_category.setSelectedItem(d1.getValueAt(selectedIndex, 3).toString());
        jComboBox_brand.setSelectedItem(d1.getValueAt(selectedIndex, 4).toString());
        jTextField_cost.setText(d1.getValueAt(selectedIndex, 5).toString());
        jTextField_retail.setText(d1.getValueAt(selectedIndex, 6).toString());
        jTextField_quantity.setText(d1.getValueAt(selectedIndex, 7).toString());
        jTextField_barcode.setText(d1.getValueAt(selectedIndex, 8).toString());
        jComboBox_status.setSelectedItem(d1.getValueAt(selectedIndex, 9).toString());
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_editActionPerformed
        
       DefaultTableModel d1 = (DefaultTableModel)jTable1.getModel();
        int selectedIndex = jTable1.getSelectedRow();
        
        int id = Integer.parseInt(d1.getValueAt(selectedIndex, 0).toString());
       CategoryItem c_item = (CategoryItem)jComboBox_category.getSelectedItem();
       BrandItem b_item = (BrandItem)jComboBox_brand.getSelectedItem();
        
        try{
        String sql = "UPDATE product SET product=?,description=?,category_id=?,brand_id=?,cost_price=?,retail_price=?,quantity=?,barcode=?,status=? WHERE id=?";
        
       conn = DriverManager.getConnection("jdbc:mysql://localhost/superpos?useUnicode=true&useJDBCCompliantTimezoneShift=tr"
               + "ue&useLegacyDatetimeCode=false&serverTimezone=UTC","dev","123");
       ps = conn.prepareStatement(sql);
       ps.setString(1, jTextField_product.getText());
       ps.setString(2, jTextArea_description.getText());
       ps.setInt(3, c_item.id);
       ps.setInt(4, b_item.id);
       ps.setString(5, jTextField_cost.getText());
       ps.setString(6, jTextField_retail.getText());
       ps.setString(7, jTextField_quantity.getText());
       ps.setString(8, jTextField_barcode.getText());
       ps.setString(9, jComboBox_status.getSelectedItem().toString());
     ps.setInt(10, id);
       
       ps.executeUpdate();
           JOptionPane.showMessageDialog(null, "Successfully Updated");
           table_update();
            jTextField_product.setText("");
           jTextArea_description.setText("");
           jTextField_barcode.setText("");
           jTextField_cost.setText("");
           jTextField_product.setText("");
           jTextField_quantity.setText("");
           jTextField_retail.setText("");
           jComboBox_category.setSelectedIndex(-1);
           jComboBox_brand.setSelectedIndex(-1);
           jComboBox_status.setSelectedIndex(-1);
           jTextField_product.requestFocus();
           
       }catch(Exception e){
           System.out.println(e);
           
       }
        
    }//GEN-LAST:event_jButton_editActionPerformed

    private void jButton_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_deleteActionPerformed
        
        DefaultTableModel d1 = (DefaultTableModel)jTable1.getModel();
        int selectedIndex = jTable1.getSelectedRow();
        
        int id = Integer.parseInt(d1.getValueAt(selectedIndex, 0).toString());
        
        int dialogResult = JOptionPane.showConfirmDialog(null, "Do you want to delete this record?", "Warning",JOptionPane.YES_NO_OPTION);
        
        if(dialogResult == JOptionPane.YES_OPTION){
            
        
       try{
       String sql = "DELETE FROM product WHERE id=?";
       
       conn = DriverManager.getConnection("jdbc:mysql://localhost/superpos?useUnicode=true&useJDBCCompliantTimezoneShift=tr"
              + "ue&useLegacyDatetimeCode=false&serverTimezone=UTC","dev","123");
       ps = conn.prepareStatement(sql);
       ps.setInt(1, id);
       ps.executeUpdate();
       table_update();
       JOptionPane.showMessageDialog(null, "Record Deleted");
       
           jTextField_product.setText(""); //DELETE WHATS IN THE TEXT
           jTextArea_description.setText("");
           jTextField_barcode.setText("");
           jTextField_cost.setText("");
           jTextField_product.setText("");
           jTextField_quantity.setText("");
           jTextField_retail.setText("");
           jComboBox_category.setSelectedIndex(-1);
           jComboBox_brand.setSelectedIndex(-1);
           jComboBox_status.setSelectedIndex(-1);
           jTextField_product.requestFocus();
           jComboBox_status.setSelectedIndex(-1);
           jTextField_product.requestFocus();
       
       }catch(Exception e){
                 JOptionPane.showMessageDialog(null, e);
       
                 
            }
        }
       
    }//GEN-LAST:event_jButton_deleteActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        setVisible(false);
        new category().setVisible(true);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
               setVisible(false);
        new brand().setVisible(true);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        setVisible(false);
        new product().setVisible(true);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jPanel4MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
               setVisible(false);
        new pos().setVisible(true);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
                setVisible(false);
        new cashier().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new product().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton_delete;
    private javax.swing.JButton jButton_edit;
    private javax.swing.JComboBox jComboBox_brand;
    private javax.swing.JComboBox jComboBox_category;
    private javax.swing.JComboBox<String> jComboBox_status;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea_description;
    private javax.swing.JTextField jTextField_barcode;
    private javax.swing.JTextField jTextField_cost;
    private javax.swing.JTextField jTextField_product;
    private javax.swing.JTextField jTextField_quantity;
    private javax.swing.JTextField jTextField_retail;
    // End of variables declaration//GEN-END:variables
}
