package classes;

public enum PajamuKategorija {
    PASKOLA(1,"Paskola"),
    ALGA(2,"Alga"),
    INVESTICIJOS(3,"Investicijos"),
    KREDITAS(4,"Kreditas");

    private int id;
    private String name;

    PajamuKategorija(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static PajamuKategorija pajamuKategorijaSuID(int id) {
        for (PajamuKategorija kategorija: values()) {
            if(kategorija.id == id) return kategorija;
        }
        return null;
    }

    public String getName() {
        return name;
    }
}
