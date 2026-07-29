package ve;

/* JADX INFO: loaded from: classes7.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f53152a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f53153b;

    public l(float f10, float f11) {
        this.f53152a = f10;
        this.f53153b = f11;
    }

    public static float a(l lVar, l lVar2, l lVar3) {
        float f10 = lVar2.f53152a;
        float f11 = lVar2.f53153b;
        return ((lVar3.f53152a - f10) * (lVar.f53153b - f11)) - ((lVar3.f53153b - f11) * (lVar.f53152a - f10));
    }

    public static float b(l lVar, l lVar2) {
        return bf.a.a(lVar.f53152a, lVar.f53153b, lVar2.f53152a, lVar2.f53153b);
    }

    public static void e(l[] lVarArr) {
        l lVar;
        l lVar2;
        l lVar3;
        float fB = b(lVarArr[0], lVarArr[1]);
        float fB2 = b(lVarArr[1], lVarArr[2]);
        float fB3 = b(lVarArr[0], lVarArr[2]);
        if (fB2 >= fB && fB2 >= fB3) {
            lVar = lVarArr[0];
            lVar2 = lVarArr[1];
            lVar3 = lVarArr[2];
        } else if (fB3 < fB2 || fB3 < fB) {
            lVar = lVarArr[2];
            lVar2 = lVarArr[0];
            lVar3 = lVarArr[1];
        } else {
            lVar = lVarArr[1];
            lVar2 = lVarArr[0];
            lVar3 = lVarArr[2];
        }
        if (a(lVar2, lVar, lVar3) < 0.0f) {
            l lVar4 = lVar3;
            lVar3 = lVar2;
            lVar2 = lVar4;
        }
        lVarArr[0] = lVar2;
        lVarArr[1] = lVar;
        lVarArr[2] = lVar3;
    }

    public final float c() {
        return this.f53152a;
    }

    public final float d() {
        return this.f53153b;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return this.f53152a == lVar.f53152a && this.f53153b == lVar.f53153b;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.f53152a) * 31) + Float.floatToIntBits(this.f53153b);
    }

    public final String toString() {
        return ee.a.f26978c + this.f53152a + ',' + this.f53153b + ')';
    }
}
