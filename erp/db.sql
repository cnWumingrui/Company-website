create database db1;

--人才信息表：acjob
create table acjob(
	id int primary key auto_increment,
	jodid int ,
	username varchar(200),
	sex varchar(200),
	birthday date,
	ismarry varchar(200),
	school varchar(200),
	studydegree varchar(200),
	specialty varchar(200),
	gradyear date,
	telephone	varchar(2000),
	email	varchar(2000),
	address	varchar(2000),
	ability	varchar(2000),
	resumes	varchar(2000),
	join_date	date,
	position varchar(2000)
);

--2.管理员表：admin  对应序列   seq_admin_id
create table  admin(
	id	int primary key auto_increment,
	username	varchar(2000) not null,
	userpassword	varchar(2000) not null,
	join_time	date not null
);
delete from admin;
select * from admin;
insert into admin(username,userpassword,join_time) values('a','0cc175b9c0f1b6a831c399e269772661',now());
--3.公司信息类别表：infotype  对应序列   seq_infotype_id
create table infotype(
	id	int primary key auto_increment,
  typename	varchar(2000) not null
);
select * from  infotype;

--4.公司信息表：companyinfo   对应序列  seq_companyinfo_id
create table companyinfo(
	id	int primary key auto_increment,
	typeid	int not null,
	title	varchar(2000) not null,
	content	varchar(2000) not null,
	picture	varchar(2000),
	change_date	date
);

--5.友情链接：friendlink     对应序列  seq_friendlink_id
create table friendlink(
   id	int primary key auto_increment ,
   web_name	varchar(2000),
   web_address	varchar(2000)
);

--6.工作信息表：job        对应序列  seq_job_id
create table job(
	id	int primary key auto_increment,
	inviter	varchar(2000),
	number	int,
	address	varchar(2000) not null,
	wage	varchar(2000),
	expressdate	date,
	demand	varchar(1500),
	join_date	date not null
);

--7.留言表：leave_word     对应序列  seq_leave_word_id
create table leave_word(
	id	int primary key auto_increment,
	username	varchar(2000),
	firmname	varchar(2000),
	contactman	varchar(2000),
	ring	varchar(2000),
	fax	varchar(2000),
	email	varchar(2000),
	title	varchar(2000),
	content	varchar(2000),
	renew	varchar(2000),
	join_date	date
);


--8.新闻表：news
create table news(
	id	int primary key auto_increment,
	title	varchar(2000),
	typeid	varchar(2000),
	content	text,
	picture	varchar(2000),
	laiz	varchar(2000),
	join_date	datetime,
	change_date	datetime,
	imgurl	varchar(2000),
	picnum	varchar(2000),
	imgtext	varchar(2000),
  imglink	varchar(2000),
  imgAlt	varchar(2000)
);

--9新闻类别表：news_class
create table news_class(
	id	int primary key auto_increment,
	typename	varchar(2000)
);

select * from Product_class
--10.产品信息表：Product
create table Product(
	id	int primary key auto_increment,
	Product_class	varchar(2000),
	Product_name	varchar(2000),
	Product_in	varchar(2000) not null,
	Product_gain	varchar(2000),
	Product_spec	varchar(2000),
	Product_unit	varchar(2000),
	Product_remark	text,
	Product_explain	text,
	Product_picture	varchar(50),
	Product_auditing	int not null,
	index_show	int not null,
	join_date	date,
	change_date date
);
drop table Product;
select * from product;
select * from product,product_class where product.product_class=product_class.protype and product_class.id=1
			 order by change_date desc limit 0,10
							
insert into product(Product_picture,Product_class,Product_name,Product_in,Product_explain,Product_auditing,index_show,join_date,change_date) 
values(?,?,?,?,?,?,1,now(),now())
--11.产品类别表：Product_class
create table Product_class(
	id	int primary key auto_increment,
	protype	varchar(2000)
);
select * from Product_class
--12.网站公告表：pronunciament      对应序列    seq_ pronunciament_id
create table pronunciament(
	id	int primary key auto_increment,
	title	varchar(2000),
	content	varchar(2000),
	join_date	date
);
drop table pronunciament

--13.服务信息表：server      对应序列    seq_server_id
create table server(
	id	int primary key auto_increment,
	title	varchar(2000),
	content	varchar(1500),
	pic	varchar(2000),
	join_date	date,
	picnum	varchar(100),
	picname	varchar(2000)
);

--14.网站基本信息配置表：webconfig      对应序列    seq_webconfig_id
create table webconfig(
	id	int primary key auto_increment,
	web_name	varchar(2000),
	join_date	date,
	Url	varchar(2000),
	logo	varchar(2000),
	email	varchar(2000),
	banner	varchar(2000),
	banquan	varchar(2000)
);
