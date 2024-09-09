# SIP-Attendance-Management-System
## API Endpoints

### Add or Update Attendance
- **URL:** `/api/attendance`
- **Method:** `POST`
- **Description:** Adds or updates attendance records.
- **Request Body:**
  ```json
  {
    "studentId": 1,
    "date": "2024-09-07",
    "fnAttendance": true,
    "anAttendance": false
  }
  
### Get Attendance by Advisor
- **URL:** `/api/attendance/advisor/{advisorId}/{date}`
- **Method:** `GET`
- **Description:**  Retrieves attendance records by advisor ID and date.
- **Path Variables:**
+ advisorId (Long): ID of the advisor.
+ date (String): Date of the attendance record in YYYY-MM-DD format.
- **Responses:**
+ 200 OK: Returns a list of attendance records.
+ 404 Not Found: No attendance records found.

### Get Attendance by Mentor
- **URL:** `/api/attendance/mentor/{mentorId}/{date}`
- **Method:** GET
- **Description:** Retrieves attendance records by mentor ID and date.
- **Path Variables:**
+ mentorId (Long): ID of the mentor.
+ date (String): Date of the attendance record in YYYY-MM-DD format.
- **Responses:**
+ 200 OK: Returns a list of attendance records.
+ 404 Not Found: No attendance records found.