public class Queue {
    private Node front; // Node terdepan
    private Node rear;  // Node terbelakang
    private int size;   // Ukuran antrean

    public Queue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    // Menambahkan orang ke antrean
    public void enqueue(String nama_orang, String posisi) {
        Node newNode = new Node(nama_orang, posisi);
        if (rear == null) {
            // Jika antrean kosong
            front = rear = newNode;
        } else {
            // Menambahkan node baru di belakang antrean
            rear.next = newNode;
            newNode.prev = rear;
            rear = newNode;
        }
        size++;
        System.out.println(nama_orang + " telah ditambahkan ke antrean.");
    }

    // Menghapus orang dari antrean
    public void dequeue() {
        if (front == null) {
            System.out.println("Antrean kosong, tidak ada yang bisa dihapus.");
            return;
        }
        System.out.println(front.nama_orang + " telah keluar dari antrean.");
        front = front.next;
        if (front == null) {
            rear = null; // Jika antrean menjadi kosong
        } else {
            front.prev = null;
        }
        size--;
    }

    // Menampilkan antrean
    public void displayQueue() {
        if (front == null) {
            System.out.println("Antrean kosong.");
            return;
        }
        Node current = front;
        System.out.println("Antrean saat ini:");
        while (current != null) {
            System.out.println("Nama: " + current.nama_orang + ", Posisi: " + current.posisi);
            current = current.next;
        }
    }

    // Mendapatkan ukuran antrean
    public int getSize() {
        return size;
    }
}