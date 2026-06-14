package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class um0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final um0 f7612a = new um0();

    public final String a(String str) {
        f92.d(str, "prop");
        try {
            String property = System.getProperty(str);
            if (!(property == null || property.length() == 0)) {
                if (property != null) {
                    return ec2.s0(property).toString();
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
            }
        } catch (Exception unused) {
        }
        String strJ1 = e50.j1(e50.f677a, "get-prop", str, null, 4, null);
        if (f92.a(strJ1, "error")) {
            return "";
        }
        if (strJ1 != null) {
            return ec2.s0(strJ1).toString();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    public final boolean b(String str, String str2) {
        f92.d(str, "prop");
        f92.d(str2, "value");
        e50 e50Var = e50.f677a;
        return !f92.a(e50.j1(e50Var, "set-prop", str + ':' + str2, null, 4, null), "error");
    }
}
