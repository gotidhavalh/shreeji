package main.scs.dto;

import java.sql.Blob;
import java.sql.Date;

public class EmployeeDTO
{

	private int empCode;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String alternativePhoneNumber;
	private String Email;
	private String companyEmail;
	private String education;
	private String pAddress;
	private String cAddress;
	private Blob empImage;
	private Blob residentImage;
	private String panCard;
	private long adharCard;
	private String licence;
	private Blob panImage;
	private Blob adharImage;
	private Blob licenceImage;
	private Date joinDate;
	private int designation;
	private int currentSalary;
	private Date nextIncrement;
	private String username;
	private String password;
	private String gender;
	private String designationDesc;
	private byte[] empimage;
	private String base64Image;
	private String imageString;
	private byte[] imageData;

	private int ID;
	private String holderName;
	private String accountNumber;
	private String bankName;
	private String IFSC;
	private String accountType;
	private String paymentType;

	public byte[] getEmpimage()
	{
		return empimage;
	}

	public void setEmpimage(byte[] empimage)
	{
		this.empimage = empimage;
	}

	public String getBase64Image()
	{
		return base64Image;
	}

	public void setBase64Image(String base64Image)
	{
		this.base64Image = base64Image;
	}

	public String getImageString()
	{
		return imageString;
	}

	public void setImageString(String imageString)
	{
		this.imageString = imageString;
	}

	public byte[] getImageData()
	{
		return imageData;
	}

	public void setImageData(byte[] imageData)
	{
		this.imageData = imageData;
	}

	public int getCurrentSalary()
	{
		return currentSalary;
	}

	public void setCurrentSalary(int currentSalary)
	{
		this.currentSalary = currentSalary;
	}

	public int getEmpCode()
	{
		return empCode;
	}

	public void setEmpCode(int empCode)
	{
		this.empCode = empCode;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getPhoneNumber()
	{
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}

	public String getAlternativePhoneNumber()
	{
		return alternativePhoneNumber;
	}

	public void setAlternativePhoneNumber(String alternativePhoneNumber)
	{
		this.alternativePhoneNumber = alternativePhoneNumber;
	}

	public String getEmail()
	{
		return Email;
	}

	public void setEmail(String email)
	{
		Email = email;
	}

	public String getCompanyEmail()
	{
		return companyEmail;
	}

	public String getDesignationDesc()
	{
		return designationDesc;
	}

	public void setDesignationDesc(String designationDesc)
	{
		this.designationDesc = designationDesc;
	}

	public void setCompanyEmail(String companyEmail)
	{
		this.companyEmail = companyEmail;
	}

	public String getEducation()
	{
		return education;
	}

	public void setEducation(String education)
	{
		this.education = education;
	}

	public String getpAddress()
	{
		return pAddress;
	}

	public void setpAddress(String pAddress)
	{
		this.pAddress = pAddress;
	}

	public String getcAddress()
	{
		return cAddress;
	}

	public void setcAddress(String cAddress)
	{
		this.cAddress = cAddress;
	}

	public Blob getEmpImage()
	{
		return empImage;
	}

	public void setEmpImage(Blob empImage)
	{
		this.empImage = empImage;
	}

	public Blob getResidentImage()
	{
		return residentImage;
	}

	public void setResidentImage(Blob residentImage)
	{
		this.residentImage = residentImage;
	}

	public String getPanCard()
	{
		return panCard;
	}

	public void setPanCard(String panCard)
	{
		this.panCard = panCard;
	}

	public long getAdharCard()
	{
		return adharCard;
	}

	public void setAdharCard(long adharCard)
	{
		this.adharCard = adharCard;
	}

	public String getLicence()
	{
		return licence;
	}

	public void setLicence(String licence)
	{
		this.licence = licence;
	}

	public Blob getPanImage()
	{
		return panImage;
	}

	public void setPanImage(Blob panImage)
	{
		this.panImage = panImage;
	}

	public Blob getAdharImage()
	{
		return adharImage;
	}

	public void setAdharImage(Blob adharImage)
	{
		this.adharImage = adharImage;
	}

	public Blob getLicenceImage()
	{
		return licenceImage;
	}

	public void setLicenceImage(Blob licenceImage)
	{
		this.licenceImage = licenceImage;
	}

	public Date getJoinDate()
	{
		return joinDate;
	}

	public void setJoinDate(Date joinDate)
	{
		this.joinDate = joinDate;
	}

	public int getDesignation()
	{
		return designation;
	}

	public void setDesignation(int designation)
	{
		this.designation = designation;
	}

	public Date getNextIncrement()
	{
		return nextIncrement;
	}

	public void setNextIncrement(Date nextIncrement)
	{
		this.nextIncrement = nextIncrement;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getGender()
	{
		return gender;
	}

	public void setGender(String gender)
	{
		this.gender = gender;
	}

	public int getID()
	{
		return ID;
	}

	public void setID(int iD)
	{
		ID = iD;
	}

	public String getHolderName()
	{
		return holderName;
	}

	public void setHolderName(String holderName)
	{
		this.holderName = holderName;
	}

	public String getAccountNumber()
	{
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber)
	{
		this.accountNumber = accountNumber;
	}

	public String getBankName()
	{
		return bankName;
	}

	public void setBankName(String bankName)
	{
		this.bankName = bankName;
	}

	public String getIFSC()
	{
		return IFSC;
	}

	public void setIFSC(String iFSC)
	{
		IFSC = iFSC;
	}

	public String getAccountType()
	{
		return accountType;
	}

	public void setAccountType(String accountType)
	{
		this.accountType = accountType;
	}

	public String getPaymentType()
	{
		return paymentType;
	}

	public void setPaymentType(String paymentType)
	{
		this.paymentType = paymentType;
	}

}
