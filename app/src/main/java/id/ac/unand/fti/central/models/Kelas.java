package id.ac.unand.fti.central.models;

public class Kelas {
    String nama;
    String hari;
    String waktu;
    String ruang;
    int statusHadir;

    public Kelas() {}

    public Kelas(String nama, String hari, String waktu, String ruang, int statusHadir) {
        this.nama = nama;
        this.hari = hari;
        this.waktu = waktu;
        this.ruang = ruang;
        this.statusHadir = statusHadir;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getHari() {
        return hari;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public String getRuang() {
        return ruang;
    }

    public void setRuang(String ruang) {
        this.ruang = ruang;
    }

    public int getStatusHadir() {
        return statusHadir;
    }

    public void setStatusHadir(int statusHadir) {
        this.statusHadir = statusHadir;
    }
}
