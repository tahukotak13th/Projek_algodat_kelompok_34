public class NestedLinked {
    LinkedList head;

    public void tambahTempat(String tempat) {
        LinkedList newTempat = new LinkedList(tempat);
        if (head == null) {
            head = newTempat;
        } else {
            LinkedList temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newTempat;
        }
    }
    public LinkedList cariTempat(String tempat) {
        LinkedList temp = head;
        while (temp != null) {
            if (temp.tempat.equals(tempat)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public void tampilkanSemua() {
        LinkedList temp = head;
        if (temp == null) {
            System.out.println("Tidak ada tempat.");
        } else {
            
            while (temp != null) {
                System.out.println("");
                System.out.println("Tempat : " + temp.tempat);
                temp.display();
                temp = temp.next;
            }
        }
    }
}
