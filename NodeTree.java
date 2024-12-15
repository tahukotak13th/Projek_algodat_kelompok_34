public class NodeTree{
    String nama_rental;
    int pendapatan;
    NodeTree left,right;
    NodeLinked list_pegawai;
    public NodeTree(String nama_rental,int pendapatan,NodeLinked list_pegawai) {
        this.nama_rental = nama_rental;
        this.pendapatan = pendapatan;
        this.list_pegawai = list_pegawai;
        this.left = null;
        this.right = null;
    }
    
}