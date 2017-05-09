drop table T_EMPLOYEE if exists;

create table T_EMPLOYEE (ID bigint identity primary key, FNAME varchar(50),
                        LNAME varchar(50) not null, EMAILID varchar(100));
