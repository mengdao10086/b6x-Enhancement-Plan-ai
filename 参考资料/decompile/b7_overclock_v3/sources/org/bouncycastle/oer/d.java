package org.bouncycastle.oer;

import gm.c0;
import gm.h;
import gm.w;
import java.security.AccessController;
import java.security.PrivilegedAction;

/* JADX INFO: loaded from: classes6.dex */
public class d extends w {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d f45570c = new d(false, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f45571a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f45572b;

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class a<T> implements PrivilegedAction<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Class f45573a;

        public a(Class cls) {
            this.f45573a = cls;
        }

        @Override // java.security.PrivilegedAction
        public T run() {
            try {
                return (T) this.f45573a.cast(this.f45573a.getMethod("getInstance", Object.class).invoke(null, d.this.f45572b));
            } catch (Exception e10) {
                throw new IllegalStateException("could not invoke getInstance on type " + e10.getMessage(), e10);
            }
        }
    }

    public d(boolean z10, h hVar) {
        this.f45571a = z10;
        this.f45572b = hVar;
    }

    public static <T> T B(Class<T> cls, Object obj) {
        d dVarZ = z(obj);
        if (dVarZ.f45571a) {
            return (T) dVarZ.A(cls);
        }
        return null;
    }

    public static d z(Object obj) {
        return obj instanceof d ? (d) obj : obj instanceof h ? new d(true, (h) obj) : f45570c;
    }

    public <T> T A(Class<T> cls) {
        if (this.f45571a) {
            return this.f45572b.getClass().isInstance(cls) ? cls.cast(this.f45572b) : (T) AccessController.doPrivileged(new a(cls));
        }
        return null;
    }

    public boolean C() {
        return this.f45571a;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        if (this.f45571a) {
            return y().b();
        }
        throw new RuntimeException("bang");
    }

    @Override // gm.w
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        d dVar = (d) obj;
        if (this.f45571a != dVar.f45571a) {
            return false;
        }
        h hVar = this.f45572b;
        h hVar2 = dVar.f45572b;
        return hVar != null ? hVar.equals(hVar2) : hVar2 == null;
    }

    @Override // gm.w
    public int hashCode() {
        int iHashCode = ((super.hashCode() * 31) + (this.f45571a ? 1 : 0)) * 31;
        h hVar = this.f45572b;
        return iHashCode + (hVar != null ? hVar.hashCode() : 0);
    }

    public String toString() {
        if (!this.f45571a) {
            return "ABSENT";
        }
        return "OPTIONAL(" + this.f45572b + ee.a.f26979d;
    }

    public h y() {
        return !this.f45571a ? f45570c : this.f45572b;
    }
}
