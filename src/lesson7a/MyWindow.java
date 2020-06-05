package lesson7a;

import javax.swing.*;
import java.awt.*;
import java.awt.dnd.MouseDragGestureRecognizer;
import java.awt.event.*;

public class MyWindow extends JFrame {
    final int HEIGHT_OF_ROW=50;
    final int WIDTH=HEIGHT_OF_ROW*4;
    static int a;
    static int b;
    static String[] vars;
    static String str;

    public MyWindow(){
        setBounds(400,300, WIDTH+20,HEIGHT_OF_ROW*7);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Калькулятор");
        setLayout(null);
        JTextField textField=new JTextField();
        add(textField);
        textField.setBounds(0,0,WIDTH,HEIGHT_OF_ROW);
        JButton[] buttons=new JButton[10];
        for (int i = 0; i < 3; i++) {
            for (int j = 1; j <= 3; j++) {
                int num=i*3+j;
                buttons[num]=new JButton(""+num);
                buttons[num].setBounds((j-1)*HEIGHT_OF_ROW,HEIGHT_OF_ROW+i*HEIGHT_OF_ROW,HEIGHT_OF_ROW,HEIGHT_OF_ROW);
                add(buttons[num]);
                buttons[num].addActionListener(e ->  {
                        textField.setText(textField.getText()+num);
                });
            }
        }

        buttons[0]=new JButton("0");
        buttons[0].setBounds(0,4*HEIGHT_OF_ROW,HEIGHT_OF_ROW,HEIGHT_OF_ROW);
        add(buttons[0]);
        buttons[0].addActionListener(e -> {
            textField.setText(textField.getText() + "0");
        });

        JButton myltiply=new JButton("*");
        myltiply.setBounds(HEIGHT_OF_ROW*3,HEIGHT_OF_ROW,HEIGHT_OF_ROW,HEIGHT_OF_ROW);
        add(myltiply);
        myltiply.addActionListener(e -> {
            textField.setText(textField.getText() + "*");
        });

        JButton divide=new JButton("/");
        divide.setBounds(HEIGHT_OF_ROW*3,2*HEIGHT_OF_ROW,HEIGHT_OF_ROW,HEIGHT_OF_ROW);
        add(divide);
        divide.addActionListener(e -> {
            textField.setText(textField.getText() + "/");
        });

        JButton plus=new JButton("+");
        plus.setBounds(HEIGHT_OF_ROW*3,3*HEIGHT_OF_ROW,HEIGHT_OF_ROW,HEIGHT_OF_ROW);
        add(plus);
        plus.addActionListener(e -> {
            textField.setText(textField.getText() + "+");
        });

        JButton minus=new JButton("-");
        minus.setBounds(HEIGHT_OF_ROW*3,4*HEIGHT_OF_ROW,HEIGHT_OF_ROW,HEIGHT_OF_ROW);
        add(minus);
        minus.addActionListener(e -> {
            textField.setText(textField.getText() + "-");
        });

        JButton clear=new JButton("CLEAR");
        clear.setBounds(0,5*HEIGHT_OF_ROW,WIDTH,HEIGHT_OF_ROW);
        add(clear);
        clear.addActionListener(e -> {
            textField.setText("");
        });

        JButton equal=new JButton("=");
        equal.setBounds(HEIGHT_OF_ROW,4*HEIGHT_OF_ROW,2*HEIGHT_OF_ROW,HEIGHT_OF_ROW);
        add(equal);
        equal.addActionListener(e -> {
            a=0;
            b=0;
            str=textField.getText();
            int i=0;
            double result;
            if (str.indexOf("*") != -1) {
                vars=str.split("\\*");
                textField.setText(""+(Integer.parseInt(vars[0])*Integer.parseInt(vars[1])));
            }
            if (str.indexOf("+") != -1) {
                vars=str.split("\\+");
                textField.setText(""+(Integer.parseInt(vars[0])+Integer.parseInt(vars[1])));
            }
            if (str.indexOf("-") != -1) {
                vars=str.split("-");
                textField.setText(""+(Integer.parseInt(vars[0])-Integer.parseInt(vars[1])));
            }
            if (str.indexOf("/") != -1) {
                vars=str.split("/");
                textField.setText(String.valueOf(Integer.parseInt(vars[0])/Integer.parseInt(vars[1])));
            }
        });

        setVisible(true);
    }
}
