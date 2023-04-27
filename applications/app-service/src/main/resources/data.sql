INSERT INTO TBL_DRONE (ID, SERIAL_NUMBER, MODEL, WEIGHT_LIMIT, BATTERY_CAPACITY, STATE)
VALUES
  (100, 'ABCD1234', 'Lightweight', 10.0, 30.0, 'IDLE'),
  (101, 'EFGH5678', 'Middleweight', 200.0, 28.7, 'LOADING'),
  (102, 'IJKL9012', 'Cruiserweight', 300.0, 31.8, 'LOADED'),
  (103, 'IJKF8712', 'Cruiserweight', 250.0, 31.0, 'DELIVERING'),
  (104, 'IJKF8712', 'Heavyweight', 500.0, 31.0, 'DELIVERED'),
  (105, 'RLMO1597', 'Heavyweight', 367.0, 31.4, 'RETURNING'),
  (107, 'LAMO0408', 'Middleweight', 327.0, 5.5, 'IDLE'),
  (108, 'EJVM2510', 'Lightweight', 168.0, 30.0, 'LOADING'),
  (109, 'JVB0811', 'Cruiserweight', 287.0, 90.0, 'LOADED'),
  (110, 'MARM3010', 'Heavyweight', 467.0, 100.0, 'DELIVERING');
 COMMIT;

INSERT INTO TBL_MEDICATION (ID, NAME, WEIGHT, CODE, IMAGE, ID_DRONE)
VALUES
(100,'Ibuprofen', 100.7, 'MED_001', 'https://example.com/ibuprofen.jpg',100),
(200,'Acetaminophen', 50.5, 'MED_002', 'https://example.com/acetaminophen.jpg',101),
(300,'Acetaminophen', 50.5, 'MED_002', 'https://example.com/acetaminophen.jpg',102),
(400,'Codeine', 300.4, 'MED_004', 'https://example.com/codeine.jpg',100),
(500,'Codeine', 300.4, 'MED_004', 'https://example.com/codeine.jpg',null);
 COMMIT;