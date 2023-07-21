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
import com.itextpdf.text.pdf.PdfWriter;

@RestController
public class Pdf_generator 
{
	@Autowired
	public EmployeeRepo e_repo;
	
	@Autowired
	public ResourceLoader r_loader;
	
	@GetMapping("employee/id/{id}/pdf")
	public ResponseEntity<byte[]> generate_pdf(@PathVariable Integer id) throws Exception
	{
		EmployeeCentral emp = e_repo.findByid(id);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		Document doc = new Document();
		
		
		PdfWriter.getInstance(doc ,baos);
		
		doc.open();
		
		Font bold = FontFactory.getFont(FontFactory.HELVETICA_BOLD , 16);
		Font normal = FontFactory.getFont(FontFactory.HELVETICA , 16);
		
		Paragraph formA = new Paragraph("Form A ", bold);
		formA.setAlignment(Element.ALIGN_CENTER);
		doc.add(formA);
		
		  Paragraph space43 = new Paragraph(" ");
		    doc.add(space43);
		
		Image photo = Image.getInstance(emp.getImagedata());
		 photo.scaleToFit(100, 200);
		 Paragraph image = new Paragraph("Photo - " +photo);
		 image.setAlignment(Element.ALIGN_RIGHT);
		doc.add(photo);
		
		  Paragraph space42 = new Paragraph(" ");
		    doc.add(space42);
		
		Integer empslNumberInEmployeeRegister1 = emp.getId();
		Paragraph slNumberInEmployeeRegister1 = new Paragraph("Sl. Number in Employee Register - " + empslNumberInEmployeeRegister1, normal);
	    slNumberInEmployeeRegister1.setAlignment(Element.ALIGN_LEFT);
	    doc.add(slNumberInEmployeeRegister1);
	   
	    Paragraph space41 = new Paragraph(" ");
	    doc.add(space41);
		
		String empname = emp.getName();
		Paragraph emp_name = new Paragraph("Name - " +empname , normal);
		emp_name.setAlignment(Element.ALIGN_LEFT);
		doc.add(emp_name);
		
		  Paragraph space40 = new Paragraph(" ");
		    doc.add(space40);
		
		String empsurname = emp.getLastname();
		Paragraph emp_surname = new Paragraph("Surname - " +empsurname , normal);
		emp_surname.setAlignment(Element.ALIGN_LEFT);
		doc.add(emp_surname);
		
		  Paragraph space39 = new Paragraph(" ");
		    doc.add(space39);
		
		String empgender = emp.getGender();
		Paragraph emp_gender = new Paragraph("Gender - " + empgender, normal);
		emp_gender.setAlignment(Element.ALIGN_LEFT);
		doc.add(emp_gender);
		
		  Paragraph space38 = new Paragraph(" ");
		    doc.add(space38);
		
		String empguardian = emp.getGurdianname();
		Paragraph emp_guardian = new Paragraph("Father / Spouse Name - " + empguardian , normal);
		emp_guardian.setAlignment(Element.ALIGN_LEFT);
		doc.add(emp_guardian);
		
		  Paragraph space37 = new Paragraph(" ");
		    doc.add(space37);
		
		Date empdob = emp.getDob();
		Paragraph emp_dob = new Paragraph("Date of Birth - " + empdob , normal);
		emp_dob.setAlignment(Element.ALIGN_LEFT);
		doc.add(emp_dob);
		
		  Paragraph space36 = new Paragraph(" ");
		    doc.add(space36);
		
		String empnation = emp.getNation();
		Paragraph nationality = new Paragraph("Nationality - " + empnation, normal);
	   nationality.setAlignment(Element.ALIGN_LEFT);
		doc.add(nationality);
		
		  Paragraph space35 = new Paragraph(" ");
		    doc.add(space35);

	    String emp_edu = emp.getEdu();
		Paragraph educationLevel = new Paragraph("Education Level - " + emp_edu, normal);
		educationLevel.setAlignment(Element.ALIGN_LEFT);
		doc.add(educationLevel);
		
		  Paragraph space34 = new Paragraph(" ");
		    doc.add(space34);

	    Date empdoj = emp.getDoj();
		Paragraph dateOfJoining = new Paragraph("Date of Joining - " +empdoj, normal);
		dateOfJoining.setAlignment(Element.ALIGN_LEFT);
		doc.add(dateOfJoining);
		
		  Paragraph space33 = new Paragraph(" ");
		    doc.add(space33);

		String empdesignation = emp.getPost();
	    Paragraph designation = new Paragraph("Designation - " + empdesignation, normal);
	    designation.setAlignment(Element.ALIGN_LEFT);
	    doc.add(designation);
	    
	    Paragraph space32 = new Paragraph(" ");
	    doc.add(space32);

	    String empcategoryAddress = emp.getSkill();
	    Paragraph categoryAddress = new Paragraph("Category Address - " + empcategoryAddress, normal);
	    categoryAddress.setAlignment(Element.ALIGN_LEFT);
	    doc.add(categoryAddress);
	    
	    Paragraph space31 = new Paragraph(" ");
	    doc.add(space31);

	    String emptypeOfEmployment = emp.getType_emp();
	    Paragraph typeOfEmployment = new Paragraph("Type of Employment - " + emptypeOfEmployment, normal);
	    typeOfEmployment.setAlignment(Element.ALIGN_LEFT);
	    doc.add(typeOfEmployment);
	    
	    Paragraph space30 = new Paragraph(" ");
	    doc.add(space30);

	    Long empmobile = emp.getMob();
	    Paragraph mobile = new Paragraph("Mobile - " + empmobile, normal);
	    mobile.setAlignment(Element.ALIGN_LEFT);
	    doc.add(mobile);
	    
	    Paragraph space29 = new Paragraph(" ");
	    doc.add(space29);

	    String empuan = emp.getUan(); 
	    Paragraph uan = new Paragraph("UAN - " +empuan, normal);
	    uan.setAlignment(Element.ALIGN_LEFT);
	    doc.add(uan);
	    
	    Paragraph space28 = new Paragraph(" ");
	    doc.add(space28);

	    String emppan = emp.getPan();
	    Paragraph pan = new Paragraph("PAN - " + emppan, normal);
	    pan.setAlignment(Element.ALIGN_LEFT);
	    doc.add(pan);
	    
	    Paragraph space27 = new Paragraph(" ");
	    doc.add(space27);

	    Integer empesicIP = emp.getEsicip();
	    Paragraph esicIP = new Paragraph("ESIC IP - " +empesicIP, normal);
	    esicIP.setAlignment(Element.ALIGN_LEFT);
	    doc.add(esicIP);
	    
	    Paragraph space26 = new Paragraph(" ");
	    doc.add(space26);

	    String emplwf = emp.getLwf();
	    Paragraph lwf = new Paragraph("LWF - " + emplwf, normal);
	    lwf.setAlignment(Element.ALIGN_LEFT);
	    doc.add(lwf);
	    
	    Paragraph space25 = new Paragraph(" ");
	    doc.add(space25);

	    Long empaddhar = emp.getAddhar();
	    Paragraph aadhaar = new Paragraph("AADHAAR - " + empaddhar, normal);
	    aadhaar.setAlignment(Element.ALIGN_LEFT);
	    doc.add(aadhaar);
	    
	    Paragraph space24 = new Paragraph(" ");
	    doc.add(space24);

	    Long empbankAccountNumber = emp.getBankaccount();
	    Paragraph bankAccountNumber = new Paragraph("Bank A/c Number - " + empbankAccountNumber, normal);
	    bankAccountNumber.setAlignment(Element.ALIGN_LEFT);
	    doc.add(bankAccountNumber);
	    
	    Paragraph space23 = new Paragraph(" ");
	    doc.add(space23);

	    String empbankBranchIFSC = emp.getIfsc();
	    Paragraph bankBranchIFSC = new Paragraph("Bank Branch (IFSC) - " + empbankBranchIFSC, normal);
	    bankBranchIFSC.setAlignment(Element.ALIGN_LEFT);
	    doc.add(bankBranchIFSC);
	    
	    Paragraph space22 = new Paragraph(" ");
	    doc.add(space22);
	    
	    String emppresentAddress = emp.getPreadd();
	    Paragraph presentAddress = new Paragraph("Present Address - " + emppresentAddress, normal);
	    presentAddress.setAlignment(Element.ALIGN_LEFT);
	    doc.add(presentAddress);
	    
	    Paragraph space21 = new Paragraph(" ");
	    doc.add(space21);

	    String emppermanentAddress = emp.getPermadd();
	    Paragraph permanentAddress = new Paragraph("Permanent Address - " + emppermanentAddress, normal);
	    permanentAddress.setAlignment(Element.ALIGN_LEFT);
	    doc.add(permanentAddress);
	    
	    Paragraph space20 = new Paragraph(" ");
	    doc.add(space20);

	    Long empserviceBookNo = emp.getMvtcert();
	    Paragraph serviceBookNo = new Paragraph("Service Book No. - " +empserviceBookNo, normal);
	    serviceBookNo.setAlignment(Element.ALIGN_LEFT);
	    doc.add(serviceBookNo);
	    
	    Paragraph space19 = new Paragraph(" ");
	    doc.add(space19);

	    Date empdoe = emp.getDoe();
	    Paragraph dateOfExit = new Paragraph("Date of Exit - " + empdoe, normal);
	    dateOfExit.setAlignment(Element.ALIGN_LEFT);
	    doc.add(dateOfExit);
	    
	    Paragraph space18 = new Paragraph(" ");
	    doc.add(space18);

	    String empreasonForExit = emp.getRoe();
	    Paragraph reasonForExit = new Paragraph("Reason for Exit - " + empreasonForExit, normal);
	    reasonForExit.setAlignment(Element.ALIGN_LEFT);
	    doc.add(reasonForExit);
	    
	    Paragraph space17 = new Paragraph(" ");
	    doc.add(space17);

	    String empmarkOfIdentification = emp.getMoi();
	    Paragraph markOfIdentification = new Paragraph("Mark of Identification - " + empmarkOfIdentification, normal);
	    markOfIdentification.setAlignment(Element.ALIGN_LEFT);
	    doc.add(markOfIdentification);
	    
	    Paragraph space16 = new Paragraph(" ");
	    doc.add(space16);

	    String empspecimenSignatureThumbImpression = emp.getSignature();
	    Paragraph specimenSignatureThumbImpression = new Paragraph("Specimen Signature/Thumb Impression - " + empspecimenSignatureThumbImpression, normal);
	    specimenSignatureThumbImpression.setAlignment(Element.ALIGN_LEFT);
	    doc.add(specimenSignatureThumbImpression);
	    
	    Paragraph space15 = new Paragraph(" ");
	    doc.add(space15);

	    String  empremarks = emp.getRemarks();
	    Paragraph remarks = new Paragraph("Remarks - " + empremarks, normal);
	    remarks.setAlignment(Element.ALIGN_LEFT);
	    doc.add(remarks);

	   
		doc.newPage();
		
		Paragraph formB = new Paragraph("Form B" , bold);
		formB.setAlignment(Element.ALIGN_CENTER);
		doc.add(formB);
		
		Paragraph space14 = new Paragraph(" ");
		doc.add(space14);
		
		Integer empslNumberInEmployeeRegister = emp.getId();
		Paragraph slNumberInEmployeeRegister = new Paragraph("Sl. Number in Employee Register - " + empslNumberInEmployeeRegister, normal);
	    slNumberInEmployeeRegister.setAlignment(Element.ALIGN_LEFT);
	    doc.add(slNumberInEmployeeRegister);
	    
	    Paragraph space13 = new Paragraph(" ");
	    doc.add(space13);
			
	    String empname1 = emp.getName();
		Paragraph emp_name1 = new Paragraph("Name - " +empname1 , normal);
		emp_name1.setAlignment(Element.ALIGN_LEFT);
		doc.add(emp_name1);
		
		Paragraph space12 = new Paragraph(" ");
		doc.add(space12);
		
		Date empdateOfFirstAppointment = emp.getFirst_meeting();
		Paragraph dateOfFirstAppointment = new Paragraph("Date of First Appointment with present Owner - " + empdateOfFirstAppointment, normal);
		dateOfFirstAppointment.setAlignment(Element.ALIGN_LEFT);
		doc.add(dateOfFirstAppointment);
		
		Paragraph space11 = new Paragraph(" ");
		doc.add(space11);

		Date empcertificateOfAgeFitness = emp.getFitness_not_adult();
	    Paragraph certificateOfAgeFitness = new Paragraph("Certificate of age/fitness taken (for 14 to 18 Years) - " + empcertificateOfAgeFitness, normal);
	    certificateOfAgeFitness.setAlignment(Element.ALIGN_LEFT);
	    doc.add(certificateOfAgeFitness);
	    
	    Paragraph space10 = new Paragraph(" ");
	    doc.add(space10);

	    String empplaceOfEmployment = emp.getEmployment_place();
	    Paragraph placeOfEmployment = new Paragraph("Place of Employment - " + empplaceOfEmployment, normal);
	    placeOfEmployment.setAlignment(Element.ALIGN_LEFT);
	    doc.add(placeOfEmployment);
	    
	    Paragraph space9 = new Paragraph(" ");
	    doc.add(space9);

	    Integer empcertificateOfVocationalTrainingNumber = emp.getVtnumber();
	    Paragraph certificateOfVocationalTrainingNumber = new Paragraph("Certificate of Vocational Training Number - " + empcertificateOfVocationalTrainingNumber, normal);
	    certificateOfVocationalTrainingNumber.setAlignment(Element.ALIGN_LEFT);
	    doc.add(certificateOfVocationalTrainingNumber);
	    
	    Paragraph space8 = new Paragraph(" ");
	    doc.add(space8);

	    Date empcertificateOfVocationalTrainingDate = emp.getVtdate();
	    Paragraph certificateOfVocationalTrainingDate = new Paragraph("Certificate of Vocational Training Date - " + empcertificateOfVocationalTrainingDate, normal);
	    certificateOfVocationalTrainingDate.setAlignment(Element.ALIGN_LEFT);
	    doc.add(certificateOfVocationalTrainingDate);
	    
	    Paragraph space7 = new Paragraph(" ");
	    doc.add(space7);
	    
	    String empnomineeName = emp.getNname();
	    Paragraph nomineeName = new Paragraph("Nominee Name - " + empnomineeName, normal);
	    nomineeName.setAlignment(Element.ALIGN_LEFT);
	    doc.add(nomineeName);
	    
	    Paragraph space6 = new Paragraph(" ");
	    doc.add(space6);

	    String empnomineeAddress = emp.getNadd();
	    Paragraph nomineeAddress = new Paragraph("Nominee Address - " + empnomineeAddress, normal);
	    nomineeAddress.setAlignment(Element.ALIGN_LEFT);
	    doc.add(nomineeAddress);

	    Paragraph space5 = new Paragraph(" ");
	    doc.add(space5);
	    
	    String empemergencyContactName = emp.getEcname();
	    Paragraph emergencyContactName = new Paragraph("Emergency Contact Name - " + empemergencyContactName, normal);
	    emergencyContactName.setAlignment(Element.ALIGN_LEFT);
	    doc.add(emergencyContactName);

	    Paragraph space4 = new Paragraph(" ");
	    doc.add(space4);
	    
	    String empemergencyContactRelationship = emp.getEcrelationship();
	    Paragraph emergencyContactRelationship = new Paragraph("Emergency Contact Relationship - " + empemergencyContactRelationship, normal);
	    emergencyContactRelationship.setAlignment(Element.ALIGN_LEFT);
	    doc.add(emergencyContactRelationship);

	    String empemergencyContactAddress = emp.getEcadd();
	    Paragraph emergencyContactAddress = new Paragraph("Emergency Contact Address - " + empemergencyContactAddress, normal);
	    emergencyContactAddress.setAlignment(Element.ALIGN_LEFT);
	    doc.add(emergencyContactAddress);

	    Paragraph space3 = new Paragraph(" ");
	    doc.add(space3);
	    
	    Long empemergencyContactMobile = emp.getEcmob();
	    Paragraph emergencyContactMobile = new Paragraph("Emergency Contact Mobile - " + empemergencyContactMobile, normal);
	    emergencyContactMobile.setAlignment(Element.ALIGN_LEFT);
	    doc.add(emergencyContactMobile);
	    
	    Paragraph space2 = new Paragraph(" ");
	    doc.add(space2);
	    
	    String empremarks1 = emp.getRemarks();
	    Paragraph remarks1 = new Paragraph("Remarks - " + empremarks1, normal);
	    remarks1.setAlignment(Element.ALIGN_LEFT);
	    doc.add(remarks1);
	    
	    Paragraph space1 = new Paragraph(" ");
	    doc.add(space1);
	    
	    String empsignatureOfMinesManager = emp.getSig_mines_manager();
	    Paragraph signatureOfMinesManager = new Paragraph("Signature of Mines Manager -" +empsignatureOfMinesManager, normal);
	    signatureOfMinesManager.setAlignment(Element.ALIGN_LEFT);
	    doc.add(signatureOfMinesManager);
		
		doc.close();
	

		HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + " " +emp.getName()+ emp.getId() +".pdf");
        byte[] pdfContent = baos.toByteArray();

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body( pdfContent);
		
	}

}
