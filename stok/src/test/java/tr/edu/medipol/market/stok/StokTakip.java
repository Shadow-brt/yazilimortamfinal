package tr.edu.medipol.market.stok;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StokTakip {

    private stok stokController;

    @BeforeEach
    void setUp() {
        stokController = new stok();
    }

    @Test
    void testStokEkle() {
        stok.Stok stok = new stok.Stok("Pirinç", 30);

        // Stok eklenir
        stok.Stok eklenenStok = stokController.ekle(stok);

       
        assertEquals("Pirinç", eklenenStok.Urun());
        assertEquals(30, eklenenStok.Stok());

       
        List<stok.Stok> stokListesi = stokController.listele();
        assertEquals(3, stokListesi.size());
        assertEquals("Pirinç", stokListesi.get(0).Urun());
        assertEquals(10, stokListesi.get(0).Stok());
    }



    @Test
    void testStokListele() {
      
        stok.Stok stok1 = new stok.Stok("Pirinç", 10);
        stok.Stok stok2 = new stok.Stok("Telefon", 20);

       
        stokController.ekle(stok1);
        stokController.ekle(stok2);

        
        List<stok.Stok> stokListesi = stokController.listele();
        assertEquals(2, stokListesi.size());
        assertEquals("Pirinç", stokListesi.get(0).Urun());
        assertEquals(10, stokListesi.get(0).Stok());
        assertEquals("Telefon", stokListesi.get(1).Urun());
        assertEquals(20, stokListesi.get(1).Stok());
    }

    @Test
    void testStokBul() {
        stok.Stok stok1 = new stok.Stok("Bilgisayar", 10);
        stokController.ekle(stok1);
        stok.Stok bulunanStok = stokController.bul("Bilgisayar");
        assertNotNull(bulunanStok);
        assertEquals("Bilgisayar", bulunanStok.Urun());
        assertEquals(10, bulunanStok.Stok());
    }

    @Test
    void testStokSil() {
        
        stok.Stok stok1 = new stok.Stok("Domates", 10);
        stokController.ekle(stok1);
        boolean silmeSonucu = stokController.StokSil("Domates");
        assertTrue(silmeSonucu);
        List<stok.Stok> stokListesi = stokController.listele();
        assertFalse(stokListesi.isEmpty());
    }
    
    
}
