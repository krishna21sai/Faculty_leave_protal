import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig
public class UploadServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // Get the uploaded file part
    Part filePart = request.getPart("file");
    String fileName = filePart.getSubmittedFileName();

    // Save the file on the server (optional)
    String filePath = getServletContext().getRealPath("/") + File.separator + fileName;
    filePart.write(filePath);

    // Read the file content
    BufferedReader reader = new BufferedReader(new FileReader(filePath));
    String line;
    StringBuilder csvContent = new StringBuilder();
    while ((line = reader.readLine()) != null) {
      csvContent.append(line).append("<br>");
    }
    reader.close();

    // Display the content on the JSP page
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    out.println("<html><body>");
    out.println("<h2>CSV Content:</h2>");
    out.println(csvContent.toString());
    out.println("</body></html>");
  }
}
