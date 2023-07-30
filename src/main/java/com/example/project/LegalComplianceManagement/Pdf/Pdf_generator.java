package com.example.project.LegalComplianceManagement.Pdf;

import java.io.ByteArrayOutputStream;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.LegalComplianceManagement.Entity.EmployeeCentral;
import com.example.project.LegalComplianceManagement.Repository.EmployeeRepo;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@RestController
public class Pdf_generator {
	@Autowired
	public EmployeeRepo e_repo;

	@Autowired
	public ResourceLoader r_loader;

	private PdfPCell createCenteredCell(String content, Font font) {
		PdfPCell cell = new PdfPCell(new Paragraph(content, font));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setPaddingBottom(15);
		cell.setPaddingTop(10);
		return cell;
	}

	@GetMapping("employee/id/{id}/pdf")
	public ResponseEntity<byte[]> generate_pdf(@PathVariable Integer id) throws Exception {
		EmployeeCentral emp = e_repo.findByid(id);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		Document doc = new Document();

		PdfWriter.getInstance(doc, baos);

		doc.open();
		Font boldCenter = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 45);
		Font bold = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16);
		Font normal = FontFactory.getFont(FontFactory.HELVETICA, 16);

		PdfPTable table = new PdfPTable(2);
		table.setWidthPercentage(100);
		table.setSpacingBefore(10);

		Paragraph formA = new Paragraph("Form A", boldCenter);
		formA.setAlignment(Element.ALIGN_CENTER);
		doc.add(formA);

		Paragraph addSpace = new Paragraph(" ");
		doc.add(addSpace);

		Paragraph partA = new Paragraph("Part-A", bold);
		partA.setAlignment(Element.ALIGN_CENTER);
		doc.add(partA);

		Paragraph addSpace1 = new Paragraph(" ");
		doc.add(addSpace1);

		/*
		 * Image photo = Image.getInstance(emp.getImagedata());
		 * photo.scaleToFit(50, 100);
		 * Paragraph image = new Paragraph("Photo - " + photo);
		 * image.setAlignment(Element.ALIGN_LEFT);
		 * doc.add(photo);
		 */
		// Add the fields to the table
		table.addCell(createCenteredCell("Name", normal));
		table.addCell(createCenteredCell(emp.getName(), normal));

		table.addCell(createCenteredCell("Surname", normal));
		table.addCell(createCenteredCell(emp.getLastname(), normal));

		table.addCell(createCenteredCell("Gender", normal));
		table.addCell(createCenteredCell(emp.getGender(), normal));

		table.addCell(createCenteredCell("Father / Spouse Name", normal));
		table.addCell(createCenteredCell(emp.getGurdianname(), normal));

		table.addCell(createCenteredCell("Date of Birth", normal));
		table.addCell(createCenteredCell(String.valueOf(emp.getDob()), normal));

		table.addCell(createCenteredCell("Nationality", normal));
		table.addCell(createCenteredCell(emp.getNation(), normal));

		table.addCell(createCenteredCell("Education Level", normal));
		table.addCell(createCenteredCell(emp.getEdu(), normal));

		table.addCell(createCenteredCell("Date of Joining", normal));
		table.addCell(createCenteredCell(String.valueOf(emp.getDoj()), normal));

		table.addCell(createCenteredCell("Designation", normal));
		table.addCell(createCenteredCell(emp.getPost(), normal));

		table.addCell(createCenteredCell("Category Address", normal));
		table.addCell(createCenteredCell(emp.getSkill(), normal));

		table.addCell(createCenteredCell("Type of Employment", normal));
		table.addCell(createCenteredCell(emp.getType_emp(), normal));

		table.addCell(createCenteredCell("Mobile", normal));
		table.addCell(createCenteredCell(String.valueOf(emp.getMob()), normal));

		table.addCell(createCenteredCell("UAN", normal));
		table.addCell(createCenteredCell(emp.getUan(), normal));

		table.addCell(createCenteredCell("PAN", normal));
		table.addCell(createCenteredCell(emp.getPan(), normal));

		table.addCell(createCenteredCell("ESIC IP", normal));
		table.addCell(createCenteredCell(String.valueOf(emp.getEsicip()), normal));

		table.addCell(createCenteredCell("LWF", normal));
		table.addCell(createCenteredCell(emp.getLwf(), normal));

		table.addCell(createCenteredCell("AADHAAR", normal));
		table.addCell(createCenteredCell(String.valueOf(emp.getAddhar()), normal));

		table.addCell(createCenteredCell("Bank A/c Number", normal));
		table.addCell(createCenteredCell(String.valueOf(emp.getBankaccount()), normal));

		table.addCell(createCenteredCell("Bank Branch (IFSC)", normal));
		table.addCell(createCenteredCell(emp.getIfsc(), normal));

		table.addCell(createCenteredCell("Present Address", normal));
		table.addCell(createCenteredCell(emp.getPreadd(), normal));

		table.addCell(createCenteredCell("Permanent Address", normal));
		table.addCell(createCenteredCell(emp.getPermadd(), normal));

		table.addCell(createCenteredCell("Service Book No.", normal));
		table.addCell(createCenteredCell(String.valueOf(emp.getMvtcert()), normal));

		table.addCell(createCenteredCell("Date of Exit", normal));
		table.addCell(createCenteredCell(String.valueOf(emp.getDoe()), normal));

		table.addCell(createCenteredCell("Reason for Exit", normal));
		table.addCell(createCenteredCell(emp.getRoe(), normal));

		table.addCell(createCenteredCell("Mark of Identification", normal));
		table.addCell(createCenteredCell(emp.getMoi(), normal));

		PdfPCell photoCell = new PdfPCell();
		Image photo = Image.getInstance(emp.getImagedata());
		photo.scaleToFit(100, 200);
		photoCell.addElement(photo);
		table.addCell(createCenteredCell("Photo", normal));
		table.addCell(photoCell);

		table.addCell(createCenteredCell("Specimen Signature/Thumb Impression", normal));
		table.addCell(createCenteredCell(emp.getSignature(), normal));

		table.addCell(createCenteredCell("Remarks", normal));
		table.addCell(createCenteredCell(emp.getRemarks(), normal));

		// Add the table to the document
		doc.add(table);

		// Add Form B
		doc.newPage();

		PdfPTable tableFormB = new PdfPTable(2);
		tableFormB.setWidthPercentage(100);
		tableFormB.setSpacingBefore(10);

		Paragraph partB = new Paragraph("Part-B", bold);
		partB.setAlignment(Element.ALIGN_CENTER);
		doc.add(partB);

		Paragraph addSpace2 = new Paragraph(" ");
		doc.add(addSpace2);
		// Add the fields to the table (Form B)
		tableFormB.addCell(createCenteredCell("Sl. Number in Employee Register", normal));
		tableFormB.addCell(createCenteredCell(String.valueOf(emp.getId()), normal));

		tableFormB.addCell(createCenteredCell("Name", normal));
		tableFormB.addCell(createCenteredCell(emp.getName(), normal));

		tableFormB.addCell(createCenteredCell("Date of First Appointment with present Owner", normal));
		tableFormB.addCell(createCenteredCell(String.valueOf(emp.getFirst_meeting()), normal));

		tableFormB.addCell(createCenteredCell("Certificate of age/fitness taken (for 14 to 18 Years)", normal));
		tableFormB.addCell(createCenteredCell(String.valueOf(emp.getFitness_not_adult()), normal));

		tableFormB.addCell(createCenteredCell("Place of Employment", normal));
		tableFormB.addCell(createCenteredCell(emp.getEmployment_place(), normal));

		tableFormB.addCell(createCenteredCell("Certificate of Vocational Training Number", normal));
		tableFormB.addCell(createCenteredCell(String.valueOf(emp.getVtnumber()), normal));

		tableFormB.addCell(createCenteredCell("Certificate of Vocational Training Date", normal));
		tableFormB.addCell(createCenteredCell(String.valueOf(emp.getVtdate()), normal));

		tableFormB.addCell(createCenteredCell("Nominee Name", normal));
		tableFormB.addCell(createCenteredCell(emp.getNname(), normal));

		tableFormB.addCell(createCenteredCell("Nominee Address", normal));
		tableFormB.addCell(createCenteredCell(emp.getNadd(), normal));

		tableFormB.addCell(createCenteredCell("Emergency Contact Name", normal));
		tableFormB.addCell(createCenteredCell(emp.getEcname(), normal));

		tableFormB.addCell(createCenteredCell("Emergency Contact Relationship", normal));
		tableFormB.addCell(createCenteredCell(emp.getEcrelationship(), normal));

		tableFormB.addCell(createCenteredCell("Emergency Contact Address", normal));
		tableFormB.addCell(createCenteredCell(emp.getEcadd(), normal));

		tableFormB.addCell(createCenteredCell("Emergency Contact Mobile", normal));
		tableFormB.addCell(createCenteredCell(String.valueOf(emp.getEcmob()), normal));

		tableFormB.addCell(createCenteredCell("Remarks", normal));
		tableFormB.addCell(createCenteredCell(emp.getRemarks(), normal));

		tableFormB.addCell(createCenteredCell("Signature of Mines Manager", normal));
		tableFormB.addCell(createCenteredCell(emp.getSig_mines_manager(), normal));

		// Add Form B table to the document
		doc.add(tableFormB);

		doc.close();

		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_DISPOSITION,
				"attachment; filename=" + " " + emp.getName() + emp.getId() + ".pdf");
		byte[] pdfContent = baos.toByteArray();

		return ResponseEntity.ok()
				.headers(headers)
				.contentType(MediaType.APPLICATION_PDF)
				.body(pdfContent);
	}
}
