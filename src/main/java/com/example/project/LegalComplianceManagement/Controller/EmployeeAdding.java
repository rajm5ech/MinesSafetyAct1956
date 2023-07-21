package com.example.project.LegalComplianceManagement.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.PictureData;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.project.LegalComplianceManagement.Entity.EmployeeCentral;
import com.example.project.LegalComplianceManagement.IdGenerator.CustomIdgenerator;
import com.example.project.LegalComplianceManagement.Repository.EmployeeRepo;
@RestController
public class EmployeeAdding
{
	@Autowired
	public EmployeeRepo e_repo;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@GetMapping("delete-emp/id/{id}")
	public ResponseEntity<String> delete_emp(@PathVariable Integer id)
	{
		e_repo.deleteByid(id);
		return ResponseEntity.ok().body("Employee" + " " + id + " " + "deleted");
	}

	@GetMapping("emp/id/{id}")  // Search by id.
	public ResponseEntity<EmployeeCentral> search_id(@PathVariable Integer id)
	{
		EmployeeCentral emp_id = e_repo.findByid(id);
		return ResponseEntity.ok().body(emp_id);
	}
	
	@GetMapping("emp/doj/{doj}")  //Search by doj.
	public ResponseEntity<List<EmployeeCentral>> search_doj(@PathVariable Date doj)
	{
		List<EmployeeCentral> emp_doj = e_repo.findBydoj(doj);
		return ResponseEntity.ok().body(emp_doj);
	}
	
	@GetMapping("/emp/doj/{doj}/firstname/{firstname}")  // Search by and first name.
	public ResponseEntity<List<EmployeeCentral>> search_department_firstname(@PathVariable Date doj 
																																					, @PathVariable String name)
	{
		List<EmployeeCentral> emp_dep_fname = e_repo.findBydojAndName(doj, name);
		return ResponseEntity.ok().body(emp_dep_fname );
	}
	
	
	
	@GetMapping("/emp/addhar/{addhar}")  // Search .
	public ResponseEntity<EmployeeCentral> search_company(@PathVariable Long addhar)
	{
		EmployeeCentral emp_addhar = e_repo.findByaddhar(addhar);
		return ResponseEntity.ok().body(emp_addhar);
	}
	
	@PostMapping("/emp/insertion")  // Insertion of employee data manually through JSON object.
	public ResponseEntity<String> insertion_manual(@RequestBody EmployeeCentral employee)
	{
		e_repo.save(employee);
		Integer id = employee.getId();
		return ResponseEntity.ok().body("Employee Data Inserted" + id);
	}
	
	@PostMapping("/emp/image-insertion/{id}")  // Insertion of employee image manually through JSON object.
	public ResponseEntity<String> insertion_image_manual(@PathVariable Integer id , @RequestBody MultipartFile image) throws IOException, Exception, SQLException 
	{
		EmployeeCentral emp = e_repo.findByid(id);
		byte[] imageData = image.getBytes();
		Blob imageBlob = new SerialBlob(imageData);
		 byte[] imageBytes = imageBlob.getBytes(1, (int) imageBlob.length());
	   emp.setImagedata(imageBytes);
		e_repo.save(emp);
		return ResponseEntity.ok().body("Employee Image Inserted");
	}
	
