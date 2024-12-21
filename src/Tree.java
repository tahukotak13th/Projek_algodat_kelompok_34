public class Tree {
    NodeTree root;
    public void insert(String nama_rental, int pendapatan, LinkedList list_pegawai) {
        root = insertRec(root, nama_rental, pendapatan, list_pegawai);
    }

    private NodeTree insertRec(NodeTree current, String nama_rental, int pendapatan, LinkedList list_pegawai) {
        if (current == null) {
            return new NodeTree(nama_rental, pendapatan, list_pegawai);
        }
        if (pendapatan < current.pendapatan) {
            current.left = insertRec(current.left, nama_rental, pendapatan, list_pegawai);
        } else if (pendapatan >= current.pendapatan) {
            current.right = insertRec(current.right, nama_rental, pendapatan, list_pegawai);
        }
        return current;
    }
    public void inOrderTraversal(NodeTree node) {
        if (node != null) {
            inOrderTraversal(node.left);
    
            // Cetak informasi rental
            System.out.println("Rental: " + node.nama_rental + ", Pendapatan: " + node.pendapatan);
    
            // Cetak daftar pegawai
            System.out.println("Daftar Pegawai:");
            NodeLinked currentPegawai = node.list_pegawai.head;
            if (currentPegawai == null) {
                System.out.println("  Tidak ada pegawai.");
            } else {
                while (currentPegawai != null) {
                    System.out.println("  Nama: " + currentPegawai.nama_pegawai + 
                                       ", Posisi: " + currentPegawai.posisi + 
                                       ", Gaji: " + currentPegawai.gaji);
                    currentPegawai = currentPegawai.next;
                }
            }
    
            inOrderTraversal(node.right);
        }
    }    
    public void display() {
        inOrderTraversal(root);
    }
}
