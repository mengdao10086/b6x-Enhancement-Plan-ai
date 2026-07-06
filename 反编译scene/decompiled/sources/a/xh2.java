package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class xh2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f7893a = new li2("CONDITION_FALSE");

    public static final Object a() {
        return f7893a;
    }

    public static final zh2 b(Object obj) {
        zh2 zh2Var;
        ii2 ii2Var = (ii2) (!(obj instanceof ii2) ? null : obj);
        if (ii2Var != null && (zh2Var = ii2Var.f6418a) != null) {
            return zh2Var;
        }
        if (obj != null) {
            return (zh2) obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
    }
}
