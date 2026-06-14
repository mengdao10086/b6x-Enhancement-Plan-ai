package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class od2 extends x52 implements e62 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final nd2 f7010a = new nd2(null);

    public od2() {
        super(e62.f5972a);
    }

    @Override // a.e62
    public final <T> b62<T> d(b62<? super T> b62Var) {
        return new le2(this, b62Var);
    }

    @Override // a.x52, a.i62, a.l62
    public <E extends i62> E get(j62<E> j62Var) {
        return (E) c62.a(this, j62Var);
    }

    public abstract void l(l62 l62Var, Runnable runnable);

    @Override // a.x52, a.l62
    public l62 minusKey(j62<?> j62Var) {
        return c62.b(this, j62Var);
    }

    public boolean o(l62 l62Var) {
        return true;
    }

    @Override // a.e62
    public void r(b62<?> b62Var) {
        if (b62Var == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.DispatchedContinuation<*>");
        }
        uc2<?> uc2VarK = ((le2) b62Var).k();
        if (uc2VarK != null) {
            uc2VarK.q();
        }
    }

    public String toString() {
        return ce2.a(this) + '@' + ce2.b(this);
    }
}
