drop database if exists travelagency;
create database if not exists travelagency;
use travelagency;


create table if not exists branch(
    br_code int(11) not null auto_increment ,
	br_num int(4) not null,
    br_street varchar(30) default 'unknown' not null,
    br_city varchar(30) default 'unknown' not null,
	primary key(br_code)
);


create table if not exists phones(
    ph_br_code int(11) not null,
    ph_number char(10) default 'unknown' not null,
    primary key (ph_br_code,ph_number),
    constraint branchPhone foreign key (ph_br_code) references branch(br_code)
	ON DELETE CASCADE ON UPDATE CASCADE
);

create table if not exists destination(
    dst_id int(11) auto_increment,
    dst_name varchar(50) default 'unknown' not null,
    dst_descr text not null,
    dst_rtype enum('LOCAL','ABROAD'),
    dst_language varchar(30) default 'unknown' not null,
    dst_location int(11),
	primary key(dst_id),
	constraint locationId foreign key (dst_location) references destination(dst_id)
	ON DELETE CASCADE ON UPDATE CASCADE
);

create table if not exists worker(
    wrk_AT char(10) default 'unknown' not null,
    wrk_name varchar(20) default 'unknown' not null,
    wrk_lame varchar(20) default 'unknown' not null,
    wrk_salary float(7,2) not null,
    wrk_br_code int(11) not null ,
	PRIMARY KEY (wrk_AT, wrk_br_code), #Ένας εργαζόμενος εργάζεται σε ένα μόνο υποκατάστημα
	constraint workerBranch foreign key (wrk_br_code) references branch(br_code)
	ON DELETE CASCADE ON UPDATE CASCADE
);


create table if not exists guide(
    gui_AT char(10) not null,
    gui_cv text not null,
	PRIMARY KEY (gui_AT),
    constraint workerGuide foreign key (gui_AT) references worker(wrk_AT)
	ON DELETE CASCADE ON UPDATE CASCADE
);

create table if not exists languages(
    lng_gui_AT char(10) not null,
    lng_language varchar(30) default 'unknown' not null,
    primary key (lng_gui_AT,lng_language),
    constraint guideLanguage foreign key (lng_gui_AT) references guide(gui_AT)
	ON DELETE CASCADE ON UPDATE CASCADE
);

create table if not exists driver(
    drv_AT char(10) not null,
    drv_license enum('A','B','C','D') not null,
    drv_route enum('LOCAL', 'ABROAD') not null,
    drv_experience tinyint(4) not null,
	PRIMARY KEY(drv_AT),
    constraint driverWorkData foreign key (drv_AT) references worker(wrk_AT)
	ON DELETE CASCADE ON UPDATE CASCADE
);

create table if not exists admin(
    adm_AT char(10) not null,
    adm_type enum('LOGISTICS','ADMINISTRATIVE','ACCOUNTING') not null,
    adm_diploma varchar(200) DEFAULT 'unkown' not null,
	PRIMARY KEY(adm_AT),
	constraint workerAdminAt foreign key (adm_AT) references worker(wrk_AT)
	ON DELETE CASCADE ON UPDATE CASCADE
);


create table if not exists manages(
    mng_adm_AT char(10) default 'unkown' not null,
    mng_br_code int(11) not null ,
    primary key (mng_adm_AT, mng_br_code),
	constraint manageBranch foreign key (mng_br_code) references branch(br_code)
	ON DELETE CASCADE ON UPDATE CASCADE,
	constraint managerAdministration foreign key (mng_adm_AT) references admin(adm_AT)
	ON DELETE CASCADE ON UPDATE CASCADE
);

create table if not exists trip(
    tr_id int(10) not null auto_increment,
    tr_departure datetime not null,
    tr_return datetime not null,
    tr_maxseats tinyint(4) not null,
    tr_cost float(7,2) not null,
    tr_br_code int(11) not null,
    tr_gui_AT char(10) not null,
    tr_drv_AT char(10) not null,
	PRIMARY KEY(tr_id),
	constraint tripBranchCode foreign key (tr_br_code) references branch(br_code)
	ON DELETE CASCADE ON UPDATE CASCADE,
	constraint tripGuideAt foreign key (tr_gui_AT) references guide(gui_AT)
	ON DELETE CASCADE ON UPDATE CASCADE,
	constraint tripDriverAt foreign key (tr_drv_AT) references driver(drv_AT)
	ON DELETE CASCADE ON UPDATE CASCADE
);

create table if not exists event(
    ev_tr_id int(11) not null,      #removed auto increment
    ev_start datetime not null,
    ev_end datetime not null,
    ev_descr text not null,
    primary key (ev_tr_id, ev_start),
    constraint tripEventId foreign key (ev_tr_id) references trip(tr_id)
	ON DELETE CASCADE ON UPDATE CASCADE
);

create table if not exists reservation(
    res_tr_id int(11) not null auto_increment,
    res_seatnum tinyint(4) not null,
    res_name varchar(20) default 'unknown' not null,
    res_lname varchar(20) default 'unknown' not null,
    res_isadult enum('ADULT','MINOR') not null,
    primary key (res_tr_id, res_seatnum),
    constraint tripReservationId foreign key (res_tr_id) references trip(tr_id)
	ON DELETE CASCADE ON UPDATE CASCADE
);

create table if not exists travelTo(
    to_tr_id int(11) not null auto_increment,
    to_dst_id int(11) not null,
    to_arrival datetime not null,
    to_departure datetime not null,
    primary key (to_tr_id, to_dst_id),
	constraint travelIdTrip foreign key (to_tr_id) references trip(tr_id)
	ON DELETE CASCADE ON UPDATE CASCADE,
	constraint destinationIdTrip foreign key (to_dst_id) references destination(dst_id)
	ON DELETE CASCADE ON UPDATE CASCADE
);

create table if not exists offers(
    offer_id int(11) not null auto_increment,
    offer_startDate date not null,
    offer_endDate date not null,
    cost_per_person float(7,2) not null,
    offer_dst_id int(11) not null,
    primary key (offer_id),
    constraint offerDestination foreign key (offer_dst_id) references destination(dst_id)
    on delete cascade on update cascade
);

create table if not exists reservation_offers(
    res_offer_id int(11) not null auto_increment,
    res_name varchar(20) not null,
    res_lname varchar(20) not null,
    offer_id_trip int(11) not null,
    res_deposit float(7,2) not null,
    primary key (res_offer_id),
    constraint offerId foreign key (offer_id_trip) references offers(offer_id)
    on delete cascade on update cascade
);

create table if not exists itOfficer(
    it_AT char(10) not null,
    password char(10) default 'password' not null,
    start_date date not null,
    end_date date,
    primary key (IT_AT),
    constraint itworker foreign key (IT_AT) references worker(wrk_AT)
    on delete cascade on update cascade
);

