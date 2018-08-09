package lens.make;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

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
import lens.vo.CRS;
import lens.vo.ODM;
import lens.vo.SCM;

/**
 * @author ict-11
 *
 */
public class ODMCon implements Initializable{
	
	@FXML
	private ComboBox<CRS> cbcid;

    @FXML
    private TextField txcid;

    @FXML
    private Button btfin;

    @FXML
    private Button btdel;

    @FXML
    private Button btins;

    @FXML
    private TextField txqty;

    @FXML
    private TextField txid;

    @FXML
    private TextField txetc;

    @FXML
    private Button btselA;

    @FXML
    private Button btupd;
    
    @FXML
    private Button btins2;

    @FXML
    private TextField txdate;

    @FXML
    private DatePicker picdate;

    @FXML
    private TextField txsid;

    @FXML
    private Button btcle;

    @FXML
    private ComboBox<?> cbdep;

    @FXML
    private TextField txdep;

    @FXML
    private Button btback;

    @FXML
    private Button btsel;
    
    @FXML
    private Button btrs;
    
    @FXML
    private Button bttl;

    @FXML
    private AnchorPane odm;

    @FXML
    private TextField txpri;
    
    @FXML
    private TextField txopri;
    
    @FXML
    private TextField txpqty;
   
    @FXML
    private TextField txrqty;
    
    @FXML
    private TextField txspri;
    
    @FXML
    private TextField txopri2;
    
    @FXML
    private Button btqty;

    @FXML
    private ComboBox<SCM> cbsid;

    @FXML
    private TableView<ODM> table;
    
    @FXML
    private Label lb1;
    
    public static SCMDao sDao;
    public static HRSDao hDao;
    public static ODMDao oDao;
    public static CRSDao cDao;
    
    
  
    /**
     * @param event 수량자동계산
     */
    @FXML
    void btqtym(ActionEvent event) {
    	try {
			txrqty.setText((Integer.parseInt(txpqty.getText())
					+Integer.parseInt(txqty.getText()))+"");
		} catch (NumberFormatException e) {
			System.out.println("정보입력 후 사용하십시오.");
			lb1.setText("정보입력 후 사용하십시오.");
		}
    }
    
    
    /**
     * @param event 총액과 결과총액 계산
     */
    @FXML
    void bttlm(ActionEvent event) {
    	
			try {
				txopri.setText((Integer.parseInt(txqty.getText())
						*Integer.parseInt(("-"+txpri.getText())))+"");
				txopri2.setText(Integer.parseInt(txspri.getText())
						+Integer.parseInt(txopri.getText())+"");
			} catch (NumberFormatException e) {
				System.out.println("필요한 정보가 빠졌습니다.");
				lb1.setText("필요한 정보가 빠졌습니다.");
			}
		
    }
    
    @FXML
    void txsprim(ActionEvent event) {
    	
    }
    
