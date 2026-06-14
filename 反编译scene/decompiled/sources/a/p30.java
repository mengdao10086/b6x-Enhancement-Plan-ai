package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.common.net.Daemon$execIgnoreResult$1", f = "Daemon.kt", l = {252}, m = "invokeSuspend")
public final class p30 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wd2 f7079a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f2382a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f2383a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p30(String str, b62 b62Var) {
        super(2, b62Var);
        this.f2383a = str;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        p30 p30Var = new p30(this.f2383a, b62Var);
        p30Var.f7079a = (wd2) obj;
        return p30Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((p30) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        Object objC = r62.c();
        int i = this.b;
        if (i == 0) {
            h42.b(obj);
            wd2 wd2Var = this.f7079a;
            e50 e50Var = e50.f677a;
            String str = this.f2383a;
            this.f2382a = wd2Var;
            this.b = 1;
            if (e50.h1(e50Var, "exec-shell", str, null, this, 4, null) == objC) {
                return objC;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            h42.b(obj);
        }
        return m42.f6769a;
    }
}
