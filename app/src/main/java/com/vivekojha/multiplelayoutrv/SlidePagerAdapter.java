package com.vivekojha.multiplelayoutrv;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;


public class SlidePagerAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> fragmentList;

    public SlidePagerAdapter(@NonNull FragmentManager fm, List<Fragment> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
       /* if (position == 0) {
            return new Fragment1();
        } else if (position == 1) {
            return new Fragment2();
        } else {
            return new Fragment3();
        }
*/
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
//        return 3;
        return fragmentList.size();
    }
}


/*public class  SlidePagerAdapter extends FragmentStateAdapter{

    private List<Fragment> fragmentList;

    public SlidePagerAdapter(@NonNull FragmentActivity fragmentActivity, List<Fragment> fragmentList) {
        super(fragmentActivity);
        this.fragmentList = fragmentList;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getItemCount() {
        return  fragmentList.size();
    }
}*/


