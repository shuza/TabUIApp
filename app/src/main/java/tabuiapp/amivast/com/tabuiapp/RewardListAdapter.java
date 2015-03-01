package tabuiapp.amivast.com.tabuiapp;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

public class RewardListAdapter extends BaseAdapter 
{

	private Context context;

	public RewardListAdapter(Context content)
	{
		this.context = content;
	}


	public static abstract class Row {}

	public static final class Section extends Row 
	{
		public final String text;

		public Section(String text) {
			this.text = text;
		}
	}

	public static final class Item extends Row 
	{
		public final Reward reward;

		public Item(Reward text) {
			this.reward = text;
		}
	}


	private List<Row> rows;

	public void setRows(List<Row> rows) {

		//    	for(int i=0;i<rows.size();i++)
			//    	{
			//    		System.out.println("Rows : "+rows.get(i).toString());
		//    	}

		this.rows = rows;
	}

	@Override
	public int getCount() {
		return rows.size();
	}

	@Override
	public Row getItem(int position) {
		return rows.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public int getViewTypeCount() {
		return 2;
	}

	@Override
	public int getItemViewType(int position) {
		if (getItem(position) instanceof Section) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = convertView;

		if (getItemViewType(position) == 0) 
		{ 
			if (view == null)	// Header 
			{
				LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				view = (LinearLayout) inflater.inflate(R.layout.section_item, parent, false);
			}

			final Item item = (Item) getItem(position);
			TextView txtRewardTitle = (TextView) view.findViewById(R.id.txtRewardTitle);
			TextView txtRewardPoint = (TextView) view.findViewById(R.id.txtRewardPoints);
			TextView txtRewardDetail = (TextView) view.findViewById(R.id.txtRewardDetail);
			final ImageView imgFavorite = (ImageView) view.findViewById(R.id.imgStar);
			ImageView imgCloud = (ImageView) view.findViewById(R.id.imgUpload);
			ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.progressBar);

			// Set Values
			txtRewardTitle.setText(item.reward.getReward_title());
			txtRewardPoint.setText(item.reward.getReward_point());
			txtRewardDetail.setText(item.reward.getReward_detail());

			// Set value for start
			if(item.reward.getReward_favorite()==0)
			{
				imgFavorite.setImageResource(R.drawable.black_star);
			}
			else
			{
				imgFavorite.setImageResource(R.drawable.orange_star);
			}
			
			// Set value for progress bar
			progressBar.setProgress(70);
			
			txtRewardDetail.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
					Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
					context.startActivity(webIntent);
					
				}
			});
			
			imgFavorite.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub

					if(item.reward.getReward_favorite()==0)
					{
						item.reward.setReward_favorite(1);
						imgFavorite.setImageResource(R.drawable.orange_star);
					}
					else
					{
						item.reward.setReward_favorite(0);
						imgFavorite.setImageResource(R.drawable.black_star);
					}
				}
			});

		} else { // Section

			if (view == null) 
			{
				LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				view = (LinearLayout) inflater.inflate(R.layout.section_header, parent, false); 
			}
            
            Section section = (Section) getItem(position);
            TextView textView = (TextView) view.findViewById(R.id.txtSection);
            textView.setText(section.text);
		}

		return view;
	}

}
