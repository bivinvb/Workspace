//STEP 1. Import required packages
import java.sql.*;

public class FirstExample {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";  
   static final String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";

   //  Database credentials
   static final String USER = "bivin";
   static final String PASS = "bivin123";
   
   public static void main(String[] args) {
   Connection conn = null;
   Statement stmt = null;
   String serverName = "127.0.0.1";
   String portNumber = "1521";
   String sid = "XE";
   String url = "jdbc:oracle:thin:@" + serverName + ":" + portNumber + ":" + sid;
   String username = "bivin";
   String password = "bivin123";
   

   try{
      //STEP 2: Register JDBC driver
      //Class.forName("oracle.jdbc.driver.OracleDriver");
	   String driverName = "oracle.jdbc.driver.OracleDriver";
		Class.forName(driverName);

      //STEP 3: Open a connection
      System.out.println("Connecting to database...");
      //conn = DriverManager.getConnection(DB_URL,USER,PASS);
      conn = DriverManager.getConnection(url, username, password);

      //STEP 4: Execute a query
      System.out.println("Creating statement...");
      stmt = conn.createStatement();
      String sql;
      sql = "SELECT id, first, last, age FROM example";
      ResultSet rs = stmt.executeQuery(sql);

      //STEP 5: Extract data from result set
      while(rs.next()){
         //Retrieve by column name
         int id  = rs.getInt("id");
         int age = rs.getInt("age");
         String first = rs.getString("first");
         String last = rs.getString("last");

         //Display values
         System.out.print("ID: " + id);
         System.out.print(", Age: " + age);
         System.out.print(", First: " + first);
         System.out.println(", Last: " + last);
      }
      //STEP 6: Clean-up environment
      rs.close();
      stmt.close();
      conn.close();
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   System.out.println("Goodbye!");
}//end main
}//end FirstExample