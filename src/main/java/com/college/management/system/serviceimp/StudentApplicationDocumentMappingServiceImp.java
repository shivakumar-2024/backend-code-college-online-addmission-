package com.college.management.system.serviceimp;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;
import org.springframework.web.multipart.MultipartFile;

import com.college.management.system.VO.StudentApplicationDocumentMappingVO;
import com.college.management.system.VO.StudentApplicationIdVO;
import com.college.management.system.VO.StudentApplicationShowCollegeVo;
import com.college.management.system.VO.StudentApplicationVO;
import com.college.management.system.entity.Qualification;
import com.college.management.system.entity.RegisterCollege;
import com.college.management.system.entity.StudentApplication;
import com.college.management.system.entity.StudentApplicationDocumentMapping;
import com.college.management.system.entity.UserLogin;
import com.college.management.system.repository.RegisterCollegeRepository;
import com.college.management.system.repository.StudentApplicationDcomentMappingRepository;
import com.college.management.system.repository.StudentApplicationRepository;
import com.college.management.system.repository.UserLoginRepository;
import com.college.management.sytem.service.StudentApppicationDocumentMappingService;
import com.google.gson.Gson;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Service
public class StudentApplicationDocumentMappingServiceImp implements StudentApppicationDocumentMappingService {

	@Autowired
	private com.college.management.system.repository.QualificationRepository QualificationRepository;

	@Autowired
	private StudentApplicationDcomentMappingRepository studentApplicationDcomentMappingRepository;

	@Autowired
	private StudentApplicationRepository studentApplicationRepository;

	@Autowired
	private UserLoginRepository loginRepo;

	@Autowired
	private RegisterCollegeRepository collegeRepo;

	@Override
	public StudentApplicationDocumentMappingVO addStudentDocumentService(String studentDocument, MultipartFile file)
			throws IOException {
		Gson gson = new Gson();
		StudentApplicationDocumentMappingVO studentApplicationDocumentMappingVO = gson.fromJson(studentDocument,
				StudentApplicationDocumentMappingVO.class);

		StudentApplicationDocumentMapping StudentApplicationDocumentMapping = new StudentApplicationDocumentMapping();
		StudentApplicationDocumentMapping.setQualification(
				fetchQualificationId(Long.valueOf(studentApplicationDocumentMappingVO.getStandard())));
		StudentApplicationDocumentMapping.setPassingYear(studentApplicationDocumentMappingVO.getPassingYear());
		StudentApplicationDocumentMapping.setPercentage(studentApplicationDocumentMappingVO.getPercentage());
		StudentApplicationDocumentMapping
				.setStudentApplication(existStudentId(Long.parseLong(studentApplicationDocumentMappingVO.getUserId())));

		StudentApplicationDocumentMapping.setUploadDocument(savePhoto(file));
//		studentApplicationRepository.findAll().stream().map(idGet-> idGet.getId()).collect(null);
//		StudentApplicationDocumentMapping.setStudentApplication();
		StudentApplicationDocumentMapping studentApplicationDocumentMappingData = this.studentApplicationDcomentMappingRepository
				.save(StudentApplicationDocumentMapping);

		// StudentApplicationDocumentMappingVO studentApplicationDocumentMappingVO=new
		// StudentApplicationDocumentMappingVO();
		// studentApplicationDocumentMappingVO.setStandard(studentApplicationDocumentMappingData.getStandard());
		studentApplicationDocumentMappingVO.setPassingYear(studentApplicationDocumentMappingData.getPassingYear());
		studentApplicationDocumentMappingVO.setPercentage(studentApplicationDocumentMappingData.getPercentage());

		return null;
	}

	private StudentApplication existStudentId(long long1) {
		return this.studentApplicationRepository.findById(long1).get();

	}

	private Qualification fetchQualificationId(Long long1) {

		return this.QualificationRepository.findById(long1).get();
	}

