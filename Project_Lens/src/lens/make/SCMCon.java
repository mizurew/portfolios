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
import lens.vo.SCM;
 


public class SCMCon implements Initializable{
	
	@FXML
	private AnchorPane scm;
	
    @FXML
    private Button btfin;

    @FXML
    private TextField txid;
    
    @FXML
    private TextField txpqty;
    
    @FXML
    private TextField txoqty;
    
    @FXML
    private TextField txrqty;
    
    @FXML
    private TextField txmid;
    
    @FXML
    private TextField txmname;
    
    @FXML
    private Button btdel;

    @FXML
    private Button btins;

    @FXML
    private Button btselA;

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
    private ComboBox<HRS> cbdep;
    
    @FXML
    private ComboBox<SCM> cbpd;

    @FXML
    private TextField txdep;

    @FXML
    private Button btback;

    @FXML
    private Button btsel;

    @FXML
    private TextField txname1;

    @FXML
    private TextField txdep1;
    
    @FXML
    private TextField txsale;
    
    @FXML
    private Button btrs;
    
    @FXML
    private Label lb1;

    @FXML
    private TableView<SCM> table;
    
    public static SCMDao sDao;
    public static HRSDao hDao;
    public static ODMDao oDao;
    public static CRSDao cDao;
    
    ObservableList<String> list;
   
    
    @FXML
    void btrsm(ActionEvent event) {
    	
	
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
    void btclem(ActionEvent event) {
    	table.getItems().clear();
    	txid.clear();
    	txname.clear();
    	txdep.clear();
    	txmid.clear();
    	txdate.clear();
    	txpqty.clear();
    	txmname.clear();
    	txsale.clear();
    	lb1.setText("");
    	
    }
    @FXML
    void txsalem(ActionEvent event) {
    	
    }
    

    @FXML
    void tablem(ActionEvent event) {
    	
    }

    @FXML
    void btfinm(ActionEvent event) {

    }

    @FXML
    void btsel(ActionEvent event) {
    	try {
			int index = Integer.parseInt(txid.getText());
			SCM vo = sDao.select(index);
			table.getItems().add(vo);
		} catch (NumberFormatException e) {
			System.out.println("제품을 우선 선택하십시오.");
			lb1.setText("제품을 우선 선택하십시오.");
		}
    }

    @FXML
    void btupdm(ActionEvent event) {
    	try {
			SCM vo = new SCM();
			vo.setSid(Integer.parseInt(txid.getText()));
			vo.setSname(txname.getText());
			vo.setDep(txdep.getText());
			vo.setHid(Integer.parseInt(txmid.getText()));
			vo.setSdate(txdate.getText());
			vo.setPqty(Integer.parseInt(txpqty.getText()));
			vo.setOqty(txmname.getText());
			vo.setRqty(Integer.parseInt(txsale.getText()));
			sDao.update(vo);
			int index = table.getSelectionModel().getSelectedIndex();
			table.getItems().set(index, vo);
		} catch (NumberFormatException e) {
			System.out.println("변경할 제품을 선택하십시오.");
			lb1.setText("변경할 제품을 선택하십시오.");
		}
    }

    @FXML
    void btdelm(ActionEvent event) {
    	try {
			int index = table.getSelectionModel().getSelectedIndex();
			SCM vo = table.getItems().get(index);
			sDao.delete(vo.getSid());
			table.getItems().remove(index);
		} catch (Exception e) {
			System.out.println("삭제할 제품을 선택하십시오.");
			lb1.setText("삭제할 제품을 선택하십시오.");
		}
    }

    @FXML
    void btselAm(ActionEvent event) {
    	List<SCM> list = sDao.selectAll();
    	table.getItems().clear();
    	table.getItems().addAll(list);
    }
    
    
    
    @FXML
    void btinsm(ActionEvent event) {
    	try {
			SCM vo = new SCM();
			//vo.setSid(Integer.parseInt(txid.getText()));
			vo.setSname(txname.getText());
			vo.setDep(txdep.getText());
			vo.setHid(Integer.parseInt(txmid.getText()));
			vo.setSdate(txdate.getText());
			vo.setPqty(Integer.parseInt(txpqty.getText()));
			vo.setOqty(txmname.getText());
			vo.setRqty(Integer.parseInt(txsale.getText()));
			
			sDao.insert(vo);
			//table.getItems().add(vo);
			
			
			
			int currval = 0;
			
			try {
				String sql = "select Max(sid) from scm";
				Connection conn = ConnFactory.getConnection("lens.config.oracle");
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				rs.next();
				currval = rs.getInt(1);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			vo.setSid(currval);
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
			root.getChildren().remove(scm);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }


    

    @FXML
    void cbdepm(ActionEvent event) {
    	HRS vo = cbdep.getSelectionModel().getSelectedItem();
    	txdep.setText(vo.getDep());
    	txmid.setText(vo.getHid()+"");
    	txmname.setText(vo.getHname());
    	
    }
    
    int x = 0;
    @FXML
    int cbpdm(ActionEvent event) {
//    	SCM vo = cbpd.getSelectionModel().getSelectedItem();
//    	txid.setText(vo.getSid()+"");
//    	txname.setText(vo.getSname());
//    	txdep.setText(vo.getDep());
//    	txmid.setText(vo.getHid()+"");
//    	txpqty.setText(vo.getRqty()+"");
//    	x = Integer.parseInt(txpqty.getText());
    	return x;
   }

    @FXML
    void txdepm(ActionEvent event) {

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
    void txmidm(ActionEvent event) {

    }
    
    @FXML
    void txrqtym(ActionEvent event) {
    	
    	
    }
    
    @FXML
    void txpqtym(ActionEvent event) {

    }
    
    
    @FXML
    void txoqtym(ActionEvent event) {
//    	int y = Integer.parseInt(txoqty.getText())+x;
//    	txrqty.setText(y+"");
    }
    
    @FXML
    void txidm(ActionEvent event) {

    }
    
    @FXML
    void txnamem(ActionEvent event) {

    }
    
    /**
     * @param event 테이블 내용 클릭시 정보 칸에 입력
     */
    @FXML
    void infor(MouseEvent event) {
    	try {
			int index = table.getSelectionModel().getSelectedIndex();
			SCM vo = table.getItems().get(index);
			txid.setText(vo.getSid()+"");
			txname.setText(vo.getSname());
			txdep.setText(vo.getDep());
			txmid.setText(vo.getHid()+"");
			txdate.setText(vo.getSdate());
			txpqty.setText(vo.getPqty()+"");
			txmname.setText(vo.getOqty()+"");
			txsale.setText(vo.getRqty()+"");
		} catch (Exception e) {
			System.out.println("열람할 정보가 없습니다.");
			lb1.setText("열람할 정보가 없습니다.");
		}
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		sDao = new SCMDao();
		oDao = new ODMDao();
		hDao = new HRSDao();
		cDao = new CRSDao();
		
		TVF.setTable(table, SCM.class);
		
//		list = FXCollections.observableArrayList();
//		list.add("콘택트렌즈");list.add("선글라스");list.add("안경");list.add("안경테");
//		cbdep.setItems(list);
		
		cbdep.getItems().addAll(hDao.selectAll());
		
		//cbpd.getItems().addAll(sDao.selectAll());
	}

    

   

}
