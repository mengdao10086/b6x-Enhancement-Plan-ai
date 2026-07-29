package os;

/* JADX INFO: loaded from: classes6.dex */
public final class f extends np.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f46216b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f46217c;

    public f(int i10, byte[] bArr) {
        super(false);
        if (bArr.length != g.c(i10)) {
            throw new IllegalArgumentException("invalid key size for security category");
        }
        this.f46216b = i10;
        this.f46217c = org.bouncycastle.util.a.p(bArr);
    }

    public byte[] d() {
        return org.bouncycastle.util.a.p(this.f46217c);
    }

    public int e() {
        return this.f46216b;
    }
}
