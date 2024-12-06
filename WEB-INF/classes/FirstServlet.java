import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DataManager;

public class FirstServlet extends javax.servlet.http.HttpServlet
    implements javax.servlet.Servlet {
  private static final long serialVersionUID = 1L;
String str = "";
  public FirstServlet() {
    super();
    }

  public void init(ServletConfig config) throws ServletException {
    System.out.println("*** initializing controller servlet.");
    super.init(config);

    DataManager dataManager = new DataManager();
    dataManager.setDbURL(config.getInitParameter("dbURL"));
    dataManager.setDbUserName(config.getInitParameter("dbUserName"));
    dataManager.setDbPassword(config.getInitParameter("dbPassword"));
	dataManager.connect();

	DataManager dataManager1 = new DataManager();
    dataManager1.setDbURL(config.getInitParameter("dbURL"));
    dataManager1.setDbUserName(config.getInitParameter("dbUserName1"));
    dataManager1.setDbPassword(config.getInitParameter("dbPassword1"));
	dataManager1.connect();

	DataManager dataManager2 = new DataManager();
    dataManager2.setDbURL(config.getInitParameter("dbURL"));
    dataManager2.setDbUserName(config.getInitParameter("dbUserName2"));
    dataManager2.setDbPassword(config.getInitParameter("dbPassword2"));
	dataManager2.connect();


	DataManager dataManager3 = new DataManager();
    dataManager3.setDbURL(config.getInitParameter("dbURL"));
    dataManager3.setDbUserName(config.getInitParameter("dbUserName3"));
    dataManager3.setDbPassword(config.getInitParameter("dbPassword3"));
	dataManager3.connect();


	DataManager dataManager4 = new DataManager();
    dataManager4.setDbURL(config.getInitParameter("dbURL"));
    dataManager4.setDbUserName(config.getInitParameter("dbUserName4"));
    dataManager4.setDbPassword(config.getInitParameter("dbPassword4"));
	dataManager4.connect();


	DataManager dataManager5 = new DataManager();
    dataManager5.setDbURL(config.getInitParameter("dbURL"));
    dataManager5.setDbUserName(config.getInitParameter("dbUserName5"));
    dataManager5.setDbPassword(config.getInitParameter("dbPassword5"));
	dataManager5.connect();


	DataManager dataManager6 = new DataManager();
    dataManager6.setDbURL(config.getInitParameter("dbURL"));
    dataManager6.setDbUserName(config.getInitParameter("dbUserName6"));
    dataManager6.setDbPassword(config.getInitParameter("dbPassword6"));
	dataManager6.connect();


	DataManager dataManager7 = new DataManager();
    dataManager7.setDbURL(config.getInitParameter("dbURL"));
    dataManager7.setDbUserName(config.getInitParameter("dbUserName7"));
    dataManager7.setDbPassword(config.getInitParameter("dbPassword7"));
	dataManager7.connect();


	DataManager dataManager8 = new DataManager();
    dataManager8.setDbURL(config.getInitParameter("dbURL"));
    dataManager8.setDbUserName(config.getInitParameter("dbUserName8"));
    dataManager8.setDbPassword(config.getInitParameter("dbPassword8"));
	dataManager8.connect();

	DataManager dataManager9 = new DataManager();
    dataManager9.setDbURL(config.getInitParameter("dbURL"));
    dataManager9.setDbUserName(config.getInitParameter("dbUserName9"));
    dataManager9.setDbPassword(config.getInitParameter("dbPassword9"));
	dataManager9.connect();

	DataManager dataManager10 = new DataManager();
    dataManager10.setDbURL(config.getInitParameter("dbURL"));
    dataManager10.setDbUserName(config.getInitParameter("dbUserName10"));
    dataManager10.setDbPassword(config.getInitParameter("dbPassword10"));
	dataManager10.connect();

	ServletContext context = config.getServletContext();
    //context.setAttribute("base", config.getInitParameter("base"));
    //context.setAttribute("imageURL", config.getInitParameter("imageURL"));
    //context.setAttribute("dataManager", dataManager);
	//str+="<br>"+config.getInitParameter("dbURL");
	//str+="<br>"+config.getInitParameter("dbUserName");
	//str+="<br>"+config.getInitParameter("dbPassword");
    //ServletContext context = config.getServletContext();
    //context.setAttribute("base", config.getInitParameter("base"));
    //context.setAttribute("imageURL", config.getInitParameter("imageURL"));
    context.setAttribute("db", dataManager);
	context.setAttribute("db1", dataManager1);
	   context.setAttribute("db2", dataManager2);
	context.setAttribute("db3", dataManager3);
	   context.setAttribute("db4", dataManager4);
	context.setAttribute("db5", dataManager5);
	   context.setAttribute("db6", dataManager6);
	context.setAttribute("db7", dataManager7);
	   context.setAttribute("db8", dataManager8);
	context.setAttribute("db9", dataManager9);
	   context.setAttribute("db10", dataManager10);


    }

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response) throws ServletException, IOException 
	{
		
	    //RequestDispatcher requestDispatcher =
		  //getServletContext().getRequestDispatcher("/login.html");
	    //requestDispatcher.forward(request, response);
    }
    
  }
