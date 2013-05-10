/*
 * MapData.java
 * 作成者；YoheiMurata
 * 作成日：2013年5月11日
 * 概要：
 * 　ServiceやAsyncTaskで位置情報を計算した結果を返すようのデータ
 */

package com.example.foursquaretest;

public class MapData {
	
	//緯度と経度
	private double Lat, Lang;

	/*
	 * public MapData
	 * 概要：
	 * コンストラクタ
	 */
	public MapData(){
		Lat = Lang = 0;
	}
	
	/*
	 * public double getLatitude();
	 * 引数：なし
	 * 戻り値：Double
	 * 概要：
	 * 緯度を返す
	 */
	public double getLatitude(){
		return Lat;
	}
	
	/*
	 * public double getLongitude();
	 * 引数：なし
	 * 戻り値：Double
	 * 概要：
	 * 経度を返す
	 */
	public double getLongitude(){
		return Lang;
	}
	
	/*
	 * public void setLang();
	 * 引数：double Latitude;
	 * 戻り値：なし
	 * 概要：
	 * 緯度をセットする
	 */
	public void setLatitude( double Latitude ){
		Lat = Latitude;
	}
	
	/*
	 * public void setLongitude();
	 * 引数：double Longitude;
	 * 戻り値：なし
	 * 概要：
	 * 経度をセット
	 */
	public void setLongitude( double Longitude ){
		Lang = Longitude;
	}
	
}
