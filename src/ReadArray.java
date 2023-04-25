import java.io.*;
import java.util.Random;

public class ReadArray {
    private static String fileName;
    private static int ArraySize;
    private ReadArray(String filename, int ArraySize){
        this.fileName = filename;
        this.ArraySize = ArraySize;
    }

    public static ReadArray getInstance(String fileName, int ArraySize){
        return new ReadArray(fileName, ArraySize);
    }
    public static void WriteInFile(){
        try {
            Random random = new Random();
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            for (int i = 0; i < ArraySize; i++){
                int random_number = random.nextInt()%41-20;
                writer.write(random_number + "\n");
            }
            writer.close();
        } catch (NumberFormatException e){
            System.out.println("Error : " + e);
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static int[] NumbersFromArray(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            int number = 0;
            int[] arr = new int[ArraySize];
            for (int i = 0; i < ArraySize; i++){
                line = reader.readLine();
                if(line != null) {
                    number = Integer.parseInt(line);
                }
                
                arr[i] = number;
                if (number < 0){
                    throw new InvalidNumberException("Number in file is negative: " + number);
                }

            }
            reader.close();
            return arr;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InvalidNumberException e) {
            throw new RuntimeException(e);
        }
    }

    public static int arraySum(int[] arr){
        int sum = 0;
        try {
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i];
            }
            return sum;
        }catch (ArithmeticException e){
            throw new ArithmeticException("Error!!! Arithmetic Exception");
        }
    }
}