	@PostMapping("/emp/insertion/pdf")
	public ResponseEntity<String> insertion_excel(@PathVariable MultipartFile excelFile) throws Exception
	{
		String file_content_type = excelFile.getContentType();
		if(file_content_type.equals("xlsx"))
		{
			String filename = excelFile.getOriginalFilename();
			FileOutputStream fout = new FileOutputStream("src//main//resources//Upload//"+ filename);
			fout.write(excelFile.getBytes());
			
			Workbook workbook = new XSSFWorkbook("src//main//resources//Upload//"+filename);
			Sheet worksheet = workbook.getSheetAt(0);
			Row row;
		
		
			Drawing<?> drawing = worksheet.getDrawingPatriarch();
	        List<? extends PictureData> pictureDataList = workbook.getAllPictures();
	        ArrayList<EmployeeCentral> emplist = new ArrayList<EmployeeCentral>();
	        for(int i = 1 ; i < worksheet.getPhysicalNumberOfRows() ; i++)
			{
				EmployeeCentral	emp1 = new EmployeeCentral();
				CustomIdgenerator id_gen = new CustomIdgenerator();
				row = worksheet.getRow(i);
				emp1.setSl_no((int)row.getCell(0).getNumericCellValue());
				 if(row.getCell(1).getStringCellValue().isBlank())
				 {
					 emp1.setId((int) id_gen.generate(null, emp1));
				 }
				 else
					 emp1.setId((int)row.getCell(1).getNumericCellValue());
				emp1.setName(row.getCell(2).getStringCellValue());
				emp1.setLastname(row.getCell(3).getStringCellValue());
				emp1.setGender(row.getCell(4).getStringCellValue());
				emp1.setGurdianname(row.getCell(5).getStringCellValue());
				emp1.setDob(row.getCell(6).getDateCellValue());
				emp1.setNation(row.getCell(7).getStringCellValue());
				emp1.setEdu(row.getCell(8).getStringCellValue());
				emp1.setDoj(row.getCell(9).getDateCellValue());
				emp1.setPost(row.getCell(10).getStringCellValue());
				emp1.setSkill(row.getCell(11).getStringCellValue());
				emp1.setType_emp(row.getCell(12).getStringCellValue());
				emp1.setMob((long)row.getCell(13).getNumericCellValue()); 
				emp1.setUan(row.getCell(14).getStringCellValue());
				emp1.setPan(row.getCell(15).getStringCellValue());
				emp1.setEsicip((int)row.getCell(16).getNumericCellValue());
				emp1.setLwf(row.getCell(17).getStringCellValue());
				emp1.setAddhar((long)row.getCell(18).getNumericCellValue());
				emp1.setBankaccount((long)row.getCell(19).getNumericCellValue());
				emp1.setBank(row.getCell(20).getStringCellValue());
				emp1.setIfsc(row.getCell(21).getStringCellValue());
				emp1.setPreadd(row.getCell(22).getStringCellValue());
				emp1.setPermadd(row.getCell(23).getStringCellValue());
				emp1.setMvtcert((long)row.getCell(24).getNumericCellValue());
				Cell doe = row.getCell(25);
				if(doe != null && doe.getCellType() == CellType.NUMERIC)
				{
					emp1.setDoe(row.getCell(25).getDateCellValue());
				}
				else 
					emp1.setDoe(null);
				Cell roe = row.getCell(27);
				if(roe != null && roe.getCellType() == CellType.STRING)
				{
					emp1.setRoe(row.getCell(26).getStringCellValue());
				}
				else
					emp1.setRoe(null);
				emp1.setMoi(row.getCell(28).getStringCellValue());
				Cell imageCell = row.getCell(29);
		        if (imageCell != null && imageCell.getCellType() == CellType.STRING)
		        {
		            String imageFilePath = imageCell.getStringCellValue();
		            byte[] imageData = readImageFromFile(imageFilePath);
		            emp1.setImagedata(imageData);
		        }  
		        emp1.setSignature(row.getCell(30).getStringCellValue());
		        emp1.setRemarks(row.getCell(31).getStringCellValue());
		        emp1.setFirst_meeting(row.getCell(32).getDateCellValue());
		        emp1.setFitness_not_adult(row.getCell(33).getDateCellValue());
		        emp1.setEmployment_place(row.getCell(34).getStringCellValue());
		        emp1.setVtnumber((int)row.getCell(35).getNumericCellValue());
		        emp1.setVtdate(row.getCell(36).getDateCellValue());
		        emp1.setNname(row.getCell(37).getStringCellValue());
		        emp1.setNadd(row.getCell(38).getStringCellValue());
		        emp1.setEcname(row.getCell(39).getStringCellValue());
		        emp1.setEcrelationship(row.getCell(40).getStringCellValue());
		        emp1.setEcadd(row.getCell(41).getStringCellValue());
		        emp1.setEcmob((long)row.getCell(42).getNumericCellValue());
		        emp1.setSig_mines_manager(row.getCell(43).getStringCellValue());
		        emplist.add(emp1);
			}
	        e_repo.saveAll(emplist);
		}
		
		return ResponseEntity.ok().body("Excel Employee data uploaded");
	}	
	private byte[] readImageFromFile(String filePath) throws IOException 
	{
	    File imageFile = new File(filePath);
	    byte[] imageData = null;

	    if (imageFile.exists()) 
	    {
	        try (InputStream inputStream = new FileInputStream(imageFile))
	        {
	            imageData = inputStream.readAllBytes();
	        }
	    }

	    return imageData;
	}


}	
	
	
	
	
	
	
	
	
	
	
	

