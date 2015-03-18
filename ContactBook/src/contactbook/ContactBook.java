package contactbook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author leonard
 */
public class ContactBook extends javax.swing.JFrame {

    private final Connection connection;

    /**
     *the contact book constructor called when the user has made himself admin or authenticated his login
     */
    public ContactBook() {
        initComponents();
        connection = ContactDB.createConnection();
        fillCount();
        viewcon_btnActionPerformed(null);
    }

    /**
     *the constructor called when the user refuses to authenticate login and just wants to view contacts
     * @param disableString
     */
    public ContactBook(String disableString) {
        initComponents();
        connection = ContactDB.createConnection();
        fillCount();
        viewcon_btnActionPerformed(null);
        insertnew_btn.setEnabled(false);
        update_btn.setEnabled(false);
        save_btn.setEnabled(false);
        delete_btn.setEnabled(false);
    }

    private void fillCount() {
        String sql = "SELECT * FROM contacts";
        int count = 0;
        try {
            Statement st1 = connection.createStatement();
            ResultSet rs1 = st1.executeQuery(sql);
            while (rs1.next()) {
                count++;
            }
            next_txt.setText("" + count);
        } catch (SQLException e) {
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lName_txt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        address_txt = new javax.swing.JTextField();
        viewcon_btn = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        search_txt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        next_btn = new javax.swing.JButton();
        phoneNum_txt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        next_txt = new javax.swing.JTextField();
        prev_txt = new javax.swing.JTextField();
        update_btn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        delete_btn = new javax.swing.JButton();
        search_btn = new javax.swing.JButton();
        prev_btn = new javax.swing.JButton();
        email_txt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        avgAge_txt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        save_btn = new javax.swing.JButton();
        regNum_txt = new javax.swing.JTextField();
        day_txt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        fName_txt = new javax.swing.JTextField();
        insertnew_btn = new javax.swing.JButton();
        year_txt = new javax.swing.JTextField();
        month_txt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Address Book");
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(50, 50));
        setName("addressbook"); // NOI18N
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);
        getContentPane().setLayout(new java.awt.BorderLayout(500, 500));

        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jPanel1.setAutoscrolls(true);
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.setInheritsPopupMenu(true);

        jLabel6.setText("Address");

        jLabel1.setText("    OF");

