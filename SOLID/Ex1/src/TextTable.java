// Code style adjusted (minor refactor for readability)
public class TextTable {
    public static String render3(FakeDb database) {
        StringBuilder sb = new StringBuilder();
        sb.append("| ID             | NAME | PROGRAM |\n");
        for (StudentRecord r : database.all()) {
            sb.append(String.format("| %-14s | %-4s | %-7s |\n", r.id, r.name, r.program));
        }
        return sb.toString();
    }
}
