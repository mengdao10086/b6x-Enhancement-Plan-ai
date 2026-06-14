package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class vr1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wd2 f7719a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ wr1 f3300a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f3301a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vr1(wr1 wr1Var, b62 b62Var) {
        super(2, b62Var);
        this.f3300a = wr1Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        vr1 vr1Var = new vr1(this.f3300a, b62Var);
        vr1Var.f7719a = (wd2) obj;
        return vr1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((vr1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        Object objC = r62.c();
        int i = this.b;
        if (i == 0) {
            h42.b(obj);
            wd2 wd2Var = this.f7719a;
            zs1 zs1Var = this.f3300a.f7817a;
            this.f3301a = wd2Var;
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
