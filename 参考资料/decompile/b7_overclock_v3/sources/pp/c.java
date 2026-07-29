package pp;

import org.bouncycastle.crypto.s;

/* JADX INFO: loaded from: classes5.dex */
public class c implements g {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static long f46937f = 10;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public s f46940c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f46941d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f46942e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f46939b = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f46938a = 1;

    public c(s sVar) {
        this.f46940c = sVar;
        this.f46942e = new byte[sVar.h()];
        this.f46941d = new byte[sVar.h()];
    }

    @Override // pp.g
    public void a(byte[] bArr, int i10, int i11) {
        synchronized (this) {
            i();
            int i12 = i11 + i10;
            int i13 = 0;
            while (i10 != i12) {
                if (i13 == this.f46941d.length) {
                    i();
                    i13 = 0;
                }
                bArr[i10] = this.f46941d[i13];
                i10++;
                i13++;
            }
        }
    }

    @Override // pp.g
    public void b(long j10) {
        synchronized (this) {
            f(j10);
            h(this.f46942e);
            g(this.f46942e);
        }
    }

    @Override // pp.g
    public void c(byte[] bArr) {
        synchronized (this) {
            if (!org.bouncycastle.util.a.F0(bArr)) {
                h(bArr);
            }
            h(this.f46942e);
            g(this.f46942e);
        }
    }

    @Override // pp.g
    public void d(byte[] bArr) {
        a(bArr, 0, bArr.length);
    }

    public final void e() {
        h(this.f46942e);
        long j10 = this.f46939b;
        this.f46939b = 1 + j10;
        f(j10);
        g(this.f46942e);
    }

    public final void f(long j10) {
        for (int i10 = 0; i10 != 8; i10++) {
            this.f46940c.update((byte) j10);
            j10 >>>= 8;
        }
    }

    public final void g(byte[] bArr) {
        this.f46940c.c(bArr, 0);
    }

    public final void h(byte[] bArr) {
        this.f46940c.update(bArr, 0, bArr.length);
    }

    public final void i() {
        long j10 = this.f46938a;
        this.f46938a = 1 + j10;
        f(j10);
        h(this.f46941d);
        h(this.f46942e);
        g(this.f46941d);
        if (this.f46938a % f46937f == 0) {
            e();
        }
    }
}
