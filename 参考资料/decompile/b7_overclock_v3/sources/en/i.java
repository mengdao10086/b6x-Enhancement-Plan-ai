package en;

import gm.c0;
import gm.w;

/* JADX INFO: loaded from: classes5.dex */
public class i extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public xn.b f27082a;

    public i(String str) {
        this.f27082a = new xn.b(str);
    }

    public i(xn.b bVar) {
        this.f27082a = bVar;
    }

    public static i x(Object obj) {
        if (obj instanceof i) {
            return (i) obj;
        }
        if (obj != null) {
            return new i(xn.b.y(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        return this.f27082a.b();
    }

    public xn.b y() {
        return this.f27082a;
    }
}
