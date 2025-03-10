package frames;

import database_connection.DatabaseManager;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author root
 */
public class ProfileFrame extends javax.swing.JInternalFrame {
    private DatabaseManager database;
    private int counter = 1;
    
    /**
     * Creates new form ProfileFrame
     */
    public ProfileFrame(DatabaseManager database) {
        this.database = database;
        initComponents();
        this.errorMessage.setForeground(Color.red);
        this.errorMessage.setVisible(true);
        showOption(false); 
        setBasicInformations();
    }
    public void setBasicInformations(){
        username.setText("Username: "+database.user.getUsername());
        email.setText("Email: "+database.user.getEmail());
    }
    public void showOption(boolean option){
        changeButton.setVisible(option);
        newPassword.setVisible(option);
        newPasswordT.setVisible(option);
        oldPassword.setVisible(option);
        oldPasswordT.setVisible(option);
        passwordAgain.setVisible(option);
        passwordAgainT.setVisible(option);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        username = new javax.swing.JLabel();
        email = new javax.swing.JLabel();
        info = new javax.swing.JLabel();
        password = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        oldPassword = new javax.swing.JLabel();
        newPassword = new javax.swing.JLabel();
        passwordAgain = new javax.swing.JLabel();
        oldPasswordT = new javax.swing.JPasswordField();
        newPasswordT = new javax.swing.JPasswordField();
        passwordAgainT = new javax.swing.JPasswordField();
        changeButton = new javax.swing.JButton();
        errorMessage = new javax.swing.JLabel();

        setClosable(true);

        username.setText("jLabel1");

        email.setText("jLabel1");

        info.setText("Basic Informations: ");

        password.setText("Password: ");

        jButton1.setText("change password");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        oldPassword.setText("Old password:");

        newPassword.setText("new password: ");

        passwordAgain.setText("password again:");

        changeButton.setText("Change");
        changeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                changeButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(errorMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(email)
                            .addComponent(info)
                            .addComponent(password)
                            .addComponent(jButton1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(oldPassword)
                                    .addComponent(newPassword)
                                    .addComponent(passwordAgain))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(changeButton)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(oldPasswordT, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                                        .addComponent(newPasswordT)
                                        .addComponent(passwordAgainT)))))
                        .addGap(0, 144, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(info)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(email)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(password)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(oldPasswordT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(oldPassword))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(newPasswordT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newPassword))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordAgain)
                    .addComponent(passwordAgainT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(changeButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorMessage, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        if(counter%2!=0){
            showOption(true);
        }else{
            showOption(false);
        }
        counter++;
    }//GEN-LAST:event_jButton1MouseClicked

    private void changeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changeButtonMouseClicked
        String oldPassword = oldPasswordT.getText();
        String newPassword = newPasswordT.getText();
        String againPassword = passwordAgainT.getText();
        if(oldPassword.equals(database.user.getPassword())){
            if(newPassword.length()>=7 && newPassword.length()<=15){
                if(newPassword.equals(againPassword)){
                    errorMessage.setText("");
                    try {
                        PreparedStatement newPasswordUpdate = database.Update("users","password","'"+newPassword+"'",
                                "username = "+"'"+database.user.getUsername()+"'");
                        if(newPasswordUpdate.executeUpdate()==1){
                            JOptionPane.showMessageDialog(this,"Changed password successfuly.");
                        }
                        oldPasswordT.setText("");
                        newPasswordT.setText("");
                        passwordAgainT.setText("");
                        showOption(false);
                    } catch (SQLException ex) {
                        Logger.getLogger(ProfileFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{
                    errorMessage.setText("Passwords do not match.");
                }
            }else{
                errorMessage.setText("Password length must be between 7 and 15.");
            }
        }else{
            errorMessage.setText("Old password is not correct.");
        }
    }//GEN-LAST:event_changeButtonMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton changeButton;
    private javax.swing.JLabel email;
    private javax.swing.JLabel errorMessage;
    private javax.swing.JLabel info;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel newPassword;
    private javax.swing.JPasswordField newPasswordT;
    private javax.swing.JLabel oldPassword;
    private javax.swing.JPasswordField oldPasswordT;
    private javax.swing.JLabel password;
    private javax.swing.JLabel passwordAgain;
    private javax.swing.JPasswordField passwordAgainT;
    private javax.swing.JLabel username;
    // End of variables declaration//GEN-END:variables
}