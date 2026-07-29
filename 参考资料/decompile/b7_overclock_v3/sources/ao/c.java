package ao;

import gm.c0;
import gm.d0;
import gm.i2;
import gm.t;
import gm.w;

/* JADX INFO: loaded from: classes5.dex */
public class c extends w implements gm.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8775a = 3;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f8776b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f8777c = 999;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public gm.h f8778d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f8779e;

    public c(int i10) {
        if (i10 > 999 || i10 < 1) {
            throw new IllegalArgumentException("wrong size in numeric code : not in (1..999)");
        }
        this.f8778d = new t(i10);
    }

    public c(String str) {
        if (str.length() > 3) {
            throw new IllegalArgumentException("wrong size in alphabetic code : max size is 3");
        }
        this.f8778d = new i2(str);
    }

    public static c y(Object obj) {
        if (obj == null || (obj instanceof c)) {
            return (c) obj;
        }
        if (obj instanceof t) {
            return new c(t.I(obj).Q());
        }
        if (obj instanceof d0) {
            return new c(d0.I(obj).d());
        }
        throw new IllegalArgumentException("unknown object in getInstance");
    }

    public boolean A() {
        return this.f8778d instanceof d0;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        return this.f8778d.b();
    }

    public String x() {
        return ((d0) this.f8778d).d();
    }

    public int z() {
        return ((t) this.f8778d).Q();
    }
}
