# S1_G3
- En la UserStory 3 vamos a mostrar el precio de la reserva ya que creemos que es el dato mas relevante.
- Asumimos que la cantidad de personas que reservan las habitaciones es coincidente con el tipo de habitación solicitada. Por ejemplo, si una persona reserva una habitacion doble, entendemos que está acompañado.
# Sprint 1

# Endpoints POSTMAN
- User Story 1= localhost:8085/api/v1/hotels

- User Story 2= localhost:8085/api/v1/hotels?dateFrom=10/04/2023&dateTo=23/05/2023&destination=Puerto Iguazú

- User Story 3= localhost:8085/api/v1/booking
  - Para ver los resultados, ingresar:
    - {     "username": "Stefano",     "booking": {         "dateFrom": "10/04/2023",         "dateTo": "23/05/2023",         "destination": "Puerto Iguazú",         "hotelCode": "CH-0002",         "peopleAmount": 2,         "roomType": "Double",         "people": [             {                 "dni": 999999999,                 "name": "Robertito",                 "lastname": "Mmmm",                 "birthday": "03/02/2023",                 "mail": "roertito.mmmm@ok.com"             }         ],         "payments": {             "type": "tarjeta de credito",             "number": "1234-1234-1234-1234",             "dues": 99         }     } }

- User Story 4= localhost:8085/api/v1/flights

- User Story 5= localhost:8085/api/v1/flights?dateFrom=10/03/2023&dateTo=15/04/2023&origin=Buenos Aires&destination=Puerto Iguazú
 
- User Story 6= localhost:8085/api/v1/flight-reservation
  - Para ver los resultados, ingresar:
    {
    "userName": "arjonamiguel@gmail.com",
    "flightReservation": {
    "dateFrom": "10/03/2023",
    "dateTo": "15/04/2023",
    "destination": "Buenos Aires",
    "flightNumber": "BOBA-6567",
    "seats": 2,
    "seatType": "ECONOMIC",
    "people": [
    {
    "dni": "12234542",
    "firstName": "Juan",
    "lastName": "Pérez",
    "birthday": "10/11/1982",
    "mail": "arjonamiguel@gmail.com"
    },
    {
    "dni": "13234542",
    "firstName": "Fernando",
    "lastName": "Pérez",
    "birthday": "10/11/1980",
    "mail": "ferl@gmail.com"
    }
    ],
    "paymentMethod": {
    "type": "CREDIT",
    "number": "1234-1234-1234-1234",
    "dues": 6
    }
    }
    }

# Sprint 2

Validaciones y Test

Validaciones: Aplicadas en los Controllers, Service, Repository, y en DTO´s

Test unitarios sin mocks: 5 en fligths, 6 el hotels.

Test unitarios con mocks: 2 en fligths y 2 en hotels. 

Test de Integración: 2 en fligths, 2 en hotels

Total de test: 18
Total de coverage: 87%
