package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class hi2 {
    public abstract kh2<?> a();

    public final boolean b(hi2 hi2Var) {
        kh2<?> kh2VarA;
        kh2<?> kh2VarA2 = a();
        return (kh2VarA2 == null || (kh2VarA = hi2Var.a()) == null || kh2VarA2.f() >= kh2VarA.f()) ? false : true;
    }

    public abstract Object c(Object obj);

    public String toString() {
        return ce2.a(this) + '@' + ce2.b(this);
    }
}
