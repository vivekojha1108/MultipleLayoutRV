package com.vivekojha.multiplelayoutrv;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.vivekojha.multiplelayoutrv.fragment.Fragment1;
import com.vivekojha.multiplelayoutrv.fragment.Fragment2;
import com.vivekojha.multiplelayoutrv.fragment.Fragment3;

import java.util.ArrayList;
import java.util.List;

import static com.vivekojha.multiplelayoutrv.ModelClass.AD_LAYOUT;
import static com.vivekojha.multiplelayoutrv.ModelClass.FRAGMENT_SLIDER_LAYOUT;
import static com.vivekojha.multiplelayoutrv.ModelClass.IMAGE_LAYOUT;
import static com.vivekojha.multiplelayoutrv.ModelClass.RECYCLE_LAYOUT;
import static com.vivekojha.multiplelayoutrv.ModelClass.USER_INFO_LAYOUT;

public class Adapter extends RecyclerView.Adapter {

    private List<ModelClass> modelClassList;
    private int lastPosition = -1;
    ArrayList<String> usernameArrayList = new ArrayList<>();
    PagerAdapter customPagerAdapter;
    Context context;

    public Adapter(Context context, List<ModelClass> modelClassList) {
        this.context = context;
        this.modelClassList = modelClassList;
    }

