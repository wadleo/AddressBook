package contactbook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author leonard
 */
public class Login {

    private JFrame frame;
    private final Connection connection;

    /**
     *constructor to create login frame and test connection to the database to authenticate users
     */
    public Login() {
        initialise();
        connection = ContactDB.createConnection();
    }

    private void initialise() {
        frame = new JFrame("Login");
        initComponents();
    }

    @SuppressWarnings("unchecked")
                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cancel_btn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        login_btn = new javax.swing.JButton();
        username_txt = new javax.swing.JTextField();
        password_txt = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        new_btn = new javax.swing.JButton();

        frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationByPlatform(true);
        frame.setMinimumSize(new java.awt.Dimension(50, 50));
        frame.setAlwaysOnTop(false);
        //frame.setLocation(600, 50);

        jPanel1.setPreferredSize(new java.awt.Dimension(50, 50));

        cancel_btn.setText("Cancel");
        cancel_btn.addActionListener((java.awt.event.ActionEvent evt) -> {
            cancel_btnActionPerformed(evt);
        });

        jLabel1.setText("Username:");

        login_btn.setText("Login");
        login_btn.addActionListener((evt) -> this.login_btnActionPerformed(evt));

        jLabel2.setText("Password:");

        new_btn.setText("New");
        new_btn.addActionListener(Login.this::new_btnActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(password_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(username_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(24, 24, 24)
                                        .addComponent(new_btn)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(login_btn)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cancel_btn)))
                        .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(username_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(password_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(login_btn)
                                .addComponent(cancel_btn)
                                .addComponent(new_btn))
                        .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                        .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))
        );
        frame.getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(frame);
    }// </editor-fold>                        

    private void login_btnActionPerformed(java.awt.event.ActionEvent evt) {
        String Username = username_txt.getText();
        String Password = password_txt.getText();
        String sql = "SELECT * FROM login WHERE Username = '"+Username+"' AND Password = '"+Password+"'";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            int count = 0;

            while (rs.next()) {
                count++;
            }
            if (count > 0) {
                JOptionPane.showMessageDialog(null, "User identified");
                frame.dispose();
                ContactBook addressBook = new ContactBook();
                addressBook.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "User not found");
            }

        } catch (SQLException ex) {
            Logger.getLogger(ContactBook.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Exception handling: " + ex);
        }

    }

    private void cancel_btnActionPerformed(java.awt.event.ActionEvent evt) {
        frame.dispose();
        String disableString = null;
        ContactBook addressBook = new ContactBook(disableString);
        addressBook.setVisible(true);
    }

    private void new_btnActionPerformed(java.awt.event.ActionEvent evt) {
        String Username = username_txt.getText();
        String Password = password_txt.getText();
        String save_query = "INSERT INTO login (Username, Password ) VALUES (?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(save_query);
            ps.setString(1, Username);
            ps.setString(2, Password);
            ps.execute();
            JOptionPane.showMessageDialog(null, "User created");
            login_btnActionPerformed(evt);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
           //JOptionPane.showMessageDialog(null, "User could not be created. " + ex);
        }
    }

    /**
     *main method creates the login object and makes it visible
     * @param args
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(() -> {
            Login window = new Login();
            window.frame.setVisible(true);
        });
    }

    private javax.swing.JButton cancel_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton login_btn;
    private javax.swing.JButton new_btn;
    private javax.swing.JPasswordField password_txt;
    private javax.swing.JTextField username_txt;

}
