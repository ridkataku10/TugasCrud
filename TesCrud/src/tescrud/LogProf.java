/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tescrud;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author sistem
 */
public class LogProf {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new Login();
    }

}

class Login extends JFrame {

    JLabel user = new JLabel("Username");
    JLabel pass = new JLabel("Password");
    JTextField us = new JTextField(20);
    JTextField pa = new JTextField(20);
    JButton log = new JButton("Login");
    JButton can = new JButton("Cancel");

    Login() {
        setTitle("Yok Login Yok!");
        setSize(350, 200);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(user);
        add(us);
        add(pass);
        add(pa);
        add(log);
        add(can);

        log.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username, password;
                username = us.getText();
                password = pa.getText();
                if (username.length() == 0 && password.length() == 0) {
                    JOptionPane.showMessageDialog(null, "Username/Password tidak boleh kosong!");
                } 
                else if (username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin123") ){
                    new MVC();
                }
                else
                    JOptionPane.showMessageDialog(null, "Username/Password anda salah!");

            }
        });

        can.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pa.setText(null);
            }
        });
        setVisible(true);
    }
}
