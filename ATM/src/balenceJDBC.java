import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class balenceJDBC {
	static String card;
	static double balence;
	static String Acc_num;
	static String password;
	public void Balence() {
		
		ATMMachine atm = new ATMMachine();
		 card = atm.num;
		 try
	        {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/atmmachine", "root", "Root");
	            String query = "select Balence,Account_Number from customers where Card_Number = ?";
	            PreparedStatement ps=con.prepareStatement(query);
	            ps.setString(1, card);
	            ResultSet rs=ps.executeQuery();
	            if(rs.next()) {
	            	balence = rs.getDouble(1);
	            	Acc_num = rs.getString(2);
	            	//System.out.println(balence);
	            } 
	                
	        }
		 catch(Exception e){
	            e.printStackTrace();
	        }
	}
	public void password() {
			 try
		        {
		            Class.forName("com.mysql.cj.jdbc.Driver");
		            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/atmmachine", "root", "Root");
		            String query = "select Password from authenticator where Card_Number = ?";
		            PreparedStatement ps2=con.prepareStatement(query);
		            ps2.setString(1, card);
		            ResultSet rs2=ps2.executeQuery();
		            if(rs2.next()) {
		            	password = rs2.getString(1);
		            }
		      
		        }
			 catch(Exception e){
		            e.printStackTrace();
		        }
	}

}
