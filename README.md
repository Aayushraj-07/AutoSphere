# AutoSphere
AutoSphere: Car Rental Management System

This project is a car rental management system named AutoSphere. It allows users to browse available cars, book cars, and manage their bookings.

Prerequisites:
Java 17 or later
Maven 3.x or Gradle 7.5+
Running the application:
Clone the project repository using Git (replace <url> with the actual repository URL):

bash
Copy code
git clone https://github.com/Aayushraj-07/AutoSphere.git
Navigate to the project directory.

Build the project using Maven:

bash
Copy code
mvn clean package

API Endpoints:

Admin API (Access requires admin role):
GET /api/admin/cars – Get all available cars.
POST /api/admin/car – Add a new car. (Request body: CarDto object)
DELETE /api/admin/car/{id} – Delete a car by ID.
GET /api/admin/car/{id} – Get details of a specific car by ID.
PUT /api/admin/car/{id} – Update details of a car. (Request body: CarDto object with new car details)
GET /api/admin/car/bookings – Get a list of all car bookings.
GET /api/admin/car/booking/{bookingId}/{status} – Change the status of a car booking. (Path variables: bookingId, status) - Possible values for status: "PENDING", "CONFIRMED", "CANCELLED"
POST /api/admin/car/search – Search for cars based on specific criteria. (Request body: SearchCarDto object)

Customer API:

GET /api/customer/cars – Get all available cars.
POST /api/customer/car/book – Book a car. (Request body: BookACarDto object)
GET /api/customer/car/{id} – Get details of a specific car by ID.
GET /api/customer/car/bookings/{userId} – Get a list of a customer's car bookings by user ID.
POST /api/customer/car/search – Search for cars based on specific criteria. (Request body: SearchCarDto object)

Authentication API:

POST /api/auth/signup – Register a new user. (Request body: SignupRequest object)
POST /api/auth/login – Login a user. (Request body: AuthenticationRequest object) – Response includes a JWT token for subsequent API requests.
