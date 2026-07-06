package a;

import java.io.Serializable;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class d42<A, B> implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final A f5860a;
    public final B b;

    public d42(A a2, B b) {
        this.f5860a = a2;
        this.b = b;
    }

    public final A a() {
        return this.f5860a;
    }

    public final B b() {
        return this.b;
    }

    public final A c() {
        return this.f5860a;
    }

    public final B d() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d42)) {
            return false;
        }
        d42 d42Var = (d42) obj;
        return f92.a(this.f5860a, d42Var.f5860a) && f92.a(this.b, d42Var.b);
    }

    public int hashCode() {
        A a2 = this.f5860a;
        int iHashCode = (a2 != null ? a2.hashCode() : 0) * 31;
        B b = this.b;
        return iHashCode + (b != null ? b.hashCode() : 0);
    }

    public String toString() {
        return '(' + this.f5860a + ", " + this.b + ')';
    }
}
