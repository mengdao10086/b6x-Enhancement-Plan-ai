package zn;

import gm.c2;
import gm.p2;
import gm.s2;

/* JADX INFO: loaded from: classes5.dex */
public class u extends gm.w implements gm.g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f58972c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f58973d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f58974e = 2;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f58975f = 3;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f58976g = 200;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f58977a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.k0 f58978b;

    public u(int i10, String str) {
        str = str.length() > 200 ? str.substring(0, 200) : str;
        this.f58977a = i10;
        gm.k0 p2Var = i10 != 0 ? i10 != 1 ? (i10 == 2 || i10 != 3) ? new p2(str) : new s2(str) : new gm.t1(str) : new c2(str);
        this.f58978b = p2Var;
    }

    public u(gm.k0 k0Var) {
        int i10;
        this.f58978b = k0Var;
        if (k0Var instanceof gm.r0) {
            i10 = 2;
        } else if (k0Var instanceof gm.c) {
            i10 = 1;
        } else if (k0Var instanceof gm.r) {
            i10 = 0;
        } else {
            if (!(k0Var instanceof gm.x0)) {
                throw new IllegalArgumentException("unknown STRING type in DisplayText");
            }
            i10 = 3;
        }
        this.f58977a = i10;
    }

    public u(String str) {
        str = str.length() > 200 ? str.substring(0, 200) : str;
        this.f58977a = 2;
        this.f58978b = new p2(str);
    }

    public static u x(gm.n0 n0Var, boolean z10) {
        return y(n0Var.U());
    }

    public static u y(Object obj) {
        if (obj instanceof gm.k0) {
            return new u((gm.k0) obj);
        }
        if (obj == null || (obj instanceof u)) {
            return (u) obj;
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return (gm.c0) this.f58978b;
    }

    public String d() {
        return this.f58978b.d();
    }
}
