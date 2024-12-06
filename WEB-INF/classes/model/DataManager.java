package model;

import java.sql.*;



public class DataManager {
  
	private Connection con=null;
	private String message="";
	private ResultSet res=null;
	private Statement st=null;
	private int effected_rows=-1;
	private boolean flag=false;
	private String dbURL = "";
	private String dbUserName = "";
	private String dbPassword = "";
	PreparedStatement ps=null;

	public void connect()
		{
			try
			{
				flag=true;
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				con = DriverManager.getConnection(getDbURL(), getDbUserName(),getDbPassword());
				//st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);	
				//System.out.println(con);
			}
			catch(Exception e)
			{
				message=e.getMessage();
			}
			
		}
  public void setDbURL(String dbURL) {
    this.dbURL = dbURL;
    }
  public String getDbURL() {
    return dbURL;
    }

  public void setDbUserName(String dbUserName) {
    this.dbUserName = dbUserName;
    }
  public String getDbUserName() {
    return dbUserName;
    }

  public void setDbPassword(String dbPassword) {
    this.dbPassword = dbPassword;
    }
  public String getDbPassword() {
    return dbPassword;
    }

  public boolean operation(String query,String operation)
	{
		try
		{
			if(con!=null)
			{
				flag=true;
					//Class.forName("com.mysql.jdbc.Driver").newInstance();
				//con = DriverManager.getConnection("jdbc:mysql:///ezlib","root", "tomweb");
				//st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);	
				ps=con.prepareStatement(query);
				if(operation.equals("select"))	
				{
					res=ps.executeQuery();
					if(res.next())
					{
						message=operation+" success";
						ps=null;
						return(true);
					}
					else 
					{
						message=operation+" no value in the resultset ";
						ps=null;
						return(false);
					}
				}
				else 
				{
					message="** in else ** "+query;
					effected_rows=ps.executeUpdate();
					message="** done ** ";
					message=operation+" success";
					ps=null;
					return(true);
				}
			}
			else
			{
				connect();
				message="NOT CONNECTED YET.";
				return operation(query,operation);
			}
		}
		catch(Exception e)
		{
			message = operation+" Failed "+e.getMessage()+" "+query;
			System.out.println(e);
			ps=null;
			return(false);
		}
	}
	public ResultSetMetaData getMetaData() 
	{
		try
		{
			return(res.getMetaData());
		}
		catch(SQLException e)
		{
			message="MeataDataObject error "+e.getMessage();
			return(null);
		}
	}
	public String getErrorMessage()
	{
		return(message);
	}
	public ResultSet getResultSet()
	{
		return(res);
	}
	public int getEffectedRows()
	{
		return(effected_rows);
	}
	public void close()
	{
		try
		{
			if(flag)
			{
				st.close();
				con.close();
			}
		}
		catch(Exception e)
		{
		}
	}
  }
