package np;

/* JADX INFO: loaded from: classes5.dex */
public class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f42551a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f42552b;

    public v(byte[] bArr, int i10) {
        this.f42551a = org.bouncycastle.util.a.p(bArr);
        this.f42552b = i10;
    }

    public int a() {
        return this.f42552b;
    }

    public byte[] b() {
        return org.bouncycastle.util.a.p(this.f42551a);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof v)) {
            return false;
        }
        v vVar = (v) obj;
        if (vVar.f42552b != this.f42552b) {
            return false;
        }
        return org.bouncycastle.util.a.g(this.f42551a, vVar.f42551a);
    }

    public int hashCode() {
        return this.f42552b ^ org.bouncycastle.util.a.s0(this.f42551a);
    }
}
