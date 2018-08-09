package lens.make;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;

/**
 * @author 김임박
 *
 */
/**
 * @author ict-11
 *
 */
public class MainCon implements Initializable{
	
	@FXML
	private StackPane main;
	
    @FXML
    private Button btSCM;

    @FXML
    private Button btlogout;

    @FXML
    private Button btCRS;

    @FXML
    private TextField txid;

    @FXML
    private PasswordField txpsw;

    @FXML
    private Button btODM;

    @FXML
    private Button btHRS;

    @FXML
    private Button btlogin;
    
    @FXML 
    private Label lb1;
    
    @FXML 
    private Label lb2;

    /**
     * @param event 각 버튼으로 각 시스템에 접속
     */
    @FXML
    void btHRSm(ActionEvent event) {
    	try {
			Parent hrs = FXMLLoader.load(getClass().getResource("hrs.fxml"));
			StackPane root = (StackPane)btHRS.getScene().getRoot();
			root.getChildren().add(hrs);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void btSCMm(ActionEvent event) {
    	try {
			Parent scm = FXMLLoader.load(getClass().getResource("scm.fxml"));
			StackPane root = (StackPane)btSCM.getScene().getRoot();
			root.getChildren().add(scm);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    

   
    @FXML
    void btODMm(ActionEvent event) {
    	try {
			Parent odm = FXMLLoader.load(getClass().getResource("odm.fxml"));
			StackPane root = (StackPane)btODM.getScene().getRoot();
			root.getChildren().add(odm);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void btCRSm(ActionEvent event) {
    	try {
			Parent crs = FXMLLoader.load(getClass().getResource("crs.fxml"));
			StackPane root = (StackPane)btODM.getScene().getRoot();
			root.getChildren().add(crs);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void txidm(ActionEvent event) {

    }

    @FXML
    void txpswm(ActionEvent event) {

    }

    /**
     * @param event id에 따른 시스템 이용 권한부여
     */
    @FXML
    void btloginm(ActionEvent event) {
    	if(txid.getText().equals("dba") && txpsw.getText().equals("java")) {
    		btHRS.setDisable(false);
    		btSCM.setDisable(false);
    		btODM.setDisable(false);
    		btCRS.setDisable(false);
    		lb1.setText("DB관리자 로그인");
    		lb2.setText("시스템을 선택하세요.");
    	}else if(txid.getText().equals("mf") && txpsw.getText().equals("java")){
    		btHRS.setDisable(true);
    		btSCM.setDisable(false);
    		btODM.setDisable(false);
    		btCRS.setDisable(true);
    		lb1.setText("제품관리자 로그인");
    		lb2.setText("시스템을 선택하세요.");
    	
    	}else if(txid.getText().equals("pm") && txpsw.getText().equals("java")){
    		btHRS.setDisable(false);
    		btSCM.setDisable(true);
    		btODM.setDisable(true);
    		btCRS.setDisable(false);
    		lb1.setText("인사관리자 로그인");
    		lb2.setText("시스템을 선택하세요.");	
    		
    	}else {
    		lb1.setText("로그인에 실패하였습니다.");
    	}
    }

    @FXML
    void btlogoutm(ActionEvent event) {
    	btHRS.setDisable(true);
    	btSCM.setDisable(true);
    	btODM.setDisable(true);
    	btCRS.setDisable(true);
    	txid.clear();
    	txpsw.clear();
    	lb1.setText("로그인이 필요합니다.");
    	lb2.setText("");
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}

}
