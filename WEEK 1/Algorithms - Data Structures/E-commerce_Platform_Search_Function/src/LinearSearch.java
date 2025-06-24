import java.util.ArrayList;
import java.util.List;

public class LinearSearch {
    public static Product searchById(Product[] products, String productId) {
        for (Product product : products) {
            if (product.getProductId().equals(productId)) {
                return product;
            }
        }
        return null;
    }

    public static List<Product> searchByName(Product[] products, String name) {
        List<Product> results = new ArrayList<>();
        for (Product product : products) {
            if (product.getProductName().contains(name)) {
                results.add(product);
            }
        }
        return results;
    }
}