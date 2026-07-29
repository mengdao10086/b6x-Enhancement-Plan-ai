package ec;

import g.p0;

/* JADX INFO: loaded from: classes3.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f26856a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f26857b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f26858c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f26859d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f26860e;

    public n(Object obj) {
        this(obj, -1L);
    }

    public n a(Object obj) {
        return this.f26856a.equals(obj) ? this : new n(obj, this.f26857b, this.f26858c, this.f26859d, this.f26860e);
    }

    public boolean b() {
        return this.f26857b != -1;
    }

    public boolean equals(@p0 Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return this.f26856a.equals(nVar.f26856a) && this.f26857b == nVar.f26857b && this.f26858c == nVar.f26858c && this.f26859d == nVar.f26859d && this.f26860e == nVar.f26860e;
    }

    public int hashCode() {
        return ((((((((527 + this.f26856a.hashCode()) * 31) + this.f26857b) * 31) + this.f26858c) * 31) + ((int) this.f26859d)) * 31) + this.f26860e;
    }

    public n(Object obj, long j10) {
        this(obj, -1, -1, j10, -1);
    }

    public n(Object obj, long j10, int i10) {
        this(obj, -1, -1, j10, i10);
    }

    public n(Object obj, int i10, int i11, long j10) {
        this(obj, i10, i11, j10, -1);
    }

    public n(n nVar) {
        this.f26856a = nVar.f26856a;
        this.f26857b = nVar.f26857b;
        this.f26858c = nVar.f26858c;
        this.f26859d = nVar.f26859d;
        this.f26860e = nVar.f26860e;
    }

    public n(Object obj, int i10, int i11, long j10, int i12) {
        this.f26856a = obj;
        this.f26857b = i10;
        this.f26858c = i11;
        this.f26859d = j10;
        this.f26860e = i12;
    }
}
