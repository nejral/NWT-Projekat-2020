# NWT-Projekat-2020

The only active and final branch for login 

Na LoginNew branchu je implementirano:
Mikroservis Login za aplikaciju HotelEna
opcije kreiranja, ažuriranja i brisanja te dobavljanja svih korisnika i traženje po id-u korisnika
dobavljanje rezervacija po idu korisnika koji odgovara datom userId u rezervaciji (sinhrona komunikacija sa Rezervacija ms, dobavljaju se sve rezervacije od gosta)
dobavljanje rezervacije čiji id radnika koji ju je kreirao (createdBy) odgovara datom (sinhrona komunikacija sa Rezervacija ms)
login
dobavljanje racuna koji ima dati userId kao racun za odgovarajuceg gosta (komunikacija sa Racun ms)
dobavljanje racuna koji ima dati userId kao racun za odgovarajuceg zaposlenik (komunikacija sa Racun ms)
 
Placanje racuna gdje se unosi lista ideva svih racuna i izvrsi se njihovo placanje (komunikacija sa Racun ms)
entities: KorisnikEntity
testovi (unit testovi za nevalidne podatke i rezultat greska)
swagger
error handling i testiranje
feign client kao RacunClient
baza se kreira u mysql workbenchu
aplikacija HotelEna se pokrene klikom na dugme Run
pokrene se i Eureka server (EurekaServer branch)  kako bi mikroservisi komunicirali

