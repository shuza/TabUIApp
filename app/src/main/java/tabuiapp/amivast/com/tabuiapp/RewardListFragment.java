package tabuiapp.amivast.com.tabuiapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import tabuiapp.amivast.com.tabuiapp.RewardListAdapter.Item;
import tabuiapp.amivast.com.tabuiapp.RewardListAdapter.Row;
import tabuiapp.amivast.com.tabuiapp.RewardListAdapter.Section;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

public class RewardListFragment extends ListFragment 
{
	private List<Row> rows;
	private List<Reward> rewardInfoList;        // ListView items list

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		//favoriteRewardInfoList = new ArrayList<Reward>();
		//rewardInfoList = new ArrayList<Reward>();

		rewardInfoList = TabActivity.rewardInfoList;
		
		/*
		// initialize the items list
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
		}*/

//		// Deafult Set All List
//		RewardListAdapter adapter = prepareList(rewardInfoList);
//
//		// initialize and set the list adapter
//		//setListAdapter(new ListViewDemoAdapter(getActivity(), mItems));
//		setListAdapter(adapter);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		// remove the dividers from the ListView of the ListFragment
		getListView().setDivider(null);
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// retrieve theListView item
		//Reward item =  rewardInfoList.get(position);

		int pos = position;

//		if (l.getAdapter().getItem(pos) instanceof Item) 
//		{
//			//pos = pos - getSectionCounter(pos);
//
//			if (pos >= 0 && temp_position == pos)
//				getSwipeItem(false, pos);
//		}


		// do something
		//Toast.makeText(getActivity(), item.title, Toast.LENGTH_SHORT).show();
	}

	public RewardListAdapter prepareList(List<Reward> preparedList) {

		RewardListAdapter adapter = null;

		try
		{
			adapter = new RewardListAdapter(getActivity());

			List<Object[]> alphabet = new ArrayList<Object[]>();
			HashMap<String, Integer> sections = new HashMap<String, Integer>();

			//List<Row> rows = new ArrayList<Row>();
			rows = new ArrayList<Row>();
			int start = 0;
			int end = 0;
			String previousName = null;
			//String previousLetter = null;
			Object[] tmpIndexItem = null;
			//Pattern numberPattern = Pattern.compile("[0-9]");

			for (int i=0; i<preparedList.size(); i++) 
			{
				Reward reward = preparedList.get(i);

				String category_name = reward.getReward_category();


				// If we've changed to a new letter, add the previous letter to the alphabet scroller
				if (previousName != null && !category_name.equals(previousName)) 
				{
					end = rows.size() - 1;
					tmpIndexItem = new Object[3];
					tmpIndexItem[0] = previousName;
					tmpIndexItem[1] = start;
					tmpIndexItem[2] = end;
					alphabet.add(tmpIndexItem);

					start = end + 1;
				}

				// Check if we need to add a header row
				if (!category_name.equals(previousName)) {
					rows.add(new Section(category_name));
					sections.put(category_name, start);
				}

				// Add the country to the list
				rows.add(new Item(reward));
				previousName = category_name;

			}

			if (previousName != null) {
				// Save the last letter
				tmpIndexItem = new Object[3];
				tmpIndexItem[0] = previousName;
				tmpIndexItem[1] = start;
				tmpIndexItem[2] = rows.size() - 1;
				alphabet.add(tmpIndexItem);
			}

			adapter.setRows(rows);
			//listView.setAdapter(adapter);

			return adapter;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
	}


	class SideIndexGestureListener extends GestureDetector.SimpleOnGestureListener
	{
		private int REL_SWIPE_MIN_DISTANCE;
		private int REL_SWIPE_MAX_OFF_PATH;
		private int REL_SWIPE_THRESHOLD_VELOCITY;
		
//		@Override
//		public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) 
//		{
//
//			Log.d("Scrolled- fragment ", "Scrolling");
//			return super.onScroll(e1, e2, distanceX, distanceY);
//		}
		
		//CONDITIONS ARE TYPICALLY VELOCITY OR DISTANCE    
	    @Override
	    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) 
	    {
	    	if (Math.abs(e1.getY() - e2.getY()) > REL_SWIPE_MAX_OFF_PATH)
				return false;
//			if (e1.getX() - e2.getX() > REL_SWIPE_MIN_DISTANCE && Math.abs(velocityX) > REL_SWIPE_THRESHOLD_VELOCITY) 
//			{
//				int pos = list.pointToPosition((int) e1.getX(), (int) e2.getY());
//
//				if (list.getAdapter().getItem(pos) instanceof Item) 
//				{	
//					if (pos >= 0 && temp_position == pos)
//						getSwipeItem(false, pos);
//				}
//			} 
//			else if (e2.getX() - e1.getX() > REL_SWIPE_MIN_DISTANCE && Math.abs(velocityX) > REL_SWIPE_THRESHOLD_VELOCITY) 
//			{
//				int pos = list.pointToPosition((int) e1.getX(), (int) e2.getY());
//
//				if (list.getAdapter().getItem(pos) instanceof Item) 
//				{
//					if (pos >= 0 && temp_position == pos)
//						getSwipeItem(true, pos);
//				}
//
//			}
			return false;
	    }

		
	}


	@Override
	public void onActivityCreated(Bundle savedInstanceState) 
	{
		super.onActivityCreated(savedInstanceState);

		final GestureDetector gestureDetector = new GestureDetector(getActivity(),
				new SideIndexGestureListener());
		View.OnTouchListener gestureListener = new View.OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				return gestureDetector.onTouchEvent(event);
			}
		};

		getListView().setOnTouchListener(gestureListener);

		try 
		{
//			adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_single_choice, elementos);
//			setListAdapter(adapter);
//			getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
			
			// Deafult Set All List
			RewardListAdapter adapter = prepareList(rewardInfoList);

			// initialize and set the list adapter
			setListAdapter(adapter);

		}catch (Exception e){

		}
	}

}
