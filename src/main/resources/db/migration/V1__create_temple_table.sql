CREATE TABLE `temple`
(
<<<<<<< HEAD
    `id`        int    NOT NULL AUTO_INCREMENT,
=======
    `id`        int          NOT NULL AUTO_INCREMENT,
>>>>>>> master
    `temple_id`  varchar(255) NOT NULL,
    `password`  varchar(255) NOT NULL,
    `temple_name` varchar(255) NOT NULL,
    `denomination` varchar(255) NOT NULL,
<<<<<<< HEAD
    `name` varchar(255) NOT NULL,
    `position` varchar(255) NOT NULL,
    `postalcode` varchar(255) NOT NULL,
    `adress` varchar(255) NOT NULL,
=======
    `monk_name` varchar(255) NOT NULL,
    `position` varchar(255) NOT NULL,
    `postalcode` varchar(255) NOT NULL,
    `address` varchar(255) NOT NULL,
>>>>>>> master
    `email`     varchar(255) NOT NULL,
    `role`      varchar(32)  ,
    PRIMARY KEY (`id`)
);