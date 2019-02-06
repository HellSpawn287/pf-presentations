Drop TAble if exists customer;
CREATE TABLE customer (
  id BIGSERIAL PRIMARY KEY,
  firstName  VARCHAR(30),
  lastName  VARCHAR(30),
  city  VARCHAR(30),
  street  VARCHAR(30),
  houseNumber  VARCHAR(30)
);

Insert into customer(firstname, lastname, city, street, housenumber)
select 'F', 'L' , 'C' , 'S', g.houseNumber
from generate_series(1,2000000) as g(houseNumber);

ALTER TABLE customer ADD COLUMN newColumn VARCHAR(61);
update customer
set newColumn = 'xyz';

ALTER TABLE customer ADD COLUMN newColumn2 VARCHAR(61) DEFAULT 'XYZ';


ALTER TABLE customer ADD COLUMN concat VARCHAR(61);

UPDATE customer set concat = regexp_replace(street || ' ' || housenumber, '1', 'one');




