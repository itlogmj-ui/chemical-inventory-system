package Avendano;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.regex.Pattern;

/**
 * Complete one-file Java Swing application.
 *
 * Compile:
 *   javac -d out MainApp.java
 * Run:
 *   java -cp out Avendano.MainApp
 *
 * In VS Code, save this file as:
 *   src/Avendano/MainApp.java
 */
public class MainApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new InstructorLogin().setVisible(true));
    }

    // ---------------- Instructor Login ----------------
    private static class InstructorLogin extends JFrame {
        private final JTextField emailField = new JTextField();
        private final JPasswordField passwordField = new JPasswordField();

        InstructorLogin() {
            setTitle("LabChem Inventory Management System - Instructor Login");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(550, 430);
            setLocationRelativeTo(null);
            setResizable(false);

            JPanel panel = new JPanel(new GridBagLayout());
            panel.setBackground(new Color(177, 111, 223));
            panel.setBorder(new EmptyBorder(35, 80, 35, 80));
            GridBagConstraints c = new GridBagConstraints();
            c.gridx = 0;
            c.fill = GridBagConstraints.HORIZONTAL;
            c.weightx = 1;
            c.insets = new Insets(8, 0, 8, 0);

            JLabel heading = new JLabel("Instructor Login", SwingConstants.CENTER);
            heading.setFont(new Font("Times New Roman", Font.BOLD, 24));
            heading.setForeground(Color.WHITE);
            c.gridy = 0;
            panel.add(heading, c);

            emailField.setText("");
            emailField.setToolTipText("Email");
            emailField.setBorder(BorderFactory.createTitledBorder("Email"));
            c.gridy++;
            panel.add(emailField, c);

            passwordField.setToolTipText("Password");
            passwordField.setBorder(BorderFactory.createTitledBorder("Password"));
            c.gridy++;
            panel.add(passwordField, c);

            JButton loginButton = new JButton("Login");
            loginButton.setBackground(new Color(141, 16, 16));
            loginButton.setForeground(Color.WHITE);
            loginButton.setFont(new Font("SansSerif", Font.BOLD, 14));
            loginButton.addActionListener(e -> login());
            c.gridy++;
            panel.add(loginButton, c);

            JPanel registerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            registerPanel.setOpaque(false);
            JLabel question = new JLabel("Don't have an account?");
            question.setForeground(Color.WHITE);
            JButton registerButton = new JButton("Register");
            registerButton.setBackground(new Color(120, 45, 170));
            registerButton.setForeground(Color.WHITE);
            registerButton.addActionListener(e -> new RegistrationApp(this).setVisible(true));
            registerPanel.add(question);
            registerPanel.add(registerButton);
            c.gridy++;
            panel.add(registerPanel, c);

            add(panel);
        }

        private void login() {
            String email = emailField.getText().trim();
            String password = new String(passwordField.getPassword()).trim();
            if (email.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter both email and password.",
                        "Login Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            JOptionPane.showMessageDialog(this, "Login successful for: " + email,
                    "Login", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // ---------------- Instructor Registration ----------------
    private static class RegistrationApp extends JFrame {
        private static final Pattern EMAIL = Pattern.compile("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$");
        private final JTextField lastName = new JTextField();
        private final JTextField firstName = new JTextField();
        private final JTextField middleName = new JTextField();
        private final JTextField idNumber = new JTextField();
        private final JTextField contactNumber = new JTextField();
        private final JTextField email = new JTextField();
        private final JTextField username = new JTextField();
        private final JPasswordField password = new JPasswordField();
        private final JPasswordField confirmPassword = new JPasswordField();

        RegistrationApp(JFrame owner) {
            super("Register — Instructor");
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setSize(650, 780);
            setLocationRelativeTo(owner);
            add(createForm());
        }

        private JPanel createForm() {
            JPanel background = new JPanel(new GridBagLayout());
            background.setBackground(new Color(125, 75, 210));

            JPanel card = new JPanel(new GridBagLayout());
            card.setBackground(new Color(177, 111, 223));
            card.setBorder(new EmptyBorder(25, 35, 25, 35));
            GridBagConstraints c = new GridBagConstraints();
            c.gridx = 0;
            c.weightx = 1;
            c.fill = GridBagConstraints.HORIZONTAL;
            c.insets = new Insets(5, 0, 5, 0);

            JLabel university = heading("UNIVERSITY OF CAMARINES NORTE", 16);
            c.gridy = 0;
            card.add(university, c);
            JLabel title = heading("Chemical Inventory and Management System", 17);
            c.gridy++;
            card.add(title, c);
            JLabel section = heading("Register — Instructor", 15);
            c.gridy++;
            card.add(section, c);

            JPanel names = new JPanel(new GridLayout(1, 3, 8, 0));
            names.setOpaque(false);
            names.add(field("Last Name", lastName));
            names.add(field("First Name", firstName));
            names.add(field("Middle Name", middleName));
            c.gridy++;
            card.add(names, c);

            JPanel identifiers = new JPanel(new GridLayout(1, 2, 8, 0));
            identifiers.setOpaque(false);
            identifiers.add(field("ID Number", idNumber));
            identifiers.add(field("Contact No.", contactNumber));
            c.gridy++;
            card.add(identifiers, c);

            c.gridy++;
            card.add(field("Email", email), c);
            c.gridy++;
            card.add(field("Username", username), c);
            c.gridy++;
            card.add(passwordField("Password", password), c);
            c.gridy++;
            card.add(passwordField("Confirm Password", confirmPassword), c);

            JButton create = new JButton("Create Account");
            create.setBackground(new Color(141, 16, 16));
            create.setForeground(Color.WHITE);
            create.setFont(new Font("SansSerif", Font.BOLD, 15));
            create.addActionListener(e -> register());
            c.gridy++;
            c.insets = new Insets(14, 0, 5, 0);
            card.add(create, c);

            JButton back = new JButton("← Back to Login");
            back.setContentAreaFilled(false);
            back.setBorderPainted(false);
            back.setForeground(Color.WHITE);
            back.addActionListener(e -> dispose());
            c.gridy++;
            c.insets = new Insets(2, 0, 2, 0);
            card.add(back, c);

            background.add(card);
            return background;
        }

        private JLabel heading(String text, int size) {
            JLabel label = new JLabel(text, SwingConstants.CENTER);
            label.setForeground(Color.WHITE);
            label.setFont(new Font("SansSerif", Font.BOLD, size));
            return label;
        }

        private JPanel field(String title, JTextField input) {
            JPanel panel = new JPanel(new BorderLayout(0, 3));
            panel.setOpaque(false);
            JLabel label = new JLabel(title);
            label.setForeground(Color.WHITE);
            label.setFont(new Font("SansSerif", Font.BOLD, 13));
            input.setPreferredSize(new Dimension(100, 38));
            input.setToolTipText(title);
            panel.add(label, BorderLayout.NORTH);
            panel.add(input, BorderLayout.CENTER);
            return panel;
        }

        private JPanel passwordField(String title, JPasswordField input) {
            JPanel panel = field(title, input);
            JCheckBox show = new JCheckBox("Show");
            show.setOpaque(false);
            show.setForeground(Color.WHITE);
            show.addActionListener(e -> input.setEchoChar(show.isSelected() ? (char) 0 : '•'));
            panel.add(show, BorderLayout.EAST);
            return panel;
        }

        private void register() {
            String pass = new String(password.getPassword());
            String confirm = new String(confirmPassword.getPassword());
            if (lastName.getText().isBlank() || firstName.getText().isBlank()
                    || idNumber.getText().isBlank() || email.getText().isBlank()
                    || username.getText().isBlank() || pass.isBlank()) {
                error("Please complete all required fields.");
            } else if (!EMAIL.matcher(email.getText().trim()).matches()) {
                error("Please enter a valid email address.");
            } else if (pass.length() < 6) {
                error("Password must contain at least 6 characters.");
            } else if (!pass.equals(confirm)) {
                error("Passwords do not match.");
            } else {
                JOptionPane.showMessageDialog(this, "Instructor account created successfully.",
                        "Registration Complete", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        private void error(String message) {
            JOptionPane.showMessageDialog(this, message, "Registration Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
