import java.io.*; 

class Lab1_Java {
 public static void main(String args[]){

 for (String string : args) {
            System.out.println(""+string);
        }

     Console cnsl = System.console();
     String name = cnsl.readLine("Enter you name: ");
     System.out.println("Hello " + name);
 }
}