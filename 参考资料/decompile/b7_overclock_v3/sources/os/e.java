package os;

/* JADX INFO: loaded from: classes6.dex */
public final class e extends np.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f46214b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f46215c;

    public e(int i10, byte[] bArr) {
        super(true);
        if (bArr.length != g.b(i10)) {
            throw new IllegalArgumentException("invalid key size for security category");
        }
        this.f46214b = i10;
        this.f46215c = org.bouncycastle.util.a.p(bArr);
    }

    public byte[] d() {
        return org.bouncycastle.util.a.p(this.f46215c);
    }

    public int e() {
        return this.f46214b;
    }
}
