package lens.make;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import lens.common.ConnFactory;
import lens.common.TVF;
import lens.dao.CRSDao;
import lens.dao.HRSDao;
import lens.dao.ODMDao;
import lens.dao.SCMDao;
import lens.vo.HRS;


public class HRSCon implements Initializable{

	@FXML
	private AnchorPane hrs;
	
    @FXML
    private TextField txsal;

    @FXML
    private Button btdel;

    @FXML
    private Button btfin;

    

    @FXML
    private TextField txtel;

    @FXML
    private Button btins;

    @FXML
    private TextField txid;

    @FXML
    private Button btselA;

    @FXML
    private TextField txpst;

    @FXML
    private Label lb1;

    @FXML
    private Button btupd;

    @FXML
    private TextField txeaddy;

    @FXML
    private TextField txdate;

    @FXML
    private TextField txname;

    @FXML
    private DatePicker picdate;

    @FXML
    private TextField txdep;

    @FXML
    private ComboBox<String> cbdep;

    @FXML
    private Button btcle;

    @FXML
    private Button btback;

    @FXML
    private Button btsel;

    @FXML
    private CheckBox ckmale;

    @FXML
    private ComboBox<String> cbpst;

    @FXML
    private CheckBox chfemale;

    @FXML
    private TableView<HRS> table;
    
    public static HRSDao hDao;
    public static SCMDao sDao;
    public static ODMDao oDao;
    public static CRSDao cDao;
    
