package kotlin;

/* JADX INFO: loaded from: classes5.dex */
public final class x1 {
    @bk.f
    @s
    @v0(version = "1.3")
    public static final short[] a(int i10, ik.l<? super Integer, v1> init) {
        kotlin.jvm.internal.f0.p(init, "init");
        short[] sArr = new short[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            sArr[i11] = init.i(Integer.valueOf(i11)).j0();
        }
        return w1.e(sArr);
    }

    @bk.f
    @s
    @v0(version = "1.3")
    public static final short[] b(short... elements) {
        kotlin.jvm.internal.f0.p(elements, "elements");
        return elements;
    }
}
