- What are the benefits of using a RESTful API?

Principperne giver en god og let tilgængelig tilgang til at designe og bygge webapplikationer som kan snakke sammen / samarbejde.
Vi har ikke rigtig talt om eksempler som *ikke* er REST, eller hvornår REST *ikke* er smart - så jeg synes det er lidt svært at have noget at sammenligne med.

- What is JSON, and why does JSON fit so well with REST?

JSON er et simpelt sprog/format, som kan bruges til at bygge alle mulige datastrukturer i et simpelt tekstbasert format, som passer godt når vi bruger HTTP-metoder (som REST bruger).


- How you have designed simple CRUD endpoints using spring boot and DTOs to separate api from data  -> Focus on your use of DTO's

Jeg har designet CRUD endpoints så de bruger DTO'erne CarRequest og -response som "versioner" af Car-objekter når de enten skal hentes og vises i Front-end, eller
når de skal sendes tilbage til applikationen - sådan at man kan designe hvilke deler af objektet som skal følge med (i.e. ikke indeholde hemlig eller sensitiv info).
Oprettelse af disse DTO's kan også indeholde parametere som bruges til at bestemme hvilke data som skal følge med i datatransaktionen.

-  What is the advantage of using using DTOs to separate api from data structure when designing rest endpoints

Tror jeg har svaret på dette i spm over.

- Explain shortly the concept mocking in relation to software testing

Jeg er ikke helt sikker, men jeg mener dette bare betyder at man bruger realistisk "dummy"-data til testing, specielt unit-testing, sådan at man ikke er afhængig af at
man kan hente korrekt og opdateret data fra andre deler af softwaren, men kan fokusere på testing af én enkelt unit af gangen.

- How did you mock database access in your tests, using an in-memory database and/or mockito → Refer to your code

Jeg kunne desværre ikke nå at lave Service-tests, men i Repository-tests oprettet jeg simpelthen bare nogle test objekter i en setup vha @BeforeEach annotation.
Jeg er stadig lidt usikker på præcis hvordan vi bruger og hvordan in-memory database defineres til testing

- Explain the concept Build Server and the role Github Actions play here

Build server er en server som bruges til at bygge en ny version af koden som lige er blit commitet til main, og tjekker om koden kan bygges før den deployes.

- Explain maven, relevant parts in maven, and how maven is used in our CI setup. Explain where maven is used by your GitHub Actions Script(s)

Maven definerer hvordan vores projekter er opbygget, håndterer mappestruktur, og forteller os bl.a. hvilke dependencies og plug-ins som bruges. Dette gør at vi kan 
eksportere et helt projekt som en maven-fil og køre det f.eks. via terminalen eller andre steder end vores IDE.
Maven definerer også et projekt i gennem "livscykluser", hele vejen fra compile -> test -> run.

Jeg mener Github Actions prøver at bygge maven projektet ved at køre igennem alle livscykluserne, og dermed bekræfte at projektet kan bygges før det sendes videre til deployment.

-  Understand and chose cloud service models (IaaS, PaaS, SaaS, DBaaS)for your projects -> Just explain what you have used for this handin

Jeg synes det var lidt svært at skille mellem disse modellerne da vi ikke talte så meget om reelle eksempler, men som jeg forstår det bruger vi Azure som en fuld SaaS løsning
da de kører applikationen og holder databasen for os - altså jeg behøver ikke at køre noget selv for at alt skal fungere, alt håndteres af dem.
