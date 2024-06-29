### Run Kafka Cluster

> docker-compose -f common.yml -f kafka.yml up

### Create topics

> docker-compose -f common.yml -f topics.yml up

Will be created 5 topics:
- payment-request
- payment-response
- store-approval-request
- store-approval-response
- customer