create table if not exists log(
    logid int not null auto_increment,
    logdescrc text not null,
    log_ID_AT char(10) not null,
    log_date datetime not null,
    primary key(logid),
    constraint logitat foreign key (log_ID_AT) references itOfficer(IT_AT)
    on delete cascade on update cascade
);

drop table if exists templogin;
create table templogin(
    tempID char(10) primary key
);

INSERT INTO branch VALUES
(1, 1, 'Main Street', 'New York'),
(2, 2, 'Maple Avenue', 'Chicago'),
(3, 3, '1st Street', 'Los Angeles'),
(4, 4, '2nd Avenue', 'Houston'),
(5, 5, '3rd Boulevard', 'Philadelphia'),
(6, 1, '4th Street', 'Phoenix'),
(7, 2, '5th Avenue', 'San Antonio'),
(8, 3, '6th Boulevard', 'San Diego'),
(9, 4, '7th Street', 'Dallas'),
(10, 5, '8th Avenue', 'San Jose');


INSERT INTO phones VALUES
(1, '0201111111'),
(2, '0202222222'),
(3, '0203333333'),
(4, '0204444444'),
(5, '0205555555'),
(6, '0206666666'),
(7, '0207777777'),
(8, '0208888888'),
(9, '0209999999'),
(10, '0200000000'),
(1, '0201234567'),
(2, '0202345678'),
(3, '0203456789'),
(4, '0204567890'),
(5, '0205678901'),
(6, '0206789012'),
(7, '0207890123'),
(8, '0208901234'),
(9, '0209012345'),
(10, '0200123456'),
(1, '0205432109'),
(2, '0204321098'),
(3, '0203210987'),
(4, '0202109876'),
(5, '0201098765'),
(6, '0200987654'),
(7, '0209876543'),
(8, '0208765432'),
(9, '0207654321'),
(10, '0206543210');

INSERT INTO destination VALUES
(1, 'New York', 'The city that never sleeps', 'LOCAL', 'English', NULL),
(2, 'Chicago', 'The Windy City', 'LOCAL', 'English', NULL),
(3, 'Los Angeles', 'The City of Angels', 'LOCAL', 'English', NULL),
(4, 'Houston', 'Space City', 'LOCAL', 'English', NULL),
(5, 'Philadelphia', 'The City of Brotherly Love', 'LOCAL', 'English', NULL),
(6, 'Phoenix', 'The Valley of the Sun', 'LOCAL', 'English', NULL),
(7, 'San Antonio', 'The Alamo City', 'LOCAL', 'English', NULL),
(8, 'San Diego', 'America''s Finest City', 'LOCAL', 'English', NULL),
(9, 'Dallas', 'Big D', 'LOCAL', 'English', NULL),
(10, 'San Jose', 'The Capital of Silicon Valley', 'LOCAL', 'English', NULL),
(11, 'Athens', 'The Capital of Greece', 'LOCAL', 'Greek', 7),
(12, 'Thessaloniki', 'The Second City of Greece', 'LOCAL', 'Greek', 7),
(13, 'Rome', 'The Eternal City', 'ABROAD', 'Italian', 1),
(14, 'Paris', 'The City of Love', 'ABROAD', 'French', 2),
(15, 'London', 'The Capital of the UK', 'ABROAD', 'English', 3),
(16, 'Madrid', 'The Capital of Spain', 'ABROAD', 'Spanish', 4),
(17, 'Berlin', 'The Capital of Germany', 'ABROAD', 'German', 5),
(18, 'Tokyo', 'The Capital of Japan', 'ABROAD', 'Japanese', 6),
(19, 'Barcelona', 'The Capital of Catalonia', 'ABROAD', 'Spanish', NULL),
(20, 'Amsterdam', 'The Capital of the Netherlands', 'ABROAD', 'Dutch', NULL),
(21, 'Sydney', 'The Capital of Australia', 'ABROAD', 'English', NULL),
(22, 'Beijing', 'The Capital of China', 'ABROAD', 'Chinese', NULL),
(23, 'Moscow', 'The Capital of Russia', 'ABROAD', 'Russian', NULL),
(24, 'Dubai', 'The City of Gold', 'ABROAD', 'Arabic', NULL),
(25, 'Rio de Janeiro', 'The Marvelous City', 'ABROAD', 'Portuguese', NULL),
(26, 'Cape Town', 'The Mother City', 'ABROAD', 'English', NULL),
(27, 'Johannesburg', 'The City of Gold', 'ABROAD', 'Afrikaans', NULL),
(28, 'São Paulo', 'The Capital of São Paulo', 'ABROAD', 'Portuguese', NULL),
(29, 'Lisbon', 'The Capital of Portugal', 'ABROAD', 'Portuguese', NULL),
(30, 'Bangkok', 'The Capital of Thailand', 'ABROAD', 'Thai', NULL);


