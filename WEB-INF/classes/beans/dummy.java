package beans;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.io.IOException;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
public class dummy
{
     private static final int CELL_SIZE = 40;
    private int gridRows=2;
    private int gridCols=8;
    private StringBuilder generatedString = new StringBuilder();
public static void send(String gmail,String usercode)
{
     dummy g = new dummy();
     g.generateGridCharacters(); // Generate characters for the grid
     g.storeInDatabase(g.generatedString.toString(),usercode,gmail); // Store in the database
     //g.saveAsPDF(g.generatedString.toString());
     g.sendemail(gmail);
}
public static void main(String x[])
{
  //send();
}
 private String generateRandomAlphanumeric() {
            String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < 3; i++) {
                int randomIndex = (int) (Math.random() * characters.length());
                sb.append(characters.charAt(randomIndex));
            }

            return sb.toString();
        }
 private void generateGridCharacters() {
            Random random = new Random();

            for (int row = 0; row < gridRows; row++) {
                for (int col = 0; col < gridCols; col++) {
                    // Generate random alphanumeric characters (including lowercase)
                    String alphanumeric = generateRandomAlphanumeric();
               
                    generatedString.append(alphanumeric);
                }
            }
           //System.System.out.println(generatedString);
        }

        private void storeInDatabase(String generatedString,String usercode,String gmail) {
            // Load the MySQL JDBC driver
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                return;
            }

            // Insert into database
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "Atten!@nce")) {
                insertIntoDatabase(connection, generatedString,usercode,gmail);
               // System.System.out.println("Strings inserted into database successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        /*private void insertIntoDatabase(Connection connection, String generatedString,String usercode) throws SQLException {
			String query1 = "select * from generated_strings where empcode=?";
			 try (PreparedStatement preparedStatement1 = connection.prepareStatement(query1)) {
				 preparedStatement1.setString(1,usercode);
				 preparedStatement1.executeUpdate();
				 ResultSet rs8818=preparedStatement1.executeQuery();  

                 rs8818.beforeFirst();
                  if(rs8818.next())
                  {
					 String query = "INSERT INTO generated_strings(g1, g2, g3, g4, g5, g6, g7, g8, g9, g10, g11, g12, g13, g14, g15, g16) VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) where empcode=?";

            try (PreparedStatement preparedStatement2 = connection.prepareStatement(query)) {

                preparedStatement2.setString(17,usercode);
                int index = 0;
                int parameterIndex = 1;
                while (index < generatedString.length()) {
                    String substring = generatedString.substring(index, Math.min(index + 3, generatedString.length()));
                    preparedStatement2.setString(parameterIndex++, substring);
                    index += 3;
                }
                preparedStatement2.executeUpdate();
            }  
			      }
			   
			 else{

            String query = "INSERT INTO generated_strings(empcode,g1, g2, g3, g4, g5, g6, g7, g8, g9, g10, g11, g12, g13, g14, g15, g16) VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

                preparedStatement.setString(1,usercode);
                int index = 0;
                int parameterIndex = 2;
                while (index < generatedString.length()) {
                    String substring = generatedString.substring(index, Math.min(index + 3, generatedString.length()));
                    preparedStatement.setString(parameterIndex++, substring);
                    index += 3;
                }
                preparedStatement.executeUpdate();
            }
			 }
			 }
          // System.out.println(generatedString);
           saveAsPDF(generatedString);
        }*/
private void insertIntoDatabase(Connection connection, String generatedString, String usercode,String gmail) throws SQLException {
    // Check if empcode already exists
    boolean empcodeExists = false;
    String queryCheck = "SELECT COUNT(*) FROM generated_strings WHERE empcode = ?";
    try (PreparedStatement checkStatement = connection.prepareStatement(queryCheck)) {
        checkStatement.setString(1, usercode);
        try (ResultSet resultSet = checkStatement.executeQuery()) {
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                empcodeExists = count > 0;
            }
        }
    }

    // Perform insert or update based on empcode existence
    String queryCheck1 = "SELECT * FROM verify WHERE empcode = ?";   
     try (PreparedStatement preparedStatement3 = connection.prepareStatement(queryCheck1)) {
                preparedStatement3.setString(1,usercode);
                 try (ResultSet resultSet =preparedStatement3.executeQuery()) {
                 if (resultSet.next()) {
                 }
	 else{
   
     String queryCheck2 = "insert into verify (empcode,email) values(?,?)";
         try (PreparedStatement preparedStatement = connection.prepareStatement(queryCheck2)) {
               preparedStatement.setString(1,usercode);
           preparedStatement.setString(2,gmail);
                preparedStatement.executeUpdate();
              }
     }
                 }
     }
      String query;
    if (empcodeExists) {
        query = "UPDATE generated_strings SET g1 = ?, g2 = ?, g3 = ?, g4 = ?, g5 = ?, g6 = ?, g7 = ?, g8 = ?, g9 = ?, g10 = ?, g11 = ?, g12 = ?, g13 = ?, g14 = ?, g15 = ?, g16 = ? WHERE empcode = ?";
		try (PreparedStatement preparedStatement2 = connection.prepareStatement(query)) {

                preparedStatement2.setString(17,usercode);
                int index = 0;
                int parameterIndex = 1;
                while (index < generatedString.length()) {
                    String substring = generatedString.substring(index, Math.min(index + 3, generatedString.length()));
                    preparedStatement2.setString(parameterIndex++, substring);
                    index += 3;
                }
                preparedStatement2.executeUpdate();
            }
		
    } else {
		/*String queryCheck1 = "SELECT * FROM verify WHERE empcode = ?";   
     try (PreparedStatement preparedStatement3 = connection.prepareStatement(queryCheck1)) {
                preparedStatement3.setString(1,usercode);
                 try (ResultSet resultSet =preparedStatement3.executeQuery()) {
                 if (resultSet.next()) {
                 }
	 else{*/
		
	 //}
	// }
	// }
        query = "INSERT INTO generated_strings(empcode, g1, g2, g3, g4, g5, g6, g7, g8, g9, g10, g11, g12, g13, g14, g15, g16) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
         try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

                preparedStatement.setString(1,usercode);
                int index = 0;
                int parameterIndex = 2;
                while (index < generatedString.length()) {
                    String substring = generatedString.substring(index, Math.min(index + 3, generatedString.length()));
                    preparedStatement.setString(parameterIndex++, substring);
                    index += 3;
                }
                preparedStatement.executeUpdate();
            } 
    }

  
    // System.out.println(generatedString);
    saveAsPDF(generatedString);
}




