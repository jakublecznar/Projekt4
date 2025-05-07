
import java.io.IOException;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    try {
      Service s = new Service();
      Scanner scanner = new Scanner(System.in);

      boolean tak = true;
      while(tak){
        System.out.println("\nWybierz opcję:");
        System.out.println("1 - Dodaj studenta");
        System.out.println("2 - Wyświetl wszystkich studentów");
        System.out.print("Twój wybór: ");
        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
          case 1:
            System.out.print("Podaj imię studenta: ");
            String name = scanner.nextLine();

            System.out.print("Podaj nazwisko studenta: ");
            String lastname = scanner.nextLine();

            int age = 0;
            boolean validAge = false;
            while (!validAge) {
              System.out.print("Podaj wiek studenta: ");
              try {
                age = Integer.parseInt(scanner.nextLine());
                validAge = true;
              } catch (NumberFormatException e) {
                System.out.println("Wiek musi być liczbą. Spróbuj ponownie.");
              }
            }

            String birthDate;
            boolean validDate = false;
            while (!validDate) {
              System.out.print("Podaj datę urodzenia (DD-MM-YYYY): ");
              birthDate = scanner.nextLine();
              if (birthDate.matches("\\d{2}-\\d{2}-\\d{4}")) {
                String[] dateParts = birthDate.split("-");
                int day = Integer.parseInt(dateParts[0]);
                int month = Integer.parseInt(dateParts[1]);
                int year = Integer.parseInt(dateParts[2]);

                if (month >= 1 && month <= 12 && 
                    day >= 1 && day <= 31 && 
                    year >= 1900 && year <= 2100) {
                  // Dodatkowa walidacja dni w miesiącu
                  boolean validDay = true;
                  if (month == 4 || month == 6 || month == 9 || month == 11) {
                    validDay = day <= 30;
                  } else if (month == 2) {
                    boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
                    validDay = isLeapYear ? day <= 29 : day <= 28;
                  }

                  if (validDay) {
                    validDate = true;
                    s.addStudent(new Student(name, lastname, age, birthDate));
                    break;
                  }
                }
              }
              System.out.println("Nieprawidłowy format daty lub data. Spróbuj ponownie.");
            }
            System.out.println("Dodano studenta.");
            break;

            case 2:
            var students = s.getStudents();
            System.out.println("📋 Lista studentów:");
            for (Student current : students) {
              System.out.println(current.toString());
            }
            break;
        }
      }
      scanner.close();
    } catch (IOException e) {
      System.out.println("Wystąpił błąd: " + e.getMessage());
    }
  }
}