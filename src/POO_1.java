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
        Producto product1 = new Producto(1, "Laptop", 999.99, 10);
        product1.increaseStock(5);
        product1.decreaseStock(3);
        product1.setPrice(899.99);
        String available = product1.isAvailable() ? "sí" : "no";
        System.out.println("Nombre producto: " + product1.getName());
        System.out.println("El producto " + product1.getName() + " está disponible: " + available);
        System.out.println("Precio: $" + product1.getPrice() + ", Stock: " + product1.getStock());
        System.out.println("Precio con descuento: $" + product1.calculateDiscount(10));
    }
}
