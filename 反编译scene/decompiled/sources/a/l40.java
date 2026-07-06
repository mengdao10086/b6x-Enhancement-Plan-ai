package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.common.net.Daemon", f = "Daemon.kt", l = {94}, m = "setWorkingMode")
public final class l40 extends v62 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6672a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ e50 f1751a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public /* synthetic */ Object f1752a;
    public Object b;
    public Object c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l40(e50 e50Var, b62 b62Var) {
        super(b62Var);
        this.f1751a = e50Var;
    }

    @Override // a.s62
    public final Object j(Object obj) {
        this.f1752a = obj;
        this.f6672a |= Integer.MIN_VALUE;
        return this.f1751a.d1(null, this);
    }
}