	private String savePhoto(MultipartFile file) throws IOException {
		String imageName = file.getOriginalFilename();
		String folderName = "D://image//";
		String fullPath = folderName + imageName;

		if (!Files.exists(Paths.get(folderName))) {
			try {
				Files.createDirectories(Paths.get(folderName));
			} catch (IOException e) {
				e.printStackTrace();
				// Handle the exception appropriately
			}
		}
		Files.copy(file.getInputStream(), Paths.get(fullPath));
		return imageName;

	}

	@Override
	public ResponseEntity<Map<Long, List<StudentApplicationShowCollegeVo>>> fetchStudentsAllDataService(boolean alloted) {
		Map<Long, List<StudentApplicationDocumentMapping>> studentApplicationDocumentMappings = 
				alloted?this.studentApplicationDcomentMappingRepository
						.findAllByStudentApplication_AllotmentStatusTrue().stream().collect(Collectors.groupingBy(s->s.getStudentApplication().getUserRegisteration().getId())):
				this.studentApplicationDcomentMappingRepository
				.findAllByStudentApplication_AllotmentStatusFalse().stream().collect(Collectors.groupingBy(s->s.getStudentApplication().getUserRegisteration().getId()));

		Map<Long, List<StudentApplicationShowCollegeVo>> studentApplicationShowCollegeVos = new HashMap<>() ;
		
		for(Map.Entry<Long, List<StudentApplicationDocumentMapping>> entry: studentApplicationDocumentMappings.entrySet()) {
			
			studentApplicationShowCollegeVos.put(entry.getKey(), entry.getValue().stream().map(StudentApplicationDocumentMapping::convertoToVO).collect(Collectors.toList()));
			
		}
		
		return ResponseEntity.ok().body(studentApplicationShowCollegeVos);
	}

	@Override
	public ResponseEntity<List<StudentApplicationShowCollegeVo>> fetchStudentAllAllotedService() {
		return null;
//
//		Map<Long,List<StudentApplicationDocumentMapping>> studentApplicationDocumentMappings = this.studentApplicationDcomentMappingRepository
//				.findAllByStudentApplication_AllotmentStatusTrue().stream().collect(Collectors.groupingBy(s->s.getStudentApplication().getUserRegisteration().getId()));
//		
//		Map<Long, List<StudentApplicationDocumentMapping>> studentApplicationShowCollegeVos=new HashMap();
//		
//		for(Map.Entry<Long,List<StudentApplicationDocumentMapping>> entry:studentApplicationDocumentMappings.entrySet()) {
//			
//			studentApplicationShowCollegeVos.put(entry.getKey(), entry.getValue().stream().map(StudentApplicationDocumentMapping::convertoToVO).collect(Collectors.toList()));
//			
//		}
//		
//		List<StudentApplicationShowCollegeVo> studentApplicationShowCollegeVos2 = studentApplicationDocumentMappings
//				.stream().map(StudentApplicationDocumentMapping::convertoToVO).collect(Collectors.toList());
//		return ResponseEntity.ok().body(studentApplicationShowCollegeVos2);
	}

	@Override
	public Map<String, Object> studentIdPdfService(StudentApplicationIdVO studentApplicationIdVO) {
		List<StudentApplicationDocumentMapping> studentApplicationDocumentMapping = this.studentApplicationDcomentMappingRepository
				.findByStudentApplication_Id(studentApplicationIdVO.getId());

		return Map.of("fileData", createPdf(studentApplicationDocumentMapping));

	}

	public static String path = "D://projectpdf//StudentApplicationCollege.pdf";

