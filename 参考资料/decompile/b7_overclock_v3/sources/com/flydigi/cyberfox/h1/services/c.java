package com.flydigi.cyberfox.h1.services;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothManager;
import android.os.Handler;
import g.n0;
import java.io.File;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import k6.k;

/* JADX INFO: loaded from: classes7.dex */
public class c extends com.flydigi.cyberfox.h1.services.a implements k.a {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f14198l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f14199m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Handler f14200n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Handler f14201o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final b f14202p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public k f14203q;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.f14203q.L();
        }
    }

    /* JADX INFO: renamed from: com.flydigi.cyberfox.h1.services.c$c, reason: collision with other inner class name */
    @Retention(RetentionPolicy.SOURCE)
    @SuppressLint({"ShiftFlags"})
    public @interface InterfaceC0152c {

        /* JADX INFO: renamed from: k0, reason: collision with root package name */
        public static final int f14210k0 = 0;

        /* JADX INFO: renamed from: l0, reason: collision with root package name */
        public static final int f14211l0 = 1;

        /* JADX INFO: renamed from: m0, reason: collision with root package name */
        public static final int f14212m0 = 2;

        /* JADX INFO: renamed from: n0, reason: collision with root package name */
        public static final int f14213n0 = 3;

        /* JADX INFO: renamed from: o0, reason: collision with root package name */
        public static final int f14214o0 = 4;
    }

    public c(@n0 Handler handler, BluetoothManager bluetoothManager) {
        super(bluetoothManager);
        this.f14198l = "GAIABREDRProvider";
        this.f14199m = false;
        this.f14201o = new Handler();
        this.f14202p = new b(this, null);
        this.f14200n = handler;
    }

    @Override // k6.k.a
    public boolean E(byte[] bArr, boolean z10) {
        return V(bArr);
    }

    @Override // k6.k.a
    public void F() {
        if (e0()) {
            return;
        }
        this.f14203q.v();
    }

    @Override // com.flydigi.cyberfox.h1.services.a
    public void L() {
        h0(3);
        if (e0()) {
            this.f14201o.post(new a());
        }
    }

    @Override // k6.k.a
    public void M(boolean z10) {
    }

    @Override // com.flydigi.cyberfox.h1.services.a
    public void N(int i10) {
        j0(2, Integer.valueOf(i10));
    }

    @Override // k6.k.a
    public void P(double d10) {
        i0(4, 4, Double.valueOf(d10));
    }

    @Override // com.flydigi.cyberfox.h1.services.a
    public void R(int i10) {
        j0(0, Integer.valueOf(i10));
        if (i10 == 0 || i10 == 3) {
            this.f14202p.d();
            k kVar = this.f14203q;
            if (kVar != null) {
                kVar.v();
            }
        }
    }

    @Override // com.flydigi.cyberfox.h1.services.a
    public void S(byte[] bArr) {
        this.f14202p.c(bArr);
    }

    @Override // com.flydigi.cyberfox.h1.services.a
    public void X(boolean z10) {
        this.f14199m = z10;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Debug logs are now ");
        sb2.append(z10 ? "activated" : "deactivated");
        sb2.append(j3.b.f36044h);
        super.X(z10);
    }

    public void Y() {
        k kVar;
        if (H() != 2 || (kVar = this.f14203q) == null) {
            return;
        }
        kVar.E();
    }

    @Override // k6.k.a
    public void b(int i10) {
        i0(4, 2, Integer.valueOf(i10));
    }

    public void b0(boolean z10) {
        X(z10);
        this.f14203q.G(z10);
    }

    public void c0(boolean z10) {
        if (z10 && this.f14203q == null) {
            this.f14203q = new k(this, 1);
        } else {
            if (z10) {
                return;
            }
            this.f14203q = null;
        }
    }

    public int d0() {
        k kVar = this.f14203q;
        if (kVar != null) {
            return kVar.I();
        }
        return 0;
    }

    @Override // k6.k.a
    public void e(int i10) throws Throwable {
        if (this.f14200n != null) {
            i0(4, 1, Integer.valueOf(i10));
        } else {
            g0(i10, true);
        }
    }

    public boolean e0() {
        k kVar = this.f14203q;
        return kVar != null && kVar.K();
    }

    public final void f0(byte[] bArr) {
        if (this.f14199m) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Receive potential GAIA packet: ");
            sb2.append(i6.b.f(bArr));
        }
        k kVar = this.f14203q;
        if (kVar != null) {
            kVar.q(bArr);
        } else {
            j0(1, bArr);
        }
    }

    public void g0(int i10, boolean z10) throws Throwable {
        k kVar = this.f14203q;
        if (kVar != null) {
            kVar.Q(i10, z10);
        }
    }

    @Override // k6.k.a
    public void h(jg.b bVar) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("ERROR during upgrade: ");
        sb2.append(bVar.d());
        i0(4, 3, bVar);
    }

    public final void h0(int i10) {
        Handler handler = this.f14200n;
        if (handler != null) {
            handler.obtainMessage(i10).sendToTarget();
        }
    }

    public final void i0(int i10, int i11, Object obj) {
        Handler handler = this.f14200n;
        if (handler != null) {
            handler.obtainMessage(i10, i11, 0, obj).sendToTarget();
        }
    }

    public final void j0(int i10, Object obj) {
        Handler handler = this.f14200n;
        if (handler != null) {
            handler.obtainMessage(i10, obj).sendToTarget();
        }
    }

    public void k0(File file) {
        k kVar = this.f14203q;
        if (kVar != null) {
            kVar.Y(file);
        }
    }

    @Override // k6.k.a
    public void v() {
    }

    @Override // k6.k.a
    public void y() {
        i0(4, 0, null);
    }

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final byte[] f14205a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f14206b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f14207c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f14208d;

        public b() {
            this.f14205a = new byte[263];
            this.f14207c = 0;
            this.f14208d = 263;
        }

        public final void c(byte[] bArr) {
            int length = bArr.length;
            for (int i10 = 0; i10 < length; i10++) {
                int i11 = this.f14207c;
                if (i11 > 0 && i11 < 263) {
                    byte[] bArr2 = this.f14205a;
                    bArr2[i11] = bArr[i10];
                    if (i11 == 2) {
                        this.f14206b = bArr[i10];
                    } else if (i11 == 3) {
                        this.f14208d = bArr[i10] + 8 + ((this.f14206b & 1) == 0 ? 0 : 1);
                    }
                    int i12 = i11 + 1;
                    this.f14207c = i12;
                    if (i12 == this.f14208d) {
                        byte[] bArr3 = new byte[i12];
                        System.arraycopy(bArr2, 0, bArr3, 0, i12);
                        d();
                        c.this.f0(bArr3);
                    }
                } else if (bArr[i10] == -1) {
                    this.f14207c = 1;
                } else if (i11 >= 263) {
                    d();
                }
            }
        }

        public final void d() {
            this.f14207c = 0;
            this.f14208d = 263;
        }

        public /* synthetic */ b(c cVar, a aVar) {
            this();
        }
    }
}
