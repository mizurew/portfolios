package lens.make;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import lens.vo.CRS;
import lens.vo.SCM;

public class CRSCon implements Initializable{

    @FXML
    private ComboBox<String> cbloc;

    @FXML
    private ComboBox<?> cbeaddy2;

    @FXML
    private Button btfin;

    @FXML
    private Button btdel;

    @FXML
    private AnchorPane crs;

    @FXML
    private TextField txaddy;

    @FXML
    private TextField txloc;

    @FXML
    private Button btins;

    @FXML
    private TextField txid;

    @FXML
    private TextField txeaddy2;

    @FXML
    private TextField txgrade;

    @FXML
    private Button btselA;

    @FXML
    private TextField txeaddy;

    @FXML
    private Button btupd;

    @FXML
    private TextField txdate;

    @FXML
    private TextField txname;

    @FXML
    private DatePicker picdate;

    @FXML
    private Button btcle;

    @FXML
    private Button btback;

    @FXML
    private CheckBox ckmale;

    @FXML
    private Button btsel;

    @FXML
    private CheckBox chfemale;

    @FXML
    private ComboBox<String> cbgrade;

    @FXML
    private TableView<CRS> table;
    
    @FXML
    private Label lb1;
    
    public static SCMDao sDao;
    public static HRSDao hDao;
    public static ODMDao oDao;
    public static CRSDao cDao;
    
    ObservableList<String> list;
    ObservableList<String> list1;

    @FXML
    void btclem(ActionEvent event) {
    	table.getItems().clear();
    	txid.clear();
    	txname.clear();
    	txgrade.clear();
    	txloc.clear();
    	txdate.clear();
    	txaddy.clear();
    	txeaddy.clear();
    	lb1.setText("");
    	
    }

    @FXML
    void chfemalem(ActionEvent event) {

    }

    @FXML
    void ckmalem(ActionEvent event) {

    }

    @FXML
    void cbeaddy2(ActionEvent event) {

    }

    @FXML
    void txeaddy2(ActionEvent event) {

    }

    @FXML
    void txeaddym(ActionEvent event) {

    }

    @FXML
    void txaddym(ActionEvent event) {

    }

    @FXML
    void cblocm(ActionEvent event) {
    	String str = cbloc.getValue().toString();
    	txloc.setText(str);
    }

    @FXML
    void txlocm(ActionEvent event) {

    }

    @FXML
    void cbgradem(ActionEvent event) {
    	String str = cbgrade.getValue().toString();
    	txgrade.setText(str);
    }

    @FXML
    void txdatem(ActionEvent event) {

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
    void txgradem(ActionEvent event) {

    }

    @FXML
    void txnamem(ActionEvent event) {

    }

    @FXML
    void txidm(ActionEvent event) {

    }

    @FXML
    void tablem(ActionEvent event) {

    }

    @FXML
    void btfinm(ActionEvent event) {

    }

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
    void btsel(ActionEvent event) {
    	try {
			int index = Integer.parseInt(txid.getText());
			CRS vo = cDao.select(index);
			table.getItems().add(vo);
		} catch (NumberFormatException e) {
			System.out.println("우선 고객을 선택하신 후 사용하시기 바랍니다.");
			lb1.setText("고객을 선택하신 후 사용하십시오.");
		}
    }

    @FXML
    void btupdm(ActionEvent event) {
    	try {
			CRS vo = new CRS();
			vo.setCid(Integer.parseInt(txid.getText()));
			vo.setCname(txname.getText());
			vo.setGrade(txgrade.getText());
			vo.setLoc(txloc.getText());
			vo.setCdate(txdate.getText());
			vo.setAddy(txaddy.getText());
			vo.setEaddy(txeaddy.getText());
			
			cDao.update(vo);
			int index = table.getSelectionModel().getSelectedIndex();
			table.getItems().set(index, vo);
		} catch (NumberFormatException e) {
			System.out.println("변경할 고객을 선택하십시오.");
			lb1.setText("변경할 고객을 선택하십시오.");
		}
    }

    @FXML
    void btdelm(ActionEvent event) {
    	try {
			int index = table.getSelectionModel().getSelectedIndex();
			CRS vo = table.getItems().get(index);
			cDao.delete(vo.getCid());
			table.getItems().remove(index);
		} catch (Exception e) {
			System.out.println("삭제할 고객을 선택하십시오.");
			lb1.setText("삭제할 고객을 선택하십시오.");
		}
    }

    @FXML
    void btselAm(ActionEvent event) {
    	List<CRS> list = cDao.selectAll();
    	table.getItems().clear();
    	table.getItems().addAll(list);
    }

    @FXML
    void btinsm(ActionEvent event) {
    	try {
			CRS vo = new CRS();
			//vo.setCid(Integer.parseInt(txid.getText()));
			vo.setCname(txname.getText());
			vo.setGrade(txgrade.getText());
			vo.setLoc(txloc.getText());
			vo.setCdate(txdate.getText());
			vo.setAddy(txaddy.getText());
			vo.setEaddy(txeaddy.getText());
			
			cDao.insert(vo);
   
			int currval = 0;
			
			try {
				String sql = "select Max(cid) from crs";
				Connection conn = ConnFactory.getConnection("lens.config.oracle");
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				rs.next();
				currval = rs.getInt(1);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			vo.setCid(currval);
			table.getItems().add(vo);
		} catch (NumberFormatException e) {
			System.out.println("필요한 정보를 모두 입력하십시오.");
			lb1.setText("필요한 정보를 모두 입력하십시오.");
		}
    }
   
    @FXML
    void btbackm(ActionEvent event) {
    	try {
			StackPane root = (StackPane)btback.getScene().getRoot();
			root.getChildren().remove(crs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    

    /**
        * @param event 테이블 내용 클릭시 정보 칸에 입력
        */
    @FXML
    void infor(MouseEvent event) {
    	try {
			int index = table.getSelectionModel().getSelectedIndex();
			CRS vo = table.getItems().get(index);
			txid.setText(vo.getCid()+"");
			txname.setText(vo.getCname());
			txgrade.setText(vo.getGrade());
			txloc.setText(vo.getLoc()+"");
			txdate.setText(vo.getCdate());
			txaddy.setText(vo.getAddy());
			txeaddy.setText(vo.getEaddy());
		} catch (Exception e) {
			System.out.println("열람할 정보가 없습니다.");
			lb1.setText("열람할 정보가 없습니다.");
		}
    	
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		sDao = new SCMDao();
		oDao = new ODMDao();
		hDao = new HRSDao();
		cDao = new CRSDao();
		
		TVF.setTable(table, CRS.class);
		
		list = FXCollections.observableArrayList();
		list.add("플래티넘");list.add("골드");list.add("실버");list.add("일반");
		cbgrade.setItems(list);
		
		list1 = FXCollections.observableArrayList();
		list1.add("한국");list1.add("중국");list1.add("일본");list1.add("미국");
		cbloc.setItems(list1);
	}

}

