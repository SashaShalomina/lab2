import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
public class sasha {
    public static Scanner in = new Scanner(System.in);
    public static PrintStream out = System.out;
    public static void main(String[] args) throws IOException {
        int x = in.nextInt();
        int y = in.nextInt();
        int z = in.nextInt();
        int [][][] masiv = new int [x][y][z];
        for (int i=0; i<masiv.length;i++){
            for (int j=0; j<masiv[i].length;j++){
                for (int p=0;p<masiv[i][j].length;p++){
                    masiv[i][j][p]=in.nextInt();
                }
            }
        }// инициализация

        int [][] masiv1 = new int [x][3];// массив для хранения данных
        
        for (int i=0; i<masiv.length;i++){
            int sum=0;
            int k = 0;
            for (int j=0; j<masiv[i].length;j++){
                for (int p=0;p<masiv[i][j].length;p++){
                    sum+=masiv[i][j][p];
                    if (masiv[i][j][p]%2==0)
                        k++;
                }
            }
            masiv1[i][0]=sum;
            masiv1[i][1]=k;
            masiv1[i][2]=i;
        }// инициализация нового массива

        int osum=0;// переменная для суммы всех элементов

        for (int i=0; i<masiv1.length;i++)
            osum+=masiv1[i][0]; // подсчет суммы всех элементов массива

        out.println("\nсумма всех элементов:");
        out.println(osum);//вывод суммы всех элементов

        for (int i=masiv1.length-1;i>0;i--){
            for (int j =0; j<i;j++){
                if (masiv1[j][0]>masiv1[j+1][0]){
                    int [] t = masiv1[j];
                    masiv1[j]=masiv1[j+1];
                    masiv1[j+1]=t;}
                if (masiv1[j][0]==masiv1[j+1][0]){
                    if (masiv1[j][1]>masiv1[j+1][1]){
                        int [] t = masiv1[j];
                        masiv1[j]=masiv1[j+1];
                        masiv1[j+1]=t;}
                }
            }

        }// сортировка нового массива

        int [][][] masiv2 = new int [x][y][z];//создание финального отсортированного массива

        for (int i= 0;i<masiv1.length;i++)
            masiv2[i]=masiv[masiv1[i][2]];//инициализвция отсортированного массива

        out.println("отосортированный масив в виде среза по оси z");

        for (int i=0; i<z;i++) {
            for (int j = 0; j < x; j++) {
                for (int p = 0; p < y; p++) {
                    out.print(masiv2[j][p][i]+" ");
                }
                out.println();
            }
            out.println();
        }// вывод массива в виде среза по оси z

        for (int i= 0; i<x;i++){
            for (int j=0;j<y;j++){
                for (int p=0;p<z;p++){
                    masiv2[i][j][p]=Math.abs(masiv2[i][j][p]);
                }
            }
        } //замена отрицательных значений на их модуль(т.к значение неотрицательных значений и их модуль равны, то можно просто каждый элемент заменить на его модуль)

        out.println("финальный массив:");

        for (int i=0; i<z;i++) {
            for (int j = 0; j < x; j++) {
                for (int p = 0; p < y; p++) {
                    out.print(masiv2[j][p][i]+" ");
                }
                out.println();
            }
            out.println();
        }// вывод финального массива
    }
}