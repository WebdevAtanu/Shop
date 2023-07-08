package Bookshop;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.sql.*;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;


/**
 *
 * @author Admin
 */
public final class User extends javax.swing.JFrame {

    /**
     * Creates new form books
     * @param Uname
     */
    public User(String Uname) {
        initComponents();
        Connect();
        table_update();
       
        Cname.setText(Uname);
        
    }
    
    
    Connection con;
    PreparedStatement pst;
    PreparedStatement pst1;
    PreparedStatement insert;
    ResultSet rs;
    DefaultTableModel df;
    public void Connect()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/bookshop","root","");
            
            
        } 
        
        
        
        
        
        catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void reset()
    {
        bid.setText("");
        title.setText("");
        author.setText("");
        Qty.setText("");
        price.setText("");
    }
    private void table_update() {
        int CC;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/bookshop","root","");
            insert = con.prepareStatement("SELECT * FROM books");
            rs = insert.executeQuery();
            
            ResultSetMetaData RSMD = rs.getMetaData();
            CC = RSMD.getColumnCount();
            DefaultTableModel DFT = (DefaultTableModel) showbooks.getModel();
            DFT.setRowCount(0);

            while (rs.next()) {
                Vector v2 = new Vector();
           
                for (int ii = 1; ii <= CC; ii++) {
                    v2.add(rs.getString("id"));
                    v2.add(rs.getString("title"));
                    v2.add(rs.getString("author"));
                    v2.add(rs.getString("quantity"));
                    v2.add(rs.getString("price"));
                }
                DFT.addRow(v2);
            }
        } catch (ClassNotFoundException | SQLException e) {
        }
    }
    
    
    
    public void sales()
    {
        String totalcost = gtotal.getText();
        String tpay = pay.getText();
        String tbal = bal.getText();
        int lastid =0;
        try {
            
            String query = "insert into sales(subtotal,pay,bal)values(?,?,?)";
            pst = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, totalcost);
            pst.setString(2, tpay);
            pst.setString(3, tbal);
            pst.executeUpdate();
            rs = pst.getGeneratedKeys();
            if(rs.next())
            {
                lastid = rs.getInt(1);
            }
              int rows = selectedbooks.getRowCount();
              
              String query1 = "insert into productsale(saleid,title,author,quantity,price,total)values(?,?,?,?,?,?)";
              pst1 = con.prepareStatement(query1);
              
              String btitle ="";
              String bauthor ="";
              String bprice;
              String bquantity;
              int btotal = 0;
              
              for(int i=0; i<selectedbooks.getRowCount(); i++)
              {
                   btitle = (String)selectedbooks.getValueAt(i, 1);
                    bauthor = (String)selectedbooks.getValueAt(i, 2);
                    bquantity = (String)selectedbooks.getValueAt(i, 3);
                   bprice = (String)selectedbooks.getValueAt(i, 4);
                   btotal = (int)selectedbooks.getValueAt(i, 5);
                    pst1.setInt(1, lastid);
                    pst1.setString(2, btitle);
                    pst1.setString(3, bauthor);
                     pst1.setString(4, bquantity);
                     pst1.setString(5, bprice);
                     pst1.setInt(6, btotal);
                     pst1.executeUpdate();
              }
              
              JOptionPane.showMessageDialog(this, "Purchase Complete. Wait for receipt");
              HashMap a=new HashMap();
              a.put("invoice", lastid);
              
            try {
                JasperDesign jdesign=JRXmlLoader.load("C:\\Users\\Admin\\Documents\\NetBeansProjects\\Bookshopproject\\src\\Bookshop\\report1.jrxml");
                JasperReport jreport=JasperCompileManager.compileReport(jdesign);
                JasperPrint jprint= JasperFillManager.fillReport(jreport, a, con);
                JasperViewer.viewReport(jprint);
            } catch (JRException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
 
           
 
        } catch (SQLException ex) {
        }
 
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        add = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        showbooks = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        close = new javax.swing.JButton();
        Cname = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        selectedbooks = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        bid = new javax.swing.JTextField();
        title = new javax.swing.JTextField();
        author = new javax.swing.JTextField();
        AMOUNT = new javax.swing.JLabel();
        AMOUNT3 = new javax.swing.JLabel();
        AMOUNT2 = new javax.swing.JLabel();
        gtotal = new javax.swing.JTextField();
        pay = new javax.swing.JTextField();
        bal = new javax.swing.JTextField();
        checkout = new javax.swing.JButton();
        ResetCart = new javax.swing.JButton();
        Logout = new javax.swing.JButton();
        PrintTable = new javax.swing.JButton();
        Qty = new javax.swing.JTextField();
        price = new javax.swing.JTextField();
        remove = new javax.swing.JButton();
        quantity = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(695, 419));

        add.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Bookshop/icons8-add-basket-30.png"))); // NOI18N
        add.setText(">>");
        add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addMouseClicked(evt);
            }
        });
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        showbooks.setBackground(new java.awt.Color(153, 255, 255));
        showbooks.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        showbooks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "TITLE", "AUTHOR", "QUANTITY", "PRICE"
            }
        ));
        showbooks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showbooksMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(showbooks);

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 0));
        jLabel7.setText("Browse Available Books Here");

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 0));
        jLabel14.setText("Book Store Management Application");

        close.setBackground(new java.awt.Color(204, 255, 204));
        close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Bookshop/icons8-close-20.png"))); // NOI18N
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
        });

        Cname.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Cname.setForeground(new java.awt.Color(255, 255, 0));
        Cname.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Bookshop/icons8-id-button-30.png"))); // NOI18N
        Cname.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Cname)
                .addGap(239, 239, 239)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(close))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel7)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(Cname))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(69, 69, 69))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(close)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel10.setText("List of books selected");

        selectedbooks.setBackground(new java.awt.Color(204, 255, 51));
        selectedbooks.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        selectedbooks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "TITLE", "AUTHOR", "QUANTITY", "PRICE", "TOTAL"
            }
        ));
        jScrollPane2.setViewportView(selectedbooks);
        if (selectedbooks.getColumnModel().getColumnCount() > 0) {
            selectedbooks.getColumnModel().getColumn(3).setHeaderValue("QUANTITY");
            selectedbooks.getColumnModel().getColumn(5).setHeaderValue("TOTAL");
        }

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel11.setText("Select books from here");

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));

        bid.setEditable(true);
        bid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bidKeyPressed(evt);
            }
        });

        title.setEditable(false);

        author.setEditable(false);

        AMOUNT.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        AMOUNT.setForeground(new java.awt.Color(255, 255, 0));
        AMOUNT.setText("Total");

        AMOUNT3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        AMOUNT3.setForeground(new java.awt.Color(255, 255, 0));
        AMOUNT3.setText("Pay");

        AMOUNT2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        AMOUNT2.setForeground(new java.awt.Color(255, 255, 0));
        AMOUNT2.setText("Balance");

        gtotal.setEditable(false);

        bal.setEditable(false);

        checkout.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        checkout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Bookshop/icons8-checkout-30.png"))); // NOI18N
        checkout.setText("Checkout");
        checkout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkoutMouseClicked(evt);
            }
        });
        checkout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkoutActionPerformed(evt);
            }
        });

        ResetCart.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        ResetCart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Bookshop/icons8-reset-30.png"))); // NOI18N
        ResetCart.setText("Reset Cart");
        ResetCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetCartActionPerformed(evt);
            }
        });

        Logout.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        Logout.setForeground(new java.awt.Color(255, 0, 0));
        Logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Bookshop/icons8-exit-30.png"))); // NOI18N
        Logout.setText("Logout");
        Logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogoutMouseClicked(evt);
            }
        });

        PrintTable.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        PrintTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Bookshop/icons8-print-30.png"))); // NOI18N
        PrintTable.setText("Print Table");
        PrintTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PrintTableMouseClicked(evt);
            }
        });
        PrintTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintTableActionPerformed(evt);
            }
        });

        Qty.setEditable(false);

        price.setEditable(false);

        remove.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        remove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Bookshop/icons8-delete-30.png"))); // NOI18N
        remove.setText("Remove Cart");
        remove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(bid, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(author, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Qty, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(checkout, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(PrintTable)
                        .addGap(18, 18, 18)
                        .addComponent(remove)
                        .addGap(18, 18, 18)
                        .addComponent(ResetCart)
                        .addGap(18, 18, 18)
                        .addComponent(Logout, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(AMOUNT2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bal, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AMOUNT3)
                            .addComponent(AMOUNT))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(gtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pay, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bid, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(author, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Qty, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AMOUNT)
                    .addComponent(gtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AMOUNT3)
                            .addComponent(pay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AMOUNT2)
                            .addComponent(bal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(checkout)
                            .addComponent(PrintTable)
                            .addComponent(ResetCart)
                            .addComponent(remove)
                            .addComponent(Logout))))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(jLabel11)
                        .addGap(360, 360, 360)
                        .addComponent(jLabel10)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(add)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(add)
                        .addGap(9, 9, 9)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 955, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void LogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutMouseClicked
         int result=JOptionPane.showConfirmDialog(null, "Do you want to logout");
        if(result==JOptionPane.YES_OPTION){
        new login().setVisible(true);
        this.dispose();
        }
    }//GEN-LAST:event_LogoutMouseClicked

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        
        int bprice = Integer.parseInt(price.getText());
        int qty = Integer.parseInt(quantity.getValue().toString());
        int total = qty * bprice;
        df = (DefaultTableModel)selectedbooks.getModel();

        df.addRow(new Object[]
            {
                bid.getText(),
                title.getText(),
                author.getText(),
                quantity.getValue().toString(),
                price.getText(),
                total

            });
            int sum = 0;
            for(int i=0; i<selectedbooks.getRowCount(); i++)
            {
                sum = sum + Integer.parseInt(selectedbooks.getValueAt(i, 5).toString());
            }
            gtotal.setText(String.valueOf(sum));
            bid.setText("");
            author.setText("");
            title.setText("");
            price.setText("");
            Qty.setText("");
            quantity.setValue(0);
            bid.requestFocus();
           
            
         
    }//GEN-LAST:event_addActionPerformed

    private void addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseClicked

    }//GEN-LAST:event_addMouseClicked

    private void bidKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bidKeyPressed

        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            try {
                String id= bid.getText();
                pst = con.prepareStatement("select * from books where id = ?");
                pst.setString(1,id);
                rs = pst.executeQuery();
                if(rs.next() == false)
                {
                    JOptionPane.showMessageDialog(this, "Book Code not Found");
                }
                else{
                    String booktitle=rs.getString("title");
                    title.setText(booktitle);
                    String bookauthor=rs.getString("author");
                    author.setText(bookauthor);
                    String bookprice=rs.getString("price");
                    price.setText(bookprice);
                    String quantity1=rs.getString("quantity");
                    Qty.setText(quantity1);
                    quantity.requestFocus();
                }

            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_bidKeyPressed

    private void checkoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkoutMouseClicked
       
        
    }//GEN-LAST:event_checkoutMouseClicked

    private void ResetCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetCartActionPerformed
        gtotal.setText("");
        DefaultTableModel model=(DefaultTableModel)selectedbooks.getModel();
      while(model.getRowCount()>0)
      {
          for(int i=0;i<model.getRowCount();i++)
          {
              model.removeRow(i);
          }
      }
      JOptionPane.showMessageDialog(this, "Table Reset");
    }//GEN-LAST:event_ResetCartActionPerformed

    private void PrintTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintTableActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PrintTableActionPerformed

    private void PrintTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PrintTableMouseClicked
        try {
            selectedbooks.print();
        } catch (PrinterException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_PrintTableMouseClicked

    private void checkoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkoutActionPerformed
        if(pay.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Enter paying amount");
        }
        int tpay = Integer.parseInt(pay.getText());
        int totalcost = Integer.parseInt(gtotal.getText()); 
        
        if(tpay<totalcost)
        {
            JOptionPane.showMessageDialog(this, "Paying amount is lessthan total amount. Enter valid amount");
        }
       
        else{
                
       int tbal = tpay-totalcost;  
       bal.setText(String.valueOf(tbal));
       sales();
       
        }
    }//GEN-LAST:event_checkoutActionPerformed
    int BID;int stock=0;
    private void showbooksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showbooksMouseClicked
         DefaultTableModel model = (DefaultTableModel) showbooks.getModel();
  int selectedIndex = showbooks.getSelectedRow();
  bid.setText(model.getValueAt(selectedIndex, 0).toString());
  title.setText(model.getValueAt(selectedIndex, 1).toString());
  author.setText(model.getValueAt(selectedIndex, 2).toString());
  Qty.setText(model.getValueAt(selectedIndex, 3).toString());
  price.setText(model.getValueAt(selectedIndex, 4).toString());
  stock=Integer.valueOf(model.getValueAt(selectedIndex,3).toString());
  BID=Integer.valueOf(model.getValueAt(selectedIndex,0).toString());
  
    }//GEN-LAST:event_showbooksMouseClicked

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
        int result=JOptionPane.showConfirmDialog(null, "Do you want to exit");
        if(result==JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_closeMouseClicked

    private void removeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeMouseClicked
        DefaultTableModel model=(DefaultTableModel)selectedbooks.getModel();
        {
            try
            {
               int SelectedRowIndex=selectedbooks.getSelectedRow();
               model.removeRow(SelectedRowIndex);
              
                JOptionPane.showMessageDialog(this, "Cart removed");
                
                 reset();
            int sum = 0;
            for(int i=0; i<selectedbooks.getRowCount(); i++)
            {
                sum = sum + Integer.parseInt(selectedbooks.getValueAt(i, 5).toString());
            }
            gtotal.setText(String.valueOf(sum));
            }
            catch(HeadlessException | NumberFormatException e)
            {
            }
        }
    }//GEN-LAST:event_removeMouseClicked
  
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new User("").setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AMOUNT;
    private javax.swing.JLabel AMOUNT2;
    private javax.swing.JLabel AMOUNT3;
    private javax.swing.JLabel Cname;
    private javax.swing.JButton Logout;
    private javax.swing.JButton PrintTable;
    private javax.swing.JTextField Qty;
    private javax.swing.JButton ResetCart;
    private javax.swing.JButton add;
    private javax.swing.JTextField author;
    private javax.swing.JTextField bal;
    private javax.swing.JTextField bid;
    private javax.swing.JButton checkout;
    private javax.swing.JButton close;
    private javax.swing.JTextField gtotal;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField pay;
    private javax.swing.JTextField price;
    private javax.swing.JSpinner quantity;
    private javax.swing.JButton remove;
    private javax.swing.JTable selectedbooks;
    private javax.swing.JTable showbooks;
    private javax.swing.JTextField title;
    // End of variables declaration//GEN-END:variables
}
