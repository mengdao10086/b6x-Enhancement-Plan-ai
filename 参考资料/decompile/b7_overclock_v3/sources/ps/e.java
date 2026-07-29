package ps;

import org.bouncycastle.crypto.k;

/* JADX INFO: loaded from: classes6.dex */
public class e implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f47038a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f47039b;

    public e() {
        int[] iArr = {6, 12, 17, 22, 33};
        this.f47038a = iArr;
        this.f47039b = iArr;
    }

    public e(int[] iArr) {
        this.f47038a = new int[]{6, 12, 17, 22, 33};
        this.f47039b = iArr;
        a();
    }

    public final void a() {
        int[] iArr;
        int i10;
        int[] iArr2 = this.f47039b;
        if (iArr2 == null) {
            throw new IllegalArgumentException("no layers defined.");
        }
        if (iArr2.length <= 1) {
            throw new IllegalArgumentException("Rainbow needs at least 1 layer, such that v1 < v2.");
        }
        int i11 = 0;
        do {
            iArr = this.f47039b;
            if (i11 >= iArr.length - 1) {
                return;
            }
            i10 = iArr[i11];
            i11++;
        } while (i10 < iArr[i11]);
        throw new IllegalArgumentException("v[i] has to be smaller than v[i+1]");
    }

    public int b() {
        int[] iArr = this.f47039b;
        return iArr[iArr.length - 1] - iArr[0];
    }

    public int c() {
        return this.f47039b.length - 1;
    }

    public int[] d() {
        return this.f47039b;
    }
}
