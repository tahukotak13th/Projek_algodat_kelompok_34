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
        LinkedList pegawai_rental1 = new LinkedList();
        pegawai_rental1.add_last("nama_pegawai", "posisi");
        pegawai_rental1.add_last("nama_pegawai2", "posisi2");
        pegawai_rental1.add_last("nama_pegawai3", "posisi3");
        pegawai_rental1.add_last("nama_pegawai4", "posisi4");
        pegawai_rental1.display();

        LinkedList pegawai_rental2 = new LinkedList();
        pegawai_rental2.add_last("nama_pegawai", "posisi");
        pegawai_rental2.add_last("nama_pegawai2", "posisi2");
        pegawai_rental2.add_last("nama_pegawai3", "posisi3");
        pegawai_rental2.add_last("nama_pegawai4", "posisi4");
        pegawai_rental2.display();

        Tree tree = new Tree();
    }
}
