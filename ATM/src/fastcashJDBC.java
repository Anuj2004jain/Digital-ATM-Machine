import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class fastcashJDBC {
	static String card;
	static String password;
	static Double balence;
	
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
		fastCash fc = new fastCash();
		double Balence = fc.updatedBalence;
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
		
	public void password() {
		//System.out.println("password");
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
