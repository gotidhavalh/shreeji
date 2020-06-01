
create table Designation(
	ID int not null primary key auto_increment,
    designation varchar(255) not null
);

CREATE TABLE Asset (
  AssetID int(11) NOT NULL AUTO_INCREMENT,
  AssetName varchar(200) DEFAULT NULL,
  HolderName varchar(200) DEFAULT NULL,
  SKU varchar(250) DEFAULT NULL,
  AssetDetail varchar(1000) DEFAULT NULL,
  AssetImage longblob,
  PRIMARY KEY (AssetID)
);

insert into Asset(AssetName, HolderName, SKU, AssetDetail) values ("Asset_One", "Holder_Person", "SKU_10101", " This is very important asset of company");



CREATE TABLE Employee (
  EmpCode int(11) NOT NULL primary key,
  FirstName varchar(200) DEFAULT NULL,
  LastName varchar(200) DEFAULT NULL,
  PhoneNum varchar(30) DEFAULT NULL,
  AlternatePhoneNum varchar(45) DEFAULT NULL,
  Email varchar(150) DEFAULT NULL,
  CompanyEmail varchar(150) DEFAULT NULL,
  Education varchar(100) DEFAULT NULL,
  PermanentAddress varchar(500) DEFAULT NULL,
  CurrentAddress varchar(500) DEFAULT NULL,
  ResidentProof longblob,
  EmpImage longblob,
  PAN varchar(244) DEFAULT NULL,
  Aadhar long DEFAULT NULL,
  DrivingLicense varchar(45) DEFAULT NULL,
  PANProof longblob,
  AadharProof longblob,
  DrivingLicenseProof longblob,
  JoiningDate date DEFAULT NULL,
  Designation varchar(100) DEFAULT NULL,
  CurrentSalary int(11) DEFAULT NULL,
  NextIncrementDate date DEFAULT NULL,
  Username varchar(150) DEFAULT NULL,
  Password varchar(1500) DEFAULT NULL,
  isActive tinyint(1) default 1,
  Gender	varchar(255)
  );

create table Leaves(
	ID int(10) not null auto_increment primary key,
    EmpCode int(11) not null,
    ToDate  date not null,
    FromDate date Not null,
    NoofDays float,
    Days varchar(255),
    Reason varchar(255),
    status varchar(255),
    currDate timestamp default CURRENT_TIMESTAMP,
    Approvername varchar(255),
    foreign key (EmpCode) references Employee(EmpCode)
);

create table Bank(
	ID int not null auto_increment primary key,
    EmpCode int(11) not null ,
    HolderName varchar(255),
    AccountNumber varchar(255),
    BankName varchar(255),
    IFSC varchar(255),
    AccountType varchar(255),
    paymentType varchar(255),
    foreign key (EmpCode) references Employee(EmpCode)
);



create table Holidays(
	ID int(10) not null auto_increment primary key,
    Days varchar(255),
    Holidate date not null,
    Holiname varchar(255)
 );
 
 create table Salary(
	ID int not null auto_increment primary key,
    EmpCode int(11),
    Name varchar(255),
    Designation varchar(255),
    SalaryType varchar(244),
    NoofworkingDays float,
    Month varchar(255),
    year int,
    NoofleaveDays float,
    Currentsalary float,
    SalaryDeduction float,
    Netsalary float,
    Status boolean default 0, 
    ChequeNo varchar(255),
    foreign key (EmpCode) references Employee(EmpCode)
);


create table Deduction(

	ID int not null auto_increment primary key,
    EmpCode int(11),
    PF float,
    TDS float,
    Leaves float,
    Asset float,
    Other float,
    Month varchar(255),
    year int,
    DeductDate timestamp default current_timestamp,
    foreign key (EmpCode) references Employee(EmpCode)
);


create table Allowence(
	
    ID int not null auto_increment primary key,
    EmpCode int(11),
    Fual float,
    OverTime float,
    month varchar(255),
    year int,
    AllowDate timestamp default current_timestamp
    foreign key (EmpCode) references Employee(EmpCode)
);