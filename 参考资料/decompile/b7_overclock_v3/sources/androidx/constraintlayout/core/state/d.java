package androidx.constraintlayout.core.state;

import java.util.HashMap;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f3131b = new d();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashMap<String, e> f3132a = new HashMap<>();

    public static d c() {
        return f3131b;
    }

    public String a(String str) {
        e eVar = this.f3132a.get(str);
        if (eVar != null) {
            return eVar.b();
        }
        return null;
    }

    public String b(String str) {
        e eVar = this.f3132a.get(str);
        if (eVar != null) {
            return eVar.g();
        }
        return null;
    }

    public long d(String str) {
        e eVar = this.f3132a.get(str);
        if (eVar != null) {
            return eVar.h();
        }
        return Long.MAX_VALUE;
    }

    public Set<String> e() {
        return this.f3132a.keySet();
    }

    public void f(String str, e eVar) {
        this.f3132a.put(str, eVar);
    }

    public void g(String str, int i10) {
        e eVar = this.f3132a.get(str);
        if (eVar != null) {
            eVar.c(i10);
        }
    }

    public void h(String str, int i10) {
        e eVar = this.f3132a.get(str);
        if (eVar != null) {
            eVar.d(i10);
        }
    }

    public void i(String str, e eVar) {
        this.f3132a.remove(str);
    }

    public void j(String str, String str2) {
        e eVar = this.f3132a.get(str);
        if (eVar != null) {
            eVar.a(str2);
        }
    }

    public void k(String str, int i10, int i11) {
        e eVar = this.f3132a.get(str);
        if (eVar != null) {
            eVar.f(i10, i11);
        }
    }

    public void l(String str, float f10) {
        e eVar = this.f3132a.get(str);
        if (eVar != null) {
            eVar.e(f10);
        }
    }
}
