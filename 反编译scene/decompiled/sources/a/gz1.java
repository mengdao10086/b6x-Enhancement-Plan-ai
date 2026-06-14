package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.popup.FloatMonitorThreads", f = "FloatMonitorThreads.kt", l = {112, 114}, m = "updateData")
public final class gz1 extends v62 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6256a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ iz1 f1077a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public /* synthetic */ Object f1078a;
    public Object b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gz1(iz1 iz1Var, b62 b62Var) {
        super(b62Var);
        this.f1077a = iz1Var;
    }

    @Override // a.s62
    public final Object j(Object obj) {
        this.f1078a = obj;
        this.f6256a |= Integer.MIN_VALUE;
        return this.f1077a.n(this);
    }
}
