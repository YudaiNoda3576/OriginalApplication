CREATE TABLE `worship`
(
    `worship_id` int NOT NULL AUTO_INCREMENT,
    `worship_opts`  tinyint NOT NULL,
    `schedule`  datetime NOT NULL,
    `remark` text(500) NOT NULL,
    `supporter_id` int NOT NULL,
    `progress` int DEFAULT 1,
    foreign key worship(supporter_id) references supporter(supporter_id),
    PRIMARY KEY (`worship_id`)
);