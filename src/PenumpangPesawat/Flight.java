
package PenumpangPesawat;


public class Flight {
    private Passenger head;

    public Flight() {
        head = null;
    }

    // Menambah penumpang di akhir daftar
    public boolean addPassenger(String name) {
        // Memeriksa apakah penumpang sudah ada
        if (CheckPassenger(name)) {
            return false; // Tidak bisa ditambahkan, sudah ada
        }
        
        Passenger newPassenger = new Passenger(name);
        
        if (head == null) {
            newPassenger.next = head;
            head = newPassenger;
        } else {
            Passenger current = head;
            while (current.next != null) {
                current = current.next;
            }
            newPassenger.next = current.next;
            current.next = newPassenger;
        }
        return true; // Berhasil ditambahkan
    }


    // Menghapus penumpang berdasarkan nama
    public void removePassenger(String name) {
        if (head == null) return;

        if (head.name.equals(name)) {
            head = head.next;
            return;
        }

        Passenger current = head;
        while (current.next != null) {
            if (current.next.name.equals(name)) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    // Menampilkan semua penumpang
    public String displayPassengers() {
        StringBuilder passengers = new StringBuilder();
        Passenger current = head;
        while (current != null) {
            passengers.append(current.name).append("\n");
            current = current.next;
        }
        return passengers.toString();
    }

    // Memeriksa apakah penumpang sudah ada
    private boolean CheckPassenger(String name) {
        Passenger current = head;
        while (current != null) {
            if (current.name.equals(name)) {
                return true; // Penumpang sudah ada
            }
            current = current.next;
        }
        return false; // Penumpang tidak ada
    }
}
