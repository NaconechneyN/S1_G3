INSERT INTO hotel (codigo_hotel, nombre_hotel, ciudad, tipo_habitacion, precio, fecha_disponibilidad_desde, fecha_disponibilidad_hasta, reservado, acepta_mascotas)
VALUES ('CH-0002', 'Cataratas Hotel', 'Puerto Iguazú', 'doble', 6300.00, '2023/04/10', '2023/06/20', false, false);

INSERT INTO hotel (codigo_hotel, nombre_hotel, ciudad, tipo_habitacion, precio, fecha_disponibilidad_desde, fecha_disponibilidad_hasta, reservado, acepta_mascotas)
VALUES ('CH-0003', 'Cataratas Hotel 2', 'Puerto Iguazú', 'triple', 8300.00, '2023/04/10', '2023/05/23', false, true);

INSERT INTO hotel (codigo_hotel, nombre_hotel, ciudad, tipo_habitacion, precio, fecha_disponibilidad_desde, fecha_disponibilidad_hasta, reservado, acepta_mascotas)
VALUES ('HB-0001', 'Hotel Bristol', 'Buenos Aires', 'single', 5435.00, '2023/02/10', '2023/06/19', false, true);

INSERT INTO hotel (codigo_hotel, nombre_hotel, ciudad, tipo_habitacion, precio, fecha_disponibilidad_desde, fecha_disponibilidad_hasta, reservado, acepta_mascotas)
VALUES ('BH-0002', 'Hotel Bristol 2', 'Buenos Aires', 'doble', 7200.00, '2023/02/12', '2023/06/17', false, false);

INSERT INTO hotel (codigo_hotel, nombre_hotel, ciudad, tipo_habitacion, precio, fecha_disponibilidad_desde, fecha_disponibilidad_hasta, reservado, acepta_mascotas)
VALUES ('SH-0002', 'Sheraton', 'Tucumán', 'doble', 5790.00, '2023/02/12', '2023/06/17', false, false);

INSERT INTO hotel (codigo_hotel, nombre_hotel, ciudad, tipo_habitacion, precio, fecha_disponibilidad_desde, fecha_disponibilidad_hasta, reservado, acepta_mascotas)
VALUES ('SH-0001', 'Sheraton 2', 'Tucumán', 'single', 4150.00, '2023/02/12', '2023/06/17', false, false);

INSERT INTO hotel (codigo_hotel, nombre_hotel, ciudad, tipo_habitacion, precio, fecha_disponibilidad_desde, fecha_disponibilidad_hasta, reservado, acepta_mascotas)
VALUES ('SE-0001', 'Selina', 'Bogotá', 'single', 3900.00, '2023/02/12', '2023/06/17', false, true);

INSERT INTO hotel (codigo_hotel, nombre_hotel, ciudad, tipo_habitacion, precio, fecha_disponibilidad_desde, fecha_disponibilidad_hasta, reservado, acepta_mascotas)
VALUES ('SE-0002', 'Selina 2', 'Bogotá', 'doble', 5840.00, '2023/02/12', '2023/06/17', false, false);

INSERT INTO hotel (codigo_hotel, nombre_hotel, ciudad, tipo_habitacion, precio, fecha_disponibilidad_desde, fecha_disponibilidad_hasta, reservado, acepta_mascotas)
VALUES ('EC-0003', 'El Campín', 'Bogotá', 'triple', 7020.00, '2023/02/12', '2023/06/17', false, false);

INSERT INTO hotel (codigo_hotel, nombre_hotel, ciudad, tipo_habitacion, precio, fecha_disponibilidad_desde, fecha_disponibilidad_hasta, reservado, acepta_mascotas)
VALUES ('CP-0004', 'Central Plaza', 'Medellín', 'Múltiple', 8600.00, '2023/02/12', '2023/06/17', false, false);

INSERT INTO hotel (codigo_hotel, nombre_hotel, ciudad, tipo_habitacion, precio, fecha_disponibilidad_desde, fecha_disponibilidad_hasta, reservado, acepta_mascotas)
VALUES ('CP-0002', 'Central Plaza 2', 'Medellín', 'doble', 6400.00, '2023/02/12', '2023/06/17', false, true);

