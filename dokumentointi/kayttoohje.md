# Kayttoohje

## Ennen ohjelman käynnistämistä

Sovellus tarvitsee toimiakseen Redis tietokannan. Sen voi ladata [täältä](https://redis.io/download)
Esimerkiksi stable (4.0.9) versio toimii. Ennen sovelluksen käynnistämistä täytyy tietokanta käynnistää ajamalla mukana 
tuleva redis-server.exe

Sudokun voi ajaa lataamalla 
[jar-tiedoston](https://github.com/jkokko/otm-harjoitustyo/releases/download/viikko7/sudoku-1.0-SNAPSHOT.jar)

## Ohjelman käyttäminen
### Sisäänkirjautuminen

Sovellus avautuu kirjautumisnäkymään. Syötä haluamasi käyttäjänimi.
Tällä hetkellä käyttäjillä ei ole muuta funktiota kuin olla käyttäjäniminä, jotka sitten tallentuvat tietokantaan 
ratkaisuaikojen kanssa. Käytännössä käyttäjät ovat siis kuin merkkijonoja, mutta sisällytin erikseen luokan "User", 
sillä mikäli ohjelmaa haluttaisiin laajentaa olisi se nyt helpompaa.

### Nappuloista

Nappuloiden nimet kertovat aikalailla niiden toiminnallisuuden. Sisällytin nappulan jolla voi "läpäistä" sudokun. Tämä 
nappula on täysin sovelluksen testaamista varten lisätty. Sen avulla voi nyt esimerkiksi eri nimimerkeillä läpäistä 
sudokun eri aikoihin ja seurata tietokannan toimintaa.

Huomautus vielä tietokannasta: parhaissa ajoissa voi yhdellä nimimerkillä olla vain yksi aika, eli oma paras aika. Tämä 
ei ollut aivan tarkoitus ohjelmoida näin, mutta en tuota aiemmin hoksannut että rediksen set ei tosiaan anna tallentaa 
useampaa samaa jäsentä samaan avaimeen.