    @FXML
    void txopri2m(ActionEvent event) {
    	
    }
    
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
    	txcid.clear();
    	txsid.clear();
    	txdep.clear();
    	txpri.clear();
    	txdate.clear();
    	txqty.clear();
    	txetc.clear();
    	txrqty.clear();
    	txopri.clear();
    	txpqty.clear();
    	txspri.clear();
    	txopri2.clear();
    	lb1.setText("");
    
    }
    
    /**
     * @param event 고객id 자동입력
     */
    @FXML
    void cbcidm(ActionEvent event) {
    	CRS vo = cbcid.getSelectionModel().getSelectedItem();
    	txcid.setText(vo.getCid()+"");
    }

    @FXML
    void txetcm(ActionEvent event) {

    }

    @FXML
    void cbdepm(ActionEvent event) {

    }

    @FXML
    void txdepm(ActionEvent event) {

    }

    /**
     * @param event 제품아이디 선택시 매출액과 재고량 입력
     */
    @FXML
    void cbsidm(ActionEvent event) {
    	SCM vo = cbsid.getSelectionModel().getSelectedItem();
    	txsid.setText(vo.getSid()+"");
    	txpqty.setText(vo.getPqty()+"");
    	txdep.setText(vo.getSname());
    	txspri.setText(vo.getRqty()+"");
    }

    @FXML
    void txdatem(ActionEvent event) {

    }

    int x=0;
    int t=0;
    @FXML
    int txprim(ActionEvent event) {
    	 x = Integer.parseInt(txpri.getText());
    	 return x;
    }
    int z=0;
    @FXML
    int txpqtym(ActionEvent event) {
    	z = Integer.parseInt(txpqty.getText());
    	return z;
    }
    
    int r=0;
    @FXML
    void txqtym(ActionEvent event) {
     
    	t =x*Integer.parseInt(txqty.getText());
    	 r = z+Integer.parseInt(txqty.getText());
     txopri.setText(t+"");
    
     txrqty.setText(r+"");
    }
    
    
    @FXML
    void txrqtym(ActionEvent event) {
    	
    	
    	
    	
    }
        
    
    @FXML
    void txoprim(ActionEvent event) {

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
    void txsidm(ActionEvent event) {

    }

    @FXML
    void txcidm(ActionEvent event) {

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

    @FXML
    void btsel(ActionEvent event) {
    	try {
			int index = Integer.parseInt(txid.getText());
			ODM vo = oDao.select(index);
			table.getItems().add(vo);
		} catch (NumberFormatException e) {
			System.out.println("생산/주문 선택 후 사용하십시오.");
			lb1.setText("생산/주문 선택 후 사용하십시오.");
		}
    }

    @FXML 
    void btupdm(ActionEvent event) {
    	try {
			ODM vo = new ODM();
			vo.setOid(Integer.parseInt(txid.getText()));
			vo.setCid(Integer.parseInt(txcid.getText()));
			vo.setSid(Integer.parseInt(txsid.getText()));
			vo.setDep(txdep.getText());
			vo.setPri(Integer.parseInt(txpri.getText()));
			vo.setOdate(txdate.getText());
			vo.setQty(Integer.parseInt(txqty.getText()));
			vo.setEtc(txetc.getText());
			oDao.update(vo);
			int index = table.getSelectionModel().getSelectedIndex();
			table.getItems().set(index, vo);
		} catch (NumberFormatException e) {
			System.out.println("변경할 생산/주문을 선택하십시오.");
			lb1.setText("변경할 생산/주문을 선택하십시오.");
		}
    }

    @FXML
    void btdelm(ActionEvent event) {
    	try {
			int index = table.getSelectionModel().getSelectedIndex();
			ODM vo = table.getItems().get(index);
			oDao.delete(vo.getOid());
			table.getItems().remove(index);
			
			SCM vo2 = new SCM();
			
			 
			vo2.setSid(Integer.parseInt(txsid.getText()));
			int p = Integer.parseInt(txpqty.getText())-Integer.parseInt(txqty.getText());
			int u = Integer.parseInt(txspri.getText())-Integer.parseInt(txopri.getText());
			vo2.setPqty(p);
			vo2.setRqty(u);
			sDao.update2(vo2);
		} catch (Exception e) {
			System.out.println("삭제할 생산/주문을 선택하십시오.");
			System.out.println("제품을 재선택해 필요한 정보를 입력하시기 바랍니다.");
			lb1.setText("삭제할 생산/주문을 선택하십시오.");
			
		}
    	
    }

    @FXML
    void btselAm(ActionEvent event) {
    	List<ODM> list = oDao.selectAll();
    	table.getItems().clear();
    	table.getItems().addAll(list);
    }
    
    @FXML
    void btinsm2(ActionEvent event) {
    	try {
			ODM vo = new ODM();
			//SCM vo2 = new SCM();
			//vo.setOid(Integer.parseInt(txid.getText()));
			//vo.setCid(Integer.parseInt(txcid.getText()));
			vo.setSid(Integer.parseInt(txsid.getText()));
			vo.setDep(txdep.getText());
			vo.setPri(Integer.parseInt(txpri.getText()));
			vo.setOdate(txdate.getText());
			vo.setQty(Integer.parseInt(txqty.getText()));
			vo.setEtc(txetc.getText());
			
			oDao.insert2(vo);
			int currval = 0;
			
			try {
				String sql = "select Max(oid) from odm";
				Connection conn = ConnFactory.getConnection("lens.config.oracle");
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				rs.next();
				currval = rs.getInt(1);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			vo.setOid(currval);
			table.getItems().add(vo);
			
			SCM vo2 = new SCM();
			vo2.setSid(Integer.parseInt(txsid.getText()));
			vo2.setPqty(Integer.parseInt(txrqty.getText()));
			vo2.setRqty(Integer.parseInt(txopri2.getText()));
			sDao.update2(vo2);
		} catch (NumberFormatException e) {
			System.out.println("필요한 정보를 모두 입력해주십시오.");
			lb1.setText("필요한 정보를 모두 입력해주십시오.");
		}
    }
    
   
    
    
    @FXML
    void btinsm(ActionEvent event) {
    	try {
			ODM vo = new ODM();
			//SCM vo2 = new SCM();
			//vo.setOid(Integer.parseInt(txid.getText()));
			vo.setCid(Integer.parseInt(txcid.getText()));
			vo.setSid(Integer.parseInt(txsid.getText()));
			vo.setDep(txdep.getText());
			vo.setPri(Integer.parseInt(txpri.getText()));
			vo.setOdate(txdate.getText());
			vo.setQty(Integer.parseInt(txqty.getText()));
			vo.setEtc(txetc.getText());
			
			oDao.insert(vo);
			int currval = 0;
			
			try {
				String sql = "select Max(oid) from odm";
				Connection conn = ConnFactory.getConnection("lens.config.oracle");
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				rs.next();
				currval = rs.getInt(1);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			vo.setOid(currval);
			table.getItems().add(vo);
			
			SCM vo2 = new SCM();
			vo2.setSid(Integer.parseInt(txsid.getText()));
			vo2.setPqty(Integer.parseInt(txrqty.getText()));
			vo2.setRqty(Integer.parseInt(txopri2.getText()));
			sDao.update2(vo2);
		} catch (NumberFormatException e) {
			System.out.println("입력시 필요한 내용이 빠졌습니다.");
			lb1.setText("입력시 필요한 내용이 빠졌습니다.");
		}
    	
//    	vo2.setSname(txdep.getText());
//    	vo2.setSdate(txdate.getText());
//    	vo2.setDep(txetc.getText());
//    	vo2.setPqty(Integer.parseInt(txpqty.getText()));
//    	vo2.setOqty(txqty.getText());
//    	vo2.setRqty(Integer.parseInt(txrqty.getText()));
//    	vo2.setHid(Integer.parseInt(txcid.getText()));
//    	sDao.insert(vo2);
//    	
//    	int currval2 = 0;
//    	
//    	try {
//			String sql = "select Max(sid) from scm";
//			Connection conn = ConnFactory.getConnection("lens.config.oracle");
//			PreparedStatement pstmt = conn.prepareStatement(sql);
//			ResultSet rs2 = pstmt.executeQuery();
//			rs2.next();
//			currval2 = rs2.getInt(1);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    	vo.setSid(currval2);
    	
    }

    @FXML
    void btbackm(ActionEvent event) {
    	try {
    		StackPane root = (StackPane)btback.getScene().getRoot();
    		root.getChildren().remove(odm);
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
			ODM vo = table.getItems().get(index);
			txid.setText(vo.getOid()+"");
			txcid.setText(vo.getCid()+"");
			txsid.setText(vo.getSid()+"");
			txdep.setText(vo.getDep());
			txpri.setText(vo.getPri()+"");
			txdate.setText(vo.getOdate());
			txqty.setText(vo.getQty()+"");
			txetc.setText(vo.getEtc()+"");
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
		
		TVF.setTable(table, ODM.class);
		
		
		cbcid.getItems().addAll(cDao.selectAll());
		cbsid.getItems().addAll(sDao.selectAll());
	}

}







