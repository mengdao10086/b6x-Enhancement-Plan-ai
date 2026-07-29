package rs;

/* JADX INFO: loaded from: classes6.dex */
public class i extends h {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final byte[] f49171e;

    public i(byte[] bArr) {
        super(true, null);
        this.f49171e = org.bouncycastle.util.a.p(bArr);
    }

    public i(byte[] bArr, String str) {
        super(true, str);
        this.f49171e = org.bouncycastle.util.a.p(bArr);
    }

    public byte[] e() {
        return org.bouncycastle.util.a.p(this.f49171e);
    }
}
