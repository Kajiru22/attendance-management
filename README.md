# attendance-management

This is the backend of a web application to track attendance and for creating reports.

## Configuration

The application's configuration is stored in the `application.yml` file. The following are the key settings:

* `server.port`: The port that the application will listen on.
* `spring.datasource.url`: The URL of the MySQL database.
* `spring.datasource.username`: The username for the MySQL database.
* `spring.datasource.password`: The password for the MySQL database.
* `spring.jpa.hibernate.ddl-auto`: The mode for creating or updating the database schema.

## Roles

The application has three roles: ROLE_ADMIN, ROLE_EMPLOYEE, and ROLE_STUDENT. The following are the permissions for each role:

* `ROLE_ADMIN`: Can create, delete, and list all employees and students.
* `ROLE_EMPLOYEE`: Can create, delete, and list all students, create reports, confirm attendance records, and search for students by name.
* `ROLE_STUDENT`: Can create attendance records and upload absence confirmations.

## Installation

To install the application, follow these steps:

1. Clone the repository to your local machine.
2. Create a MySQL database and import the `attendance-management.sql` file.
3. Configure the application's settings in the `application.yml` file.
4. Start the application by running the following command:


mvn spring-boot:run
```

## Usage

The application can be accessed at the following URL:

```
http://localhost:9100/
```

## Classes

The application uses the following classes to store data in the database:

* **StudentSheet**
    * username: The username of the student.
    * firstName: The first name of the student.
    * lastName: The last name of the student.
    * svnr: The social security number of the student.
    * attendance: A list of attendance records for the student.
* **Attendance**
    * date: The date of the attendance record.
    * startTime: The start time of the attendance record.
    * endTime: The end time of the attendance record (optional).
    * confirmed: A boolean value that indicates whether the attendance record has been confirmed.
    * absenceConfirmation: An optional string that contains an absence confirmation.
* **Person**
    * username: The username of the person.
    * password: The password of the person.
* **Report**
    * firstName: The first name of the student.
    * lastName: The last name of the student.
    * svnr: The social security number of the student.
    * attendance: A list of attendance records for the week.
```