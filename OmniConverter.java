import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class baseFrame extends JFrame implements ActionListener{
    JButton[] buttons = new JButton[8];
    String[] names = {"LENGTH", "AREA", "WEIGHT", "TEMPERATURE", "PRESSURE", "TIME", "SPEED", "NUMBER SYSTEM"};
    int[] xCoords = {117, 434, 117, 434, 117, 434, 117, 434};
    int[] yCoords = {144, 144, 328, 328, 512, 512, 696, 696};
    JLabel heading, to, from, destination, image, background;
    JTextField IText, OText;
    JComboBox<String> toUnit, fromUnit;
    int temp;
    
    baseFrame(){
        createBackground();

        this.setTitle("Omni Converter");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(750, 900);
        this.setResizable(false);
        this.add(background);  
        this.setLayout(null);
        this.setVisible(true);
        ImageIcon image = new ImageIcon("Omni.png");
        this.setIconImage(image.getImage());

        createButtons();

        createLabel();
    }

      //creating background
    void createBackground(){
        ImageIcon bg = new ImageIcon("BG.gif");
        background = new JLabel(bg);
        background.setLayout(null);
        background.setBounds(0,0,750, 900); 
    }
    //creating label
    void createLabel(){
        heading = new JLabel();
        heading.setText("Omni Converter");
        heading.setForeground(new Color(0xffffff));
        heading.setFont(new Font("Times New Roman", Font.BOLD, 70));
        heading.setHorizontalAlignment(JLabel.CENTER);
        heading.setBounds(0, 30, 750, 70);
        background.add(heading);
        background.setVisible(true);
    }

    //creating buttons for choosing converters
    void createButtons(){
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton(names[i]);
            buttons[i].setBounds(xCoords[i], yCoords[i], 200, 100);
            buttons[i].addActionListener(this);
            buttons[i].setFocusable(false);
            if(i == 7)
                buttons[i].setFont(new Font("Roboto", Font.BOLD, 20));
            else buttons[i].setFont(new Font("Roboto", Font.BOLD, 25));
            buttons[i].setForeground(Color.WHITE);
            buttons[i].setBackground(new Color(93, 26, 151));
            buttons[i].setBorder(BorderFactory.createBevelBorder(1, Color.WHITE, Color.WHITE));
            background.add(buttons[i]);
        }
    }

    void updateFrame() {
        //for choosing buttons removal
        for(int i = 0; i < buttons.length; i++)
            background.remove(buttons[i]);
        background.revalidate();
        background.repaint();

        //for input and output
        createTextField();

        //for arrow
        ImageIcon arrow = new ImageIcon("arrow.png");
        image = new JLabel(arrow);
        image.setBounds(345, 225, 60, 80);
        background.add(image);

        //for unit labels
        createDestination("From: ", 380);
        createDestination("To: ", 500);
        //for combo box units
        createComboBox();
        
        //for buttons back and convert
        createActionButton("BACK", 84);
        createActionButton("Convert", 418);
    }

    //create text field for input and output
    void createTextField(){
        IText = new JTextField();
        OText = new JTextField();
        
        IText.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent kt) {
                JTextFieldKeyTyped(kt);
            }
        });
        OText.setEditable(false);
        IText.setForeground(Color.WHITE);
        IText.setBackground(new Color(93, 26, 151));
        IText.setBorder(BorderFactory.createBevelBorder(1, Color.WHITE, Color.WHITE));
        OText.setForeground(Color.WHITE);
        OText.setBackground(new Color(93, 26, 151));
        OText.setBorder(BorderFactory.createBevelBorder(1, Color.WHITE, Color.WHITE));
        
        IText.setFont(new Font("Roboto", Font.BOLD, 20));
        OText.setFont(new Font("Roboto", Font.BOLD, 20));
        if(temp == 8){
            IText.setBounds(150, 180, 450, 40);
            OText.setBounds(150, 300, 450, 40);
        }
        else{
            IText.setBounds(150, 180, 400, 40);
            OText.setBounds(150, 300, 400, 40);
        }
        background.add(IText);
        background.add(OText);
    }

    //create label for to & from
    void createDestination(String name, int y){
        destination = new JLabel();
        destination.setText(name);
        destination.setForeground(new Color(0xffffff));
        destination.setFont(new Font("Roboto", Font.BOLD, 35));
        destination.setBounds(150, y, 300, 35);
        background.add(destination);
    }

    //create label for units
    void createFromLabel(String name){
        try{
            background.remove(from);
            background.revalidate();
            background.repaint();
        } catch(Exception e){}
        from = new JLabel();
        from.setText(name);
        from.setForeground(new Color(0xffffff));
        from.setFont(new Font("Roboto", Font.BOLD, 40));
        from.setBounds(560, 180, 300, 40);
        background.add(from);
        IText.setText("");
        OText.setText("");
    }
    void createToLabel(String name){
        try{
            background.remove(to);
            background.revalidate();
            background.repaint();
        } catch(Exception e){}
        to = new JLabel();
        to.setText(name);
        to.setForeground(new Color(0xffffff));
        to.setFont(new Font("Roboto", Font.BOLD, 40));
        to.setBounds(560, 300, 300, 40);
        background.add(to);
        IText.setText("");
        OText.setText("");
    }

    //create combo box input and backgroundut
    void createComboBox(){
        String[] lengthUnits = {"mm", "cm", "m", "km", "in", "ft"};
        String[] areaUnits = {"sq mm", "sq cm", "sq m", "sq km", "sq in", "sq ft", "acre"};
        String[] weightUnits = {"mg", "g", "kg", "tonne", "lb", "oz"};
        String[] temperatureUnits = {"Celsius", "Fahrenheit", "Kelvin"};
        String[] pressureUnits = {"Pa", "kPa", "bar", "psi"};
        String[] timeUnits = {"sec", "min", "hr"};
        String[] speedUnits = {"m/s", "km/hr", "mph"};
        String[] numberUnits = {"Binary", "Octal", "Decimal", "Hexadecimal"};
        switch(temp){
            case 1:
                fromUnit = new JComboBox<String>(lengthUnits);
                toUnit = new JComboBox<String>(lengthUnits);
                break;

            case 2:
                fromUnit = new JComboBox<String>(areaUnits);
                toUnit = new JComboBox<String>(areaUnits);
                break;

            case 3:
                fromUnit = new JComboBox<String>(weightUnits);
                toUnit = new JComboBox<String>(weightUnits);
                break;

            case 4:
                fromUnit = new JComboBox<String>(temperatureUnits);
                toUnit = new JComboBox<String>(temperatureUnits);
                break;

            case 5:
                fromUnit = new JComboBox<String>(pressureUnits);
                toUnit = new JComboBox<String>(pressureUnits);
                break;

            case 6:
                fromUnit = new JComboBox<String>(timeUnits);
                toUnit = new JComboBox<String>(timeUnits);
                break;

            case 7:
                fromUnit = new JComboBox<String>(speedUnits);
                toUnit = new JComboBox<String>(speedUnits);
                break;

            case 8:
                fromUnit = new JComboBox<String>(numberUnits);
                toUnit = new JComboBox<String>(numberUnits);
                break;
        }
        fromUnit.setBounds(200, 435, 350, 40);
        toUnit.setBounds(200, 555, 350, 40);
        fromUnit.addActionListener(this);
        toUnit.addActionListener(this);
        fromUnit.setEditable(false);
        toUnit.setEditable(false);
        fromUnit.setForeground(Color.WHITE);
        fromUnit.setBackground(new Color(93, 26, 151));
        fromUnit.setBorder(BorderFactory.createBevelBorder(1, Color.WHITE, Color.WHITE));
        toUnit.setForeground(Color.WHITE);
        toUnit.setBackground(new Color(93, 26, 151));
        toUnit.setBorder(BorderFactory.createBevelBorder(1, Color.WHITE, Color.WHITE));
        fromUnit.setFont(new Font("Roboto", Font.BOLD, 20));
        toUnit.setFont(new Font("Roboto", Font.BOLD, 20));
        if(temp != 8){
            String name = fromUnit.getSelectedItem().toString();
            createFromLabel(name);
            name = toUnit.getSelectedItem().toString();
            createToLabel(name);
        }
        background.add(fromUnit);
        background.add(toUnit); 
    }

    //button creator(back and convert)
    void createActionButton(String name, int x){
        JButton actionButton = new JButton(name);
        actionButton.setBounds(x, 696,250, 75);
        actionButton.addActionListener(this);
        actionButton.setFocusable(false);
        actionButton.setFont(new Font("Roboto", Font.BOLD, 25));
        actionButton.setForeground(Color.WHITE);
        actionButton.setBackground(new Color(93, 26, 151));
        actionButton.setBorder(BorderFactory.createBevelBorder(1, Color.WHITE, Color.WHITE));
        background.add(actionButton);
    } 

    public void actionPerformed(ActionEvent e){
        for (int i = 0; i < buttons.length; i++) {
            if (e.getSource() == buttons[i]) {
                switch(names[i]) {
                    case "LENGTH":
                        length();
                        break;

                    case "AREA":
                        area();
                        break;
                    
                    case "WEIGHT":
                        weight();
                        break;
                    
                    case "TEMPERATURE":
                        temperature();
                        break;
                    
                    case "PRESSURE":
                        pressure();
                        break;
                    
                    case "TIME":
                        time();
                        break;

                    case "SPEED":
                        speed();
                        break;
                    
                    case "NUMBER SYSTEM":
                        number();
                        break;  
                }
            }
        }
    
        if (e.getActionCommand() == "BACK") {
            background.removeAll();
            background.revalidate();
            background.repaint();
            createButtons();
            createLabel();
        }

        if(e.getSource() == fromUnit){
            if(temp != 8){
                String name = fromUnit.getSelectedItem().toString();
                createFromLabel(name);
            }
        }

        if(e.getSource() == toUnit){
            if(temp != 8){
                String name = toUnit.getSelectedItem().toString();
                createToLabel(name);
            }
        }

        if(e.getActionCommand() == "Convert") {
            Converter converter = new Converter(IText, OText, fromUnit, toUnit, temp);
            switch(temp){
                case 1:
                    converter.lengthConverter();
                    break;

                case 2:
                    converter.areaConverter();
                    break;

                case 3:
                    converter.weightConverter();
                    break;

                case 4:
                    converter.temperatureConverter();
                    break;

                case 5:
                    converter.pressureConverter();
                    break;

                case 6:
                    converter.timeConverter();
                    break;

                case 7:
                    converter.speedConverter();
                    break;

                case 8:
                    converter.numberConverter();
                    break;
            }
        }
    }

    //key listener
    public void JTextFieldKeyTyped(KeyEvent kt) {
        char c = kt.getKeyChar();
        if(temp == 8){
            if(fromUnit.getSelectedItem() == "Binary"){
                if(!(c == '0' || c == '1'))
                    kt.consume(); 
            }

            else if(fromUnit.getSelectedItem() == "Octal")
                if(c == '8' || c == '9' ||!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE))
                    kt.consume();

            else if (fromUnit.getSelectedItem() == "Decimal") 
            if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) 
                kt.consume();
            
            else if (fromUnit.getSelectedItem() == "Hexadecimal") 
            if (!((Character.isDigit(c) || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F') || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE))) 
            kt.consume();
        }

        else if(!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE))
            kt.consume(); 
    }   

    //converters 
    void length(){
        heading.setText("Length Converter");
        temp = 1;
        updateFrame();
    }

    void area(){
        heading.setText("Area Converter");
        temp = 2;
        updateFrame();
    }

    void weight(){
        heading.setText("Weight Converter");
        temp = 3;
        updateFrame();
    }

    void temperature(){
        heading.setText("Temperature Converter");
        temp = 4;
        updateFrame();
    }

    void pressure(){
        heading.setText("Pressure Converter");
        temp = 5;
        updateFrame();
    }

    void time(){
        heading.setText("Time Converter");
        temp = 6;
        updateFrame();
    }

    void speed(){
        heading.setText("Speed Converter");
        temp = 7;
        updateFrame();
    }

    void number(){
        heading.setText("Number System Converter");
        heading.setFont(new Font("Times New Roman", Font.BOLD, 60));
        temp = 8;
        updateFrame();
    }
}

//Driver Class
class OmniConverter{
    public static void main(String[] args){
        new baseFrame();
    }
}