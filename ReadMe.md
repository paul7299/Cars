- The idea with, and reasons for why to use, a ORM-mapper

Ideen er at konvertere data mellem relationelle databaser og objekter i et OOP sprog mere effektivt.
At have kode som er nemmere at arbejde med, samt bedre samhørighed mellem database og app mtp koden. Og vi undgår også masse af overflødig kode.

- The meaning of the terms JPA, Hibernate and Spring Data JPA and how they are connected

JPA er en specifikation som definerer ORM funktionalitet (en standardiseret måde at administrere data i en relationel db i en java app).
Hibernate er en implementering af ORM (eller JPA? dette er forklaret forskellig) 
og giver os funktioner vi kan bruge til at mappe Java-objekter til databaseposter og omvendt.
Spring Data JPA er en del af Spring projektet og hjælper med at effektivisere arbejde med ORM i Java, bl.a. giver
den os Repository interfaces.

- How to create simple Java entities and map them to a database via the Spring Data API

Entity annotion

Id annotation

no arg constructor

- How to control the mapping between individual fields in an Entity class and their matching columns in the database

Man kan bruge @Column annotation for at kontrollere navn, nullable, længde osv

- How to auto generate IDs, and how to ensure we are using  a specific database's preferred way of doing it (Auto Increment in our case for  MySQL)

@Id annotation for ID

@GeneratedValue(strategy = GenerationType.IDENTITY) for at sikre at det er auto increment

- How to use and define repositories and relevant query methods using Spring Data JPAs repository pattern

Repositoryet skal extende JpaRepository<objekt, primærnøgle> og derefter kan man få den til at definere SQL queries ved simpelthen at skrive f.eks.

Object findObjectById(int id);

- How to write simple "integration" tests, using H2 as a mock-database instead of MySQL

Jeg mener at H2 bruger et snapshot af databasen som mock-database hvis man fjerner springs @Test annotation

- How to add (dev) connection details for you local MySQL database

Jeg lagde dem til som environment variabler i edit config via IntelliJ
