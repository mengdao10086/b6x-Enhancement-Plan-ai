package en;

import gm.c0;
import gm.w;

/* JADX INFO: loaded from: classes5.dex */
public class a extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public xn.b f27037a;

    public a(String str) {
        this(new xn.b(str));
    }

    public a(xn.b bVar) {
        this.f27037a = bVar;
    }

    public static a y(Object obj) {
        if (obj instanceof a) {
            return (a) obj;
        }
        if (obj != null) {
            return new a(xn.b.y(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        return this.f27037a.b();
    }

    public xn.b x() {
        return this.f27037a;
    }
}
