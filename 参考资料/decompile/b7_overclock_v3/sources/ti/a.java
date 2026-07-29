package ti;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class a {
    /* JADX WARN: Removed duplicated region for block: B:16:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static ti.a a() {
        /*
            java.lang.Object r0 = io.objectbox.BoxStore.h1()
            if (r0 == 0) goto L3e
            r1 = 0
            java.lang.String r2 = "android.content.Context"
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch: java.lang.ClassNotFoundException -> L2a java.lang.reflect.InvocationTargetException -> L2c java.lang.IllegalAccessException -> L2f java.lang.NoSuchMethodException -> L31
            java.lang.String r3 = "io.objectbox.android.internal.AndroidPlatform"
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch: java.lang.ClassNotFoundException -> L2a java.lang.reflect.InvocationTargetException -> L2c java.lang.IllegalAccessException -> L2f java.lang.NoSuchMethodException -> L31
            java.lang.String r4 = "create"
            r5 = 1
            java.lang.Class[] r6 = new java.lang.Class[r5]     // Catch: java.lang.ClassNotFoundException -> L2a java.lang.reflect.InvocationTargetException -> L2c java.lang.IllegalAccessException -> L2f java.lang.NoSuchMethodException -> L31
            r7 = 0
            r6[r7] = r2     // Catch: java.lang.ClassNotFoundException -> L2a java.lang.reflect.InvocationTargetException -> L2c java.lang.IllegalAccessException -> L2f java.lang.NoSuchMethodException -> L31
            java.lang.reflect.Method r2 = r3.getMethod(r4, r6)     // Catch: java.lang.ClassNotFoundException -> L2a java.lang.reflect.InvocationTargetException -> L2c java.lang.IllegalAccessException -> L2f java.lang.NoSuchMethodException -> L31
            java.lang.Object[] r3 = new java.lang.Object[r5]     // Catch: java.lang.ClassNotFoundException -> L2a java.lang.reflect.InvocationTargetException -> L2c java.lang.IllegalAccessException -> L2f java.lang.NoSuchMethodException -> L31
            r3[r7] = r0     // Catch: java.lang.ClassNotFoundException -> L2a java.lang.reflect.InvocationTargetException -> L2c java.lang.IllegalAccessException -> L2f java.lang.NoSuchMethodException -> L31
            java.lang.Object r0 = r2.invoke(r1, r3)     // Catch: java.lang.ClassNotFoundException -> L2a java.lang.reflect.InvocationTargetException -> L2c java.lang.IllegalAccessException -> L2f java.lang.NoSuchMethodException -> L31
            ti.a r0 = (ti.a) r0     // Catch: java.lang.ClassNotFoundException -> L2a java.lang.reflect.InvocationTargetException -> L2c java.lang.IllegalAccessException -> L2f java.lang.NoSuchMethodException -> L31
            return r0
        L2a:
            goto L33
        L2c:
            r0 = move-exception
        L2d:
            r1 = r0
            goto L33
        L2f:
            r0 = move-exception
            goto L2d
        L31:
            r0 = move-exception
            goto L2d
        L33:
            if (r1 != 0) goto L36
            goto L3e
        L36:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r2 = "AndroidPlatform could not be created."
            r0.<init>(r2, r1)
            throw r0
        L3e:
            ti.a r0 = new ti.a
            r0.<init>()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ti.a.a():ti.a");
    }

    @Nullable
    public si.a b() {
        return null;
    }
}
