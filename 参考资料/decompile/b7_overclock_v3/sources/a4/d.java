package a4;

import android.util.Log;
import g.n0;
import g.p0;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f200e = "GifHeaderParser";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f201f = 255;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f202g = 44;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f203h = 33;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f204i = 59;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f205j = 249;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f206k = 255;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f207l = 254;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f208m = 1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f209n = 28;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f210o = 2;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f211p = 1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f212q = 128;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f213r = 64;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f214s = 7;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f215t = 128;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f216u = 7;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f217v = 2;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f218w = 10;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f219x = 256;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ByteBuffer f221b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f222c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f220a = new byte[256];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f223d = 0;

    public void a() {
        this.f221b = null;
        this.f222c = null;
    }

    public final boolean b() {
        return this.f222c.f188b != 0;
    }

    public boolean c() {
        l();
        if (!b()) {
            j(2);
        }
        return this.f222c.f189c > 1;
    }

    @n0
    public c d() {
        if (this.f221b == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        }
        if (b()) {
            return this.f222c;
        }
        l();
        if (!b()) {
            i();
            c cVar = this.f222c;
            if (cVar.f189c < 0) {
                cVar.f188b = 1;
            }
        }
        return this.f222c;
    }

    public final int e() {
        try {
            return this.f221b.get() & 255;
        } catch (Exception unused) {
            this.f222c.f188b = 1;
            return 0;
        }
    }

    public final void f() {
        this.f222c.f190d.f174a = o();
        this.f222c.f190d.f175b = o();
        this.f222c.f190d.f176c = o();
        this.f222c.f190d.f177d = o();
        int iE = e();
        boolean z10 = (iE & 128) != 0;
        int iPow = (int) Math.pow(2.0d, (iE & 7) + 1);
        b bVar = this.f222c.f190d;
        bVar.f178e = (iE & 64) != 0;
        if (z10) {
            bVar.f184k = h(iPow);
        } else {
            bVar.f184k = null;
        }
        this.f222c.f190d.f183j = this.f221b.position();
        t();
        if (b()) {
            return;
        }
        c cVar = this.f222c;
        cVar.f189c++;
        cVar.f191e.add(cVar.f190d);
    }

    public final void g() {
        int iE = e();
        this.f223d = iE;
        if (iE <= 0) {
            return;
        }
        int i10 = 0;
        int i11 = 0;
        while (true) {
            try {
                i11 = this.f223d;
                if (i10 >= i11) {
                    return;
                }
                i11 -= i10;
                this.f221b.get(this.f220a, i10, i11);
                i10 += i11;
            } catch (Exception unused) {
                if (Log.isLoggable(f200e, 3)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Error Reading Block n: ");
                    sb2.append(i10);
                    sb2.append(" count: ");
                    sb2.append(i11);
                    sb2.append(" blockSize: ");
                    sb2.append(this.f223d);
                }
                this.f222c.f188b = 1;
                return;
            }
        }
    }

    @p0
    public final int[] h(int i10) {
        byte[] bArr = new byte[i10 * 3];
        int[] iArr = null;
        try {
            this.f221b.get(bArr);
            iArr = new int[256];
            int i11 = 0;
            int i12 = 0;
            while (i11 < i10) {
                int i13 = i12 + 1;
                int i14 = i13 + 1;
                int i15 = i14 + 1;
                int i16 = i11 + 1;
                iArr[i11] = ((bArr[i12] & 255) << 16) | (-16777216) | ((bArr[i13] & 255) << 8) | (bArr[i14] & 255);
                i12 = i15;
                i11 = i16;
            }
        } catch (BufferUnderflowException unused) {
            this.f222c.f188b = 1;
        }
        return iArr;
    }

    public final void i() {
        j(Integer.MAX_VALUE);
    }

    public final void j(int i10) {
        boolean z10 = false;
        while (!z10 && !b() && this.f222c.f189c <= i10) {
            int iE = e();
            if (iE == 33) {
                int iE2 = e();
                if (iE2 == 1) {
                    s();
                } else if (iE2 == 249) {
                    this.f222c.f190d = new b();
                    k();
                } else if (iE2 == 254) {
                    s();
                } else if (iE2 != 255) {
                    s();
                } else {
                    g();
                    StringBuilder sb2 = new StringBuilder();
                    for (int i11 = 0; i11 < 11; i11++) {
                        sb2.append((char) this.f220a[i11]);
                    }
                    if (sb2.toString().equals("NETSCAPE2.0")) {
                        n();
                    } else {
                        s();
                    }
                }
            } else if (iE == 44) {
                c cVar = this.f222c;
                if (cVar.f190d == null) {
                    cVar.f190d = new b();
                }
                f();
            } else if (iE != 59) {
                this.f222c.f188b = 1;
            } else {
                z10 = true;
            }
        }
    }

    public final void k() {
        e();
        int iE = e();
        b bVar = this.f222c.f190d;
        int i10 = (iE & 28) >> 2;
        bVar.f180g = i10;
        if (i10 == 0) {
            bVar.f180g = 1;
        }
        bVar.f179f = (iE & 1) != 0;
        int iO = o();
        if (iO < 2) {
            iO = 10;
        }
        b bVar2 = this.f222c.f190d;
        bVar2.f182i = iO * 10;
        bVar2.f181h = e();
        e();
    }

    public final void l() {
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < 6; i10++) {
            sb2.append((char) e());
        }
        if (!sb2.toString().startsWith("GIF")) {
            this.f222c.f188b = 1;
            return;
        }
        m();
        if (!this.f222c.f194h || b()) {
            return;
        }
        c cVar = this.f222c;
        cVar.f187a = h(cVar.f195i);
        c cVar2 = this.f222c;
        cVar2.f198l = cVar2.f187a[cVar2.f196j];
    }

    public final void m() {
        this.f222c.f192f = o();
        this.f222c.f193g = o();
        int iE = e();
        c cVar = this.f222c;
        cVar.f194h = (iE & 128) != 0;
        cVar.f195i = (int) Math.pow(2.0d, (iE & 7) + 1);
        this.f222c.f196j = e();
        this.f222c.f197k = e();
    }

    public final void n() {
        do {
            g();
            byte[] bArr = this.f220a;
            if (bArr[0] == 1) {
                this.f222c.f199m = ((bArr[2] & 255) << 8) | (bArr[1] & 255);
            }
            if (this.f223d <= 0) {
                return;
            }
        } while (!b());
    }

    public final int o() {
        return this.f221b.getShort();
    }

    public final void p() {
        this.f221b = null;
        Arrays.fill(this.f220a, (byte) 0);
        this.f222c = new c();
        this.f223d = 0;
    }

    public d q(@n0 ByteBuffer byteBuffer) {
        p();
        ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.f221b = byteBufferAsReadOnlyBuffer;
        byteBufferAsReadOnlyBuffer.position(0);
        this.f221b.order(ByteOrder.LITTLE_ENDIAN);
        return this;
    }

    public d r(@p0 byte[] bArr) {
        if (bArr != null) {
            q(ByteBuffer.wrap(bArr));
        } else {
            this.f221b = null;
            this.f222c.f188b = 2;
        }
        return this;
    }

    public final void s() {
        int iE;
        do {
            iE = e();
            this.f221b.position(Math.min(this.f221b.position() + iE, this.f221b.limit()));
        } while (iE > 0);
    }

    public final void t() {
        e();
        s();
    }
}
