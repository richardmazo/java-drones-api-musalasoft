INSERT INTO TBL_DRONE (ID, SERIAL_NUMBER, MODEL, WEIGHT_LIMIT, BATTERY_CAPACITY, STATE)
VALUES
  (1, 'ABCD1234', 'Lightweight', 10.0, 30.0, 'IDLE'),
  (2, 'EFGH5678', 'Middleweight', 200.0, 28.7, 'LOADING'),
  (3, 'IJKL9012', 'Cruiserweight', 300.0, 31.8, 'LOADED'),
  (4, 'IJKF8712', 'Cruiserweight', 250.0, 31.0, 'DELIVERING'),
  (5, 'IJKF8712', 'Heavyweight', 500.0, 31.0, 'DELIVERED'),
  (6, 'RLMO1597', 'Heavyweight', 367.0, 31.4, 'RETURNING'),
  (7, 'LAMO0408', 'Middleweight', 327.0, 5.5, 'IDLE'),
  (8, 'EJVM2510', 'Lightweight', 168.0, 30.0, 'LOADING'),
  (9, 'JVB0811', 'Cruiserweight', 287.0, 90.0, 'LOADED'),
  (10, 'MARM3010', 'Heavyweight', 467.0, 100.0, 'DELIVERING');
 COMMIT;

INSERT INTO TBL_MEDICATION (id, name, weight, code, image)
VALUES
(1,'Ibuprofen', 100.7, 'MED_001', 'https://example.com/ibuprofen.jpg'),
(2,'Acetaminophen', 50.5, 'MED_002', 'https://example.com/acetaminophen.jpg'),
(3,'Aspirin', 0.1, 'MED_003', 'https://example.com/aspirin.jpg'),
(4,'Codeine', 300.4, 'MED_004', 'https://example.com/codeine.jpg');
 COMMIT;