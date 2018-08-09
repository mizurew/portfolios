package lens.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lens.vo.SCM;

import lens.common.ConnFactory;

public class SCMDao implements IDao<SCM, Integer> {
	
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
	public void insert(SCM vo) {										//
		String sql = "INSERT INTO scm(sid, sname, dep, hid, sdate, pqty, oqty, rqty) "
				+ "VALUES(sseq.nextval,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			//pstmt.setInt(1, vo.getOrderid());
			//pstmt.setInt(1, vo.getSid());
			pstmt.setString(1, vo.getSname());
			pstmt.setString(2, vo.getDep());
			pstmt.setInt(3, vo.getHid());
			pstmt.setString(4, vo.getSdate());
			pstmt.setInt(5, vo.getPqty());
			pstmt.setString(6, vo.getOqty());
			pstmt.setInt(7, vo.getRqty());
			
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
		String sql = "DELETE FROM scm "
				+ "WHERE sid=?";
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
	
	public void update2(SCM vo) {
		String sql = "update scm "
				+ "set pqty=?, rqty=? "
				+ "where sid=? ";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,  vo.getPqty());
			pstmt.setInt(2, vo.getRqty());
			pstmt.setInt(3, vo.getSid());
			
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
	public void update(SCM vo) {
		String sql = "UPDATE scm "									//	
				+ "SET sname=?, dep=?, hid=?, sdate=?, pqty=?, oqty=?, rqty=? "
				+ "WHERE sid=? ";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
						
			pstmt.setString(1, vo.getSname());
			pstmt.setString(2, vo.getDep());
			pstmt.setInt(3, vo.getHid());
			String str = vo.getSdate();
			pstmt.setString(4, str.substring(0, 10));
//			pstmt.setString(4, vo.getSdate());
			pstmt.setInt(5, vo.getPqty());
			pstmt.setString(6, vo.getOqty());
			pstmt.setInt(7, vo.getRqty());
			pstmt.setInt(8, vo.getSid());
			
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
	public SCM select(Integer primaryKey) {
		String sql = "SELECT * FROM scm "
				+ "WHERE sid=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		SCM vo = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, primaryKey);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo = new SCM();
				vo.setSid(rs.getInt("sid"));
				vo.setSname(rs.getString("sname"));
				vo.setDep(rs.getString("dep"));
				vo.setHid(rs.getInt("hid"));
				vo.setSdate(rs.getString("sdate"));
				vo.setPqty(rs.getInt("pqty"));
				vo.setOqty(rs.getString("oqty"));
				vo.setRqty(rs.getInt("rqty"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return vo;
	}
	

	@Override
	public List selectAll() {
		String sql = "SELECT * FROM scm order by sid";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		List<SCM> list = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				SCM vo = new SCM();
				vo.setSid(rs.getInt("sid"));
				vo.setSname(rs.getString("sname"));
				vo.setDep(rs.getString("dep"));
				vo.setHid(rs.getInt("hid"));
				vo.setSdate(rs.getString("sdate"));
				vo.setPqty(rs.getInt("pqty"));
				vo.setOqty(rs.getString("oqty"));
				vo.setRqty(rs.getInt("rqty"));
				
				list.add(vo);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	@Override
	public List<SCM> find() {
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
