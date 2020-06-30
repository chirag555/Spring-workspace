<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>File Uploading Form</title>
</head>

<body>
	<h3>File Upload:</h3>
	Select a file to upload:
	<br />
	<form action="UploadServlet" method="post"
		enctype="multipart/form-data">
		<input type="file" name="file" size="50" /> <br /> <input
			type="submit" value="Upload File" />
	</form>
	<%@ page import="org.apache.commons.io.output.*"%>
	<%@ page import="java.io.File"%>
	<%@ page import="java.io.IOException"%>
	<%@ page import="java.io.PrintWriter"%>
	<%@ page import="java.io.Writer"%>
	<%@ page import="javax.xml.parsers.ParserConfigurationException"%>
	<%@ page import="org.apache.pdfbox.pdmodel.PDDocument"%>
	<%@ page
		import="org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException"%>
	<%@ page import="org.fit.pdfdom.PDFDomTree"%>
	<%
		
				PDDocument pdf = PDDocument.load(new File(${file}));
				Writer output = new PrintWriter("C:/Users/Chirag/Desktop/pdftoHtml/pdf.html", "utf-8");
				new PDFDomTree().writeText(pdf, output);

				output.close();
			
	%>


</body>

</html>