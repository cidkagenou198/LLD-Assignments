// Code style adjusted (minor refactor for readability)
public interface InvoiceStore {
    void save(String name, String content);
    int countLines(String name);
}
