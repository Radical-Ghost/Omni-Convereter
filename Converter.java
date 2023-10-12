import java.text.DecimalFormat;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class Converter {
    double inputValue, outputValue;
    JTextField IText, OText;
    JComboBox<String> toUnit, fromUnit;
    int temp;
    
    Converter(JTextField IText,JTextField OText,JComboBox<String> fromUnit,JComboBox<String> toUnit,int temp){
        this.IText = IText;
        this.OText = OText;
        this.fromUnit = fromUnit;
        this.toUnit = toUnit;
        this.temp = temp;
    }

    void textOutput(){
        DecimalFormat decimalFormat = new DecimalFormat("#.###");
        String formattedOutputValue = decimalFormat.format(outputValue);
        if (formattedOutputValue.endsWith(".000")) {
            formattedOutputValue = formattedOutputValue.substring(0, formattedOutputValue.indexOf("."));
        }

        OText.setText(formattedOutputValue);
    }

    void lengthConverter(){
        inputValue = Double.parseDouble(IText.getText());
        String convertFrom = fromUnit.getSelectedItem().toString();
        String convertTo = toUnit.getSelectedItem().toString();

        switch (convertFrom) {
            case "mm":
                switch (convertTo) {
                    case "mm":
                        outputValue = inputValue;
                        break;
                    case "cm":
                        outputValue = inputValue / 10.0;
                        break;
                    case "m":
                        outputValue = inputValue / 1000.0;
                        break;
                    case "km":
                        outputValue = inputValue / 1000000.0;
                        break;
                    case "in":
                        outputValue = inputValue / 25.4;
                        break;
                    case "ft":
                        outputValue = inputValue / 304.8;
                        break;
                }
                break;
            case "cm":
                switch (convertTo) {
                    case "mm":
                        outputValue = inputValue * 10.0;
                        break;
                    case "cm":
                        outputValue = inputValue;
                        break;
                    case "m":
                        outputValue = inputValue / 100.0;
                        break;
                    case "km":
                        outputValue = inputValue / 100000.0;
                        break;
                    case "in":
                        outputValue = inputValue / 2.54;
                        break;
                    case "ft":
                        outputValue = inputValue / 30.48;
                        break;
                }
                break;
            case "m":
                switch (convertTo) {
                    case "mm":
                        outputValue = inputValue * 1000.0;
                        break;
                    case "cm":
                        outputValue = inputValue * 100.0;
                        break;
                    case "m":
                        outputValue = inputValue;
                        break;
                    case "km":
                        outputValue = inputValue / 1000.0;
                        break;
                    case "in":
                        outputValue = inputValue / 0.0254;
                        break;
                    case "ft":
                        outputValue = inputValue / 0.3048;
                        break;
                }
                break;
            case "km":
                switch (convertTo) {
                    case "mm":
                        outputValue = inputValue * 1000000.0;
                        break;
                    case "cm":
                        outputValue = inputValue * 100000.0;
                        break;
                    case "m":
                        outputValue = inputValue * 1000.0;
                        break;
                    case "km":
                        outputValue = inputValue;
                        break;
                    case "in":
                        outputValue = inputValue / 0.0000254;
                        break;
                    case "ft":
                        outputValue = inputValue / 0.0003048;
                        break;
                }
                break;
            case "in":
                switch (convertTo) {
                    case "mm":
                        outputValue = inputValue * 25.4;
                        break;
                    case "cm":
                        outputValue = inputValue * 2.54;
                        break;
                    case "m":
                        outputValue = inputValue * 0.0254;
                        break;
                    case "km":
                        outputValue = inputValue * 0.0000254;
                        break;
                    case "in":
                        outputValue = inputValue;
                        break;
                    case "ft":
                        outputValue = inputValue / 12.0;
                        break;
                }
                break;
            case "ft":
                switch (convertTo) {
                    case "mm":
                        outputValue = inputValue * 304.8;
                        break;
                    case "cm":
                        outputValue = inputValue * 30.48;
                        break;
                    case "m":
                        outputValue = inputValue * 0.3048;
                        break;
                    case "km":
                        outputValue = inputValue * 0.0003048;
                        break;
                    case "in":
                        outputValue = inputValue * 12.0;
                        break;
                    case "ft":
                        outputValue = inputValue;
                        break;
                }
                break;
        }

        textOutput();
    }

    void areaConverter() {
        inputValue = Double.parseDouble(IText.getText());
        String convertFrom = fromUnit.getSelectedItem().toString();
        String convertTo = toUnit.getSelectedItem().toString();

        switch (convertFrom) {
            case "sq mm":
                switch (convertTo) {
                    case "sq mm":
                        outputValue = inputValue;
                        break;
                    case "sq cm":
                        outputValue = inputValue / 100.0;
                        break;
                    case "sq m":
                        outputValue = inputValue / 1000000.0;
                        break;
                    case "sq km":
                        outputValue = inputValue / 1000000000000.0;
                        break;
                    case "sq in":
                        outputValue = inputValue / 645.16;
                        break;
                    case "sq ft":
                        outputValue = inputValue / 92903.04;
                        break;
                    case "acre":
                        outputValue = inputValue / 4046856422.4;
                        break;
                }
                break;
            case "sq cm":
                switch (convertTo) {
                    case "sq mm":
                        outputValue = inputValue * 100.0;
                        break;
                    case "sq cm":
                        outputValue = inputValue;
                        break;
                    case "sq m":
                        outputValue = inputValue / 10000.0;
                        break;
                    case "sq km":
                        outputValue = inputValue / 10000000000.0;
                        break;
                    case "sq in":
                        outputValue = inputValue / 6.4516;
                        break;
                    case "sq ft":
                        outputValue = inputValue / 929.0304;
                        break;
                    case "acre":
                        outputValue = inputValue / 40468542.24;
                        break;
                }
                break;
            case "sq m":
                switch (convertTo) {
                    case "sq mm":
                        outputValue = inputValue * 1000000.0;
                        break;
                    case "sq cm":
                        outputValue = inputValue * 10000.0;
                        break;
                    case "sq m":
                        outputValue = inputValue;
                        break;
                    case "sq km":
                        outputValue = inputValue / 1000000.0;
                        break;
                    case "sq in":
                        outputValue = inputValue / 0.00064516;
                        break;
                    case "sq ft":
                        outputValue = inputValue / 10.763910417;
                        break;
                    case "acre":
                        outputValue = inputValue / 4046.8564224;
                        break;
                }
                break;
            case "sq km":
                switch (convertTo) {
                    case "sq mm":
                        outputValue = inputValue * 1000000000000.0;
                        break;
                    case "sq cm":
                        outputValue = inputValue * 10000000000.0;
                        break;
                    case "sq m":
                        outputValue = inputValue * 1000000.0;
                        break;
                    case "sq km":
                        outputValue = inputValue;
                        break;
                    case "sq in":
                        outputValue = inputValue / 0.00000064516;
                        break;
                    case "sq ft":
                        outputValue = inputValue / 0.000010763910417;
                        break;
                    case "acre":
                        outputValue = inputValue / 0.0040468564224;
                        break;
                }
                break;
            case "sq in":
                switch (convertTo) {
                    case "sq mm":
                        outputValue = inputValue * 645.16;
                        break;
                    case "sq cm":
                        outputValue = inputValue * 6.4516;
                        break;
                    case "sq m":
                        outputValue = inputValue * 0.00064516;
                        break;
                    case "sq km":
                        outputValue = inputValue * 0.00000000064516;
                        break;
                    case "sq in":
                        outputValue = inputValue;
                        break;
                    case "sq ft":
                        outputValue = inputValue / 144.0;
                        break;
                    case "acre":
                        outputValue = inputValue / 6272640.0;
                        break;
                }
                break;
            case "sq ft":
                switch (convertTo) {
                    case "sq mm":
                        outputValue = inputValue * 92903.04;
                        break;
                    case "sq cm":
                        outputValue = inputValue * 929.0304;
                        break;
                    case "sq m":
                        outputValue = inputValue * 0.09290304;
                        break;
                    case "sq km":
                        outputValue = inputValue * 0.00000009290304;
                        break;
                    case "sq in":
                        outputValue = inputValue * 144.0;
                        break;
                    case "sq ft":
                        outputValue = inputValue;
                        break;
                    case "acre":
                        outputValue = inputValue / 43560.0;
                        break;
                }
                break;
            case "acre":
                switch (convertTo) {
                    case "sq mm":
                        outputValue = inputValue * 4046856422.4;
                        break;
                    case "sq cm":
                        outputValue = inputValue * 40468542.24;
                        break;
                    case "sq m":
                        outputValue = inputValue * 4046.8564224;
                        break;
                    case "sq km":
                        outputValue = inputValue * 0.0040468564224;
                        break;
                    case "sq in":
                        outputValue = inputValue * 6272640.0;
                        break;
                    case "sq ft":
                        outputValue = inputValue * 43560.0;
                        break;
                    case "acre":
                        outputValue = inputValue;
                        break;
                }
                break;
        }

        textOutput();
    }

    void weightConverter() {
        inputValue = Double.parseDouble(IText.getText());
        String convertFrom = fromUnit.getSelectedItem().toString();
        String convertTo = toUnit.getSelectedItem().toString();

        switch (convertFrom) {
            case "mg":
                switch (convertTo) {
                    case "mg":
                        outputValue = inputValue;
                        break;
                    case "g":
                        outputValue = inputValue / 1000.0;
                        break;
                    case "kg":
                        outputValue = inputValue / 1000000.0;
                        break;
                    case "tonne":
                        outputValue = inputValue / 1000000000.0;
                        break;
                    case "lb":
                        outputValue = inputValue / 453592.37;
                        break;
                    case "oz":
                        outputValue = inputValue / 28349.5231;
                        break;
                }
                break;
            case "g":
                switch (convertTo) {
                    case "mg":
                        outputValue = inputValue * 1000.0;
                        break;
                    case "g":
                        outputValue = inputValue;
                        break;
                    case "kg":
                        outputValue = inputValue / 1000.0;
                        break;
                    case "tonne":
                        outputValue = inputValue / 1000000.0;
                        break;
                    case "lb":
                        outputValue = inputValue / 453.59237;
                        break;
                    case "oz":
                        outputValue = inputValue / 28.3495231;
                        break;
                }
                break;
            case "kg":
                switch (convertTo) {
                    case "mg":
                        outputValue = inputValue * 1000000.0;
                        break;
                    case "g":
                        outputValue = inputValue * 1000.0;
                        break;
                    case "kg":
                        outputValue = inputValue;
                        break;
                    case "tonne":
                        outputValue = inputValue / 1000.0;
                        break;
                    case "lb":
                        outputValue = inputValue * 2.20462;
                        break;
                    case "oz":
                        outputValue = inputValue * 35.27396;
                        break;
                }
                break;
            case "tonne":
                switch (convertTo) {
                    case "mg":
                        outputValue = inputValue * 1000000000.0;
                        break;
                    case "g":
                        outputValue = inputValue * 1000000.0;
                        break;
                    case "kg":
                        outputValue = inputValue * 1000.0;
                        break;
                    case "tonne":
                        outputValue = inputValue;
                        break;
                    case "lb":
                        outputValue = inputValue * 2204.62;
                        break;
                    case "oz":
                        outputValue = inputValue * 35273.96;
                        break;
                }
                break;
            case "lb":
                switch (convertTo) {
                    case "mg":
                        outputValue = inputValue * 453592.37;
                        break;
                    case "g":
                        outputValue = inputValue * 453.59237;
                        break;
                    case "kg":
                        outputValue = inputValue / 2.20462;
                        break;
                    case "tonne":
                        outputValue = inputValue / 2204.62;
                        break;
                    case "lb":
                        outputValue = inputValue;
                        break;
                    case "oz":
                        outputValue = inputValue * 16.0;
                        break;
                }
                break;
            case "oz":
                switch (convertTo) {
                    case "mg":
                        outputValue = inputValue * 28349.5231;
                        break;
                    case "g":
                        outputValue = inputValue * 28.3495231;
                        break;
                    case "kg":
                        outputValue = inputValue / 35.27396;
                        break;
                    case "tonne":
                        outputValue = inputValue / 35273.96;
                        break;
                    case "lb":
                        outputValue = inputValue / 16.0;
                        break;
                    case "oz":
                        outputValue = inputValue;
                        break;
                }
                break;
        }

        textOutput();
    }

    void temperatureConverter() {
        inputValue = Double.parseDouble(IText.getText());
        String convertFrom = fromUnit.getSelectedItem().toString();
        String convertTo = toUnit.getSelectedItem().toString();

        switch (convertFrom) {
            case "Celsius":
                switch (convertTo) {
                    case "Celsius":
                        outputValue = inputValue;
                        break;
                    case "Fahrenheit":
                        outputValue = (inputValue * 9.0 / 5.0) + 32.0;
                        break;
                    case "Kelvin":
                        outputValue = inputValue + 273.15;
                        break;
                }
                break;
            case "Fahrenheit":
                switch (convertTo) {
                    case "Celsius":
                        outputValue = (inputValue - 32.0) * 5.0 / 9.0;
                        break;
                    case "Fahrenheit":
                        outputValue = inputValue;
                        break;
                    case "Kelvin":
                        outputValue = (inputValue + 459.67) * 5.0 / 9.0;
                        break;
                }
                break;
            case "Kelvin":
                switch (convertTo) {
                    case "Celsius":
                        outputValue = inputValue - 273.15;
                        break;
                    case "Fahrenheit":
                        outputValue = (inputValue * 9.0 / 5.0) - 459.67;
                        break;
                    case "Kelvin":
                        outputValue = inputValue;
                        break;
                }
                break;
        }
        textOutput();
    }

    void pressureConverter() {
        inputValue = Double.parseDouble(IText.getText());
        String convertFrom = fromUnit.getSelectedItem().toString();
        String convertTo = toUnit.getSelectedItem().toString();

        switch (convertFrom) {
            case "Pa":
                switch (convertTo) {
                    case "Pa":
                        outputValue = inputValue;
                        break;
                    case "kPa":
                        outputValue = inputValue / 1000.0;
                        break;
                    case "bar":
                        outputValue = inputValue / 100000.0;
                        break;
                    case "psi":
                        outputValue = inputValue / 6894.757;
                        break;
                }
                break;
            case "kPa":
                switch (convertTo) {
                    case "Pa":
                        outputValue = inputValue * 1000.0;
                        break;
                    case "kPa":
                        outputValue = inputValue;
                        break;
                    case "bar":
                        outputValue = inputValue / 100.0;
                        break;
                    case "psi":
                        outputValue = inputValue / 6.894757;
                        break;
                }
                break;
            case "bar":
                switch (convertTo) {
                    case "Pa":
                        outputValue = inputValue * 100000.0;
                        break;
                    case "kPa":
                        outputValue = inputValue * 100.0;
                        break;
                    case "bar":
                        outputValue = inputValue;
                        break;
                    case "psi":
                        outputValue = inputValue * 14.50377;
                        break;
                }
                break;
            case "psi":
                switch (convertTo) {
                    case "Pa":
                        outputValue = inputValue * 6894.757;
                        break;
                    case "kPa":
                        outputValue = inputValue * 6.894757;
                        break;
                    case "bar":
                        outputValue = inputValue / 14.50377;
                        break;
                    case "psi":
                        outputValue = inputValue;
                        break;
                }
                break;
        }

        textOutput();
    }

    void timeConverter() {
        inputValue = Double.parseDouble(IText.getText());
        String convertFrom = fromUnit.getSelectedItem().toString();
        String convertTo = toUnit.getSelectedItem().toString();

        switch (convertFrom) {
            case "sec":
                switch (convertTo) {
                    case "sec":
                        outputValue = inputValue;
                        break;
                    case "min":
                        outputValue = inputValue / 60.0;
                        break;
                    case "hr":
                        outputValue = inputValue / 3600.0;
                        break;
                }
                break;
            case "min":
                switch (convertTo) {
                    case "sec":
                        outputValue = inputValue * 60.0;
                        break;
                    case "min":
                        outputValue = inputValue;
                        break;
                    case "hr":
                        outputValue = inputValue / 60.0;
                        break;
                }
                break;
            case "hr":
                switch (convertTo) {
                    case "sec":
                        outputValue = inputValue * 3600.0;
                        break;
                    case "min":
                        outputValue = inputValue * 60.0;
                        break;
                    case "hr":
                        outputValue = inputValue;
                        break;
                }
                break;
        }

        textOutput();
    }

    void speedConverter() {
        inputValue = Double.parseDouble(IText.getText());
        String convertFrom = fromUnit.getSelectedItem().toString();
        String convertTo = toUnit.getSelectedItem().toString();

        switch (convertFrom) {
            case "m/s":
                switch (convertTo) {
                    case "m/s":
                        outputValue = inputValue;
                        break;
                    case "km/h":
                        outputValue = inputValue * 3.6;
                        break;
                    case "mph":
                        outputValue = inputValue * 2.23694;
                        break;
                }
                break;
            case "km/h":
                switch (convertTo) {
                    case "m/s":
                        outputValue = inputValue / 3.6;
                        break;
                    case "km/h":
                        outputValue = inputValue;
                        break;
                    case "mph":
                        outputValue = inputValue / 1.60934;
                        break;
                }
                break;
            case "mph":
                switch (convertTo) {
                    case "m/s":
                        outputValue = inputValue / 2.23694;
                        break;
                    case "km/h":
                        outputValue = inputValue * 1.60934;
                        break;
                    case "mph":
                        outputValue = inputValue;
                        break;
                }
                break;
        }

        textOutput();
    }

    void numberConverter() {
        inputValue = Double.parseDouble(IText.getText());
        String convertFrom = fromUnit.getSelectedItem().toString();
        String convertTo = toUnit.getSelectedItem().toString();

        switch (convertFrom) {
            case "Binary":
                switch (convertTo) {
                    case "Binary":
                        outputValue = inputValue;
                        break;
                    case "Octal":
                        break;
                    case "Decimal":
                        break;
                    case "Hexadecimal":
                        break;
                }
                break;
            case "Octal":
                switch (convertTo) {
                    case "Binary":
                        break;
                    case "Octal":
                        outputValue = inputValue;
                        break;
                    case "Decimal":
                        break;
                    case "Hexadecimal":
                        break;
                }
                break;
            case "Decimal":
                switch (convertTo) {
                    case "Binary":
                        break;
                    case "Octal":
                        break;
                    case "Decimal":
                        outputValue = inputValue;
                        break;
                    case "Hexadecimal":
                        break;
                }
                break;
            case "Hexadecimal":
                switch (convertTo) {
                    case "Binary":
                        break;
                    case "Octal":
                        break;
                    case "Decimal":
                        break;
                    case "Hexadecimal":
                        outputValue = inputValue;
                        break;
                }
                break;
        }

        textOutput();
    }
}