    //mustImplement : Called first
    @Override
    public int getItemViewType(int position) {
        switch (modelClassList.get(position).getViewType()) {
            case 0:
                return USER_INFO_LAYOUT;
            case 1:
                return AD_LAYOUT;
            case 2:
                return IMAGE_LAYOUT;
            case 3:
                return RECYCLE_LAYOUT;
            case 4:
                return FRAGMENT_SLIDER_LAYOUT;
            default:
                return -1;

        }
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        switch (viewType) {
            case USER_INFO_LAYOUT:
                View userInfoLayout = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
                return new UserInfoLayout(userInfoLayout);
            case AD_LAYOUT:
                View adLayout = LayoutInflater.from(parent.getContext()).inflate(R.layout.ad_layout, parent, false);
                return new ADLayout(adLayout);
            case IMAGE_LAYOUT:
                View ImageLayout = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_layout, parent, false);
                return new ImageLayout(ImageLayout);
            case RECYCLE_LAYOUT:
                View RecyclerLayout = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_layout, parent, false);
                return new RecyclerLayout(RecyclerLayout);
            case FRAGMENT_SLIDER_LAYOUT:
                View fragmentSliderLayout = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_slider_layout, parent, false);
                return new FragmentSliderLayout(fragmentSliderLayout);
            default:
                return null;

        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        switch (modelClassList.get(position).getViewType()) {
            case USER_INFO_LAYOUT:
                int resourceImg = modelClassList.get(position).getImageResource();
                String title = modelClassList.get(position).getTitle();
                String desc = modelClassList.get(position).getDesc();

                ((UserInfoLayout) holder).setUserInfoData(resourceImg, title, desc);
                break;
            case AD_LAYOUT:
                String ad = modelClassList.get(position).getAdText();
                ((ADLayout) holder).setAdText(ad);
                break;
            case IMAGE_LAYOUT:
                int resource = modelClassList.get(position).getResource();
                ((ImageLayout) holder).setImageView(resource);
                break;

            case RECYCLE_LAYOUT:

                BindRecyclerLayout(holder);

                break;

            case FRAGMENT_SLIDER_LAYOUT:
               /* int resource = modelClassList.get(position).getResource();
                ((ImageLayout) holder).setImageView(resource);*/

                BindFragmentSliderLayout(holder, position);

                break;

            default:
                return;
        }

        /*if (lastPosition < position){
            Animation animation = AnimationUtils.loadAnimation(holder.itemView.getContext(), android.R.anim.fade_in);
            holder.itemView.setAnimation(animation);
            lastPosition = position;

        }*/
    }


    @Override
    public int getItemCount() {
        return modelClassList.size();
    }

    //ViewHolderClasses Are Here

    class UserInfoLayout extends RecyclerView.ViewHolder {

        ImageView imageViewUser;
        TextView title, desc;

        public UserInfoLayout(@NonNull View itemView) {
            super(itemView);
            imageViewUser = itemView.findViewById(R.id.imageView_User);
            title = itemView.findViewById(R.id.textViewTitle);
            desc = itemView.findViewById(R.id.textViewDesc);
        }

        private void setUserInfoData(int imageResource, String titleText, String descText) {
            imageViewUser.setImageResource(imageResource);
            title.setText(titleText);
            desc.setText(descText);
        }
    }


    class ADLayout extends RecyclerView.ViewHolder {
        private TextView adText;

        public ADLayout(@NonNull View itemView) {
            super(itemView);
            adText = itemView.findViewById(R.id.textView_AD);
        }

        private void setAdText(String ad) {
            adText.setText(ad);
        }
    }


    class ImageLayout extends RecyclerView.ViewHolder {
        ImageView imageView;

        public ImageLayout(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.mainImage);
        }

        private void setImageView(int image) {
            imageView.setImageResource(image);
        }
    }

    class RecyclerLayout extends RecyclerView.ViewHolder {

        RecyclerView ChildRV;

        public RecyclerLayout(@NonNull View itemView) {
            super(itemView);
            ChildRV = (RecyclerView) itemView.findViewById(R.id.RL_RV);
        }

    }

    class FragmentSliderLayout extends RecyclerView.ViewHolder {
        ViewPager viewPager;

        public FragmentSliderLayout(@NonNull View itemView) {
            super(itemView);
            viewPager = itemView.findViewById(R.id.viewPager);
        }
    }


    ///BindRecyclerLayout(holder) function starts here
    private void BindRecyclerLayout(RecyclerView.ViewHolder holder) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(holder.itemView.getContext(), LinearLayoutManager.HORIZONTAL, false);
        ((RecyclerLayout) holder).ChildRV.setLayoutManager(layoutManager);


        usernameArrayList.clear();
        String[] user = {"John", "Batista", "Undertaker", "Khali", "Kane", "Randy", "TripleH"};
        for (int i = 0; i < user.length; i++) {
            usernameArrayList.add(user[i]);
        }

        final int duration = 10; //duration for moving 50 pxl : Speed
        final int pixelsToMove = 50;
        final Handler mHandler = new Handler(Looper.getMainLooper());

        final Runnable SCROLLING_RUNNABLE = new Runnable() {
            @Override
            public void run() {
                ((RecyclerLayout) holder).ChildRV.smoothScrollBy(pixelsToMove, 0);
                mHandler.postDelayed(this, duration);
            }
        };

        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(usernameArrayList);
        ((RecyclerLayout) holder).ChildRV.setAdapter(recyclerViewAdapter);


        ((RecyclerLayout) holder).ChildRV.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                int lastItem = layoutManager.findLastCompletelyVisibleItemPosition();

                if (lastItem == layoutManager.getItemCount() - 1) {
                    mHandler.removeCallbacks(SCROLLING_RUNNABLE);
                    Handler postHandler = new Handler();

                    postHandler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            recyclerView.setAdapter(null);
                            recyclerView.setAdapter(recyclerViewAdapter);
                            mHandler.postDelayed(SCROLLING_RUNNABLE, 1000); //delay time for restarting scroll animation
                        }
                    }, 100); // delay time for Reset the scroll list
                }
            }
        });


        mHandler.postDelayed(SCROLLING_RUNNABLE, 2000); //call the postDelay: After the 4000millis very first animation

        ((RecyclerLayout) holder).ChildRV.setHasFixedSize(true);
        recyclerViewAdapter.notifyDataSetChanged();
        //case  RECYCLE_LAYOUT : ENds Here
    }


    //////// BindFragmentSliderLayout function Starts Here
    private void BindFragmentSliderLayout(RecyclerView.ViewHolder holder, int position) {

        List<Fragment> list = new ArrayList<>();
        list.add(new Fragment1());
//        list.add(new Fragment2());
//        list.add(new Fragment3());


        customPagerAdapter = new SlidePagerAdapter(((MainActivity) context).getSupportFragmentManager(), list);
        ((FragmentSliderLayout) holder).viewPager.setAdapter(customPagerAdapter);
        customPagerAdapter.notifyDataSetChanged();

       /* ((FragmentSliderLayout) holder).viewPager.setCurrentItem(1);
        Log.e("TAG", position + "");*/

    }


}


//Old code for onlyUSerINfo
/*
public class Adapter extends RecyclerView.Adapter<Adapter.myViewHolder> {

    private List<ModelClass> modelClassList;

    public Adapter(List<ModelClass> modelClassList) {
        this.modelClassList = modelClassList;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        int resource = modelClassList.get(position).getImageResource();
        String title = modelClassList.get(position).getTitle();
        String desc = modelClassList.get(position).getDesc();

        holder.setData(resource,title,desc);

    }

    @Override
    public int getItemCount() {
        return modelClassList.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {

         ImageView imageView;
         TextView title, desc;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            title = itemView.findViewById(R.id.textViewTitle);
            desc = itemView.findViewById(R.id.textViewDesc);
        }

        private void setData(int imageResource, String titleText, String descText){
            imageView.setImageResource(imageResource);
            title.setText(titleText);
            desc.setText(descText);
        }
    }
}
*/
