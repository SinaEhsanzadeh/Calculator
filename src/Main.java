import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Main{


    public static void main(String[] args){

        StringBuffer x = new StringBuffer("");

        JFrame frame = new JFrame("Calculator");
        Dimension dimension = new Dimension(300, 400);
        frame.setLayout(null);
        frame.setSize(dimension);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);

        JPanel pad = new JPanel();
        pad.setLayout(new GridLayout(4,4,10, 10));
        pad.setBounds(40, 100    , 200, 200);
        pad.setSize(200, 200);

        JButton[] buttons = new JButton[16];

        for(int i = 0; i < buttons.length; i++){
            buttons[i]= new JButton();
            buttons[i].setBounds(0,0, 50, 50);
            pad.add(buttons[i]);
        }

        buttons[0].setText("1");
        buttons[1].setText("2");
        buttons[2].setText("3");
        buttons[3].setText("+");
        buttons[4].setText("4");
        buttons[5].setText("5");
        buttons[6].setText("6");
        buttons[7].setText("-");
        buttons[8].setText("7");
        buttons[9].setText("8");
        buttons[10].setText("9");
        buttons[11].setText("*");
        buttons[12].setText(".");
        buttons[13].setText("0");
        buttons[14].setText("=");
        buttons[15].setText("/");

        JButton del = new JButton("Del");
        del.setBounds(40,310, 60, 40);

        JButton clr = new JButton("Clr");
        clr.setBounds(110, 310, 60, 40);

        JButton minus = new JButton("-");
        minus.setBounds(180, 310, 60, 40);

        JLabel output = new JLabel();
        Border border = BorderFactory.createLineBorder(Color.black, 2);
        output.setBounds(40,40, 200, 40);
        output.setBorder(border);
        output.setText(x.toString());

        frame.add(pad);
        frame.add(output);
        frame.add(del);
        frame.add(clr);
        frame.add(minus);

        buttons[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            x.insert(x.length(), "1");
            output.setText(x.toString());
            }
        });

        buttons[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x.insert(x.length(), "2");
                output.setText(x.toString());
            }
        });

        buttons[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x.insert(x.length(), "3");
                output.setText(x.toString());
            }
        });

        buttons[4].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x.insert(x.length(), "4");
                output.setText(x.toString());
            }
        });

        buttons[5].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x.insert(x.length(), "5");
                output.setText(x.toString());
            }
        });

        buttons[6].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x.insert(x.length(), "6");
                output.setText(x.toString());
            }
        });

        buttons[8].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x.insert(x.length(), "7");
                output.setText(x.toString());
            }
        });

        buttons[9].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x.insert(x.length(), "8");
                output.setText(x.toString());
            }
        });

        buttons[10].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x.insert(x.length(), "9");
                output.setText(x.toString());
            }
        });

        buttons[12].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x.insert(x.length(), ".");
                output.setText(x.toString());
            }
        });

        buttons[13].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x.insert(x.length(), "0");
                output.setText(x.toString());
            }
        });

        buttons[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x.insert(x.length(), "+");
                output.setText(x.toString());

            }
        });

        buttons[7].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x.insert(x.length(), "-");
                output.setText(x.toString());
            }
        });

        buttons[11].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x.insert(x.length(), "*");
                output.setText(x.toString());

            }
        });

        buttons[15].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x.insert(x.length(), "/");
                output.setText(x.toString());

            }
        });

        buttons[14].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<String> executionLine = cal(x);
                ArrayList<Character> operatorList = operationListing(x);
                double result = Double.parseDouble(executionLine.get(0));
                int i = 1;
                for (Character character : operatorList) {
                    switch (character) {
                        case '+' -> {
                            result += Double.parseDouble(executionLine.get(i));
                            i++;
                        }
                        case '-' -> {
                            result -= Double.parseDouble(executionLine.get(i));
                            i++;
                        }
                        case '*' -> {
                            result *= Double.parseDouble(executionLine.get(i));
                            i++;
                        }
                        case '/' -> {
                            result /= Double.parseDouble(executionLine.get(i));
                            i++;
                        }
                    }
                }
                x.replace(0, x.length(), "");
                x.insert(0, result);
                i = 1;
                output.setText(String.valueOf(result));
            }
        });

        clr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x.replace(0, x.length(), "");
                output.setText(x.toString());
            }
        });

        del.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x.replace(x.length() - 1, x.length(), "");
                output.setText(x.toString());
            }
        });

        minus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x.insert(x.length(), "-");
                output.setText(x.toString());
            }
        });

    }

    public static ArrayList<String> cal(StringBuffer x){
        ArrayList<String> calculation = new ArrayList<>(Arrays.asList(x.toString().split("[-+/*]")));
        int j = 0;
        for (int i = 0; i < calculation.size(); i++){
            int k = 0;
            j += calculation.get(i).length();
            if (calculation.get(i).equals("")){
                calculation.set(i + 1, x.toString().charAt(j + k) + calculation.get(i + 1));
            }else{
                j++;
            }
        }
        for (int i = 0; i < calculation.size(); i++)
            if (calculation.get(i).equals(""))
                calculation.remove(i);
        return calculation;
    }

    public static ArrayList<Character> operationListing(StringBuffer x){
        ArrayList<Character> operation = new ArrayList<>();
        for (int i = 1; i < x.length(); i++){
            if (x.toString().charAt(i) == '+' || x.toString().charAt(i) == '-' || x.toString().charAt(i) == '/' || x.toString().charAt(i) == '*')
                if (x.toString().charAt(i + 1) != '+' && x.toString().charAt(i + 1) != '-' && x.toString().charAt(i + 1) != '*' && x.toString().charAt(i + 1) != '/')
                    operation.add(x.toString().charAt(i));
        }
        return operation;
    }
}