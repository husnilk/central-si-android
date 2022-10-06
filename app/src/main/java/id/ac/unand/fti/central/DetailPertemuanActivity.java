package id.ac.unand.fti.central;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import id.ac.unand.fti.central.databinding.ActivityDetailPertemuanBinding;

public class DetailPertemuanActivity extends AppCompatActivity {

    ActivityDetailPertemuanBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailPertemuanBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent detailMingguanIntent = getIntent();
        String materi = detailMingguanIntent.getStringExtra("MATERI");
        binding.textView2.setText(materi);
    }
}