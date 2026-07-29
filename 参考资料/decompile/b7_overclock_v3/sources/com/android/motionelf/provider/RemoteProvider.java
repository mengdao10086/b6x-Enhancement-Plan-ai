package com.android.motionelf.provider;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Parcelable;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.android.motionelf.FloatingWindow;
import com.flydigi.base.common.n;
import com.flydigi.baseProvider.IRemoteProvider;
import com.flydigi.data.DataConstant;
import i9.a;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
@Route(path = a.g.f31983b)
public class RemoteProvider implements IRemoteProvider {
    @Override // com.flydigi.baseProvider.IRemoteProvider
    public void a(Context context) {
        o(context, new Intent(context, (Class<?>) FloatingWindow.class));
    }

    @Override // com.flydigi.baseProvider.IRemoteProvider
    public void c(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) FloatingWindow.class);
        intent.setAction(DataConstant.REMOTE_ACTION_FLOAT_WINDOW);
        intent.putExtra(DataConstant.REMOTE_ACTION_FLOAT_WINDOW, str);
        o(context, intent);
    }

    @Override // com.flydigi.baseProvider.IRemoteProvider
    public void d(Context context, String str, String str2, int i10) {
        Intent intent = new Intent(context, (Class<?>) FloatingWindow.class);
        intent.setAction(str);
        intent.putExtra(str2, i10);
        o(context, intent);
    }

    @Override // com.flydigi.baseProvider.IRemoteProvider
    public void e(Context context, String str, String str2, String str3) {
        Intent intent = new Intent(context, (Class<?>) FloatingWindow.class);
        intent.setAction(str);
        intent.putExtra(str2, str3);
        o(context, intent);
    }

    @Override // com.flydigi.baseProvider.IRemoteProvider
    public void f(Context context, String str, String str2, String str3) {
        Intent intent = new Intent(context, (Class<?>) FloatingWindow.class);
        intent.setAction(DataConstant.REMOTE_ACTION_FLOAT_WINDOW);
        intent.putExtra(DataConstant.REMOTE_ACTION_FLOAT_WINDOW, str);
        intent.putExtra(str2, str3);
        o(context, intent);
    }

    @Override // com.flydigi.baseProvider.IRemoteProvider
    public void g(Context context, String str, String str2, Serializable serializable) {
        Intent intent = new Intent(context, (Class<?>) FloatingWindow.class);
        intent.setAction(str);
        intent.putExtra(str2, serializable);
        o(context, intent);
    }

    @Override // com.flydigi.baseProvider.IRemoteProvider
    public void h(Context context, String str, String str2, Parcelable parcelable) {
        Intent intent = new Intent(context, (Class<?>) FloatingWindow.class);
        intent.setAction(str);
        intent.putExtra(str2, parcelable);
        o(context, intent);
    }

    @Override // com.flydigi.baseProvider.IRemoteProvider
    public void i(Context context, String str, String str2, float f10, String str3, float f11, String str4, float f12, String str5, float f13, String str6, float f14, String str7, float f15) {
        Intent intent = new Intent(context, (Class<?>) FloatingWindow.class);
        intent.setAction(str);
        intent.putExtra(str2, f10);
        intent.putExtra(str3, f11);
        intent.putExtra(str4, f12);
        intent.putExtra(str5, f13);
        intent.putExtra(str6, f14);
        intent.putExtra(str7, f15);
        o(context, intent);
    }

    @Override // com.alibaba.android.arouter.facade.template.IProvider
    public void init(Context context) {
    }

    @Override // com.flydigi.baseProvider.IRemoteProvider
    public void k(Context context, boolean z10) {
        Intent intent = new Intent(context, (Class<?>) FloatingWindow.class);
        intent.setAction(DataConstant.DEVICE_KILL_SERVICE);
        intent.putExtra(DataConstant.KILL_DRIVER_PID, z10);
        o(context, intent);
    }

    @Override // com.flydigi.baseProvider.IRemoteProvider
    public void l(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) FloatingWindow.class);
        intent.setAction(str);
        o(context, intent);
    }

    @Override // com.flydigi.baseProvider.IRemoteProvider
    public void m(Context context, String str, String str2, byte[] bArr) {
        Intent intent = new Intent(context, (Class<?>) FloatingWindow.class);
        intent.setAction(str);
        intent.putExtra(str2, bArr);
        o(context, intent);
    }

    @Override // com.flydigi.baseProvider.IRemoteProvider
    public void n(Context context, String str, String str2, boolean z10) {
        Intent intent = new Intent(context, (Class<?>) FloatingWindow.class);
        intent.setAction(str);
        intent.putExtra(str2, z10);
        o(context, intent);
    }

    public final void o(Context context, Intent intent) {
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                context.startForegroundService(intent);
            } else {
                context.startService(intent);
            }
        } catch (RuntimeException e10) {
            n.c(e10.getMessage(), new Object[0]);
        }
    }
}
