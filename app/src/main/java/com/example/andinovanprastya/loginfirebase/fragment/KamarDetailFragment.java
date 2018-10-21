package com.example.andinovanprastya.loginfirebase.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.andinovanprastya.loginfirebase.R;
import com.example.andinovanprastya.loginfirebase.model.Kamar;


public class KamarDetailFragment extends Fragment {
    private long kosId;

    public KamarDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kamar_detail, container, false);
    }

    public void setKos(long id){
        this.kosId = id;
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();

        if(view != null){
            TextView title = view.findViewById(R.id.textTitle);
            Kamar tipekamar = Kamar.jeniskamar[(int) kosId];
            title.setText(tipekamar.getName());

            TextView fasilitas = view.findViewById(R.id.textFasilitas);
            fasilitas.setText(tipekamar.getFasilitas());

            TextView harga = view.findViewById(R.id.textPrice);
            harga.setText(tipekamar.getHarga());

            ImageView img = view.findViewById(R.id.fotoKamar);
            img.setImageResource(tipekamar.getGambar());
        }
    }
}