INSERT INTO worker VALUES
('AT000001', 'John', 'Doe', 45000.00, 1),
('AT000002', 'Jane', 'Doe', 50000.00, 2),
('AT000003', 'Bob', 'Smith', 40000.00, 3),
('AT000004', 'Sue', 'Smith', 55000.00, 4),
('AT000005', 'Alice', 'Jones', 52000.00, 5),
('AT000006', 'Mike', 'Jones', 48000.00, 6),
('AT000007', 'Sarah', 'Williams', 45000.00, 7),
('AT000008', 'Chris', 'Williams', 52000.00, 8),
('AT000009', 'Dave', 'Johnson', 50000.00, 9),
('AT000010', 'Emily', 'Johnson', 45000.00, 10),
('AT000011', 'Laura', 'Brown', 52000.00, 1),
('AT000012', 'Tom', 'Brown', 48000.00, 2),
('AT000013', 'Kim', 'Davis', 45000.00, 3),
('AT000014', 'Steve', 'Davis', 52000.00, 4),
('AT000015', 'Julie', 'Moore', 50000.00, 5),
('AT000016', 'Jason', 'Moore', 45000.00, 6),
('AT000017', 'Samantha', 'Miller', 52000.00, 7),
('AT000018', 'Mark', 'Miller', 48000.00, 8),
('AT000019', 'Alex', 'Wilson', 45000.00, 9),
('AT000020', 'Megan', 'Wilson', 52000.00, 10),
('AT000021', 'Tina', 'Taylor', 50000.00, 1),
('AT000022', 'Ryan', 'Taylor', 45000.00, 2),
('AT000023', 'Rachel', 'Anderson', 52000.00, 3),
('AT000024', 'Adam', 'Anderson', 48000.00, 4),
('AT000025', 'Katie', 'Thomas', 45000.00, 5),
('AT000026', 'Scott', 'Thomas', 52000.00, 6),
('AT000027', 'Amy', 'Jackson', 50000.00, 7),
('AT000028', 'Brian', 'Jackson', 45000.00, 8),
('AT000029', 'Lisa', 'White', 52000.00, 9),
('AT000030', 'Matt', 'White', 48000.00, 10),
('AT000031', 'George', 'Baknis', 12000.00, 1),
('AT000032', 'Thanasis', 'Bakalis', 12000.00, 1),
('AT000033', 'Haris', 'Stamelos', 12000.00, 1),
('AT000034', 'Maria', 'Papadopoulou', 46000.00, 1),
('AT000035', 'Nikos', 'Georgiou', 48000.00, 2),
('AT000036', 'Giannis', 'Papadopoulos', 50000.00, 3),
('AT000037', 'Eleni', 'Katsarou', 45000.00, 4),
('AT000038', 'Dimitris', 'Nikolopoulos', 52000.00, 5),
('AT000039', 'Christina', 'Papadaki', 55000.00, 6),
('AT000040', 'Panos', 'Kostopoulos', 42000.00, 7),
('AT000041', 'Andreas', 'Ioannou', 48000.00, 8),
('AT000042', 'Sofia', 'Christou', 45000.00, 9),
('AT000043', 'Katerina', 'Papageorgiou', 52000.00, 10),
('AT000044', 'Marios', 'Antoniou', 48000.00, 1),
('AT000045', 'Stavros', 'Papadopoulos', 45000.00, 2),
('AT000046', 'Kostas', 'Vasilopoulos', 52000.00, 3),
('AT000047', 'Eva', 'Karakosta', 50000.00, 4),
('AT000048', 'Maria', 'Karagianni', 45000.00, 5),
('AT000049', 'Dimitris', 'Christopoulos', 52000.00, 6),
('AT000050', 'Eleni', 'Kontou', 48000.00, 7),
('AT000051', 'Sofia', 'Papaioannou', 45000.00, 8),
('AT000052', 'Katerina', 'Papadimitriou', 52000.00, 9),
('AT000053', 'Panos', 'Stefanopoulos', 50000.00, 10),
('AT000054', 'Stavros', 'Nikolaidis', 45000.00, 1),
('AT000055', 'Kostas', 'Christodoulou', 52000.00, 2),
('AT000056', 'Eva', 'Vlachou', 48000.00, 3),
('AT000057', 'Maria', 'Papandreou', 45000.00, 4),
('AT000058', 'Dimitris', 'Andreadis', 52000.00, 5),
('AT000059', 'Eleni', 'Mavridou', 48000.00, 6),
('AT000060', 'Sofia', 'Papadopoulou', 45000.00, 7);


INSERT INTO guide VALUES
('AT000001', 'I have been working as a tour guide for 10 years and have extensive knowledge of local history and landmarks.'),
('AT000002', 'I have a degree in art history and have been leading museum and gallery tours for the past 5 years.'),
('AT000003', 'I am fluent in Spanish, French, and English and have been leading international tours for the past 7 years.'),
('AT000004', 'I have a background in geology and have been leading hiking and outdoor adventure tours for the past 3 years.'),
('AT000005', 'I have been leading food and wine tours in the local area for the past 8 years and have a deep understanding of regional cuisine and culinary traditions.'),
('AT000006', 'I have a degree in theatre and have been leading backstage and behind-the-scenes tours at local performance venues for the past 5 years.'),
('AT000007', 'I am an experienced wildlife photographer and have been leading photography tours in local nature reserves for the past 7 years.'),
('AT000008', 'I have a background in engineering and have been leading technology and innovation tours for the past 3 years.'),
('AT000009', 'I am an expert in local architecture and have been leading walking tours of historical neighborhoods for the past 8 years.'),
('AT000010', 'I have a degree in music and have been leading music and entertainment tours for the past 5 years.');

INSERT INTO languages VALUES
('AT000001', 'Spanish'),
('AT000001', 'French'),
('AT000002', 'Greek'),
('AT000003', 'Italian'),
('AT000003', 'French'),
('AT000004', 'Spanish'),
('AT000005', 'German'),
('AT000006', 'French'),
('AT000007', 'Portuguese'),
('AT000008', 'Italian'),
('AT000009', 'Greek'),
('AT000010', 'French');

INSERT INTO driver VALUES
('AT000011', 'B', 'LOCAL', 5),
('AT000012', 'C', 'LOCAL', 10),
('AT000013', 'D', 'LOCAL', 15),
('AT000014', 'A', 'ABROAD', 5),
('AT000015', 'B', 'ABROAD', 10),
('AT000016', 'C', 'ABROAD', 15),
('AT000017', 'D', 'ABROAD', 5),
('AT000018', 'A', 'LOCAL', 10),
('AT000019', 'B', 'LOCAL', 15),
('AT000020', 'C', 'ABROAD', 5);

INSERT INTO admin VALUES
('AT000021', 'ADMINISTRATIVE', 'Bachelor''s degree in Business Administration'),
('AT000022', 'ADMINISTRATIVE', 'Bachelor''s degree in Finance'),
('AT000023', 'ADMINISTRATIVE', 'Bachelor''s degree in Public Administration'),
('AT000024', 'ADMINISTRATIVE', 'Bachelor''s degree in Supply Chain Management'),
('AT000025', 'ADMINISTRATIVE', 'Bachelor''s degree in Accounting'),
('AT000026', 'ADMINISTRATIVE', 'Bachelor''s degree in Organizational Management'),
('AT000027', 'ADMINISTRATIVE', 'Bachelor''s degree in Logistics and Transportation'),
('AT000028', 'ADMINISTRATIVE', 'Bachelor''s degree in Financial Management'),
('AT000029', 'ADMINISTRATIVE', 'Bachelor''s degree in Business Administration'),
('AT000030', 'ADMINISTRATIVE', 'Bachelor''s degree in Industrial Management'),
('AT000031', 'ACCOUNTING', 'Bachelor''s degree in Health Services Administration'),
('AT000032', 'ACCOUNTING', 'Bachelor''s degree in Criminal Justice Administration'),
('AT000033', 'ACCOUNTING', 'Bachelor''s degree in Education Administration'),
('AT000034', 'ACCOUNTING', 'Bachelor''s degree in Hospitality Administration'),
('AT000035', 'ACCOUNTING', 'Bachelor''s degree in Environmental Policy and Management'),
('AT000036', 'ACCOUNTING', 'Bachelor''s degree in International Business'),
('AT000037', 'ACCOUNTING', 'Bachelor''s degree in Public Policy'),
('AT000038', 'ACCOUNTING', 'Bachelor''s degree in Project Management'),
('AT000039', 'ACCOUNTING', 'Bachelor''s degree in Social Work Administration'),
('AT000040', 'ACCOUNTING', 'Bachelor''s degree in Nonprofit Administration'),
('AT000041', 'LOGISTICS', 'Bachelor''s degree in Communication Studies'),
('AT000042', 'LOGISTICS', 'Bachelor''s degree in Information Technology Management'),
('AT000043', 'LOGISTICS', 'Bachelor''s degree in Marketing Administration'),
('AT000044', 'LOGISTICS', 'Bachelor''s degree in Retail Management'),
('AT000045', 'LOGISTICS', 'Bachelor''s degree in Sports Administration'),
('AT000046', 'LOGISTICS', 'Bachelor''s degree in Public Safety Administration'),
('AT000047', 'LOGISTICS', 'Bachelor''s degree in Emergency Management'),
('AT000048', 'LOGISTICS', 'Bachelor''s degree in Emergency Management'),
('AT000049', 'LOGISTICS', 'Bachelor''s degree in Emergency Management'),
('AT000050', 'LOGISTICS', 'Bachelor''s degree in Emergency Management');



