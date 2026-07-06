package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class ce2 {
    public static final String a(Object obj) {
        return obj.getClass().getSimpleName();
    }

    public static final String b(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static final String c(b62<?> b62Var) {
        Object objA;
        if (b62Var instanceof le2) {
            return b62Var.toString();
        }
        try {
            e42 e42Var = g42.f6169a;
            objA = b62Var + '@' + b(b62Var);
            g42.a(objA);
        } catch (Throwable th) {
            e42 e42Var2 = g42.f6169a;
            objA = h42.a(th);
            g42.a(objA);
        }
        if (g42.b(objA) != null) {
            objA = b62Var.getClass().getName() + '@' + b(b62Var);
        }
        return (String) objA;
    }
}
