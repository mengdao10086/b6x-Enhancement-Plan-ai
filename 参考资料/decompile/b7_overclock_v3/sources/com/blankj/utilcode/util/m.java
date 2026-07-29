package com.blankj.utilcode.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class m implements w3.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f11930g = 256;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Map<String, m> f11931h = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f11932e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final androidx.collection.j<String, a> f11933f;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f11934a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f11935b;

        public a(long j10, Object obj) {
            this.f11934a = j10;
            this.f11935b = obj;
        }
    }

    public m(String str, androidx.collection.j<String, a> jVar) {
        this.f11932e = str;
        this.f11933f = jVar;
    }

    public static m e() {
        return f(256);
    }

    public static m f(int i10) {
        return g(String.valueOf(i10), i10);
    }

    public static m g(String str, int i10) {
        Map<String, m> map = f11931h;
        m mVar = map.get(str);
        if (mVar == null) {
            synchronized (m.class) {
                mVar = map.get(str);
                if (mVar == null) {
                    mVar = new m(str, new androidx.collection.j(i10));
                    map.put(str, mVar);
                }
            }
        }
        return mVar;
    }

    public void a() {
        this.f11933f.d();
    }

    public <T> T b(@g.n0 String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return (T) c(str, null);
    }

    public <T> T c(@g.n0 String str, T t10) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        a aVarF = this.f11933f.f(str);
        if (aVarF == null) {
            return t10;
        }
        long j10 = aVarF.f11934a;
        if (j10 == -1 || j10 >= System.currentTimeMillis()) {
            return (T) aVarF.f11935b;
        }
        this.f11933f.l(str);
        return t10;
    }

    public int d() {
        return this.f11933f.o();
    }

    public void h(@g.n0 String str, Object obj) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        i(str, obj, -1);
    }

    public void i(@g.n0 String str, Object obj, int i10) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        if (obj == null) {
            return;
        }
        this.f11933f.j(str, new a(i10 < 0 ? -1L : System.currentTimeMillis() + ((long) (i10 * 1000)), obj));
    }

    public Object j(@g.n0 String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        a aVarL = this.f11933f.l(str);
        if (aVarL == null) {
            return null;
        }
        return aVarL.f11935b;
    }

    public String toString() {
        return this.f11932e + "@" + Integer.toHexString(hashCode());
    }
}
