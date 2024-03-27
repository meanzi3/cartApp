import java.io.Serializable;
import java.util.Objects;

/**
 * 상품의 key, 이름, 가격을 필드로 가지고 있습니다.
 * equals() 및 hashCode() 함수를 override 해야합니다. HashSet을 사용할때 중복된 상품이 상품목록에 들어가지 않게 이 함수들이 사용되어야 합니다.
 */
public class Product implements Serializable {
  private static long keyCount = 1L; // key 값을 증가시키기 위한 static 변수
  private long key;
  private String name;
  private int price;

  // Constructor
  public Product(String name, int price) {
    this.key = keyCount++;
    this.name = name;
    this.price = price;
  }

  // equals 및 hashCode override
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Product product = (Product) o;
    return key == product.key;
  }

  @Override
  public int hashCode() {
    return Objects.hash(key);
  }

  public long getKey() {
    return key;
  }

  public String getName() {
    return name;
  }

  public int getPrice() {
    return price;
  }
}
