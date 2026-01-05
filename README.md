# 🎯 About The Project

### This project demonstrates a full-cycle application with CRUD operations, advanced filtering, CSV reporting, and bulk data import, built using Spring Boot.

## **Key Features:**
### 📄 Insurance Policies
* **Lifecycle Management**: Create and update insurance policies linked to specific clients.
* **Validation**: policy numbers remain unique.

### 🔍 Search & Reporting
* **Advanced Filtering**: Search by Client ID, Policy Type, or Policy Number.
* **Pagination**: Efficient handling of large datasets.
* **CSV Exports**: Generate reports based on specific search criteria.

### 📤 Bulk Data Import
* **JSON Upload**: Import multiple policies via a single JSON file.
* **Atomic Processing**: The system processes records individually, tracking success and failure counts.
* **Robust Validation**: Invalid records are skipped and counted without stopping the entire process.

## 🛠 Built With

* **Java 21**
* **Spring boot 3.5.8**
* **Docker** (Docker Compose, Testcontainers)
* **PostgreSQL 15**
* **Liquibase** (SQL Migration)
* **JUnit 5, MockMvc**
* **Lombok** 
* **Gradle**

---

## 🚀 Getting Started

To get a local copy up and running, follow these simple steps.

### 1.  Clone the repository
 ```sh
git clone https://github.com/MaksymPohribnyi/ProfITsoft-spring-rest.git
cd ProfITsoft-spring-rest
```
### 2. Build the project

**Option 1: Docker (Recommended)**

The easiest way to run the application with the database.

```bash
# Build and start services
docker-compose up --build
```
**The API will be available at: http://localhost:8080**

**Option 2: Local Run (Gradle)**
```sh
# Linux/macOS
./gradlew bootRun

# Windows
.\gradlew.bat bootRun
```
**Ensure you have a PostgreSQL database running on port 5433 (or update application.yml)**

## 📡 API Endpoints

### Clients (/api/client)
| Method | Endpoint | Description |
|--------|----------|-------------|
| **GET**|          |Get all clients|
| **POST**|         |Create new client|
| **PUT**|  /{id}   |Update a client|
| **DELETE**| /{id} |Remove a client|


### Insurance Policies (/api/insurance_policy)
| Method | Endpoint | Description |
|--------|----------|-------------|
| **GET**|  /{id}   |Get policy by ID|
| **POST**|         |Create new policy|
| **PUT**|  /{id}   |Update an existing policy|
| **DELETE**| /{id} |Remove a policy|
| **POST**| /_list  |Search: Filter and paginate policies|
| **POST**| /_report |Report: Download filtered CSV report|
| **POST**| /upload |Upload policies via JSON file|

> **A sample JSON file for testing the `/upload` endpoint is included in the project resources:**
`src/main/resources/upload/import.json`

## 🌐 API Reference

### Client Base URL: http://localhost:8080/api/client

### 1. Get Clients

**Example Request**

```bash
#Linux/macOS/Windows
curl http://localhost:8080/api/client
```

**Example Response**

```json
[
  {
    "id": "11111111-0000-0000-0000-000000000001",
    "firstName": "Taras",
    "lastName": "Shevchenko",
    "email": "taras.sheva@ua.net"
  },
  {
    "id": "11111111-0000-0000-0000-000000000002",
    "firstName": "Lesya",
    "lastName": "Ukrainka",
    "email": "lesya.ukr@ua.net"
  },
  {
    "id": "11111111-0000-0000-0000-000000000007",
    "firstName": "Lina",
    "lastName": "Kostenko",
    "email": "lina.kost@ua.net"
  },
  {
    "id": "11111111-0000-0000-0000-000000000003",
    "firstName": "Ivan",
    "lastName": "Franko",
    "email": "ivan.franko@ua.net"
  },
  {
    "id": "11111111-0000-0000-0000-000000000004",
    "firstName": "Bogdan",
    "lastName": "Khmelnytsky",
    "email": "bogdan.khm@ua.net"
  },
  {
    "id": "11111111-0000-0000-0000-000000000005",
    "firstName": "Hryhorii",
    "lastName": "Skovoroda",
    "email": "hryhorii.skov@ua.net"
  },
  {
    "id": "11111111-0000-0000-0000-000000000006",
    "firstName": "Mykhailo",
    "lastName": "Hrushevsky",
    "email": "mykhailo.hru@ua.net"
  },
  {
    "id": "11111111-0000-0000-0000-000000000008",
    "firstName": "Serhii",
    "lastName": "Zhadan",
    "email": "serhii.zhadan@ua.net"
  }
]
```

### 2. Create Client

**Example Request**

```bash
#Linux/macOS
curl -X POST http://localhost:8080/api/client \
  -H "Content-Type: application/json" \
  -d '{
    "firstName": "Іван",
    "lastName": "Петренко",
    "email": "ivan@example.com"
  }'
```

```bash
#Windows CMD
curl -X POST http://localhost:8080/api/client ^
-H "Content-Type: application/json" ^
-d "{\"firstName\":\"Іван\",\"lastName\":\"Петренко\",\"email\":\"ivan@example.com\"}"
```

**Example Response**

```json
{
  "id": "ea51fe07-61cd-42d1-9e56-38e3367a6dbe",
  "firstName": "Іван",
  "lastName": "Петренко",
  "email": "ivan@example.com"
}
```

### 3. Update Client

**Example Request**

