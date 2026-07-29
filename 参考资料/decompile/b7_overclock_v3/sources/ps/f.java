package ps;

/* JADX INFO: loaded from: classes6.dex */
public class f extends d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public short[][] f47040c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public short[] f47041d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public short[][] f47042e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public short[] f47043f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int[] f47044g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public a[] f47045h;

    public f(short[][] sArr, short[] sArr2, short[][] sArr3, short[] sArr4, int[] iArr, a[] aVarArr) {
        super(true, iArr[iArr.length - 1] - iArr[0]);
        this.f47040c = sArr;
        this.f47041d = sArr2;
        this.f47042e = sArr3;
        this.f47043f = sArr4;
        this.f47044g = iArr;
        this.f47045h = aVarArr;
    }

    public short[] e() {
        return this.f47041d;
    }

    public short[] f() {
        return this.f47043f;
    }

    public short[][] g() {
        return this.f47040c;
    }

    public short[][] h() {
        return this.f47042e;
    }

    public a[] i() {
        return this.f47045h;
    }

    public int[] j() {
        return this.f47044g;
    }
}