INSERT INTO hotel (codigo_hotel, nombre_hotel, ciudad, tipo_habitacion, precio, fecha_disponibilidad_desde, fecha_disponibilidad_hasta, reservado, acepta_mascotas)
VALUES ('BG-0004', 'Bocagrande', 'Cartagena', 'Múltiple', 9370.00, '2023/02/12', '2023/06/17', false, false);

INSERT INTO vuelos (numero_vuelo, ciudad_origen, ciudad_destino, tipo_asiento, precio, fecha_salida, fecha_retorno, reserva)
VALUES ("BAPI-1235", "Buenos Aires", "Puerto Iguazú", "Economy", 6500, "2023/03/10", "2023/04/15", false);

INSERT INTO vuelos (numero_vuelo, ciudad_origen, ciudad_destino, tipo_asiento, precio, fecha_salida, fecha_retorno, reserva)
VALUES ("PIBA-1420", "Puerto Iguazú", "Bogotá", "Business", 43200, "2023/03/10", "2023/04/15", false);

INSERT INTO vuelos (numero_vuelo, ciudad_origen, ciudad_destino, tipo_asiento, precio, fecha_salida, fecha_retorno, reserva)
VALUES ("PIBA-1420", "Buenos Aires", "Puerto Iguazú", "Economy", 25735, "2023/03/10", "2023/04/15", false);

INSERT INTO vuelos (numero_vuelo, ciudad_origen, ciudad_destino, tipo_asiento, precio, fecha_salida, fecha_retorno, reserva)
VALUES ("BATU-5536", "Buenos Aires", "Tucumán", "Economy", 7320, "2023/03/10", "2023/04/15", false);

INSERT INTO vuelos (numero_vuelo, ciudad_origen, ciudad_destino, tipo_asiento, precio, fecha_salida, fecha_retorno, reserva)
VALUES ("TUPI-3369", "Tucumán", "Puerto Iguazú", "Business", 12530, "2023/03/10", "2023/04/15", false);

INSERT INTO vuelos (numero_vuelo, ciudad_origen, ciudad_destino, tipo_asiento, precio, fecha_salida, fecha_retorno, reserva)
VALUES ("TUPI-3369", "Tucumán", "Puerto Iguazú", "Economy", 5400, "2023/03/10", "2023/04/15", false);

INSERT INTO vuelos (numero_vuelo, ciudad_origen, ciudad_destino, tipo_asiento, precio, fecha_salida, fecha_retorno, reserva)
VALUES ("BOCA-4213", "Bogotá", "Cartagena", "Economy", 8000, "2023/03/10", "2023/04/15", false);

INSERT INTO vuelos (numero_vuelo, ciudad_origen, ciudad_destino, tipo_asiento, precio, fecha_salida, fecha_retorno, reserva)
VALUES ("CAME-0321", "Cartagena", "Medellín", "Economy", 7800, "2023/03/10", "2023/04/15", false);

INSERT INTO vuelos (numero_vuelo, ciudad_origen, ciudad_destino, tipo_asiento, precio, fecha_salida, fecha_retorno, reserva)
VALUES ("BOBA-6567", "Bogotá", "Buenos Aires", "Business", 57000, "2023/03/10", "2023/04/15", false);

INSERT INTO vuelos (numero_vuelo, ciudad_origen, ciudad_destino, tipo_asiento, precio, fecha_salida, fecha_retorno, reserva)
VALUES ("BOBA-6567", "Bogotá", "Buenos Aires", "Economy", 39860, "2023/03/10", "2023/04/15", false);

INSERT INTO vuelos (numero_vuelo, ciudad_origen, ciudad_destino, tipo_asiento, precio, fecha_salida, fecha_retorno, reserva)
VALUES ("BOME-4442", "Bogotá", "Medellín", "Economy", 11000, "2023/03/10", "2023/04/15", false);

INSERT INTO vuelos (numero_vuelo, ciudad_origen, ciudad_destino, tipo_asiento, precio, fecha_salida, fecha_retorno, reserva)
VALUES ("MEPI-9986", "Medellín", "Puerto Iguazú", "Business", 41640, "2023/03/10", "2023/04/15", false);



