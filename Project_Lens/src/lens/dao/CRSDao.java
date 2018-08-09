package lens.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lens.common.ConnFactory;
import lens.vo.CRS;
import lens.vo.SCM;

public class CRSDao implements IDao<CRS, Integer> {
	
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
	public void insert(CRS vo) {
	
			String sql = "INSERT INTO crs(cid,cname,grade,loc,cdate,addy,eaddy) "
					+ "VALUES(cseq.nextval,?,?,?,?,?,?) ";
				
			PreparedStatement pstmt = null;
			
			try {
				pstmt = conn.prepareStatement(sql);
				//pstmt.setInt(1, vo.getOrderid());
				//pstmt.setInt(1, vo.getCid());
				pstmt.setString(1, vo.getCname());
				pstmt.setString(2, vo.getGrade());
				pstmt.setString(3, vo.getLoc());
				pstmt.setString(4, vo.getCdate());
				pstmt.setString(5, vo.getAddy());
				pstmt.setString(6, vo.getEaddy());
				
				
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
		String sql = "DELETE FROM crs "
				+ "WHERE cid=?";
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
	public void update(CRS vo) {
		String sql = "UPDATE crs "
				+ "SET cname=?, grade=?, loc=?, cdate=?, addy=?, eaddy=?  "
				+ "WHERE cid=? ";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
						
			
			pstmt.setString(1, vo.getCname());
			pstmt.setString(2, vo.getGrade());
			pstmt.setString(3, vo.getLoc());
			String str = vo.getCdate();
			pstmt.setString(4, str.substring(0, 10));
			pstmt.setString(5, vo.getAddy());
			pstmt.setString(6, vo.getEaddy());
			pstmt.setInt(7, vo.getCid());
			
			int res = pstmt.executeUpdate();
			if(res>0) {
				System.out.println(vo.getCid()+"갱신잘됨");
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
	public CRS select(Integer primaryKey) {
		String sql = "SELECT * FROM crs "
				+ "WHERE cid=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		CRS vo = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, primaryKey);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo = new CRS();
				vo.setCid(rs.getInt("cid"));
				vo.setCname(rs.getString("cname"));
				vo.setGrade(rs.getString("grade"));
				vo.setLoc(rs.getString("loc"));
				vo.setCdate(rs.getString("cdate"));
				vo.setAddy(rs.getString("addy"));
				vo.setEaddy(rs.getString("eaddy"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return vo;
	}
	

	@Override
	public List selectAll() {
		String sql = "SELECT * FROM crs order by cid";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		List<CRS
		
		> list = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				CRS vo = new CRS();
				vo.setCid(rs.getInt("cid"));
				vo.setCname(rs.getString("cname"));
				vo.setGrade(rs.getString("grade"));
				vo.setLoc(rs.getString("loc"));
				vo.setCdate(rs.getString("cdate"));
				vo.setAddy(rs.getString("addy"));
				vo.setEaddy(rs.getString("eaddy"));
				
				
				list.add(vo);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<CRS> find() {
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
