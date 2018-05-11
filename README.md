# Sudoku

Sovellus luo sudokutehtävän, jolle on vain yksi uniikki ratkaisu.

Sovellus tallentaa parhaat ajat tietokantaan sisään kirjautuneen käyttäjän nimellä.


## Dokumentaatio
[Työaikakirjanpito](https://github.com/jkokko/otm-harjoitustyo/blob/master/dokumentointi/tyoaikakirjanpito.md)

[Vaatimusmäärittely](https://github.com/jkokko/otm-harjoitustyo/blob/master/dokumentointi/Vaatimusmaarittely.md)

[Arkkitehtuuri](https://github.com/jkokko/otm-harjoitustyo/blob/master/dokumentointi/arkkitehtuuri.md)

[Käyttöohje](https://github.com/jkokko/otm-harjoitustyo/blob/master/dokumentointi/kayttoohje.md)


## Komentorivitoiminnot

### Testaus
```
mvn test
```

### Testikattavuusraportti

```
mvn jacoco:report
``` 

raportti löytyy tiedostosta targer/site/jacoco/index.html

### Jarin generointi
```
mvn package
``` 

luo suoritettavan tiedoston target/sudoku-1.0-SNAPSHOT.jar

### Checkstyle
voit tarkistaa checkstyle raportin ajamalla

```
mvn jxr:jxr checkstyle:checkstyle
```

ja avaamalla tiedoston target/site/checkstyle.html
