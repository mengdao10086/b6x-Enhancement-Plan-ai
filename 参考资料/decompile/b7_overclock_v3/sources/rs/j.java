package rs;

/* JADX INFO: loaded from: classes6.dex */
public class j extends h {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final byte[] f49172e;

    public j(byte[] bArr) {
        super(false, null);
        this.f49172e = org.bouncycastle.util.a.p(bArr);
    }

    public j(byte[] bArr, String str) {
        super(false, str);
        this.f49172e = org.bouncycastle.util.a.p(bArr);
    }

    public byte[] e() {
        return org.bouncycastle.util.a.p(this.f49172e);
    }
}
