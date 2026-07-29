package org.bouncycastle.crypto.util;

import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.crypto.s;
import zo.c0;
import zo.d0;
import zo.e0;
import zo.f0;
import zo.g0;
import zo.h0;
import zo.i0;
import zo.j0;
import zo.u;

/* JADX INFO: loaded from: classes5.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map f44736a;

    public static class a implements m {
        @Override // org.bouncycastle.crypto.util.f.m
        public s a(s sVar) {
            return new g0((g0) sVar);
        }
    }

    public static class b implements m {
        @Override // org.bouncycastle.crypto.util.f.m
        public s a(s sVar) {
            return new j0((j0) sVar);
        }
    }

    public static class c implements m {
        @Override // org.bouncycastle.crypto.util.f.m
        public s a(s sVar) {
            return new j0((j0) sVar);
        }
    }

    public static class d implements m {
        @Override // org.bouncycastle.crypto.util.f.m
        public s a(s sVar) {
            return new u((u) sVar);
        }
    }

    public static class e implements m {
        @Override // org.bouncycastle.crypto.util.f.m
        public s a(s sVar) {
            return new u((u) sVar);
        }
    }

    /* JADX INFO: renamed from: org.bouncycastle.crypto.util.f$f, reason: collision with other inner class name */
    public static class C0502f implements m {
        @Override // org.bouncycastle.crypto.util.f.m
        public s a(s sVar) {
            return new d0((d0) sVar);
        }
    }

    public static class g implements m {
        @Override // org.bouncycastle.crypto.util.f.m
        public s a(s sVar) {
            return new e0((e0) sVar);
        }
    }

    public static class h implements m {
        @Override // org.bouncycastle.crypto.util.f.m
        public s a(s sVar) {
            return new f0((f0) sVar);
        }
    }

    public static class i implements m {
        @Override // org.bouncycastle.crypto.util.f.m
        public s a(s sVar) {
            return new h0((h0) sVar);
        }
    }

    public static class j implements m {
        @Override // org.bouncycastle.crypto.util.f.m
        public s a(s sVar) {
            return new g0((g0) sVar);
        }
    }

    public static class k implements m {
        @Override // org.bouncycastle.crypto.util.f.m
        public s a(s sVar) {
            return new g0((g0) sVar);
        }
    }

    public static class l implements m {
        @Override // org.bouncycastle.crypto.util.f.m
        public s a(s sVar) {
            return new g0((g0) sVar);
        }
    }

    public interface m {
        s a(s sVar);
    }

    static {
        HashMap map = new HashMap();
        f44736a = map;
        map.put(b().b(), new d());
        map.put(c().b(), new e());
        map.put(d().b(), new C0502f());
        map.put(e().b(), new g());
        map.put(f().b(), new h());
        map.put(k().b(), new i());
        map.put(g().b(), new j());
        map.put(h().b(), new k());
        map.put(i().b(), new l());
        map.put(j().b(), new a());
        map.put(n().b(), new b());
        map.put(o().b(), new c());
    }

    public static s a(s sVar) {
        return ((m) f44736a.get(sVar.b())).a(sVar);
    }

    public static s b() {
        return new u();
    }

    public static s c() {
        return new c0();
    }

    public static s d() {
        return new d0();
    }

    public static s e() {
        return new e0();
    }

    public static s f() {
        return new f0();
    }

    public static s g() {
        return new g0(224);
    }

    public static s h() {
        return new g0(256);
    }

    public static s i() {
        return new g0(384);
    }

    public static s j() {
        return new g0(512);
    }

    public static s k() {
        return new h0();
    }

    public static s l() {
        return new i0(224);
    }

    public static s m() {
        return new i0(256);
    }

    public static s n() {
        return new j0(128);
    }

    public static s o() {
        return new j0(256);
    }
}
