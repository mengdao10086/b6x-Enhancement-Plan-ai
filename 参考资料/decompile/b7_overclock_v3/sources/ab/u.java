package ab;

import g.p0;

/* JADX INFO: loaded from: classes3.dex */
public final class u {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f487c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f488a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f489b;

    public u(int i10, float f10) {
        this.f488a = i10;
        this.f489b = f10;
    }

    public boolean equals(@p0 Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || u.class != obj.getClass()) {
            return false;
        }
        u uVar = (u) obj;
        return this.f488a == uVar.f488a && Float.compare(uVar.f489b, this.f489b) == 0;
    }

    public int hashCode() {
        return ((527 + this.f488a) * 31) + Float.floatToIntBits(this.f489b);
    }
}
