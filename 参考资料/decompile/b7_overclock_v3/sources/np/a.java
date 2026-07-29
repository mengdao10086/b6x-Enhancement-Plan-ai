package np;

/* JADX INFO: loaded from: classes5.dex */
public class a implements org.bouncycastle.crypto.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f42324a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f42325b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public n1 f42326c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f42327d;

    public a(n1 n1Var, int i10, byte[] bArr) {
        this(n1Var, i10, bArr, null);
    }

    public a(n1 n1Var, int i10, byte[] bArr, byte[] bArr2) {
        this.f42326c = n1Var;
        this.f42325b = org.bouncycastle.util.a.p(bArr);
        this.f42327d = i10;
        this.f42324a = org.bouncycastle.util.a.p(bArr2);
    }

    public byte[] a() {
        return org.bouncycastle.util.a.p(this.f42324a);
    }

    public n1 b() {
        return this.f42326c;
    }

    public int c() {
        return this.f42327d;
    }

    public byte[] d() {
        return org.bouncycastle.util.a.p(this.f42325b);
    }
}
