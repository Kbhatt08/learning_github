package com.mycompany.calculator;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

public class PrimaryController {
    @FXML
    String operator="";
    @FXML
    private TextField screen1;
    @FXML
    private TextField screen2;
    long num1,num2;
    

    @FXML
    void num(ActionEvent event) {
        String click=((Button)event.getSource()).getText();
        screen1.setText(screen1.getText()+click);
    }

    @FXML
    void opr(ActionEvent event) {
        String op=((Button)event.getSource()).getText();
        if(!op.equals("="))
        {
            if(!operator.equals("")){
                return;
            }
        operator=op;
        screen2.setText(op);
        num1=Long.parseLong(screen1.getText());
        screen1.setText("");
        }
        else
        {
            if(operator.equals(""))
                ;
            num2=Long.parseLong(screen1.getText());
            calculate(num1,num2,operator);
            operator="";
            num1=0;num2=0;
        }
    }
     
    public void calculate(long n1,long n2,String op){
        switch(op){
            case  "+":screen1.setText(String.valueOf(n1+n2)+"");break;
            case  "-":screen1.setText(String.valueOf(n1-n2)+"");break;
            case  "*":screen1.setText(String.valueOf(n1*n2)+"");break;
            case  "/":if (n2==0){
                screen1.setText("0");break;}
                screen1.setText(String.valueOf(n1/n2)+"");break;
        }
    }
    @FXML
    void clean(ActionEvent event) {
        screen1.setText("");
        screen2.setText("");
        operator="";
        num1=0;
        num2=0;
    }

    @FXML
    void end(ActionEvent event) throws IOException, Exception {
       Alert al=new Alert(Alert.AlertType.CONFIRMATION);
       al.setTitle("Exit");
       al.setHeaderText("Do you want to colse the Application?");
       al.setContentText("No data will be saved");
       if(al.showAndWait().get()==ButtonType.OK)
           System.exit(0);
    }
}