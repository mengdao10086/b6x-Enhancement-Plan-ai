package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class ke2 {
    public static final Object a(long j, b62<? super m42> b62Var) {
        if (j <= 0) {
            return m42.f6769a;
        }
        uc2 uc2Var = new uc2(q62.b(b62Var), 1);
        uc2Var.B();
        b(uc2Var.c()).g(j, uc2Var);
        Object objZ = uc2Var.z();
        if (objZ == r62.c()) {
            z62.c(b62Var);
        }
        return objZ;
    }

    public static final je2 b(l62 l62Var) {
        i62 i62Var = l62Var.get(e62.f5972a);
        if (!(i62Var instanceof je2)) {
            i62Var = null;
        }
        je2 je2Var = (je2) i62Var;
        return je2Var != null ? je2Var : ee2.a();
    }
}
