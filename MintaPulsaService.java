import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MintaPulsaService {
    private Set<String> validNumbers = new HashSet<>(); // Simulasi database nomor pelanggan yang valid
    private Map<String, Double> pulsaSaldo = new HashMap<>(); // Menyimpan saldo pulsa masing-masing nomor

    public static void main(String[] args) {
        MintaPulsaService service = new MintaPulsaService();
        service.initializeValidNumbers(); // Inisialisasi data pelanggan
        service.initializeSaldoPulsa(); // Inisialisasi saldo pulsa pelanggan
        service.mintaPulsa(new Scanner(System.in)); // Memulai proses minta pulsa
    }

    // Inisialisasi daftar pelanggan yang valid
    public void initializeValidNumbers() {
        validNumbers.add("081234567890");
        validNumbers.add("081987654321");
        validNumbers.add("081345678912");
        validNumbers.add("081876543219");
        validNumbers.add("081223344556");
    }

    // Inisialisasi saldo pulsa untuk setiap nomor
    public void initializeSaldoPulsa() {
        pulsaSaldo.put("081234567890", 50000.0);
        pulsaSaldo.put("081987654321", 75000.0);
        pulsaSaldo.put("081345678912", 100000.0);
        pulsaSaldo.put("081876543219", 30000.0);
        pulsaSaldo.put("081223344556", 60000.0);
    }

    // Proses minta pulsa
    public void mintaPulsa(Scanner scanner) {
        System.out.print("Masukkan nomor yang akan Anda minta pulsa: ");
        String recipient = scanner.nextLine();

        if (!validNumbers.contains(recipient)) {
            System.out.println(
                    "Maaf, nomor yang Anda masukkan tidak terdaftar. Pastikan Anda memasukkan nomor yang benar.");
            return;
        }

        System.out.print("Masukkan jumlah pulsa yang ingin Anda minta: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Membersihkan buffer

        // Mengecek apakah saldo penerima cukup
        if (amount > 0 && pulsaSaldo.get(recipient) >= amount) {
            System.out.println("Permintaan pulsa sebesar " + amount + " berhasil dikirim ke " + recipient
                    + ". Kami harap permintaan Anda segera dipenuhi.");
            System.out.println(
                    "Saldo pulsa " + recipient + " sekarang: " + (pulsaSaldo.get(recipient) - amount) + " rupiah.");
        } else if (amount <= 0) {
            System.out.println("Jumlah pulsa tidak valid. Silakan coba lagi dengan memasukkan jumlah yang benar.");
        } else {
            System.out.println("Maaf, saldo penerima tidak mencukupi untuk memenuhi permintaan pulsa.");
        }
    }

    public Set<String> getValidNumbers() {
        return validNumbers;
    }

    public void setValidNumbers(Set<String> validNumbers) {
        this.validNumbers = validNumbers;
    }

    public Map<String, Double> getPulsaSaldo() {
        return pulsaSaldo;
    }

    public void setPulsaSaldo(Map<String, Double> pulsaSaldo) {
        this.pulsaSaldo = pulsaSaldo;
    }
}