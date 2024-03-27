import java.util.*;

public class Cart {
  private Map<String, Integer> items;

  public Cart() {
    this.items = new HashMap<>();
  }

  // 상품 추가
  public void addProduct(String productName, int quantity) {
    if (items.containsKey(productName)) {
      int currentQuantity = items.get(productName);
      items.put(productName, currentQuantity + quantity);
    } else {
      items.put(productName, quantity);
    }
  }

  // 상품 제거
  public void removeProduct(String productName, int quantity) {
    if (items.containsKey(productName)) {
      int currentQuantity = items.get(productName);
      if (currentQuantity <= quantity) {
        items.remove(productName);
      } else {
        items.put(productName, currentQuantity - quantity);
      }
    }
  }

  // 장바구니 내용 출력
  public void showItems() {
    System.out.println("장바구니 내용:");
    for (Map.Entry<String, Integer> entry : items.entrySet()) {
      System.out.println(entry.getKey() + " : " + entry.getValue() + "개");
    }
  }
}
