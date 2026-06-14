package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ns1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ os1 f6945a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f2154a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f2155a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ns1(b62 b62Var, os1 os1Var) {
        super(2, b62Var);
        this.f6945a = os1Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        ns1 ns1Var = new ns1(b62Var, this.f6945a);
        ns1Var.f2154a = (wd2) obj;
        return ns1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((ns1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        Object objC = r62.c();
        int i = this.b;
        if (i == 0) {
            h42.b(obj);
            wd2 wd2Var = this.f2154a;
            zs1 zs1Var = this.f6945a.f2296a;
            this.f2155a = wd2Var;
            this.b = 1;
            if (zs1Var.S1(this) == objC) {
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
