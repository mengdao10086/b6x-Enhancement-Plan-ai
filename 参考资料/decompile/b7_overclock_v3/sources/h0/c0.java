package h0;

import android.content.LocusId;
import android.os.Build;
import g.v0;

/* JADX INFO: loaded from: classes2.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f30101a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LocusId f30102b;

    @v0(29)
    public static class a {
        @g.n0
        public static LocusId a(@g.n0 String str) {
            return new LocusId(str);
        }

        @g.n0
        public static String b(@g.n0 LocusId locusId) {
            return locusId.getId();
        }
    }

    public c0(@g.n0 String str) {
        this.f30101a = (String) androidx.core.util.o.q(str, "id cannot be empty");
        if (Build.VERSION.SDK_INT >= 29) {
            this.f30102b = a.a(str);
        } else {
            this.f30102b = null;
        }
    }

    @g.n0
    @v0(29)
    public static c0 d(@g.n0 LocusId locusId) {
        androidx.core.util.o.m(locusId, "locusId cannot be null");
        return new c0((String) androidx.core.util.o.q(a.b(locusId), "id cannot be empty"));
    }

    @g.n0
    public String a() {
        return this.f30101a;
    }

    @g.n0
    public final String b() {
        return this.f30101a.length() + "_chars";
    }

    @g.n0
    @v0(29)
    public LocusId c() {
        return this.f30102b;
    }

    public boolean equals(@g.p0 Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c0.class != obj.getClass()) {
            return false;
        }
        c0 c0Var = (c0) obj;
        String str = this.f30101a;
        return str == null ? c0Var.f30101a == null : str.equals(c0Var.f30101a);
    }

    public int hashCode() {
        String str = this.f30101a;
        return 31 + (str == null ? 0 : str.hashCode());
    }

    @g.n0
    public String toString() {
        return "LocusIdCompat[" + b() + "]";
    }
}
