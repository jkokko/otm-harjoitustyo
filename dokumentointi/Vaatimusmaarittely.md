# Vaatimusmaarittely otm-harjoitustyolle
## Sovellus lyhyesti

Kyseessä on desktop-sovelluksena toteutettu Sudokupeli. Ohjelma generoi satunnaisen sudokun käyttäjälle, ja pitää kirjaa ratkaisuun käytetystä ajasta. 

## Käyttäjät
On vain yhdenlainen käyttäjä, eli tavallinen pelaaja, jolla on oma käyttäjätunnus. Ennen pelaamistaan pelaaja syöttää 
käyttäjätunnuksen, jolle haluaa ratkaisuun käyttämänsä ajan tallentuvan. Sovellus pitää kirjaa käyttäjän parhaimmista 
ajoista.

## Käyttöliittymäluonnos

Tässä alkuperäinen luonnos kurssin alusta:

![kayttoliittymaluonnos](https://github.com/jkokko/otm-harjoitustyo/blob/master/dokumentointi/kayttoliittymahahmotelma.png)


Lopullinen käyttöliittymä poikkeaa hieman toteutukseltaan. Ohjelma on siinä mielessä yksinkertaisempi, ettei käyttäjää 
tallenneta mihinkään, vaan ennen pelaamista yksinkertaisesti syötetään haluttu käyttäjänimi. Mikäli tuo nimi on ollut 
aiemmin käytössä, tallentuu ajat tuolle samalla nimelle.


## Toiminnallisuus
### Pelaaminen
* Käyttäjälle luodaan satunnainen sudokutehtävä.
* Kello lähtee samalla käyntiin
* Pelaaja täyttää numeroita ruudukkoon hiiren avulla ja näppäimistön avulla
* Peli ei alustavasti tarkista, onko syötetyt luvut sallittuja
* Käyttäjä voi halutessaan keskeyttää pelin luomalla luomalla uuden sudokun, tällöin kello nollaantuu
* Pelaaja voi aloittaa alusta painamalla "Clear" nappulaa. Kello ei nollaudu.
* Peli loppuu, kun pelaaja painaa tarkista nappulaa ja ratkaisu on oikein.

### Pelin loputtua
* Peli näyttää pelaajan omat parhaat ajat sekä parhaat ajat kaikkien käyttäjien kesken
* Peli antaa mahdollisuuden tehdä uusi sudoku

## Jatkokehitysideoita
* Vaativuusalgoritmi generoiduille sudokuille, sekä mahdollisuus valita sudokun vaikeusaste
* Tapa merkitä kandidaattilukuja ruutuun (esim. ruudun ylälaitaan pienellä fontilla)
