/*
Kod bazowy programu Commit4_0: 
• Program dodaje do prostej bazy danych (pliku db.txt) dane odnośnie Studentów.
• Studenci dodawani są w klasie Main.
• Wszyscy studenci są wypisywani na końcu klasy Main.
• Klasa Service obsługuje odczyt i zapis do pliku bazy danych.
• Klasa Student reprezentuje pojedynczego studenta (Imię, Wiek).
*/

import java.io.IOException;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    try {
      Service s = new Service();
      Scanner scanner = new Scanner(System.in);

      System.out.println("Podaj imię studenta:");
      String name = scanner.nextLine();

      System.out.println("Podaj wiek studenta:");
      int age = scanner.nextInt();

      Student newStudent = new Student(name, age);
      s.addStudent(newStudent);

      System.out.println("\nLista wszystkich studentów:");
      var students = s.getStudents();
      for(Student current : students) {
        System.out.println(current.ToString());
      }

      scanner.close();
    } catch (IOException e) {
      System.out.println("Błąd podczas operacji na pliku: " + e.getMessage());
    }
  }
}
