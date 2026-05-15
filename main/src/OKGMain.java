class Person { }
class Student extends Person { }
class Researcher extends Person { }
class Professor extends Researcher { }

public class OKGMain {
   static void print(Person p) {
      if(p instanceof Person) { System.out.print("Person "); }
      if(p instanceof Student) { System.out.print("Student "); }
      if(p instanceof Researcher) { System.out.print("Researcher "); }
      if(p instanceof Person) { System.out.print("Professor "); }
      System.out.println();
   }

   public static void main(String[] args) {
      System.out.print("new Student() ->\t");
      System.out.println(new Student());
      System.out.print("new Researcher() ->\t");
      System.out.println(new Researcher());
      System.out.print("new Professor() ->\t");
      System.out.println(new Professor());
   }
}
