# MC-Java-Microservices

Database is connected to AWS RDS mySql database.

## ports

|service name | ports|
| ---------- | :----:|
|api-gateway | 8765 |
|bills-service | 8000 |
|customer-service | 8081 |
|eureka-naming-server | 8761 |
|payment -service | 8100 |
|spring-cloud-config-server | 8888 |

## APIs

#### Customer API:
/login (POST)
/get-all-customer (GET)
/get-customer/{username} (isaac) (GET)
/register (POST)
/update-details (PUT)

#### Bills API:
/get-bills/{username} (isaac) (GET)
/add-bills (POST)
/paid (PUT)

#### Payment API:
/get-card-details/{username} (GET)
/paid (POST)
/add-card-details (POST)
/remove-card-details/{id} (DELETE)
Things present in these micro services:

#### API gateway
#### naming server
#### spring cloud config serrver

## Swagger Urls
| APIs | url|
|----|:----:|
|bill-service | http://localhost:8000/swagger-ui.html|
|customer-service | http://localhost:8081/swagger-ui.html|
|payment-service | http://localhost:8100/swagger-ui.html|

