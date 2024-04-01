-- auto-generated definition
create schema `library-management` collate utf8mb4_unicode_ci;

-- auto-generated definition
create table admin
(
    id         int auto_increment
        primary key,
    username   varchar(255) null,
    password   varchar(30)  null,
    email      varchar(255) null,
    createtime datetime     null,
    updatetime datetime     null
);



-- auto-generated definition
create table book
(
    id          int auto_increment
        primary key,
    name        varchar(255)  null comment '图书名',
    description varchar(255)  null comment '描述',
    author      varchar(255)  null comment '作者',
    category    varchar(255)  null,
    status      int default 1 not null comment '可借状态',
    createtime  datetime      null,
    updatetime  datetime      null,
    constraint book_category_name_fk
        foreign key (category) references category (name)
)
    comment '图书表';

create table `library-management`.borrow
(
    id         int auto_increment
        primary key,
    book_id    int          null comment '书的id',
    book_name  varchar(255) null comment '书名',
    user_id    int          null comment '用户id',
    user_name  varchar(255) null comment '用户名',
    createtime datetime     null comment '创建时间',
    updatetime datetime     null comment '更新时间'
);

-- auto-generated definition
create table category
(
    id         int auto_increment
        primary key,
    name       varchar(255) not null comment '名称',
    remark     varchar(255) null,
    pid        varchar(255) null comment '图书分类编号',
    createtime datetime     null,
    updatetime datetime     null,
    constraint category_pk
        unique (name)
);

-- auto-generated definition
create table user
(
    id         int auto_increment
        primary key,
    name       varchar(255) null comment '姓名',
    username   varchar(255) null comment '用户名',
    age        int          null comment '年龄',
    sex        varchar(1)   null comment '性别',
    phone      varchar(255) null comment '联系方式',
    address    varchar(255) null comment '地址',
    createtime datetime     null comment '创建时间',
    updatetime datetime     null comment '更新时间'
);

