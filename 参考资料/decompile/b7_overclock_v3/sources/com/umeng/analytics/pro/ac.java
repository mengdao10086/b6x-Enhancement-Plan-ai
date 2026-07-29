package com.umeng.analytics.pro;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.umeng.analytics.pro.a;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
public class ac implements aa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23171a = "Coolpad";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f23172b = "com.coolpad.deviceidsupport";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f23173c = "com.coolpad.deviceidsupport.DeviceIdService";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static a f23174d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private CountDownLatch f23176f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Context f23177g;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f23175e = "";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ServiceConnection f23178h = new ServiceConnection() { // from class: com.umeng.analytics.pro.ac.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                a unused = ac.f23174d = a.AbstractBinderC0252a.a(iBinder);
                ac.this.f23175e = ac.f23174d.b(ac.this.f23177g.getPackageName());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("onServiceConnected: oaid = ");
                sb2.append(ac.this.f23175e);
            } catch (RemoteException | NullPointerException e10) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("onServiceConnected failed e=");
                sb3.append(e10.getMessage());
            }
            ac.this.f23176f.countDown();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            a unused = ac.f23174d = null;
        }
    };

    private void b(Context context) {
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(f23172b, f23173c));
            context.bindService(intent, this.f23178h, 1);
        } catch (Throwable th2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("bindService failed. e=");
            sb2.append(th2.getMessage());
            this.f23176f.countDown();
        }
    }

    private void c(Context context) {
        try {
            context.unbindService(this.f23178h);
        } catch (Throwable th2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("unbindService failed. e=");
            sb2.append(th2.getMessage());
        }
    }

    @Override // com.umeng.analytics.pro.aa
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        this.f23177g = context.getApplicationContext();
        this.f23176f = new CountDownLatch(1);
        try {
            b(context);
            this.f23176f.await(500L, TimeUnit.MILLISECONDS);
            return this.f23175e;
        } catch (InterruptedException e10) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("getOAID interrupted. e=");
            sb2.append(e10.getMessage());
            return null;
        } finally {
            c(context);
        }
    }
}
