### Prerequisites
1. Java version 8+
2. Maven
3. Java IDE

### Homework
Task 1. Download and install Elasticsearch 8.4.3

Task 2. Run Elasticsearch. Configure and create an index with name "books" containing at least 4 fields: 
id, title, authors (collection of strings), content, language. It is better to use epub format.

Task 3. Create new Java maven project,  add Elasticsearch Java API Client dependency. 

Task 4. Find collection of the books in English language. It is better to use epub format. Using Elasticsearch Java API Client, add at least 100 documents to "books" index. 
The process of indexing could be described as following:
        - Read all books from local folder
        - Use epubreader library (ex. *com.positiondev.epublib*) for transforming from File to EbubBook object
        - Then transform EpubBook to Book model which represent Solr document
        - Save Books to Solr
		
Task 5. Using Elasticsearch Java API Client, compose at least 10 different requests containing proximity, fielded or wildcard queries, retrive results.

