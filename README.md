# NWT-Projekat-2020

Mikroservis Rezervacija za aplikaciju HotelEna

-opcije kreiranja, ažuriranja i brisanja rezervacije 
-dobavljanje rezervacije čiji id korisnika odgovara datom (sinhrona komunikacija sa Login ms)
-dobavljanje rezervacije čiji id radnika koji ju je kreirao (createdBy) odgovara datom (sinhrona komunikacija sa Login ms)
-dobavljanje rezervacije koje nisu vise validne
-sadrzi id (rezervacije, userId, createdBy), datum kreiranja, datume početka i kraja validnosti, fk na sobu i salu.
-entities: RezervacijaEntity, SalaEntity, SobaEntity
-testovi (unit testovi za nevalidne podatke i rezultat greska)
-swagger
-error handling i testiranje
-feign client kao RacunClient
-baza se kreira u mysql workbenchu
-aplikacija HotelEna se pokrene klikom na dugme Run
-pokrene se i Eureka server kako bi mikroservisi komunicirali
