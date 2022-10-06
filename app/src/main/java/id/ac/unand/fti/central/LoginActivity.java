package id.ac.unand.fti.central;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import id.ac.unand.fti.central.databinding.ActivityLoginBinding;
import id.ac.unand.fti.central.databinding.ActivityMainBinding;

public class LoginActivity extends AppCompatActivity {

    //1. Deklarasi object
    String username, password;

    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        View v = binding.getRoot();
        setContentView(v);

    }

    public void onLoginButtonClicked(View view) {

        username = binding.textEditUsername.getText().toString();
        password = binding.textEditPassword.getText().toString();

        if(password.equals("123")) {
            Intent mainIntent = new Intent(this, MainActivity.class);
            mainIntent.putExtra("USERX", username);
            mainIntent.putExtra("LOGX", true);
            startActivity(mainIntent);
        }else{
            Toast.makeText(
                    this,
                    "Kombinasi username dan password salah. Silahkan perbanyak amal shaleh",
                    Toast.LENGTH_SHORT).show();
        }
    }

    public void onLupaPasswordClicked(View view) {
        //Implicit Intent
        Intent callIntent = new Intent();
        callIntent.setAction(Intent.ACTION_SEND);
        callIntent.putExtra(Intent.EXTRA_TEXT, "Halo");
        callIntent.setType("text/plain");
        if(callIntent.resolveActivity(getPackageManager()) != null){
            startActivity(callIntent);    
        }else{
            Toast.makeText(this, "Tidak ada aplikasi tersedia", Toast.LENGTH_SHORT).show();
        }
        
    }
}