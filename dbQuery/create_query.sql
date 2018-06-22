create table users(
	user_id varchar(20) primary key not null,
    user_password varchar(32) not null,
    user_nickname varchar(20) not null unique,
    user_regtime timestamp not null,
    user_email varchar(40),
    user_phone varchar(20)
)