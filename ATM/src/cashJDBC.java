import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class cashJDBC {
	static double balence;
	static String card;
	
public void Balence() {
		ATMMachine atm = new ATMMachine();
		 card = atm.num;
		 try
	        {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/atmmachine", "root", "Root");
	            String query = "select Balence from customers where Card_Number = ?";
	            PreparedStatement ps=con.prepareStatement(query);
	            ps.setString(1, card);
	            ResultSet rs=ps.executeQuery();
	            if(rs.next()) {
	            	balence = rs.getDouble(1);
	            	//System.out.println(balence);
	            } 
	                
	        }
		 catch(Exception e){
	            e.printStackTrace();
	        }
	}

	public void SetBalence() {
		cash c = new cash();
		double Balence = c.updateBalence;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/atmmachine", "root", "Root");
			String query = "update customers set  Balence = ? where Card_Number = ?";
			PreparedStatement ps5=con.prepareStatement(query);
			ps5.setDouble(1, Balence);
			ps5.setString(2, card);
			ps5.executeUpdate();
		}
		catch(Exception e){
			e.printStackTrace();
		}
}

}
