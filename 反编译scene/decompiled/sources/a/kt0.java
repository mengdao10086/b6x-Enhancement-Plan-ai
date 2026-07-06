package a;

import android.content.Context;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class kt0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f6639a;

    public kt0(Context context) {
        f92.d(context, "ctx");
        this.f6639a = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final a.m30 c() {
        /*
            r20 = this;
            r6 = r20
            a.im0 r0 = a.jm0.f6525a
            java.lang.String r3 = r0.a()
            java.lang.String r7 = "waipio"
            java.lang.String r8 = "lahaina"
            java.lang.String r9 = "cliffs"
            java.lang.String r10 = "mt6893"
            java.lang.String r11 = "mt6895"
            java.lang.String r12 = "mt6897"
            java.lang.String r13 = "mt6899"
            java.lang.String r14 = "mt6983"
            java.lang.String r15 = "mt6985"
            java.lang.String r16 = "zuma"
            java.lang.String r17 = "kera"
            java.lang.String r18 = "kona"
            java.lang.String r19 = "msmnile"
            java.lang.String[] r0 = new java.lang.String[]{r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19}
            boolean r5 = a.u42.k(r0, r3)
            a.e50 r0 = a.e50.f677a
            java.lang.String r0 = r0.d0()
            java.lang.String r1 = "FASLite"
            boolean r0 = a.f92.a(r0, r1)
            if (r0 == 0) goto L3b
            java.lang.String r0 = "never"
            goto L3d
        L3b:
            java.lang.String r0 = "always"
        L3d:
            r2 = r0
            java.lang.String r0 = android.os.Build.MANUFACTURER
            r1 = 0
            r4 = 1
            if (r0 == 0) goto L71
            if (r0 == 0) goto L69
            java.lang.String r0 = r0.toLowerCase()
            java.lang.String r7 = "(this as java.lang.String).toLowerCase()"
            a.f92.c(r0, r7)
            if (r0 == 0) goto L71
            java.lang.String r7 = "xiaomi"
            boolean r7 = a.f92.a(r0, r7)
            if (r7 != 0) goto L64
            java.lang.String r7 = "poco"
            boolean r0 = a.f92.a(r0, r7)
            if (r0 == 0) goto L62
            goto L64
        L62:
            r0 = r1
            goto L65
        L64:
            r0 = r4
        L65:
            if (r0 != r4) goto L71
            r7 = r4
            goto L72
        L69:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "null cannot be cast to non-null type java.lang.String"
            r0.<init>(r1)
            throw r0
        L71:
            r7 = r1
        L72:
            a.m30 r8 = new a.m30
            r0 = 5
            a.g82[] r9 = new a.g82[r0]
            a.cs0 r0 = new a.cs0
            r0.<init>(r6, r2)
            r9[r1] = r0
            a.js0 r0 = new a.js0
            r0.<init>(r6, r2)
            r9[r4] = r0
            r10 = 2
            a.dt0 r11 = new a.dt0
            r0 = r11
            r1 = r20
            r4 = r7
            r0.<init>(r1, r2, r3, r4, r5)
            r9[r10] = r11
            r0 = 3
            a.gt0 r1 = new a.gt0
            r1.<init>(r6)
            r9[r0] = r1
            r0 = 4
            a.jt0 r1 = new a.jt0
            r1.<init>(r6)
            r9[r0] = r1
            r8.<init>(r9)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: a.kt0.c():a.m30");
    }

    public final m30 d() {
        String[] strArrE = new kl0().e();
        String[] strArr = f92.a(jm0.f6525a.b(), "mt6991") ? new String[]{"sugov_ext", "performance", "conservative"} : new String[]{"uag", "walt", "sugov_ext", "schedutil", "performance", "conservative"};
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            f92.c(strArrE, "availableGovernors");
            if (u42.k(strArrE, str)) {
                arrayList.add(str);
            }
        }
        List listA0 = i52.a0(arrayList);
        listA0.add(0, "auto");
        Object[] array = listA0.toArray(new String[0]);
        if (array != null) {
            return new m30(Arrays.copyOf(array, array.length));
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public final String e(int i) {
        String string = this.f6639a.getString(i);
        f92.c(string, "ctx.getString(id)");
        return string;
    }
}
