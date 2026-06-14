package a;

import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class mn0 {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f1959a;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6825a = 1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public HashMap<Integer, in0> f1960a = new HashMap<>();

    public static /* synthetic */ ArrayList c(mn0 mn0Var, d30 d30Var, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 65535;
        }
        return mn0Var.b(d30Var, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(int r6, a.b62<? super java.util.ArrayList<a.in0>> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof a.kn0
            if (r0 == 0) goto L13
            r0 = r7
            a.kn0 r0 = (a.kn0) r0
            int r1 = r0.f6622a
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f6622a = r1
            goto L18
        L13:
            a.kn0 r0 = new a.kn0
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f1667a
            java.lang.Object r1 = a.r62.c()
            int r2 = r0.f6622a
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3b
            if (r2 == r4) goto L31
            if (r2 != r3) goto L29
            goto L31
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L31:
            int r6 = r0.b
            java.lang.Object r0 = r0.f1668b
            a.mn0 r0 = (a.mn0) r0
            a.h42.b(r7)
            goto L55
        L3b:
            a.h42.b(r7)
            java.lang.String r7 = r5.f1959a
            if (r7 == 0) goto L58
            a.e50 r2 = a.e50.f677a
            a.f92.b(r7)
            r0.f1668b = r5
            r0.b = r6
            r0.f6622a = r4
            java.lang.Object r7 = r2.x0(r7, r0)
            if (r7 != r1) goto L54
            return r1
        L54:
            r0 = r5
        L55:
            a.d30 r7 = (a.d30) r7
            goto L69
        L58:
            a.e50 r7 = a.e50.f677a
            int r2 = r5.f6825a
            r0.f1668b = r5
            r0.b = r6
            r0.f6622a = r3
            java.lang.Object r7 = r7.w0(r2, r0)
            if (r7 != r1) goto L54
            return r1
        L69:
            if (r7 == 0) goto L70
            java.util.ArrayList r6 = r0.b(r7, r6)
            return r6
        L70:
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: a.mn0.a(int, a.b62):java.lang.Object");
    }

    public final ArrayList<in0> b(d30 d30Var, int i) {
        f92.d(d30Var, "threadsArr");
        ArrayList<in0> arrayList = new ArrayList<>();
        int iG = d30Var.g();
        for (int i2 = 0; i2 < iG; i2++) {
            g30 g30VarD = d30Var.d(i2);
            double d = ((double) ((int) (g30VarD.d("load") * ((double) 10)))) / 10.0d;
            if (i2 > i || (i2 > 14 && d < 0.1d)) {
                break;
            }
            in0 in0Var = new in0();
            in0Var.m(g30VarD.n("pid"));
            String strT = g30VarD.t("cpus");
            f92.c(strT, "item.optString(\"cpus\")");
            in0Var.i(strT);
            in0Var.l(d);
            String strT2 = g30VarD.t("comm");
            f92.c(strT2, "item.optString(\"comm\")");
            in0Var.h(strT2);
            in0Var.j(g30VarD.r("duration"));
            in0Var.o(g30VarD.r("start_time"));
            in0 in0Var2 = this.f1960a.get(Integer.valueOf(in0Var.e()));
            if (in0Var2 != null && in0Var2.g() == in0Var.g()) {
                in0Var.h(in0Var2.a());
            }
            this.f1960a.put(Integer.valueOf(in0Var.e()), in0Var);
            arrayList.add(in0Var);
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(a.b62<? super a.m42> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof a.ln0
            if (r0 == 0) goto L13
            r0 = r5
            a.ln0 r0 = (a.ln0) r0
            int r1 = r0.f6724a
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f6724a = r1
            goto L18
        L13:
            a.ln0 r0 = new a.ln0
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f1838a
            java.lang.Object r1 = a.r62.c()
            int r2 = r0.f6724a
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r0 = r0.b
            a.mn0 r0 = (a.mn0) r0
            a.h42.b(r5)
            goto L48
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L35:
            a.h42.b(r5)
            a.e50 r5 = a.e50.f677a
            r2 = 65536(0x10000, float:9.1835E-41)
            r0.b = r4
            r0.f6724a = r3
            java.lang.Object r5 = r5.w0(r2, r0)
            if (r5 != r1) goto L47
            return r1
        L47:
            r0 = r4
        L48:
            java.util.HashMap<java.lang.Integer, a.in0> r5 = r0.f1960a
            r5.clear()
            a.m42 r5 = a.m42.f6769a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: a.mn0.d(a.b62):java.lang.Object");
    }

    public final mn0 e(String str) {
        f92.d(str, "targetApp");
        if (!f92.a(this.f1959a, str)) {
            this.f1960a.clear();
        }
        this.f1959a = str;
        this.f6825a = 1;
        return this;
    }

    public final mn0 f(int i) {
        if (this.f6825a != i) {
            this.f1960a.clear();
        }
        this.f6825a = i;
        this.f1959a = null;
        return this;
    }
}
