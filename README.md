# Sudoku

Tässä vaiheessa sovellus luo sudokutehtävän, mutta annettujen numeroiden määrä vaihtelee, ja voi olla lähes tyhjä. Periaatteessa ohjelma tarkistaa, että onko annetulle sudokutehtävälle vain yksi uniikki ratkaisu, mutta toteutus on toistaiseksi vielä pielessä.

Sudokuun voi täyttää numeroita numeronäppäimien avulla, ja backspacella voi poistaa numeron. Check nappula toimii, ja kertoo tekstinä onko annettu ratkaisu oikein. Myös Clear ja New Puzzle nappulat toimivat nyt.

Käyttäjiin liittyvää koodia ei vielä ole. Ainoastaan tyhjiä luokkia.

## Dokumentaatio
[Työaikakirjanpito](https://github.com/jkokko/otm-harjoitustyo/blob/master/dokumentointi/tyoaikakirjanpito.md)

[Vaatimusmäärittely](https://github.com/jkokko/otm-harjoitustyo/blob/master/dokumentointi/Vaatimusmaarittely.md)

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
