package classes.irasai;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Irasas {
    private BigDecimal suma;
    private LocalDate data;
    private final int id;
    private static int i = 0;

    public Irasas(BigDecimal suma, LocalDate data) {
        this.suma = suma;
        this.data = data;
        this.id = i++;
    }

    public BigDecimal getSuma() {
        return suma;
    }

    public LocalDate getData() {
        return data;
    }

    public int getId() {
        return id;
    }

    public void setSuma(BigDecimal suma) {
        this.suma = suma;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Irasas{" +
                "suma=" + suma +
                ", data=" + data +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Irasas irasas = (Irasas) o;
        return id == irasas.id;
    }
}
