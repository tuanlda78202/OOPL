import javax.swing.JOptionPane;
public class HelloNameDialog {
    public static void main(String[] args){
        String result;
        result = javax.swing.JOptionPane.showInputDialog("Please enter your name:");
        javax.swing.JOptionPane.showMessageDialog(null, "Hi " + result + "!");
        System.exit(0);
    }
}