INSERT INTO manages VALUES
('AT000021', 1),
('AT000022', 2),
('AT000023', 3),
('AT000024', 4),
('AT000025', 5),
('AT000026', 6),
('AT000027', 7),
('AT000028', 8),
('AT000029', 9),
('AT000030', 10),
('AT000031', 1),
('AT000032', 2),
('AT000033', 3),
('AT000034', 4),
('AT000035', 5),
('AT000036', 6),
('AT000037', 7),
('AT000038', 8),
('AT000039', 9),
('AT000040', 10),
('AT000041', 1),
('AT000042', 2),
('AT000043', 3),
('AT000044', 4),
('AT000045', 5),
('AT000046', 6),
('AT000047', 7),
('AT000048', 8),
('AT000049', 9),
('AT000050', 10);

INSERT INTO trip VALUES
(1, '2022-01-01', '2022-01-07', 30, 1000.00, 1, 'AT000001', 'AT000011'),
(2, '2022-01-08', '2022-01-14', 35, 1200.00, 2, 'AT000002', 'AT000012'),
(3, '2022-01-15', '2022-01-21', 40, 1500.00, 3, 'AT000003', 'AT000013'),
(4, '2022-01-22', '2022-01-28', 45, 1700.00, 4, 'AT000004', 'AT000014'),
(5, '2022-01-29', '2022-02-04', 50, 2000.00, 5, 'AT000005', 'AT000015'),
(6, '2022-02-05', '2022-02-11', 55, 2200.00, 6, 'AT000006', 'AT000016'),
(7, '2022-02-12', '2022-02-18', 60, 2500.00, 7, 'AT000007', 'AT000017'),
(8, '2022-02-19', '2022-02-25', 65, 2700.00, 8, 'AT000008', 'AT000018'),
(9, '2022-02-26', '2022-03-04', 70, 3000.00, 9, 'AT000009', 'AT000019'),
(10, '2022-03-05', '2022-03-11', 75, 3200.00, 10, 'AT000010', 'AT000020'),
(11, '2022-03-12', '2022-03-18', 80, 3500.00, 1, 'AT000001', 'AT000011'),
(12, '2022-03-19', '2022-03-25', 85, 3700.00, 2, 'AT000002', 'AT000012'),
(13, '2022-03-26', '2022-04-01', 90, 4000.00, 3, 'AT000003', 'AT000013'),
(14, '2022-04-02', '2022-04-08', 95, 4200.00, 4, 'AT000004', 'AT000014'),
(15, '2022-04-09', '2022-04-15', 100, 4500.00, 5, 'AT000005', 'AT000015'),
(16, '2022-04-16', '2022-04-22', 105, 4700.00, 6, 'AT000006', 'AT000016'),
(17, '2022-04-23', '2022-04-29', 110, 5000.00, 7, 'AT000007', 'AT000017'),
(18, '2022-04-30', '2022-05-06', 115, 5200.00, 8, 'AT000008', 'AT000018'),
(19, '2022-05-07', '2022-05-13', 20, 1200.00, 9, 'AT000009', 'AT000019'),
(20, '2022-05-14', '2022-05-20', 25, 1100.00, 10, 'AT000010', 'AT000020'),
(21, '2022-05-21', '2022-05-27', 30, 1000.00, 1, 'AT000001', 'AT000011'),
(22, '2022-05-28', '2022-06-03', 35, 900.00, 2, 'AT000002', 'AT000012'),
(23, '2022-06-04', '2022-06-10', 40, 800.00, 3, 'AT000003', 'AT000013'),
(24, '2022-06-11', '2022-06-17', 45, 700.00, 4, 'AT000004', 'AT000014'),
(25, '2022-06-18', '2022-06-24', 50, 600.00, 5, 'AT000005', 'AT000015'),
(26, '2022-06-25', '2022-07-01', 55, 500.00, 6, 'AT000006', 'AT000016'),
(27, '2022-07-02', '2022-07-08', 60, 400.00, 7, 'AT000007', 'AT000017'),
(28, '2022-07-09', '2022-07-15', 65, 300.00, 8, 'AT000008', 'AT000018'),
(29, '2022-07-16', '2022-07-22', 70, 200.00, 9, 'AT000009', 'AT000019'),
(30, '2022-07-23', '2022-07-29', 75, 100.00, 10, 'AT000010', 'AT000020');


INSERT INTO event VALUES
(1, '2022-01-01', '2022-01-07', 'Event 1'),
(1, '2022-01-02', '2022-01-06', 'Event 1.1'),
(2, '2022-01-08', '2022-01-14', 'Event 2'),
(2, '2022-01-10', '2022-01-11', 'Event 2.2'),
(3, '2022-01-15', '2022-01-21', 'Event 3'),
(4, '2022-01-22', '2022-01-28', 'Event 4'),
(5, '2022-01-29', '2022-02-04', 'Event 5'),
(6, '2022-02-05', '2022-02-11', 'Event 6'),
(7, '2022-02-12', '2022-02-18', 'Event 7'),
(8, '2022-02-19', '2022-02-25', 'Event 8'),
(9, '2022-02-26', '2022-03-04', 'Event 9'),
(10, '2022-03-05', '2022-03-11', 'Event 10'),
(11, '2022-03-12', '2022-03-18', 'Event 11'),
(12, '2022-03-19', '2022-03-25', 'Event 12'),
(13, '2022-03-26', '2022-04-01', 'Event 13'),
(14, '2022-04-02', '2022-04-08', 'Event 14'),
(15, '2022-04-09', '2022-04-15', 'Event 15'),
(16, '2022-04-16', '2022-04-22', 'Event 16'),
(17, '2022-04-23', '2022-04-29', 'Event 17'),
(18, '2022-04-30', '2022-05-06', 'Event 18'),
(19, '2022-05-07', '2022-05-13', 'Event 19'),
(20, '2022-05-14', '2022-05-20', 'Event 20'),
(21, '2022-05-21', '2022-05-27', 'Event 21'),
(22, '2022-05-28', '2022-06-03', 'Event 22'),
(23, '2022-06-04', '2022-06-10', 'Event 23'),
(24, '2022-06-11', '2022-06-17', 'Event 24'),
(25, '2022-06-18', '2022-06-24', 'Event 25'),
(26, '2022-06-25', '2022-07-01', 'Event 26'),
(27, '2022-07-02', '2022-07-08', 'Event 27'),
(28, '2022-07-09', '2022-07-15', 'Event 28'),
(29, '2022-07-16', '2022-07-22', 'Event 29'),
(30, '2022-07-23', '2022-07-29', 'Event 30');


