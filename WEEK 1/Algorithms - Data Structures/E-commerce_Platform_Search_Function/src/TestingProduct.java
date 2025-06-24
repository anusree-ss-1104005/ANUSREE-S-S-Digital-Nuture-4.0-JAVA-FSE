import java.util.Arrays;
import java.util.List;

public class TestingProduct {
    public static void main(String[] args) {
        
        Product[] products = {
            new Product("P100", "Laptop", "Electronics", 999.99),
            new Product("P200", "Smartphone", "Electronics", 699.99),
            new Product("P300", "Headphones", "Electronics", 199.99),
            new Product("P400", "Desk Chair", "Furniture", 249.99)
        };

        
        System.out.println("Linear Search Results:");
        Product found = LinearSearch.searchById(products, "P200");
        System.out.println("Found by ID: " + found);
        
        List<Product> nameResults = LinearSearch.searchByName(products, "Chair");
        System.out.println("Found by name: " + nameResults);

        
        Arrays.sort(products);
        System.out.println("\nBinary Search Results:");
        Product binaryFound = BinarySearch.searchById(products, "P300");
        System.out.println("Found by ID: " + binaryFound);
    }
}