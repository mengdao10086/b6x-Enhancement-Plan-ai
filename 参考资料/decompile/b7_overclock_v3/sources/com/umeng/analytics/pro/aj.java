package com.umeng.analytics.pro;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.umeng.analytics.pro.b;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
public class aj implements aa {

    public static final class a implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f23194a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final LinkedBlockingQueue<IBinder> f23195b;

        public IBinder a() throws InterruptedException {
            if (this.f23194a) {
                throw new IllegalStateException();
            }
            this.f23194a = true;
            return this.f23195b.poll(5L, TimeUnit.SECONDS);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f23195b.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }

        private a() {
            this.f23194a = false;
            this.f23195b = new LinkedBlockingQueue<>();
        }
    }

    @Override // com.umeng.analytics.pro.aa
    public String a(Context context) {
        a aVar = new a();
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        if (context.bindService(intent, aVar, 1)) {
            try {
                return b.a.a(aVar.a()).a();
            } catch (Exception unused) {
            } finally {
                context.unbindService(aVar);
            }
        }
        return null;
    }
}
