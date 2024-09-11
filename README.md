# Attendance System TKM

## Overview
This project is an attendance management system for TKM.

## Endpoints

### Attendance Endpoints

- **Get Attendance by Department and Date**
  - **URL**: `/api/attendance/department/{departmentId}/{date}`
  - **Method**: GET
  - **Description**: Retrieves attendance records for a specific department on a given date.
  - **Parameters**:
    - `departmentId` (String): The ID of the department.
    - `date` (String): The date for which attendance is to be retrieved (format: `yyyy-MM-dd`).

- **Get Attendance by Mentor Group and Date**
  - **URL**: `/api/attendance/group/{group}/{date}`
  - **Method**: GET
  - **Description**: Retrieves attendance records for a specific mentor group on a given date.
  - **Parameters**:
    - `group` (String): The mentor group number.
    - `date` (String): The date for which attendance is to be retrieved (format: `yyyy-MM-dd`).

- **Update Attendance**
  - **URL**: `/api/attendance`
  - **Method**: PATCH
  - **Description**: Updates attendance records for a specific department on a given date.
  - **Parameters**:
    - `departmentId` (String): The ID of the department.
    - `date` (String): The date for which attendance is to be updated (format: `yyyy-MM-dd`).
    - `fnAttendance` (Boolean): Forenoon attendance status.
    - `anAttendance` (Boolean): Afternoon attendance status.
  - **Request Body:**
  ```json
  {
    "studentId": 1,
    "date": "2024-09-07",
    "fnAttendance": true,
    "anAttendance": false
  }