	public String createPdf(List<StudentApplicationDocumentMapping> studentApplicationDocumentMapping) {
		String path = "your_file_path_here.pdf"; // Define your file path

		try {

			Document document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream(path));
			document.open();

			// Create a Paragraph with the desired text
			Paragraph title = new Paragraph("Student Application",
					FontFactory.getFont(FontFactory.HELVETICA, 20, Font.BOLD, BaseColor.BLUE));
			title.setAlignment(Paragraph.ALIGN_CENTER);
			document.add(title);

			// Add student ID
			Paragraph studentIdLabel = new Paragraph(
					"Student Id: " + studentApplicationDocumentMapping.get(1).getStudentApplication().getId());
			studentIdLabel.setAlignment(Element.ALIGN_RIGHT);
			document.add(studentIdLabel);

			// Add some space
			document.add(Chunk.NEWLINE);

			// Create and add student details
			Font blueFont = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL, BaseColor.BLUE);
			Paragraph studentDetails = new Paragraph();
			studentDetails.add(new Chunk("Student Details\n", blueFont));
			studentDetails.add(new Chunk(
					"Name: " + studentApplicationDocumentMapping.get(0).getStudentApplication().getFirstName() + " "
							+ studentApplicationDocumentMapping.get(0).getStudentApplication().getLastName() + "\n"));
			studentDetails.add(new Chunk(
					"Email: " + studentApplicationDocumentMapping.get(0).getStudentApplication().getEmail() + "\n"));
			studentDetails.add(new Chunk("Mobile No: "
					+ studentApplicationDocumentMapping.get(0).getStudentApplication().getPhoneNumber() + "\n"));
			studentDetails.setAlignment(Element.ALIGN_LEFT);

			// Create and add parent details
			Paragraph parentDetails = new Paragraph();
			parentDetails.add(new Chunk("Parent Details\n", blueFont));
			parentDetails.add(new Chunk("Father Name: "
					+ studentApplicationDocumentMapping.get(0).getStudentApplication().getFatherName() + "\n"));
			parentDetails.add(new Chunk("Mother Name: "
					+ studentApplicationDocumentMapping.get(0).getStudentApplication().getMotherName() + "\n"));
			parentDetails.setAlignment(Element.ALIGN_RIGHT);

			// Create a table with 2 columns to hold the paragraphs
			PdfPTable detailsTable = new PdfPTable(2);
			detailsTable.setWidthPercentage(100);
			PdfPCell studentDetailsCell = new PdfPCell(studentDetails);
			studentDetailsCell.setBorder(Rectangle.NO_BORDER);
			studentDetailsCell.setHorizontalAlignment(Element.ALIGN_LEFT);
			detailsTable.addCell(studentDetailsCell);

			PdfPCell parentDetailsCell = new PdfPCell(parentDetails);
			parentDetailsCell.setBorder(Rectangle.NO_BORDER);
			parentDetailsCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			detailsTable.addCell(parentDetailsCell);

			// Add the table to the document
			document.add(detailsTable);

			// Add address details
			document.add(Chunk.NEWLINE);
			Paragraph addressLabel = new Paragraph();
			addressLabel.add(new Chunk("Address: ", blueFont));
			addressLabel.add(new Chunk(studentApplicationDocumentMapping.get(0).getStudentApplication().getCity()));
			addressLabel.setAlignment(Element.ALIGN_CENTER);
			document.add(addressLabel);

			// Add qualification details
			document.add(Chunk.NEWLINE);
			Paragraph qualification = new Paragraph("Qualification", blueFont);
			qualification.setAlignment(Element.ALIGN_CENTER);
			document.add(qualification);

			Paragraph tenthDocument = new Paragraph("10th Document: "
					+ studentApplicationDocumentMapping.get(0).getQualification().getHigherEducation());
			tenthDocument.setAlignment(Element.ALIGN_CENTER);
			document.add(tenthDocument);

			Paragraph percentage = new Paragraph(
					"Percentage: " + studentApplicationDocumentMapping.get(0).getPercentage());
			percentage.setAlignment(Element.ALIGN_CENTER);
			document.add(percentage);

			Paragraph passingYear = new Paragraph(
					"Passing Year: " + studentApplicationDocumentMapping.get(0).getPassingYear());
			passingYear.setAlignment(Element.ALIGN_CENTER);
			document.add(passingYear);

			// Add document status
			document.add(Chunk.NEWLINE);
			Paragraph uploaded = new Paragraph("Documents Uploaded: Yes", blueFont);
			uploaded.setAlignment(Element.ALIGN_RIGHT);
			document.add(uploaded);

			Paragraph approved = new Paragraph("Documents Approved: Approved", blueFont);
			approved.setAlignment(Element.ALIGN_RIGHT);
			document.add(approved);

