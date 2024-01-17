package tr.edu.medipol.market.stok;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/stoktakip")
public class stok {

    public record Stok(String Urun, int Stok) {};

    private static final List<Stok> STOK_LISTESI = new ArrayList<>();

    @GetMapping("/")
    public List<Stok> listele(){
        return STOK_LISTESI;
    }

    @GetMapping("/{UrunIsmi}")
    public Stok bul(@PathVariable String UrunIsmi){
        for(Stok stok: STOK_LISTESI) {
            if(stok.Urun().equals(UrunIsmi)) {
                return stok;
            }
        }
        return null;
    }

    @DeleteMapping("/{UrunIsmi}")
    public boolean StokSil(@PathVariable String UrunIsmi) {
        Stok stok = bul(UrunIsmi);
        if (stok != null) {
            STOK_LISTESI.remove(stok);
            System.out.println(STOK_LISTESI); 
            return true;
        }
        return false;
    }


    @PostMapping("/")
    public Stok ekle(@RequestBody Stok stok) {
        STOK_LISTESI.add(stok);
        return stok;
    }
}
