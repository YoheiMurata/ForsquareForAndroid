/*
 * LocatinoListenerService.java
 * �쐬�ҁFYohei Murata
 * �쐬���F2013�N5��10��
 * �T�v�F
 * �W�I���P�[�V�������g�p���Č��ݒn�̍��W���擾����T�[�r�X
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
	
	//�f�o�b�O���O�p�̃^�O
	private static final String DEBUG_TAG = "TEST_LOCATION_SERVICE";

	//�W�I���P�[�V�����̊Ǘ������邽�߂̕ϐ�
	//�ꉞnull�ɂ��ď�����
	private LocationManager mLocationManager = null;

	
	//�K���I�[�o�[���C�h���Ȃ��ƍs���Ȃ����\�b�h�B
	//�Ƃ��ɂ�邱�ƂȂ��̂Ŏ��������̂܂�
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void onStart( Intent intent, int startId ){
		
		//�W�I���P�[�V�����}�l�[�W���̃C���X�^���X�擾
		mLocationManager = ( LocationManager ) getSystemService( LOCATION_SERVICE );
		
		mLocationManager.requestLocationUpdates( LocationManager.GPS_PROVIDER, 0, 0, (LocationListener) this );
		
		//���ݒn�擾���̃��b�Z�[�W���o���B
		Toast.makeText(this, R.string.label_now_listening, Toast.LENGTH_LONG).show();
		

	}

	@Override
	//�ʒu��񂪕ω������ꍇ�̏���
	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub
		Log.v( DEBUG_TAG, "onLocationChanged" );
		Toast.makeText( this, "Lat: "+location.getLatitude(), Toast.LENGTH_SHORT ).show();
		Toast.makeText( this, "Lang: "+location.getLongitude(), Toast.LENGTH_SHORT ).show();
	}

	@Override
	//geolocation���g�p�ł��Ȑݒ�ɂȂ��Ă����ꍇ�͂����ɓ���͂�
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
		Log.v( DEBUG_TAG, "onProviderDisabled" );
		
		//�Ƃ肠�������b�Z�[�W���o��
		Toast.makeText( this, R.string.label_failed_to_get_instance, Toast.LENGTH_LONG ).show();
	
	}

	@Override
	//geolocation���g�p�ł���󋵂ɂȂ����ꍇ�̏���
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
		
		Log.v( DEBUG_TAG, "onProviderEnabled" );
		
	}

	@Override
	//geolocation�̐ݒ肪�ω������Ƃ��̏����i���Ǝv���j
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
		
		Log.v( DEBUG_TAG, "onStatusChanged" );
	}
	
	

	
}
