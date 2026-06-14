package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.common.net.Daemon", f = "Daemon.kt", l = {373, 1466}, m = "socketSend")
public final class p40 extends v62 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7082a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ e50 f2385a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public /* synthetic */ Object f2386a;
    public Object b;
    public Object c;
    public Object d;
    public Object e;
    public Object f;
    public Object g;
    public Object h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p40(e50 e50Var, b62 b62Var) {
        super(b62Var);
        this.f2385a = e50Var;
    }

    @Override // a.s62
    public final Object j(Object obj) {
        this.f2386a = obj;
        this.f7082a |= Integer.MIN_VALUE;
        return this.f2385a.m1(null, null, null, null, this);
    }
}
