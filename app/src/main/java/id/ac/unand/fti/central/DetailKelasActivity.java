package id.ac.unand.fti.central;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

import id.ac.unand.fti.central.adapter.MingguanAdapter;
import id.ac.unand.fti.central.models.PertemuanMingguan;

public class DetailKelasActivity extends AppCompatActivity implements MingguanAdapter.OnMingguanClickListener{

    RecyclerView rvMingguan;
    TextView textMakul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_kelas);

        rvMingguan = findViewById(R.id.rv_mingguan);

        Intent detailIntent = getIntent();
        String namaKelas = detailIntent.getStringExtra("NAMA_KELAS");

        textMakul = findViewById(R.id.textMakul);
        textMakul.setText(namaKelas);

        MingguanAdapter adapter = new MingguanAdapter();
        adapter.setListPertemuanMingguan(getDummyData());
        adapter.setListener(this); //inject activity ke dalam adapter
        rvMingguan.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvMingguan.setLayoutManager(layoutManager);
    }

    public ArrayList<PertemuanMingguan> getDummyData(){
        ArrayList<PertemuanMingguan> list = new ArrayList<>();

        list.add(new PertemuanMingguan(1, 1, "2022-09-22", "Pengantar Android", "Bla..bla..bla", 1));
        list.add(new PertemuanMingguan(2, 2, "2022-09-22", "Pengantar Activity", "Bla..bla..bla", 0));
        list.add(new PertemuanMingguan(3, 3, "2022-09-22", "Presentasi Desain", "Bla..bla..bla", 1));
        list.add(new PertemuanMingguan(4, 4, "2022-09-22", "Presentasi Activity", "Bla..bla..bla", 1));
        list.add(new PertemuanMingguan(5, 5, "2022-09-22", "View dan Layout", "Bla..bla..bla", 0));
        list.add(new PertemuanMingguan(6, 6, "2022-09-22", "RecyclerView", "Bla..bla..bla", 1));
        list.add(new PertemuanMingguan(1, 1, "2022-09-22", "Pengantar Android", "Bla..bla..bla", 1));
        list.add(new PertemuanMingguan(2, 2, "2022-09-22", "Pengantar Activity", "Bla..bla..bla", 0));
        list.add(new PertemuanMingguan(3, 3, "2022-09-22", "Presentasi Desain", "Bla..bla..bla", 1));
        list.add(new PertemuanMingguan(4, 4, "2022-09-22", "Presentasi Activity", "Bla..bla..bla", 1));
        list.add(new PertemuanMingguan(5, 5, "2022-09-22", "View dan Layout", "Bla..bla..bla", 0));
        list.add(new PertemuanMingguan(6, 6, "2022-09-22", "RecyclerView", "Bla..bla..bla", 1));
        return list;
    }

    @Override
    public void onClick(PertemuanMingguan mingguan) {
        Intent detailMingguanIntent = new Intent(this, DetailPertemuanActivity.class);
        detailMingguanIntent.putExtra("MATERI", mingguan.getMateri());
        startActivity(detailMingguanIntent);
    }
}