import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdateExam {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@192.168.0.52:1522:orcl";
		Connection con = null;
		Statement stmt = null;
		
		String hakbun,addr,phone;
		
		try {
			
			BufferedReader br = new BufferedReader(
					new InputStreamReader(System.in));
			System.out.print("갱신할 학번 입력: ");
			hakbun = br.readLine();
			System.out.print("새 주소 입력: ");
			addr = br.readLine();
			System.out.print("새 전화번호 입력: ");
			phone = br.readLine();
			
			String sql = "Update member Set addr = '"+addr;
			sql += "',phone = '" + phone + "'Where hakbun ='";
			sql += hakbun +"'";
			System.err.println(sql);
			Class.forName(driver);
			con = DriverManager.getConnection(url,"scott","123456");
			stmt = con.createStatement();
			 stmt.executeUpdate(sql);
			 System.out.println("데이터베이스 내용 갱신 성공");
			
		} catch (Exception e) {
			System.out.println("데이터 연결 실패! = "+e.getMessage());
		}
		finally {
			try {
				if(con != null) con.close();
				if(stmt != null) stmt.close();
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		}

}

