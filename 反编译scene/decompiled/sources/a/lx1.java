package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.popup.FloatMonitor$startTimer$1$run$1", f = "FloatMonitor.kt", l = {422}, m = "invokeSuspend")
public final class lx1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ mx1 f6745a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f1850a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f1851a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lx1(mx1 mx1Var, b62 b62Var) {
        super(2, b62Var);
        this.f6745a = mx1Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        lx1 lx1Var = new lx1(this.f6745a, b62Var);
        lx1Var.f1850a = (wd2) obj;
        return lx1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((lx1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        Object objC = r62.c();
        int i = this.b;
        if (i == 0) {
            h42.b(obj);
            wd2 wd2Var = this.f1850a;
            ox1 ox1Var = this.f6745a.f6851a;
            this.f1851a = wd2Var;
            this.b = 1;
            if (ox1Var.y(this) == objC) {
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
