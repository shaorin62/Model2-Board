package net.board.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds;
	public MemberDAO(){
		try{
			Context init = new InitialContext();
			DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
			con = ds.getConnection();
			
		}catch(Exception ex){
			System.out.println("DB 연결실패 : " + ex);
			return;
		}
	}
	
	public int isMember(MemberBean member){
			String sql = "select password from member where id = ?";
			int result = -1;
			
		try{
		
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getID());
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				if(rs.getString("password").equals(member.getPASSWORD())){
					result = 1; //일치
				}else{
					result = 0; //불일치
				}
			}else{
				result = -1; //아이디가 존재하지 않음
			}
			
		}catch(Exception ex){
			System.out.println("isMember 오류 : " + ex);
		}finally{
			if(rs!=null)try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null)try{pstmt.close();}catch(SQLException ex){}
			if(con!=null)try{con.close();}catch(SQLException ex){}
		}
		return result;
	}
	public boolean joinMember(MemberBean member){
		
		String sql = "insert into member values(?,?,?,?,?,?)";
		int result = 0;
		
		try{
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getID());
			pstmt.setString(2, member.getPASSWORD());
			pstmt.setString(3, member.getNAME());
			pstmt.setInt(4, member.getAGE());
			pstmt.setString(5, member.getGENDER());
			pstmt.setString(6, member.getEMAIL());
			
			
			
			
			result = pstmt.executeUpdate();
			
			if(result!=0){
				return true;
			}
			
		}catch(Exception ex){
			System.out.println("joinMember 에러 : " + ex);
		}finally{
			if(rs!=null)try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null)try{pstmt.close();}catch(SQLException ex){}
			if(con!=null)try{con.close();}catch(SQLException ex){}
		}
		return false;
	}
	
	public List getMemberList(){
		String sql = "select * from member";
		List memberlist = new ArrayList();
		
		try{
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				MemberBean mb = new MemberBean();
				mb.setID(rs.getString("ID"));
				mb.setPASSWORD(rs.getString("PASSWORD"));
				mb.setNAME(rs.getString("NAME"));
				mb.setAGE(rs.getInt("AGE"));
				mb.setGENDER(rs.getString("GENDER"));
				mb.setEMAIL(rs.getString("EMAIL"));
				
				memberlist.add(mb);
			}
			return memberlist;
			
		}catch(Exception ex){
			System.out.println("getMemberList 에러 : " + ex);
		}finally{
			if(rs!=null)try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null)try{pstmt.close();}catch(SQLException ex){}
			if(con!=null)try{con.close();}catch(SQLException ex){}
		}
		return null;
	}
	
	public MemberBean getDetailMember(String id){
		String sql = "select * from member where id = ?";
		
		try{
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			rs.next();
			
			MemberBean mb = new MemberBean();
			mb.setID(rs.getString("ID"));
			mb.setPASSWORD(rs.getString("PASSWORD"));
			mb.setNAME(rs.getString("NAME"));
			mb.setAGE(rs.getInt("AGE"));
			mb.setGENDER(rs.getString("GENDER"));
			mb.setEMAIL(rs.getString("EMAIL"));
			
			return mb;
			
		}catch(Exception ex){
			System.out.println("getDetailMember  에러" + ex );
		}finally{
			if(rs!=null)try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null)try{pstmt.close();}catch(SQLException ex){}
			if(con!=null)try{con.close();}catch(SQLException ex){}
		}
		return null;
	}
	
	public boolean deleteMember(String id){
		String sqlmember = "delete from member where id = ?";
		String sqlboard = "delete from board where board_id = ?";
		boolean isSuccess = false;
		int result = 0, result1 = 0;
		

		try{
			con = ds.getConnection();
			con.setAutoCommit(false);
			
			pstmt = con.prepareStatement(sqlmember);
			pstmt.setString(1, id);
			result = pstmt.executeUpdate();
			
			pstmt = con.prepareStatement(sqlboard);
			pstmt.setString(1, id);
			result1 = pstmt.executeUpdate();
			
			if(result>0 && result1>0 ){
				return true;
			}
			isSuccess = true;
			
		}catch(Exception ex){
			System.out.println("deleteMember 에러 : " + ex);
		}finally{
			
			try{
				if(isSuccess){
					con.commit();
				}else{
					con.rollback();
				}
			}catch(Exception e){}
			if(rs!=null)try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null)try{pstmt.close();}catch(SQLException ex){}
			if(con!=null)try{con.close();}catch(SQLException ex){}
		}
		return false;
	}
	public int idValidation(MemberBean member){
		String sql = "select id from member where id = ?";
		int result = 0;
		
	try{
	
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, member.getID());
		rs = pstmt.executeQuery();
		
		if(rs.next()){
			if(rs.getString("id").equals(member.getID())){
				result = 1; //일치
			}
		}else{
			result = -1; //아이디가 존재하지 않음
		}
		
	}catch(Exception ex){
		System.out.println("idValidation 오류 : " + ex);
	}finally{
		if(rs!=null)try{rs.close();}catch(SQLException ex){}
		if(pstmt!=null)try{pstmt.close();}catch(SQLException ex){}
		if(con!=null)try{con.close();}catch(SQLException ex){}
	}
	return result;
}
}
