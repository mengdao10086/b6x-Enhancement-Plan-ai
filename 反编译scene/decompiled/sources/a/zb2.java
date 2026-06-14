package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class zb2 extends yb2 {
    public static final Double i(String str) {
        f92.d(str, "$this$toDoubleOrNull");
        try {
            if (qb2.f7197a.f(str)) {
                return Double.valueOf(Double.parseDouble(str));
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }
}
