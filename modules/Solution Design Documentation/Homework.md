# Solution Architecture Documenting Practical Task 

##### Elaborate Decision Log capturing design considerations for following use case: (2 points)
 ```
Development team is goign to elaborate REST Service manipulating Event resource.

Event entity contains following fields:
    *   id;
    *   title;
    *   place;
    *   speaker;
    *   eventType;
    *   dateTime.

Team leader should choos the most suitable data storage implementation for REST Service providing following functionality:
    * CRUD operations
    * Filtering
    * Search
    * Sorting
    * Aggregation by specified field value

Data storage for REST service should provide support multi-tenant content storage.
Instance of storage service should host several independent databases with tenant specific content.
Data Storage should be provide calculation of query against 100 000 000 entries within ~700ms.
Data storage for Legal Analytics service should provide automated data backup every 30 days.
Event Model to Data Storage Schema mapping complexity should be minimized.
Cloud provider should be consistent.
Data storage should provide detailed logging for troubleshooting and process verification.
Hosting and maintenance pricing should be optimal.

Use Amazon Web Services Cloud Provider deployment distributed between regions following regions: eu-west, eu-east.
```
 
##### Decision Log page should contain following sections: (3 points)
    a.   Title
    b.   Status
    c.   Background
    d.   Glossary
    e.   Functional requirements
    f.   Non-functional requirements
    g.   Constraints
    h.   Quality attributes
    i.   Solution Options
     ```
        - MySQL DB deployed to on-premis
        - AWS RDS Aurora MySQL DB
        - ElasticSearch NoSQL storage 
     ```
    j.   Decision criteria
    k.   Decision
    l.   Sources
    m.   Tickets
    n.   References
   
Note: data storage options could be changed depending on mentors advice. The main goal is to have comparison.    

## References
[C4 Model](https://c4model.com/)
[C4 Architecture Model](https://www.infoq.com/articles/C4-architecture-model/)
[What is Data Flow Diagram](https://www.visual-paradigm.com/guide/data-flow-diagram/what-is-data-flow-diagram/)
[Ensure the Team has learnt and understand the solution](https://kb.epam.com/display/EPMEAGA/%5BEAG%5D%5BEng.%5D%5BAssets%5D%5BRECOs%5D+Ensure+the+Team+has+learnt+and+understand+the+solution) 
[MySQL DB](https://www.oracle.com/technetwork/database/mysql/index.html)     
[ElasticSearch](https://www.elastic.co/products/elasticsearch/features)     
[AWS RDS Aurora MySQL](https://docs.aws.amazon.com/AmazonRDS/latest/AuroraUserGuide/Aurora.AuroraMySQL.html)
