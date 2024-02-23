package customer.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import customer.db.DbConn;
import customer.vo.Notice;

public class NoticeDao {
	public void write(Notice n) throws Exception {
		Connection conn=null;
		String sql="";

			String driver="oracle.jdbc.driver.OracleDriver";
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String user="hr";
			String pass="123456";
			
			Class.forName(driver);
			
			PreparedStatement pstmt=null;
			conn=DriverManager.getConnection(url,user,pass);
			sql="insert into notices values "
				+" ((select max(to_number(seq)) "
				+" from notices)+1,?,'bg',?,systimestamp,0) ";
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,n.getTitle());
			pstmt.setString(2,n.getContent());
			pstmt.executeUpdate();
			
			
			pstmt.close();
			conn.close();

	}
	
	public void update(Notice n) throws Exception {
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="";

			String driver="oracle.jdbc.driver.OracleDriver";
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String user="hr";
			String pass="123456";
			
			Class.forName(driver);
			conn=DriverManager.getConnection(url,user,pass);
			sql="update notices set title=?, content=? where seq=?";
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1,n.getTitle());
			pstmt.setString(2,n.getContent());
			pstmt.setString(3,n.getSeq());
			
			pstmt.executeUpdate();
			
			

	}
	
	public int delete(String seq) throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="hr";
		String pw="123456";
		Connection conn=DriverManager.getConnection(url,user,pw);

		//실행
		String sql="delete from notices where seq=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1,seq);
		int delcnt=pstmt.executeUpdate();
		
		return delcnt;
	}
	
	public Notice getDetail(String seq) throws Exception{
		Connection conn=DbConn.getConnection();
		String sql=" select seq,title, writer, content, regdate, hit from notices where seq="+seq;
		
		//실행
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		rs.next();
		
		Notice n=new Notice();
		n.setSeq(rs.getString("seq"));
		n.setTitle(rs.getString("title"));
		n.setWriter(rs.getString("writer"));
		n.setContent(rs.getString("content"));
		n.setRegdate(rs.getDate("regdate"));
		n.setHit(rs.getInt("hit"));
		
		return n;
		
//		rs.close();
//		stmt.close();
//		conn.close();
	}
	
}
