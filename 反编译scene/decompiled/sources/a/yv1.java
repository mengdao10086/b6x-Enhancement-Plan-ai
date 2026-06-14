package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.fragments.FragmentUser$loginCallback$2$1$onLoginSuccess$2", f = "FragmentUser.kt", l = {}, m = "invokeSuspend")
public final class yv1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wd2 f8014a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ zv1 f3776a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yv1(zv1 zv1Var, b62 b62Var) {
        super(2, b62Var);
        this.f3776a = zv1Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        yv1 yv1Var = new yv1(this.f3776a, b62Var);
        yv1Var.f8014a = (wd2) obj;
        return yv1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((yv1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        this.f3776a.f8101a.f5648a.Y1();
        return m42.f6769a;
    }
}
