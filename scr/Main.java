import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        // Run GUI in the Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    Admin mainFrame = new Admin();
                    mainFrame.setVisible(true);
                } catch (Exception e) {
                    System.err.println("Error starting application: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        });
    }
}