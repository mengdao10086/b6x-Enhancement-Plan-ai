package xr;

/* JADX INFO: loaded from: classes6.dex */
public class w extends gm.w {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f56081b = 128;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f56082c = 64;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final gm.d f56083a;

    public w(int i10) {
        this(new gm.u1(i10));
    }

    public w(gm.u1 u1Var) {
        this.f56083a = u1Var;
    }

    public static w x(Object obj) {
        if (obj instanceof w) {
            return (w) obj;
        }
        if (obj != null) {
            return new w(gm.u1.S(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return this.f56083a;
    }
}
