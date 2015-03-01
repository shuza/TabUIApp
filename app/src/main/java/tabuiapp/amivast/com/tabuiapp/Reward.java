package tabuiapp.amivast.com.tabuiapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Reward implements Parcelable {
	
	private int reward_id;	
	private String reward_title;
	private String reward_point;
	private String reward_expire;
	private String reward_detail;
	private String reward_category;
	private int reward_favorite;
	
	public Reward()
	{	
	}
	
	public int getReward_id() {
		return reward_id;
	}
	public void setReward_id(int reward_id) {
		this.reward_id = reward_id;
	}

	public String getReward_title() {
		return reward_title;
	}
	public void setReward_title(String reward_title) {
		this.reward_title = reward_title;
	}

	public String getReward_point() {
		return reward_point;
	}
	public void setReward_point(String reward_point) {
		this.reward_point = reward_point;
	}

	public String getReward_expire() {
		return reward_expire;
	}
	public void setReward_expire(String reward_expire) {
		this.reward_expire = reward_expire;
	}

	public String getReward_detail() {
		return reward_detail;
	}
	public void setReward_detail(String reward_detail) {
		this.reward_detail = reward_detail;
	}
	
	public String getReward_category() {
		return reward_category;
	}
	public void setReward_category(String reward_category) {
		this.reward_category = reward_category;
	}
	
	public int getReward_favorite() {
		return reward_favorite;
	}
	public void setReward_favorite(int reward_favorite) {
		this.reward_favorite = reward_favorite;
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		dest.writeInt(reward_id);
		dest.writeString(reward_title);
		dest.writeString(reward_point);
		dest.writeString(reward_expire);
		dest.writeString(reward_detail);
		dest.writeString(reward_category);
		dest.writeInt(reward_favorite);
	}

	protected Reward(Parcel in) {
        reward_id = in.readInt();
        reward_title = in.readString();
        reward_point = in.readString();
        reward_expire = in.readString();
        reward_detail = in.readString();
        reward_category = in.readString();
        reward_favorite = in.readInt();
    }
	
    public static final Creator<Reward> CREATOR = new Creator<Reward>() {
        @Override
        public Reward createFromParcel(Parcel in) {
            return new Reward(in);
        }

        @Override
        public Reward[] newArray(int size) {
            return new Reward[size];
        }
    };
	
}
