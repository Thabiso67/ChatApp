/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.chatapp;

import javax.swing.JOptionPane;

public class ChatApp {

    private static final String[] usernames = new String[1];
    private static final String[] passwords = new String[1];
    private static final String[] contacts = new String[1];  

    public static void main(String[] args) {
        for (int i = 0; i < usernames.length; i++) {
            String username = JOptionPane.showInputDialog("Register username for User"  + ":");

            String password;
            while (true) {
                password = JOptionPane.showInputDialog("""
                                                       Register password for User:
                                                       - At least 8 characters
                                                       - 1 Capital Letter
                                                       - 1 Number
                                                       - 1 Special Character""");

                if (isValidPassword(password)) {
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "Password does not meet requirements. Please try again.");
                }
            }

            // Prompt for contact number
            String contact;
            while (true) {
                contact = JOptionPane.showInputDialog("Enter contact number (must start with +27 and be no more than 10 digits after +27):");

                if (isValidContact(contact)) {
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid contact number. Please enter a valid South African number.");
                }
            }

            usernames[i] = username;
            passwords[i] = password;
            contacts[i] = contact;  // Store contact
        }

        String loginUser = JOptionPane.showInputDialog("Login - Enter username:");
        String loginPass = JOptionPane.showInputDialog("Login - Enter password:");

        boolean loggedIn = false;
        for (int i = 0; i < usernames.length; i++) {
            if (usernames[i].equals(loginUser) && passwords[i].equals(loginPass)) {
                loggedIn = true;
                break;
            }
        }

        if (loggedIn) {
            JOptionPane.showMessageDialog(null, "Login successful!");
        } else {
            JOptionPane.showMessageDialog(null, "Login failed!");
        }
    }

    // Password validation
    public static boolean isValidPassword(String password) {
        if (password == null || password.length() < 8) return false;
        boolean hasUpper = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpper = true;
            else if (Character.isDigit(c)) hasDigit = true;
            else if (!Character.isLetterOrDigit(c)) hasSpecial = true;
        }

        return hasUpper && hasDigit && hasSpecial;
    }

    // Contact number validation method
    public static boolean isValidContact(String contact) {
        if (contact == null) return false;
        if (!contact.startsWith("+27")) return false;

        String digitsOnly = contact.substring(3); // remove +27
        if (digitsOnly.length() > 10 || digitsOnly.length() == 0) return false;

        // Ensure the rest are digits
        for (char c : digitsOnly.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }

        return true;
    }
}