public class Node{
    String nama_orang;
    String posisi;
    Node next;
    Node prev;

    public Node(String nama_orang,String posisi){
        this.nama_orang = nama_orang;
        this.posisi = posisi;
        this.next = null;
        this.prev = null;
    }
}
