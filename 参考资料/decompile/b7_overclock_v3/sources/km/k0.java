package km;

/* JADX INFO: loaded from: classes5.dex */
public class k0 {
    public static a[] a(a[] aVarArr) {
        a[] aVarArr2 = new a[aVarArr.length];
        System.arraycopy(aVarArr, 0, aVarArr2, 0, aVarArr.length);
        return aVarArr2;
    }

    public static zn.y[] b(zn.y[] yVarArr) {
        zn.y[] yVarArr2 = new zn.y[yVarArr.length];
        System.arraycopy(yVarArr, 0, yVarArr2, 0, yVarArr.length);
        return yVarArr2;
    }

    public static a[] c(gm.f0 f0Var) {
        a[] aVarArr = new a[f0Var.size()];
        for (int i10 = 0; i10 != f0Var.size(); i10++) {
            aVarArr[i10] = a.z(f0Var.K(i10));
        }
        return aVarArr;
    }
}
