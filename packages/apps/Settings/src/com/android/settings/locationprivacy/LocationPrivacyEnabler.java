package com.android.settings.locationprivacy;

import android.content.Context;
import android.locationprivacy.control.LocationPrivacyManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Switch;

/**
 * Stellt ein Switch-Element zum Ein- und Ausschalten des
 * Location-Privacy-Frameworks zur Verf�gung
 * 
 * @author Christian Kater
 * 
 */
public class LocationPrivacyEnabler {
	private Switch mSwitch;
	private LocationPrivacyManager mLPService;

	private OnClickListener listener = new OnClickListener() {

		public void onClick(View v) {
			mLPService.setStatus(mSwitch.isChecked());
		}

	};

	/**
	 * Instanziiert ein neues LocationPrivacyEnabler-Objekt
	 * @param context Context in dem das LocationPrivacyEnabler-Objekt ausgef�hrt wird
	 */
	public LocationPrivacyEnabler(Context context) {
		mLPService = new LocationPrivacyManager(context);
	}

	/**
	 * Initialisiert den Switch
	 */
	public void resume() {
		if (mSwitch != null) {
			mSwitch.setChecked(mLPService.getStatus());
			mSwitch.setOnClickListener(listener);
		}

	}

	/**
	 * Setzt ein neues Switch.Dieser wird anschlie�end initialisiert.
	 * @param aSwitch neues Switch
	 */
	public void setSwitch(Switch aSwitch) {
		mSwitch = aSwitch;
		resume();
	}

}
