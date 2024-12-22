import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Queue rentalQueue = new Queue();
        Scanner scanner = new Scanner(System.in);
        Tree tree = new Tree();
        NestedLinked list_pegawai = new NestedLinked();

        list_pegawai.tambahTempat("rental STRIKE");

        LinkedList rental1 = list_pegawai.cariTempat("rental STRIKE");
        if (rental1 != null) {
            rental1.add_last("yayan", "Owner", 1000);
            rental1.add_last("Anggi", "kasir", 900);
            rental1.add_last("Karina", "penjaga", 800);
            rental1.add_last("Abiyyu", "penjaga", 700);
        }
        tree.insert("rental STRIKE", 5000, rental1);
        tree.display();

        
        int choice;
        do {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("\n========== SISTEM RENTAL ==========");
            System.out.println("1. Kelola Antrean (Queue)");
            System.out.println("2. Kelola Data Pegawai (Linked List)");
            System.out.println("3. Kelola Pohon Data (Tree)");
            System.out.println("4. Keluar");
            System.out.println("===================================");
            System.out.print("Masukkan pilihan Anda (1-4): ");
            choice = scanner.nextInt();
            

            switch (choice) {
                case 1:
                    queueMenu(scanner, rentalQueue);
                    break;
                case 2:
                    NestedLinkedMenu(scanner, list_pegawai);
                    break;
                case 3:
                    treeMenu(scanner, tree,list_pegawai);
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
        System.out.print("\033[H\033[2J");
        System.out.flush();
        do {
            System.out.println("\n========== MENU ANTRIAN RENTAL ==========");
            System.out.println("1. Tambahkan Orang ke Antrean");
            System.out.println("2. Proses Antrean");
            System.out.println("3. Tampilkan Antrean");
            System.out.println("4. Tampilkan Ukuran Antrean");
            System.out.println("5. Kembali ke Menu Utama");
            System.out.println("=========================================");
            System.out.print("Masukkan pilihan Anda: ");
            subChoice = scanner.nextInt();
            scanner.nextLine(); // Membersihkan buffer input

            switch (subChoice) {
                case 1:
                    System.out.print("Masukkan nama: ");
                    String nama = scanner.nextLine();
                    queue.enqueue(nama);
                    System.out.println(nama + " berhasil ditambahkan ke antrean.");
                    break;
                case 2:
                    queue.dequeue();
                    System.out.println("Antrean telah diproses.");
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

    private static void NestedLinkedMenu(Scanner scanner, NestedLinked list_pegawai) {
        int subChoice;

        System.out.print("\033[H\033[2J");
        System.out.flush();
        do {
            System.out.println("\n========== MENU DATA RENTAL ==========");
            System.out.println("1. Pilih Tempat Rental");
            System.out.println("2. Tambah Tempat rental");
            System.out.println("3. Tampilkan Seluruh Data Pegawai");
            System.out.println("4. Kembali ke Menu Utama");
            System.out.println("=======================================");
            System.out.print("Masukkan pilihan Anda: ");
            subChoice = scanner.nextInt();
            scanner.nextLine();

            switch (subChoice) {
                case 1:
                    System.out.print("Masukkan nama tempat rental: ");
                    String tempat = scanner.nextLine();
                    LinkedList rental = list_pegawai.cariTempat(tempat);
                    if (rental != null) {
                        linkedListMenu(scanner, rental);
                    } else {
                        System.out.println("Tempat rental tidak ditemukan!");
                    }
                    break;
                case 2:
                    System.out.print("Masukkan nama tempat rental: ");
                    String tempatbaru = scanner.nextLine();
                    list_pegawai.tambahTempat(tempatbaru);
                    break;
                case 3:
                    list_pegawai.tampilkanSemua();
                    break;
                case 4:
                    System.out.println("Kembali ke menu utama.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (subChoice != 4);
    }

    private static void linkedListMenu(Scanner scanner, LinkedList list) {
        int subChoice;
        System.out.print("\033[H\033[2J");
        System.out.flush();
        do {
            System.out.println("\n========== MENU DATA PEGAWAI ==========");
            System.out.println("1. Tambah Pegawai");
            System.out.println("2. Hapus Pegawai");
            System.out.println("3. Tampilkan Seluruh Pegawai");
            System.out.println("4. Edit Data Pegawai");
            System.out.println("5. Search Berdasarkan Gaji");
            System.out.println("6. Sorting");
            System.out.println("7. Kembali ke Menu Sebelumnya");
            System.out.println("=======================================");
            System.out.print("Masukkan pilihan Anda: ");
            subChoice = scanner.nextInt();
            scanner.nextLine(); // Membersihkan buffer input

            switch (subChoice) {
                case 1:
                    System.out.print("Masukkan nama pegawai: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan posisi pegawai: ");
                    String posisi = scanner.nextLine();
                    System.out.print("Masukkan gaji pegawai: ");
                    int gaji = scanner.nextInt();
                    list.add_last(nama, posisi, gaji);
                    System.out.println("Pegawai berhasil ditambahkan.");
                    break;
                case 2:
                    System.out.print("Masukkan nama pegawai yang ingin dihapus: ");
                    String namaHapus = scanner.nextLine();
                    NodeLinked pegawaidihapus = list.searchPegawai(namaHapus);
                    if (pegawaidihapus != null) {
                        list.delete_mid(namaHapus);
                    } else {
                        System.out.println("Pegawai tidak ditemukan!");
                    }
                    break;
                case 3:
                    list.display();
                    break;
                case 4:
                    System.out.print("Masukkan nama pegawai yang ingin diedit: ");
                    String namaEdit = scanner.nextLine();
                    NodeLinked pegawai = list.searchPegawai(namaEdit);
                    if (pegawai != null) {
                        System.out.print("Atribut yang ingin diedit (nama/posisi/gaji): ");
                        String atribut = scanner.nextLine();
                        System.out.print("Masukkan nilai baru: ");
                        String nilaiBaru = scanner.nextLine();
                        list.editData(pegawai, atribut, nilaiBaru);
                    } else {
                        System.out.println("Pegawai tidak ditemukan!");
                    }
                    break;
                case 5:
                    System.out.println("Masukkan Minimum Gaji yang diinginkan: ");
                    int gaji1 = scanner.nextInt();
                    list.displayPegawaiDenganGajiLebihBesarDari(gaji1);
                    break;
                case 6:
                    list.bubblesorting();
                    list.display();
                    break;
                case 7:
                    System.out.println("Kembali ke menu sebelumnya.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (subChoice != 7);
    }

    // Menu Kelola Tree
    private static void treeMenu(Scanner scanner, Tree tree,NestedLinked list_pegawai) {
        int subChoice;
        System.out.print("\033[H\033[2J");
        System.out.flush();
        do {
            System.out.println("\n========== HIERARKI RENTAL ==========");
            System.out.println("1. Tambahkan Node ke Pohon");
            System.out.println("2. Tampilkan InOrder Traversal");
            System.out.println("3. Kembali Ke menu utama");
            System.out.println("=====================================");
            System.out.print("Masukkan pilihan Anda: ");
            subChoice = scanner.nextInt();
            scanner.nextLine(); // Membersihkan buffer input

            switch (subChoice) {
                case 1:
                    System.out.print("Masukkan nama rental: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan pendapatan rental: ");
                    int pendapatan = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Masukkan list pegawai: ");
                    String namatempat = scanner.nextLine();
                    LinkedList list = list_pegawai.cariTempat(namatempat);
                    tree.insert(nama, pendapatan, list);
                    System.out.println("Pegawai berhasil ditambahkan.");
                    break;
                case 2:
                    tree.display();
                    break;
                case 3:
                    System.out.println("Kembali ke menu sebelumnya.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (subChoice != 3);
    }
}
