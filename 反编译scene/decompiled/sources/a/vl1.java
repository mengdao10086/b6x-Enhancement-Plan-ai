package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.dialogs.DialogExchange$exchangeHandler$5", f = "DialogExchange.kt", l = {254}, m = "invokeSuspend")
public final class vl1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ nm1 f7705a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f3289a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f3290a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vl1(nm1 nm1Var, b62 b62Var) {
        super(2, b62Var);
        this.f7705a = nm1Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        vl1 vl1Var = new vl1(this.f7705a, b62Var);
        vl1Var.f3289a = (wd2) obj;
        return vl1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((vl1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        Object objC = r62.c();
        int i = this.b;
        if (i == 0) {
            h42.b(obj);
            wd2 wd2Var = this.f3289a;
            sn0 sn0Var = new sn0(this.f7705a.f2115a);
            this.f3290a = wd2Var;
            this.b = 1;
            if (sn0.b(sn0Var, null, this, 1, null) == objC) {
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
