package gradebooktest;

import java.util.Scanner;

public class GradeBookTest {

    public static void main(String[] args) {
        
        Scanner ler = new Scanner (System.in);
        System.out.print("Introduza a qtidades de alunos da turma: ");int n=ler.nextInt();
        int[][] Notas = new int[n][5];
        float n1, n2, proj, media;
        for(int j=0; j<n;j++){
            System.out.print("\nAluno: "+(j+1));
            for(int i=0; i<5;i++){
                System.out.print("\nDisciplina: "+(i+1));
                System.out.print("\n\t1º teste: "); n1 = ler.nextInt();
                System.out.print("\t2º teste: "); n2 = ler.nextInt();
                System.out.print("\tProjeto: "); proj = ler.nextInt();
                media = ((n1+n2+proj)/3);
                Notas[j][i]= (int) Math.ceil(media);
            }
        }
        processarNotas(Notas);
    }
    
    // perform various operations on the data
   public static void  processarNotas(int[][] grades)
   {
      // output grades array
      mostrarNotas(grades);

      // call methods getMinimum and getMaximum
      System.out.printf("%n%s %d%n%s %d%n%n", 
         "Nota mais baixa: ", getMinimum(grades), 
         "Nota mais alta: ", getMaximum(grades));

      // output grade distribution chart of all grades on all tests
      //outputBarChart(grades);
   } 

   // find minimum grade
   public static int getMinimum(int[][] grades)
   { 
      // assume first element of grades array is smallest
      int lowGrade = grades[0][0];

      // loop through rows of grades array
      for (int[] studentGrades : grades) 
      {
         // loop through columns of current row
         for (int grade : studentGrades) 
         {
            // if grade less than lowGrade, assign it to lowGrade
            if (grade < lowGrade)
               lowGrade = grade;
         } 
      } 

      return lowGrade; 
   } 

   // find maximum grade
   public static int getMaximum(int[][] grades)
   { 
      // assume first element of grades array is largest
      int highGrade = grades[0][0];

      // loop through rows of grades array
      for (int[] studentGrades : grades) 
      {
         // loop through columns of current row
         for (int grade : studentGrades) 
         {
            // if grade greater than highGrade, assign it to highGrade
            if (grade > highGrade)
               highGrade = grade;
         }
      }

      return highGrade; 
   } 

   // determine average grade for particular student (or set of grades)
   public static double calcularMedia(int[] setOfGrades)
   {      
      int total = 0; 
 
      // sum grades for one student
      for (int grade : setOfGrades)
         total += grade;

      // return average of grades
      return (double) total / setOfGrades.length;
   }

   // output bar chart displaying overall grade distribution
   public static void outputBarChart(int[][] grades)
   {
      System.out.println("Distribuição das medias:");

      // stores frequency of grades in each range of 10 grades
      int[] frequency = new int[11];
      
      // for each grade in GradeBook, increment the appropriate frequency 
      for (int[] studentGrades : grades)
      {
         for (int grade : studentGrades)
            ++frequency[grade / 10];
      }
      
      // for each grade frequency, print bar in chart
      for (int count = 0; count < frequency.length; count++)
      {
         // output bar label ("00-09: ", ..., "90-99: ", "100: ")
         if (count == 10)
            System.out.printf("%5d: ", 100); 
         else
            System.out.printf("%02d-%02d: ", 
               count * 10, count * 10 + 9); 
         
         // print bar of asterisks
         for (int stars = 0; stars < frequency[count]; stars++)
            System.out.print("*");

         System.out.println(); 
      } 
   } 

   // output the contents of the grades array
   public static void mostrarNotas(int[][] grades)
   {
      System.out.printf("As notas são:%n%n");
      System.out.print("            "); // align column heads

      // create a column heading for each of the tests
      for (int i = 0; i < grades[0].length; i++) 
         System.out.printf("Disciplina %d  ", i + 1);

      System.out.println("Media"); // student average column heading

      // create rows/columns of text representing array grades
      for (int i = 0; i < grades.length; i++) 
      {
         System.out.printf("Aluno %2d", i + 1);

         for (int test : grades[i]) // output student's grades
            System.out.printf("%8d\t\t", test);
         
         double average = calcularMedia(grades[i]);
         System.out.printf("%9.2f%n", average);
      } 
   } 
    
}
