# KafkaService

- Kafka consumer and producer base code using kafka template
- Requires zookeeper and kafka server
- Uses rest endpoint to publish message to kafka
- Runs on port 8000

# Steps - 
- run zookeeper
  zookeeper-server-start.bat config\zookeeper.properties
  
- run kafka server
  kafka-server-start.bat config\server.properties
  
- Use endpoint to publish message
  http://localhost:8000/kafka/producer/message
  (message accepted as path variable)
  
# Useful commands

- Run Zookeeper
  zookeeper-server-start.bat config\zookeeper.properties
  
- Run Kafka Server
  kafka-server-start.bat config\server.properties
  
- Create kafka topic
  kafka-topics.bat --create --topic topicName --bootstrap-server localhost:9092 --replication-factor 1 --partitions 3
  
- Describe topic
  kafka-topics.bat --bootstrap-server localhost:9092 --topic topicName --describe
  
- Display messages on topic
  kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic topicName --from-beginning
  
- Display consumer group details
  kafka-consumer-groups.bat --bootstrap-server localhost:9092 --group groupName --describe
