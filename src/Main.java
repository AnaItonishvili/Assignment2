public class Main {
    public static void main(String[] args) {
        String fileName = "numbers.txt";
        int ArraySize = 10;

        ReadArray array = ReadArray.getInstance(fileName, ArraySize);
        array.WriteInFile();
        int[] arr = array.NumbersFromArray();
        int sum = array.arraySum(arr);
        System.out.println("Sum of numbers: " + sum);
    }
}