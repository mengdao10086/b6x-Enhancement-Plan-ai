package zn;

import gm.n2;

/* JADX INFO: loaded from: classes5.dex */
public class g1 extends gm.w implements gm.g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f58754c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f58755d = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b0 f58756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b0 f58757b;

    public g1(int i10, b0 b0Var) {
        this(new n2(i10, b0Var));
    }

    public g1(gm.n0 n0Var) {
        int iQ = n0Var.q();
        if (iQ == 0) {
            this.f58756a = b0.y(n0Var, true);
        } else {
            if (iQ == 1) {
                this.f58757b = b0.y(n0Var, true);
                return;
            }
            throw new IllegalArgumentException("unknown tag: " + n0Var.q());
        }
    }

    public static g1 x(Object obj) {
        if (obj == null || (obj instanceof g1)) {
            return (g1) obj;
        }
        if (obj instanceof gm.n0) {
            return new g1((gm.n0) obj);
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass());
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        b0 b0Var = this.f58756a;
        return b0Var != null ? new n2(true, 0, (gm.h) b0Var) : new n2(true, 1, (gm.h) this.f58757b);
    }

    public b0 y() {
        return this.f58757b;
    }

    public b0 z() {
        return this.f58756a;
    }
}
