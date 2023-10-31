import java.util.Scanner;

public class BioskopWithScanner23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int baris = 0,kolom = 0,opsi = 0;
        String nama,next;

        String[][] penonton = new String[4][2];

        // Saya mengganti null sejak awal karena jika null tidak diubah sejak awal maka setelah case 2 maka case 1 tidak akan bekerja lagi.

        for (int a = 0; a < penonton.length; a++) {
            for (int b = 0; b < penonton[a].length; b++) {
                if (penonton[a][b] == null) {
                    penonton[a][b] = "***";
                }
            }
        }

        while (opsi != 3) {
            System.out.println("Pilih Opsi Menu:\n1. Input data penonton.\n2. Tampilkan daftar penonton.\n3. Exit.");
            opsi = sc.nextInt();
            switch (opsi) {
                case 1:
                    while (true) {
                        System.out.print("Masukkan nama: ");
                        nama = sc.next();
                        System.out.print("Masukkan baris: ");
                        baris = sc.nextInt();
                        System.out.print("Masukkan kolom: ");
                        kolom = sc.nextInt();
                        sc.nextLine();

                        if (baris > penonton.length || kolom > penonton[0].length) {
                            System.out.println("Kursi tidak tersedia.");
                            continue;
                        }

                        if (!penonton[baris - 1][kolom - 1].equalsIgnoreCase("***")) {
                            System.out.println("Kursi telah terisi, isi yang tersedia.");
                            for (int i = 0; i < penonton.length; i++){
                                System.out.println(String.join(", ", penonton[i]));
                            }
                            continue;
                        }

                        penonton[baris - 1][kolom - 1] = nama;


                        System.out.print("input penonton lainnya? (y/n): ");
                        next = sc.nextLine();

                        if (next.equalsIgnoreCase("n")) {
                            break;
                        }
                    }

                    break;
                case 2:
                    System.out.println("Daftar Penonton: ");
                    for (int i = 0; i < penonton.length; i++) {
                        for (int j = 0; j < penonton[i].length; j++){
                            if (penonton[i][j] == null){
                                penonton[i][j] = "***";
                            }
                        }
                        System.out.println("Penonton pada baris ke-" + (i + 1) + ": " + String.join(", ", penonton[i]));
                    }

                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Tolong pilih opsi yang tersedia:");
            }

            
        }
    }
}
