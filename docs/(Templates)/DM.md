# OO Analysis #

The construction process of the domain model is based on the client specifications, especially the nouns (for _concepts_) and verbs (for _relations_) used. 

## Rationale to identify domain conceptual classes ##
To identify domain conceptual classes, start by making a list of candidate conceptual classes inspired by the list of categories suggested in the book "Applying UML and Patterns: An Introduction to Object-Oriented Analysis and Design and Iterative Development". 


### _Conceptual Class Category List_ ###

**Business Transactions**

* Schedule a vaccine
* Getting the vaccine

---

**Transaction Line Items**

* Vaccine

---

**Product/Service related to a Transaction or Transaction Line Item**

* Vaccine
* SNS number of client
* Administering the vaccine

---


**Transaction Records**

* 
---  


**Roles of People or Organizations**

* Administrator is responsible for properly configuring and managing the core information (e.g.:
  type of vaccines, vaccines, vaccination centers, employees) and can use the
  application to register centers, SNS users, center coordinators, receptionists, and nurses enrolled in
  the vaccination process.
* Nurse is responsible for callin SNS users that are present in the vaccination center to take the vaccine, for administering the vaccine, helping some users schedulling the vaccine
  * Nurses working in the healthcare centers can issue and deliver on site a vaccination certificate whenever a SNS user asks for it.
* Receptionist confirms if the client has the vaccine scheduled for that day and time using his SNS number
* Center Coordinator monitors the vaccination process, to see statistics and charts, to evaluate the performance of the vaccination process, generate reports and
  analyze data from other centers, including data from law systems.


---


**Places**

* Vaccination center
* Healthcare center

---

** Noteworthy Events**

* 

---


**Physical Objects**

* Vaccine

---


**Descriptions of Things**

*  Vaccine - The product that we can inject in our system/bloodstream in order to overcome diseases.


---


**Catalogs**

*  

---


**Containers**

*  

---


**Elements of Containers**

*  

---


**Organizations**

*  DGS

---

**Other External/Collaborating Systems**

*  


---


**Records of finance, work, contracts, legal matters**

* 

---


**Financial Instruments**

*  

---


**Documents mentioned/used to perform some work/**

* 
---



###**Rationale to identify associations between conceptual classes**###

An association is a relationship between instances of objects that indicates a relevant connection and that is worth of remembering, or it is derivable from the List of Common Associations: 

+ **_A_** is physically or logically part of **_B_**
+ **_A_** is physically or logically contained in/on **_B_**
+ **_A_** is a description for **_B_**
+ **_A_** known/logged/recorded/reported/captured in **_B_**
+ **_A_** uses or manages or owns **_B_**
+ **_A_** is related with a transaction (item) of **_B_**
+ etc.



| Concept (A) 		|  Association   	|  Concept (B) |
|----------	   		|:-------------:		|------:       |
| C1  	| verb1    		 	| C2  |
| ...  	| ...    		 	| ...  |



## Domain Model

**Do NOT forget to identify concepts atributes too.**

**Insert below the Domain Model Diagram in a SVG format**

![DM.svg](DM.svg)



