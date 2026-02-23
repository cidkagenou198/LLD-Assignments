// Code style adjusted (minor refactor for readability)
import java.util.*;

public class StudentValidator {
    private static final Set<String> ALLOWED_PROGRAMS = new HashSet<>(Arrays.asList("CSE", "AI", "SWE"));

    public List<String> validate(Map<String, String> kv) {
        List<String> errors = new ArrayList<>();
        String name = kv != null ? kv.getOrDefault("name", "") : "";
        String email = kv != null ? kv.getOrDefault("email", "") : "";
        String phone = kv != null ? kv.getOrDefault("phone", "") : "";
        String program = kv != null ? kv.getOrDefault("program", "") : "";
        if (name.isBlank()) errors.add("name is required");
        if (email.isBlank() || !email.contains("@")) errors.add("email is invalid");
        if (phone.isBlank() || !phone.chars().allMatch(Character::isDigit)) errors.add("phone is invalid");
        if (!ALLOWED_PROGRAMS.contains(program)) errors.add("program is invalid");

        return errors;
    }
}
