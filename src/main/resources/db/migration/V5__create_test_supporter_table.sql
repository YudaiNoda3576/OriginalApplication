CREATE TABLE `test_supporter`
(
    `supporter_id` int(11) NOT NULL AUTO_INCREMENT,
    `supporter_name`  varchar(45) NOT NULL,
    `owner_name`  varchar(45) NOT NULL,
    `postalcode` varchar(10) NOT NULL,
    `address` varchar(45) NOT NULL,
    `phonenumber` varchar(15) NOT NULL,
    `email`     varchar(30) NOT NULL,
    `temple_id` int NOT NULL,
    foreign key supporter(temple_id) references temple(id),
    PRIMARY KEY (`supporter_id`)
);