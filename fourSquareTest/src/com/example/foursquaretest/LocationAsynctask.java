/*
 * LocationAsynctask.java
 * 作成者：Yohei Murata
 * 作成日：2013年5月11日
 * 概要：
 * 動作自体はLocationListenerService.javaと同じ。
 * Androidのサービスを使うか、Asynctaskを使うかだけの違いしかない。
 * 
 */

package com.example.foursquaretest;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;

/*
 * AsyncTaskについての補足：
 * AsyncTaskはアクティビティ内では実行できないような処理（UIスレッドが長時間止まってしまう可能性がある処理)
 * をアクティビティとは違うスレッドを生成してバックグラウンドで実行させるためのクラスである。
 * AsyncTaskのクラスを利用するには、AsyncTaskクラスをスーパークラスとして継承する必要がある。
 * AsyncTaskはジェネリクスクラスなので、継承時にパラメータの型を３つ指定する必要がある。
 * 
 * public class ..... extends AsyncTask< Param, Progress, Result >
 * Param,Progress,Resultの部分はそれぞれ
 * Param: doInBackgroundメソッド内で使用する引数
 * Progress: onProgressUpdateメソッド内で使用する引数
 * Result: onPostExecuteメソッド内で使用する引数
 * ・・・の変数型を指定する。
 * 
 * :各メソッドの使い道:
 * AsyncTask内のメソッドはそれぞれ次のように使用する
 * void onPreExecute()：　バックグラウンド実行の前準備をするための処理。（＊）
 * (戻り値任意) doInBackground：　バックグラウンド上で実行する処理
 * void onProgressUpdate：　進捗状況をUIスレッドで表示する処理
 * (戻り値任意) onPostExecute：	バックグラウンド処理の実行終了の処理
 * (＊)はAsyncTaskクラス継承時に指定することができない。なのでここだけ戻り値の型が確定している。
 * それ以外は引数の型が継承時に指定する型で決まる。
 * 
 * 注意としては、特に引数がいらなくても次の形は許されない。
 * extends AsyncTask< Void, Void, Void >
 * 
 */
public class LocationAsynctask extends AsyncTask<Void, Integer, Void> implements LocationListener{
	
	//デバッグ用り仮置きのタグ
	private static final String DEBUG_TAG = "LOCATION_ASYNCTASK";
	//プログレスダイアログの最大値
	private static final int PROGRESS_MAX = 100;
	//位置情報取得の最低間隔（ミリ秒)
	private static final int INTERVAL_GET_POSITION_MIN = 100;
	
	//Toastやダイアログを出すために呼び出し元のアクティビティのコンテキストをもらう
	private Context context = null;
	//プログレスダイアログを位置情報を取得中に表示するための変数
	private ProgressDialog progress = null;
	//位置情報管理に使用する変数みたい
	LocationManager manager;
	//位置情報取得に使用する変数
	LocationListener mLocationListener;
	
	
	
	/*
	 * LocationAsynctask()
	 * 引数：Context c;
	 * 概要：
	 * 　LocationAsynctaskクラスのコンストラクタ。
	 *  このクラスで使用する変数のインスタンスを取得したりダイアログを初期化したりしている
	 */
	public LocationAsynctask( Context c ){
		
		//呼び出し元アクティビティのコンテキストを取得
		context = c;
		
		//ロケーションマネージャのインスタンス取得
		//補足：
		//システムサービスはコンテキストクラス内にある(知らなかった)
		manager = ( LocationManager )context.getSystemService( context.LOCATION_SERVICE  );
		//ロケーションリスナを使用することを明記
		manager.requestLocationUpdates( LocationManager.GPS_PROVIDER,
															0, 0, (LocationListener)this);
		
		
		
		//---------------------------------------------------
		//以下、プログレスダイアログの初期化
		
		//表示させるUIコンテキストをもらったのでダイアログのインスタンスを生成
		progress = new ProgressDialog( context );
		//ダイアログのタイトル
		progress.setTitle( R.string.progress_dialog_title );
		//ダイアログのメッセージをセット
		//本当はString.xmlから取得できるようにしたいのだけども、なぜかできないので暫定として直接文字列を入れる
		progress.setMessage( "少々おまちください" );
		//プログレスダイアログの確定（false)不確定(true)を設定する
		//つまり終了を100として「進捗何%ですぅ」と出せるかどうかということか？
		progress.setIndeterminate( true );
		//プログレスダイアログのスタイルを設定
		progress.setProgressStyle( ProgressDialog.STYLE_SPINNER );
		//プログレスの最大値設定
		progress.setMax( PROGRESS_MAX );
		//プログレスがキャンセル可能かどうか設定
		progress.setCancelable( true );
	
		//---------------------------------------------------
		
	}

	@Override
	protected Void doInBackground( Void... params ) {
		
		
		
		
		
		
		/*
		 * 補足：
		 * Void型の関数は戻り値なしのvoid型関数とは異なる。
		 * 従って何かしらの型を戻す必要があるが、この場合特にないのでnullを返す。
		 */
		return null;
	}
	
	@Override
	protected void onProgressUpdate( Integer... prog ){
		
		//プログレスダイアログの値を設定
		progress.incrementProgressBy( prog[ 0 ] );
		//プログレスダイアログの表示
		progress.show();
		
	}

	@Override
	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
		
	}


}
