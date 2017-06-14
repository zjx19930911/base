package com.cpic.team.basetools.utils;

import android.content.Context;
import android.widget.Toast;

import com.sdsmdg.tastytoast.TastyToast;

import cn.pedant.SweetAlert.SweetAlertDialog;

import static com.cpic.team.basetools.base.BaseConfig.context;


public class ToastUtils {
    public static Toast mToast;

    public static void showToast(final String message) {
        if (mToast == null) {
            mToast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(message);
            mToast.setDuration(Toast.LENGTH_SHORT);
        }
        mToast.show();
    }


    public static void showFailedDiaLog(Context context, final String message) {
        new SweetAlertDialog(context, SweetAlertDialog.ERROR_TYPE)
                .setTitleText(message)
                .setConfirmText("确     定").setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
            @Override
            public void onClick(SweetAlertDialog sweetAlertDialog) {
                sweetAlertDialog.dismissWithAnimation();
            }
        }).show();
    }

    public static void showSucessDiaLog(Context context, final String message) {
        new SweetAlertDialog(context, SweetAlertDialog.SUCCESS_TYPE)
                .setTitleText(message)
                .setConfirmText("确     定").setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
            @Override
            public void onClick(SweetAlertDialog sweetAlertDialog) {
                sweetAlertDialog.dismissWithAnimation();
            }
        }).show();
    }

    public static void showWarningDiaLog(Context context, final String message) {
        new SweetAlertDialog(context, SweetAlertDialog.WARNING_TYPE)
                .setTitleText(message)
                .setConfirmText("确     定").setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
            @Override
            public void onClick(SweetAlertDialog sweetAlertDialog) {
                sweetAlertDialog.dismissWithAnimation();
            }
        }).show();
    }


    public static void showSucessToast(final String message) {
        TastyToast.makeText(context, message, Toast.LENGTH_LONG, TastyToast.SUCCESS);
    }


    public static void showFailedToast(final String message) {
        TastyToast.makeText(context, message, Toast.LENGTH_LONG, TastyToast.ERROR);
    }

    public static void showWarningToast(final String message) {
        TastyToast.makeText(context, message, Toast.LENGTH_LONG, TastyToast.WARNING);
    }

    public static void showConfuseToast(final String message) {
        TastyToast.makeText(context, message, Toast.LENGTH_LONG, TastyToast.CONFUSING);
    }

    public static void showToast(final int messageResId) {
        if (mToast == null) {
            mToast = Toast.makeText(context, messageResId, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(messageResId);
            mToast.setDuration(Toast.LENGTH_SHORT);
        }
        mToast.show();
    }
}
