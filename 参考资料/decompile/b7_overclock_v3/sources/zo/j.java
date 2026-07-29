package zo;

/* JADX INFO: loaded from: classes5.dex */
public final class j extends i {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final byte[] f59331m = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};

    public j() {
        super(f59331m);
    }

    public j(j jVar) {
        super(f59331m);
        i(jVar);
    }

    @Override // zo.i, org.bouncycastle.crypto.s
    public String b() {
        return "GOST3411-2012-256";
    }

    @Override // zo.i, org.bouncycastle.crypto.s
    public int c(byte[] bArr, int i10) {
        byte[] bArr2 = new byte[64];
        super.c(bArr2, 0);
        System.arraycopy(bArr2, 32, bArr, i10, 32);
        return 32;
    }

    @Override // zo.i, org.bouncycastle.util.m
    public org.bouncycastle.util.m d() {
        return new j(this);
    }

    @Override // zo.i, org.bouncycastle.crypto.s
    public int h() {
        return 32;
    }
}
