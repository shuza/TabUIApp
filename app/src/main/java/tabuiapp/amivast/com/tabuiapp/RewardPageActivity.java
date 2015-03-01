package tabuiapp.amivast.com.tabuiapp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import android.webkit.WebView;

public class RewardPageActivity extends Activity {

	private Context context;

	private WebView rewardWebView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.reward_page_layout);
		
		String strURL = getIntent().getStringExtra("REWARD_PAGE");
		
		context = this;
		
		rewardWebView = (WebView) findViewById(R.id.rewardWebView);
		rewardWebView.loadUrl(strURL);
	}
	
}
