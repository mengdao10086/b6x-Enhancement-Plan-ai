package np;

/* JADX INFO: loaded from: classes5.dex */
public final class y0 implements org.bouncycastle.crypto.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n1 f42573a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f42574b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f42575c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f42576d;

    public y0(n1 n1Var, int i10, byte[] bArr) {
        this(n1Var, i10, bArr, false);
    }

    public y0(n1 n1Var, int i10, byte[] bArr, boolean z10) {
        this.f42573a = n1Var;
        this.f42574b = i10;
        this.f42575c = org.bouncycastle.util.a.p(bArr);
        this.f42576d = z10;
    }

    public n1 a() {
        return this.f42573a;
    }

    public int b() {
        return this.f42574b;
    }

    public byte[] c() {
        return org.bouncycastle.util.a.p(this.f42575c);
    }

    public boolean d() {
        return this.f42576d;
    }
}
