import java.util.Objects;

public class Notebook {

    int ram;
    int hdd;
    String OS;
    String color;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notebook notebook = (Notebook) o;
        return ram == notebook.ram && hdd == notebook.hdd && Objects.equals(OS, notebook.OS) && Objects.equals(color, notebook.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ram, hdd, OS, color);
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "ram=" + ram +
                ", hdd=" + hdd +
                ", OS='" + OS + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
