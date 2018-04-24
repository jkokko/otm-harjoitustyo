# Arkkitehtuurikuvaus

## Luokkarakenne
Pakkaus UI k‰ytt‰‰ sovelluslogiikan sis‰lt‰v‰n pakkauksen domain sis‰lt‰vi‰ luokkia Generator, Solver ja DatabaseService.
DatabaseService puolestaan on riippuvainen UserDao rajapinnan toteuttavasta luokasta.
RedisUserDao on ainoa t‰h‰n koodattu luokka joka sen toteuttaa, ja se k‰ytt‰‰ avain-arvo
tietokantapalvelua Redis. Tietokantaan otetaan yhteys kirjastolla "Jedis".

![Luokkakaavio](https://github.com/jkokko/otm-harjoitustyo/blob/master/dokumentointi/luokkakaavio.png)
