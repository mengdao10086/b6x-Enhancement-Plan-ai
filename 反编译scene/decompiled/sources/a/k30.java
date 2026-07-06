package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class k30 {
    public static final Double[] a(g30 g30Var, String str) throws e30 {
        f92.d(g30Var, "$this$getDoubleArray");
        f92.d(str, "key");
        d30 d30VarF = g30Var.f(str);
        int iG = d30VarF.g();
        Double[] dArr = new Double[iG];
        for (int i = 0; i < iG; i++) {
            dArr[i] = Double.valueOf(0.0d);
        }
        int iG2 = d30VarF.g();
        for (int i2 = 0; i2 < iG2; i2++) {
            dArr[i2] = Double.valueOf(d30VarF.b(i2));
        }
        return dArr;
    }

    public static final Integer[] b(g30 g30Var, String str) throws e30 {
        f92.d(g30Var, "$this$getIntArray");
        f92.d(str, "key");
        d30 d30VarF = g30Var.f(str);
        int iG = d30VarF.g();
        Integer[] numArr = new Integer[iG];
        for (int i = 0; i < iG; i++) {
            numArr[i] = 0;
        }
        int iG2 = d30VarF.g();
        for (int i2 = 0; i2 < iG2; i2++) {
            numArr[i2] = Integer.valueOf(d30VarF.c(i2));
        }
        return numArr;
    }
}
