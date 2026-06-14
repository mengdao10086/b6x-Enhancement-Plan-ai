package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.common.net.Daemon", f = "Daemon.kt", l = {1138}, m = "postEvent")
public final class i40 extends v62 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6374a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ e50 f1325a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public /* synthetic */ Object f1326a;
    public Object b;
    public Object c;
    public Object d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i40(e50 e50Var, b62 b62Var) {
        super(b62Var);
        this.f1325a = e50Var;
    }

    @Override // a.s62
    public final Object j(Object obj) {
        this.f1326a = obj;
        this.f6374a |= Integer.MIN_VALUE;
        return this.f1325a.M0(null, null, this);
    }
}
