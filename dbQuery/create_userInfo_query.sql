create table userinfo(
	userinfo_id char(32) primary key,
    user_id varchar(20) references users
)