import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Queue rentalQueue = new Queue();
        Scanner scanner = new Scanner(System.in);
        Tree tree = new Tree();
        
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


        int choice;
        do {
            System.out.println("========== SISTEM RENTAL ==========");
            System.out.println("1. Kelola Antrean (Queue)");
            System.out.println("2. Kelola Data Pegawai (Linked List)");
            System.out.println("3. Kelola Pohon Data (Tree)");
            System.out.println("4. Keluar");
            System.out.print("Masukkan pilihan Anda (1-4): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    queueMenu(scanner, rentalQueue);
                    break;
                case 2:
                    linkedListMenu(scanner, pegawai_rental1);
                    break;
                case 3:
                    treeMenu(scanner, tree);
                    break;
                case 4:
                    System.out.println("Terima kasih! Keluar dari program.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid, silakan coba lagi!");
            }
        } while (choice != 4);
    }

    // Menu Kelola Queue
    private static void queueMenu(Scanner scanner, Queue queue) {
        int subChoice;
        do {
            System.out.println("\n---- Menu Antrean Rental ----");
            System.out.println("1. Tambahkan Orang ke Antrean");
            System.out.println("2. Hapus Orang dari Antrean");
            System.out.println("3. Tampilkan Antrean");
            System.out.println("4. Tampilkan Ukuran Antrean");
            System.out.println("5. Kembali ke Menu Utama");
            System.out.print("Masukkan pilihan Anda: ");
            subChoice = scanner.nextInt();
            scanner.nextLine(); // Membersihkan buffer input

            switch (subChoice) {
                case 1:
                    System.out.print("Masukkan nama: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan nomor ID: ");
                    String id = scanner.nextLine();
                    queue.enqueue(nama, id);
                    System.out.println("Orang berhasil ditambahkan ke antrean.");
                    break;
                case 2:
                    queue.dequeue();
                    System.out.println("Orang pertama dihapus dari antrean.");
                    break;
                case 3:
                    queue.displayQueue();
                    break;
                case 4:
                    System.out.println("Ukuran antrean: " + queue.getSize());
                    break;
                case 5:
                    System.out.println("Kembali ke menu utama.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (subChoice != 5);
    }

    // Menu Kelola Linked List
    private static void linkedListMenu(Scanner scanner, LinkedList list) {
        int subChoice;
        do {
            System.out.println("\n---- Menu Data Pegawai Rental ----");
            System.out.println("1. Tambahkan Data Pegawai di Akhir List");
            System.out.println("2. Tampilkan Seluruh Data Pegawai");
            System.out.println("3. Edit Data Pegawai");
            System.out.println("4. Kembali ke Menu Utama");
            System.out.print("Masukkan pilihan Anda: ");
            subChoice = scanner.nextInt();
            scanner.nextLine(); // Membersihkan buffer input

            switch (subChoice) {
                case 1:
                    System.out.print("Masukkan nama pegawai: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan posisi pegawai: ");
                    String posisi = scanner.nextLine();
                    list.add_last(nama, posisi);
                    System.out.println("Data pegawai berhasil ditambahkan.");
                    break;
                case 2:
                    list.display();
                    break;
                case 3:
                    System.out.println("Kembali ke menu utama.");
                    break;
                case 4:
                    System.out.print("Masukkan nama pegawai yang ingin diedit: ");
                    String nm = scanner.nextLine();
                    NodeLinked ketemu = list.searchPegawai(nm);
                    if(ketemu == null){
                        System.out.println("Tidak ada pegawai dengan nama itu");
                        break;
                    }
                    System.out.print("Atribut apa yang mau diedit (nama, posisi): ");
                    String atribut = scanner.nextLine();
                    System.out.print("Masukkan isi atribut yang baru: ");
                    String newAtr = scanner.nextLine();
                    list.editData(ketemu, atribut, newAtr);
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (subChoice != 3);
    }

    // Menu Kelola Tree
    private static void treeMenu(Scanner scanner, Tree tree) {
        int subChoice;
        do {
            System.out.println("\n---- Menu Pohon Data Rental ----");
            System.out.println("1. Tambahkan Node ke Pohon");
            System.out.println("2. Tampilkan PreOrder Traversal");
            System.out.println("3. Tampilkan InOrder Traversal");
            System.out.println("4. Tampilkan PostOrder Traversal");
            System.out.println("5. Kembali ke Menu Utama");
            System.out.print("Masukkan pilihan Anda: ");
            subChoice = scanner.nextInt();
            scanner.nextLine(); // Membersihkan buffer input

            switch (subChoice) {
                case 1:
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (subChoice != 5);
    }
}