```bash
#Linux/macOS
curl -X PUT http://localhost:8080/api/client/ea51fe07-61cd-42d1-9e56-38e3367a6dbe \
  -H "Content-Type: application/json" \
  -d '{
    "firstName": "ІванUpd",
    "lastName": "ІвановUpd",
    "email": "ivan.new@example.com"
  }'
```

```bash
#Windows CMD
curl -X PUT http://localhost:8080/api/client/ea51fe07-61cd-42d1-9e56-38e3367a6dbe ^
-H "Content-Type: application/json" ^
-d "{\"firstName\":\"ІванUpd\",\"lastName\":\"ІвановUpd\",\"email\":\"ivan.new@example.com\"}"
```

**Example Response**

```json
{
  "id": "ea51fe07-61cd-42d1-9e56-38e3367a6dbe",
  "firstName": "ІванUpd",
  "lastName": "ІвановUpd",
  "email": "ivan.new@example.com"
}
```

### 4. Remove Client

**Example Request**

```bash
#Linux/macOS/Windows
curl -X DELETE http://localhost:8080/api/client/ea51fe07-61cd-42d1-9e56-38e3367a6dbe
```

**Example Response**

```http
HttpStatus: 204 No Content
```

### Insurance Policies Base URL: http://localhost:8080/api/insurance_policy

### 1. Get Policy

**Example Request**

```bash
#Linux/macOS/Windows
curl http://localhost:8080/api/insurance_policy/22222222-0000-0000-0000-000000000001
```

**Example Response**

```json
{
  "id": "22222222-0000-0000-0000-000000000001",
  "policyNumber": "POL-AUTO-001",
  "policyType": "AUTO",
  "startDate": "2024-01-01",
  "endDate": "2025-01-01",
  "coveredRisks": [
    "ACCIDENT",
    "THEFT"
  ],
  "client": {
    "id": "11111111-0000-0000-0000-000000000001",
    "firstName": "Taras",
    "lastName": "Shevchenko",
    "email": "taras.sheva@ua.net"
  }
}
```

### 2. Create Policy

**Example Request**

```bash
#Linux/macOS
curl -X POST http://localhost:8080/api/insurance_policy \
  -H "Content-Type: application/json" \
  -d '{
    "policyNumber": "POL-2026-001",
    "policyType": "Health Insurance",
    "startDate": "2026-02-01",
    "endDate": "2027-02-01",
    "coveredRisks": ["Medical", "Hospital"],
    "clientId": "11111111-0000-0000-0000-000000000001"
  }'
```

```bash
#Windows CMD
curl -X POST http://localhost:8080/api/insurance_policy ^
-H "Content-Type: application/json" ^
-d "{\"policyNumber\":\"POL-2026-001\",\"policyType\":\"Health Insurance\",\"startDate\":\"2026-02-01\",\"endDate\":\"2027-02-01\",\"coveredRisks\":[\"Medical\",\"Hospital\"],\"clientId\":\"11111111-0000-0000-0000-000000000001\"}"
```

**Example Response**

```json
{
  "id": "04b34093-aa3d-4f2f-bf69-9c14f22cf480",
  "policyNumber": "POL-2026-001",
  "policyType": "Health Insurance",
  "startDate": "2026-02-01",
  "endDate": "2027-02-01",
  "coveredRisks": [
    "Medical",
    "Hospital"
  ],
  "client": {
    "id": "11111111-0000-0000-0000-000000000001",
    "firstName": "Taras",
    "lastName": "Shevchenko",
    "email": "taras.sheva@ua.net"
  }
}
```

### 3. Update Policy

**Example Request**

```bash
#Linux/macOS
curl -X PUT http://localhost:8080/api/insurance_policy/04b34093-aa3d-4f2f-bf69-9c14f22cf480 \
  -H "Content-Type: application/json" \
  -d '{
    "policyType": "Health Insurance Premium",
    "startDate": "2026-12-01",
    "endDate": "2027-12-01",
    "coveredRisks": ["Medical", "Hospital", "Surgery"],
    "clientId": "11111111-0000-0000-0000-000000000001"
  }'
```

```bash
#Windows CMD
curl -X PUT http://localhost:8080/api/insurance_policy/04b34093-aa3d-4f2f-bf69-9c14f22cf480 ^
-H "Content-Type: application/json" ^
-d "{\"policyType\":\"Health Insurance Premium\",\"startDate\":\"2026-12-01\",\"endDate\":\"2027-12-01\",\"coveredRisks\":[\"Medical\",\"Hospital\",\"Surgery\"],\"clientId\":\"11111111-0000-0000-0000-000000000001\"}"
```

**Example Response**

```json
{
  "id": "04b34093-aa3d-4f2f-bf69-9c14f22cf480",
  "policyNumber": "POL-2026-001",
  "policyType": "Health Insurance Premium",
  "startDate": "2026-12-01",
  "endDate": "2027-12-01",
  "coveredRisks": [
    "Medical",
    "Hospital",
    "Surgery"
  ],
  "client": {
    "id": "11111111-0000-0000-0000-000000000001",
    "firstName": "Taras",
    "lastName": "Shevchenko",
    "email": "taras.sheva@ua.net"
  }
}
```

### 4. Remove Policy

**Example Request**

```bash
#Linux/macOS/Windows
curl -X DELETE http://localhost:8080/api/insurance_policy/04b34093-aa3d-4f2f-bf69-9c14f22cf480
```

**Example Response**

```http
HttpStatus: 204 No Content
```

