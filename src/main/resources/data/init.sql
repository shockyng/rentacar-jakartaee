CREATE TABLE CARS
(
    CAR_ID   SERIAL UNIQUE,
    CAR_NAME VARCHAR(50),
    CAR_YEAR INTEGER,
    PRIMARY KEY (CAR_ID)
);

INSERT INTO CARS (CAR_NAME, CAR_YEAR)
VALUES ('Volvo XC40 ', 2023),
       ('Volkswagen Tiguan', 2023),
       ('Mazda CX-5', 2023),
       ('Hyundai Kauai', 2023),
       ('KIA Sportage', 2023),
       ('KIA Sportage', 2023),
       ('Honda HR-V', 2023),
       ('Hyundai Tucson', 2023),
       ('Jaguar E-Pace', 2023),
       ('DS7 Crossback', 2023);