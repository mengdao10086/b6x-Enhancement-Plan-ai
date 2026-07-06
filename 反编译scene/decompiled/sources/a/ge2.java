package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "kotlinx.coroutines.DeferredCoroutine", f = "Builders.common.kt", l = {101}, m = "await$suspendImpl")
public final class ge2 extends v62 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6200a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ he2 f1001a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public /* synthetic */ Object f1002a;
    public Object b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ge2(he2 he2Var, b62 b62Var) {
        super(b62Var);
        this.f1001a = he2Var;
    }

    @Override // a.s62
    public final Object j(Object obj) {
        this.f1002a = obj;
        this.f6200a |= Integer.MIN_VALUE;
        return he2.J0(this.f1001a, this);
    }
}
