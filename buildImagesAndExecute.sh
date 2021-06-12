#!/bin/bash

sudo docker system prune -a
cd infra
sudo docker-compose -f mongo-compose.yml -f common.yml -f kafka_cluster.yml -f user-compose.yml down
sudo docker-compose -f common.yml -f mongo-compose.yml up -d
sudo docker-compose -f common.yml -f kafka_cluster.yml up -d
cd ..
sudo mvn clean install
sudo mvn spring-boot:run
#sudo docker build -t havyx/user-service:latest .
#cd infra
#sudo docker-compose -f common.yml -f user-compose.yml up -d
#cd ..
#sudo docker logs user-service -f
