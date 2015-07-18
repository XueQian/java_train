create table employee(id int not null primary key auto_increment,user_name varchar(30),role varchar(10));
create table user (id int not null primary key auto_increment,name varchar(20) not null,password varchar(50) not null,employee_id int not null);
create table course(id int not null primary key auto_increment,name varchar(30),time varchar(10),employee_id int not null,constraint foreign key(employee_id) references employee(id) on delete cascade);
create table customer(id int not null primary key auto_increment,name varchar(30),employee_id int not null,constraint foreign key(employee_id) references employee(id) on delete cascade);
create table customer_course(id int not null primary key auto_increment,customer_id int not null,constraint foreign key(customer_id) references customer(id) on delete cascade,course_id int not null,constraint foreign key(course_id) references course(id) on delete cascade);
