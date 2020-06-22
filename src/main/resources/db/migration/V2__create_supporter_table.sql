CREATE TABLE `supporter`
(
    `supporter_id` int NOT NULL AUTO_INCREMENT,
    `supporter_name`  varchar(255) NOT NULL,
    `owner_name`  varchar(255) NOT NULL,
    `postalcode` varchar(255) NOT NULL,
    `adress` varchar(255) NOT NULL,
    `phonenumber` varchar(255) NOT NULL,
    `email`     varchar(255) NOT NULL,
    `temple_id` int,
    foreign key temple_id (supporter) references id(temple),
    PRIMARY KEY (`id`)
);