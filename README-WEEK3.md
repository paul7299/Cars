- Where and why you have used a @OneToMany annotation

Den er brugt hos Car og Member, da en bil eller bruger kan være del af flere reservationer.

- Where an why you have used a @ManyToOne annotation

I Reservation-klassen ved Member og Car, da mange forskellige Reservationer kan være tilknyttet en bil eller bruger.

- The purpose of the CascadeType, FetchType and mappedBy attributes you can use with one-to-many

mappedBy skal bruges i @OneToMany-siden af forholdet for at angive hvilket felt i den relaterede entitet, 
der skal bruges til at mappe tilbage til den aktuelle entitet.

- How/where you have (if done) added user defined queries to you repositories

  Forstår ikke spørgsmålet. Ja, jeg har lagt til user defined queries, som kan findes i repository interfacerne.

- a few words, explaining what you had to do on your Azure App Service in order to make your Spring Boot App connect to your Azure MySqlDatabase

Ved ikke hvad der fiskes efter her. De er connectet til hinanden..? Dette var også en del af forrige aflevering.

- a few words about where you have used inheritance in your project, and how it's reflected in your database

Vi har opprettet UserWithRoles som extendes af Member. Jeg forstår idéen med hvad det kan bruges til, men det genspejles ikke i databasen,
og vi har heller ikke fået at vide præcist planen er. 

Lige nu kan der oprettes UserWithRole uden member status, men også Member uden UserWithRole status og det giver ikke praktisk mening p.t. ift nogen domænemodel vi har snakket om.
Vi har brugt alt for lidt tid på dette.

- What are the pros & cons of using the Single Table Strategy for inheritance?'


  
- how are passwords stored in the database with the changes suggested in part-6 of the exercise
