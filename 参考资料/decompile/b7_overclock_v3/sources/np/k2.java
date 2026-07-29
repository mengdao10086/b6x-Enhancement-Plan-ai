package np;

/* JADX INFO: loaded from: classes5.dex */
public class k2 implements org.bouncycastle.crypto.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f42468a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n1 f42469b;

    public k2(n1 n1Var, byte[] bArr) {
        this.f42469b = n1Var;
        this.f42468a = org.bouncycastle.util.a.p(bArr);
    }

    public n1 a() {
        return this.f42469b;
    }

    public byte[] b() {
        return this.f42468a;
    }
}
