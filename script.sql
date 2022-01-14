INSERT INTO `roles` (`name`) VALUES ('USER');
INSERT INTO `roles` (`name`) VALUES ('ADMIN');

INSERT INTO `users` (`email`,`enabled`,`first_name`,`last_name`,`password`, `math_points`, `cs_points` )
VALUES ('admin@gmail.com', 1,'Admin','BlueTeam','$2a$10$NFYJYnrpxPL4otV9hs1QweEp80slkiYyXAzBv7j0wgXcT1RkO03Ea',0,0); -- parola e Admin00


INSERT INTO `questions` ( `title`, `optionA`, `optionB`, `optionC`,`ans`,`chose`,`type`)
VALUES ('Given x = 47, calculate y = x + 7','y = 53','y = 54','y = 55',2,-1,'math');
INSERT INTO `questions` ( `title`, `optionA`, `optionB`, `optionC`,`ans`,`chose`,`type`)
VALUES ('If you need to copy the contents of MS Word, which command will you give?','Ctrl + X','Ctrl + Z','Ctrl + C',3,-1,'info');
INSERT INTO `questions` ( `title`, `optionA`, `optionB`, `optionC`,`ans`,`chose`,`type`)
VALUES ('Solve for y.   y/3 = 18','y = 54','y = 6','y = 1/6',1,-1,'math');
INSERT INTO `questions` ( `title`, `optionA`, `optionB`, `optionC`,`ans`,`chose`,`type`)
VALUES ('Solve for x.   5/6*x = 30','x = 36','x = 30','x = 25',1,-1,'math');
INSERT INTO `questions` ( `title`, `optionA`, `optionB`, `optionC`,`ans`,`chose`,`type`)
VALUES ('Which of the following values has an exact square root?','125','49','24',2,-1,'math');
INSERT INTO `questions` ( `title`, `optionA`, `optionB`, `optionC`,`ans`,`chose`,`type`)
VALUES ('Which of the following has an exact cube root?','125','49','24',1,-1,'math');
INSERT INTO `questions` ( `title`, `optionA`, `optionB`, `optionC`,`ans`,`chose`,`type`)
VALUES ('Between which two integers will you find √156 equation?','10 and 11','11 and 12','12 and 13',3,-1,'math');
INSERT INTO `questions` ( `title`, `optionA`, `optionB`, `optionC`,`ans`,`chose`,`type`)
VALUES ('Approximate √59','7.3','7.7','7.5',2,-1,'math');
INSERT INTO `questions` ( `title`, `optionA`, `optionB`, `optionC`,`ans`,`chose`,`type`)
VALUES ('Approximate √(600/15)','6.3','6.5','6.7',1,-1,'math');
INSERT INTO `questions` ( `title`, `optionA`, `optionB`, `optionC`,`ans`,`chose`,`type`)
VALUES ('Which statement is true?','2√3 < 3√2','2√3 > 3√2','2√3 = 3√2',1,-1,'math');
INSERT INTO `questions` ( `title`, `optionA`, `optionB`, `optionC`,`ans`,`chose`,`type`)
VALUES ('Who among the following had invented the computer microprocessor?','Marcian Hoff','Wolfson James Clerk','Leonardo da Vinci',1,-1,'info');
INSERT INTO `questions` ( `title`, `optionA`, `optionB`, `optionC`,`ans`,`chose`,`type`)
VALUES ('Which among the following correctly defines the term ‘backup?’','Separating a computer system from the group of computers','Linking one computer system with multiple computers','Copying and saving data from the original source to other secure destination',3,-1,'info');
INSERT INTO `questions` ( `title`, `optionA`, `optionB`, `optionC`,`ans`,`chose`,`type`)
VALUES ('PageMaker, which was one of the first desktop publishing programs, is related to …','UNIX','Windows','A & B both',2,-1,'info');
INSERT INTO `questions` ( `title`, `optionA`, `optionB`, `optionC`,`ans`,`chose`,`type`)
VALUES ('Which among the following connects two more networks?','Gateway','HTTP','Highway',1,-1,'info');
INSERT INTO `questions` ( `title`, `optionA`, `optionB`, `optionC`,`ans`,`chose`,`type`)
VALUES ('The computer malware that disguises users by representing itself as legitimate software/program is known as …','Spyware','Trojans','Worms',2,-1,'info');
INSERT INTO `questions` ( `title`, `optionA`, `optionB`, `optionC`,`ans`,`chose`,`type`)
VALUES ('If you restart your computer by switching it off (i.e. power cut), it is known as …','Soft boot','Cold boot','Warm boot',2,-1,'info');
INSERT INTO `questions` ( `title`, `optionA`, `optionB`, `optionC`,`ans`,`chose`,`type`)
VALUES ('Which among the following is the shortcut key to Zoom out window?','Shift + [-]','Win + [-]','Alt + [-]',2,-1,'info');
INSERT INTO `questions` ( `title`, `optionA`, `optionB`, `optionC`,`ans`,`chose`,`type`)
VALUES ('Magnetic disk or simply disk is an information storage device.','Organization','Department','Individual',3,-1,'info');
INSERT INTO `questions` ( `title`, `optionA`, `optionB`, `optionC`,`ans`,`chose`,`type`)
VALUES ('Which among the following correctly defines two parts of an email address?','Name and Surname','Username and domain name','Initial name and domain name',2,-1,'info');
INSERT INTO `questions` ( `title`, `optionA`, `optionB`, `optionC`,`ans`,`chose`,`type`)
VALUES ('Simplify √21','3√7','7√3','It is already in simplest form.',3,-1,'math');

INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES (1, 2);