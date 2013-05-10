/*
 * MapData.java
 * �쐬�ҁGYoheiMurata
 * �쐬���F2013�N5��11��
 * �T�v�F
 * �@Service��AsyncTask�ňʒu�����v�Z�������ʂ�Ԃ��悤�̃f�[�^
 */

package com.example.foursquaretest;

public class MapData {
	
	//�ܓx�ƌo�x
	private double Lat, Lang;

	/*
	 * public MapData
	 * �T�v�F
	 * �R���X�g���N�^
	 */
	public MapData(){
		Lat = Lang = 0;
	}
	
	/*
	 * public double getLatitude();
	 * �����F�Ȃ�
	 * �߂�l�FDouble
	 * �T�v�F
	 * �ܓx��Ԃ�
	 */
	public double getLatitude(){
		return Lat;
	}
	
	/*
	 * public double getLongitude();
	 * �����F�Ȃ�
	 * �߂�l�FDouble
	 * �T�v�F
	 * �o�x��Ԃ�
	 */
	public double getLongitude(){
		return Lang;
	}
	
	/*
	 * public void setLang();
	 * �����Fdouble Latitude;
	 * �߂�l�F�Ȃ�
	 * �T�v�F
	 * �ܓx���Z�b�g����
	 */
	public void setLatitude( double Latitude ){
		Lat = Latitude;
	}
	
	/*
	 * public void setLongitude();
	 * �����Fdouble Longitude;
	 * �߂�l�F�Ȃ�
	 * �T�v�F
	 * �o�x���Z�b�g
	 */
	public void setLongitude( double Longitude ){
		Lang = Longitude;
	}
	
}
