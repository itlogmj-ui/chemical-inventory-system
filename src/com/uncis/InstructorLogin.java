package com.uncis;

import javax.swing.*;
import java.awt.*;

/**
 * Instructor Login Frame that integrates with Registration
 * @author JOCELLE
 */
public class InstructorLogin extends javax.swing.JInternalFrame {
    private RegistrationApp registrationApp;

    /**
     * Creates new form InstructorLogin
     */
    public InstructorLogin() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setTitle("LabChem Inventory Management System - Instructor Login");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setVisible(true);

        jTextField1.setText("Email");
        jTextField1.addActionListener(this::jTextField1ActionPerformed);

        jTextField2.setText("Password");
        jTextField2.addActionListener(this::jTextField2ActionPerformed);

        jToggleButton1.setText("Login");
        jToggleButton1.setBackground(new Color(141, 16, 16));
        jToggleButton1.setForeground(Color.WHITE);
        jToggleButton1.setFont(new Font("SansSerif", Font.BOLD, 14));
        jToggleButton1.addActionListener(this::jToggleButton1ActionPerformed);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18));
        jLabel1.setText("Instructor Login");

        jLabel2.setText("Don't have account?");

        jButton1.setText("Register");
        jButton1.setBackground(new Color(177, 111, 223));
        jButton1.setForeground(Color.WHITE);
        jButton1.setFont(new Font("SansSerif", Font.BOLD, 12));
        jButton1.addActionListener(this::jButton1ActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(209, 209, 209)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                            .addComponent(jTextField1)
                            .addComponent(jToggleButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(307, 307, 307)
                        .addComponent(jLabel1)))
                .addContainerGap(246, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jButton1))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        pack();
    }

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
        // Handle email field action
    }

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {
        // Handle password field action
    }

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        String email = jTextField1.getText().trim();
        String password = jTextField2.getText().trim();

        if (email.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                \"Please enter both email and password.\", 
                \"Login Error\", 
                JOptionPane.ERROR_MESSAGE);
            return;
        }

        // TODO: Add authentication logic here
        JOptionPane.showMessageDialog(this, 
            \"Login successful for: \" + email, 
            \"Login\", 
            JOptionPane.INFORMATION_MESSAGE);
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // Open the registration window
        SwingUtilities.invokeLater(() -> {
            registrationApp = new RegistrationApp();
            registrationApp.showWindow();
        });
    }

    // Variables declaration
    public javax.swing.JButton jButton1;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JTextField jTextField1;
    public javax.swing.JTextField jTextField2;
    public javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration
}
