public class LinkedList {
    String tempat;
    LinkedList next;
    NodeLinked head;
    NodeLinked tail;

    public LinkedList(String tempat){
        this.tempat = tempat;
        this.head = null;
        this.next = null;
    }

    public void add_last(String nama_pegawai, String posisi, int gaji) {
        NodeLinked newnode = new NodeLinked(nama_pegawai, posisi, gaji);
        if (head == null) {
            head = newnode;
            tail = newnode;
        } else {
            newnode.prev = tail;
            tail.next = newnode;
            tail = newnode;
        }
    }
    public void display() {
        NodeLinked temp = head;
        while (temp != null) {

            System.out.println("Nama : " + temp.nama_pegawai + " Posisi: " + temp.posisi + " Gaji: " + temp.gaji);
            temp = temp.next;
        }
    }
    

    public void delete_mid(String nama_pegawai) {
        if (head == null) {
            System.out.println("List kosong");
            return;
        }
    
        NodeLinked temp = head;
        // Traverse the list to find the node to delete
        while (temp != null && !temp.nama_pegawai.equals(nama_pegawai)) {
            temp = temp.next;
        }
    
        if (temp == null) {
            System.out.println("Pegawai dengan nama " + nama_pegawai + " tidak ditemukan");
            return;
        }
    
        // If node is the first one
        if (temp == head) {
            head = temp.next;
            if (head != null) {
                head.prev = null;
            }
        }
        // If node is the last one
        else if (temp == tail) {
            tail = temp.prev;
            if (tail != null) {
                tail.next = null;
            }
        }
        // If node is in the middle
        else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
    
        System.out.println(temp.nama_pegawai + " berhasil dihapus");
        temp.prev = null;
        temp.next = null;
    }
    


    public NodeLinked searchPegawai(String nama) {
        NodeLinked curr = head;
        while (curr != null) {
            if (curr.nama_pegawai.equals(nama)) {
                return curr;
            }
            curr = curr.next;
        }
        return null;
    }

    public void editData(NodeLinked node, String atr, String dataBaru) {
        if (atr.equals("nama")) {
            node.nama_pegawai = dataBaru;
        }
        if (atr.equals("posisi")) {
            node.posisi = dataBaru;
        }
        if (atr.equals("gaji")) {
            node.posisi = dataBaru;
        }
    }

    public void displayPegawaiDenganGajiLebihBesarDari(int batasMinimum) {
        NodeLinked temp = head;
        System.out.println("Pegawai dengan gaji lebih dari " + batasMinimum + ":");
        while (temp != null) {
            if (temp.gaji > batasMinimum) {
                System.out.println("Nama: " + temp.nama_pegawai + ", Posisi: " + temp.posisi + ", Gaji: " + temp.gaji);
            }
            temp = temp.next;
        }
    }
    public void bubblesorting(){
        if (head == null) return; 

        boolean swapped;
        do {
            swapped = false;
            NodeLinked current = head;
            while (current.next != null) {
                if (current.gaji > current.next.gaji) {
                    String tempNama = current.nama_pegawai;
                    String tempPosisi = current.posisi;
                    int tempGaji = current.gaji;

                    current.nama_pegawai = current.next.nama_pegawai;
                    current.posisi = current.next.posisi;
                    current.gaji = current.next.gaji;

                    current.next.nama_pegawai = tempNama;
                    current.next.posisi = tempPosisi;
                    current.next.gaji = tempGaji;

                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }
}
