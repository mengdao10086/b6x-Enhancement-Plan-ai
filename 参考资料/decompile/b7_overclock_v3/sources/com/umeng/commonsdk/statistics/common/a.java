package com.umeng.commonsdk.statistics.common;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes5.dex */
public class a {

    /* JADX INFO: renamed from: com.umeng.commonsdk.statistics.common.a$a, reason: collision with other inner class name */
    public static final class C0261a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f24184a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f24185b;

        public C0261a(String str, boolean z10) {
            this.f24184a = str;
            this.f24185b = z10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String b() {
            return this.f24184a;
        }

        public boolean a() {
            return this.f24185b;
        }
    }

    public static final class b implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f24186a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final LinkedBlockingQueue<IBinder> f24187b;

        private b() {
            this.f24186a = false;
            this.f24187b = new LinkedBlockingQueue<>(1);
        }

        public IBinder a() throws InterruptedException {
            if (this.f24186a) {
                throw new IllegalStateException();
            }
            this.f24186a = true;
            return this.f24187b.take();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f24187b.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public static String a(Context context) {
        try {
            C0261a c0261aC = c(context);
            if (c0261aC != null && !c0261aC.a()) {
                return c0261aC.b();
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static String b(Context context) {
        try {
            C0261a c0261aC = c(context);
            if (c0261aC == null) {
                return null;
            }
            return c0261aC.b();
        } catch (Exception unused) {
            return null;
        }
    }

    private static C0261a c(Context context) throws Exception {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return null;
        }
        try {
            if (com.umeng.commonsdk.utils.b.a().a(context, "com.android.vending", 0) == null) {
                return null;
            }
            b bVar = new b();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            try {
                if (!context.bindService(intent, bVar, 1)) {
                    throw new IOException("Google Play connection failed");
                }
                try {
                    c cVar = new c(bVar.a());
                    boolean zA = cVar.a(true);
                    return new C0261a(zA ? "" : cVar.a(), zA);
                } catch (Exception e10) {
                    throw e10;
                }
            } finally {
                context.unbindService(bVar);
            }
        } catch (Exception e11) {
            throw e11;
        }
    }

    public static final class c implements IInterface {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private IBinder f24188a;

        public c(IBinder iBinder) {
            this.f24188a = iBinder;
        }

        public String a() throws RemoteException {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f24188a.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readString();
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f24188a;
        }

        public boolean a(boolean z10) throws RemoteException {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                parcelObtain.writeInt(z10 ? 1 : 0);
                this.f24188a.transact(2, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readInt() != 0;
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }
    }
}
