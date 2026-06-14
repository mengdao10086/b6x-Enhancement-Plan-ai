package a;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class oc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f7004a = new Object();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static Method f2226a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static boolean f2227a;

    /* JADX WARN: Removed duplicated region for block: B:30:0x0027 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(android.content.res.Resources.Theme r6) {
        /*
            java.lang.Object r0 = a.oc.f7004a
            monitor-enter(r0)
            boolean r1 = a.oc.f2227a     // Catch: java.lang.Throwable -> L3e
            r2 = 0
            if (r1 != 0) goto L23
            r1 = 1
            java.lang.Class<android.content.res.Resources$Theme> r3 = android.content.res.Resources.Theme.class
            java.lang.String r4 = "rebase"
            java.lang.Class[] r5 = new java.lang.Class[r2]     // Catch: java.lang.NoSuchMethodException -> L19 java.lang.Throwable -> L3e
            java.lang.reflect.Method r3 = r3.getDeclaredMethod(r4, r5)     // Catch: java.lang.NoSuchMethodException -> L19 java.lang.Throwable -> L3e
            a.oc.f2226a = r3     // Catch: java.lang.NoSuchMethodException -> L19 java.lang.Throwable -> L3e
            r3.setAccessible(r1)     // Catch: java.lang.NoSuchMethodException -> L19 java.lang.Throwable -> L3e
            goto L21
        L19:
            r3 = move-exception
            java.lang.String r4 = "ResourcesCompat"
            java.lang.String r5 = "Failed to retrieve rebase() method"
            android.util.Log.i(r4, r5, r3)     // Catch: java.lang.Throwable -> L3e
        L21:
            a.oc.f2227a = r1     // Catch: java.lang.Throwable -> L3e
        L23:
            java.lang.reflect.Method r1 = a.oc.f2226a     // Catch: java.lang.Throwable -> L3e
            if (r1 == 0) goto L3c
            java.lang.reflect.Method r1 = a.oc.f2226a     // Catch: java.lang.reflect.InvocationTargetException -> L2f java.lang.IllegalAccessException -> L31 java.lang.Throwable -> L3e
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.reflect.InvocationTargetException -> L2f java.lang.IllegalAccessException -> L31 java.lang.Throwable -> L3e
            r1.invoke(r6, r2)     // Catch: java.lang.reflect.InvocationTargetException -> L2f java.lang.IllegalAccessException -> L31 java.lang.Throwable -> L3e
            goto L3c
        L2f:
            r6 = move-exception
            goto L32
        L31:
            r6 = move-exception
        L32:
            java.lang.String r1 = "ResourcesCompat"
            java.lang.String r2 = "Failed to invoke rebase() method via reflection"
            android.util.Log.i(r1, r2, r6)     // Catch: java.lang.Throwable -> L3e
            r6 = 0
            a.oc.f2226a = r6     // Catch: java.lang.Throwable -> L3e
        L3c:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L3e
            return
        L3e:
            r6 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L3e
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: a.oc.a(android.content.res.Resources$Theme):void");
    }
}
