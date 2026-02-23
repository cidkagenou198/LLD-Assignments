// Code style adjusted (minor refactor for readability)
public class DisciplinaryFlagRule implements EligibilityRule {
    @Override
    public String check(StudentProfile s) {
        if (s.disciplinaryFlag != LegacyFlags.NONE) return "disciplinary flag present";
        return null;
    }
}
