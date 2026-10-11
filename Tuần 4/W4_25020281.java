import java.util.Scanner;
import java.util.Arrays;

public class W4_25020281 {

  public static void main(String[] args) {
    main2();
  }

  public static void main1(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] bao = new int[n];
    for (int i = 0; i < n; i++) {
      bao[i] = sc.nextInt();
    }

    Arrays.sort(bao);
    int hIndex = 0;
    for (int i = 0; i < n; i++) {
      if (bao[n - i - 1] >= i + 1) {
        hIndex = i + 1;
      } else {
        break;
      }
    }

    System.out.println(hIndex);
    sc.close();

  }

  public static void main2() {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] bao = new int[n];
    
    Arrays.sort(bao);
    for (int i = 0; i < n; i++) {
      bao[i] = sc.nextInt();
    }

    int i = n - 1;
    while (i >= 0 && bao[i] >= n - i) {
      i = i - 1;
    }

    int hIndex = n - i;
    System.out.println(hIndex);
    sc.close();
  }
}
