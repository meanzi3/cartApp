import java.io.*;
import java.util.*;

public class CartApp {
  public static void main(String[] args) {
    // 상품 목록 생성
    Set<Product> productSet = loadProductsFromFile("products.csv");

    // 상품 목록 확인
    System.out.println("고유한 상품 목록:");
    for (Product product : productSet) {
      System.out.println(product.getName() + " : " + product.getPrice());
    }

    // 장바구니 생성
    Cart myCart = new Cart();

    // 상품을 장바구니에 추가
    myCart.addProduct("우유", 3);
    myCart.addProduct("사과", 3);

    // 상품을 장바구니에서 제거
    myCart.removeProduct("우유", 1);

    // 장바구니에 현재 담긴 상품들을 출력
    myCart.showItems();
  }

  // CSV 파일로부터 상품 목록을 읽어와 Set<Product>으로 반환
  private static Set<Product> loadProductsFromFile(String filename) {
    Set<Product> productSet = new HashSet<>();
    try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
      String line;
      while ((line = br.readLine()) != null) {
        String[] parts = line.split(",");
        String name = parts[0];
        int price = Integer.parseInt(parts[1]);
        productSet.add(new Product(name, price));
      }
    } catch (IOException e) {
      System.err.println("파일을 읽는 중 오류가 발생했습니다: " + e.getMessage());
    }
    return productSet;
  }
}