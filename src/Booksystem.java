import java.util.Scanner;

public class Booksystem {
    private String nama; //atribut nama dengan tipe data String
    private String noTelp; //atribut noTelp dengan tipe data String
    private String alamat; //atribut alamat dengan tipe data String
    private String email; //atribut email dengan tipe data String

    private int[][] room = { //atribut room berupa array multidimensi dengan tipe data int
            {0, 101, 150000},
            {1, 102, 200000},
            {0, 103, 250000},
            {1, 104, 300000},
    };

    //method setter dan getter untuk atribut nama
    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    //method setter dan getter untuk atribut noTelp
    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public String getNoTelp() {
        return noTelp;
    }

    //method setter dan getter untuk atribut alamat
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getAlamat() {
        return alamat;
    }

    //method setter dan getter untuk atribut email
    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    //method getter untuk atribut room
    public int[][] getRoom() {
        return room;
    }

    //method untuk menginisialisasi atribut nama, noTelp, alamat, dan email dengan memanggil setter atributnya
    public void init() {
        Scanner sc = new Scanner(System.in);

        //input nama dengan validasi hanya huruf
        System.out.print("Masukkan nama: ");
        String nama = sc.nextLine();
        while (!nama.matches("[a-zA-Z ]+")) {
            System.out.print("Nama hanya boleh terdiri dari huruf dan spasi. Masukkan nama: ");
            nama = sc.nextLine();
        }
        setNama(nama);

        //input noTelp dengan validasi format +kodeNegara(nomorTelepon)
        System.out.print("Masukkan nomor telepon: ");
        String noTelp = sc.nextLine();
        while (!noTelp.matches("\\+\\d{12,13}")) {
            System.out.print("Format nomor telepon salah. Masukkan nomor telepon: ");
            noTelp = sc.nextLine();
        }
        setNoTelp(noTelp);

        //input alamat
        System.out.print("Masukkan alamat: ");
        String alamat = sc.nextLine();
        setAlamat(alamat);

        //input email dengan validasi domain yang valid
        System.out.print("Masukkan email: ");
        String email = sc.nextLine();
        while (!email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
            System.out.print("Format email salah. Masukkan email: ");
            email = sc.nextLine();
        }
        setEmail(email);
    }

    //method untuk menampilkan atribut identitas yang telah diinisialisasi dengan memanggil getter atributnya
    public void dispPerson() {
        System.out.println("Nama : " + getNama());
        System.out.println("Nomor Telepon : " + getNoTelp());
        System.out.println("Alamat : " + getAlamat());
        System.out.println("Email : " + getEmail());
    }


    //method untuk memesan kamar dengan parameter noKamar
    public void bookRoom() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Daftar Kamar Tersedia");
        System.out.println("----------------------");
        System.out.println("No Kamar\tHarga\tStatus");
        for (int i = 0; i < room.length; i++) {
            System.out.println(room[i][1] + "\t\t" + room[i][2] + "\t" + (room[i][0] == 0 ? "Tersedia" : "Tidak Tersedia"));
        }


        System.out.print("Masukkan No. Kamar yang Ingin Dipesan     : ");
        int noKamar = scanner.nextInt();
        noKamar -= 101;

        if (noKamar < 0 || noKamar >= room.length) {
            System.out.println("No. Kamar yang Dimasukkan Tidak Valid");
            bookRoom();
            return;
        }

        if (room[noKamar][0] == 1) {
            System.out.println();
            System.out.println("Kamar yang Dipilih Tidak Tersedia");
            System.out.println("Silahkan memilih kamar yang tersedia dibawah!");
            bookRoom();
            return;


        }

        System.out.println("Kamar dengan No. " + room[noKamar][1] + " Berhasil Dipesan");
        doPayment(noKamar);
    }


    public void doPayment(int noRoom) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pembayaran kamar " + room[noRoom][1]);
        System.out.println("Harga                   : " + room[noRoom][2]);
        System.out.println();
        System.out.print("Masukkan jumlah uang    : ");
        int payment = scanner.nextInt();
        if (payment < room[noRoom-1][2]) {
            System.out.println("Maaf pembayaran kurang");
            System.out.println("======================");
            doPayment(noRoom);
        } else {
            room[noRoom-1][0] = 1;
            System.out.println("Pembayaran berhasil");
        }
    }



    //contoh penggunaan kelas BookSystem
    public static void main(String[] args) {
        Booksystem bs = new Booksystem();
        bs.init(); //inisialisasi data personal
        bs.dispPerson(); //tampilkan data personal
        bs.bookRoom(); //tampilkan daftar kamar
    }
}