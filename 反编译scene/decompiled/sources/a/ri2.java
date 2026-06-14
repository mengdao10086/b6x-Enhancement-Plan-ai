package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ri2 extends g92 implements k82<wi2, i62, wi2> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ri2 f7305a = new ri2();

    public ri2() {
        super(2);
    }

    public final wi2 a(wi2 wi2Var, i62 i62Var) {
        if (i62Var instanceof pg2) {
            ((pg2) i62Var).h(wi2Var.b(), wi2Var.d());
        }
        return wi2Var;
    }

    @Override // a.k82
    public /* bridge */ /* synthetic */ wi2 d(wi2 wi2Var, i62 i62Var) {
        wi2 wi2Var2 = wi2Var;
        a(wi2Var2, i62Var);
        return wi2Var2;
    }
}
