package a;

import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class kn1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g91 f6623a;

    public kn1(g91 g91Var) {
        f92.d(g91Var, "activity");
        this.f6623a = g91Var;
    }

    public final boolean b() {
        ArrayList<String> arrayListH = ul0.h();
        if (arrayListH.size() <= 0) {
            return false;
        }
        boolean zA = this.f6623a.getThemeMode().a();
        f92.c(arrayListH, "options");
        ArrayList arrayList = new ArrayList(z42.m(arrayListH, 10));
        for (String str : arrayListH) {
            f92.c(str, "it");
            arrayList.add(new n30(str, str));
        }
        b90 b90Var = new b90(zA, arrayList, false, new jn1(this), 0, 16, null);
        b90Var.K1("切换温控配置");
        b90Var.B1(this.f6623a.getSupportFragmentManager(), "ThermalPolicy");
        return true;
    }
}
