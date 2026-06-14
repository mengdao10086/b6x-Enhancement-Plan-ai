package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.activities.ActivityFiles$onViewCreated$1$1$1", f = "ActivityFiles.kt", l = {60}, m = "invokeSuspend")
public final class na1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n50 f6893a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ n92 f2029a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f2030a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f2031a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Object f2032b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public na1(n50 n50Var, n92 n92Var, b62 b62Var) {
        super(2, b62Var);
        this.f6893a = n50Var;
        this.f2029a = n92Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        na1 na1Var = new na1(this.f6893a, this.f2029a, b62Var);
        na1Var.f2030a = (wd2) obj;
        return na1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((na1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [T, java.lang.String] */
    @Override // a.s62
    public final Object j(Object obj) {
        Object objC = r62.c();
        int i = this.b;
        if (i == 0) {
            h42.b(obj);
            wd2 wd2Var = this.f2030a;
            n92 n92Var = new n92();
            n92Var.f6891a = e50.f677a.Z("pm install -r '" + this.f6893a.b() + '\'');
            fg2 fg2VarC = qe2.c();
            ma1 ma1Var = new ma1(this, n92Var, null);
            this.f2031a = wd2Var;
            this.f2032b = n92Var;
            this.b = 1;
            if (oc2.g(fg2VarC, ma1Var, this) == objC) {
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
