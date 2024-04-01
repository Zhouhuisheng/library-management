INSERT INTO `library-management`.admin (id, username, password, email, createtime, updatetime) VALUES (7, 'admin', '1234', '11@qq.com', '2024-03-29 10:31:43', '2024-04-01 11:56:51');
INSERT INTO `library-management`.admin (id, username, password, email, createtime, updatetime) VALUES (8, 'zhouhs', '123', '3910@qq.com', '2024-04-01 12:06:22', '2024-04-01 12:06:22');

INSERT INTO `library-management`.book (id, name, description, author, category, status, createtime, updatetime) VALUES (10, 'Java从入门到摔门1', '这是一本Java入门书', '周辉生', '计算机类', 1, '2024-03-31 21:01:43', '2024-03-31 21:02:47');
INSERT INTO `library-management`.book (id, name, description, author, category, status, createtime, updatetime) VALUES (11, 'Java从入门到摔门2', '这是一本Java入门书', '周辉生', '计算机类', 1, '2024-03-31 21:01:43', '2024-03-31 21:02:47');
INSERT INTO `library-management`.book (id, name, description, author, category, status, createtime, updatetime) VALUES (16, '高等数学1', '这是高等数学第一册', '数学老师', '数学类', 0, '2024-04-01 13:58:38', '2024-04-01 13:58:38');
INSERT INTO `library-management`.book (id, name, description, author, category, status, createtime, updatetime) VALUES (17, '高等数学2', '这是高等数学第二册。', '数学老师', '数学类', 1, '2024-04-01 13:58:55', '2024-04-01 13:59:27');

INSERT INTO `library-management`.borrow (id, book_id, book_name, user_id, user_name, createtime, updatetime) VALUES (17, 15, '高等数学2', 20, 'zhs', '2024-04-01 11:36:45', '2024-04-01 11:36:45');
INSERT INTO `library-management`.borrow (id, book_id, book_name, user_id, user_name, createtime, updatetime) VALUES (19, 16, '高等数学1', 22, '周辉生', '2024-04-01 13:59:12', '2024-04-01 13:59:12');

INSERT INTO `library-management`.category (id, name, remark, pid, createtime, updatetime) VALUES (3, '计算机类', '计算机类的图书', '1', '2024-03-31 20:18:04', '2024-03-31 20:18:04');
INSERT INTO `library-management`.category (id, name, remark, pid, createtime, updatetime) VALUES (4, '数学类', '这是数学图书的分类', '3', '2024-04-01 11:35:30', '2024-04-01 11:35:30');

INSERT INTO `library-management`.user (id, name, username, age, sex, phone, address, createtime, updatetime) VALUES (10, '张一', 'zhang1', 25, '女', '18888888000', '海口市', '2024-03-28 10:27:49', '2024-03-28 10:27:49');
INSERT INTO `library-management`.user (id, name, username, age, sex, phone, address, createtime, updatetime) VALUES (11, '张二', 'zhang2', 23, '男', '18888888001', '海口市', '2024-03-27 13:45:13', '2024-03-27 13:45:13');
INSERT INTO `library-management`.user (id, name, username, age, sex, phone, address, createtime, updatetime) VALUES (12, '张三', 'zhang3', 26, '男', '18888888002', '海口市', '2024-03-27 13:45:13', '2024-03-27 13:45:13');
INSERT INTO `library-management`.user (id, name, username, age, sex, phone, address, createtime, updatetime) VALUES (13, '张四', 'zhang4', 28, '男', '18888888003', '海口市', '2024-03-27 13:45:13', '2024-03-27 13:45:13');
INSERT INTO `library-management`.user (id, name, username, age, sex, phone, address, createtime, updatetime) VALUES (17, '张五', 'zhang5', 22, '男', '18888888004', '海口市', '2024-03-27 13:45:13', '2024-03-27 13:45:13');
INSERT INTO `library-management`.user (id, name, username, age, sex, phone, address, createtime, updatetime) VALUES (18, '张六', 'zhang6', 22, '男', '18888888005', '海口市', '2024-03-27 12:23:13', '2024-03-27 13:45:13');
INSERT INTO `library-management`.user (id, name, username, age, sex, phone, address, createtime, updatetime) VALUES (19, '张七', 'zhang7', 22, '男', '18888888006', '海口市', '2024-03-27 12:24:43', '2024-03-27 13:45:13');
INSERT INTO `library-management`.user (id, name, username, age, sex, phone, address, createtime, updatetime) VALUES (20, 'zhs', 'zhs123', 23, '男', '18889995660', '海口市', '2024-03-28 10:23:09', '2024-03-28 10:23:09');
INSERT INTO `library-management`.user (id, name, username, age, sex, phone, address, createtime, updatetime) VALUES (21, 'zhs', 'zhs123123', 23, '男', '18888889990', '海口市', '2024-03-28 10:26:23', '2024-03-28 10:26:23');
INSERT INTO `library-management`.user (id, name, username, age, sex, phone, address, createtime, updatetime) VALUES (22, '周辉生', 'zhs333', 23, '男', '18889990000', '海口市', '2024-03-28 10:27:08', '2024-03-28 10:27:08');
INSERT INTO `library-management`.user (id, name, username, age, sex, phone, address, createtime, updatetime) VALUES (23, '周馨婷', 'zxt', 19, '女', '13630000000', '三亚市', '2024-04-01 11:38:35', '2024-04-01 11:38:35');
INSERT INTO `library-management`.user (id, name, username, age, sex, phone, address, createtime, updatetime) VALUES (24, '周一', 'zhouyi', 20, '女', '13000000000', '文昌市', '2024-04-01 12:06:03', '2024-04-01 12:06:03');
