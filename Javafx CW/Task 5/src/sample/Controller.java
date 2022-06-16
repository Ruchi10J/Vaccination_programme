package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private Button btnReceipt;

    @FXML
    private TextField lblFirst;

    @FXML
    private TextField lblSecond;

    @FXML
    private TextField lblAge;

    @FXML
    private TextField lblCity;

    @FXML
    private TextField lblNic;

    @FXML
    private TextField lblType;

    @FXML
    private TextField lblNo;

    @FXML
    private TextArea lblReceipt;

    @FXML
    private Button btnPrint;

    @FXML
    private Button btnClear;

    @FXML
    private TextField lblDate;

    @FXML
    private TextField lblTime;

    @FXML
    public void clear(){
        lblFirst.clear();
        lblSecond.clear();
        lblAge.clear();
        lblCity.clear();
        lblNic.clear();
        lblNo.clear();
        lblType.clear();
    }
    @FXML
    public void GenerateReceiptBtn(ActionEvent event){
        lblReceipt.setText("***************Receipt*************");
        String txt1=lblFirst.getText();
        lblReceipt.appendText("\n First Name: "+txt1);
        String txt2=lblSecond.getText();
        lblReceipt.appendText("\n Surname: "+txt2);
        String txt3=lblAge.getText();
        lblReceipt.appendText("\n Age: "+txt3);
        String txt4=lblCity.getText();
        lblReceipt.appendText("\n City: "+txt4);
        String txt5=lblNic.getText();
        lblReceipt.appendText("\n NIC: "+txt5);
        String txt6=lblType.getText();
        lblReceipt.appendText("\n Vaccine Type: "+txt6);
        String txt7=lblNo.getText();
        lblReceipt.appendText("\n Booth Number: "+txt7);
        String txt8=lblDate.getText();
        lblReceipt.appendText("\n Date:"+txt8);
        String txt9=lblTime.getText();
        lblReceipt.appendText("\n Time:"+txt9);

    }


}
