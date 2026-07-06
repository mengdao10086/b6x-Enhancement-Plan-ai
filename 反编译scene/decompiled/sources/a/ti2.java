package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class ti2 {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final li2 f3036a = new li2("ZERO");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k82<Object, i62, Object> f7506a = pi2.f7123a;
    public static final k82<pg2<?>, i62, pg2<?>> b = qi2.f7216a;
    public static final k82<wi2, i62, wi2> c = si2.f7403a;
    public static final k82<wi2, i62, wi2> d = ri2.f7305a;

    public static final void a(l62 l62Var, Object obj) {
        if (obj == f3036a) {
            return;
        }
        if (obj instanceof wi2) {
            ((wi2) obj).c();
            l62Var.fold(obj, d);
        } else {
            Object objFold = l62Var.fold(null, b);
            if (objFold == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
            }
            ((pg2) objFold).h(l62Var, obj);
        }
    }

    public static final Object b(l62 l62Var) {
        Object objFold = l62Var.fold(0, f7506a);
        f92.b(objFold);
        return objFold;
    }

    public static final Object c(l62 l62Var, Object obj) {
        if (obj == null) {
            obj = b(l62Var);
        }
        if (obj == 0) {
            return f3036a;
        }
        if (obj instanceof Integer) {
            return l62Var.fold(new wi2(l62Var, ((Number) obj).intValue()), c);
        }
        if (obj != null) {
            return ((pg2) obj).b(l62Var);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
    }
}
