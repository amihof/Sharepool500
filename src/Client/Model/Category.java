package Client.Model;

public enum Category {

    Kategori,
    Bygg_och_verktyg,
    Båt,
    Elektronik,
    Fest,
    Fordon,
    Hem_och_trädgård,
    Sport_och_fritid,
    Övrigt;

    @Override
    public String toString() {
        return name().replaceAll("_", " ");
    }

}
