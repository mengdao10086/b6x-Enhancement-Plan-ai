package wm;

import gm.c0;
import gm.f0;
import gm.g;
import gm.h;
import gm.w;
import gm.y;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class a extends w implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y f54748a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final pn.a f54749b;

    public a(y yVar) {
        this.f54748a = yVar;
        this.f54749b = null;
    }

    public a(pn.a aVar) {
        this.f54748a = null;
        this.f54749b = aVar;
    }

    public static a y(Object obj) {
        if (obj instanceof a) {
            return (a) obj;
        }
        if (obj == null) {
            return null;
        }
        if (obj instanceof h) {
            c0 c0VarB = ((h) obj).b();
            if (c0VarB instanceof y) {
                return new a(y.N(c0VarB));
            }
            if (c0VarB instanceof f0) {
                return new a(pn.a.A(c0VarB));
            }
        }
        if (obj instanceof byte[]) {
            try {
                return y(c0.D((byte[]) obj));
            } catch (IOException unused) {
                throw new IllegalArgumentException("unknown encoding in getInstance()");
            }
        }
        throw new IllegalArgumentException("unknown object in getInstance(): " + obj.getClass().getName());
    }

    public boolean A() {
        return this.f54748a != null;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        y yVar = this.f54748a;
        return yVar != null ? yVar : this.f54749b.b();
    }

    public pn.a x() {
        return this.f54749b;
    }

    public y z() {
        return this.f54748a;
    }
}
