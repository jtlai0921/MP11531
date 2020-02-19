drop database if exists auction;

create database auction;

use auction;

#用戶表
create table auction_user(
  user_id int(11) auto_increment,
  username varchar(50) not null,
  userpass varchar(50) not null,
  email varchar(100) not null,
  primary key(user_id),
  unique(username)
);

INSERT INTO auction_user (username,userpass,email) VALUES ('tomcat','tomcat','spring_test@163.com');
INSERT INTO auction_user (username,userpass,email) VALUES ('mysql','mysql','spring_test@163.com');

#物品種類表
create table kind(
  kind_id int(11) auto_increment,
  kind_name varchar(50) not null, 
  kind_desc varchar(255) not null,
  primary key(kind_id)
);

INSERT INTO kind (kind_name,kind_desc) VALUES ('電腦硬體','這裡並不是很主流的產品，但價格絕對令你心動');
INSERT INTO kind (kind_name,kind_desc) VALUES ('房產','提供非常稀缺的房源');

#物品狀態表
create table state(
  state_id int(11) auto_increment,
  state_name varchar(10),
  primary key(state_id)
);

INSERT INTO state (state_name) VALUES ('拍賣中');
INSERT INTO state (state_name) VALUES ('拍賣成功');
INSERT INTO state (state_name) VALUES ('流拍');

#物品表
create table item(
  item_id int(11) auto_increment,
  item_name varchar(255) not null,
  item_remark varchar(255),
  item_desc varchar(255),
  kind_id int(11) not null, 
  addtime date not null,
  endtime date not null,
  init_price double not null, 
  max_price double not null, 
  owner_id int(11) not null, 
  winer_id int(11), 
  state_id int(11) not null, 
  primary key(item_id),
  FOREIGN KEY(kind_id) REFERENCES kind(kind_id), 
  FOREIGN KEY(owner_id) REFERENCES auction_user(user_id),
  FOREIGN KEY(winer_id) REFERENCES auction_user(user_id),
  FOREIGN KEY(state_id) REFERENCES state(state_id)
); 

# 拍賣中的物品
INSERT INTO item ( item_name , item_remark , item_desc, kind_id, addtime , endtime, init_price,  max_price,  owner_id,  winer_id,  state_id)
	VALUES ( '主機板', '老式主機板', '老主機板，還可以用', 1, ADDDATE(CURDATE(), -5), ADDDATE(CURDATE(), 30) , 230, 250, 1,  null,  1);
# 流派的物品
INSERT INTO item ( item_name , item_remark , item_desc, kind_id, addtime , endtime, init_price,  max_price,  owner_id,  winer_id,  state_id)
	VALUES ( '顯卡', '老式顯卡', '老顯卡，還可以用', 1, ADDDATE(CURDATE(), -9), ADDDATE(CURDATE(), -2), 210, 210, 2,  null,  3);
# 被競得的物品
INSERT INTO item ( item_name , item_remark , item_desc, kind_id, addtime , endtime, init_price,  max_price,  owner_id,  winer_id,  state_id)
	VALUES ( '老房子', '老式房子', '40年的老房子', 2, ADDDATE(CURDATE(), -9), ADDDATE(CURDATE(), -5), 21000, 25000, 2,  1,  2);

#競標歷史表
create table bid(
  bid_id int(11) auto_increment,
  user_id int(11) not null,
  item_id int(11) not null,
  bid_price double not null,
  bid_date date not null, 
  primary key(bid_id),
  unique(item_id , bid_price),
  FOREIGN KEY(user_id) REFERENCES auction_user(user_id), 
  FOREIGN KEY(item_id) REFERENCES item(item_id)   
);

INSERT INTO bid ( user_id , item_id , bid_price, bid_date)
	VALUES ( 2, 1, 250, ADDDATE(CURDATE(), -2));
INSERT INTO bid ( user_id , item_id , bid_price, bid_date)
	VALUES ( 1, 3, 25000, ADDDATE(CURDATE(), -6));

