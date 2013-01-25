package com.example.gf_webviewsample;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.webkit.WebView;
import android.content.Context;
import jp.basicinc.gamefeat.android.sdk.controller.GameFeatAppController;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		WebView webView = new WebView(this);
		webView.getSettings().setJavaScriptEnabled(true);
		webView.loadUrl("http://www.example.com/");
		JsObject jsObj = new JsObject(this);
		webView.addJavascriptInterface(jsObj, "andjs");

		setContentView(webView);
	}
	
	public class JsObject {
		private Context con;
		public JsObject(Context con) {
			this.con = con;
		}
		/*
		 * HTML側で onClick="andjs.loadGameFeat()" とメソッドを呼ぶことが可能
		 */
		public void loadGameFeat() {
			GameFeatAppController.show(MainActivity.this);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
