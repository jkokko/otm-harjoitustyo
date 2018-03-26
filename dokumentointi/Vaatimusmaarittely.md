# Vaatimusmaarittely otm-harjoitustyolle
## Sovellus lyhyesti

Kyseessä on desktop-sovelluksena toteutettu Sudokupeli. Ohjelma generoi satunnaisen sudokun käyttäjälle, ja pitää kirjaa ratkaisuun käytetystä ajasta. 

## Käyttäjät
On vain yhdenlainen käyttäjä, eli tavallinen pelaaja, jolla on oma tallennettu tunnus. Ennen pelaamistaan pelaaja tekee uuden käyttäjätunnuksen ellei hänellä sellaista ole, tai sitte kirjautuun omaan vanhaan tunnukseensa. Sovellus pitää kirjaa käyttäjän parhaimmista ajoista.

## Käyttöliittymäluonnos
![kayttoliittymaluonnos]
https://github.com/jkokko/otm-harjoitustyo/blob/master/dokumentointi/kayttoliittymahahmotelma.png


## Toiminnallisuus
### Kirjautuminen
* Jos käyttäjällä ei ole tunnusta, täytyy hänen sellainen tehdä.
** Tunnuksen täytyy olla uniikki
* Käyttäjä kirjautuu omalla tunnuksellaan sisään, salasanaa ei toistaiseksi tarvita.
* Käyttäjät ovat tallennettuna koneen tiedostolle
### Pelaaminen
* Käyttäjälle luodaan satunnainen sudokutehtävä.
* Kello lähtee samalla käyntiin
* Pelaaja täyttää numeroita ruudukkoon hiiren avulla ja näppäimistön avulla
* Peli ei alustavasti tarkista, onko syötetyt luvut sallittuja
* Käyttäjä voi halutessaan keskeyttää pelin luomalla luomalla uuden sudokun
* Pelaaja voi aloittaa alusta painamalla "Clear" nappulaa. Kello ei nollaudu.
* Peli loppuu, kun pelaaja painaa tarkista nappulaa ja ratkaisu on oikein.

### Pelin loputtua
* Peli näyttää pelaajan omat parhaat ajat sekä parhaat ajat kaikkien käyttäjien kesken
* Peli antaa mahdollisuuden tehdä uusi sudoku

## Jatkokehitysideoita
* Vaativuusalgoritmi generoiduille sudokuille, sekä mahdollisuus valita sudokun vaikeusaste
* Tapa merkitä kandidaattilukuja ruutuun (esim. ruudun ylälaitaan pienellä fontilla)
