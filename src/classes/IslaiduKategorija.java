package classes;

public enum IslaiduKategorija {
    MAISTAS(1,"Maistas"),
    KOMUNALINIAI(2,"Komunaliniai"),
    TRANSPORTAS(3,"Transportas");

    int id;
    String name;

    IslaiduKategorija(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static IslaiduKategorija islaiduKategorijaSuID(int id) {
        for (IslaiduKategorija kategorija: values()) {
            if(kategorija.id == id) return kategorija;
        }
        return null;
    }

    public String getName() {
        return name;
    }
}
