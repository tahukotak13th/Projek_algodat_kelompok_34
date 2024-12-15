public class Tree {
    NodeTree root;

    public void insert(String nama_rental, int pendapatan, NodeLinked list_pegawai) {
        root = insertRec(root, nama_rental, pendapatan, list_pegawai);
    }

    private NodeTree insertRec(NodeTree current, String nama_rental, int pendapatan, NodeLinked list_pegawai) {
        if (current == null) {
            return new NodeTree(nama_rental, pendapatan, list_pegawai);
        }
        if (pendapatan < current.pendapatan) {
            current.left = insertRec(current.left, nama_rental, pendapatan, list_pegawai);
        } else if (pendapatan > current.pendapatan) {
            current.right = insertRec(current.right, nama_rental, pendapatan, list_pegawai);
        } else {
            System.out.println("Pendapatan " + pendapatan + " sudah ada, node tidak ditambahkan.");
        }
        return current;
    }

    public void inOrderTraversal(NodeTree node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.println("Rental: " + node.nama_rental + ", Pendapatan: " + node.pendapatan);
            inOrderTraversal(node.right);
        }
    }

    public void display() {
        inOrderTraversal(root);
    }
}