INSERT INTO reservation VALUES
(1, 1, 'John', 'Doe', 'ADULT'),
(1, 2, 'Jane', 'Doe', 'ADULT'),
(1, 3, 'Tom', 'Smith', 'MINOR'),
(2, 1, 'Alice', 'Johnson', 'ADULT'),
(2, 2, 'Bob', 'Johnson', 'MINOR'),
(3, 1, 'Emily', 'Williams', 'ADULT'),
(3, 2, 'William', 'Williams', 'ADULT'),
(4, 1, 'Samantha', 'Jones', 'ADULT'),
(4, 2, 'Jason', 'Jones', 'MINOR'),
(5, 1, 'Emma', 'Brown', 'ADULT'),
(5, 2, 'David', 'Brown', 'MINOR'),
(6, 1, 'Olivia', 'Davis', 'ADULT'),
(6, 2, 'James', 'Davis', 'MINOR'),
(7, 1, 'Ava', 'Miller', 'ADULT'),
(7, 2, 'Benjamin', 'Miller', 'MINOR'),
(8, 1, 'Isabella', 'Moore', 'ADULT'),
(8, 2, 'Michael', 'Moore', 'MINOR'),
(9, 1, 'Mia', 'Taylor', 'ADULT'),
(9, 2, 'Matthew', 'Taylor', 'MINOR'),
(10, 1, 'Abigail', 'Anderson', 'ADULT'),
(10, 2, 'Christopher', 'Anderson', 'MINOR'),
(11, 10, 'Emily', 'Thomas', 'ADULT'),
(1, 11, 'John', 'Doe', 'ADULT'),
(1, 21, 'Jane', 'Doe', 'ADULT'),
(1, 31, 'Bill', 'Smith', 'ADULT'),
(1, 41, 'Susan', 'Smith', 'ADULT'),
(1, 51, 'Paul', 'Johnson', 'MINOR'),
(2, 11, 'Emily', 'Johnson', 'MINOR'),
(2, 21, 'Michael', 'Williams', 'ADULT'),
(2, 31, 'Samantha', 'Williams', 'ADULT'),
(2, 41, 'Roger', 'Brown', 'ADULT');

INSERT INTO travelTo VALUES
(1, 1, '2022-01-07', '2022-01-01'),
(2, 2, '2022-01-14', '2022-01-08'),
(3, 3, '2022-01-21', '2022-01-15'),
(4, 4, '2022-01-28', '2022-01-22'),
(5, 5, '2022-02-04', '2022-01-29'),
(6, 6, '2022-02-11', '2022-02-05'),
(7, 7, '2022-02-18', '2022-02-12'),
(8, 8, '2022-02-25', '2022-02-19'),
(9, 9, '2022-03-04', '2022-02-26'),
(10, 10, '2022-03-11', '2022-03-05'),
(11, 11, '2022-03-18', '2022-03-12'),
(12, 12, '2022-03-25', '2022-03-19'),
(13, 13, '2022-04-01', '2022-03-26'),
(14, 14, '2022-04-08', '2022-04-02'),
(15, 15, '2022-04-15', '2022-04-09'),
(16, 16, '2022-04-22', '2022-04-16'),
(17, 17, '2022-04-29', '2022-04-23'),
(18, 18, '2022-05-06', '2022-04-30'),
(19, 19, '2022-05-13', '2022-05-07'),
(20, 20, '2022-05-20', '2022-05-14'),
(21, 21, '2022-05-27', '2022-05-21'),
(22, 22, '2022-06-03', '2022-05-28'),
(23, 23, '2022-06-10', '2022-06-04'),
(24, 24, '2022-06-17', '2022-06-11'),
(25, 25, '2022-06-24', '2022-06-18'),
(26, 26, '2022-07-01', '2022-06-25'),
(27, 27, '2022-07-08', '2022-07-02'),
(28, 28, '2022-07-15', '2022-07-09'),
(29, 29, '2022-07-22', '2022-07-16'),
(30, 30, '2022-07-29', '2022-07-23');

insert into itOfficer values('AT000051', '1234', NOW(), NULL);
insert into itOfficer values('AT000052', '1234', NOW(), NULL);
insert into itOfficer values('AT000053', '1234', NOW(), NULL);

insert into offers values
(null, '2023-01-01', '2024-01-01', 250, 1),
(null, '2023-01-10', '2024-02-01', 300, 2),
(null, '2023-05-01', '2024-05-25', 400, 3);


#Procedures

#FIRST PROCEDURE
drop procedure if exists newDriverAssignment;
DELIMITER $

CREATE PROCEDURE newDriverAssignment(drvAT char(10), drvName varchar(20), drvLname varchar(30),
 drvSalary float(7,2), drvLicense enum('A', 'B', 'C', 'D'), drvRoute enum('LOCAL', 'ABROAD'), drvExperience tinyint(4))
BEGIN
    declare BRANCH_CODE int;

    select br_code into BRANCH_CODE
    from branch
    inner join worker on branch.br_code = worker.wrk_br_code
    inner join driver on worker.wrk_AT = driver.drv_AT
    group by br_code
    order by count(drv_AT) asc limit 1;

    insert into worker values(drvAT, drvName, drvLname, drvSalary, BRANCH_CODE);
    insert into driver values(drvAT, drvLicense, drvRoute, drvExperience);

END$

delimiter ;

#SECOND PROCEDURE
drop procedure if exists showAvailableTrips;
delimiter $

