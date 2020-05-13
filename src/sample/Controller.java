package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;


public class Controller implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML private TextField month_field;
    @FXML private TextField year_field;

    @FXML private Label month_label;
    @FXML private Label year_label;

    @FXML private Button btn_enter;

    @FXML SplitPane split;

    private Label[] labels;

    public Controller(){
        initializeLabels();
    }

    private Label[] initializeLabels() {
        Label[] result = new Label[37];
        result[0] = l0;
        result[1] = l1;
        result[2] = l2;
        result[3] = l3;
        result[4] = l4;
        result[5] = l5;
        result[6] = l6;
        result[7] = l7;
        result[8] = l8;
        result[9] = l9;
        result[10] = l10;
        result[11] = l11;
        result[12] = l12;
        result[13] = l13;
        result[14] = l14;
        result[15] = l15;
        result[16] = l16;
        result[17] = l17;
        result[18] = l18;
        result[19] = l19;
        result[20] = l20;
        result[21] = l21;
        result[22] = l22;
        result[23] = l23;
        result[24] = l24;
        result[25] = l25;
        result[26] = l26;
        result[27] = l27;
        result[28] = l28;
        result[29] = l29;
        result[30] = l30;
        result[31] = l31;
        result[32] = l32;
        result[33] = l33;
        result[34] = l34;
        result[35] = l35;
        result[36] = l36;
        return result;
    }

    @FXML private Label l0;
    @FXML private Label l1;
    @FXML private Label l2;
    @FXML private Label l3;
    @FXML private Label l4;
    @FXML private Label l5;
    @FXML private Label l6;
    @FXML private Label l7;
    @FXML private Label l8;
    @FXML private Label l9;
    @FXML private Label l10;
    @FXML private Label l11;
    @FXML private Label l12;
    @FXML private Label l13;
    @FXML private Label l14;
    @FXML private Label l15;
    @FXML private Label l16;
    @FXML private Label l17;
    @FXML private Label l18;
    @FXML private Label l19;
    @FXML private Label l20;
    @FXML private Label l21;
    @FXML private Label l22;
    @FXML private Label l23;
    @FXML private Label l24;
    @FXML private Label l25;
    @FXML private Label l26;
    @FXML private Label l27;
    @FXML private Label l28;
    @FXML private Label l29;
    @FXML private Label l30;
    @FXML private Label l31;
    @FXML private Label l32;
    @FXML private Label l33;
    @FXML private Label l34;
    @FXML private Label l35;
    @FXML private Label l36;


    @FXML
    private void onClick(ActionEvent actionEvent) {
        String month = month_field.getText();
        String year = year_field.getText();
        int m = 0, y = 0;
        try {
            m = Integer.parseInt(month);
            y = Integer.parseInt(year);
        }catch (Exception e){
            System.out.println("Invalid Input");
        }
        month_label.setText(getMonthName(m));
        year_label.setText("" + y);
        labels = initializeLabels();
        printMonthTitle(m,y);
        printMonth(m,y);
    }

    private void printMonthTitle(int m, int y) {
        month_label.setText(getMonthName(m));
        year_label.setText("" + y);
    }

    private String getMonthName(int month) {
        String monthName = "";
        switch (month) {
            case 1: monthName = "January"; break;
            case 2: monthName = "February"; break;
            case 3: monthName = "March"; break;
            case 4: monthName = "April"; break;
            case 5: monthName = "May"; break;
            case 6: monthName = "June"; break;
            case 7: monthName = "July"; break;
            case 8: monthName = "August"; break;
            case 9: monthName = "September"; break;
            case 10: monthName = "October"; break;
            case 11: monthName = "November"; break;
            case 12: monthName = "December";
        }
        return monthName;
    }

    private void printMonth(int m, int y) {
        int startDay = getStartDay(m,y);
        int numOfDaysInMonth = getNumOfDaysInMonth(m,y);

        for(int i = 0; i < labels.length; i++){
            labels[i].setText("");
        }

        for (int i = 1; i <= numOfDaysInMonth; i++){
            labels[startDay + i-1].setText("" + i);
        }

    }

    private int getNumOfDaysInMonth(int month, int year) {
        if (month == 1 || month == 3 || month == 5 || month == 7 ||
                month == 8 || month == 10 || month == 12)
            return 31;
        if (month == 4 || month == 6 || month == 9 || month == 11)
            return 30;
        if (month == 2) return isLeapYear(year) ? 29 : 28;

        return 0;
    }

    private int getStartDay(int month, int year) {
        final int START_DAY_FOR_JAN_1_1800 = 3;

        int totalNumberOfDays = getTotalNumberOfDays(year, month);

        return (totalNumberOfDays + START_DAY_FOR_JAN_1_1800) % 7;
    }

    private int getTotalNumberOfDays(int year, int month) {
        int total = 0;

        for (int i = 1800; i < year; i++) {
            if (isLeapYear(i))
                total = total + 366;
            else
                total = total + 365;
        }

        for (int i = 1; i < month; i++) {
            total = total + getNumOfDaysInMonth(i,year);
        }
        return total;
    }

    private boolean isLeapYear(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }

    @FXML
    private void next(ActionEvent event){
        month_field.setText("" + (Integer.parseInt(month_field.getText()) + 1));
        if(Integer.parseInt(month_field.getText()) == 13){
            month_field.setText("" + (Integer.parseInt(month_field.getText())%12));
            year_field.setText("" + (Integer.parseInt(year_field.getText()) + 1));
        }
        btn_enter.fire();
    }

    @FXML
    private void prev(ActionEvent event){
        month_field.setText("" + (Integer.parseInt(month_field.getText()) - 1));
        if(Integer.parseInt(month_field.getText()) == 0){
            month_field.setText("" + (Integer.parseInt(month_field.getText()) + 12));
            year_field.setText("" + (Integer.parseInt(year_field.getText()) - 1));
        }
        btn_enter.fire();
    }
}

