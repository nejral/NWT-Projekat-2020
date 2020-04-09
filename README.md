Mikroservis Racun za aplikaciju HotelEna

- opcije kreiranja, update, i delete racuna 
- sadrzi id(rezervacije, racuna usera), ko ga je kreirao, te datum kreiranja kao i boolean varijablu da li je racun placen ili nije.
- testovi (unit testovi za nevalidne podatke i rezultat greska)
- swagger
- error handling i testiranje
- feign client kao KorisnikClient 
- baza se kreira u mysql workbenchu
- aplikacija HotelEna se pokrene klikom na dugme Run
- pokrene se i Eureka server kako bi mikroservisi komunicirali


Za sinhronu komunikaciju ovdje se moze iz Login mikroservisa poslati id zaposlenika za npr.
pregled svih racuna koje je kreirao taj zaposlenik, za update oznaci sve placene racune kao
paid. Iz Login mikroservisa takodjer se moze poslati id gosta kako bi gost vidio sve svoje racune.
Iz mikroservisa Rezervacija moguce je kreirati i dobiti racun proslijedjivanjem reservationId-a.
