DROP TABLE IF EXISTS `car_parking`;

CREATE TABLE car_parking( 
id long AUTO_INCREMENT, 
number_plate VARCHAR(10) NOT NULL,
make VARCHAR(10) NOT NULL,
model VARCHAR(10) NOT NULL,
colour VARCHAR(25) NOT NULL,
price float NOT NULL,
paid boolean NOT NULL,
PRIMARY KEY (id)
);

use carparkingdb;


INSERT INTO `car_parking` (`number_plate`, `make`, `model`, `colour`, `price`, `paid`) VALUES ('AA11 AAA', 'Brand1', 'Car1', 'Colour1', 11.11, false);
INSERT INTO `car_parking` (`number_plate`, `make`, `model`, `colour`, `price`, `paid`) VALUES ('BB22 BBB', 'Brand2', 'Car2', 'Colour2', 22.22, true);
INSERT INTO `car_parking` (`number_plate`, `make`, `model`, `colour`, `price`, `paid`) VALUES ('CC33 CCC', 'Brand3', 'Car3', 'Colour3', 333.33, false);
INSERT INTO `car_parking` (`number_plate`, `make`, `model`, `colour`, `price`, `paid`) VALUES ('DD44 DDD', 'Brand4', 'Car4', 'Colour4', 44.44, true);
INSERT INTO `car_parking` (`number_plate`, `make`, `model`, `colour`, `price`, `paid`) VALUES ('EE55 EEE', 'Brand5', 'Car5', 'Colour5', 555.55, false);
INSERT INTO `car_parking` (`number_plate`, `make`, `model`, `colour`, `price`, `paid`) VALUES ('FF66 FFF', 'Brand6', 'Car6', 'Colour6', 6.66, true);
INSERT INTO `car_parking` (`number_plate`, `make`, `model`, `colour`, `price`, `paid`) VALUES ('GG77 GGG', 'Brand7', 'Car7', 'Colour7', 77.77, false);
INSERT INTO `car_parking` (`number_plate`, `make`, `model`, `colour`, `price`, `paid`) VALUES ('HH88 HHH', 'Brand8', 'Car8', 'Colour8', 8.8, true);
INSERT INTO `car_parking` (`number_plate`, `make`, `model`, `colour`, `price`, `paid`) VALUES ('II99 III', 'Brand9', 'Car9', 'Colour9', 9.99, false);
INSERT INTO `car_parking` (`number_plate`, `make`, `model`, `colour`, `price`, `paid`) VALUES ('JJ00 JJJ', 'Brand10', 'Car10', 'Colour10', 00.10, true);