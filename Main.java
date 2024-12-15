public class Main {
    public static void main(String[] args) {
        Queue rentalQueue = new Queue();
        
        // Menambahkan beberapa orang ke antrean
        rentalQueue.enqueue("Alice", "1");
        rentalQueue.enqueue("Bob", "2");
        rentalQueue.enqueue("Charlie", "3");
        
        // Menampilkan antrean
        rentalQueue.displayQueue();
        
        // Menghapus orang dari antrean
        rentalQueue.dequeue();
        
        // Menampilkan antrean setelah penghapusan
        rentalQueue.displayQueue();
        
        // Menampilkan ukuran antrean
        System.out.println("Ukuran antrean: " + rentalQueue.getSize());
    }
}