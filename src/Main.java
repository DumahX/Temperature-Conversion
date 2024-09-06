import javax.swing.JOptionPane;

public class Main {
    private static final String PROGRAM_TITLE = "Homework 5: Temperature Conversion";
    private static final double OFFSET = 32;
    private static final double FACTOR = 1.8;

    public static void main(String[] args) {
        doConversion(
                "Enter a temperature in degrees Fahrenheit (F):",
                "The provided temperature is: %.1f degrees Celsius (C)",
                true
        );

        doConversion(
                "Enter a temperature in degrees Celsius (C):",
                "The provided temperature is %.1f degrees Fahrenheit (F)",
                false
        );
    }

    private static double convertToNumber(String numberString) {
        try {
            return Double.parseDouble(numberString);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private static String getUserInput(String inputMessage) {
        String collectedInput = JOptionPane.showInputDialog(null, inputMessage, PROGRAM_TITLE, JOptionPane.INFORMATION_MESSAGE);

        return collectedInput != null ? collectedInput : "";
    }

    private static void doConversion(String inputMessage, String resultMessage, boolean convertToCelsius) {
        double inputTemp = convertToNumber(getUserInput(inputMessage));
        double convertedTemp = convertToCelsius ? (inputTemp - OFFSET) / FACTOR : inputTemp * FACTOR + OFFSET;

        String result = String.format(resultMessage, convertedTemp);
        JOptionPane.showMessageDialog(null, result, PROGRAM_TITLE, JOptionPane.INFORMATION_MESSAGE);
    }
}