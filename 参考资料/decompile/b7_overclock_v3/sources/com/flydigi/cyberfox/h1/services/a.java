package com.flydigi.cyberfox.h1.services;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.ParcelUuid;
import com.blankj.utilcode.util.i0;
import g.n0;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.UUID;
import o5.h;
import o6.d;

/* JADX INFO: loaded from: classes7.dex */
public abstract class a implements d.a {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final long f14163k = 5000;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BluetoothAdapter f14166c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public UUID f14169f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14164a = "BREDRProvider";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BluetoothDevice f14165b = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f14167d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f14168e = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f14170g = 4;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f14171h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Handler f14172i = new Handler();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f14173j = false;

    /* JADX INFO: renamed from: com.flydigi.cyberfox.h1.services.a$a, reason: collision with other inner class name */
    public class RunnableC0150a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f14174a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ o6.d f14175b;

        public RunnableC0150a(Context context, o6.d dVar) {
            this.f14174a = context;
            this.f14175b = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f14174a.unregisterReceiver(this.f14175b);
            if (a.this.f14173j && a.this.H() == 1) {
                a.this.f14173j = false;
                a.this.W(0);
                a.this.N(0);
            }
        }
    }

    public class b extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final InputStream f14177a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final OutputStream f14178b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final BluetoothSocket f14179c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f14180d = false;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f14181e = "CommunicationThread";

        public b(@n0 BluetoothSocket bluetoothSocket) {
            InputStream inputStream;
            setName("CommunicationThread" + getId());
            this.f14179c = bluetoothSocket;
            OutputStream outputStream = null;
            try {
                inputStream = bluetoothSocket.getInputStream();
                try {
                    outputStream = bluetoothSocket.getOutputStream();
                } catch (IOException unused) {
                }
            } catch (IOException unused2) {
                inputStream = null;
            }
            this.f14177a = inputStream;
            this.f14178b = outputStream;
        }

        public final void b() {
            byte[] bArr = new byte[1024];
            boolean unused = a.this.f14171h;
            this.f14180d = true;
            a.this.L();
            while (a.this.f14170g == 2 && this.f14180d) {
                try {
                    int i10 = this.f14177a.read(bArr);
                    if (i10 > 0) {
                        byte[] bArr2 = new byte[i10];
                        System.arraycopy(bArr, 0, bArr2, 0, i10);
                        if (a.this.f14171h) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Reception of data: ");
                            sb2.append(i6.b.f(bArr2));
                        }
                        a.this.S(bArr2);
                    }
                } catch (IOException e10) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Reception of data failed: exception occurred while reading: ");
                    sb3.append(e10.toString());
                    this.f14180d = false;
                    if (a.this.f14170g == 2) {
                        a.this.Q();
                    }
                    a.this.f14168e = null;
                }
            }
            boolean unused2 = a.this.f14171h;
        }

        public boolean c(byte[] bArr) {
            OutputStream outputStream;
            boolean unused = a.this.f14171h;
            BluetoothSocket bluetoothSocket = this.f14179c;
            if (bluetoothSocket == null || !bluetoothSocket.isConnected() || a.this.f14170g != 2 || (outputStream = this.f14178b) == null) {
                return false;
            }
            try {
                outputStream.write(bArr);
                this.f14178b.flush();
                boolean unused2 = a.this.f14171h;
                return true;
            } catch (IOException e10) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Sending of data failed: Exception occurred while writing data: ");
                sb2.append(e10.toString());
                return false;
            }
        }

        public void cancel() {
            boolean unused = a.this.f14171h;
            this.f14180d = false;
            try {
                this.f14179c.close();
            } catch (IOException e10) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Cancellation of the Thread: Close of BluetoothSocket failed: ");
                sb2.append(e10.toString());
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            if (this.f14177a == null) {
                a.this.B();
                return;
            }
            if (this.f14178b == null) {
                a.this.B();
                return;
            }
            BluetoothSocket bluetoothSocket = this.f14179c;
            if (bluetoothSocket == null) {
                a.this.B();
            } else if (bluetoothSocket.isConnected()) {
                b();
            } else {
                a.this.B();
            }
        }
    }

    public class c extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final BluetoothSocket f14183a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f14184b;

        public /* synthetic */ c(a aVar, BluetoothSocket bluetoothSocket, RunnableC0150a runnableC0150a) {
            this(bluetoothSocket);
        }

        public final void cancel() {
            interrupt();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                if (a.this.f14171h) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Attempt to connect device over BR/EDR: ");
                    sb2.append(a.this.f14165b.getAddress());
                    sb2.append(" using ");
                    sb2.append(a.this.f14169f.equals(f.f14186a) ? "SPP" : "GAIA");
                }
                a.this.f14166c.cancelDiscovery();
                this.f14183a.connect();
                a.this.T(this.f14183a);
            } catch (IOException e10) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Exception while connecting: ");
                sb3.append(e10.toString());
                try {
                    this.f14183a.close();
                } catch (IOException unused) {
                }
                a.this.O();
                a.this.f14167d = null;
            }
        }

        public c(@n0 BluetoothSocket bluetoothSocket) {
            this.f14184b = "ConnectionThread";
            setName("ConnectionThread" + getId());
            this.f14183a = bluetoothSocket;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface d {
        public static final int I = 0;
        public static final int J = 1;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface e {
        public static final int K = 0;
        public static final int L = 1;
        public static final int M = 2;
        public static final int N = 3;
        public static final int O = 4;
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final UUID f14186a = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final UUID f14187b = UUID.fromString("00001107-D102-11E1-9B23-00025B00A5A5");
    }

    public a(BluetoothManager bluetoothManager) {
        if (this.f14171h) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Creation of a new instance of BREDRProvider: ");
            sb2.append(this);
        }
        if (bluetoothManager == null) {
            this.f14166c = BluetoothAdapter.getDefaultAdapter();
        } else {
            this.f14166c = bluetoothManager.getAdapter();
        }
    }

    public static String D(int i10) {
        return i10 != 0 ? i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? h.f42757n : "NO STATE" : "DISCONNECTING" : "CONNECTED" : "CONNECTING" : "DISCONNECTED";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void W(int i10) {
        if (this.f14171h) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Connection state changes from ");
            sb2.append(D(this.f14170g));
            sb2.append(" to ");
            sb2.append(D(i10));
        }
        this.f14170g = i10;
        R(i10);
    }

    public final BluetoothSocket A(BluetoothDevice bluetoothDevice, UUID uuid) {
        if (this.f14171h) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Creating Bluetooth socket for device ");
            sb2.append(bluetoothDevice.getAddress());
            sb2.append(" using UUID ");
            sb2.append(uuid);
        }
        try {
            return r() ? bluetoothDevice.createInsecureRfcommSocketToServiceRecord(uuid) : bluetoothDevice.createRfcommSocketToServiceRecord(uuid);
        } catch (IOException e10) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Exception occurs while creating Bluetooth socket: ");
            sb3.append(e10.toString());
            try {
                return (BluetoothSocket) bluetoothDevice.getClass().getMethod("createRfcommSocket", Integer.TYPE).invoke(bluetoothDevice, 1);
            } catch (Exception unused) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Exception occurs while creating Bluetooth socket by invoking method: ");
                sb4.append(e10.toString());
                return null;
            }
        }
    }

    public boolean B() {
        boolean z10 = this.f14171h;
        String address = i0.f11859x;
        if (z10) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Receives request to disconnect from device ");
            BluetoothDevice bluetoothDevice = this.f14165b;
            sb2.append(bluetoothDevice != null ? bluetoothDevice.getAddress() : i0.f11859x);
        }
        if (this.f14170g == 0) {
            return false;
        }
        W(3);
        t();
        s();
        W(0);
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Provider disconnected from BluetoothDevice ");
        BluetoothDevice bluetoothDevice2 = this.f14165b;
        if (bluetoothDevice2 != null) {
            address = bluetoothDevice2.getAddress();
        }
        sb3.append(address);
        return true;
    }

    public final void C(BluetoothDevice bluetoothDevice, Context context) {
        this.f14173j = true;
        o6.d dVar = new o6.d(this, bluetoothDevice);
        context.registerReceiver(dVar, new IntentFilter("android.bluetooth.device.action.UUID"));
        bluetoothDevice.fetchUuidsWithSdp();
        this.f14172i.postDelayed(new RunnableC0150a(context, dVar), 5000L);
    }

    public BluetoothDevice G() {
        return this.f14165b;
    }

    public synchronized int H() {
        return this.f14170g;
    }

    public final UUID I(ParcelUuid[] parcelUuidArr) {
        if (parcelUuidArr == null) {
            return null;
        }
        for (ParcelUuid parcelUuid : parcelUuidArr) {
            UUID uuid = parcelUuid.getUuid();
            if (u(uuid)) {
                return uuid;
            }
        }
        return null;
    }

    public final boolean J() {
        return this.f14166c != null;
    }

    public boolean K() {
        b bVar;
        return this.f14170g == 2 && (bVar = this.f14168e) != null && bVar.f14180d;
    }

    public abstract void L();

    public abstract void N(int i10);

    public final void O() {
        W(0);
        N(0);
    }

    public final void Q() {
        W(0);
        N(1);
    }

    public abstract void R(int i10);

    public abstract void S(byte[] bArr);

    public final void T(BluetoothSocket bluetoothSocket) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Successful connection to device: ");
        sb2.append(G().getAddress());
        t();
        s();
        W(2);
        b bVar = new b(bluetoothSocket);
        this.f14168e = bVar;
        bVar.start();
    }

    public boolean U(@n0 Context context) {
        BluetoothDevice bluetoothDevice = this.f14165b;
        return bluetoothDevice != null && w(bluetoothDevice, context);
    }

    public boolean V(byte[] bArr) {
        synchronized (this) {
            if (this.f14170g != 2) {
                return false;
            }
            b bVar = this.f14168e;
            if (bVar == null) {
                return false;
            }
            return bVar.c(bArr);
        }
    }

    public void X(boolean z10) {
        this.f14171h = z10;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Debug logs are now ");
        sb2.append(z10 ? "activated" : "deactivated");
        sb2.append(j3.b.f36044h);
    }

    @Override // o6.d.a
    public void a(BluetoothDevice bluetoothDevice, ParcelUuid[] parcelUuidArr) {
        UUID uuidI;
        if (!this.f14173j || parcelUuidArr == null || parcelUuidArr.length <= 0 || bluetoothDevice == null || (uuidI = I(parcelUuidArr)) == null) {
            return;
        }
        this.f14173j = false;
        x(bluetoothDevice, uuidI);
    }

    @SuppressLint({"ObsoleteSdkInt"})
    public final boolean r() {
        return true;
    }

    public final void s() {
        b bVar = this.f14168e;
        if (bVar != null) {
            bVar.cancel();
            this.f14168e = null;
        }
    }

    public final void t() {
        c cVar = this.f14167d;
        if (cVar != null) {
            cVar.cancel();
            this.f14167d = null;
        }
    }

    public final boolean u(UUID uuid) {
        return uuid.equals(f.f14186a) || uuid.equals(f.f14187b);
    }

    public final boolean w(@n0 BluetoothDevice bluetoothDevice, @n0 Context context) {
        if (this.f14171h) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Request received to connect to a BluetoothDevice ");
            sb2.append(bluetoothDevice.getAddress());
        }
        if (this.f14170g == 2) {
            return false;
        }
        if ((bluetoothDevice.getType() != 1 && bluetoothDevice.getType() != 3) || !J() || !BluetoothAdapter.checkBluetoothAddress(bluetoothDevice.getAddress())) {
            return false;
        }
        ParcelUuid[] uuids = bluetoothDevice.getUuids();
        if (uuids == null) {
            C(bluetoothDevice, context);
            return true;
        }
        UUID uuidI = I(uuids);
        if (uuidI == null && bluetoothDevice.getBondState() != 12) {
            uuidI = f.f14186a;
        } else if (uuidI == null) {
            return false;
        }
        return x(bluetoothDevice, uuidI);
    }

    public final boolean x(@n0 BluetoothDevice bluetoothDevice, @n0 UUID uuid) {
        if (this.f14171h) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Request received to connect to a BluetoothDevice with UUID ");
            sb2.append(uuid.toString());
        }
        if (this.f14170g == 2 && this.f14168e != null) {
            return false;
        }
        t();
        s();
        W(1);
        BluetoothSocket bluetoothSocketA = A(bluetoothDevice, uuid);
        if (bluetoothSocketA == null) {
            return false;
        }
        if (this.f14171h) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Request connect to BluetoothDevice ");
            sb3.append(bluetoothSocketA.getRemoteDevice().getAddress());
            sb3.append(" over RFCOMM starts.");
        }
        this.f14169f = uuid;
        this.f14165b = bluetoothDevice;
        c cVar = new c(this, bluetoothSocketA, null);
        this.f14167d = cVar;
        cVar.start();
        return true;
    }

    public boolean z(String str, @n0 Context context) {
        BluetoothDevice remoteDevice;
        if (this.f14171h) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Request received to connect to a device with address ");
            sb2.append(str);
        }
        if (str == null || str.length() == 0 || !J() || !BluetoothAdapter.checkBluetoothAddress(str) || (remoteDevice = this.f14166c.getRemoteDevice(str)) == null) {
            return false;
        }
        return w(remoteDevice, context);
    }
}
