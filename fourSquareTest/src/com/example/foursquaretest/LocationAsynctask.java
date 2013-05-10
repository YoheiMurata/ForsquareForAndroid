/*
 * LocationAsynctask.java
 * �쐬�ҁFYohei Murata
 * �쐬���F2013�N5��11��
 * �T�v�F
 * ���쎩�̂�LocationListenerService.java�Ɠ����B
 * Android�̃T�[�r�X���g�����AAsynctask���g���������̈Ⴂ�����Ȃ��B
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
 * AsyncTask�ɂ��Ă̕⑫�F
 * AsyncTask�̓A�N�e�B�r�e�B���ł͎��s�ł��Ȃ��悤�ȏ����iUI�X���b�h�������Ԏ~�܂��Ă��܂��\�������鏈��)
 * ���A�N�e�B�r�e�B�Ƃ͈Ⴄ�X���b�h�𐶐����ăo�b�N�O���E���h�Ŏ��s�����邽�߂̃N���X�ł���B
 * AsyncTask�̃N���X�𗘗p����ɂ́AAsyncTask�N���X���X�[�p�[�N���X�Ƃ��Čp������K�v������B
 * AsyncTask�̓W�F�l���N�X�N���X�Ȃ̂ŁA�p�����Ƀp�����[�^�̌^���R�w�肷��K�v������B
 * 
 * public class ..... extends AsyncTask< Param, Progress, Result >
 * Param,Progress,Result�̕����͂��ꂼ��
 * Param: doInBackground���\�b�h���Ŏg�p�������
 * Progress: onProgressUpdate���\�b�h���Ŏg�p�������
 * Result: onPostExecute���\�b�h���Ŏg�p�������
 * �E�E�E�̕ϐ��^���w�肷��B
 * 
 * :�e���\�b�h�̎g����:
 * AsyncTask���̃��\�b�h�͂��ꂼ�ꎟ�̂悤�Ɏg�p����
 * void onPreExecute()�F�@�o�b�N�O���E���h���s�̑O���������邽�߂̏����B�i���j
 * (�߂�l�C��) doInBackground�F�@�o�b�N�O���E���h��Ŏ��s���鏈��
 * void onProgressUpdate�F�@�i���󋵂�UI�X���b�h�ŕ\�����鏈��
 * (�߂�l�C��) onPostExecute�F	�o�b�N�O���E���h�����̎��s�I���̏���
 * (��)��AsyncTask�N���X�p�����Ɏw�肷�邱�Ƃ��ł��Ȃ��B�Ȃ̂ł��������߂�l�̌^���m�肵�Ă���B
 * ����ȊO�͈����̌^���p�����Ɏw�肷��^�Ō��܂�B
 * 
 * ���ӂƂ��ẮA���Ɉ���������Ȃ��Ă����̌`�͋�����Ȃ��B
 * extends AsyncTask< Void, Void, Void >
 * 
 */
public class LocationAsynctask extends AsyncTask<Void, Integer, Void> implements LocationListener{
	
	//�f�o�b�O�p�艼�u���̃^�O
	private static final String DEBUG_TAG = "LOCATION_ASYNCTASK";
	//�v���O���X�_�C�A���O�̍ő�l
	private static final int PROGRESS_MAX = 100;
	//�ʒu���擾�̍Œ�Ԋu�i�~���b)
	private static final int INTERVAL_GET_POSITION_MIN = 100;
	
	//Toast��_�C�A���O���o�����߂ɌĂяo�����̃A�N�e�B�r�e�B�̃R���e�L�X�g�����炤
	private Context context = null;
	//�v���O���X�_�C�A���O���ʒu�����擾���ɕ\�����邽�߂̕ϐ�
	private ProgressDialog progress = null;
	//�ʒu���Ǘ��Ɏg�p����ϐ��݂���
	LocationManager manager;
	//�ʒu���擾�Ɏg�p����ϐ�
	LocationListener mLocationListener;
	
	
	
	/*
	 * LocationAsynctask()
	 * �����FContext c;
	 * �T�v�F
	 * �@LocationAsynctask�N���X�̃R���X�g���N�^�B
	 *  ���̃N���X�Ŏg�p����ϐ��̃C���X�^���X���擾������_�C�A���O�������������肵�Ă���
	 */
	public LocationAsynctask( Context c ){
		
		//�Ăяo�����A�N�e�B�r�e�B�̃R���e�L�X�g���擾
		context = c;
		
		//���P�[�V�����}�l�[�W���̃C���X�^���X�擾
		//�⑫�F
		//�V�X�e���T�[�r�X�̓R���e�L�X�g�N���X���ɂ���(�m��Ȃ�����)
		manager = ( LocationManager )context.getSystemService( context.LOCATION_SERVICE  );
		//���P�[�V�������X�i���g�p���邱�Ƃ𖾋L
		manager.requestLocationUpdates( LocationManager.GPS_PROVIDER,
															0, 0, (LocationListener)this);
		
		
		
		//---------------------------------------------------
		//�ȉ��A�v���O���X�_�C�A���O�̏�����
		
		//�\��������UI�R���e�L�X�g����������̂Ń_�C�A���O�̃C���X�^���X�𐶐�
		progress = new ProgressDialog( context );
		//�_�C�A���O�̃^�C�g��
		progress.setTitle( R.string.progress_dialog_title );
		//�_�C�A���O�̃��b�Z�[�W���Z�b�g
		//�{����String.xml����擾�ł���悤�ɂ������̂����ǂ��A�Ȃ����ł��Ȃ��̂Ŏb��Ƃ��Ē��ڕ����������
		progress.setMessage( "���X���܂���������" );
		//�v���O���X�_�C�A���O�̊m��ifalse)�s�m��(true)��ݒ肷��
		//�܂�I����100�Ƃ��āu�i����%�ł����v�Əo���邩�ǂ����Ƃ������Ƃ��H
		progress.setIndeterminate( true );
		//�v���O���X�_�C�A���O�̃X�^�C����ݒ�
		progress.setProgressStyle( ProgressDialog.STYLE_SPINNER );
		//�v���O���X�̍ő�l�ݒ�
		progress.setMax( PROGRESS_MAX );
		//�v���O���X���L�����Z���\���ǂ����ݒ�
		progress.setCancelable( true );
	
		//---------------------------------------------------
		
	}

	@Override
	protected Void doInBackground( Void... params ) {
		
		
		
		
		
		
		/*
		 * �⑫�F
		 * Void�^�̊֐��͖߂�l�Ȃ���void�^�֐��Ƃ͈قȂ�B
		 * �]���ĉ�������̌^��߂��K�v�����邪�A���̏ꍇ���ɂȂ��̂�null��Ԃ��B
		 */
		return null;
	}
	
	@Override
	protected void onProgressUpdate( Integer... prog ){
		
		//�v���O���X�_�C�A���O�̒l��ݒ�
		progress.incrementProgressBy( prog[ 0 ] );
		//�v���O���X�_�C�A���O�̕\��
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
