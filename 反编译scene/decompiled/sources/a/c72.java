package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class c72 extends s62 {
    public c72(b62<Object> b62Var) {
        super(b62Var);
        if (b62Var != null) {
            if (!(b62Var.c() == m62.f6776a)) {
                throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext".toString());
            }
        }
    }

    @Override // a.b62
    public l62 c() {
        return m62.f6776a;
    }
}
