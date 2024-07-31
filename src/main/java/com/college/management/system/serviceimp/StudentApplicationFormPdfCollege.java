////package com.college.management.system.serviceimp;
////
////import java.io.FileOutputStream;
////
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.stereotype.Service;
////
////import com.college.management.system.repository.StudentApplicationDcomentMappingRepository;
////import com.itextpdf.text.BaseColor;
////import com.itextpdf.text.Document;
////import com.itextpdf.text.Element;
////import com.itextpdf.text.Paragraph;
////import com.itextpdf.text.pdf.PdfPTable;
////import com.itextpdf.text.pdf.PdfWriter;
////
////@Service
////public class StudentApplicationFormPdfCollege {
////	@Autowired
////	private StudentApplicationDcomentMappingRepository studentApplicationDcomentMappingRepository;
////
//new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			
//			Font blueFont = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL, BaseColor.BLUE);
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//
//			Paragraph studentDetails = new Paragraph();
//			studentDetails.add(new Chunk("Student Details\n",blueFont));
//			studentDetails.add(new Chunk("Name: " + studentApplicationDocumentMapping.getStudentApplication().getFirstName() + " " + studentApplicationDocumentMapping.getStudentApplication().getLastName() + "\n"));
//			studentDetails.add(new Chunk("Email: " + studentApplicationDocumentMapping.getStudentApplication().getEmail() + "\n"));
//			studentDetails.add(new Chunk("Mobile No: " + studentApplicationDocumentMapping.getStudentApplication().getPhoneNumber() + "\n"));
//			studentDetails.setAlignment(Element.ALIGN_LEFT);
//			new Paragraph();new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//
//			// Create a paragraph for the parent details
//			Paragraph parentDetails = new Paragraph();
//			parentDetails.add(new Chunk("Parent Details\n",blueFont));
//			parentDetails.add(new Chunk("Father Name: " + studentApplicationDocumentMapping.getStudentApplication().getFatherName() + "\n"));
//			parentDetails.add(new Chunk("Mother Name: " + studentApplicationDocumentMapping.getStudentApplication().getMotherName() + "\n"));
//			parentDetails.setAlignment(Element.ALIGN_RIGHT);
//
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			// Create a table with 2 columns to hold the paragraphs
//			PdfPTable detailsTable = new PdfPTable(2);
//			detailsTable.setWidthPercentage(100);
//			new Paragraph();new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//
//			// Add student details to the left cell
//			PdfPCell studentDetailsCell = new PdfPCell(studentDetails);
//			studentDetailsCell.setBorder(Rectangle.NO_BORDER);
//			studentDetailsCell.setHorizontalAlignment(Element.ALIGN_LEFT);
//			detailsTable.addCell(studentDetailsCell);
//
//			// Add parent details to the right cell
//			PdfPCell parentDetailsCell = new PdfPCell(parentDetails);
//			parentDetailsCell.setBorder(Rectangle.NO_BORDER);
//			parentDetailsCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
//			detailsTable.addCell(parentDetailsCell);
//
//			// Add the table to the document
//			document.add(detailsTable);
//
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			// Add the address details as before
//			Paragraph addressLabel = new Paragraph();
//			Chunk addressHeading = new Chunk("Address: ", FontFactory.getFont(FontFactory.HELVETICA, 12, Font.NORMAL, BaseColor.BLUE)); // Blue color
//			Chunk cityChunk = new Chunk(studentApplicationDocumentMapping.getStudentApplication().getCity());
//			addressLabel.add(addressHeading);
//			addressLabel.add(cityChunk);
//			addressLabel.setAlignment(Element.ALIGN_CENTER);
//			document.add(addressLabel);
//
//
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			Paragraph qualification = new Paragraph("Qualification",blueFont);
//			qualification.setAlignment(Element.ALIGN_CENTER);
//			Paragraph tenthDocument = new Paragraph("10th Document: "+studentApplicationDocumentMapping.getQualification().getHigherEducation());
//			tenthDocument.setAlignment(Element.ALIGN_CENTER);
//			Paragraph percentage = new Paragraph("Percentage: "+studentApplicationDocumentMapping.getPercentage());
//			percentage.setAlignment(Element.ALIGN_CENTER);
//			Paragraph passingYear = new Paragraph("Passing Year: "+studentApplicationDocumentMapping.getPassingYear());
//			passingYear.setAlignment(Element.ALIGN_CENTER);
//
//			document.add(qualification);
//			document.add(tenthDocument);
//			document.add(percentage);
//			document.add(passingYear);
//
//			new Paragraph();
//			new Paragraph();
//			Paragraph uploaded = new Paragraph("Documents Uploaded: Yes ",blueFont);
//			uploaded.setAlignment(Element.ALIGN_RIGHT);
//			Paragraph approved = new Paragraph("Documents Approved: Approved ",blueFont);
//			approved.setAlignment(Element.ALIGN_RIGHT);
//			document.add(uploaded);
//			document.add(approved);
//
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			Paragraph qualification12 = new Paragraph("Qualification: ",blueFont);
//			qualification12.setAlignment(Element.ALIGN_CENTER);
//			Paragraph twelfthDocument = new Paragraph("12th Document: "+studentApplicationDocumentMapping.getQualification().getHigherEducation());
//			twelfthDocument.setAlignment(Element.ALIGN_CENTER);
//			Paragraph percentage12 = new Paragraph("Percentage: "+studentApplicationDocumentMapping.getPercentage());
//			percentage12.setAlignment(Element.ALIGN_CENTER);
//			Paragraph passingYear12 = new Paragraph("Passing Year: "+studentApplicationDocumentMapping.getPassingYear());
//			passingYear12.setAlignment(Element.ALIGN_CENTER);
//
//			document.add(qualification12);
//			document.add(twelfthDocument);
//			document.add(percentage12);
//			document.add(passingYear12);
//
//			Paragraph uploaded12 = new Paragraph("Documents Uploaded: Yes ",blueFont);
//			uploaded12.setAlignment(Element.ALIGN_RIGHT);
//			Paragraph approved12 = new Paragraph("Documents Approved: Approved ",blueFont);
//			approved12.setAlignment(Element.ALIGN_RIGHT);
//
//			// Add paragraphs to the document
//			document.add(uploaded12);
//			document.add(approved12);
//
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			Paragraph courseDetails = new Paragraph("Course Details ",blueFont);
//			courseDetails.setAlignment(Element.ALIGN_CENTER);
//			Paragraph courseName = new Paragraph("Course Name :"+studentApplicationDocumentMapping.getStudentApplication().getCourseMaster().getCourses());
//			courseName.setAlignment(Element.ALIGN_CENTER);
//			document.add(courseDetails);
//			document.add(courseName);
//
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			Paragraph amountPaid = new Paragraph("Application Form Amount Paid: Yes ",blueFont);
//			amountPaid.setAlignment(Element.ALIGN_RIGHT);
//			document.add(amountPaid);
//
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			Paragraph approvalStatus = new Paragraph("Application Approval Status ",blueFont);
//			approvalStatus.setAlignment(Element.ALIGN_CENTER);
//
//			document.add(approvalStatus);
//			
//
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			Paragraph isApproved = new Paragraph("Is Application Approved?: Approved ",blueFont);
//			isApproved.setAlignment(Element.ALIGN_CENTER);
//
//			document.add(isApproved);
//			
//
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			Paragraph allottedCollege = new Paragraph("Allotted College ",blueFont);
//			allottedCollege.setAlignment(Element.ALIGN_CENTER);
//
//			document.add(allottedCollege);
//
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			
//			PdfPTable table = new PdfPTable(5);
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//
//			table.getDefaultCell().setBorderWidth(1f);
//			
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//			new Paragraph();
//
//			table.addCell("College Name");
//			table.addCell("College Code");
//			table.addCell("Email id");
//			table.addCell("Phone");
//			table.addCell("Address");
//
//			document.add(table);
////			StudentApplicationFormPdfCollege pdfCreator = new StudentApplicationFormPdfCollege();
//
//			// Call the createPdf() method to generate the PDF
////			pdfCreator.createPdf();
////}
//
//import com.itextpdf.text.BaseColor;
//import com.itextpdf.text.Chunk;
//import com.itextpdf.text.Element;
//import com.itextpdf.text.Font;
//import com.itextpdf.text.FontFactory;
//import com.itextpdf.text.Paragraph;
//import com.itextpdf.text.Rectangle;
//import com.itextpdf.text.pdf.PdfPCell;
//import com.itextpdf.text.pdf.PdfPTable;
