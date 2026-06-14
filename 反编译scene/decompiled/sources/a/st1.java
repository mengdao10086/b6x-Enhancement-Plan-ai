package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.fragments.FragmentPerf$chooseConfigSource$2$2$1", f = "FragmentPerf.kt", l = {436}, m = "invokeSuspend")
public final class st1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n92 f7432a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ tt1 f2922a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f2923a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f2924a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final /* synthetic */ n92 f2925b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public st1(tt1 tt1Var, n92 n92Var, n92 n92Var2, b62 b62Var) {
        super(2, b62Var);
        this.f2922a = tt1Var;
        this.f7432a = n92Var;
        this.f2925b = n92Var2;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        st1 st1Var = new st1(this.f2922a, this.f7432a, this.f2925b, b62Var);
        st1Var.f2923a = (wd2) obj;
        return st1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((st1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // a.s62
    public final Object j(Object obj) {
        Object objC = r62.c();
        int i = this.b;
        if (i == 0) {
            h42.b(obj);
            wd2 wd2Var = this.f2923a;
            if ((((String) this.f7432a.f6891a).length() < 3 || f92.a((String) this.f7432a.f6891a, "611")) && ((kl0) this.f2925b.f6891a).l(0) < 2800000) {
                fg2 fg2VarC = qe2.c();
                rt1 rt1Var = new rt1(this, null);
                this.f2924a = wd2Var;
                this.b = 1;
                if (oc2.g(fg2VarC, rt1Var, this) == objC) {
                    return objC;
                }
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
