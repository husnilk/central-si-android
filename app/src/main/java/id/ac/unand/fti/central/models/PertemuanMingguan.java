package id.ac.unand.fti.central.models;

public class PertemuanMingguan {
    private int id;
    private int mingguKe;
    private String tanggal;
    private String materi;
    private String deskripsi;
    private int statusHadir;

    public PertemuanMingguan() {
    }

    public PertemuanMingguan(int id, int mingguKe, String tanggal, String materi, String deskripsi, int statusHadir) {
        this.id = id;
        this.mingguKe = mingguKe;
        this.tanggal = tanggal;
        this.materi = materi;
        this.deskripsi = deskripsi;
        this.statusHadir = statusHadir;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMingguKe() {
        return mingguKe;
    }

    public void setMingguKe(int mingguKe) {
        this.mingguKe = mingguKe;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getMateri() {
        return materi;
    }

    public void setMateri(String materi) {
        this.materi = materi;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public int getStatusHadir() {
        return statusHadir;
    }

    public void setStatusHadir(int statusHadir) {
        this.statusHadir = statusHadir;
    }
}
