package Delad;

/**This class/enum consist every category for
 * the user to choose when uploading an add**/

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
