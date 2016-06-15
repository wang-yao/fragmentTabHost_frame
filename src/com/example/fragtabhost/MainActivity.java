package com.example.fragtabhost;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends FragmentActivity{
	private FragmentTabHost mTabHost;
	private static final String[] tab = new String[] { "A", "B", "C", "D", "E" };
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
		mTabHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);
		for (int i = 0; i < tab.length-1; i++) {
			mTabHost.addTab(mTabHost.newTabSpec("tab"+(i+1)).setIndicator(getTabItemView(tab[i])), FragmentTab.class, null);
		}
		mTabHost.addTab(mTabHost.newTabSpec("tab5").setIndicator(getTabItemView(tab[4])), FragmentTab1.class, null);
	}
	private View getTabItemView(String name) {
		View view = LayoutInflater.from(this).inflate(R.layout.tab_item_view, null);
		TextView class_content = (TextView) view.findViewById(R.id.class_con);
		class_content.setText(name);
		return view;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
