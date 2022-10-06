package id.ac.unand.fti.central;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import id.ac.unand.fti.central.adapter.KelasAdapter;
import id.ac.unand.fti.central.databinding.ActivityMainBinding;
import id.ac.unand.fti.central.models.Kelas;

//6. Implementasikan Iterface dari Adapter ke Kelas MainActivity
public class MainActivity extends AppCompatActivity implements KelasAdapter.KelasItemClickListener {

    private Boolean isLoggedIn = false;
    private ActivityMainBinding binding;
    RecyclerView rv_kelas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View v = binding.getRoot();
        setContentView(v);

        Intent mainIntent = getIntent();
        String username = mainIntent.getStringExtra("USERX");
        isLoggedIn = mainIntent.getBooleanExtra("LOGX", false);


//        if(isLoggedIn == false) {
//            //Panggil activity login
//            Intent loginIntent = new Intent(this, LoginActivity.class);
//            startActivity(loginIntent);
//            finish();
//        }

        rv_kelas = findViewById(R.id.rv_kelas);

        KelasAdapter adapter = new KelasAdapter();
        adapter.setListKelas(getDummyData());
        adapter.setListener(this);
        rv_kelas.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rv_kelas.setLayoutManager(linearLayoutManager);

    }

    public ArrayList<Kelas> getDummyData(){
       ArrayList<Kelas> listKelas = new ArrayList<>();

       listKelas.add(new Kelas(
          "Pemograman Teknologi Bergerak",
          "Selasa",
          "10:10 - 12:40",
          "H2.3",
          1
       ));
        listKelas.add(new Kelas(
                "Pemograman Web",
                "Rabu",
                "10:10 - 12:40",
                "H2.3",
                0
        ));
        listKelas.add(new Kelas(
                "Pancasila",
                "Rabu",
                "10:10 - 12:40",
                "H2.3",
                1
        ));
        listKelas.add(new Kelas(
                "Pemograman Teknologi Bergerak",
                "Selasa",
                "10:10 - 12:40",
                "H2.3",
                1
        ));
        listKelas.add(new Kelas(
                "Pemograman Teknologi Bergerak",
                "Selasa",
                "10:10 - 12:40",
                "H2.3",
                1
        ));
        listKelas.add(new Kelas(
                "Pemograman Teknologi Bergerak",
                "Selasa",
                "10:10 - 12:40",
                "H2.3",
                1
        ));
        listKelas.add(new Kelas(
                "Pemograman Web",
                "Rabu",
                "10:10 - 12:40",
                "H2.3",
                0
        ));
        listKelas.add(new Kelas(
                "Pancasila",
                "Rabu",
                "10:10 - 12:40",
                "H2.3",
                1
        ));
        listKelas.add(new Kelas(
                "Pemograman Teknologi Bergerak",
                "Selasa",
                "10:10 - 12:40",
                "H2.3",
                1
        ));
        listKelas.add(new Kelas(
                "Pemograman Teknologi Bergerak",
                "Selasa",
                "10:10 - 12:40",
                "H2.3",
                1
        ));
        listKelas.add(new Kelas(
                "Pemograman Teknologi Bergerak",
                "Selasa",
                "10:10 - 12:40",
                "H2.3",
                1
        ));
        listKelas.add(new Kelas(
                "Pemograman Web",
                "Rabu",
                "10:10 - 12:40",
                "H2.3",
                0
        ));
        listKelas.add(new Kelas(
                "Pancasila",
                "Rabu",
                "10:10 - 12:40",
                "H2.3",
                1
        ));
        listKelas.add(new Kelas(
                "Pemograman Teknologi Bergerak",
                "Selasa",
                "10:10 - 12:40",
                "H2.3",
                1
        ));
        listKelas.add(new Kelas(
                "Pemograman Teknologi Bergerak",
                "Selasa",
                "10:10 - 12:40",
                "H2.3",
                1
        ));


       return listKelas;
    }

    @Override
    public void kelasOnClick(Kelas kelas) {
        Intent detailIntent = new Intent(this, DetailKelasActivity.class);
        detailIntent.putExtra("NAMA_KELAS", kelas.getNama());
        startActivity(detailIntent);
    }
}