			// Add 12th qualification details
			document.add(Chunk.NEWLINE);
			Paragraph qualification12 = new Paragraph("Qualification: ", blueFont);
			qualification12.setAlignment(Element.ALIGN_CENTER);
			document.add(qualification12);

			Paragraph twelfthDocument = new Paragraph("12th Document: "
					+ studentApplicationDocumentMapping.get(1).getQualification().getHigherEducation());
			twelfthDocument.setAlignment(Element.ALIGN_CENTER);
			document.add(twelfthDocument);

			Paragraph percentage12 = new Paragraph(
					"Percentage: " + studentApplicationDocumentMapping.get(1).getPercentage());
			percentage12.setAlignment(Element.ALIGN_CENTER);
			document.add(percentage12);

			Paragraph passingYear12 = new Paragraph(
					"Passing Year: " + studentApplicationDocumentMapping.get(1).getPassingYear());
			passingYear12.setAlignment(Element.ALIGN_CENTER);
			document.add(passingYear12);

			Paragraph uploaded12 = new Paragraph("Documents Uploaded: Yes", blueFont);
			uploaded12.setAlignment(Element.ALIGN_RIGHT);
			document.add(uploaded12);

			Paragraph approved12 = new Paragraph("Documents Approved: Approved", blueFont);
			approved12.setAlignment(Element.ALIGN_RIGHT);
			document.add(approved12);

			// Add course details
			document.add(Chunk.NEWLINE);
			Paragraph courseDetails = new Paragraph("Course Details", blueFont);
			courseDetails.setAlignment(Element.ALIGN_CENTER);
			document.add(courseDetails);

			Paragraph courseName = new Paragraph("Course Name: "
					+ studentApplicationDocumentMapping.get(1).getStudentApplication().getCourseMaster().getCourses());
			courseName.setAlignment(Element.ALIGN_CENTER);
			document.add(courseName);

			// Add application form amount paid
			document.add(Chunk.NEWLINE);
			Paragraph amountPaid = new Paragraph("Application Form Amount Paid: Yes", blueFont);
			amountPaid.setAlignment(Element.ALIGN_RIGHT);
			document.add(amountPaid);

			// Add application approval status
			document.add(Chunk.NEWLINE);
			Paragraph approvalStatus = new Paragraph("Application Approval Status", blueFont);
			approvalStatus.setAlignment(Element.ALIGN_CENTER);
			document.add(approvalStatus);

			// Add whether the application is approved
			document.add(Chunk.NEWLINE);
			Paragraph isApproved = new Paragraph("Is Application Approved?: Approved", blueFont);
			isApproved.setAlignment(Element.ALIGN_CENTER);
			document.add(isApproved);

			// Add allotted college
			document.add(Chunk.NEWLINE);
			Paragraph allottedCollege = new Paragraph("Allotted College", blueFont);
			allottedCollege.setAlignment(Element.ALIGN_CENTER);
			document.add(allottedCollege);

			// Add table with college details
			document.add(Chunk.NEWLINE);
			PdfPTable table = new PdfPTable(5);
			table.setWidthPercentage(100);
			table.addCell("College Name");
			table.addCell("College Code");
			table.addCell("Email id");
			table.addCell("Phone");
			table.addCell("Address");
			document.add(table);

