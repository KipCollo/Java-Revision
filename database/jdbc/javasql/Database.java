// package database.jdbc.javasql;

// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.Statement;

// public class Database {

//     public Connection connect(String username, String password){

//         Connection conn = null;
//         try {
//             Class.forName("org.postgresql.Driver");

//             String url ="jdbc:postgresql://localhost:5432/polling_app";
//             conn = DriverManager.getConnection( url, username ,password);

//             if(conn!=null){
//                 System.out.println("Connection Successful");
//             } else{
//                 System.out.println("Connection refused");
//             }
            
//         } catch (Exception e) {
//             System.out.println(e);
//     }
//         return conn;
//  }

//    public void createTable(Connection conn, String table){
//      try {
//         Statement statement;

//         String sql = "CREATE TABLE " + table + "(id serial,name varchar(50),email varchar(50),primary key(id));";
//         statement=conn.createStatement();
//         statement.executeUpdate(sql);
//         System.out.println("Table created");

//        } catch (Exception e) {
//         System.out.println(e);
//      }
//   }
// }
