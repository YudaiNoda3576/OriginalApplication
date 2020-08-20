CREATE TABLE `test_temple`
(
    `id`        int(11)    NOT NULL AUTO_INCREMENT,
    `temple_id`  varchar(11) NOT NULL,
    `password`  varchar(100) NOT NULL,
    `temple_name` varchar(20) NOT NULL,
    `denomination` varchar(20) NOT NULL,
    `monk_name` varchar(20) NOT NULL,
    `position` varchar(20) NOT NULL,
    `postalcode` varchar(15) NOT NULL,
    `address` varchar(45) NOT NULL,
    `email`     varchar(30) NOT NULL,
    `role`      varchar(32)  ,
    PRIMARY KEY (`id`)
);