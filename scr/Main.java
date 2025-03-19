import java.util.Scanner;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        // Create a Scanner to get user input
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter role (0 for Admin, 1 for MainFrame):");
        int role = sc.nextInt();

        // Run GUI in the Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    if (role == 0) {
                        // Run Admin frame
                        Admin admin = new Admin();
                        admin.setVisible(true);
                    } else if (role == 1) {
                        // Run MainFrame
                        MainFrame mainFrame = new MainFrame();
                        mainFrame.setVisible(true);
                    } else {
                        System.out.println("Invalid role! Please enter 0 for Admin or 1 for MainFrame.");
                    }
                } catch (Exception e) {
                    System.err.println("Error starting application: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        });

        // Close the scanner
        sc.close();
    }
}