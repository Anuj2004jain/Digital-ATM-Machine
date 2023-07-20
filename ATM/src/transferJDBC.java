import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
public class transferJDBC {
	static double balence;
	static String IFSC;
	static String Name;
	static String card;
	static String password;
	static String Acc;
	static Double Acc_Balence;
	static ArrayList<String> l = new ArrayList<String>();
	public void Balence() {
		ATMMachine atm = new ATMMachine();
		 card = atm.num;
		 //System.out.println(card);
		//String card = "243456676675";
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
	
	
	public void AccountDetails() {
		transfer t = new transfer();
		Acc = t.num;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/atmmachine", "root", "Root");
			String query = "Select IFSC_Code, Name, Balence from customers where Account_Number = ? ";
			PreparedStatement ps1=con.prepareStatement(query);
			ps1.setString(1, Acc);
            ResultSet rs1=ps1.executeQuery();
            if(rs1.next()) {
            	IFSC= rs1.getString(1);
            	Name= rs1.getString(2);
            	Acc_Balence = rs1.getDouble(3);
            	
            	//System.out.println(rs1.getString(1));
            	//System.out.println(rs1.getString(2));
            }
		}
		catch(Exception e){
			System.out.println("Account no. does not exist");
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
	
	public void Account() {
		try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/atmmachine", "root", "Root");
            String query = "select Account_Number from customers";
            PreparedStatement ps3=con.prepareStatement(query);
            ResultSet rs3=ps3.executeQuery();
            while(rs3.next()) {
            	l.add(rs3.getString(1));	
            }
            //System.out.println(l);   
        }
	 catch(Exception e){
            e.printStackTrace();
        }
	}
	public void SetReciverBalence() {
		transfer t = new transfer();
		Double Balence = t.updateReciverBalence;
		try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/atmmachine", "root", "Root");
            String query = "update customers set  Balence = ? where Account_Number = ?";
            PreparedStatement ps4=con.prepareStatement(query);
            ps4.setDouble(1, Balence);
            ps4.setString(2, Acc);
            ps4.executeUpdate();
          
                
        }
	 catch(Exception e){
            e.printStackTrace();
        }
	}
	
	public void SetSenderBalence() {
		transfer t = new transfer();
		Double Balence = t.updatesenderBalence;
		try
        {
			
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/atmmachine", "root", "Root");
            String query = "update customers set  Balence = ? where Card_Number = ?";
            PreparedStatement ps5=con.prepareStatement(query);
            ps5.setDouble(1, t.updatesenderBalence);
            
            ps5.setString(2, card);
            ps5.executeUpdate();
          
                
        }
	 catch(Exception e){
            e.printStackTrace();
        }
	}

	/*
	 * public static void main(String[] args) { transferJDBC t = new transferJDBC();
	 * t.Balence(); }
	 */

}



