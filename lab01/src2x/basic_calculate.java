import javax.swing.JOptionPane;

public class basic_calculate {
    public static void main(String[] args){
        String strNum1, strNum2;
        double sum, dif, prod, quot;

        strNum1 = JOptionPane.showInputDialog(null, "Please input the first number: ", "Input the first number", JOptionPane.INFORMATION_MESSAGE);
        double num1 = Double.parseDouble(strNum1);
        strNum2 = JOptionPane.showInputDialog(null, "Please input the second number: ", "Input the second number", JOptionPane.INFORMATION_MESSAGE);
        double num2 = Double.parseDouble(strNum2);

        sum = num1 + num2;
        String strSum = String.valueOf(sum);

        dif = num1 - num2;
        String strDif = String.valueOf(dif);

        prod = num1 * num2;
        String strProd = String.valueOf(prod);

        quot = num1 / num2;
        String strQuot = String.valueOf(quot);

        JOptionPane.showMessageDialog(null, strSum, "Show sum of two numbers", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, strDif, "Show difference of two numbers", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, strProd, "Show product of two numbers", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, strQuot, "Show quotient of two numbers", JOptionPane.INFORMATION_MESSAGE);
        
        System.exit(0);
    } 
}