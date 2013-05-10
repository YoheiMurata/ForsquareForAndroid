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
import android.location.LocationManager;
import android.os.IBinder;
import android.widget.Toast;

public class LocationListenerService extends Service{

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
		
		//どのように位置情報の取得失敗をするのかわからない。
		//インスタンスが取得できないのかな？と思いながら何となくしたの条件式になった。
		if(mLocationManager == null){
			Toast.makeText( this, R.string.label_failed_to_get_instance, Toast.LENGTH_LONG ).show();
		}else{
		
		//現在地取得中のメッセージを出す。
		Toast.makeText(this, R.string.label_now_listening, Toast.LENGTH_LONG).show();
	
		}
	}
	
	

	
}
