import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ATMmachineJDBC {
	static ArrayList<String> l = new ArrayList<String>();
	public void card() {
		 try
	        {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/atmmachine", "root", "Root");
	            String query = "select Card_Number from customers";
	            PreparedStatement ps=con.prepareStatement(query);
	            ResultSet rs=ps.executeQuery();
	            while(rs.next()) {
	            	l.add(rs.getString(1));
	            	
	            }
	                
	        }
		 catch(Exception e){
	            e.printStackTrace();
	        }
	}
	public static void main(String[] args) {
		ATMmachineJDBC a = new ATMmachineJDBC();
		a.card();
	}

}
