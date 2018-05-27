CREATE TABLE table1task1
(
  FIO   VARCHAR(20),
  adres VARCHAR(40),
  phone VARCHAR(20),
  age   INTEGER NOT NULL
);

CREATE UNIQUE INDEX table1task1_phone_uindex
  ON table1task1 (phone);