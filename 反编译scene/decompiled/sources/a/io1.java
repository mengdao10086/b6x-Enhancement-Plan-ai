package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.dialogs.DialogPaymentMethods$show$5", f = "DialogPaymentMethods.kt", l = {193, 194}, m = "invokeSuspend")
public final class io1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ jo1 f6431a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ n92 f1394a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f1395a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f1396a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public io1(jo1 jo1Var, n92 n92Var, b62 b62Var) {
        super(2, b62Var);
        this.f6431a = jo1Var;
        this.f1394a = n92Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        io1 io1Var = new io1(this.f6431a, this.f1394a, b62Var);
        io1Var.f1395a = (wd2) obj;
        return io1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((io1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        wd2 wd2Var;
        Object objC = r62.c();
        int i = this.b;
        if (i == 0) {
            h42.b(obj);
            wd2Var = this.f1395a;
            this.f1396a = wd2Var;
            this.b = 1;
            if (ke2.a(500L, this) == objC) {
                return objC;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                h42.b(obj);
                return m42.f6769a;
            }
            wd2Var = (wd2) this.f1396a;
            h42.b(obj);
        }
        fg2 fg2VarC = qe2.c();
        ho1 ho1Var = new ho1(this, null);
        this.f1396a = wd2Var;
        this.b = 2;
        if (oc2.g(fg2VarC, ho1Var, this) == objC) {
            return objC;
        }
        return m42.f6769a;
    }
}
