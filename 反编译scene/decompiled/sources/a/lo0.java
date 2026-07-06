package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.net.SceneServer", f = "SceneServer.kt", l = {42}, m = "ping")
public final class lo0 extends v62 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6726a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ no0 f1840a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public /* synthetic */ Object f1841a;
    public Object b;
    public Object c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lo0(no0 no0Var, b62 b62Var) {
        super(b62Var);
        this.f1840a = no0Var;
    }

    @Override // a.s62
    public final Object j(Object obj) {
        this.f1841a = obj;
        this.f6726a |= Integer.MIN_VALUE;
        return this.f1840a.C(null, this);
    }
}
