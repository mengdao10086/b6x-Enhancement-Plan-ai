package zo;

/* JADX INFO: loaded from: classes5.dex */
public class k extends i {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final byte[] f59332m = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    public k() {
        super(f59332m);
    }

    public k(k kVar) {
        super(f59332m);
        i(kVar);
    }

    @Override // zo.i, org.bouncycastle.crypto.s
    public String b() {
        return "GOST3411-2012-512";
    }

    @Override // zo.i, org.bouncycastle.util.m
    public org.bouncycastle.util.m d() {
        return new k(this);
    }

    @Override // zo.i, org.bouncycastle.crypto.s
    public int h() {
        return 64;
    }
}
