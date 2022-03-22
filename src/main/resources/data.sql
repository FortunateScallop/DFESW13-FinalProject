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

INSERT INTO `car_parking` (`number_plate`, `make`, `model`, `colour`, `price`, `paid`) VALUES ('AA11 AAA', 'Brand', 'Car', 'Colour', 671.23, false);
INSERT INTO `car_parking` (`number_plate`, `make`, `model`, `colour`, `price`, `paid`) VALUES ('AA11 AAA', 'Brand', 'Car', 'Colour', 671.23, false);
INSERT INTO `car_parking` (`number_plate`, `make`, `model`, `colour`, `price`, `paid`) VALUES ('AA11 AAA', 'Brand', 'Car', 'Colour', 671.23, false);
INSERT INTO `car_parking` (`number_plate`, `make`, `model`, `colour`, `price`, `paid`) VALUES ('AA11 AAA', 'Brand', 'Car', 'Colour', 671.23, false);
INSERT INTO `car_parking` (`number_plate`, `make`, `model`, `colour`, `price`, `paid`) VALUES ('AA11 AAA', 'Brand', 'Car', 'Colour', 671.23, false);