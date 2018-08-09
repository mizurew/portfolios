package lens.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lens.common.ConnFactory;

import lens.vo.HRS;


public class HRSDao implements IDao<HRS, Integer> {
	
	private Connection conn = ConnFactory.getConnection("lens.config.oracle");
	
	/**
     * @param event 각 버튼별로 기능
     * ins - 추가
     * del - 삭제
     * cle - 비우기
     * sel - 선택
     * selA - 모두선택
     * upd - 변경
     */
	@Override
	public void insert(HRS vo) {
		String sql = "insert into HRS(hid,hname,pst,dep,sal,hdate,tel,eml) "
				+ "values(hseq.nextval,?,?,?,?,?,?,?) ";
				
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			//pstmt.setInt(1,  vo.getHid());
			pstmt.setString(1, vo.getHname());
			pstmt.setString(2, vo.getPst());
			pstmt.setString(3, vo.getDep());
			pstmt.setInt(4, vo.getSal());
			pstmt.setString(5, vo.getHdate());
			pstmt.setString(6, vo.getTel());
			pstmt.setString(7, vo.getEml());
			
			int res = pstmt.executeUpdate();
			if(res>0) {
				System.out.println("굳");
			}else {
				System.out.println("노답");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(Integer primaryKey) {
		String sql = "DELETE FROM HRS "
		  		+ "WHERE hid=?";
	PreparedStatement pstmt = null;
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, primaryKey);
				int res = pstmt.executeUpdate();
				if(res>0) {
					System.out.println(primaryKey+"삭제잘됨");
				}else {
					System.out.println("삭제안됨");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("잘못입력");
			}
	
}

		
	

	@Override
	public void update(HRS vo) {
		String sql = "UPDATE hrs "
				+ "SET hname=?, pst=?, dep=?, sal=?, hdate=?, tel=?, eml=? "
				+ "WHERE hid=?";
		PreparedStatement pstmt = null; 
				
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getHname());
			pstmt.setString(2, vo.getPst());
			pstmt.setString(3, vo.getDep());
			pstmt.setInt(4, vo.getSal());
			String str = vo.getHdate();
			pstmt.setString(5, str.substring(0, 10));
		//	pstmt.setString(5, vo.getHdate());
			pstmt.setString(6, vo.getTel());
			pstmt.setString(7, vo.getEml());
			pstmt.setInt(8,  vo.getHid());
			
			int res = pstmt.executeUpdate();
			if(res>0) {
				System.out.println(vo.getHid()+"갱신잘됨");
			}else {
				System.out.println("갱신안됨");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("잘못입력");
		}
		
	}

		
	

	@Override
	public HRS select(Integer primaryKey) {
		String sql = "SELECT * FROM hrs "
				+ "WHERE hid=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		HRS vo = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, primaryKey);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo = new HRS();
				vo.setHid(rs.getInt("hid"));
				vo.setHname(rs.getString("hname"));
				vo.setPst(rs.getString("pst"));
				vo.setDep(rs.getString("dep"));
				vo.setSal(rs.getInt("sal"));
				vo.setHdate(rs.getString("hdate"));
				vo.setTel(rs.getString("tel"));
				vo.setEml(rs.getString("eml"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return vo;
	}

	@Override
	public List selectAll() {
		String sql = "SELECT * FROM hrs order by hid";
		Statement stmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		List<HRS> list = new ArrayList<>();
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				HRS vo = new HRS();
				vo.setHid(rs.getInt("hid"));
				vo.setHname(rs.getString("hname"));
				vo.setPst(rs.getString("pst"));
				vo.setDep(rs.getString("dep"));
				vo.setSal(rs.getInt("sal"));
				vo.setHdate(rs.getString("hdate"));
				vo.setTel(rs.getString("tel"));
				vo.setEml(rs.getString("eml"));
								
				list.add(vo);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}
	

	@Override
	public List<HRS> find() {
		// TODO Auto-generated method stub
		return null;
	}
	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
