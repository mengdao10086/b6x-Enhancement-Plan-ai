package hb;

import g.p0;

/* JADX INFO: loaded from: classes3.dex */
public final class b0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b0 f30804c = new b0(0, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f30805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f30806b;

    public b0(long j10, long j11) {
        this.f30805a = j10;
        this.f30806b = j11;
    }

    public boolean equals(@p0 Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b0.class != obj.getClass()) {
            return false;
        }
        b0 b0Var = (b0) obj;
        return this.f30805a == b0Var.f30805a && this.f30806b == b0Var.f30806b;
    }

    public int hashCode() {
        return (((int) this.f30805a) * 31) + ((int) this.f30806b);
    }

    public String toString() {
        return "[timeUs=" + this.f30805a + ", position=" + this.f30806b + "]";
    }
}
