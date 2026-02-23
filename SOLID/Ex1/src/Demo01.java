// Code style adjusted (minor refactor for readability)
public class Demo01 {
    public static void main(String[] args) {
        System.out.println("=== Student Onboarding ===");
        FakeDb database = new FakeDb();
        OnboardingService service = new OnboardingService(database);

        String raw = "name=Riya;email=riya@sst.edu;phone=9876543210;program=CSE";
        service.registerFromRawInput(raw);

        System.out.println();
        System.out.println("-- DB DUMP --");
        System.out.print(TextTable.render3(database));
    }
}