create procedure showAvailableTrips(brCode int(11), startDate date, endDate date)
begin
    declare not_found int;
    declare tripId int(11);
    declare tripCost float(7,2);
    declare maxSeats tinyint(4);
    declare reservCount tinyint(4);
    declare emptySeats tinyint(4);
    declare drivLname varchar(20);
    declare drivName varchar(20);
    declare GuideLname varchar(20);
    declare GuideName varchar(20);
    declare guideAT char(10);
    declare driverAt char(10);
    declare departureDate datetime;
    declare returnDate datetime;

    declare tcursor cursor for
    select tr_id, tr_departure, tr_return, tr_maxseats, tr_cost, tr_gui_AT, tr_drv_AT
    from trip
    where tr_br_code = brCode and tr_departure >= startDate and tr_departure <= endDate;

    declare continue handler for not found set not_found=1;

    set not_found=0;
    open tcursor;

    repeat
        fetch tcursor into tripId, departureDate, returnDate, maxSeats, tripCost, guideAT, driverAt;
        if(not_found=0) then
            select count(res_tr_id) into reservCount from reservation where res_tr_id = tripId;
            set emptySeats = maxSeats - reservCount;
            select wrk_lame, wrk_name into GuideLname, GuideName from worker where wrk_AT = guideAT;
            select wrk_lame, wrk_name into drivLname, drivName from worker where wrk_AT = driverAt;

            select tripCost, maxSeats, reservCount, emptySeats, drivLname,
                drivName, GuideLname, GuideName, departureDate, returnDate;
        end if;
    until (not_found=1)
    end repeat;

    close tcursor;
end $

DELIMITER ;

#THIRD PROCEDURE
drop procedure if exists delete_admin;
DELIMITER $

CREATE PROCEDURE delete_admin(IN first_name VARCHAR(20), IN last_name VARCHAR(20))
BEGIN
    -- check if employee is a manager and his/her admin type.
    SELECT COUNT(*) INTO @is_manager
    FROM manages
    INNER JOIN worker ON manages.mng_adm_AT = worker.wrk_AT
    WHERE worker.wrk_name = first_name AND worker.wrk_lame = last_name;

     -- If the employee is a branch manager
    IF @is_manager > 0 THEN
        SELECT wrk_AT INTO @AT
        from worker
        INNER JOIN manages on manages.mng_adm_AT = wrk_AT
        WHERE worker.wrk_name = first_name AND worker.wrk_lame = last_name;

        -- And if he/she is of type ADMINISTRATIVE
        SELECT count(*) INTO @is_administrative
        from admin
        where admin.adm_AT = @AT AND admin.adm_type = 'ADMINISTRATIVE';

        -- Cannot be deleted
        IF @is_administrative > 0 THEN
            signal sqlstate value '45000'
            set message_text = 'Cannot delete administrator of a branch';
        -- Else delete
        ELSE
            DELETE admin FROM admin
            INNER JOIN worker ON admin.adm_AT = worker.wrk_AT
            WHERE worker.wrk_name = first_name AND worker.wrk_lame = last_name;
            select concat(first_name, ' ', last_name, ' ', 'with AT: ', @AT, 'deleted successfully');
            #select 'not null';
        END IF;

    -- Employee is not a manager
    ELSE
        select concat(first_name, ' ', last_name, ' ', 'with AT: ', @AT, 'is not a manager.');
    END IF;
END$

delimiter ;

#PROCEDURES 4.1 4.2
#drop index idx on reservation_offers;
CREATE INDEX idx ON reservation_offers (res_deposit, res_lname);

drop procedure if exists deposit_range_names;
delimiter $

create procedure deposit_range_names(IN minDeposit INT , IN maxDeposit INT)
BEGIN
    select res_name,res_lname from reservation_offers where res_deposit>=minDeposit and res_deposit <=maxDeposit;
end $
delimiter ;

drop procedure if exists data_last_name;
delimiter $

create procedure data_last_name(IN lastName VARCHAR(20))
BEGIN
    select res_name, res_lname,offers.*  from offers inner join reservation_offers on offers.offer_id = reservation_offers.offer_id_trip
    where reservation_offers.res_lname = lastName;

    if found_rows()>1 then
        select offers.*,count(res_lname) from offers
        inner join reservation_offers on offers.offer_id = reservation_offers.offer_id_trip
        where reservation_offers.res_lname = lastName
        group by offer_id;
    end if;
end $
delimiter ;

#procedure to get id for triggers
drop procedure if exists getItID;
delimiter $
create procedure getItID(in insertedItId char(10), in insertedItPass char(10), out itID char(10))
begin
    declare verificationValue char(10);

    select it_AT into verificationValue from itOfficer where it_AT = insertedItId and password = insertedItPass;
    if (verificationValue is not null) then
        select insertedItId into itID;
        insert into templogin values(insertedItId);
    end if;
end $

#TRIGGRES

#first set of triggers
drop trigger if exists tripInsertion;
delimiter $
create trigger tripInsertion after insert on trip
for each row
begin
    declare testvalue char(10);
    select tempID into testvalue from templogin;
    if(testvalue is not null) then
        insert into log
        set logdescrc = 'Inserted a trip',log_ID_AT=testvalue,log_date=now();
    else
        signal sqlstate value '45000'
        set message_text = 'Error!You have to login as It Officer.';
    end if;
end $
delimiter ;


drop trigger if exists tripUpdating;
delimiter $
create trigger tripUpdating after update on trip
for each row
begin
    declare testvalue char(10);
    select tempID into testvalue from templogin;
    if(testvalue is not null) then
        insert into log
        set logdescrc = 'Updated a trip.',log_ID_AT=testvalue,log_date=now();
    else
        signal sqlstate value '45000'
        set message_text = 'Error!You have to login as It Officer.';
    end if;

end $
delimiter ;

drop trigger if exists tripDeletion;
delimiter $
create trigger tripDeletion after delete on trip
for each row
begin

    declare testvalue char(10);
    select tempID into testvalue from templogin;
    if(testvalue is not null) then
        insert into log
        set logdescrc = 'Deleted a trip.',log_ID_AT=testvalue,log_date=now();
    else
        signal sqlstate value '45000'
        set message_text = 'Error!You have to login as It Officer.';
    end if;

end $
delimiter ;


drop trigger if exists reservationInsertion;
delimiter $
create trigger reservationInsertion after insert on reservation
for each row
begin
    declare testvalue char(10);
    select tempID into testvalue from templogin;
    if(testvalue is not null) then
        insert into log
        set logdescrc = 'Inserted a reservation.',log_ID_AT=testvalue,log_date=now();
    else
        signal sqlstate value '45000'
        set message_text = 'Error!You have to login as It Officer.';
    end if;
end $
delimiter ;

drop trigger if exists reservationUpdating;
delimiter $
create trigger reservationUpdating after update on reservation
for each row
begin
    declare testvalue char(10);
    select tempID into testvalue from templogin;
    if(testvalue is not null) then
        insert into log
        set logdescrc = 'Updated a reservation.',log_ID_AT=testvalue,log_date=now();
    else
        signal sqlstate value '45000'
        set message_text = 'Error!You have to login as It Officer.';
    end if;

