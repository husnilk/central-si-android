package id.ac.unand.fti.central.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import id.ac.unand.fti.central.DetailPertemuanActivity;
import id.ac.unand.fti.central.R;
import id.ac.unand.fti.central.models.PertemuanMingguan;

public class MingguanAdapter extends RecyclerView.Adapter<MingguanAdapter.MingguanViewHolder> {

    ArrayList<PertemuanMingguan> listPertemuanMingguan = new ArrayList<>();
    OnMingguanClickListener listener = null;

    public void setListener(OnMingguanClickListener listener) {
        this.listener = listener;
    }

    public void setListPertemuanMingguan(ArrayList<PertemuanMingguan> listPertemuanMingguan) {
        this.listPertemuanMingguan = listPertemuanMingguan;
        notifyDataSetChanged();
    }



    @NonNull
    @Override
    public MingguanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_mingguan, parent, false);

        return new MingguanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MingguanViewHolder holder, int position) {
        PertemuanMingguan data = listPertemuanMingguan.get(position);
        holder.textMingguKe.setText(String.valueOf(data.getMingguKe()));
        holder.textTanggal.setText(data.getTanggal());
        holder.textDeskripsi.setText(data.getDeskripsi());
        holder.textMateri.setText(data.getMateri());
        if(data.getStatusHadir() == 0){
            holder.imgStatusHadir.setImageResource(R.drawable.ic_cancel);
        }else{
            holder.imgStatusHadir.setImageResource(R.drawable.ic_check);
        }
    }

    @Override
    public int getItemCount() {
        return listPertemuanMingguan.size();
    }

    public class MingguanViewHolder extends RecyclerView.ViewHolder {
        TextView textMingguKe, textTanggal, textMateri, textDeskripsi;
        ImageView imgStatusHadir;

        public MingguanViewHolder(@NonNull View itemView) {
            super(itemView);
            textMingguKe = itemView.findViewById(R.id.textMIngguKe);
            textTanggal = itemView.findViewById(R.id.textTanggalDetail);
            textMateri = itemView.findViewById(R.id.textMateri);
            textDeskripsi = itemView.findViewById(R.id.textDeskripsiMateri);
            imgStatusHadir = itemView.findViewById(R.id.imageStatusHadir);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    PertemuanMingguan mingguan = listPertemuanMingguan.get(position);
                    Toast.makeText(
                            itemView.getContext(),
                            mingguan.getMateri(),
                            Toast.LENGTH_SHORT).show();
                    listener.onClick(mingguan);
                }
            });
        }
    }

    public interface OnMingguanClickListener{
        void onClick(PertemuanMingguan mingguan);
    }
}
