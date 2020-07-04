INSERT INTO `sms`.`student` (`address`, `dob`, `first_name`, `last_name`) VALUES ('277/1,asds ,sdsad', '1994-11-04', 'Thilina', 'Dilhara');
INSERT INTO `sms`.`student` (`address`, `dob`, `first_name`, `last_name`) VALUES ('785/2,Kelaniya,Gampha', '1991-05-07', 'Hida', 'Raina');
INSERT INTO `sms`.`teacher` (`address`, `contact_number`, `dob`, `first_name`, `last_name`) VALUES ('247,Viraketiya,Hambanthota', '012347', '1987-5-8', 'Karunathilaka', 'Disanayake');
INSERT INTO `sms`.`teacher` (`address`, `contact_number`, `dob`, `first_name`, `last_name`) VALUES ('788,Pahala Biyanvila,Kadawatha', '145236', '1975-03-15', 'Anoma', 'Weerasingha');


INSERT INTO `sms`.`parent` (`contact_number`, `first_name`, `last_name`, `occupation`, `relationship`) VALUES ('01785258', 'Ruwan', 'Rathnasekara', 'Machanic', 'Father');
INSERT INTO `sms`.`parent` (`contact_number`, `first_name`, `last_name`, `occupation`, `relationship`) VALUES ('07785214', 'Kalum ', 'Gunaratne', 'Doctor', 'Father');

--add parents to already created students
UPDATE `sms`.`student` SET `parent_id` = '2' WHERE (`student_id` = '2');
UPDATE `sms`.`student` SET `parent_id` = '1' WHERE (`student_id` = '1');


--add classes
--2019 classes
INSERT INTO `sms`.`classes` (`grade`, `section`, `year`) VALUES ('1', 'A', '2019');
INSERT INTO `sms`.`classes` (`grade`, `section`, `year`) VALUES ('1', 'B', '2019');
INSERT INTO `sms`.`classes` (`grade`, `section`, `year`) VALUES ('2', 'A', '2019');
INSERT INTO `sms`.`classes` (`grade`, `section`, `year`) VALUES ('2', 'B', '2019');
INSERT INTO `sms`.`classes` (`grade`, `section`, `year`) VALUES ('3', 'A', '2019');
INSERT INTO `sms`.`classes` (`grade`, `section`, `year`) VALUES ('3', 'B', '2019');
INSERT INTO `sms`.`classes` (`grade`, `section`, `year`) VALUES ('4', 'A', '2019');
INSERT INTO `sms`.`classes` (`grade`, `section`, `year`) VALUES ('4', 'B', '2019');
INSERT INTO `sms`.`classes` (`grade`, `section`, `year`) VALUES ('5', 'A', '2019');
INSERT INTO `sms`.`classes` (`grade`, `section`, `year`) VALUES ('5', 'B', '2019');
--2020 classes
INSERT INTO `sms`.`classes` (`grade`, `section`, `year`) VALUES ('1', 'A', '2020');
INSERT INTO `sms`.`classes` (`grade`, `section`, `year`) VALUES ('1', 'B', '2020');
INSERT INTO `sms`.`classes` (`grade`, `section`, `year`) VALUES ('2', 'A', '2020');
INSERT INTO `sms`.`classes` (`grade`, `section`, `year`) VALUES ('2', 'B', '2020');
INSERT INTO `sms`.`classes` (`grade`, `section`, `year`) VALUES ('3', 'A', '2020');
INSERT INTO `sms`.`classes` (`grade`, `section`, `year`) VALUES ('3', 'B', '2020');
INSERT INTO `sms`.`classes` (`grade`, `section`, `year`) VALUES ('4', 'A', '2020');
INSERT INTO `sms`.`classes` (`grade`, `section`, `year`) VALUES ('4', 'B', '2020');
INSERT INTO `sms`.`classes` (`grade`, `section`, `year`) VALUES ('5', 'A', '2020');
INSERT INTO `sms`.`classes` (`grade`, `section`, `year`) VALUES ('5', 'B', '2020');

