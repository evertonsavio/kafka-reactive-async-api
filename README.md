### Kafka User API  

---
* Running everything on Docker:
```
Open terminal on root application folder and execute:
 
. buildImagesAndExecute.sh
```
#### Endpoints
  
* REGISTER USER
```json
POST localhost:8080/save-register
{
  "name": "test1",
  "email": "test1@test1",
  "age": 34,
    "address": {
    "street": "rua tal",
    "postalCode": "1280212"
  }
}
```
* GET ALL USERS
```json
GET localhost:8080/list-register
```
* REGISTER MULTIPLE USERS ASYNC WITH KAFKA
```json
POST localhost:8080/save-registers
{
"users":[{
    "name": "kafkaUserTest2",
    "email": "kafkatest3@test2",
    "age": 34,
      "address": {
      "street": "rua tal",
      "postalCode": "1280212"
      }
    },
{
      "name": "kafkaUserTest3",
      "email": "kafkatest3@test3",
      "age": 34,
      "address": {
        "street": "rua tal",
        "postalCode": "1280212"
      }
  }]
}
```
---
#### TODO LIST
```
1. Error Handlers
2. Data Validation Constrains
3. Apache Avro Serializer
```