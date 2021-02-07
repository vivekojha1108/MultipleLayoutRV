# MultipleLayout In RecyclerView

Implemented Layout

     parentRecyclerView>
          -userInfoLayout
          -childRecyclerViewLayout
          -bannerImageLayout
          -viewPager->  
               -fragmentLayout->
                     -childRecyclerViewofFragment
          -adTextLayout
          
          
Here ChildRecyclerView has <b>Auto Scrolling Function.</b>
ViewPager Has SwipeView Function With swiping 3 Fragments.
With Fragment has one horizontal recyclerView.
   
#Additional Dependencies 

        dependendencies{
        implementation 'com.google.android.material:material:1.3.0-rc01'
        implementation 'androidx.viewpager2:viewpager2:1.1.0-alpha01'
        }

# APK Link
https://drive.google.com/file/d/10-FREHXGbOwJnqLYk75B5HRWm6AOCv6L/view?usp=sharing
