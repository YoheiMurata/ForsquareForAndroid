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
import android.location.LocationManager;
import android.os.IBinder;
import android.widget.Toast;

public class LocationListenerService extends Service{

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
		
		//�ǂ̂悤�Ɉʒu���̎擾���s������̂��킩��Ȃ��B
		//�C���X�^���X���擾�ł��Ȃ��̂��ȁH�Ǝv���Ȃ��牽�ƂȂ������̏������ɂȂ����B
		if(mLocationManager == null){
			Toast.makeText( this, R.string.label_failed_to_get_instance, Toast.LENGTH_LONG ).show();
		}else{
		
		//���ݒn�擾���̃��b�Z�[�W���o���B
		Toast.makeText(this, R.string.label_now_listening, Toast.LENGTH_LONG).show();
	
		}
	}
	
	

	
}
