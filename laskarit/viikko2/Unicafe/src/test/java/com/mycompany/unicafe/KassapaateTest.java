package com.mycompany.unicafe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KassapaateTest {
    
    Kassapaate kassa;
    Maksukortti kortti;
    
    @Before
    public void setUp() {
        kassa = new Kassapaate();
        kortti = new Maksukortti(1000);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void konstruktorinLuomaSaldoOnOikein() {
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test
    public void alussaEdullisiaLounaitaMyytyNolla() {
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void alussaMaukkaitaLounaitaMyytyNolla() {
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void kassanSaldoEiMuutuJosKateismaksuEiRiittava() {
        kassa.syoEdullisesti(200);
        kassa.syoMaukkaasti(380);
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test
    public void kassaPalauttaaRahatKunKateismaksuLiianPieni() {
        assertEquals(200, kassa.syoEdullisesti(200));
        assertEquals(380, kassa.syoMaukkaasti(380));
    }
    
    @Test
    public void myytyjenLounaidenMaaraEiMuutuJosKateismaksuEiRiittava() {
        kassa.syoEdullisesti(200);
        kassa.syoMaukkaasti(380);
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void myytyjenLounaidenMaaraKasvaaKunKateismaksuRiittava() {
        kassa.syoEdullisesti(250);
        kassa.syoMaukkaasti(450);
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void kassanSaldoKasvaaOikeinEdullisessaKateisostossa() {
        kassa.syoEdullisesti(300);
        assertEquals(100240, kassa.kassassaRahaa());
    }
    
    @Test
    public void kassanSaldoKasvaaOikeinMaukkaassaKateisostossa() {
        kassa.syoMaukkaasti(450);
        assertEquals(100400, kassa.kassassaRahaa());
    }
    
    @Test
    public void vaihtorahaOikeaEdullisestiKateisostossa() {
        assertEquals(kassa.syoEdullisesti(300), 60);
    }
    
    @Test
    public void vaihtorahaOikeaMaukkaastiKateisostossa() {
        assertEquals(kassa.syoMaukkaasti(450), 50);
    }
    
    //Korttiostojen testaamiseen liittyvät testit:
    
    @Test
    public void korttiostossaSaldoEiMuutu() {
        kassa.syoEdullisesti(kortti);
        kassa.syoMaukkaasti(kortti);
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test
    public void ostoPalauttaaTrueKunKortillaTarpeeksiRahaa() {
        assertEquals(true, kassa.syoMaukkaasti(kortti));
        assertEquals(true, kassa.syoEdullisesti(kortti));
    }
    
    @Test
    public void ostoPalauttaaFalseKunKortillaEiTarpeeksiRahaa() {
        assertEquals(false, kassa.syoMaukkaasti(new Maksukortti(100)));
        assertEquals(false, kassa.syoEdullisesti(new Maksukortti(100)));
    }
    
    @Test
    public void edullinenOstoVeloittaaKortiltaOikein() {
        kassa.syoEdullisesti(kortti);
        assertEquals(760, kortti.saldo());
    }
    
    @Test
    public void maukkaastiOstoVeloittaaKortiltaOikein() {
        kassa.syoMaukkaasti(kortti);
        assertEquals(600, kortti.saldo());
    }
    
    @Test
    public void myytyjenLounaidenMaaraKasvaaYhdella() {
        kassa.syoEdullisesti(kortti);
        kassa.syoMaukkaasti(kortti);
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void kortinSaldoEiMuutuJosMaukkaastiMaksuEpaonnistuu() {
        kassa.syoMaukkaasti(kortti);
        kassa.syoMaukkaasti(kortti);
        kassa.syoMaukkaasti(kortti);
        
        assertEquals(200, kortti.saldo());
    }
    
    @Test
    public void kortinSaldoEiMuutuJosEdullisestiMaksuEpaonnistuu() {
        kassa.syoMaukkaasti(kortti);
        kassa.syoMaukkaasti(kortti);
        kassa.syoEdullisesti(kortti);
        
        assertEquals(200, kortti.saldo());
    }
    
    @Test
    public void myytyjenLounaidenMaaraEiMuutuJosMaksuEpaonnistuu() {
        kassa.syoMaukkaasti(kortti);
        kassa.syoMaukkaasti(kortti);
        //kortilla enää saldoa 200
        
        kassa.syoEdullisesti(kortti);
        kassa.syoMaukkaasti(kortti);
        
        assertEquals(2, kassa.maukkaitaLounaitaMyyty());
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void lataaRahaaLisaaKortinSaldoa() {
        kassa.lataaRahaaKortille(kortti, 100);
        assertEquals(1100, kortti.saldo());
    }
    
    @Test
    public void lataaRahaaLisaaKassanSaldoa() {
        kassa.lataaRahaaKortille(kortti, 100);
        assertEquals(100100, kassa.kassassaRahaa());
    }
    
    @Test
    public void negatiivistaSummaaEiVoiLadataKortille() {
        kassa.lataaRahaaKortille(kortti, -100);
        assertEquals(1000, kortti.saldo());
    }
    
    @Test
    public void negatiivisenSummanLataaminenEiMuutaKassanSaldoa() {
        kassa.lataaRahaaKortille(kortti, -100);
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    
}
