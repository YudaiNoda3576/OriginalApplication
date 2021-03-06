CREATE TABLE `temple`
(
    `id`        int    NOT NULL AUTO_INCREMENT,
    `temple_id`  varchar(255) NOT NULL,
    `password`  varchar(255) NOT NULL,
    `temple_name` varchar(255) NOT NULL,
    `denomination` varchar(255) NOT NULL,
    `monk_name` varchar(255) NOT NULL,
    `position` varchar(255) NOT NULL,
    `postalcode` varchar(255) NOT NULL,
    `address` varchar(255) NOT NULL,
    `email`     varchar(255) NOT NULL,
    `role`      varchar(32)  ,
    PRIMARY KEY (`id`)
);