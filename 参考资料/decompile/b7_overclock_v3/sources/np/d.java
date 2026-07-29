package np;

/* JADX INFO: loaded from: classes5.dex */
public class d implements org.bouncycastle.crypto.k {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f42375c = 32;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f42376a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f42377b;

    public static d b(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("Invalid context");
        }
        d dVar = new d();
        dVar.f42377b = org.bouncycastle.util.a.p(bArr);
        return dVar;
    }

    public static d e(byte[] bArr) {
        if (bArr == null || bArr.length != 32) {
            throw new IllegalArgumentException("Invalid keyLength");
        }
        d dVar = new d();
        dVar.f42376a = org.bouncycastle.util.a.p(bArr);
        return dVar;
    }

    public void a() {
        org.bouncycastle.util.a.d0(this.f42376a, (byte) 0);
    }

    public byte[] c() {
        return org.bouncycastle.util.a.p(this.f42377b);
    }

    public byte[] d() {
        return org.bouncycastle.util.a.p(this.f42376a);
    }
}
