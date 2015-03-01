package tabuiapp.amivast.com.tabuiapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.FrameLayout;

public class MainActivity extends FragmentActivity implements Communicator {

	private FrameLayout frameContaioner;
    private ViewPager pager;
	
	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.main_layout);
		
		//frameContaioner = (FrameLayout) findViewById(R.id.frameLayout);
        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));

        pager.setCurrentItem(0);

		//init();
	}
	
	
	private void init()
	{
		try
		{
			Fragment fragment = new TabActivity();
			//Fragment fragment = new FragmentDiagram();
			getSupportFragmentManager().beginTransaction().add(frameContaioner.getId(), fragment).commit();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

    @Override
    public void resond() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(android.R.id.tabhost, new AllRewardFragment());
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int pos) {
            switch(pos) {

                case 0: return SplashFragment.newInstance();
                case 1: return TabActivity.newInstance();
                default: return SplashFragment.newInstance();
            }
        }

        @Override
        public int getCount() {
            return 2;
        }
    }
}
