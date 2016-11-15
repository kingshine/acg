package daoImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Novel;
import dao.NovelDAO;
import db.MysqlOperator;

public  class novelDAOImpl implements NovelDAO  {
	public Novel findNovelbyName(String name){
		Connection conn = MysqlOperator.getConn();
		String novelname ="%"+name+"%";
	    String sql = "select * from novel where name like ?";
	    Novel novel=new Novel();
	    PreparedStatement pstmt=null;
	    ResultSet rs=null;
	    try {
	        pstmt =conn.prepareStatement(sql); 
	        pstmt.setString(1,novelname);
	        rs = pstmt.executeQuery();
	        if(rs.next()){
	        	novel=new Novel();
	        	novel.setName(rs.getString(1));
	        	novel.setAuthor(rs.getString(2));
	        	novel.setIllustrator(rs.getString(3));
	        	novel.setLibrary(rs.getString(4));
	        	novel.setCharacter(rs.getString(5));
	        	novel.setSynopsis(rs.getString(6));
	        	novel.setNumber(rs.getInt(7));
	        	novel.setScore(rs.getInt(8));
	        	novel.setRemarks(rs.getString(9));
	        }
	         
	    } catch (SQLException e) {
	        e.printStackTrace();
	    
	    
	}finally {
		MysqlOperator.clearup(pstmt, rs); 
		MysqlOperator.clearup(conn);
	}
		return novel;		
	}
	public List<Novel>findNovelbyItem(String item,String condition){
		Connection conn = MysqlOperator.getConn();
	    String sql = "";
	    switch(item){
	    case "name" :
	    	sql="select * from novel where name like ? ;";
	    	break;
	    case "score":
	    	sql="select * from novel where  score >= ? ;";
	    	break;
	    case "character" :
	    	sql="select * from novel where `character` like ? ;";
	    }
	    List<Novel> novels=new ArrayList<Novel>();
	    PreparedStatement pstmt=null;
	    ResultSet rs=null;
	    try {
	        pstmt =conn.prepareStatement(sql);	    	
	        if(item.equals("score")){
	        	int score=Integer.parseInt(condition);   		    
	        	pstmt.setInt(1, score);
	        }else{
	        	condition="%"+condition+"%";
	        pstmt.setString(1, condition);
	        }
	        rs = pstmt.executeQuery();
	        while(rs.next()){
	        	Novel novel=new Novel();
	        	novel.setName(rs.getString(1));
	        	novel.setAuthor(rs.getString(2));
	        	novel.setIllustrator(rs.getString(3));
	        	novel.setLibrary(rs.getString(4));
	        	novel.setCharacter(rs.getString(5));
	        	novel.setSynopsis(rs.getString(6));
	        	novel.setNumber(rs.getInt(7));
	        	novel.setScore(rs.getInt(8));
	        	novel.setRemarks(rs.getString(9));
	        	novels.add(novel);
	        }
	            
	    } catch (SQLException e) {
	        e.printStackTrace();
	    
	    }finally{
	    	MysqlOperator.clearup(pstmt, rs);
	    	MysqlOperator.clearup(conn);
	}
		return novels;		
	}
	public List<Novel> findAllNovel() {
		// TODO Auto-generated method stub
		Connection conn = MysqlOperator.getConn();
	    String sql = "select * from novel";
	    List<Novel> novels=new ArrayList<Novel>();
	    PreparedStatement pstmt=null;
	    ResultSet rs=null;
	    try {
	        pstmt =conn.prepareStatement(sql); 
	        rs = pstmt.executeQuery();
	        while(rs.next()){
	        	Novel novel=new Novel();
	        	novel.setName(rs.getString(1));
	        	novel.setAuthor(rs.getString(2));
	        	novel.setIllustrator(rs.getString(3));
	        	novel.setLibrary(rs.getString(4));
	        	novel.setCharacter(rs.getString(5));
	        	novel.setSynopsis(rs.getString(6));
	        	novel.setNumber(rs.getInt(7));
	        	novel.setScore(rs.getInt(8));
	        	novel.setRemarks(rs.getString(9));
	        	novels.add(novel);
	        }
	         
	    } catch (SQLException e) {
	        e.printStackTrace();
	    
	    
	}finally {
		MysqlOperator.clearup(pstmt, rs); 
		MysqlOperator.clearup(conn);
	}
		return novels;		
	}
	public void addNovel(Novel novel){
		Connection conn = MysqlOperator.getConn();
		String sql = "insert into novel values (?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt=null;
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, novel.getName());
			pstmt.setString(2, novel.getAuthor());
			pstmt.setString(3, novel.getIllustrator());
			pstmt.setString(4, novel.getLibrary());
			pstmt.setString(5, novel.getCharacter());
			pstmt.setString(6, novel.getSynopsis());
			pstmt.setInt(7, novel.getNumber());
			pstmt.setInt(8, novel.getScore());
			pstmt.setString(9, novel.getRemarks());
		    pstmt.executeUpdate();			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			MysqlOperator.clearup(pstmt, null); 
			MysqlOperator.clearup(conn);
		}
		
	}
	public void delNovel(String name){
		Connection conn = MysqlOperator.getConn();
		String sql = "delete from novel where name = ?";
		PreparedStatement pstmt=null;
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, name);
		    pstmt.executeUpdate();		
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			MysqlOperator.clearup(pstmt, null); 
			MysqlOperator.clearup(conn);
		}
		
	}
}	
	
	
	



