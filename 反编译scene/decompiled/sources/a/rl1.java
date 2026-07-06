package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.dialogs.DialogExchange$exchangeHandler$1", f = "DialogExchange.kt", l = {220}, m = "invokeSuspend")
public final class rl1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ nm1 f7313a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f2755a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f2756a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rl1(nm1 nm1Var, b62 b62Var) {
        super(2, b62Var);
        this.f7313a = nm1Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        rl1 rl1Var = new rl1(this.f7313a, b62Var);
        rl1Var.f2755a = (wd2) obj;
        return rl1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((rl1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        Object objC = r62.c();
        int i = this.b;
        if (i == 0) {
            h42.b(obj);
            wd2 wd2Var = this.f2755a;
            sn0 sn0Var = new sn0(this.f7313a.f2115a);
            this.f2756a = wd2Var;
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
