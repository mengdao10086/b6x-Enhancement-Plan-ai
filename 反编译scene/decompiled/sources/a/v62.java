package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class v62 extends s62 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l62 f7663a;
    public transient b62<Object> b;

    public v62(b62<Object> b62Var) {
        this(b62Var, b62Var != null ? b62Var.c() : null);
    }

    public v62(b62<Object> b62Var, l62 l62Var) {
        super(b62Var);
        this.f7663a = l62Var;
    }

    @Override // a.b62
    public l62 c() {
        l62 l62Var = this.f7663a;
        f92.b(l62Var);
        return l62Var;
    }

    @Override // a.s62
    public void k() {
        b62<?> b62Var = this.b;
        if (b62Var != null && b62Var != this) {
            i62 i62Var = c().get(e62.f5972a);
            f92.b(i62Var);
            ((e62) i62Var).r(b62Var);
        }
        this.b = u62.f7570a;
    }

    public final b62<Object> m() {
        b62<Object> b62VarD = this.b;
        if (b62VarD == null) {
            e62 e62Var = (e62) c().get(e62.f5972a);
            if (e62Var == null || (b62VarD = e62Var.d(this)) == null) {
                b62VarD = this;
            }
            this.b = b62VarD;
        }
        return b62VarD;
    }
}
