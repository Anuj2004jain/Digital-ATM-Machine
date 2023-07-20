import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class pinChangeJDBC {
	static String password;
	static String card;
	public void getPassword() {
			ATMMachine atm = new ATMMachine();
			card = atm.num;
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
	public void setPassword() {
		pinChange p= new pinChange();
		String pass = p.new_pass;
		try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/atmmachine", "root", "Root");
            String query = "update authenticator set  Password = ? where Card_Number = ?";
            PreparedStatement ps5=con.prepareStatement(query);
            ps5.setString(1, pass);
            ps5.setString(2, card);
            ps5.executeUpdate();
          
                
        }
	 catch(Exception e){
            e.printStackTrace();
        }
	}

}
