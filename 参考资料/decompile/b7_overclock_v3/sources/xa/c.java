package xa;

import java.util.List;
import xa.h;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends h.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static h<c> f54978e;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f54979c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f54980d;

    static {
        h<c> hVarA = h.a(256, new c(0.0f, 0.0f));
        f54978e = hVarA;
        hVarA.l(0.5f);
    }

    public c() {
    }

    public static c b(float f10, float f11) {
        c cVar = (c) f54978e.b();
        cVar.f54979c = f10;
        cVar.f54980d = f11;
        return cVar;
    }

    public static void c(c cVar) {
        f54978e.h(cVar);
    }

    public static void d(List<c> list) {
        f54978e.g(list);
    }

    @Override // xa.h.a
    public h.a a() {
        return new c(0.0f, 0.0f);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f54979c == cVar.f54979c && this.f54980d == cVar.f54980d;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.f54979c) ^ Float.floatToIntBits(this.f54980d);
    }

    public String toString() {
        return this.f54979c + "x" + this.f54980d;
    }

    public c(float f10, float f11) {
        this.f54979c = f10;
        this.f54980d = f11;
    }
}
