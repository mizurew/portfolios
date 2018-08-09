package lens.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lens.common.ConnFactory;
import lens.vo.ODM;
import lens.vo.SCM;

public class ODMDao implements IDao<ODM, Integer> {
	
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
	public void insert(ODM vo) {
		String sql = "INSERT INTO odm(oid,cid,sid,dep,pri,odate,qty,etc) "
				+ "VALUES(oseq.nextval,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			//pstmt.setInt(1, vo.getOrderid());
			//pstmt.setInt(1, vo.getOid());
			pstmt.setInt(1, vo.getCid());
			pstmt.setInt(2, vo.getSid());
			pstmt.setString(3, vo.getDep());
			pstmt.setInt(4, vo.getPri());
			pstmt.setString(5, vo.getOdate());
			pstmt.setInt(6, vo.getQty());
			pstmt.setString(7, vo.getEtc());
			
			int res = pstmt.executeUpdate();
			if(res>0) {
				System.out.println("입력굳");
			}else {
				System.out.println("노답");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void insert2(ODM vo) {
		String sql = "INSERT INTO odm(oid,sid,dep,pri,odate,qty,etc) "
				+ "VALUES(oseq.nextval,?,?,?,?,?,?)";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			//pstmt.setInt(1, vo.getOrderid());
			//pstmt.setInt(1, vo.getOid());
			//pstmt.setInt(1, vo.getCid());
			pstmt.setInt(1, vo.getSid());
			pstmt.setString(2, vo.getDep());
			pstmt.setInt(3, vo.getPri());
			pstmt.setString(4, vo.getOdate());
			pstmt.setInt(5, vo.getQty());
			pstmt.setString(6, vo.getEtc());
			
			int res = pstmt.executeUpdate();
			if(res>0) {
				System.out.println("입력굳");
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
		String sql = "DELETE FROM odm "
				+ "WHERE oid=?";
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
			System.out.println("문제발생");
		}
		
	}
		
	

	@Override
	public void update(ODM vo) {
		String sql = "UPDATE odm "
				+ "SET cid=?,sid=?,dep=?,pri=?,odate=?,qty=?,etc=? "
				+ "WHERE oid=? ";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
						
			
			pstmt.setInt(1, vo.getCid());
			pstmt.setInt(2, vo.getSid());
			pstmt.setString(3, vo.getDep());
			pstmt.setInt(4, vo.getPri());
			String str = vo.getOdate();
			pstmt.setString(5, str.substring(0, 10));
			pstmt.setInt(6, vo.getQty());
			pstmt.setString(7, vo.getEtc());
			pstmt.setInt(8, vo.getOid());
			
			int res = pstmt.executeUpdate();
			if(res>0) {
				System.out.println(vo.getSid()+"갱신잘됨");
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
	public ODM select(Integer primaryKey) {
		String sql = "SELECT * FROM odm "
				+ "WHERE oid=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		ODM vo = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, primaryKey);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo = new ODM();
				vo.setOid(rs.getInt("oid"));
				vo.setCid(rs.getInt("cid"));
				vo.setSid(rs.getInt("sid"));
				vo.setDep(rs.getString("dep"));
				vo.setPri(rs.getInt("pri"));
				vo.setOdate(rs.getString("odate"));
				vo.setQty(rs.getInt("qty"));
				vo.setEtc(rs.getString("etc"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return vo;
	}

	@Override
	public List selectAll() {
		String sql = "SELECT * FROM odm order by oid";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		List<ODM> list = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ODM vo = new ODM();
				vo.setOid(rs.getInt("oid"));
				vo.setCid(rs.getInt("cid"));
				vo.setSid(rs.getInt("sid"));
				vo.setDep(rs.getString("dep"));
				vo.setPri(rs.getInt("pri"));
				vo.setOdate(rs.getString("odate"));
				vo.setQty(rs.getInt("qty"));
				vo.setEtc(rs.getString("etc"));
				
				list.add(vo);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<ODM> find() {
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
