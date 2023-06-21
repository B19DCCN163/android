package com.hfad.th2android.views;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hfad.th2android.R;
//import com.hfad.th2android.adapters.InfoAdapter;
import com.hfad.th2android.adapters.RecyclerViewAdapter;
import com.hfad.th2android.db.SQLiteHelper;
import com.hfad.th2android.models.Book;
//import com.hfad.th2android.models.Info;

import java.util.ArrayList;
import java.util.List;

public class FragmentInfo extends Fragment {
    //    private ListView listView;
//    InfoAdapter adapter ;
//    private Info[] list;
//    private RecyclerView recyclerView;
//    private RecyclerViewAdapter recyclerViewAdapter;
    private Button btnMap1;
    private Button btnMap2;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_info,container,false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        listView = view.findViewById(R.id.lview);
//        initData();
//        adapter = new InfoAdapter(this,list);
//        listView.setAdapter(adapter);
        btnMap1 = view.findViewById(R.id.btnMap1);
        btnMap1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String latitude = "0"; // Vĩ độ
                String longitude = "0"; // Kinh độ
                String label = "Vườn Quốc Gia Tam Đảo"; // Tên địa điểm
                // Tạo URI với thông tin vị trí   "geo:" + latitude + "," + longitude + "?q=" +
                String uri = "geo:" + latitude + "," + longitude + "?q=" + Uri.encode(label);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);


            }
        });
        btnMap2 = view.findViewById(R.id.btnMap2);
        btnMap2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String latitude = "0"; // Vĩ độ
                String longitude = "0"; // Kinh độ
                String label = "Quần Đảo Cát Bà"; // Tên địa điểm
                // Tạo URI với thông tin vị trí   "geo:" + latitude + "," + longitude + "?q=" +
                String uri = "geo:" + latitude + "," + longitude + "?q=" + Uri.encode(label);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);


            }
        });




    }

//    private void initData() {
//        Integer[] imgs = {R.drawable.tamdao,R.drawable.sachthich};
//        String[] names={"Tam Dao", "Ha Noi"};
//        String[] subs ={"So1","So2"};
//        String[] descs ={"Ha Noi", "Vinh Phuc"};
//        list=new Info[imgs.length];
//        for (int i=0;i< list.length;i++){
//            list[i]=new Info(imgs[i],names[i],subs[i],descs[i]);
//        }
//
//    }
}

