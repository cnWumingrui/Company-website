--通告
insert into pronunciament(title,content,join_date) values('通告一','dsfygduhjnm',now());
insert into pronunciament(title,content,join_date) values('通告一','dsfygduhjnm',now());
insert into pronunciament(title,content,join_date) values('通告一','dsfygduhjnm',now());
insert into pronunciament(title,content,join_date) values('通告一','dsfygduhjnm',now());
insert into pronunciament(title,content,join_date) values('通告一','dsfygduhjnm',now());
insert into pronunciament(title,content,join_date) values('通告一','dsfygduhjnm',now());
insert into pronunciament(title,content,join_date) values('通告一','dsfygduhjnm',now());
insert into pronunciament(title,content,join_date) values('通告一','dsfygduhjnm',now());
insert into pronunciament(title,content,join_date) values('通告一','dsfygduhjnm',now());
insert into pronunciament(title,content,join_date) values('通告一','dsfygduhjnm',now());
insert into pronunciament(title,content,join_date) values('通告一','dsfygduhjnm',now());

insert into pronunciament(title,content,join_date) values("通告12","这是一个新通告",now());
insert into pronunciament(title,content,join_date) values("关羽2018年度分区销售策略之产品价格体系的说明","dsfygduhjnm",now());

select * from pronunciament;

--新闻类别
insert into news_class(typename) values('业界动态');
insert into news_class(typename) values('国内新闻');

--新闻 
insert into news(title,typeid,content,picture,laiz,join_date,change_date,imgurl,picnum,imgtext,imglink,imgAlt)
values('好新闻','1','good','','内部',now(),now(),'','','','','');
insert into news(title,typeid,content,picture,laiz,join_date,change_date,imgurl,picnum,imgtext,imglink,imgAlt)
values('新闻','2','safasfascasdwqfsacdgvdscassfdxcsfdxvasdcfrd','','内部',now(),now(),'','','','','');

--友情链接
insert into friendlink(web_name,web_address) values('baidu','http://www.baidu.com');
insert into friendlink(web_name,web_address) values('sina','http://www.sina.com');
insert into friendlink(web_name,web_address) values('taobao','http://www.taobao.com');
insert into friendlink(web_name,web_address) values('sohu','http://www.sohu.com');

--网站信息
select * from webconfig
delete from webconfig where id='2'
insert into webconfig(web_name,join_date,url,logo,email,banner,banquan)
values('企业官网',now(),'www.hyycinfo.com','images/logo.gif','1223764062@qq.com','images/top_image.jpg','wmr');
update webconfig set banner='';

--公司信息类别
insert into infotype(typename) values('企业简介');
insert into infotype(typename) values('企业文化');
insert into infotype(typename) values('组织机构');
insert into infotype(typename) values('成长历程');
insert into infotype(typename) values('联系我们');

--公司信息
insert into companyinfo(typeid,title,content,picture,change_date) values(1,'公司简介','本公司','',now());


--11.产品类别
insert into Product_class(protype) values ('桌子');	 
insert into Product_class(protype) values ('柜子');	 
insert into Product_class(protype) values ('椅子');	 

--服务与支持
insert into server(title,content,pic,join_date,picnum,picname)
values ('黑科技','这家伙这的贼好1','',now(),'','');
insert into server(title,content,pic,join_date,picnum,picname)
values ('白科技','这家伙这的贼好2','',now(),'','');
insert into server(title,content,pic,join_date,picnum,picname)
values ('高科技','这家伙这的贼好3','',now(),'','');
insert into server(title,content,pic,join_date,picnum,picname)
values ('雷射炮','这家伙这的贼好4','',now(),'','');

--招贤纳士
insert into job(inviter,number,address	,wage,expressdate,demand,join_date,)
values('高级工程师',3,'长沙','5k-10k',now(),'三年以上经验',now());