private void sendemail(String gmail) {
        // Sender's email address and password
        final String senderEmail = "noreply.vignan@gmail.com";
        final String senderPassword = "dgjq nwcn psmh jppo";

        // Recipient email addresses
        //String[] recipientEmails ={};

        // Mail server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        // Get the Session object
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        try {
            // Create a default MimeMessage object
            MimeMessage message = new MimeMessage(session);

            // Set From: header field
            message.setFrom(new InternetAddress(senderEmail));

            // Set To: header field for multiple recipients
           // for (String recipientEmail : recipientEmails) {
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(gmail));
            //}

            // Set Subject: header field
            message.setSubject("Grid Values");

            // Create the message body part
            BodyPart messageBodyPart = new MimeBodyPart();

            // Set the actual message
            messageBodyPart.setText("");

            // Create a multipart message
            Multipart multipart = new MimeMultipart();

            // Add text message part to multipart
            multipart.addBodyPart(messageBodyPart);

            // Attach PDF file
            String pdfFilePath = "C:/Program Files/Apache Software Foundation/Tomcat 8.0/webapps/ROOT/GeneratedGrid.pdf"; // Replace with the actual path to your PDF file
            messageBodyPart = new MimeBodyPart();
            DataSource source = new FileDataSource(pdfFilePath);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName("grids.pdf");
            multipart.addBodyPart(messageBodyPart);

            // Set the multipart message to the main message
            message.setContent(multipart);

            // Send message
            Transport.send(message);

            //System.System.out.println("Email sent successfully!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
private void saveAsPDF(String generatedString) {
    PDDocument document = new PDDocument();
    PDPage page = new PDPage(PDRectangle.A4);
    document.addPage(page);
 
    try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
        contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
 
        float margin = 50f;
        float yStart = page.getMediaBox().getHeight() - margin;
        float tableWidth = page.getMediaBox().getWidth() - 2 * margin;
        float yPosition = yStart;
        float tableHeight = 200; // Increased cell size
        float yBottom = yStart - tableHeight;
 
        // Draw the table headers
        contentStream.beginText();
        contentStream.newLineAtOffset(margin, yStart);
        contentStream.showText("Grid");
        contentStream.endText();
 
        // Draw the table cells
        contentStream.setLineWidth(1f);
        float cellMargin = 10f;
        float fontSize = 12f;
        float tableRowHeight = fontSize + 4 * cellMargin;
        float tableXPosition = margin + cellMargin;
        float tableYPosition = yStart - cellMargin;
 
        String[] lines = generatedString.toString().split("(?<=\\G...)");
 
        for (int i = 0; i < lines.length; i++) {
            int col = i % gridCols;
            int row = i / gridCols;
 
            float x = tableXPosition + col * (tableWidth / gridCols);
            float y = tableYPosition - row * tableRowHeight;
 
            contentStream.setLineWidth(1f);
 
            // Draw cell border
            contentStream.moveTo(x, y);
            contentStream.lineTo(x + tableWidth / gridCols, y);
            contentStream.lineTo(x + tableWidth / gridCols, y - tableRowHeight);
            contentStream.lineTo(x, y - tableRowHeight);
            contentStream.lineTo(x, y);
 
            contentStream.stroke();
 
            // Draw grid number in normal text aligned to the left above the cell
            contentStream.beginText();
            contentStream.setFont(PDType1Font.HELVETICA, fontSize);
            contentStream.newLineAtOffset(x + cellMargin, y - cellMargin); // Adjusted the positioning
            contentStream.showText("G" + (i + 1));
            contentStream.endText();
 
            // Draw random three characters in bold aligned to the right below the cell
            contentStream.beginText();
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, fontSize);
            float textWidth = PDType1Font.HELVETICA_BOLD.getStringWidth(lines[i]) / 1000 * fontSize;
            contentStream.newLineAtOffset(x + (tableWidth / gridCols) - textWidth - cellMargin, y - tableRowHeight + fontSize + cellMargin); // Adjusted the positioning
            contentStream.showText(lines[i]);
            contentStream.endText();
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
 
    try {
        document.save("C:/Program Files/Apache Software Foundation/Tomcat 8.0/webapps/ROOT/GeneratedGrid.pdf"); // Save the PDF with the desired name
        document.close();
        //System.out.println("PDF saved successfully.");
        //sendemail();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}








