CREATE TABLE PRODUCT (
                         ID INT AUTO_INCREMENT PRIMARY KEY,
                         CODE CHAR(15) UNIQUE,
                         NAME VARCHAR(255),
                         PRICE_EUR DECIMAL(10, 2),
                         PRICE_USD DECIMAL(10, 2),
                         DESCRIPTION VARCHAR(1000),
                         CHECK (LENGTH(CODE) = 15)
);

CREATE TABLE REVIEW (
                        ID INT AUTO_INCREMENT PRIMARY KEY,
                        PRODUCT_ID INT,
                        REVIEWER VARCHAR(255),
                        TEXT VARCHAR(1000),
                        RATING INT CHECK (RATING BETWEEN 1 AND 5),
                        FOREIGN KEY (PRODUCT_ID) REFERENCES PRODUCT(ID)
);

INSERT INTO PRODUCT (CODE, NAME, PRICE_EUR, PRICE_USD, DESCRIPTION)
VALUES
    ('COSM001', 'Ruž za usne', 10.99, 12.99, 'Mat ruž koji dugo traje'),
    ('COSM002', 'Podloga za šminkanje', 15.50, 18.00, 'Tekuća podloga srednjeg prekrivanja'),
    ('COSM003', 'Paleta sjenila za oči', 25.99, 29.99, 'Paleta s neutralnim nijansama sjenila za oči'),
    ('COSM004', 'Maskara', 8.99, 10.99, 'Maskara koja produžuje i povećava volumen trepavica'),
    ('COSM005', 'Rumenilo', 12.75, 14.99, 'Pigmentirano pudrasto rumenilo');

INSERT INTO REVIEW (PRODUCT_ID, REVIEWER, TEXT, RATING)
VALUES
    (4, 'Maja', 'Odlična boja i ostaje cijeli dan!', 5),
    (2, 'Hrvoje', 'Lijepa raznolikost nijansi.', 4),
    (2, 'Hrvoje', 'Lijepa raznolikost nijansi2.', 3),
    (4, 'Hrvoje', 'Lijepa raznolikost nijansi.', 1),
    (4, 'Maja', 'Odlična boja i ostaje cijeli dan!', 5),
    (2, 'Hrvoje', 'Lijepa raznolikost nijansi.', 4),
    (2, 'Hrvoje', 'Lijepa raznolikost nijansi2.', 3),
    (4, 'Hrvoje', 'Lijepa raznolikost nijansi.', 1),
    (1, 'Ana', 'Savršeno se uklapa uz sve kombinacije odjeće.', 5),
    (3, 'Petar', 'Jako dugotrajan i postojan proizvod.', 4),
    (5, 'Ivana', 'Pogodan za osjetljivu kožu.', 3),
    (3, 'Marija', 'Očekivao sam bolji kvalitet.', 2),
    (5, 'Marko', 'Nemam primjedbi, odličan proizvod.', 5);