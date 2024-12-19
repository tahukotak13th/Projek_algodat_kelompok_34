public class LinkedList {
    NodeLinked head;
    NodeLinked tail;

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

    public void delete_mid(String nama_pegawai) {
        if (head == null) {
            System.out.println("tidak ada pegawai");
        } else {
            NodeLinked temp = head;
            while (!temp.nama_pegawai.equals(nama_pegawai)) {
                temp = temp.next;
            }
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
            temp.prev = null;
            temp.next = null;
        }
    }

    public void display() {
        NodeLinked temp = head;
        System.out.println("");
        while (temp != null) {

            System.out.println("Nama : " + temp.nama_pegawai + " Posisi: " + temp.posisi + "Gaji: " + temp.gaji);
            temp = temp.next;
        }
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
