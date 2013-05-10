/*
 * FourSquareTest.java
 * 作成者：YoheiMurata
 * 作成日：2013年5月10日
 * 概要：
 * 　上半分に地図を表示し、下半分にVenue（・・・でいいのかな？）を表示。Venueを選択すると
 * チェックインする機能をとりあえずは実現する。
 */
package com.example.foursquaretest;

import org.junit.Test;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class FourSquareTest extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_four_square_test);
		activateService();
	}
	
	/*
	 * activateService
	 * 引数：なし
	 * 返り値：なし
	 * 概要：
	 * ジオロケーションのサービスを起動させるテストメソッド
	 */
	@Test
	private void activateService(){
		//intentの生成
		Intent intent = new Intent( this, LocationListenerService.class );
		//サービスの起動
		startService( intent );
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_four_square_test, menu);
		return true;
	}

}
