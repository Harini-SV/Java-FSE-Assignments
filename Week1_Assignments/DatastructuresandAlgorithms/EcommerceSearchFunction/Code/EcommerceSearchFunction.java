import java.util.*;

public class EcommerceSearchFunction {

    // Product class
    static class Product {
        int productId;
        String productName;
        String category;

        Product(int productId, String productName, String category) {
            this.productId = productId;
            this.productName = productName.toLowerCase();
            this.category = category.toLowerCase();
        }

        public String toString() {
            return "Product[ID=" + productId + ", Name=" + productName + ", Category=" + category + "]";
        }
    }

    // Linear Search
    public static Product linearSearch(Product[] products, String targetName) {
        for (Product product : products) {
            if (product.productName.equalsIgnoreCase(targetName)) {
                return product;
            }
        }
        return null;
    }

    // Binary Search (products must be sorted by name)
    public static Product binarySearch(Product[] products, String targetName) {
        int left = 0;
        int right = products.length - 1;
        targetName = targetName.toLowerCase();

        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = products[mid].productName.compareTo(targetName);

            if (cmp == 0) return products[mid];
            else if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return null;
    }

    // Main method
    public static void main(String[] args) {
        Product[] products = {
            new Product(101, "Shoes", "Footwear"),
            new Product(102, "T-Shirt", "Apparel"),
            new Product(103, "Laptop", "Electronics"),
            new Product(104, "Watch", "Accessories")
        };

        // Sort for binary search
        Arrays.sort(products, Comparator.comparing(p -> p.productName));

        String searchTerm = "Laptop";

        System.out.println(" Linear Search:");
        Product found1 = linearSearch(products, searchTerm);
        System.out.println(found1 != null ? found1 : "Product not found.");

        System.out.println("\n Binary Search:");
        Product found2 = binarySearch(products, searchTerm);
        System.out.println(found2 != null ? found2 : "Product not found.");

        // Analysis
        System.out.println("\n Time Complexity:");
        System.out.println("Linear Search: O(n)");
        System.out.println("Binary Search: O(log n) (requires sorted array)");
    }
}


