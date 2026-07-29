package com.umeng.analytics.pro;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
class ae implements aa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23182a = "com.uodis.opendevice.aidl.OpenDeviceIdentifierService";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f23183b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f23184c = 2;

    public static final class a implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f23185a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final LinkedBlockingQueue<IBinder> f23186b;

        private a() {
            this.f23185a = false;
            this.f23186b = new LinkedBlockingQueue<>();
        }

        public IBinder a() throws InterruptedException {
            if (this.f23185a) {
                throw new IllegalStateException();
            }
            this.f23185a = true;
            return this.f23186b.poll(5L, TimeUnit.SECONDS);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f23186b.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public static final class b implements IInterface {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private IBinder f23187a;

        public b(IBinder iBinder) {
            this.f23187a = iBinder;
        }

        public String a() throws RemoteException {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken(ae.f23182a);
                this.f23187a.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readString();
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f23187a;
        }

        public boolean b() throws RemoteException {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken(ae.f23182a);
                this.f23187a.transact(2, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readInt() != 0;
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }
    }

    @Override // com.umeng.analytics.pro.aa
    public String a(Context context) {
        a aVar = new a();
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage("com.huawei.hwid");
        if (context.bindService(intent, aVar, 1)) {
            try {
                return new b(aVar.a()).a();
            } catch (Exception unused) {
            } finally {
                context.unbindService(aVar);
            }
        }
        return null;
    }
}
