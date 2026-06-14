package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.common.net.Daemon", f = "Daemon.kt", l = {535}, m = "getKernelProp")
public final class u30 extends v62 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7562a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ e50 f3122a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public /* synthetic */ Object f3123a;
    public Object b;
    public Object c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u30(e50 e50Var, b62 b62Var) {
        super(b62Var);
        this.f3122a = e50Var;
    }

    @Override // a.s62
    public final Object j(Object obj) {
        this.f3123a = obj;
        this.f7562a |= Integer.MIN_VALUE;
        return this.f3122a.o0(null, this);
    }
}