			document.close();
			System.out.println("PDF created successfully at: " + path);
			return Base64Utils.encodeToString(Files.readAllBytes(Path.of(path)));

		} catch (Exception e) {
			
			System.out.println("An error occurred: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	public String createPdfNotAllot(List<StudentApplicationDocumentMapping> studentApplicationDocumentMapping) {
		String path = "D://projectNotAllotedStudentpdf//StudentApplicationCollege.pdf ";

		try {

			Document document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream(path));
			document.open();

			// Create a Paragraph with the desired text
			Paragraph title = new Paragraph("Student Application",
					FontFactory.getFont(FontFactory.HELVETICA, 20, Font.BOLD, BaseColor.BLUE));
			title.setAlignment(Paragraph.ALIGN_CENTER);
			document.add(title);

			// Add student ID
			Paragraph studentIdLabel = new Paragraph(
					"Student Id: " + studentApplicationDocumentMapping.get(1).getStudentApplication().getId());
			studentIdLabel.setAlignment(Element.ALIGN_RIGHT);
			document.add(studentIdLabel);

			// Add some space
			document.add(Chunk.NEWLINE);

			// Create and add student details
			Font blueFont = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL, BaseColor.BLUE);
			Paragraph studentDetails = new Paragraph();
			studentDetails.add(new Chunk("Student Details\n", blueFont));
			studentDetails.add(new Chunk(
					"Name: " + studentApplicationDocumentMapping.get(0).getStudentApplication().getFirstName() + " "
							+ studentApplicationDocumentMapping.get(0).getStudentApplication().getLastName() + "\n"));
			studentDetails.add(new Chunk(
					"Email: " + studentApplicationDocumentMapping.get(0).getStudentApplication().getEmail() + "\n"));
			studentDetails.add(new Chunk("Mobile No: "
					+ studentApplicationDocumentMapping.get(0).getStudentApplication().getPhoneNumber() + "\n"));
			studentDetails.setAlignment(Element.ALIGN_LEFT);

			// Create and add parent details
			Paragraph parentDetails = new Paragraph();
			parentDetails.add(new Chunk("Parent Details\n", blueFont));
			parentDetails.add(new Chunk("Father Name: "
					+ studentApplicationDocumentMapping.get(0).getStudentApplication().getFatherName() + "\n"));
			parentDetails.add(new Chunk("Mother Name: "
					+ studentApplicationDocumentMapping.get(0).getStudentApplication().getMotherName() + "\n"));
			parentDetails.setAlignment(Element.ALIGN_RIGHT);

			// Create a table with 2 columns to hold the paragraphs
			PdfPTable detailsTable = new PdfPTable(2);
			detailsTable.setWidthPercentage(100);
			PdfPCell studentDetailsCell = new PdfPCell(studentDetails);
			studentDetailsCell.setBorder(Rectangle.NO_BORDER);
			studentDetailsCell.setHorizontalAlignment(Element.ALIGN_LEFT);
			detailsTable.addCell(studentDetailsCell);

			PdfPCell parentDetailsCell = new PdfPCell(parentDetails);
			parentDetailsCell.setBorder(Rectangle.NO_BORDER);
			parentDetailsCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			detailsTable.addCell(parentDetailsCell);

			// Add the table to the document
			document.add(detailsTable);

			// Add address details
			document.add(Chunk.NEWLINE);
			Paragraph addressLabel = new Paragraph();
			addressLabel.add(new Chunk("Address: ", blueFont));
			addressLabel.add(new Chunk(studentApplicationDocumentMapping.get(0).getStudentApplication().getCity()));
			addressLabel.setAlignment(Element.ALIGN_CENTER);
			document.add(addressLabel);

			// Add qualification details
			document.add(Chunk.NEWLINE);
			Paragraph qualification = new Paragraph("Qualification", blueFont);
			qualification.setAlignment(Element.ALIGN_CENTER);
			document.add(qualification);

			Paragraph tenthDocument = new Paragraph("10th Document: "
					+ studentApplicationDocumentMapping.get(0).getQualification().getHigherEducation());
			tenthDocument.setAlignment(Element.ALIGN_CENTER);
			document.add(tenthDocument);

			Paragraph percentage = new Paragraph(
					"Percentage: " + studentApplicationDocumentMapping.get(0).getPercentage());
			percentage.setAlignment(Element.ALIGN_CENTER);
			document.add(percentage);

			Paragraph passingYear = new Paragraph(
					"Passing Year: " + studentApplicationDocumentMapping.get(0).getPassingYear());
			passingYear.setAlignment(Element.ALIGN_CENTER);
			document.add(passingYear);

			// Add document status
			document.add(Chunk.NEWLINE);
			Paragraph uploaded = new Paragraph("Documents Uploaded: Yes", blueFont);
			uploaded.setAlignment(Element.ALIGN_RIGHT);
			document.add(uploaded);

			Paragraph approved = new Paragraph("Documents Approved: Approved", blueFont);
			approved.setAlignment(Element.ALIGN_RIGHT);
			document.add(approved);

			// Add 12th qualification details
			document.add(Chunk.NEWLINE);
			Paragraph qualification12 = new Paragraph("Qualification: ", blueFont);
			qualification12.setAlignment(Element.ALIGN_CENTER);
			document.add(qualification12);

			Paragraph twelfthDocument = new Paragraph("12th Document: "
					+ studentApplicationDocumentMapping.get(1).getQualification().getHigherEducation());
			twelfthDocument.setAlignment(Element.ALIGN_CENTER);
			document.add(twelfthDocument);

			Paragraph percentage12 = new Paragraph(
					"Percentage: " + studentApplicationDocumentMapping.get(1).getPercentage());
			percentage12.setAlignment(Element.ALIGN_CENTER);
			document.add(percentage12);

			Paragraph passingYear12 = new Paragraph(
					"Passing Year: " + studentApplicationDocumentMapping.get(1).getPassingYear());
			passingYear12.setAlignment(Element.ALIGN_CENTER);
			document.add(passingYear12);

			Paragraph uploaded12 = new Paragraph("Documents Uploaded: Yes", blueFont);
			uploaded12.setAlignment(Element.ALIGN_RIGHT);
			document.add(uploaded12);

			Paragraph approved12 = new Paragraph("Documents Approved: Approved", blueFont);
			approved12.setAlignment(Element.ALIGN_RIGHT);
			document.add(approved12);

			// Add course details
			document.add(Chunk.NEWLINE);
			Paragraph courseDetails = new Paragraph("Course Details", blueFont);
			courseDetails.setAlignment(Element.ALIGN_CENTER);
			document.add(courseDetails);

			Paragraph courseName = new Paragraph("Course Name: "
					+ studentApplicationDocumentMapping.get(1).getStudentApplication().getCourseMaster().getCourses());
			courseName.setAlignment(Element.ALIGN_CENTER);
			document.add(courseName);

			// Add application form amount paid
			document.add(Chunk.NEWLINE);
			Paragraph amountPaid = new Paragraph("Application Form Amount Paid: Yes", blueFont);
			amountPaid.setAlignment(Element.ALIGN_RIGHT);
			document.add(amountPaid);

			// Add application approval status
			document.add(Chunk.NEWLINE);
			Paragraph approvalStatus = new Paragraph("Application Approval Status", blueFont);
			approvalStatus.setAlignment(Element.ALIGN_CENTER);
			document.add(approvalStatus);

			// Add whether the application is approved
			document.add(Chunk.NEWLINE);
			Paragraph isApproved = new Paragraph("Is Application Approved: Not Approved", blueFont);
			isApproved.setAlignment(Element.ALIGN_CENTER);
			document.add(isApproved);

			// Add allotted college
			document.add(Chunk.NEWLINE);
			Paragraph allottedCollege = new Paragraph("Allotted College:  Not College Allot", blueFont);
			allottedCollege.setAlignment(Element.ALIGN_CENTER);
			document.add(allottedCollege);

			// Add table with college details
//        document.add(Chunk.NEWLINE);
//        PdfPTable table = new PdfPTable(5);
//        table.setWidthPercentage(100);
//        table.addCell("College Name");
//        table.addCell("College Code");
//        table.addCell("Email id");
//        table.addCell("Phone");
//        table.addCell("Address");
//        document.add(table);

			document.close();
			System.out.println("PDF created successfully at: " + path);
			return Base64Utils.encodeToString(Files.readAllBytes(Path.of(path)));

		} catch (Exception e) {
			System.out.println("An error occurred: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Map<String, Boolean> checkRegistrationForCollege(Long userId) {
//
//		UserLogin user = this.loginRepo.findById(UserId).orElseThrow(() -> new RuntimeException("Inavlid user"));

		RegisterCollege college = this.collegeRepo.findByUser_Id(userId)
				.orElse(null);

		if(college == null)
			return Map.of("registered",false);
		else
			return Map.of("registered", true);
			
	}

}