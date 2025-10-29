# 🚗 Vehicle Tracker API (Backend)

This is the Spring Boot backend service for the Vehicle Tracker application. Its sole purpose is to provide a REST API endpoint that serves a hardcoded list of route coordinates (latitude, longitude, and timestamp) for the frontend to consume.

---

## 🛠️ Tech Stack

* **Java 21 ** 
* **Spring Boot 3.x**
* **Spring Web**
* **Maven**

---

## 🚀 API Endpoint

This server exposes a single, unauthenticated API endpoint.

| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `GET` | `/api/route` | Retrieves the hardcoded list of `RoutePoint` objects for the vehicle simulation. |

### Example JSON Response (`GET /api/route`)

```json
[
  {
    "latitude": 17.385044,
    "longitude": 78.486671,
    "timestamp": "2024-07-20T10:00:00Z"
  },
  {
    "latitude": 17.3852,
    "longitude": 78.4868,
    "timestamp": "2024-07-20T10:00:10Z"
  },
  {
    "latitude": 17.38545,
    "longitude": 78.4871,
    "timestamp": "2024-07-20T10:00:20Z"
  }
]