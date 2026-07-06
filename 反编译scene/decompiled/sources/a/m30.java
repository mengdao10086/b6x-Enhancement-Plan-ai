package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class m30 extends d30 {
    public m30(g82<? super l30, m42>... g82VarArr) {
        f92.d(g82VarArr, "items");
        for (g82<? super l30, m42> g82Var : g82VarArr) {
            l30 l30Var = new l30();
            g82Var.f(l30Var);
            super.k(l30Var);
        }
    }

    public m30(Object... objArr) throws Exception {
        f92.d(objArr, "items");
        for (Object obj : objArr) {
            if (obj instanceof y32) {
                throw new Exception(this + " 函数不能作为数据，请避免将 json{ ... } 写成 { ... }");
            }
            super.k(obj);
        }
    }
}
