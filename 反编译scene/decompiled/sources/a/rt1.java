package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.fragments.FragmentPerf$chooseConfigSource$2$2$1$1", f = "FragmentPerf.kt", l = {}, m = "invokeSuspend")
public final class rt1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ st1 f7331a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f2785a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rt1(st1 st1Var, b62 b62Var) {
        super(2, b62Var);
        this.f7331a = st1Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        rt1 rt1Var = new rt1(this.f7331a, b62Var);
        rt1Var.f2785a = (wd2) obj;
        return rt1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((rt1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        this.f7331a.f2922a.f3059a.setVisibility(8);
        return m42.f6769a;
    }
}