    ObservableList<String> list;
    ObservableList<String> list1;

    
    /**
     * @param event 각 버튼별로 기능
     * ins - 추가
     * del - 삭제
     * cle - 비우기
     * sel - 선택
     * selA - 모두선택
     * upd - 변경
     */
    @FXML
    void btbackm(ActionEvent event) {
    	try {
			StackPane root = (StackPane)btback.getScene().getRoot();
			root.getChildren().remove(hrs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    

    @FXML
    void btinsm(ActionEvent event) {
    	try {
			HRS vo = new HRS();
			//vo.setHid(Integer.parseInt(txid.getText()));
			vo.setHname(txname.getText());
			vo.setPst(txpst.getText());
			vo.setDep(txdep.getText());
			vo.setSal(Integer.parseInt(txsal.getText()));
			vo.setHdate(txdate.getText());
			vo.setTel(txtel.getText());
			vo.setEml(txeaddy.getText());
			hDao.insert(vo);
			//table.getItems().add(vo);
			
			int currval = 0;
			
			try {
				String sql = "select Max(hid) from hrs";
				Connection conn = ConnFactory.getConnection("lens.config.oracle");
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				rs.next();
				currval = rs.getInt(1);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			vo.setHid(currval);
			table.getItems().add(vo);
		} catch (NumberFormatException e) {
			System.out.println("필요한 정보를 모두 넣어주십시오.");
			lb1.setText("필요한 정보를 모두 넣어주십시오.");
		}
    	
    }
    

    @FXML
    void btselAm(ActionEvent event) {
    	table.getItems().clear();
    	table.getItems().addAll(hDao.selectAll());
    }

    @FXML
    void btdelm(ActionEvent event) {
    	try {
			int index = table.getSelectionModel().getSelectedIndex();
			HRS vo = table.getItems().get(index);
			hDao.delete(vo.getHid());
			table.getItems().remove(index);
		} catch (Exception e) {
			System.out.println("삭제할 직원을 선택하십시오.");
			lb1.setText("삭제할 직원을 선택하십시오.");
		}
    }

    @FXML
    void btupdm(ActionEvent event) {
    	try {
			HRS vo = new HRS();
			vo.setHid(Integer.parseInt(txid.getText()));
			vo.setHname(txname.getText());
			vo.setPst(txpst.getText());
			vo.setDep(txdep.getText());
			vo.setSal(Integer.parseInt(txsal.getText()));
			
			vo.setHdate(txdate.getText());
			vo.setTel(txtel.getText());
			vo.setEml(txeaddy.getText());
			hDao.update(vo);
			int index = table.getSelectionModel().getSelectedIndex();
			table.getItems().set(index, vo);
		} catch (NumberFormatException e) {
			System.out.println("변경할 직원을 선택하십시오.");
			lb1.setText("변경할 직원을 선택하십시오.");
		}
    }

    @FXML
    void btsel(ActionEvent event) {
    	try {
			int index = Integer.parseInt(txid.getText());
			HRS vo = hDao.select(index);
			table.getItems().add(vo);
		} catch (NumberFormatException e) {
			System.out.println("직원을 우선 선택하십시오.");
			lb1.setText("직원을 우선 선택하십시오.");
		}
    }

    @FXML
    void btfinm(ActionEvent event) {

    }

    @FXML
    void tablem(ActionEvent event) {

    }

    @FXML
    void txidm(ActionEvent event) {

    }

    @FXML
    void txnamem(ActionEvent event) {

    }

    @FXML
    void txpstm(ActionEvent event) {

    }

    @FXML
    void picdatem(ActionEvent event) {
    	String str = picdate.getEditor().getText();
    	//str.replace(".","-");
    	String[] tokens = str.split(". ");
    	int year = Integer.parseInt(tokens[0].trim());
    	int month = Integer.parseInt(tokens[1].trim());
    	int day = Integer.parseInt(tokens[2].trim());
    	if(month<10) {
    		tokens[1] = "0"+tokens[1];
    	}
    	if(day<10) {
    		tokens[2] = "0"+tokens[2];
    	}
    	
    	str = tokens[0]+"-"+tokens[1]+"-"+tokens[2];
    	txdate.setText(str);
    	}

  

    @FXML
    void txsalm(ActionEvent event) {

    }

    @FXML
    void txdatem(ActionEvent event) {

    }

    @FXML
    void cbpstm(ActionEvent event) {
    	String str = cbpst.getValue().toString();
    	txpst.setText(str);
    }

    @FXML
    void txdepm(ActionEvent event) {

    }

    @FXML
    void cbdepm(ActionEvent event) {
    	String str = cbdep.getValue().toString();
    	txdep.setText(str);
    }

    @FXML
    void txtelm(ActionEvent event) {

    }

    @FXML
    void txeaddym(ActionEvent event) {

    }

    @FXML
    void ckmalem(ActionEvent event) {

    }

    @FXML
    void chfemalem(ActionEvent event) {

    }

    @FXML
    void btclem(ActionEvent event) {
    	table.getItems().clear();
    	txid.clear();
    	txid.clear();
    	txname.clear();
    	txpst.clear();
    	txdep.clear();
    	txsal.clear();
    	txdate.clear();
    	txtel.clear();
    	txeaddy.clear();
    	lb1.setText("");
    }
    

    /**
        * @param event 테이블 내용 클릭시 정보 칸에 입력
        */

    @FXML
    void infor(MouseEvent event) {
    	try {
			int index = table.getSelectionModel().getSelectedIndex();
			HRS vo = table.getItems().get(index);
			txid.setText(vo.getHid()+"");
			txname.setText(vo.getHname());
			txpst.setText(vo.getPst());
			txdep.setText(vo.getDep());
			txsal.setText(vo.getSal()+"");
			txdate.setText(vo.getHdate());
			txtel.setText(vo.getTel());
			txeaddy.setText(vo.getEml());
		} catch (Exception e) {
			System.out.println("열람할 정보가 없습니다.");
			lb1.setText("열람할 정보가 없습니다.");
		}
    	
    }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		hDao = new HRSDao();
		sDao = new SCMDao();
		oDao = new ODMDao();
		cDao = new CRSDao();
		
		TVF.setTable(table, HRS.class);
		
		list = FXCollections.observableArrayList();
		
		list.addAll("이사","부장","차장","과장","팀장","대리","사원","인턴","계약");
		cbpst.setItems(list);
		
		list1 = FXCollections.observableArrayList();
		list1.add("기획");list1.add("개발");list1.add("영업");list1.add("생산");
		list1.addAll("생산:콘택트","생산:선글라스","생산:안경","생산:안경테");
		cbdep.setItems(list1);
	}

}
