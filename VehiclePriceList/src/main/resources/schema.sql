
drop table vehicle_price if exists;

create table vehicle_price (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    make_name varchar(255),
    model_name varchar(255),
    price double,
    option_name varchar(255),
    option_price double
   );