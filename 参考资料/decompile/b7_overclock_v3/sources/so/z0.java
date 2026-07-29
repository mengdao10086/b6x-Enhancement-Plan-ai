package so;

/* JADX INFO: loaded from: classes5.dex */
public class z0 extends v1 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public byte[] f50364f;

    public z0(byte[] bArr) {
        super(1);
        this.f50364f = bArr;
    }

    @Override // org.bouncycastle.util.q
    public boolean M(Object obj) {
        if (obj instanceof byte[]) {
            return org.bouncycastle.util.a.g(this.f50364f, (byte[]) obj);
        }
        if (obj instanceof b1) {
            return ((b1) obj).j().equals(this);
        }
        return false;
    }

    public byte[] b() {
        return org.bouncycastle.util.a.p(this.f50364f);
    }

    @Override // so.v1, org.bouncycastle.util.q
    public Object clone() {
        return new z0(this.f50364f);
    }

    public boolean equals(Object obj) {
        if (obj instanceof z0) {
            return org.bouncycastle.util.a.g(this.f50364f, ((z0) obj).f50364f);
        }
        return false;
    }

    public int hashCode() {
        return org.bouncycastle.util.a.s0(this.f50364f);
    }
}
