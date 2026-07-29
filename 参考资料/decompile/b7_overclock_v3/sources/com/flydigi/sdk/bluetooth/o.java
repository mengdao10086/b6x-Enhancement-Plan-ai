package com.flydigi.sdk.bluetooth;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public abstract class o extends AbstractDataInteractionController {

    @yt.l
    public b I;

    @yt.l
    public a J;

    @yt.l
    public BluetoothSocket K;

    public final class a extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @yt.k
        public final BluetoothSocket f16299a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f16300b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final InputStream f16301c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final OutputStream f16302d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ o f16303e;

        public a(@yt.k o oVar, BluetoothSocket socket) {
            kotlin.jvm.internal.f0.p(socket, "socket");
            this.f16303e = oVar;
            this.f16299a = socket;
            this.f16301c = socket.getInputStream();
            this.f16302d = socket.getOutputStream();
        }

        public final void a() {
            byte[] bArr = new byte[1048576];
            this.f16300b = true;
            while (this.f16303e.V0() == 2 && this.f16300b) {
                try {
                    int i10 = this.f16301c.read(bArr);
                    if (i10 > 0) {
                        byte[] bArr2 = new byte[i10];
                        System.arraycopy(bArr, 0, bArr2, 0, i10);
                        o oVar = this.f16303e;
                        oVar.Z0(oVar.X0(), bArr2);
                    }
                } catch (Exception unused) {
                    l9.a.f("listenStream occur exception");
                    this.f16300b = false;
                    if (this.f16303e.V0() == 2) {
                        this.f16303e.p1();
                    }
                    this.f16303e.J = null;
                    return;
                }
            }
        }

        public final boolean b(@yt.k byte[] data) {
            kotlin.jvm.internal.f0.p(data, "data");
            l9.a.c("sendStream " + AbstractDataInteractionControllerKt.b(data, null, 1, null));
            if (!this.f16299a.isConnected()) {
                l9.a.f("socket is disconnected");
                return false;
            }
            if (this.f16303e.V0() != 2) {
                l9.a.f("mGattConnectState = GattState.STATE_GATT_CONNECTED");
                return false;
            }
            OutputStream outputStream = this.f16302d;
            if (outputStream == null) {
                l9.a.f("mOutputStream is null");
                return false;
            }
            try {
                outputStream.write(data);
                this.f16302d.flush();
                return true;
            } catch (Exception unused) {
                l9.a.f("mOutputStream occur exception");
                return false;
            }
        }

        public final void cancel() {
            interrupt();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            if (this.f16301c == null) {
                l9.a.f("mInputStream is null");
                this.f16303e.m1();
            } else if (this.f16302d == null) {
                l9.a.f("mOutputStream is null");
                this.f16303e.m1();
            } else if (this.f16299a.isConnected()) {
                this.f16303e.n1();
                a();
            } else {
                l9.a.f("socket is disconnected");
                this.f16303e.m1();
            }
        }
    }

    public final class b extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @yt.k
        public final BluetoothSocket f16304a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ o f16305b;

        public b(@yt.k o oVar, BluetoothSocket socket) {
            kotlin.jvm.internal.f0.p(socket, "socket");
            this.f16305b = oVar;
            this.f16304a = socket;
        }

        public final void cancel() {
            interrupt();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                this.f16305b.F0();
                this.f16304a.connect();
                l9.a.e("Connect to the remote device through the socket.");
                this.f16305b.q1(this.f16304a);
            } catch (Exception e10) {
                l9.a.f("Could not connect the client socket:" + e10);
                try {
                    this.f16304a.close();
                } catch (Exception e11) {
                    l9.a.f("Could not close the client socket:" + e11);
                }
                this.f16305b.o1();
                this.f16305b.I = null;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(@yt.k Context mContext, @yt.k u filter, int i10) {
        super(mContext, filter, i10);
        kotlin.jvm.internal.f0.p(mContext, "mContext");
        kotlin.jvm.internal.f0.p(filter, "filter");
    }

    @Override // com.flydigi.sdk.bluetooth.AbstractDataInteractionController
    public void T0() throws IOException {
        BluetoothDevice bluetoothDeviceM = M();
        if (bluetoothDeviceM != null) {
            if (bluetoothDeviceM.getType() != 1 && bluetoothDeviceM.getType() != 3) {
                l9.a.f("current device is not a valid classic device");
                return;
            }
            BluetoothSocket bluetoothSocketCreateInsecureRfcommSocketToServiceRecord = bluetoothDeviceM.createInsecureRfcommSocketToServiceRecord(X0());
            if (bluetoothSocketCreateInsecureRfcommSocketToServiceRecord != null) {
                kotlin.jvm.internal.f0.o(bluetoothSocketCreateInsecureRfcommSocketToServiceRecord, "createInsecureRfcommSock…erviceRecord(serviceUUID)");
                this.K = bluetoothSocketCreateInsecureRfcommSocketToServiceRecord;
                b bVar = new b(this, bluetoothSocketCreateInsecureRfcommSocketToServiceRecord);
                this.I = bVar;
                bVar.start();
            }
        }
    }

    @Override // com.flydigi.sdk.bluetooth.AbstractDataInteractionController
    public void Z0(@yt.k UUID uuid, @yt.k byte[] value) {
        kotlin.jvm.internal.f0.p(uuid, "uuid");
        kotlin.jvm.internal.f0.p(value, "value");
        if (l9.a.f39473a.b()) {
            l9.a.c("onReceiveDataFromDevice:" + AbstractDataInteractionControllerKt.b(value, null, 1, null));
        }
    }

    @Override // com.flydigi.sdk.bluetooth.AbstractDataInteractionController
    public void f1(@yt.k j9.b pack) {
        kotlin.jvm.internal.f0.p(pack, "pack");
        a aVar = this.J;
        boolean z10 = false;
        if (aVar != null && aVar.b(pack.k())) {
            z10 = true;
        }
        if (z10) {
            l9.a.e("writeToBluetoothDevice success: " + AbstractDataInteractionControllerKt.b(pack.k(), null, 1, null));
            return;
        }
        l9.a.f("writeToBluetoothDevice failed: " + AbstractDataInteractionControllerKt.b(pack.k(), null, 1, null));
    }

    public final void j1() {
        a aVar = this.J;
        if (aVar != null) {
            aVar.cancel();
        }
        this.J = null;
    }

    public final void k1() {
        b bVar = this.I;
        if (bVar != null) {
            bVar.cancel();
        }
        this.I = null;
    }

    public final void l1() {
        m1();
        BluetoothSocket bluetoothSocket = this.K;
        if (bluetoothSocket != null) {
            bluetoothSocket.close();
        }
    }

    public final void m1() {
        k1();
        j1();
        d1(0);
    }

    public void n1() {
    }

    public final void o1() {
        d1(0);
        e0(M());
    }

    public final void p1() {
        d1(0);
        e0(M());
    }

    @g.i
    public void q1(@yt.k BluetoothSocket socket) {
        kotlin.jvm.internal.f0.p(socket, "socket");
        l9.a.c("onSocketConnected");
        d1(2);
        k1();
        j1();
        a aVar = new a(this, socket);
        this.J = aVar;
        aVar.start();
    }
}
