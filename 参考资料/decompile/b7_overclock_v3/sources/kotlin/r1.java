package kotlin;

/* JADX INFO: loaded from: classes5.dex */
public final class r1 {
    @bk.f
    @s
    @v0(version = "1.3")
    public static final long[] a(int i10, ik.l<? super Integer, p1> init) {
        kotlin.jvm.internal.f0.p(init, "init");
        long[] jArr = new long[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            jArr[i11] = init.i(Integer.valueOf(i11)).l0();
        }
        return q1.e(jArr);
    }

    @bk.f
    @s
    @v0(version = "1.3")
    public static final long[] b(long... elements) {
        kotlin.jvm.internal.f0.p(elements, "elements");
        return elements;
    }
}
