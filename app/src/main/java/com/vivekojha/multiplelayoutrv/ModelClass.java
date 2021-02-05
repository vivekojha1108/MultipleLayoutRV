package com.vivekojha.multiplelayoutrv;


import androidx.recyclerview.widget.RecyclerView;

public class ModelClass {

    public static final int USER_INFO_LAYOUT = 0;
    public static final int AD_LAYOUT = 1;
    public static final int IMAGE_LAYOUT = 2;
    public static final  int RECYCLE_LAYOUT = 3;

    private int viewType;

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    //////Constructor for UserInfo Layout
    private int ImageResource;
    private String title;
    private String desc;

    public ModelClass(int viewType, int imageResource, String title, String desc) {
        ImageResource = imageResource;
        this.title = title;
        this.desc = desc;
        this.viewType = viewType;
    }

    public int getImageResource() {
        return ImageResource;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }


    ////Ad layout Constructor
    private String adText;

    public ModelClass(int viewType, String adText) {
        this.adText = adText;
        this.viewType = viewType;
    }

    public String getAdText() {
        return adText;
    }

    public void setAdText(String adText) {
        this.adText = adText;
    }

    //Image Layout Constructor
    private int resource;

    public ModelClass(int viewType, int resource) {
        this.resource = resource;
        this.viewType = viewType;
    }

    public int getResource() {
        return resource;
    }

    public void setResource(int resource) {
        this.resource = resource;
    }

    //RECYCLER_LAYOUT
    private RecyclerView recyclerView;

    public ModelClass(int viewType, RecyclerView recyclerView) {
        this.viewType = viewType;
        this.recyclerView = recyclerView;
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public void setRecyclerView(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }
}
