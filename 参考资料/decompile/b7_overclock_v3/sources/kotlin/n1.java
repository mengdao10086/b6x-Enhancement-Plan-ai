package kotlin;

/* JADX INFO: loaded from: classes5.dex */
public final class n1 {
    @bk.f
    @s
    @v0(version = "1.3")
    public static final int[] a(int i10, ik.l<? super Integer, l1> init) {
        kotlin.jvm.internal.f0.p(init, "init");
        int[] iArr = new int[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            iArr[i11] = init.i(Integer.valueOf(i11)).l0();
        }
        return m1.e(iArr);
    }

    @bk.f
    @s
    @v0(version = "1.3")
    public static final int[] b(int... elements) {
        kotlin.jvm.internal.f0.p(elements, "elements");
        return elements;
    }
}
