package kotlin;

/* JADX INFO: loaded from: classes5.dex */
public final class j1 {
    @bk.f
    @s
    @v0(version = "1.3")
    public static final byte[] a(int i10, ik.l<? super Integer, h1> init) {
        kotlin.jvm.internal.f0.p(init, "init");
        byte[] bArr = new byte[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            bArr[i11] = init.i(Integer.valueOf(i11)).j0();
        }
        return i1.e(bArr);
    }

    @bk.f
    @s
    @v0(version = "1.3")
    public static final byte[] b(byte... elements) {
        kotlin.jvm.internal.f0.p(elements, "elements");
        return elements;
    }
}