end $
delimiter ;

drop trigger if exists reservationDeletion;
delimiter $
create trigger reservationDeletion after delete on reservation
for each row
begin
    declare testvalue char(10);
    select tempID into testvalue from templogin;
    if(testvalue is not null) then
        insert into log
        set logdescrc = 'Deleted a reservation.',log_ID_AT=testvalue,log_date=now();
    else
        signal sqlstate value '45000'
        set message_text = 'Error!You have to login as It Officer.';
    end if;

end $
delimiter ;

drop trigger if exists eventInsertion;
delimiter $
create trigger eventInsertion after insert on event
for each row
begin
    declare testvalue char(10);
    select tempID into testvalue from templogin;
    if(testvalue is not null) then
        insert into log
        set logdescrc = 'Inserted an event.',log_ID_AT=testvalue,log_date=now();
    else
        signal sqlstate value '45000'
        set message_text = 'Error!You have to login as It Officer.';
    end if;
end $
delimiter ;

drop trigger if exists eventUpdating;
delimiter $
create trigger eventUpdating after update on event
for each row
begin
    declare testvalue char(10);
    select tempID into testvalue from templogin;
    if(testvalue is not null) then
        insert into log
        set logdescrc = 'Updated an event.',log_ID_AT=testvalue,log_date=now();
    else
        signal sqlstate value '45000'
        set message_text = 'Error!You have to login as It Officer.';
    end if;

end $
delimiter ;

drop trigger if exists eventDeletion;
delimiter $
create trigger eventDeletion after delete on event
for each row
begin
    declare testvalue char(10);
    select tempID into testvalue from templogin;
    if(testvalue is not null) then
        insert into log
        set logdescrc = 'Deleted an event.',log_ID_AT=testvalue,log_date=now();
    else
        signal sqlstate value '45000'
        set message_text = 'Error!You have to login as It Officer.';
    end if;

end $
delimiter ;

drop trigger if exists traveltoInsertion;
delimiter $
create trigger traveltoInsertion after insert on travelTo
for each row
begin
    declare testvalue char(10);
    select tempID into testvalue from templogin;
    if(testvalue is not null) then
        insert into log
        set logdescrc = 'Inserted a travelto.',log_ID_AT=testvalue,log_date=now();
    else
        signal sqlstate value '45000'
        set message_text = 'Error!You have to login as It Officer.';
    end if;
end $
delimiter ;

drop trigger if exists traveltoUpdating;
delimiter $
create trigger traveltoUpdating after update on travelTo
for each row
begin
    declare testvalue char(10);
    select tempID into testvalue from templogin;
    if(testvalue is not null) then
        insert into log
        set logdescrc = 'Updated a travelto.',log_ID_AT=testvalue,log_date=now();
    else
        signal sqlstate value '45000'
        set message_text = 'Error!You have to login as It Officer.';
    end if;

end $
delimiter ;

drop trigger if exists traveltoDeletion;
delimiter $
create trigger traveltoDeletion after delete on travelTo
for each row
begin
    declare testvalue char(10);
    select tempID into testvalue from templogin;
    if(testvalue is not null) then
        insert into log
        set logdescrc = 'Deleted a travelto.',log_ID_AT=testvalue,log_date=now();
    else
        signal sqlstate value '45000'
        set message_text = 'Error!You have to login as It Officer.';
    end if;

end $
delimiter ;

drop trigger if exists destinationInsertion;
delimiter $
create trigger destinationInsertion after insert on destination
for each row
begin
    declare testvalue char(10);
    select tempID into testvalue from templogin;
    if(testvalue is not null) then
        insert into log
        set logdescrc = 'Inserted a destination.',log_ID_AT=testvalue,log_date=now();
    else
        signal sqlstate value '45000'
        set message_text = 'Error!You have to login as It Officer.';
    end if;
end $
delimiter ;

drop trigger if exists destinationUpdating;
delimiter $
create trigger destinationUpdating after update on destination
for each row
begin
    declare testvalue char(10);
    select tempID into testvalue from templogin;
    if(testvalue is not null) then
        insert into log
        set logdescrc = 'Updated a destination.',log_ID_AT=testvalue,log_date=now();
    else
        signal sqlstate value '45000'
        set message_text = 'Error!You have to login as It Officer.';
    end if;

end $
delimiter ;

drop trigger if exists destinationDeletion;
delimiter $
create trigger destinationDeletion after delete on destination
for each row
begin
    declare testvalue char(10);
    select tempID into testvalue from templogin;
    if(testvalue is not null) then
        insert into log
        set logdescrc = 'Deleted a destination.',log_ID_AT=testvalue,log_date=now();
    else
        signal sqlstate value '45000'
        set message_text = 'Error!You have to login as It Officer.';
    end if;

end $
delimiter ;

#second trigger
drop trigger if exists changeDateAndCost;

delimiter $

create trigger changeDateAndCost before update on trip
for each row
begin
    declare tempSeatsValue int;

    select count(*) into tempSeatsValue
    from trip
    inner join reservation r on trip.tr_id = r.res_tr_id
    where tr_id=new.tr_id
    group by res_tr_id;

    if(tempSeatsValue>0) then
        if(new.tr_cost <> old.tr_cost) then
            signal sqlstate value '45000'
            set message_text = 'You can not change the cost for this trip';
        end if;
        if(new.tr_departure <> old.tr_departure) then
            signal sqlstate value '45000'
            set message_text = 'You can not change the departure date for this trip';
        end if;
        if(new.tr_return <> old.tr_return) then
            signal sqlstate value '45000'
            set message_text = 'You can not change the return date for this trip';

        end if;
    end if;
end $
delimiter ;

#third trigger
drop trigger if exists changeWorkerSalary;

delimiter $

create trigger changeWorkerSalary before update on worker
for each row
begin
    if(new.wrk_salary<old.wrk_salary) then
        signal sqlstate value '45000'
        set message_text = 'Τhere can be no reduction in the workers salary';
    end if;
end $
DELIMITER ;


drop procedure if exists showBranchDetails;

