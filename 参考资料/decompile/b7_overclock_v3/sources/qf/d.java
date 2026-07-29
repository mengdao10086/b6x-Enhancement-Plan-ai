package qf;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import wf.e;
import yt.k;

/* JADX INFO: loaded from: classes7.dex */
public class d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static UUID f47334g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final UUID f47335h = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final UUID f47336i = UUID.fromString("66666666-6666-6666-6666-666666666666");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static volatile d f47337j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f47338k = 1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f47339l = 2;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f47340m = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BluetoothSocket f47342b;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b f47346f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f47341a = getClass().getSimpleName();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f47343c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f47344d = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<rf.a> f47345e = new ArrayList();

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final BluetoothDevice f47347a;

        public a(BluetoothDevice bluetoothDevice) {
            this.f47347a = bluetoothDevice;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                d.this.f47343c = 1;
                d.this.f47342b = this.f47347a.createInsecureRfcommSocketToServiceRecord(d.f47334g);
                d.this.f47342b.connect();
                d dVar = d.this;
                dVar.f47346f = dVar.new b(dVar.f47342b.getInputStream(), d.this.f47342b.getOutputStream());
                d.this.l(true);
                new Thread(d.this.f47346f).start();
            } catch (IOException e10) {
                e10.printStackTrace();
                d.this.l(false);
            }
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final OutputStream f47349a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final InputStream f47350b;

        public b(InputStream inputStream, OutputStream outputStream) {
            this.f47350b = inputStream;
            this.f47349a = outputStream;
        }

        public boolean a(byte[] bArr) {
            try {
                this.f47349a.write(bArr);
                return true;
            } catch (IOException e10) {
                e10.printStackTrace();
                d.this.l(false);
                return false;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                try {
                    byte[] bArr = new byte[1048576];
                    e.g("SPP", "connected thread run");
                    while (true) {
                        d.this.m(wf.a.g(bArr, 0, this.f47350b.read(bArr)));
                    }
                } catch (IOException e10) {
                    e10.printStackTrace();
                    d.this.l(false);
                    try {
                        InputStream inputStream = this.f47350b;
                        if (inputStream != null) {
                            inputStream.close();
                        }
                    } catch (IOException e11) {
                        e11.printStackTrace();
                    }
                }
            } catch (Throwable th2) {
                try {
                    InputStream inputStream2 = this.f47350b;
                    if (inputStream2 != null) {
                        inputStream2.close();
                    }
                } catch (IOException e12) {
                    e12.printStackTrace();
                }
                throw th2;
            }
        }
    }

    public static d k() {
        if (f47337j == null) {
            synchronized (d.class) {
                if (f47337j == null) {
                    f47337j = new d();
                }
            }
        }
        return f47337j;
    }

    public void h(rf.a aVar) {
        synchronized (this.f47344d) {
            if (!this.f47345e.contains(aVar)) {
                this.f47345e.add(aVar);
            }
        }
    }

    public boolean i(@k BluetoothDevice bluetoothDevice, boolean z10) {
        int i10 = this.f47343c;
        if (i10 == 1 || i10 == 2) {
            return false;
        }
        if (z10) {
            f47334g = f47335h;
        } else {
            f47334g = f47336i;
        }
        new Thread(new a(bluetoothDevice)).start();
        return true;
    }

    public void j() {
        try {
            BluetoothSocket bluetoothSocket = this.f47342b;
            if (bluetoothSocket != null) {
                bluetoothSocket.close();
            }
            l(false);
        } catch (IOException e10) {
            e10.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l(boolean r5) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.f47344d
            monitor-enter(r0)
            if (r5 == 0) goto L26
            int r1 = r4.f47343c     // Catch: java.lang.Throwable -> L24
            r2 = 2
            if (r1 == r2) goto L26
            java.util.List<rf.a> r5 = r4.f47345e     // Catch: java.lang.Throwable -> L24
            java.util.Iterator r5 = r5.iterator()     // Catch: java.lang.Throwable -> L24
        L10:
            boolean r1 = r5.hasNext()     // Catch: java.lang.Throwable -> L24
            if (r1 == 0) goto L21
            java.lang.Object r1 = r5.next()     // Catch: java.lang.Throwable -> L24
            rf.a r1 = (rf.a) r1     // Catch: java.lang.Throwable -> L24
            r3 = 1
            r1.A2(r3)     // Catch: java.lang.Throwable -> L24
            goto L10
        L21:
            r4.f47343c = r2     // Catch: java.lang.Throwable -> L24
            goto L4a
        L24:
            r5 = move-exception
            goto L4c
        L26:
            if (r5 != 0) goto L4a
            int r5 = r4.f47343c     // Catch: java.lang.Throwable -> L24
            if (r5 == 0) goto L4a
            r5 = 0
            r4.f47342b = r5     // Catch: java.lang.Throwable -> L24
            r4.f47346f = r5     // Catch: java.lang.Throwable -> L24
            r5 = 0
            r4.f47343c = r5     // Catch: java.lang.Throwable -> L24
            java.util.List<rf.a> r1 = r4.f47345e     // Catch: java.lang.Throwable -> L24
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> L24
        L3a:
            boolean r2 = r1.hasNext()     // Catch: java.lang.Throwable -> L24
            if (r2 == 0) goto L4a
            java.lang.Object r2 = r1.next()     // Catch: java.lang.Throwable -> L24
            rf.a r2 = (rf.a) r2     // Catch: java.lang.Throwable -> L24
            r2.A2(r5)     // Catch: java.lang.Throwable -> L24
            goto L3a
        L4a:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L24
            return
        L4c:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L24
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: qf.d.l(boolean):void");
    }

    public final void m(byte[] bArr) {
        synchronized (this.f47344d) {
            Iterator<rf.a> it2 = this.f47345e.iterator();
            while (it2.hasNext()) {
                it2.next().T0(bArr);
            }
        }
    }

    public void n(rf.a aVar) {
        synchronized (this.f47344d) {
            this.f47345e.remove(aVar);
        }
    }

    public boolean o(byte[] bArr) {
        b bVar = this.f47346f;
        if (bVar != null) {
            return bVar.a(bArr);
        }
        return false;
    }
}
