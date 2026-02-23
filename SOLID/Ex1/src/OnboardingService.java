import java.util.*;

public class OnboardingService {
    private final StudentRepository repo;
    private final StudentInputParser parser;
    private final StudentValidator validator;
    private final RegistrationPrinter printer;

    public OnboardingService(StudentRepository repo) {
        this.repo = repo;
        this.parser = new StudentInputParser();
        this.validator = new StudentValidator();
        this.printer = new RegistrationPrinter();
    }

    public void registerFromRawInput(String raw) {
        printer.printInput(raw);
        Map<String, String> kv = parser.parse(raw);
        List<String> errors = validator.validate(kv);
        if (!errors.isEmpty()) {
            printer.printErrors(errors);
            return;
        }
        String name = kv.getOrDefault("name", "");
        String email = kv.getOrDefault("email", "");
        String phone = kv.getOrDefault("phone", "");
        String program = kv.getOrDefault("program", "");

        String id = IdUtil.nextStudentId(repo.count());
        StudentRecord rec = new StudentRecord(id, name, email, phone, program);
        repo.save(rec);
        printer.printSuccess(id, repo.count(), rec);
    }
}
