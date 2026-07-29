package ao;

import gm.c0;
import gm.t;
import gm.w;
import gm.y;

/* JADX INFO: loaded from: classes5.dex */
public class h extends w implements gm.g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f8787b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f8788c = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.h f8789a;

    public h(int i10) {
        if (i10 == 0 || i10 == 1) {
            this.f8789a = new t(i10);
            return;
        }
        throw new IllegalArgumentException("unknow PredefinedBiometricType : " + i10);
    }

    public h(y yVar) {
        this.f8789a = yVar;
    }

    public static h y(Object obj) {
        if (obj == null || (obj instanceof h)) {
            return (h) obj;
        }
        if (obj instanceof t) {
            return new h(t.I(obj).Q());
        }
        if (obj instanceof y) {
            return new h(y.N(obj));
        }
        throw new IllegalArgumentException("unknown object in getInstance");
    }

    public boolean A() {
        return this.f8789a instanceof t;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        return this.f8789a.b();
    }

    public y x() {
        return (y) this.f8789a;
    }

    public int z() {
        return ((t) this.f8789a).Q();
    }
}
