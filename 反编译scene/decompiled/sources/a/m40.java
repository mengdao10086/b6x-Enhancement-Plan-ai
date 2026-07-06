package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.common.net.Daemon", f = "Daemon.kt", l = {441, 447}, m = "socketApi")
public final class m40 extends v62 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6767a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ e50 f1888a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public /* synthetic */ Object f1889a;
    public Object b;
    public Object c;
    public Object d;
    public Object e;
    public Object f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m40(e50 e50Var, b62 b62Var) {
        super(b62Var);
        this.f1888a = e50Var;
    }

    @Override // a.s62
    public final Object j(Object obj) {
        this.f1889a = obj;
        this.f6767a |= Integer.MIN_VALUE;
        return this.f1888a.g1(null, null, null, this);
    }
}
