package a;

import android.content.SharedPreferences;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.library.shell.TripleCacheValue$refreshCache$1", f = "TripleCacheValue.kt", l = {}, m = "invokeSuspend")
public final class nn0 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ on0 f6934a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f2121a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ SharedPreferences f2122a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nn0(on0 on0Var, SharedPreferences sharedPreferences, b62 b62Var) {
        super(2, b62Var);
        this.f6934a = on0Var;
        this.f2122a = sharedPreferences;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        nn0 nn0Var = new nn0(this.f6934a, this.f2122a, b62Var);
        nn0Var.f2121a = (wd2) obj;
        return nn0Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((nn0) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0056  */
    @Override // a.s62
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object j(java.lang.Object r4) {
        /*
            r3 = this;
            a.r62.c()
            int r0 = r3.b
            if (r0 != 0) goto L6c
            a.h42.b(r4)
            a.on0 r4 = r3.f6934a
            java.lang.String r4 = r4.f()
            a.on0 r0 = r3.f6934a
            java.lang.String r0 = a.on0.a(r0)
            boolean r0 = a.f92.a(r0, r4)
            r1 = 1
            r0 = r0 ^ r1
            if (r0 == 0) goto L69
            a.on0 r0 = r3.f6934a
            a.on0.c(r0, r4)
            a.on0 r0 = r3.f6934a
            java.lang.String r0 = a.on0.a(r0)
            if (r0 == 0) goto L56
            int r0 = r0.length()
            if (r0 <= 0) goto L33
            r0 = r1
            goto L34
        L33:
            r0 = 0
        L34:
            if (r0 != r1) goto L56
            a.on0 r0 = r3.f6934a
            java.lang.String r0 = a.on0.a(r0)
            java.lang.String r2 = "error"
            boolean r0 = a.f92.a(r0, r2)
            r0 = r0 ^ r1
            if (r0 == 0) goto L56
            android.content.SharedPreferences r0 = r3.f2122a
            android.content.SharedPreferences$Editor r0 = r0.edit()
            a.on0 r1 = r3.f6934a
            java.lang.String r1 = a.on0.b(r1)
            android.content.SharedPreferences$Editor r4 = r0.putString(r1, r4)
            goto L66
        L56:
            android.content.SharedPreferences r4 = r3.f2122a
            android.content.SharedPreferences$Editor r4 = r4.edit()
            a.on0 r0 = r3.f6934a
            java.lang.String r0 = a.on0.b(r0)
            android.content.SharedPreferences$Editor r4 = r4.remove(r0)
        L66:
            r4.apply()
        L69:
            a.m42 r4 = a.m42.f6769a
            return r4
        L6c:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: a.nn0.j(java.lang.Object):java.lang.Object");
    }
}
