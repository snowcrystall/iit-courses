package exams.first;

public class PetClient {
   public static void main(String[] args) {
       Pet p1 = new Pet();
       Pet p2 = new Pet("ddd",-1);

       p1.setAge(-2);
       p1.setName("ddd");
       System.out.println(p1.toString());
       System.out.println(p2.toString());
       System.out.println(p1.equals(p2));
   } 
}
