create database if not exists crm_employee_management;

use crm_employee_management;

create table if not exists role (
	id int auto_increment,
    name varchar(255) not null,
    description varchar(255),
    primary key(id)
);

create table if not exists user (
	id int auto_increment,
    email varchar(255) not null unique,
    password varchar(255) not null,
    name varchar(255) not null,
    address varchar(255),
    phone varchar(50),
    role_id int,
    primary key(id)
);

create table if not exists project (
	id int auto_increment,
    name varchar(255) not null,
    description varchar(255),
    start_date date,
    end_date date,
    owner int,
    primary key(id)
);

create table if not exists project_user (
	project_id int,
    user_id int,
    join_date date,
    role_description varchar(255),
    primary key (project_id, user_id)
);

create table if not exists status (
	id int auto_increment,
    name varchar(255) not null,
    description varchar(255),
    primary key(id)
);

create table if not exists task (
	id int auto_increment,
    name varchar(255) not null,
    description varchar(255),
    start_date date,
    end_date date,
    project_id int,
    user_id int,
    status_id int,
    primary key(id)
);

alter table user
	add constraint fk_user_role 
		foreign key (role_id) references role(id);

alter table project
	add constraint fk_project_user_owner
		foreign key (owner) references user(id);
        
alter table project_user
	add constraint fk_project_user_project_join_list
		foreign key (project_id) references project(id),
	add constraint fk_project_user_user_join_list
		foreign key (user_id) references user(id);
        
alter table task
	add constraint fk_task_user
		foreign key (user_id) references user(id),
	add constraint fk_task_project
		foreign key (project_id) references project(id),
    add constraint fk_task_status
		foreign key (status_id) references status(id);