delimiter $
CREATE PROCEDURE showBranchDetails(brCode INT)
BEGIN
    declare not_found int;
    declare temp_tr_id int;
    declare temp_cost float(7, 2);
    declare total_cost float(7, 2);


    -- total income from the reservations
    declare trip_cost_cursor cursor for
    select tr_cost, tr_id
    from trip
    where tr_br_code = brCode;

    declare continue handler for not found set not_found=1;

    set not_found=0;
    set total_cost=0.0;
    open trip_cost_cursor;

    repeat
        fetch trip_cost_cursor INTO temp_cost, temp_tr_id;
        if(not_found=0) then
            select count(res_tr_id) * temp_cost
            from reservation
            where res_tr_id = temp_tr_id INTO temp_cost;

            set total_cost = total_cost + temp_cost;
        end if ;
        until (not_found=1)
    end repeat ;
    close trip_cost_cursor;

    -- total number of reservations
    select COUNT(ALL res_tr_id) INTO @numOfRes
    from reservation
    inner join trip t on reservation.res_tr_id = t.tr_id
    where tr_br_code = brCode;

    SELECT 'Branch Details' AS 'Result Type', br_code AS 'Code', br_num AS 'Number', br_street AS 'Street', br_city AS
        'City', wrk_name AS 'admin (FN)', wrk_lame AS 'Last name (LN)', @numOfRes AS 'Num of reservations', total_cost AS
        'Income'
        FROM branch
        inner join worker w on branch.br_code = w.wrk_br_code
        inner join admin a on w.wrk_AT = a.adm_AT
        WHERE brCode = br_code and adm_type = 'ADMINISTRATIVE';
END$

delimiter ;


drop procedure if exists branchInfo;

delimiter $
CREATE PROCEDURE branchInfo (brCode INT)
BEGIN
    SELECT wrk_name AS 'First Name', wrk_lame AS 'Last Name', wrk_salary AS 'Salary'
    FROM worker
    WHERE wrk_br_code = brCode;

    SELECT 'Total Salaries' AS 'Result Type', SUM(wrk_salary)
    FROM worker
    WHERE wrk_br_code = brCode;
END$

delimiter ;


drop procedure if exists addIT;
delimiter $
CREATE PROCEDURE addIT(in wrkAT char(10), in wrkName varchar(20), in wrkLname varchar(20), in wrkSalary float(7, 2),in
    wrkBrCode int, in password char(10), in startD datetime, in endD datetime)
BEGIN
    -- First insert a worker
    insert into worker values(wrkAT, wrkName, wrkLname, wrkSalary, wrkBrCode);

    -- After insert on itofficer table
    insert into itOfficer values (wrkAT, password, startD, endD);

END $
delimiter ;

drop procedure if exists showLog;

delimiter $
CREATE PROCEDURE showLog()
BEGIN
    DECLARE not_found INT;
    DECLARE logD TEXT;
    DECLARE logID CHAR(10);
    DECLARE itLname VARCHAR(20);
    DECLARE logDate DATETIME;

    DECLARE logcursor CURSOR FOR
    SELECT logdescrc, log_ID_AT, log_date
    FROM log;

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET not_found = 1;

    SET not_found = 0;
    OPEN logcursor;

    -- Create a temporary table to store the data
    CREATE TEMPORARY TABLE temp_log_result (
        log_desc TEXT,
        it_lastname VARCHAR(20),
        log_date DATETIME
    );

    FETCH_LOOP: LOOP
        FETCH logcursor INTO logD, logID, logDate;
        IF not_found = 1 THEN
            LEAVE FETCH_LOOP;
        END IF;

        SELECT wrk_lame INTO itLname
        FROM worker
        INNER JOIN itOfficer ON worker.wrk_AT = itOfficer.it_AT
        WHERE wrk_AT = logID;

        INSERT INTO temp_log_result (log_desc, it_lastname, log_date)
        VALUES (logD, itLname, logDate);
    END LOOP FETCH_LOOP;

    CLOSE logcursor;

    -- Fetch the complete result set from the temporary table
    SELECT log_desc, it_lastname, log_date FROM temp_log_result;

    -- Drop the temporary table
    DROP TEMPORARY TABLE temp_log_result;
END;

delimiter ;


-- Extra functionalities
drop procedure if exists branch_stats;

delimiter $
CREATE PROCEDURE branch_stats(brCode INT)
BEGIN
    declare not_found int;
    declare temp_tr_id int;
    declare temp_cost float(7, 2);
    declare total_cost float(7, 2);
    declare total_salaries float(13, 2);

    -- total income from the reservations
    declare trip_cost_cursor cursor for
    select tr_cost, tr_id
    from trip
    where tr_br_code = brCode;

    declare continue handler for not found set not_found=1;

    set not_found=0;
    set total_cost=0.0;
    open trip_cost_cursor;

    repeat
        fetch trip_cost_cursor INTO temp_cost, temp_tr_id;
        if(not_found=0) then
            select count(res_tr_id) * temp_cost
            from reservation
            where res_tr_id = temp_tr_id INTO temp_cost;

            set total_cost = total_cost + temp_cost;
        end if ;
        until (not_found=1)
    end repeat ;
    close trip_cost_cursor;

    -- expenses = salaries
    SELECT SUM(wrk_salary)
    FROM worker
    WHERE wrk_br_code = brCode INTO total_salaries;


    select total_cost AS 'Income', total_salaries AS 'expenses', total_cost - total_salaries AS 'Turnover';

END $


drop procedure if exists driver_card;

delimiter $
CREATE PROCEDURE driver_card(id char(10))
BEGIN
   -- id
    select wrk_name AS "First Name", wrk_lame AS "Last Name", wrk_AT AS "AT", wrk_br_code AS 'Branch Code', wrk_salary AS
        "Salary", drv_license AS "License", drv_route AS "Route", drv_experience AS "Experience"
    from worker
    inner join driver on drv_AT = worker.wrk_AT
    where wrk_AT = id;

   -- assigned trips
    select tr_id AS "Trip Id", tr_departure AS "departure", tr_return AS "Return"
    from trip
    where tr_drv_AT = id;

END $


drop procedure if exists guide_card;

delimiter $
CREATE PROCEDURE guide_card(id char(10))
BEGIN
   -- id
    select wrk_name AS "First Name", wrk_lame AS "Last Name", wrk_AT AS "AT", wrk_br_code AS 'Branch Code', wrk_salary AS
        "Salary"
    from worker
    inner join guide on guide.gui_AT = worker.wrk_AT
    where wrk_AT = id;

    -- languages
    select lng_language
    from languages
    where lng_gui_AT = id;

    -- assigned trips
    select tr_id AS "Trip Id", tr_departure AS "departure", tr_return AS "Return"
    from trip
    where tr_gui_AT = id;

   -- guide cv
    select gui_cv AS "CV"
    from guide
    where gui_AT = id;

END $

drop procedure if exists admin_card;
delimiter $
CREATE PROCEDURE admin_card(id char(10))
BEGIN
   -- id
    select wrk_name AS "First Name", wrk_lame AS "Last Name", wrk_AT AS "AT", wrk_br_code AS 'Branch Code', wrk_salary AS
        "Salary", adm_type AS "Type", adm_diploma AS 'Diploma'
    from worker
    inner join admin on adm_AT = wrk_AT
    where wrk_AT = id;


END $

