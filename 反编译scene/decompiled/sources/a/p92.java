package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class p92 {
    public ka2 a(d92 d92Var) {
        return d92Var;
    }

    public ia2 b(Class cls) {
        return new z82(cls);
    }

    public ja2 c(Class cls, String str) {
        return new h92(cls, str);
    }

    public String d(c92 c92Var) {
        String string = c92Var.getClass().getGenericInterfaces()[0].toString();
        return string.startsWith("kotlin.jvm.functions.") ? string.substring(21) : string;
    }

    public String e(g92 g92Var) {
        return d(g92Var);
    }
}
