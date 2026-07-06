package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class ga2 extends fa2 {
    public static final int b(int i, int i2) {
        return i < i2 ? i2 : i;
    }

    public static final long c(long j, long j2) {
        return j < j2 ? j2 : j;
    }

    public static final int d(int i, int i2) {
        return i > i2 ? i2 : i;
    }

    public static final long e(long j, long j2) {
        return j > j2 ? j2 : j;
    }

    public static final int f(int i, int i2, int i3) {
        if (i2 <= i3) {
            return i < i2 ? i2 : i > i3 ? i3 : i;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i3 + " is less than minimum " + i2 + '.');
    }

    public static final ba2 g(int i, int i2) {
        return ba2.f5689a.a(i, i2, -1);
    }

    public static final ba2 h(ba2 ba2Var, int i) {
        f92.d(ba2Var, "$this$step");
        fa2.a(i > 0, Integer.valueOf(i));
        aa2 aa2Var = ba2.f5689a;
        int iA = ba2Var.a();
        int iB = ba2Var.b();
        if (ba2Var.c() <= 0) {
            i = -i;
        }
        return aa2Var.a(iA, iB, i);
    }

    public static final ea2 i(int i, int i2) {
        return i2 <= Integer.MIN_VALUE ? ea2.f5984a.a() : new ea2(i, i2 - 1);
    }
}
