# ELK Stack Log Intelligence Module Practical Tasks 

## Quiz
##### Prepare answers to following questions:
    * What is NoSQL?
    * What is Lucene?
    * What is ElasticSearch?
    * What is Analysis?
    * What is Cluster?
    * What is Document?
    * What is Document ID?
    * What is Document Field?
    * What is Filter?
    * What is Index?
    * What is Mapping?
    * What is Node?
    * What is Primary Shard?
    * What is Query?
    * What is Replica Shard?
    * What is Routing?
    * What is Shard?
    * What is Source Field?
    * What is Term?
    * What is Text?
    * What is Type?
## ElasticSearch CRUD Operations Practical Task
##### 1.	Install ElasticSearch 6.5.x+.
##### 2.	Create JSON object that represents information about event. 
    Event object should include following fields: 
    *	title
    *	event type (workshop / tech-talk)
    *	date and time
    *	place
    *	description
    *	list of sub-topics
##### 3.	Store, get, full/partial update, delete document from the elastic using Document REST API. Use some of Rest clients such as Postman Chrome plugin.
##### 4.	Populate documents to ElasticSearch which represent different events. Perform search queries using Search API to select:
    *	all events;
    *	workshop events only;
    *	events with title XXX;
    *	events which were held after date xx-xx-xx and with title XXX;
    *	calculate amount of events for each event type using ElasticSearch aggregations. (Note: use field_name.keyword)
##### 5.	Implement ElasticJavaApiDataProvider which uses Java API client for retrieval of events info.
##### 6.	Implement ElasticJavaRestApiDataProvider which uses REST Service client for retrieval of events info.
##### 7.	Do the following from java code (using both clients):
    *	create new index;
    *	apply new mapping to the previously created index;
    *	create Event class and store JSON representation of user instances into ElasticSearch;
    *	perform search queries to select:
        - all events;
        - workshop events only;
        - events with title XXX;
        - events which were held after date xx-xx-xx and with name XXX;
    Note: Serialize result documents back to Event Java instances.
##### 8.	Delete all events with title NNN (BULK API) in one request.

## Filebeat, Logstash, Kibana Practical Task
##### 1.	Install ElasticSearch 6.5.x+.
##### 2.	Install Logstash 6.5.x+.
##### 3.	Install Kibana 6.5.x+.
##### 4.	Configure event-service Java application to use log4j and log messages using to the file on file system.
##### 5.	Configure Filebeat to read log file and send log messages into the Logstash.
##### 6.	Configure Logstash to read logs from the filebeat (beats input plugin) and send logs to Elasticsearch (elasticsearch logstash output plugin).
##### 7.	Look at result data in the ElasticSearch using Kibana. Task result: application, logstash and filebeat configuration files.

## Logstash Filters Practical Task
##### 1.	Configure event-service Java application to use log4j and log messages using to the file on file system. Log messages should have the following pattern:
    ${MESSAGE_ID} [${UUID} key1="value1" key2="value2" key3="value3" keyN="ValueN"] ${PROCESS_ID} ${COMPONENT_NAME}: ${MESSAGE}
    Example:
    00-00-00000 [c133ee9a7bfa11e6ae2256b6b6499611 app_name="application-name" app_version="1.0.0-SNAPSHOT" hostname="localhost"] 69427d6c966046c58804d7f4128f7505 DataBase: message here
##### 2.	Read all the logs from the file and send them to logstash.
##### 3.	Using Logstash filters parse log messages and extract all the fields specified in the message pattern (result document in the ElasticSearch should contains all of them in the root of log document).
##### 4.	Add ${AUTHOR} field to every log messages using logstash filters. 
##### 5.	If ${MESSAGE} contains keyword "error" - add tag [failed] to this document.

    Note: Use Kibana to make sure logs are properly parsed and contains all required fields.
            Task result: application, filebeat and logstash configuration file.

## References

[Glossary](https://www.elastic.co/guide/en/elasticsearch/reference/current/glossary.html)

[Documents APIs](https://www.elastic.co/guide/en/elasticsearch/reference/current/docs.html)

[Search API](https://www.elastic.co/guide/en/elasticsearch/reference/current/search.html)

[Query DSL Range Query](https://www.elastic.co/guide/en/elasticsearch/reference/current/query-dsl-range-query.html)


[ElasticSearch Reference](https://www.elastic.co/guide/en/elasticsearch/reference/current/index.html)

[Getting Started](https://www.elastic.co/guide/en/elasticsearch/reference/current/getting-started.html)

[Postman plugin](https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop?hl=en)

[Document API](https://www.elastic.co/guide/en/elasticsearch/reference/current/docs.html)


[QUERY DSL](https://www.elastic.co/guide/en/elasticsearch/reference/current/query-dsl.html)

[Aggregations](https://www.elastic.co/guide/en/elasticsearch/reference/current/search-aggregations.html)

[Java API](https://www.elastic.co/guide/en/elasticsearch/client/java-api/current/index.html)

[Rest Java API](https://www.elastic.co/guide/en/elasticsearch/client/java-rest/current/index.html)

[BULK API](https://www.elastic.co/guide/en/elasticsearch/client/java-api/current/java-docs-bulk.html)

[Downloads](https://www.elastic.co/downloads)

[Logstash ](https://www.elastic.co/guide/en/logstash/current/index.html)

[Logstash input plugins](https://www.elastic.co/guide/en/logstash/current/input-plugins.html)

[Logstash output plugins](https://www.elastic.co/guide/en/logstash/current/output-plugins.html)

[Logstash filters](https://www.elastic.co/guide/en/logstash/current/filter-plugins.html)

[Logstash KV filter](https://www.elastic.co/guide/en/logstash/current/plugins-filters-kv.html)

[Logstash mutate filter](https://www.elastic.co/guide/en/logstash/current/plugins-filters-mutate.html)

[Logstash Grok filter](https://www.elastic.co/guide/en/logstash/current/plugins-filters-grok.html)