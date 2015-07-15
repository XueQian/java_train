use gym;
create table user (id int not null primary key auto_increment,name varchar(20) not null,password varchar(50) not null);
create table employee(id int not null primary key auto_increment,user_id int not null,constraint foreign key(user_id) references user(id) on delete cascade, role varchar(10));
create table customer(id int not null primary key auto_increment,coach_id int not null,constraint foreign key(coach_id) references employee(id) on delete cascade,name varchar(30));
create table course(id int not null primary key auto_increment,coach_id int not null,constraint foreign key(coach_id) references employee(id) on delete cascade,name varchar(30));
create table time(id int not null primary key auto_increment,course_id int not null,constraint foreign key(course_id) references course(id) on delete cascade,time varchar(10));