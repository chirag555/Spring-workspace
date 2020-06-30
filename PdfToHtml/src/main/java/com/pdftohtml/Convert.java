package com.pdftohtml;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.fit.pdfdom.PDFDomTree;

public class Convert {

	public static void main(String[] args) throws InvalidPasswordException, IOException, ParserConfigurationException {
		
		/*
		File pFile=new File("C:\\Users\\Chirag\\Desktop\\pdftoHtml\\eg.pdf");
		PDDocument pdf = PDDocument.load(pFile);
		PDFTextStripper stripper = new PDFTextStripper();
		String text = stripper.getText(pdf);
		System.out.println(text);
		*/
		generateHTMLFromPDF("C:\\Users\\Chirag\\Desktop\\pdftoHtml\\eg.pdf");
	}
	
	public static void generateHTMLFromPDF(String filename) throws IOException, ParserConfigurationException {
	    PDDocument pdf = PDDocument.load(new File(filename));
	    Writer output = new PrintWriter("C:/Users/Chirag/Desktop/pdftoHtml/pdf.html", "utf-8");
	    new PDFDomTree().writeText(pdf, output);
	     
	    output.close();
	}
}
