CREATE TABLE `worship`
(
    `worship_id` int NOT NULL AUTO_INCREMENT,
    `worship_type`  varchar(255) NOT NULL,
    `schedule`  datetime NOT NULL,
    `remark` text(500) NOT NULL,
    `supporter_id` int NOT NULL,
    foreign key worship(supporter_id) references supporter(supporter_id),
    PRIMARY KEY (`worship_id`)
);