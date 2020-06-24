CREATE TABLE `supporter`
(
    `supporter_id` int NOT NULL AUTO_INCREMENT,
    `supporter_name`  varchar(255) NOT NULL,
    `owner_name`  varchar(255) NOT NULL,
    `postalcode` varchar(255) NOT NULL,
    `address` varchar(255) NOT NULL,
    `phonenumber` varchar(255) NOT NULL,
    `email`     varchar(255) NOT NULL,
    `temple_id` int NOT NULL,
    foreign key supporter(temple_id) references temple(id),
    PRIMARY KEY (`supporter_id`)
);