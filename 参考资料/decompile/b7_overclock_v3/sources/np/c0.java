package np;

/* JADX INFO: loaded from: classes5.dex */
public class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f42369a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f42370b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f42371c;

    public c0(byte[] bArr, int i10) {
        this(bArr, i10, -1);
    }

    public c0(byte[] bArr, int i10, int i11) {
        this.f42370b = org.bouncycastle.util.a.p(bArr);
        this.f42371c = i10;
        this.f42369a = i11;
    }

    public int a() {
        return this.f42371c;
    }

    public byte[] b() {
        return org.bouncycastle.util.a.p(this.f42370b);
    }

    public int c() {
        return this.f42369a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c0)) {
            return false;
        }
        c0 c0Var = (c0) obj;
        if (c0Var.f42371c != this.f42371c) {
            return false;
        }
        return org.bouncycastle.util.a.g(this.f42370b, c0Var.f42370b);
    }

    public int hashCode() {
        return this.f42371c ^ org.bouncycastle.util.a.s0(this.f42370b);
    }
}
