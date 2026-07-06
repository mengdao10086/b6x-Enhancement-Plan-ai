package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class vc1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ wc1 f7679a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f3266a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f3267a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Object f3268b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vc1(wc1 wc1Var, b62 b62Var) {
        super(2, b62Var);
        this.f7679a = wc1Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        vc1 vc1Var = new vc1(this.f7679a, b62Var);
        vc1Var.f3266a = (wd2) obj;
        return vc1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((vc1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        Object objC = r62.c();
        int i = this.b;
        try {
            if (i == 0) {
                h42.b(obj);
                wd2 wd2Var = this.f3266a;
                i92 i92Var = new i92();
                yn0 yn0Var = new yn0();
                String dbId = this.f7679a.f7775a.f7876a.getDbId();
                f92.b(dbId);
                String strN = this.f7679a.f7775a.f3571a.n();
                f92.b(strN);
                i92Var.b = yn0Var.y(dbId, strN);
                fg2 fg2VarC = qe2.c();
                uc1 uc1Var = new uc1(this, i92Var, null);
                this.f3267a = wd2Var;
                this.f3268b = i92Var;
                this.b = 1;
                if (oc2.g(fg2VarC, uc1Var, this) == objC) {
                    return objC;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                h42.b(obj);
            }
        } catch (Exception unused) {
        }
        return m42.f6769a;
    }
}
