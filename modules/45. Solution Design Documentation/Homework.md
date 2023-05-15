# Solution Architecture Documenting Practical Task

## Overview
The task below requires you to design and document a solution using an iterative approach:
* The documentation will include **4 views** and a **decision log**.
* Whenever you create a view 
  * make sure to add a diagram which will carry most of the useful information, keep text to a minimum
  * add a brief comment which describes its purpose - e.g., decompose the system, plan development tasks, plan infrastructure, clarify tech details about component X, etc
  * list the key elements (components) of the view
* Add **decision log records** about any decisions like reference architecture choice, pattern choice, tech choice, etc
* Every decision log record must be created using the template below (but irrelevant parts might be left as N/A)
```
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
```

## Business requirements
Development team is going to elaborate REST Service manipulating Event resource.

Event entity contains following fields:
* id;
* title;
* place;
* speaker;
* eventType;
* dateTime.

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

## Task 1 - context view - 1 point
**RECOMMENDATIONS**
* the systems and actors that interact with the solution
* C4 context diagram is recommended
* no decision log records are expected for this view

## Task 2 - initial design
**RECOMMENDATIONS**
* the sub-tasks below may be done in any order
* but you should start with either a process (C&C) view or a modules (decomposition) view to define the major components and concerns in your solution
* the deployment view is recommended to be done last since you cannot make quality decisions about infrastructure without knowing what’s in your system

### Sub-task 2.1 - modules view - 3 points
**RECOMMENDATIONS**
* packages, data models, layers or whatever comprises the internal structure of the application
* UML class/package/component diagram or an informal diagram with a legend is recommended
* whenever you find that the **business requirements are not precise enough**, keep a list of such gaps - it will be **required for task 2**
* you may keep a decision log per view or have a centralised one
* **optional** - include a decision log record regarding the rationale behind choosing the components and patterns shown on the view

### Sub-task 2.2 - process view - 3 points
**RECOMMENDATIONS**
* a high-level description of the essential data flow through the application
* UML sequence/activity or BPMN diagram is recommended

### Sub-task 2.2 - deployment view - 3 points
**RECOMMENDATIONS**
* a high-level description of the infrastructure required to deploy the application in production
* an informal AWS diagram is recommended
* optional - add a decision log record(s) explaining the infrastructure choices made

## Task 3 - design refinement
### Sub-task 3.1 - covering gaps - 3 points
Given the list of **requirements gaps** obtained while doing task 1
* make your own best guesses about these gaps and document them in the decision log
* just 1-2 sentences with any useful links (case studies, external documentation, articles) are enough per decision

### Sub-task 3.2 - DB choice - 3 points
Add a decision log record which is dedicated to the choice of a DB for your solution
* MySQL DB deployed to on-premises
* AWS RDS (Aurora or MySQL)
* ElasticSearch
