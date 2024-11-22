CREATE TABLE Manager (
  Manager_id INT PRIMARY KEY identity(1,1),
  m_email VARCHAR(255),
  m_pass VARCHAR(255),
  m_previlage VARCHAR(20),
  m_expereince VARCHAR(255),
  m_sal INT ,
  constraint c1 check ( m_sal<100000 and  m_sal>25000),
);
CREATE TABLE RECEPTIONIST (
  R_id INT PRIMARY KEY identity(1,1),
  R_email VARCHAR(255),
  R_pass VARCHAR(255),
  R_previlage VARCHAR(20) default 'RECEPTIONIST',
  R_age int ,
  R_sal INT,
  R_rate DECIMAL(10, 2),
  m_id INT,
  FOREIGN KEY (m_id)REFERENCES Manager(Manager_id),
  constraint c2 check (R_sal<10000 and R_sal>3000),
  constraint c3 check (R_age<35 and R_age > 20)
);
CREATE TABLE Customer (
  customer_id INT PRIMARY KEY identity(1,1),
  c_name VARCHAR(255),
  c_address VARCHAR(20) default 'Cairo',
   R_id INT,
   m_id INT,
FOREIGN KEY (m_id)REFERENCES Manager(Manager_id),
   FOREIGN KEY (R_id) REFERENCES RECEPTIONIST(R_id)
);
 CREATE TABLE Doctor (
  Doctor_id INT PRIMARY KEY identity(1,1),
  d_name VARCHAR(255),
  d_phone_number VARCHAR(20),
  d_sal int,
  d_previlage VARCHAR(20) default 'doctor',
   m_id INT,
   R_id INT,  
  FOREIGN KEY (R_id)REFERENCES RECEPTIONIST(R_id),
   FOREIGN KEY (m_id)REFERENCES Manager(Manager_id),
);
CREATE TABLE doctor_diagnose_customer (
 c_id INT ,
 number_visiting int default  0 ,
 d_id INT,
 PRIMARY KEY (c_id, d_id),
 FOREIGN KEY (c_id) REFERENCES customer(customer_id),
 FOREIGN KEY (d_id) REFERENCES Doctor(Doctor_id)
);
CREATE TABLE Room (
  room_number INT PRIMARY KEY identity(1,1),
  ro_capacity INT,
  ro_check_in_date DATE default getdate() ,
  ro_days int default 2,
  ro_check_out_date as (getdate() + ro_days),
  ro_price_per_night DECIMAL(10, 2),
  ro_is_occupied bit ,
  hotel_id INT default 1,
  d_id int, 
  R_id INT,
  FOREIGN KEY (R_id)REFERENCES RECEPTIONIST(R_id),
  FOREIGN KEY (d_id) REFERENCES Doctor(Doctor_id)
);
CREATE TABLE has_room (
 c_id INT ,
 number_visiting int default  0 ,
 ro_id INT,
 PRIMARY KEY (c_id, ro_id),
  FOREIGN KEY (c_id) REFERENCES customer(customer_id),
 FOREIGN KEY (ro_id) REFERENCES Room(room_number)
);
CREATE TABLE chef (
  chef_id INT PRIMARY KEY identity(1,1),
  ch_name VARCHAR(255),
  ch_phone_number VARCHAR(20),
  ch_previlage VARCHAR(20) default 'chef',
  ch_sal int ,
   m_id INT,  
   FOREIGN KEY (m_id)REFERENCES Manager(Manager_id),

);
CREATE TABLE Food (
  food_id INT PRIMARY KEY identity(1,1),
  food_name VARCHAR(255),
  f_type VARCHAR(255),
  total_price DECIMAL(10, 2),
  R_id INT,
  ro_id INT,
  FOREIGN KEY (ro_id) REFERENCES Room(room_number),
  FOREIGN KEY (R_id)REFERENCES RECEPTIONIST(R_id),
  );
  CREATE TABLE storage_of_Food (
  s_food_id INT PRIMARY KEY identity(1,1),
  food_name VARCHAR(255),
  f_type VARCHAR(255),
  f_amount DECIMAL(10, 2),
  R_id INT,
  m_id INT,  
   FOREIGN KEY (m_id)REFERENCES Manager(Manager_id),
  FOREIGN KEY (R_id)REFERENCES RECEPTIONIST(R_id),
  );
  CREATE TABLE Housekeeper (
  housekeeper_id INT PRIMARY KEY identity(1,1),
  h_name VARCHAR(255),
  h_phone_number VARCHAR(20),
  H_previlage VARCHAR(20) default 'Housekeeper',
   m_id INT,
   R_id INT,  
   ro_id INT,
  FOREIGN KEY (R_id)REFERENCES RECEPTIONIST(R_id),
  FOREIGN KEY (m_id)REFERENCES Manager(Manager_id),
);
CREATE TABLE room_care (
 housekeeper_id INT  ,
  ro_id INT ,
  rate int ,
  PRIMARY KEY (housekeeper_id, ro_id),
   FOREIGN KEY (ro_id) REFERENCES Room(room_number),
   FOREIGN KEY (housekeeper_id) REFERENCES Housekeeper(housekeeper_id)
);
/*CREATE TABLE hotel_emergency (
  h_emergency_id INT PRIMARY KEY identity(1,1),
  h_emergency_name VARCHAR(255),
   h_emergency_job VARCHAR(50),
   m_id INT,
   R_id INT,  
   ro_id INT,
  FOREIGN KEY (R_id)REFERENCES RECEPTIONIST(R_id),
   FOREIGN KEY (m_id)REFERENCES Manager(Manager_id),
);*/