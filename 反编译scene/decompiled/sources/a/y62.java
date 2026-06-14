package a;

import java.lang.reflect.Field;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class y62 {
    public static final void a(int i, int i2) {
        if (i2 <= i) {
            return;
        }
        throw new IllegalStateException(("Debug metadata version mismatch. Expected: " + i + ", got " + i2 + ". Please update the Kotlin standard library.").toString());
    }

    public static final x62 b(s62 s62Var) {
        return (x62) s62Var.getClass().getAnnotation(x62.class);
    }

    public static final int c(s62 s62Var) {
        try {
            Field declaredField = s62Var.getClass().getDeclaredField("label");
            f92.c(declaredField, "field");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(s62Var);
            if (!(obj instanceof Integer)) {
                obj = null;
            }
            Integer num = (Integer) obj;
            return (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            return -1;
        }
    }

    public static final StackTraceElement d(s62 s62Var) {
        String strC;
        f92.d(s62Var, "$this$getStackTraceElementImpl");
        x62 x62VarB = b(s62Var);
        if (x62VarB == null) {
            return null;
        }
        a(1, x62VarB.v());
        int iC = c(s62Var);
        int i = iC < 0 ? -1 : x62VarB.l()[iC];
        String strB = b72.f238a.b(s62Var);
        if (strB == null) {
            strC = x62VarB.c();
        } else {
            strC = strB + '/' + x62VarB.c();
        }
        return new StackTraceElement(strC, x62VarB.m(), x62VarB.f(), i);
    }
}
