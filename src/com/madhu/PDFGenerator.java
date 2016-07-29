package com.madhu;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFGenerator {

	public String getName() {
		return "Madhukar";
	}

	public String getAddress() {
		return "Madiwala";
	}

	public String getSalary() {
		return "20000";
	}
	private static String pwd = "Hello123";
	 
    private static String pwd1 = "Owner123";
    
	public static void main(String[] args) {

		PDFGenerator pdf = new PDFGenerator();
		java.io.OutputStream file;
		File f = new File("D:\\personal\\sample.pdf");
		
		try {
			file = new FileOutputStream(f);

			Document document = new Document();
			PdfWriter writer = PdfWriter.getInstance(document, file);
			writer.setEncryption(pwd.getBytes(), pwd1.getBytes(), PdfWriter.ALLOW_PRINTING, PdfWriter.ENCRYPTION_AES_128);
			Image image = Image.getInstance("D:\\01.jpg");
			document.open();
			document.addTitle("PAYSLIP");
			document.add(image);
			document.add(new Paragraph(" "));
			document.add(new Paragraph("Sample PDF"));
			document.add(new Paragraph(new Date().toString()));
			document.add(new Paragraph(" "));
			PdfPTable table = new PdfPTable(4);
			table.addCell("SNO");
			table.addCell("Name");
			table.addCell("Address");
			table.addCell("SALARy");
			table.addCell("1");
			table.addCell(pdf.getName());
			table.addCell(pdf.getAddress());
			table.addCell(pdf.getSalary());
			document.add(table);
			document.addHeader("Madhu", "TP");
			document.addAuthor("Madhukar");
			document.close();
			file.close();
			System.out.println("Document generate with name " + f.getName());

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
