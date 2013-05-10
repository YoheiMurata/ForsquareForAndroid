/*
 * LocatinoListenerService.java
 * 作成者：Yohei Murata
 * 作成日：2013年5月10日
 * 概要：
 * ジオロケーションを使用して現在地の座標を取得するサービス
 * 
 */


package com.example.foursquaretest;

import android.app.Service;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class LocationListenerService extends Service implements LocationListener{
	
	//デバッグログ用のタグ
	private static final String DEBUG_TAG = "TEST_LOCATION_SERVICE";

	//ジオロケーションの管理をするための変数
	//一応nullにして初期化
	private LocationManager mLocationManager = null;

	
	//必ずオーバーライドしないと行けないメソッド。
	//とくにやることないので自動生成のまま
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void onStart( Intent intent, int startId ){
		
		//ジオロケーションマネージャのインスタンス取得
		mLocationManager = ( LocationManager ) getSystemService( LOCATION_SERVICE );
		
		mLocationManager.requestLocationUpdates( LocationManager.GPS_PROVIDER, 0, 0, (LocationListener) this );
		
		//現在地取得中のメッセージを出す。
		Toast.makeText(this, R.string.label_now_listening, Toast.LENGTH_LONG).show();
		

	}

	@Override
	//位置情報が変化した場合の処理
	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub
		Log.v( DEBUG_TAG, "onLocationChanged" );
		Toast.makeText( this, "Lat: "+location.getLatitude(), Toast.LENGTH_SHORT ).show();
		Toast.makeText( this, "Lang: "+location.getLongitude(), Toast.LENGTH_SHORT ).show();
	}

	@Override
	//geolocationが使用できな設定になっていた場合はここに入るはず
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
		Log.v( DEBUG_TAG, "onProviderDisabled" );
		
		//とりあえずメッセージを出力
		Toast.makeText( this, R.string.label_failed_to_get_instance, Toast.LENGTH_LONG ).show();
	
	}

	@Override
	//geolocationが使用できる状況になった場合の処理
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
		
		Log.v( DEBUG_TAG, "onProviderEnabled" );
		
	}

	@Override
	//geolocationの設定が変化したときの処理（だと思われ）
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
		
		Log.v( DEBUG_TAG, "onStatusChanged" );
	}
	
	

	
}
