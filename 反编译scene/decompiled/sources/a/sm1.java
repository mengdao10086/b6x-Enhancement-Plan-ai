package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.dialogs.DialogLogin$login$1$1", f = "DialogLogin.kt", l = {}, m = "invokeSuspend")
public final class sm1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ tm1 f7414a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f2906a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sm1(tm1 tm1Var, b62 b62Var) {
        super(2, b62Var);
        this.f7414a = tm1Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        sm1 sm1Var = new sm1(this.f7414a, b62Var);
        sm1Var.f2906a = (wd2) obj;
        return sm1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((sm1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        this.f7414a.f3042a.f3869a.c();
        return m42.f6769a;
    }
}
