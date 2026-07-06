package a;

import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class o50 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList<n50> f6983a;

    public o50(g30 g30Var) throws e30 {
        f92.d(g30Var, "jsonObject");
        this.f6983a = new ArrayList<>();
        if (g30Var.j("success")) {
            g30Var.c("success");
        }
        if (g30Var.j("error")) {
            f92.c(g30Var.i("error"), "jsonObject.getString(\"error\")");
        }
        if (g30Var.j("absPath")) {
            f92.c(g30Var.i("absPath"), "jsonObject.getString(\"absPath\")");
        }
        if (g30Var.j("files")) {
            d30 d30VarF = g30Var.f("files");
            int iG = d30VarF.g();
            for (int i = 0; i < iG; i++) {
                ArrayList<n50> arrayList = this.f6983a;
                g30 g30VarD = d30VarF.d(i);
                f92.c(g30VarD, "arr.getJSONObject(i)");
                arrayList.add(new n50(g30VarD));
            }
        }
    }

    public final ArrayList<n50> a() {
        return this.f6983a;
    }
}
