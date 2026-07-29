package km;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class d extends gm.w implements gm.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f37435a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f37436b;

    public d(a aVar) {
        this.f37435a = aVar;
        this.f37436b = null;
    }

    public d(c cVar) {
        this.f37435a = null;
        this.f37436b = cVar;
    }

    public static d z(Object obj) {
        if (obj instanceof d) {
            return (d) obj;
        }
        if (obj == null) {
            return null;
        }
        if (obj instanceof gm.h) {
            gm.c0 c0VarB = ((gm.h) obj).b();
            if (c0VarB instanceof gm.t) {
                return new d(a.z(c0VarB));
            }
            if (c0VarB instanceof gm.f0) {
                return new d(c.z(c0VarB));
            }
        }
        if (obj instanceof byte[]) {
            try {
                return z(gm.c0.D((byte[]) obj));
            } catch (IOException unused) {
                throw new IllegalArgumentException("unknown encoding in getInstance()");
            }
        }
        throw new IllegalArgumentException("unknown object in getInstance(): " + obj.getClass().getName());
    }

    public boolean A() {
        return this.f37435a != null;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        a aVar = this.f37435a;
        return aVar != null ? aVar.b() : this.f37436b.b();
    }

    public a x() {
        return this.f37435a;
    }

    public c y() {
        return this.f37436b;
    }
}
