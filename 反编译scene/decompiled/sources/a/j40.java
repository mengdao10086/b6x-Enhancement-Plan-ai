package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.common.net.Daemon$setAccessibilityDaemon$1", f = "Daemon.kt", l = {}, m = "invokeSuspend")
public final class j40 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wd2 f6472a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Boolean f1502a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j40(Boolean bool, b62 b62Var) {
        super(2, b62Var);
        this.f1502a = bool;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        j40 j40Var = new j40(this.f1502a, b62Var);
        j40Var.f6472a = (wd2) obj;
        return j40Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((j40) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        e50.f677a.i1("accessibility-daemon", f92.a(this.f1502a, t62.a(true)) ? "60" : this.f1502a == null ? "-1" : "0", t62.f(10000L));
        return m42.f6769a;
    }
}
