DROP TABLE IF EXISTS `car_parking`;

CREATE TABLE car_parking( 
id int AUTO_INCREMENT, 
number_plate VARCHAR(50) NOT NULL,
make VARCHAR(50) NOT NULL,
model VARCHAR(50) NOT NULL,
colour VARCHAR(50) NOT NULL,
price float NOT NULL,
paid boolean NOT NULL,
PRIMARY KEY (id)
);

INSERT INTO `car_parking` (`number_plate`, `make`, `model`, `colour`, `price`, `paid`) VALUES ('test_plate1', 'test_make1', 'test_model1', 'test_colour1', 111, true);
INSERT INTO `car_parking` (`number_plate`, `make`, `model`, `colour`, `price`, `paid`) VALUES ('test_plate2', 'test_make2', 'test_model2', 'test_colour2', 222, false);