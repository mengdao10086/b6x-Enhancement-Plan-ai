package et;

import java.security.spec.AlgorithmParameterSpec;

/* JADX INFO: loaded from: classes6.dex */
public class h implements AlgorithmParameterSpec {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f27158b = {6, 12, 17, 22, 33};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f27159a;

    public h() {
        this.f27159a = f27158b;
    }

    public h(int[] iArr) {
        this.f27159a = iArr;
        a();
    }

    public final void a() {
        int[] iArr;
        int i10;
        int[] iArr2 = this.f27159a;
        if (iArr2 == null) {
            throw new IllegalArgumentException("no layers defined.");
        }
        if (iArr2.length <= 1) {
            throw new IllegalArgumentException("Rainbow needs at least 1 layer, such that v1 < v2.");
        }
        int i11 = 0;
        do {
            iArr = this.f27159a;
            if (i11 >= iArr.length - 1) {
                return;
            }
            i10 = iArr[i11];
            i11++;
        } while (i10 < iArr[i11]);
        throw new IllegalArgumentException("v[i] has to be smaller than v[i+1]");
    }

    public int b() {
        int[] iArr = this.f27159a;
        return iArr[iArr.length - 1] - iArr[0];
    }

    public int c() {
        return this.f27159a.length - 1;
    }

    public int[] d() {
        return org.bouncycastle.util.a.s(this.f27159a);
    }
}
