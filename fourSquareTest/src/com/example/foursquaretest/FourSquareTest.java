/*
 * FourSquareTest.java
 * �쐬�ҁFYoheiMurata
 * �쐬���F2013�N5��10��
 * �T�v�F
 * �@�㔼���ɒn�}��\�����A��������Venue�i�E�E�E�ł����̂��ȁH�j��\���BVenue��I�������
 * �`�F�b�N�C������@�\���Ƃ肠�����͎�������B
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
	 * �����F�Ȃ�
	 * �Ԃ�l�F�Ȃ�
	 * �T�v�F
	 * �W�I���P�[�V�����̃T�[�r�X���N��������e�X�g���\�b�h
	 */
	@Test
	private void activateService(){
		//intent�̐���
		Intent intent = new Intent( this, LocationListenerService.class );
		//�T�[�r�X�̋N��
		startService( intent );
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_four_square_test, menu);
		return true;
	}

}
