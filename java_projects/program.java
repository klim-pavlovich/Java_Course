
// // public class program {
// //     public static void main(String[] args) {
// //         // boolean f = 123 >= 234;
// //         // System.out.println(f);
// //         // int a = 8;
// //         // // 1000
// //         // // a = a<<1;
// //         // System.out.println(a << 1);
// //         // // 10000

// //         int a = 18;
// //         //10010
// //         //a = a << 1
// //         System.out.println(a >> 1);
// //         //1001
// //     }
// // }

// // массивы

// /**
//  * program
//  */
// public class program {
//     public static void main(String[] args){

//         // int[] arr = new int[10];
//         // arr[3] = 13;
//         // System.out.println(arr[3]);

//         // arr = new int[] { 1, 2, 3, 4, 5 };
//         // System.out.println(arr.length);


//         // многомерные массивы

//         // int[] arr[] = new int[3][5];
//         // for (int[] line : arr) {
//         //     for (int item : line) {
//         //         System.out.printf("%d", item);
//         //     }
//         //     System.out.println();
//         // }

//         // массивы массивов
//         int[][] arr = new int[3][5];

//         for (int i = 0; i < arr.length; i++){
//             for (int j = 0; j<arr[i].length; j++){
//                 System.out.printf("%d", arr[i][j]);
//             }
//             System.out.println();
//         }
//     }
    
// }


// Сбор данных с ввода
import java.util.Scanner;
public class program {
    public static void main(String[] args){
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("name: ");
        String name = iScanner.nextLine();
        System.out.printf("Привет, %s!\n", name);
        iScanner.close();
    }
    
}