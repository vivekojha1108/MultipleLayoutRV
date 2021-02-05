package com.vivekojha.multiplelayoutrv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import static com.vivekojha.multiplelayoutrv.ModelClass.AD_LAYOUT;
import static com.vivekojha.multiplelayoutrv.ModelClass.FRAGMENT_SLIDER_LAYOUT;
import static com.vivekojha.multiplelayoutrv.ModelClass.IMAGE_LAYOUT;
import static com.vivekojha.multiplelayoutrv.ModelClass.RECYCLE_LAYOUT;
import static com.vivekojha.multiplelayoutrv.ModelClass.USER_INFO_LAYOUT;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewParent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewParent = findViewById(R.id.parentRV);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);

        recyclerViewParent.setLayoutManager(layoutManager);

        //creating a list and setting adapter
        List<ModelClass> modelClassList = new ArrayList<>();
        /*modelClassList.add(new ModelClass(R.mipmap.ic_launcher_round,"User One", "This is User One."));
        modelClassList.add(new ModelClass(R.mipmap.ic_launcher,"User Two", "This is User Two."));
        modelClassList.add(new ModelClass(R.mipmap.ic_launcher_round,"User Three", "This is User Three."));
        modelClassList.add(new ModelClass(R.drawable.ic_launcher_foreground,"User Four", "This is User Four."));
        modelClassList.add(new ModelClass(R.drawable.ic_launcher_foreground,"User Five", "This is User Five."));*/




        //new ModelClassList
        modelClassList.add(new ModelClass(USER_INFO_LAYOUT,R.mipmap.ic_launcher_round,"User One", "This is User One."));
        modelClassList.add(new ModelClass(RECYCLE_LAYOUT,R.id.RL_RV));
        modelClassList.add(new ModelClass(IMAGE_LAYOUT,R.drawable.banner_1));
        modelClassList.add(new ModelClass(FRAGMENT_SLIDER_LAYOUT,R.id.viewPager));
        modelClassList.add(new ModelClass(AD_LAYOUT,"Mobile AD"));
        modelClassList.add(new ModelClass(USER_INFO_LAYOUT,R.mipmap.ic_launcher_round,"User Two", "This is User Two."));
        modelClassList.add(new ModelClass(IMAGE_LAYOUT,R.drawable.banner_5));
        modelClassList.add(new ModelClass(AD_LAYOUT,"Laptop AD"));
        modelClassList.add(new ModelClass(USER_INFO_LAYOUT,R.mipmap.ic_launcher_round,"User Three", "This is User Three."));
        modelClassList.add(new ModelClass(IMAGE_LAYOUT,R.drawable.banner_5));
        modelClassList.add(new ModelClass(AD_LAYOUT,"TV AD"));
        modelClassList.add(new ModelClass(IMAGE_LAYOUT,R.drawable.banner_1));
        modelClassList.add(new ModelClass(AD_LAYOUT,"Mobile AD"));
        modelClassList.add(new ModelClass(USER_INFO_LAYOUT,R.mipmap.ic_launcher_round,"User One", "This is User One."));
        modelClassList.add(new ModelClass(AD_LAYOUT,"Amazon AD"));




        Adapter adapter = new Adapter(this, modelClassList);
        recyclerViewParent.setAdapter(adapter);
        adapter.notifyDataSetChanged();


    }
}