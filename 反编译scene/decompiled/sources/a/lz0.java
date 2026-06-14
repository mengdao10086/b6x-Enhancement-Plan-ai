package a;

import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class lz0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j60 f6750a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final rx0 f1872a;

    public lz0(j60 j60Var, rx0 rx0Var) {
        f92.d(j60Var, "resolver");
        this.f6750a = j60Var;
        this.f1872a = rx0Var;
    }

    public final double a(g30 g30Var, String str, double d) {
        if (g30Var.j(str)) {
            try {
                return Double.parseDouble(g30Var.b(str).toString());
            } catch (Exception unused) {
            }
        }
        return d;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(java.lang.Object r11, java.util.ArrayList<a.qz0> r12) throws a.e30 {
        /*
            Method dump skipped, instruction units count: 268
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.lz0.b(java.lang.Object, java.util.ArrayList):void");
    }

    public final String c(g30 g30Var, String str, String str2) {
        return g30Var.j(str) ? j60.d(this.f6750a, g30Var.b(str).toString(), false, 2, null) : str2;
    }

    public final ArrayList<oz0> d(String str) throws e30 {
        f92.d(str, "content");
        ArrayList<oz0> arrayList = new ArrayList<>();
        d30 d30Var = new d30(str);
        int iG = d30Var.g();
        for (int i = 0; i < iG; i++) {
            g30 g30VarD = d30Var.d(i);
            f92.c(g30VarD, "item");
            oz0 oz0VarE = e(g30VarD);
            if (oz0VarE != null) {
                arrayList.add(oz0VarE);
            }
        }
        return arrayList;
    }

    public final oz0 e(g30 g30Var) throws e30 {
        pz0 pz0VarF;
        if (!f92.a(c(g30Var, "visible", "auto"), "never")) {
            oz0 oz0Var = new oz0();
            oz0Var.f2344a = new ArrayList<>();
            if (g30Var.j("target_soc")) {
                d30 d30VarF = g30Var.f("target_soc");
                f92.c(d30VarF, "jObj.getJSONArray(\"target_soc\")");
                if (!g(d30VarF)) {
                    return null;
                }
            }
            if (g30Var.j("exclude_soc")) {
                d30 d30VarF2 = g30Var.f("exclude_soc");
                f92.c(d30VarF2, "jObj.getJSONArray(\"exclude_soc\")");
                if (g(d30VarF2)) {
                    return null;
                }
            }
            if (g30Var.j("items")) {
                Object objB = g30Var.b("items");
                if (objB instanceof d30) {
                    d30 d30Var = (d30) objB;
                    int iG = d30Var.g();
                    for (int i = 0; i < iG; i++) {
                        Object objA = d30Var.a(i);
                        if ((objA instanceof g30) && (pz0VarF = f((g30) objA)) != null) {
                            oz0Var.f2344a.add(pz0VarF);
                        }
                    }
                }
            }
            f92.c(oz0Var.f2344a, "group.items");
            if (!r2.isEmpty()) {
                oz0Var.f7067a = c(g30Var, "title", "");
                oz0Var.b = c(g30Var, "desc", "");
                return oz0Var;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final a.pz0 f(a.g30 r11) throws a.e30 {
        /*
            Method dump skipped, instruction units count: 370
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.lz0.f(a.g30):a.pz0");
    }

    public final boolean g(d30 d30Var) throws e30 {
        int iG = d30Var.g();
        boolean z = false;
        for (int i = 0; i < iG; i++) {
            String strE = d30Var.e(i);
            if (f92.a(jm0.f6525a.b(), strE) || f92.a(jm0.f6525a.a(), strE)) {
                z = true;
            }
        }
        return z;
    }
}
