# Supplementary Specification (FURPS+)

## Functionality

_Specifies functionalities that:_

- _are common across several US/UC;_
- _are not related to US/UC, namely: Audit, Reporting and Security._


- Only the nurses are allowed to access all user’s health data;
- Use Javadoc to generate useful documentation for Java code;
- The application's goal is to manage the vaccination process and to allow SNS users to schedule a vaccine and obtain a vaccination certificate;
- There 2 types of vaccination centers: ARS (Administração Regional de Saúde) and AGES (Agrupamentos de Centros de Saúde);
- Both types of vaccination can administer any type of vaccines.
- Nurses working in the healthcare centers can issue and deliver on site a vaccination certificate whenever a SNS user asks for it.
- Furthermore, receptionists and nurses registered in the application will work in the vaccination process
- When SNS user schedules application should check availability of the choosen center
- The application should check the vaccination center capacity for that day/time and, if possible, confirm that the vaccination is scheduled and inform the user that (s)he should be at the selected vaccination center at the scheduled day and time
- Administrators use the application to register centers, SNS users, center coordinators, receptionists, and nurses enrolled in the vaccination process

## Usability 

_Evaluates the user interface. It has several subcategories,
among them: error prevention; interface aesthetics and design; help and
documentation; consistency and standards._

- Both kinds of vaccination centers are characterized by a name, an address, a phone number, an e-mail address, a
fax number, a website address, opening and closing hours, slot duration and the maximum number of vaccines that can be given per slot;
- SNS user schedules vacine online with the following info:
    - SNS number
    - Vacination Center
    - Date And Hour	(LocalDateTime)
    - Type of Vacine (System gives a default vacine that is related to the current outbreak)
    - Authorize DGS to send SMS with information
    - If possible the application should inform the SNS User via SMS (If it's authorized);
- Recepctionist when Sns user goes to get the vaccine:
    - Registers the arrival of SNS user
    - Ask SNS User for number his number
    - Confirm if sns user has vaccine scheduled for the that day and time
    - If information is correct tells the system user is ready to take vacine
    - Sends SNS user to waiting room
    - The computational complexity analysis (of the brute-force algorithm and any sorting algorithms implemented within this application), must be accompanied by the observation of the execution time of the algorithms for inputs of variable size, in order to observe the asymptotic
      behavior.
- The worst-case time complexity analysis of the algorithms should be properly documented in the user manual of the application (in the annexes).
- The user manual must be delivered with the application



## Reliability
_Refers to the integrity, compliance and interoperability of the software. The requirements to be considered are: frequency and severity of failure, possibility of recovery, possibility of prediction, accuracy, average time between failures._




## Performance
_Evaluates the performance requirements of the software, namely: response time, start-up time, recovery time, memory consumption, CPU usage, load capacity and application availability._


(fill in here )

## Supportability
_The supportability requirements gathers several characteristics, such as:
testability, adaptability, maintainability, compatibility,
configurability, installability, scalability and more._ 

- Units tests must implememted for all methods, excluding those that implement Input/Output operations;
- The application must support, at least, the Portuguese and the English languages
- The JaCoCo plugin should be used to generate the coverage report
- All the images/figures produced during the software development process should be recorded in SVG format.
- 


## +

### Design Constraints

_Specifies or constraints the system design process. Examples may include: programming languages, software process, mandatory standards/patterns, use of development tools, class library, etc._


- The application must be developed in Java language using the IntelliJ IDE or NetBeans
- The application graphical interface is to be developed in JavaFX 11
- Users must be authenticated with a password holding seven alphanumeric characters, including three capital letters and two digits
-Types Of Vacinnes:
    - Covid-19
    - Dengue
    - Tetanus
    - smallpox

- After vaccination each nurse registers the event in the system with:
  - vaccine type (e.g.: Covid-19) 
  - vaccine name/brand (e.g.: Astra Zeneca, Moderna, Pfizer) 
  - lot number used  




### Implementation Constraints

_Specifies or constraints the code or construction of a system such
such as: mandatory standards/patterns, implementation languages,
database integrity, resource limits, operating system._


- Information associated with vaccination centers :
  - String name 
  - String adress
  - String email_adress
  - Integer phone_number
  - Integer/String fax_number
  - String website_address
  - LocalTime opening_hours
  - LocalTime closing_hours
  - Integer slot_duration
  - Integer max_vacines
  - String coordinator
- The application should implement a bruteforce algorithm (an algorithm which examines all the contiguous subsequences) to determine the efficency of the vaccination center during  predetermined period of time;
- The implemented algorithm should be analyzed in terms of its worst-case time complexity, and it should be compared to a benchmark algorithm provided;
- 




### Interface Constraints
_Specifies or constraints the features inherent to the interaction of the
system being developed with other external systems._


- If the user authorizes the sending of the SMS, the application should send an SMS message when the vaccination event is scheduled and registered in the system
- The system should be able to notify(e.g.: SMS or email) the user that his/her recovery period has ended

### Physical Constraints

_Specifies a limitation or physical requirement regarding the hardware used to house the system, as for example: material, shape, size or weight._

(fill in here )