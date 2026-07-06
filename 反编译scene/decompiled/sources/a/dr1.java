package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.fragments.FragmentAppSystem$setList$1", f = "FragmentAppSystem.kt", l = {113}, m = "invokeSuspend")
public final class dr1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ gr1 f5931a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f596a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f597a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dr1(gr1 gr1Var, b62 b62Var) {
        super(2, b62Var);
        this.f5931a = gr1Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        dr1 dr1Var = new dr1(this.f5931a, b62Var);
        dr1Var.f596a = (wd2) obj;
        return dr1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((dr1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        Object objC = r62.c();
        int i = this.b;
        if (i == 0) {
            h42.b(obj);
            wd2 wd2Var = this.f596a;
            gr1 gr1Var = this.f5931a;
            gr1Var.f1057a = gr1.y1(gr1Var).j();
            fg2 fg2VarC = qe2.c();
            cr1 cr1Var = new cr1(this, null);
            this.f597a = wd2Var;
            this.b = 1;
            if (oc2.g(fg2VarC, cr1Var, this) == objC) {
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
