
public class Student {
  private String name;
  private int age;
  private String lastName;
  private String birthDate;

  public Student(String name, String lastName, int age, String birthDate) {
    this.name = name;
    this.age = age;
    this.lastName = lastName;
    this.birthDate = birthDate;
  }

  public String getName() {return name;}
  public String getLastName() {return lastName;}
  public int getAge() {return age;}
  public String getBirthDate() {return birthDate;}

  public String toString() {
    return name + " " + lastName + " " + Integer.toString(age) + " " + birthDate;
  }

  public static Student parse(String str) {
    String[] data = str.split(" ");
    if (data.length != 4) {
      return new Student("Parse Error", "Parse Error", -1, "Unknown");
    }
    return new Student(data[0], data[1], Integer.parseInt(data[2]), data[3]);
  }
}
