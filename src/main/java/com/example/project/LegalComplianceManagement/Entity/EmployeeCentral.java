package com.example.project.LegalComplianceManagement.Entity;

import java.util.Arrays;
import java.util.Date;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "essar_employee_central")
public class EmployeeCentral 
{
     @Id
     @GeneratedValue(generator="Employee-custom-id")
     @GenericGenerator(name="Employee-custome-id", type = com.example.project.LegalComplianceManagement.IdGenerator.CustomIdgenerator.class)
   
     private Integer id;
  
 	private Integer sl_no;
     
     private String name;
    
     private String lastname;
    
     private String gender;
    
     private String gurdianname;
    
     private Date dob;
    
     private String nation;
  
     private String edu;
    
     private Date doj;
   
     private String post;
    
     private String skill;
    
 private String type_emp;
    
     private Long mob;
    
     private String uan;
   
     private String pan;
    
     private Integer esicip;
 
     private String lwf;
   
     private Long addhar;
   
     private Long bankaccount;
  
     private String bank;
    
     private String ifsc;
   
     private String preadd;
     
     private String permadd;
     
     private Long mvtcert;
 
     private Date doe;
    
     private String roe;
  
     private String moi;
   

     private byte[] imagedata;
   
     private String signature;
     
     private String remarks;
    
     private Date first_meeting;
   
     private Date fitness_not_adult;
   
     private String employment_place;
   
     private Integer vtnumber;
   
     private Date vtdate;
    
     private String nname;
     
     private String nadd;
    
     private String ecname;
    
     private String ecrelationship;
    
     private String ecadd;
   
     private Long ecmob;
   
     private String sig_mines_manager;
     
     private Integer leave;
     
     public EmployeeCentral() {
		
	}

	public EmployeeCentral(Integer sl_no, String name, String lastname, String gender, String gurdianname, Date dob,
			String nation, String edu, Date doj, String post, String skill, String type_emp, Long mob, String uan,
			String pan, Integer esicip, String lwf, Long addhar, Long bankaccount, String bank, String ifsc,
			String preadd, String permadd, Long mvtcert, Date doe, String roe, String moi, byte[] imagedata,
			String signature, String remarks, Date first_meeting, Date fitness_not_adult, String employment_place,
			Integer vtnumber, Date vtdate, String nname, String nadd, String ecname, String ecrelationship,
			String ecadd, Long ecmob, String sig_mines_manager , Integer leave) {
		
		this.sl_no = sl_no;
		this.name = name;
		this.lastname = lastname;
		this.gender = gender;
		this.gurdianname = gurdianname;
		this.dob = dob;
		this.nation = nation;
		this.edu = edu;
		this.doj = doj;
		this.post = post;
		this.skill = skill;
		this.type_emp = type_emp;
		this.mob = mob;
		this.uan = uan;
		this.pan = pan;
		this.esicip = esicip;
		this.lwf = lwf;
		this.addhar = addhar;
		this.bankaccount = bankaccount;
		this.bank = bank;
		this.ifsc = ifsc;
		this.preadd = preadd;
		this.permadd = permadd;
		this.mvtcert = mvtcert;
		this.doe = doe;
		this.roe = roe;
		this.moi = moi;
		this.imagedata = imagedata;
		this.signature = signature;
		this.remarks = remarks;
		this.first_meeting = first_meeting;
		this.fitness_not_adult = fitness_not_adult;
		this.employment_place = employment_place;
		this.vtnumber = vtnumber;
		this.vtdate = vtdate;
		this.nname = nname;
		this.nadd = nadd;
		this.ecname = ecname;
		this.ecrelationship = ecrelationship;
		this.ecadd = ecadd;
		this.ecmob = ecmob;
		this.sig_mines_manager = sig_mines_manager;
		this.leave = leave;
	}

