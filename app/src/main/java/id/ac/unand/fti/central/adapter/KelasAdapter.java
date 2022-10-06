package id.ac.unand.fti.central.adapter;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import id.ac.unand.fti.central.DetailKelasActivity;
import id.ac.unand.fti.central.R;
import id.ac.unand.fti.central.models.Kelas;

public class KelasAdapter extends RecyclerView.Adapter<KelasAdapter.KelasViewHolder> {



    // 2 Tambahkan properti dengan tipe Interface dalam kelas Adapter
    KelasItemClickListener listener;
    ArrayList<Kelas> listKelas = new ArrayList<Kelas>();

    public void setListKelas(ArrayList<Kelas> listKelas) {
        this.listKelas = listKelas;
        notifyDataSetChanged();
    }

    // 3. Set object listener
    public void setListener(KelasItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public KelasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_kelas, parent, false);

        return new KelasViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KelasViewHolder holder, int position) {
        Kelas data = listKelas.get(position);
        holder.textKelas.setText(data.getNama());
        String jadwal = data.getHari() + " / " + data.getWaktu()  + " @ " + data.getRuang();
        holder.textJadwal.setText(jadwal);
        if(data.getStatusHadir() == 0){
            holder.imageStatus.setImageResource(R.drawable.ic_cancel);
        }else{
            holder.imageStatus.setImageResource(R.drawable.ic_check);
        }

    }

    @Override
    public int getItemCount() {
        return listKelas.size();
    }

    //4. Implementasikan interface View.OnClickListener pada ViewHolder
    public class KelasViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView textKelas, textJadwal;
        ImageView imageStatus;
        Button buttonHai;

        public KelasViewHolder(@NonNull View itemView) {
            super(itemView);
            textKelas = itemView.findViewById(R.id.textKelas);
            textJadwal = itemView.findViewById(R.id.textJadwal);
            imageStatus = itemView.findViewById(R.id.imageStatus);
            buttonHai = itemView.findViewById(R.id.buttonHai);

            buttonHai.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(itemView.getContext(), "Diterima", Toast.LENGTH_SHORT).show();
                }
            });
            
            imageStatus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(itemView.getContext(), "Ditolak", Toast.LENGTH_SHORT).show();
                }
            });
            //5b. Tambahkan object ViewHolder sebagai listener
            //itemView.setOnClickListener(this);
        }

        //5a. Override method onClick yang ada dalam Interface View.OnClickListener
        @Override
        public void onClick(View view) {
            Kelas kelas = listKelas.get(getAdapterPosition());
            listener.kelasOnClick(kelas);
        }
    }

    // 1. Buat interface dengan method onclick dalam adapter
    public interface KelasItemClickListener{
        void kelasOnClick(Kelas kelas);
    }
}
