package model;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseOpDAO
{
	private Connection con=null;
	private String message="DataBaseOpDAO::";
	private ResultSet res=null;
	private Statement st=null;
	private int effected_rows=-1;
	private boolean flag=false;
	PreparedStatement ps=null;
	public DataBaseOpDAO()
	{
		try
		{
			flag=true;
		     	Class.forName("com.mysql.jdbc.Driver").newInstance();
	      	con = DriverManager.getConnection("jdbc:mysql:///vignan","aac", "Atten!@nce");
			//st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);	
		}
		catch(Exception e){}
	}
	public boolean operation(String query,String operation)
	{
		try
		{
			flag=true;
		  
			ps=con.prepareStatement(query);	

			if(operation.equals("select"))	
			{
				res=ps.executeQuery(query);
				if(res.next())
				{
					message+=operation+" success";
					return(true);
				}
				else 
				{
					message+=operation+" no value in the resultset ";
					return(false);
				}
			}
			else 
			{
				message+="** in else ** "+query;
				effected_rows=ps.executeUpdate(query);
				message+="** done **";
				message+=operation+" success";
				return(true);
			}
		}
		catch(Exception e)
		{
			message+=operation+" Failed "+e.getMessage()+" ** "+query;
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
			message+="MeataDataObject error "+e.getMessage();
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
				ps.close();
				con.close();
			}
		}
		catch(Exception e)
		{
		}
	}
}