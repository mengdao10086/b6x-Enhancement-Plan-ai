package qr;

/* JADX INFO: loaded from: classes6.dex */
public class d implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f47611a;

    public d(int[] iArr) {
        this.f47611a = org.bouncycastle.util.a.s(iArr);
    }

    @Override // qr.f
    public int a() {
        return this.f47611a[r0.length - 1];
    }

    @Override // qr.f
    public int[] b() {
        return org.bouncycastle.util.a.s(this.f47611a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof d) {
            return org.bouncycastle.util.a.i(this.f47611a, ((d) obj).f47611a);
        }
        return false;
    }

    public int hashCode() {
        return org.bouncycastle.util.a.v0(this.f47611a);
    }
}
