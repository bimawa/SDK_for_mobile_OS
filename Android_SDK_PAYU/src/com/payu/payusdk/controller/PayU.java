package com.payu.payusdk.controller;

import org.apache.http.util.EncodingUtils;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.payu.payusdk.R;
import com.payu.payusdk.view.PurchaseDialog;
import com.payu.payusdk.view.PurchaseView;

/**
 * ����� ��� �������������� � ������������� PayU
 */
public class PayU {

	private Activity activity;

	public PayU(FragmentActivity activity) {
		this.activity = activity;
	}

	public PayU(Activity activity) {
		this.activity = activity;
	}

	/**
	 * ���������� �������� ��� ������� �� ��������� ALU
	 * 
	 * @param purchase
	 *            ������, ���������� ������ � �������
	 * @param secretKey
	 *            ��������� ���� ��������
	 */
	public void showPurchaseFragment(ALUPurchaseBuilder purchase,
			String secretKey) {
		PurchaseDialog newFragment = new PurchaseDialog();
		Bundle bundle = new Bundle();
		bundle.putParcelable(PurchaseDialog.DATA, purchase);
		bundle.putString(PurchaseDialog.SECRET_KEY, secretKey);
		newFragment.setArguments(bundle);
		newFragment.show(
				((FragmentActivity) activity).getSupportFragmentManager(),
				activity.getString(R.string.tag));
	}

	/**
	 * ��������� ����� ������� �� ��������� LU
	 * 
	 * @param view
	 *            ������������� ��������, ������������� ��� ����������� �����
	 * @param purchase
	 *            ������, ���������� ������ � �������
	 * @param secretKey
	 *            ��������� ���� ��������
	 */
	public PurchaseView loadPurchaseView(PurchaseView view,
			LUPurchaseBuilder purchase, String secretKey) {
		view.postUrl(HttpRequest.PAYU_LU_URL,
				EncodingUtils.getBytes(purchase.build(secretKey), "BASE64"));
		return view;
	}
}
