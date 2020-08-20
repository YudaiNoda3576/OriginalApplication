CREATE TABLE `test_worship`
(
    `worship_id` int(11) NOT NULL AUTO_INCREMENT,
    `worship_opts`  tinyint(1) NOT NULL,
    `schedule`  datetime NOT NULL,
    `remark` longtext NOT NULL,
    `supporter_id` int(11) NOT NULL,
    `progress` int(11) DEFAULT 1,
    foreign key worship(supporter_id) references supporter(supporter_id),
    PRIMARY KEY (`worship_id`)
); 