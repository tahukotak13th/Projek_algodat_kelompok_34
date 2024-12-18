public class NodeLinked{
    String nama_pegawai;
    String posisi;
    int gaji;
    NodeLinked next;
    NodeLinked prev;

    public NodeLinked(String nama_pegawai,String posisi, int gaji){
        this.nama_pegawai = nama_pegawai;
        this.posisi = posisi;
        this.gaji = gaji;
        this.next = null;
        this.prev = null;
    }
}
