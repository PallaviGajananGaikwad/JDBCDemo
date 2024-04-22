#For create table
CREATE TABLE `student`.`student` (
  `idstudent` INT NOT NULL,
  `Roll_No` VARCHAR(45) NULL,
  `Student_name` VARCHAR(50) NOT NULL,
  `Student_Marks` INT NOT NULL,
  PRIMARY KEY (`idstudent`),
  UNIQUE INDEX `Roll_No_UNIQUE` (`Roll_No` ASC));

Insert data into table
insert into student (idstudent, Roll_No, student_name, Student_Marks)
values(1,"101","Pallavi",82);
insert into student (idstudent, Roll_No, student_name, Student_Marks)
values(2,"102","Gargi",99);
insert into student (idstudent, Roll_No, student_name, Student_Marks)
values(3,"103","Amrut",85);
insert into student (idstudent, Roll_No, student_name, Student_Marks)
values(4,"104","Shivam",77);
insert into student (idstudent, Roll_No, student_name, Student_Marks)
values(5,"105","Amitta",89);

for Preparedstatement


#for Stored PROCEDURE
for Retrive data use for CallableStatement
"select Student_city from stud Where Student_name= ?";
"Insert into stud(Student_id,Student_name,Student_age,Student_city) Values(?,?,?,?)";
"update stud SET Student_name=? Where Student_id=?";
"Delete from stud where Student_id=?";


DELIMITER //
CREATE PROCEDURE getStudentCity(IN studentName VARCHAR(255), OUT studentCity VARCHAR(255))
BEGIN
    SELECT Student_city INTO studentCity FROM stud WHERE Student_name = studentName;
END //
DELIMITER ;


For UPDATE Data for CallableStatement
DELIMITER //
CREATE PROCEDURE updateStudentCity(IN studentName VARCHAR(255), IN newCity VARCHAR(255))
BEGIN
    UPDATE stud SET Student_city = newCity WHERE Student_name = studentName;
END //
DELIMITER ;


For delete_student Data for CallableStatement
CREATE PROCEDURE delete_student(IN student_name VARCHAR(255))
BEGIN
    DELETE FROM stud WHERE Student_name = student_name;

For Insert Data for CallableStatement

DELIMITER //
CREATE PROCEDURE insertStud(IN studentid integer(10),IN studentName VARCHAR(255), IN studentCity VARCHAR(255))
BEGIN
    INSERT INTO stud (Student_id,Student_name, Student_city) VALUES (Student_id,studentName, studentCity);
END //
DELIMITER ;


