CREATE TABLE `worship`
(
    `worship_id` int NOT NULL AUTO_INCREMENT,
    `worship_type`  varchar(255) NOT NULL,
    `schedule`  datetime(255) NOT NULL,
    `remark` text(500) NOT NULL,
    `supporter_id` int NOT NULL,
    foreign key supporter_id (worship) references supporter_id(supporter),
    PRIMARY KEY (`worship_id`)
);