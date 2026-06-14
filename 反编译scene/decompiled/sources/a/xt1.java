package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.fragments.FragmentPerf$configInstalled$1", f = "FragmentPerf.kt", l = {}, m = "invokeSuspend")
public final class xt1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kv1 f7919a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f3612a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xt1(kv1 kv1Var, b62 b62Var) {
        super(2, b62Var);
        this.f7919a = kv1Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        xt1 xt1Var = new xt1(this.f7919a, b62Var);
        xt1Var.f3612a = (wd2) obj;
        return xt1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((xt1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        try {
            e42 e42Var = g42.f6169a;
            this.f7919a.a2();
            g42.a(m42.f6769a);
        } catch (Throwable th) {
            e42 e42Var2 = g42.f6169a;
            g42.a(h42.a(th));
        }
        return m42.f6769a;
    }
}