        address_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                address_txtActionPerformed(evt);
            }
        });

        viewcon_btn.setText("View Contacts");
        viewcon_btn.setToolTipText("see all contacts from first");
        viewcon_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewcon_btnActionPerformed(evt);
            }
        });

        jLabel7.setText("Email");

        search_txt.setToolTipText("enter first name to search");
        search_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_txtActionPerformed(evt);
            }
        });
        search_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search_txtKeyReleased(evt);
            }
        });

        jLabel5.setText("Phone Number");

        next_btn.setText("Next");
        next_btn.setToolTipText("view next");
        next_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                next_btnActionPerformed(evt);
            }
        });

        jLabel2.setText("Registration Number");

        next_txt.setEditable(false);
        next_txt.setToolTipText("total number of contacts");
        next_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                next_txtActionPerformed(evt);
            }
        });

        prev_txt.setToolTipText("enter contact number");
        prev_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prev_txtActionPerformed(evt);
            }
        });
        prev_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                prev_txtKeyReleased(evt);
            }
        });

        update_btn.setText("Update");
        update_btn.setToolTipText("update this old contact");
        update_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_btnActionPerformed(evt);
            }
        });

        jLabel4.setText("Last Name");

        delete_btn.setText("Delete");
        delete_btn.setToolTipText("delete this contact");
        delete_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_btnActionPerformed(evt);
            }
        });

        search_btn.setText("Go");
        search_btn.setToolTipText("start search");
        search_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_btnActionPerformed(evt);
            }
        });

        prev_btn.setText("Previous");
        prev_btn.setToolTipText("view previous");
        prev_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prev_btnActionPerformed(evt);
            }
        });

        jLabel9.setText("Search by First Name");

        avgAge_txt.setEditable(false);
        avgAge_txt.setToolTipText("average age of all contacts");
        avgAge_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                avgAge_txtActionPerformed(evt);
            }
        });

        jLabel8.setText("Date of Birth");

        save_btn.setText("Save");
        save_btn.setToolTipText("save new contact");
        save_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_btnActionPerformed(evt);
            }
        });

        regNum_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regNum_txtActionPerformed(evt);
            }
        });

        day_txt.setToolTipText("dd");

        jLabel3.setText("First Name");

        jLabel10.setText("Average age of contacts");

        fName_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fName_txtActionPerformed(evt);
            }
        });

        insertnew_btn.setText("Insert New");
        insertnew_btn.setToolTipText("clear fields to enter new contact");
        insertnew_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertnew_btnActionPerformed(evt);
            }
        });

        year_txt.setToolTipText("yyyy");

        month_txt.setToolTipText("mm");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(prev_btn)
                                        .addGap(51, 51, 51)
                                        .addComponent(prev_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(31, 31, 31)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26)
                                        .addComponent(next_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(34, 34, 34))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(save_btn)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(update_btn)
                                        .addGap(96, 96, 96)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(delete_btn)
                                    .addComponent(next_btn, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(avgAge_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(fName_txt, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                                    .addComponent(lName_txt)
                                    .addComponent(regNum_txt)
                                    .addComponent(phoneNum_txt)
                                    .addComponent(address_txt)
                                    .addComponent(email_txt)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(day_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(month_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(year_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 22, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(search_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(search_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(insertnew_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(viewcon_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(next_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(next_btn)
                        .addComponent(prev_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(prev_btn)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(fName_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lName_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(regNum_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneNum_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(address_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(email_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(day_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(year_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(month_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(search_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search_btn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(avgAge_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(save_btn)
                    .addComponent(update_btn)
                    .addComponent(delete_btn))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(insertnew_btn)
                    .addComponent(viewcon_btn)))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void prev_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prev_btnActionPerformed
        int nextIndex = Integer.parseInt(next_txt.getText());
        int previousIndex = Integer.parseInt(prev_txt.getText());
        if (previousIndex == 1) {
            previousIndex = nextIndex;
             prev_txt.setText(previousIndex + "");
            String sql2String = "SELECT * FROM contacts WHERE (`_rowid_` = ?)";
            try {
                PreparedStatement ps2 = connection.prepareStatement(sql2String);
                ps2.setString(1, "" + previousIndex);
                ResultSet rs2 = ps2.executeQuery();
                insertnew_btnActionPerformed(evt);
                while (rs2.next()) {
                    regNum_txt.setText(rs2.getString(1));
                    phoneNum_txt.setText(rs2.getString(4));
                    fName_txt.setText(rs2.getString(2));
                    lName_txt.setText(rs2.getString(3));
                    address_txt.setText(rs2.getString(5));
                    email_txt.setText(rs2.getString(6));
                    day_txt.setText(rs2.getString(7));
                    month_txt.setText(rs2.getString(8));
                    year_txt.setText(rs2.getString(9));
                    prev_txt.setText(previousIndex + "");
                    break;
                }
            } catch (SQLException e) {

            }
        } else if (previousIndex <= nextIndex && previousIndex > 1) {
            --previousIndex;
             prev_txt.setText(previousIndex + "");
            String sql = "SELECT * FROM contacts WHERE (`_rowid_` = ?)";
            try {
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setString(1, "" + previousIndex);
                insertnew_btnActionPerformed(evt);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    regNum_txt.setText(rs.getString(1));
                    phoneNum_txt.setText(rs.getString(4));
                    fName_txt.setText(rs.getString(2));
                    lName_txt.setText(rs.getString(3));
                    address_txt.setText(rs.getString(5));
                    email_txt.setText(rs.getString(6));
                    day_txt.setText(rs.getString(7));
                    month_txt.setText(rs.getString(8));
                    year_txt.setText(rs.getString(9));
                    prev_txt.setText(previousIndex + "");
                    break;
                }
            } catch (SQLException e) {

            }
        } else {
            JOptionPane.showMessageDialog(null, "contact does not exist");
        }
    }//GEN-LAST:event_prev_btnActionPerformed

    private void prev_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prev_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prev_txtActionPerformed

    private void next_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_next_txtActionPerformed

    }//GEN-LAST:event_next_txtActionPerformed

    private void next_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_next_btnActionPerformed
        int nextIndex = Integer.parseInt(next_txt.getText());
        int previousIndex = Integer.parseInt(prev_txt.getText());
        if (previousIndex < nextIndex && previousIndex >= 1) {
            ++previousIndex;
            prev_txt.setText(previousIndex + "");
            String sql3 = "SELECT * FROM contacts WHERE (`_rowid_` = ?)";
            try {
                PreparedStatement ps3 = connection.prepareStatement(sql3);
                ps3.setString(1, "" + previousIndex);
                insertnew_btnActionPerformed(evt);
                ResultSet rs3 = ps3.executeQuery();
                while (rs3.next()) {
                    regNum_txt.setText(rs3.getString(1));
                    phoneNum_txt.setText(rs3.getString(4));
                    fName_txt.setText(rs3.getString(2));
                    lName_txt.setText(rs3.getString(3));
                    address_txt.setText(rs3.getString(5));
                    email_txt.setText(rs3.getString(6));
                    day_txt.setText(rs3.getString(7));
                    month_txt.setText(rs3.getString(8));
                    year_txt.setText(rs3.getString(9));
                    prev_txt.setText(previousIndex + "");
                    break;
                }
            } catch (SQLException e) {

            }
        } else if (previousIndex == nextIndex) {
            previousIndex = 1;
            prev_txt.setText(previousIndex + "");
            String sql4 = "SELECT * FROM contacts WHERE (`_rowid_` = ?)";
            try {
                PreparedStatement ps4 = connection.prepareStatement(sql4);
                ps4.setString(1, "" + previousIndex);
                insertnew_btnActionPerformed(evt);
                ResultSet rs4 = ps4.executeQuery();
                while (rs4.next()) {
                    regNum_txt.setText(rs4.getString(1));
                    phoneNum_txt.setText(rs4.getString(4));
                    fName_txt.setText(rs4.getString(2));
                    lName_txt.setText(rs4.getString(3));
                    address_txt.setText(rs4.getString(5));
                    email_txt.setText(rs4.getString(6));
                    day_txt.setText(rs4.getString(7));
                    month_txt.setText(rs4.getString(8));
                    year_txt.setText(rs4.getString(9));
                    prev_txt.setText(previousIndex + "");
                    break;
                }
            } catch (SQLException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "contact does not exist");
        }
    }//GEN-LAST:event_next_btnActionPerformed

    private void update_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_btnActionPerformed
        int previousIndex = Integer.parseInt(prev_txt.getText());
        String RegNum = regNum_txt.getText();
        String Fname = fName_txt.getText();
        String Lname = lName_txt.getText();
        String Pnumber = phoneNum_txt.getText();
        String Email = email_txt.getText();
        String Address = address_txt.getText();
        String Day = day_txt.getText();
        String Month = month_txt.getText();
        String Year = year_txt.getText();
        try {
            String update1 = "Update contacts Set RegNum= '" + RegNum + "', Fname = '" + Fname + "', "
                    + "Lname = '" + Lname + "',  Pnumber = '" + Pnumber + "', Email = '" + Email + "', "
                    + "Address = '" + Address + "', Day = '" + Day + "', Month = '" + Month + "', Year = '" + Year + "' "
                    + "WHERE _rowid_= '" + previousIndex + "' ";
            PreparedStatement ps5 = connection.prepareStatement(update1);
            ps5.executeUpdate();
            JOptionPane.showMessageDialog(null, "Update succeeded");
        } catch (SQLException ae) {
            JOptionPane.showMessageDialog(null, "Update failed. " + ae);
        }
    }//GEN-LAST:event_update_btnActionPerformed

    private void delete_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_btnActionPerformed
        int previousIndex = Integer.parseInt(prev_txt.getText());
        String delete_query = "DELETE FROM contacts WHERE(_rowid_ = ?) ";
        try {
            PreparedStatement ps6 = connection.prepareStatement(delete_query);
            ps6.setString(1, "" + previousIndex);
            ps6.execute();
            JOptionPane.showMessageDialog(null, "Success: " + "Contact Deleted");
        } catch (SQLException ae) {
            JOptionPane.showMessageDialog(null, ae + "Contact could not be deleted");
        }
        prev_btnActionPerformed(evt);
    }//GEN-LAST:event_delete_btnActionPerformed

    private void insertnew_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertnew_btnActionPerformed
        fName_txt.setText(" ");
        lName_txt.setText(" ");
        address_txt.setText(" ");
        email_txt.setText(" ");
        phoneNum_txt.setText(" ");
        regNum_txt.setText(" ");
        day_txt.setText(" ");
        search_txt.setText(" ");
        month_txt.setText(" ");
        year_txt.setText(" ");
    }//GEN-LAST:event_insertnew_btnActionPerformed

    private void viewcon_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewcon_btnActionPerformed
        insertnew_btnActionPerformed(evt);
        avgAge_txtActionPerformed(evt);
        fillCount();
        int previousIndex;
        int nextIndex = Integer.parseInt(next_txt.getText());
        if (nextIndex == 0) {
            previousIndex = 0;
        } else {
            previousIndex = 1;
        }
        prev_txt.setText("" + previousIndex);
        prev_txt.setText(previousIndex + "");
        String sql7 = "SELECT * FROM contacts WHERE (`_rowid_` = ?)";
        try {
            PreparedStatement ps7 = connection.prepareStatement(sql7);
            ps7.setString(1, "" + previousIndex);
            ResultSet rs7 = ps7.executeQuery();
            while (rs7.next()) {
                regNum_txt.setText(rs7.getString(1));
                phoneNum_txt.setText(rs7.getString(4));
                fName_txt.setText(rs7.getString(2));
                lName_txt.setText(rs7.getString(3));
                address_txt.setText(rs7.getString(5));
                email_txt.setText(rs7.getString(6));
                day_txt.setText(rs7.getString(7));
                month_txt.setText(rs7.getString(8));
                year_txt.setText(rs7.getString(9));
                break;
            }
        } catch (SQLException e) {

        }
    }//GEN-LAST:event_viewcon_btnActionPerformed

    private void regNum_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regNum_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_regNum_txtActionPerformed

    private void search_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search_txtActionPerformed

    private void save_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_btnActionPerformed
        String RegNum = regNum_txt.getText();
        String Fname = fName_txt.getText();
        String Lname = lName_txt.getText();
        String Pnumber = phoneNum_txt.getText();
        String Email = email_txt.getText();
        String Address = address_txt.getText();
        String Day = day_txt.getText();
        String Month = month_txt.getText();
        String Year = year_txt.getText();
        String save_query = "INSERT INTO contacts (RegNum, Fname, Lname, Pnumber, Email, Address, Day, Month, Year)"
                + " VALUES (?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement ps = connection.prepareStatement(save_query);
            ps.setString(1, RegNum);
            ps.setString(2, Fname);
            ps.setString(3, Lname);
            ps.setString(4, Pnumber);
            ps.setString(5, Email);
            ps.setString(6, Address);
            ps.setString(7, Day);
            ps.setString(8, Month);
            ps.setString(9, Year);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Success", "Contact Added", JOptionPane.INFORMATION_MESSAGE);
            String sql = "SELECT * FROM contacts";
            int count = 0;
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            fillCount();
            viewcon_btnActionPerformed(evt);
        } catch (SQLException ae) {
            JOptionPane.showMessageDialog(null, "Contact could not be added. " + ae);
        }
    }//GEN-LAST:event_save_btnActionPerformed

    private void prev_txtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_prev_txtKeyReleased
        insertnew_btnActionPerformed(null);
        int previousIndex = Integer.parseInt(prev_txt.getText());
        int nextIndex = Integer.parseInt(next_txt.getText());
        if (previousIndex > nextIndex) {
            JOptionPane.showMessageDialog(null, "Database contains only " + nextIndex + " entries");
        } else if (previousIndex <= nextIndex && previousIndex > 1) {
            String sql = "SELECT * FROM contacts WHERE `_rowid_` = ?";
             prev_txt.setText(previousIndex + "");
            try {
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setString(1, "" + previousIndex);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    regNum_txt.setText(rs.getString(1));
                    phoneNum_txt.setText(rs.getString(4));
                    fName_txt.setText(rs.getString(2));
                    lName_txt.setText(rs.getString(3));
                    address_txt.setText(rs.getString(5));
                    email_txt.setText(rs.getString(6));
                    day_txt.setText(rs.getString(7));
                    month_txt.setText(rs.getString(8));
                    year_txt.setText(rs.getString(9));
                    break;
                }
                prev_txt.setText(previousIndex + "");
            } catch (SQLException e) {
            }
        }
        else if (previousIndex == 1) {
            previousIndex = nextIndex;
             prev_txt.setText(previousIndex + "");
            String sql2String = "SELECT * FROM contacts WHERE (`_rowid_` = ?)";
            try {
                PreparedStatement ps2 = connection.prepareStatement(sql2String);
                ps2.setString(1, "" + previousIndex);
                ResultSet rs2 = ps2.executeQuery();
                insertnew_btnActionPerformed(null);
                while (rs2.next()) {
                    regNum_txt.setText(rs2.getString(1));
                    phoneNum_txt.setText(rs2.getString(4));
                    fName_txt.setText(rs2.getString(2));
                    lName_txt.setText(rs2.getString(3));
                    address_txt.setText(rs2.getString(5));
                    email_txt.setText(rs2.getString(6));
                    day_txt.setText(rs2.getString(7));
                    month_txt.setText(rs2.getString(8));
                    year_txt.setText(rs2.getString(9));
                    prev_txt.setText(previousIndex + "");
                    break;
                }
            } catch (SQLException e) {

            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Contact does not exist");
        }
    }//GEN-LAST:event_prev_txtKeyReleased

    private void fName_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fName_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fName_txtActionPerformed

    private void address_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_address_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_address_txtActionPerformed

    private void search_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_btnActionPerformed
        String Fname = search_txt.getText();
        String sql8 = "SELECT * FROM contacts WHERE (Fname = '"+Fname+"') ";
        try {
            PreparedStatement ps8 = connection.prepareStatement(sql8);
            ResultSet rs8 = ps8.executeQuery();
            while (rs8.next()) {
                insertnew_btnActionPerformed(evt);
                regNum_txt.setText(rs8.getString(1));
                fName_txt.setText(rs8.getString(2));
                lName_txt.setText(rs8.getString(3));
                phoneNum_txt.setText(rs8.getString(4));
                address_txt.setText(rs8.getString(5));
                email_txt.setText(rs8.getString(6));
                day_txt.setText(rs8.getString(7));
                month_txt.setText(rs8.getString(8));
                year_txt.setText(rs8.getString(9));
                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ContactBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_search_btnActionPerformed

    private void avgAge_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_avgAge_txtActionPerformed
        String avg = "SELECT AVG(YEAR) FROM contacts";
        int avgAGE = 0;
        Calendar localCalendar = Calendar.getInstance(TimeZone.getDefault());
        try {
            PreparedStatement ps9 = connection.prepareStatement(avg);
            ResultSet rs9 = ps9.executeQuery();
            int currentYear = localCalendar.get(Calendar.YEAR);
            String s = rs9.getString(1);
            //JOptionPane.showMessageDialog(null, s + currentYear);
            double q = 0;
            if (s == null) {
                q = 0;
            } else {
                q = Double.parseDouble(s);
                int avgYear = (int) q;
                avgAGE = currentYear - avgYear;
                avgAge_txt.setText(" " + avgAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ContactBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_avgAge_txtActionPerformed

    private void search_txtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_txtKeyReleased
        String Fname = search_txt.getText();
        String sql8 = "SELECT * FROM contacts WHERE (Fname = '" + Fname + "') ";
        try {
            PreparedStatement ps8 = connection.prepareStatement(sql8);
            ResultSet rs8 = ps8.executeQuery();
            while (rs8.next()) {
                insertnew_btnActionPerformed(null);
                regNum_txt.setText(rs8.getString(1));
                fName_txt.setText(rs8.getString(2));
                lName_txt.setText(rs8.getString(3));
                phoneNum_txt.setText(rs8.getString(4));
                address_txt.setText(rs8.getString(5));
                email_txt.setText(rs8.getString(6));
                day_txt.setText(rs8.getString(7));
                month_txt.setText(rs8.getString(8));
                year_txt.setText(rs8.getString(9));
                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ContactBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_search_txtKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField address_txt;
    private javax.swing.JTextField avgAge_txt;
    private javax.swing.JTextField day_txt;
    private javax.swing.JButton delete_btn;
    private javax.swing.JTextField email_txt;
    private javax.swing.JTextField fName_txt;
    private javax.swing.JButton insertnew_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField lName_txt;
    private javax.swing.JTextField month_txt;
    private javax.swing.JButton next_btn;
    private javax.swing.JTextField next_txt;
    private javax.swing.JTextField phoneNum_txt;
    private javax.swing.JButton prev_btn;
    private javax.swing.JTextField prev_txt;
    private javax.swing.JTextField regNum_txt;
    private javax.swing.JButton save_btn;
    private javax.swing.JButton search_btn;
    private javax.swing.JTextField search_txt;
    private javax.swing.JButton update_btn;
    private javax.swing.JButton viewcon_btn;
    private javax.swing.JTextField year_txt;
    // End of variables declaration//GEN-END:variables

    private static class RunnableImpl implements Runnable {

        public RunnableImpl() {
        }

        @Override
        public void run() {
            new ContactBook().setVisible(true);
        }
    }
}
