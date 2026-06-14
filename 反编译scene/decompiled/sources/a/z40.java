package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.common.net.Daemon$syncAccessibilityState$1", f = "Daemon.kt", l = {}, m = "invokeSuspend")
public final class z40 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wd2 f8035a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final /* synthetic */ boolean f3795b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z40(boolean z, b62 b62Var) {
        super(2, b62Var);
        this.f3795b = z;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        z40 z40Var = new z40(this.f3795b, b62Var);
        z40Var.f8035a = (wd2) obj;
        return z40Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((z40) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        e50.j1(e50.f677a, "notify-accessibility-state", String.valueOf(this.f3795b), null, 4, null);
        return m42.f6769a;
    }
}