	public EmployeeCentral(Integer sl_no, Integer id, String name, String lastname, String gender, String gurdianname,
			Date dob, String nation, String edu, Date doj, String post, String skill, String type_emp, Long mob,
			String uan, String pan, Integer esicip, String lwf, Long addhar, Long bankaccount, String bank, String ifsc,
			String preadd, String permadd, Long mvtcert, Date doe, String roe, String moi, byte[] imagedata,
			String signature, String remarks, Date first_meeting, Date fitness_not_adult, String employment_place,
			Integer vtnumber, Date vtdate, String nname, String nadd, String ecname, String ecrelationship,
			String ecadd, Long ecmob, String sig_mines_manager ,Integer leave) {
	
		this.sl_no = sl_no;
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.gender = gender;
		this.gurdianname = gurdianname;
		this.dob = dob;
		this.nation = nation;
		this.edu = edu;
		this.doj = doj;
		this.post = post;
		this.skill = skill;
		this.type_emp = type_emp;
		this.mob = mob;
		this.uan = uan;
		this.pan = pan;
		this.esicip = esicip;
		this.lwf = lwf;
		this.addhar = addhar;
		this.bankaccount = bankaccount;
		this.bank = bank;
		this.ifsc = ifsc;
		this.preadd = preadd;
		this.permadd = permadd;
		this.mvtcert = mvtcert;
		this.doe = doe;
		this.roe = roe;
		this.moi = moi;
		this.imagedata = imagedata;
		this.signature = signature;
		this.remarks = remarks;
		this.first_meeting = first_meeting;
		this.fitness_not_adult = fitness_not_adult;
		this.employment_place = employment_place;
		this.vtnumber = vtnumber;
		this.vtdate = vtdate;
		this.nname = nname;
		this.nadd = nadd;
		this.ecname = ecname;
		this.ecrelationship = ecrelationship;
		this.ecadd = ecadd;
		this.ecmob = ecmob;
		this.sig_mines_manager = sig_mines_manager;
		this.leave = leave;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getGurdianname() {
		return gurdianname;
	}

	public void setGurdianname(String gurdianname) {
		this.gurdianname = gurdianname;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}



	public Long getMob() {
		return mob;
	}

	public void setMob(Long mob) {
		this.mob = mob;
	}

	public String getUan() {
		return uan;
	}

	public void setUan(String uan) {
		this.uan = uan;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public Integer getEsicip() {
		return esicip;
	}

	public void setEsicip(Integer esicip) {
		this.esicip = esicip;
	}

	public String getLwf() {
		return lwf;
	}

	public void setLwf(String lwf) {
		this.lwf = lwf;
	}

	public Long getAddhar() {
		return addhar;
	}

	public void setAddhar(Long addhar) {
		this.addhar = addhar;
	}

	public Long getBankaccount() {
		return bankaccount;
	}

	public void setBankaccount(Long bankaccount) {
		this.bankaccount = bankaccount;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public String getPreadd() {
		return preadd;
	}

	public void setPreadd(String preadd) {
		this.preadd = preadd;
	}

	public String getPermadd() {
		return permadd;
	}

	public void setPermadd(String permadd) {
		this.permadd = permadd;
	}

	public Long getMvtcert() {
		return mvtcert;
	}

	public void setMvtcert(Long mvtcert) {
		this.mvtcert = mvtcert;
	}

	public Date getDoe() {
		return doe;
	}

	public void setDoe(Date doe) {
		this.doe = doe;
	}

	public String getRoe() {
		return roe;
	}

	public void setRoe(String roe) {
		this.roe = roe;
	}

	public String getMoi() {
		return moi;
	}

	public void setMoi(String moi) {
		this.moi = moi;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEdu() {
		return edu;
	}

	public void setEdu(String edu) {
		this.edu = edu;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getType_emp() {
		return type_emp;
	}

	public void setType_emp(String type_emp) {
		this.type_emp = type_emp;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public byte[] getImagedata() {
		return imagedata;
	}

	public void setImagedata(byte[] imagedata) {
		this.imagedata = imagedata;
	}

	public Date getFitness_not_adult() {
		return fitness_not_adult;
	}

	public void setFitness_not_adult(Date fitness_not_adult) {
		this.fitness_not_adult = fitness_not_adult;
	}

	public Date getFirst_meeting() {
		return first_meeting;
	}

	public void setFirst_meeting(Date first_meeting) {
		this.first_meeting = first_meeting;
	}

	public String getEmployment_place() {
		return employment_place;
	}

	public void setEmployment_place(String employment_place) {
		this.employment_place = employment_place;
	}

	public Integer getVtnumber() {
		return vtnumber;
	}

	public void setVtnumber(Integer vtnumber) {
		this.vtnumber = vtnumber;
	}

	public Date getVtdate() {
		return vtdate;
	}

	public void setVtdate(Date vtdate) {
		this.vtdate = vtdate;
	}

	public String getNname() {
		return nname;
	}

	public void setNname(String nname) {
		this.nname = nname;
	}

	public String getNadd() {
		return nadd;
	}

	public void setNadd(String nadd) {
		this.nadd = nadd;
	}

	public String getEcname() {
		return ecname;
	}

	public void setEcname(String ecname) {
		this.ecname = ecname;
	}

	public String getEcrelationship() {
		return ecrelationship;
	}

	public void setEcrelationship(String ecrelationship) {
		this.ecrelationship = ecrelationship;
	}

	public String getEcadd() {
		return ecadd;
	}

	public void setEcadd(String ecadd) {
		this.ecadd = ecadd;
	}

	public Long getEcmob() {
		return ecmob;
	}

	public void setEcmob(Long ecmob) {
		this.ecmob = ecmob;
	}

	public String getSig_mines_manager() {
		return sig_mines_manager;
	}

	public void setSig_mines_manager(String sig_mines_manager) {
		this.sig_mines_manager = sig_mines_manager;
	}

	public Integer getSl_no() {
		return sl_no;
	}

	public void setSl_no(Integer sl_no) {
		this.sl_no = sl_no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	

	public Integer getLeave() {
		return leave;
	}

	public void setLeave(Integer leave) {
		this.leave = leave;
	}

	@Override
	public String toString() {
		return "EmployeeCentral [sl_no=" + sl_no + ", id=" + id + ", name=" + name + ", lastname=" + lastname
				+ ", gender=" + gender + ", gurdianname=" + gurdianname + ", dob=" + dob + ", nation=" + nation
				+ ", edu=" + edu + ", doj=" + doj + ", post=" + post + ", skill=" + skill + ", type_emp=" + type_emp
				+ ", mob=" + mob + ", uan=" + uan + ", pan=" + pan + ", esicip=" + esicip + ", lwf=" + lwf + ", addhar="
				+ addhar + ", bankaccount=" + bankaccount + ", bank=" + bank + ", ifsc=" + ifsc + ", preadd=" + preadd
				+ ", permadd=" + permadd + ", mvtcert=" + mvtcert + ", doe=" + doe + ", roe=" + roe + ", moi=" + moi
				+ ", imagedata=" + Arrays.toString(imagedata) + ", signature=" + signature + ", remarks=" + remarks
				+ ", first_meeting=" + first_meeting + ", fitness_not_adult=" + fitness_not_adult
				+ ", employment_place=" + employment_place + ", vtnumber=" + vtnumber + ", vtdate=" + vtdate
				+ ", nname=" + nname + ", nadd=" + nadd + ", ecname=" + ecname + ", ecrelationship=" + ecrelationship
				+ ", ecadd=" + ecadd + ", ecmob=" + ecmob + ", sig_mines_manager=" + sig_mines_manager + "]";
	}

	

	

	
	
     
     
}
