package com.r1v2.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.core.util.PropertyFileUtil;
import com.qa.sc.pageobjects.SCLoginPage;


public  class DataBase   {

	BaseTest b= new BaseTest();
	public static Connection conn;
	private   Map<String, String> td =b.getTestDataProperties();
	
	public String dbusername=td.get("username");
    public String dbpassword=td.get("password");
    String connectionUrl="jdbc:mysql://idbw:3306/izmoweb_r1v2";    
			//private static String connectionUrl= "jdbc:mysql://idbw:3306/";
		   // private static String connectionUrl= "jdbc:mysql://idbw:3306/";
/*
    public PageFactory getPageFactory() {
		// TODO Auto-generated method stub
		return DataBase;
	}
    */
    
    
    
	public  String executeSQLQuery(String sqlQuery) {
	        Connection connection;
	        String resultValue = "";
	        ResultSet rs;
	
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	        }catch(ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	        try {
	            connection = DriverManager.getConnection(connectionUrl,dbusername,dbpassword);
	            if(connection!=null) {
	                System.out.println("Connected to the database...");
	            }else {
	                System.out.println("Database connection failed to "+" Environment");
	            }
	            Statement stmt = connection.createStatement();
	            rs=stmt.executeQuery(sqlQuery);

	            try {
	                while(rs.next()){
	                    resultValue = rs.getString(1).toString();
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	            catch (NullPointerException err) {
	                System.out.println("No Records obtained for this specific query");
	                err.printStackTrace();
	            }
	            connection.close();

	        }catch(SQLException sqlEx) {
	            System.out.println( "SQL Exception:" +sqlEx.getStackTrace());
	        }
	        return resultValue;
	    }

    public  ArrayList<String> executeSQLQuery_List(String sqlQuery) {
        String connectionUrl="";
        Connection connection;
        ArrayList<String> resultValue = new ArrayList<String>();
        ResultSet resultSet;

        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(connectionUrl,dbusername,dbpassword);
            if(connection!=null) {
                System.out.println("Connected to the database");
            }else {
                System.out.println("Failed to connect to "+" database");
            }
            Statement statement = connection.createStatement();
            resultSet=statement.executeQuery(sqlQuery);

            try {
                while(resultSet.next()){
                    int columnCount = resultSet.getMetaData().getColumnCount();
                    StringBuilder stringBuilder = new StringBuilder();
                    for(int iCounter=1;iCounter<=columnCount; iCounter++){
                        stringBuilder.append(resultSet.getString(iCounter).trim()+" ");
                    }
                    String reqValue = stringBuilder.substring(0, stringBuilder.length()-1);
                    resultValue.add(reqValue);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            catch (NullPointerException ex) {
                System.out.println("No Records found for this specific query" +ex.getStackTrace());
            }
            finally {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException ex) {
                        System.out.println( "SQL Exception:" +ex.getStackTrace());
                    }
                }
            }
        }catch(SQLException sqlEx) {
            System.out.println( "SQL Exception:" +sqlEx.getStackTrace());
        }
        return resultValue;
    }

	
}



/*	  private  Statement getStatements() throws SQLException, ClassNotFoundException {
				if (conn == null || conn.isClosed()) {
				
					// For credentials
					Class.forName("com.mysql.jdbc.Driver");
					//String userName="rajesh.n";
					//String passWord="ra&95$sHe2N5";
					// connection driver
					  String dbusername=td.get("username");
				      String dbpassword=td.get("password");
					
				conn = DriverManager.getConnection("jdbc:mysql://idbw:3306/izmoweb_r1v2", dbusername, dbpassword);
				}
		  		  return conn.createStatement();
			}


		  public  ResultSet getData(String query) throws SQLException, ClassNotFoundException {
				ResultSet data = getStatements().executeQuery(query);
				return data;
			}
 */
		    

		  /* public static String executeSQLQuery(String testEnv, String sqlQuery) {

	      s  String connectionUrl="";
	        Connection connection;
	        String resultValue = "";
	        ResultSet rs;
	  
	        //To connect with Euro Database
	        if(testEnv.equalsIgnoreCase("QA")){
	            connectionUrl = databaseEuroUrl;
	            dbusername = "";
	            dbpassword = "";
	            
	        }
	        
	        //To connect with Mx Database
	        else if(testEnv.equalsIgnoreCase("Mx")) {
	            connectionUrl = databaseMxUrl;
	            dbusername = "root";
	            dbpassword = "stagepassword";
	            td.
	        }

	        //To connect with India Database
	        else if(testEnv.equalsIgnoreCase("India")) {
	            connectionUrl = databaseIndiaUrl;
	            dbusername = "root";
	            dbpassword = "prodpassword";
	        }
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	        }catch(ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	   
	        try {
	            connection = DriverManager.getConnection(connectionUrl,dbusername,dbpassword);
	            if(connection!=null) {
	                System.out.println("Connected to the database...");
	            }else {
	                System.out.println("Database connection failed to "+testEnv+" Environment");
	            }
	            Statement stmt = connection.createStatement();
	            rs=stmt.executeQuery(sqlQuery);

	            try {
	                while(rs.next()){
	                    resultValue = rs.getString(1).toString();
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	            catch (NullPointerException err) {
	                System.out.println("No Records obtained for this specific query");
	                err.printStackTrace();
	            }
	            connection.close();

	        }catch(SQLException sqlEx) {
	            System.out.println( "SQL Exception:" +sqlEx.getStackTrace());
	        }
	        return resultValue;
	    }*/
  



