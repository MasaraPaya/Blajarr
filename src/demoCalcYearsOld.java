import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class demoCalcYearsOld {
    private int yourBirthYear;

    public int getYourBirthYear() {
        return yourBirthYear;
    }

    public void setYourBirthYear(int yourBirthYear) {
        this.yourBirthYear = yourBirthYear;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        demoCalcYearsOld calcYearsOld = new demoCalcYearsOld();

        System.out.print("Masukan Tahun Kelahiranmu : ");
        int birthYear = scanner.nextInt();
        calcYearsOld.setYourBirthYear(birthYear);

        LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.getYear();

        Period period = Period.between(LocalDate.of(birthYear, 1, 1), LocalDate.of(currentYear, 1, 1));
        int yearsOld = period.getYears();

        System.out.println("Umur Kamu " + yearsOld + " Tahun.");
    }
}
