package a;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class b72 {
    public static a72 b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final b72 f238a = new b72();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a72 f5680a = new a72(null, null, null);

    public final a72 a(s62 s62Var) {
        try {
            a72 a72Var = new a72(Class.class.getDeclaredMethod("getModule", new Class[0]), s62Var.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), s62Var.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", new Class[0]));
            b = a72Var;
            return a72Var;
        } catch (Exception unused) {
            a72 a72Var2 = f5680a;
            b = a72Var2;
            return a72Var2;
        }
    }

    public final String b(s62 s62Var) {
        Method method;
        Object objInvoke;
        Method method2;
        Object objInvoke2;
        f92.d(s62Var, "continuation");
        a72 a72VarA = b;
        if (a72VarA == null) {
            a72VarA = a(s62Var);
        }
        if (a72VarA == f5680a || (method = a72VarA.f5578a) == null || (objInvoke = method.invoke(s62Var.getClass(), new Object[0])) == null || (method2 = a72VarA.b) == null || (objInvoke2 = method2.invoke(objInvoke, new Object[0])) == null) {
            return null;
        }
        Method method3 = a72VarA.c;
        Object objInvoke3 = method3 != null ? method3.invoke(objInvoke2, new Object[0]) : null;
        return (String) (objInvoke3 instanceof String ? objInvoke3 : null);
    }
}
