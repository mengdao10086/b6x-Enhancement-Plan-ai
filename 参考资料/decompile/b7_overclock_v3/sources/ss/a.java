package ss;

/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f50413b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f50414c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f50415d = 2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f50416e = 3;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f50417f = 4;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f50418g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f50419h = 4;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f50420i = 24;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f50421j = 28;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f50422k = 16;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f50423l = 20;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f50424m = 24;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f50425n = 28;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f50426a;

    public a() {
        this.f50426a = new byte[32];
    }

    public a(a aVar) {
        byte[] bArr = new byte[32];
        this.f50426a = bArr;
        byte[] bArr2 = aVar.f50426a;
        System.arraycopy(bArr2, 0, bArr, 0, bArr2.length);
    }

    public int a() {
        return org.bouncycastle.util.o.a(this.f50426a, 20);
    }

    public int b() {
        return org.bouncycastle.util.o.a(this.f50426a, 0);
    }

    public long c() {
        return org.bouncycastle.util.o.d(this.f50426a, 8);
    }

    public int d() {
        return org.bouncycastle.util.o.a(this.f50426a, 24);
    }

    public int e() {
        return org.bouncycastle.util.o.a(this.f50426a, 28);
    }

    public int f() {
        return org.bouncycastle.util.o.a(this.f50426a, 16);
    }

    public void g(int i10) {
        org.bouncycastle.util.o.h(i10, this.f50426a, 24);
    }

    public void h(int i10) {
        org.bouncycastle.util.o.h(i10, this.f50426a, 28);
    }

    public void i(int i10) {
        org.bouncycastle.util.o.h(i10, this.f50426a, 20);
    }

    public void j(int i10) {
        org.bouncycastle.util.o.h(i10, this.f50426a, 0);
    }

    public void k(long j10) {
        org.bouncycastle.util.o.z(j10, this.f50426a, 8);
    }

    public void l(int i10) {
        org.bouncycastle.util.o.h(i10, this.f50426a, 24);
    }

    public void m(int i10) {
        org.bouncycastle.util.o.h(i10, this.f50426a, 28);
    }

    public void n(int i10) {
        org.bouncycastle.util.o.h(i10, this.f50426a, 16);
        byte[] bArr = this.f50426a;
        org.bouncycastle.util.a.e0(bArr, 20, bArr.length, (byte) 0);
    }
}
