import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class POO_1 {
    
    interface Discountable {
        double calculateDiscount(int percentage);
    }

    static class Producto implements Discountable {
        private int id;
        private String name;
        private double price;
        private int stock;

        public Producto(int id, String name, double price, int stock) {
            this.id = id;
            this.name = name;
            this.price = price;
            this.stock = stock;
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

        public int getStock() {
            return stock;
        }

        public void setPrice(double price) {
            if (price >= 0) {
                 this.price = price;
            }
        }

        public boolean isAvailable() {
            return stock > 0;
        }

        public void increaseStock(int quantity) {
            if(quantity > 0) {
                stock += quantity;
            }
        }

        public boolean decreaseStock(int quantity) {
            if(quantity > 0 && stock >= quantity) {
                stock -= quantity;
                return true;
            }
            return false;
        }

        @Override
        public double calculateDiscount(int percentage) {
            return price - ((price * percentage) / 100);
        }
    }

    public static void main(String[] args) {
        /*Producto product1 = new Producto(1, "Laptop", 999.99, 10);
        product1.increaseStock(5);
        product1.decreaseStock(3);
        product1.setPrice(899.99);
        String available = product1.isAvailable() ? "sí" : "no";
        System.out.println("Nombre producto: " + product1.getName());
        System.out.println("El producto " + product1.getName() + " está disponible: " + available);
        System.out.println("Precio: $" + product1.getPrice() + ", Stock: " + product1.getStock());
        System.out.println("Precio con descuento: $" + product1.calculateDiscount(10));*/

        List<Producto> products = new ArrayList<>();
        Map<Integer, Producto> productsMap = new HashMap<>();
        Producto product1 = new Producto(1, "Laptop", 999.99, 10);
        Producto product2 = new Producto(2, "Mouse", 80.85, 15);
        Producto product3 = new Producto(3, "Tablet", 324.99, 0);
        Producto product4 = new Producto(4, "KeyBoard", 150.99, 5);

        //Agregar con ArrayList
        products.add(product1);
        products.add(product2);
        products.add(product3);

        //Agregar con Map
        productsMap.put(1, product1);
        productsMap.put(2, product2);
        productsMap.put(3, product3);

        Producto productMap = productsMap.get(2);
        System.out.println("Producto obtenido con Map: " + productMap.getName());

        productsMap.put(4, product4);
        productsMap.remove(2);
        System.out.println("Productos con Map: ");
        for (Producto product : productsMap.values()) {
            System.out.println(product.getName());
        }

        double totalMap = calculateInventoryValue(productsMap);
        System.out.println("Total con Map: $" + totalMap);

        Producto productFoundMap = findProductByIdMap(productsMap, 1);
        Producto productNotFound = findProductByIdMap(productsMap, 99);
        if (productFoundMap != null) {
            System.out.println("Producto encontrado con Map: " + productFoundMap.getName());
        }
        
        if(productNotFound == null) {
            System.out.println("Producto con id " + 99 +" no encontrado");
        }

        Producto productFound = findProductById(products, 1);
        if (productFound != null) {
            System.out.println("Producto encontrado: " + productFound.getName());
        }

        System.out.println("Lista de productos con stock: ");
        //List<Producto> listProducts = getProductsWithStock(products);
        List<Producto> listProductsStream = getProductsWithStockStream(products);

        for (Producto product: listProductsStream) {
            System.err.println("Producto: " + product.getName());
        }

        double totalMoney = calculateInventoryValue(products);
        System.out.println("Total: $" + totalMoney);

        getProductNames(products).forEach(nameProduct -> System.out.println("Nombre del producto: " + nameProduct));

        getAvailableProductNames(products).forEach(nameStock -> System.out.println("Nombre del producto con stock: " + nameStock));

    }

    public static Producto findProductById(List<Producto> listProducts, int id) {
       for (Producto product: listProducts) {
        if (product.getId() == id) {
            return product;
        }
       }
       return null;
    }

    public static List<Producto> getProductsWithStock(List<Producto> products){
        List<Producto> productosWithStock = new ArrayList<>();
        for (Producto product: products) {
            if(product.getStock() > 0) {
                productosWithStock.add(product);
            }
        }
        return productosWithStock;
    }

    public static List<Producto> getProductsWithStockStream(List<Producto> products) {
        return products.stream().filter(product -> product.getStock() > 0).collect(Collectors.toList());
    }

    public static double calculateInventoryValue(List<Producto> productos) {
        double sumPrice = 0;

        for ( Producto product: productos) {
            sumPrice += product.getPrice() * product.getStock();
        }
        return sumPrice;
    }

    public static double calculateInventoryValue(Map<Integer, Producto> products) {
        double sumInventory = 0;

        for (Producto product : products.values()) {
            sumInventory += product.getPrice() * product.getStock();
        }
        return sumInventory;
    }

    public static List<String> getProductNames(List<Producto> products) {
        return products.stream()
        .map(Producto::getName)
        .collect(Collectors.toList());
    }

    public static List<String> getAvailableProductNames(List<Producto> products) {
        return products.stream()
        .filter(p -> p.getStock() > 0)
        .map(Producto::getName)
        .collect(Collectors.toList());
    }

    public static Producto findProductByIdMap(Map<Integer, Producto> products, int id) {
        return products.get(id);
    }
}
