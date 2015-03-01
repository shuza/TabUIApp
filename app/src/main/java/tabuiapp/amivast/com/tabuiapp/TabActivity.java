package tabuiapp.amivast.com.tabuiapp;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class TabActivity extends Fragment {

    private Context context;
    private View parentView;
    private FragmentTabHost mTabHost;

    public static ArrayList<Reward> favoriteRewardInfoList;
    public static ArrayList<Reward> rewardInfoList;

    // List of category name
    public static ArrayList<String> categoryName;
    public static ArrayList<Integer> categoryRewardCounter;

    //private int res_id = -1;

    public static TabActivity newInstance() {
        TabActivity fragment = new TabActivity();
        //fragment.res_id = res_id;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            //setContentView(R.layout.tab_layout);

            favoriteRewardInfoList = new ArrayList<Reward>();
            rewardInfoList = new ArrayList<Reward>();

            // for category list fragment
            categoryName = new ArrayList<String>();
            categoryName.add("BONNAROO");
            categoryName.add("Music");
            categoryName.add("Filem");
            categoryName.add("Hiphop");
            categoryName.add("Country");

            categoryRewardCounter = new ArrayList<Integer>();
            categoryRewardCounter.add(13);
            categoryRewardCounter.add(10);
            categoryRewardCounter.add(5);
            categoryRewardCounter.add(20);
            categoryRewardCounter.add(5);

            // Set Initial Reward
            int count = 6;

            for(int i=0; i<count; i++)
            {
                //JSONObject jsonObject = jsonArray.getJSONObject(i);

                Reward reward = new Reward();

                reward.setReward_id((i+1));
                reward.setReward_title("Reward Title : "+(i+1));
                reward.setReward_point("Reward Point : "+(i+1)*100);
                reward.setReward_expire("3 days");
                reward.setReward_detail("Enter sweeptstakes");
                reward.setReward_favorite(0);

                if(i>2)
                {
                    reward.setReward_category("Category : 2");
                }
                else
                {
                    reward.setReward_category("Category : 1");
                }

                rewardInfoList.add(reward);
            }

        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        parentView = inflater.inflate(R.layout.tab_layout, container, false);

        context = getActivity();

        mTabHost = (FragmentTabHost) parentView.findViewById(android.R.id.tabhost);
        //mTabHost.setup(context, getActivity().getSupportFragmentManager(), R.id.realtabcontent);
        mTabHost.setup(context, getChildFragmentManager(), R.id.realtabcontent);

        mTabHost.addTab(mTabHost.newTabSpec("tab1").setIndicator("Favorite"), FavoriteRewardListFragment.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("tab2").setIndicator("All"), CategoryListFragment.class, null);

        return parentView;
    }
}
