import java.util.ArrayList;

public class Exercise_11 {

    public static void main(String[] args) {
        Product product1 = new Product(1, "Laptop", 999.99);
        Product product2 = new Product(2, "Smartphone", 599.99);
        Product product3 = new Product(3, "Tablet", 399.99);

        ArrayList<Product> productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);

        Product expensiveProduct = getExpensiveProducts(productList);
        System.out.println("El producto más caro es: " + expensiveProduct.getName() + " con un precio de $" + expensiveProduct.getPrice());
    }
    
    static class Product {
        int id;
        String name;
        double price;

        public Product(int id, String name, double price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }
    }

    public static Product getExpensiveProducts(ArrayList<Product> productList) {
        Product expensiveProduct = productList.get(0);
        double expensivePrice = productList.get(0).getPrice();

        for (Product product : productList) {
            if (product.getPrice() > expensivePrice) {
                expensivePrice = product.getPrice();
                expensiveProduct = product;
            }
        }

        return expensiveProduct;
    }
}
