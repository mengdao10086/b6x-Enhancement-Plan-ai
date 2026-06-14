package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.ui.AdapterProcess$1", f = "AdapterProcess.kt", l = {52}, m = "invokeSuspend")
public final class w11 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a21 f7744a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f3354a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f3355a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w11(a21 a21Var, b62 b62Var) {
        super(2, b62Var);
        this.f7744a = a21Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        w11 w11Var = new w11(this.f7744a, b62Var);
        w11Var.f3354a = (wd2) obj;
        return w11Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((w11) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        Object objC = r62.c();
        int i = this.b;
        if (i == 0) {
            h42.b(obj);
            wd2 wd2Var = this.f3354a;
            a21 a21Var = this.f7744a;
            this.f3355a = wd2Var;
            this.b = 1;
            if (a21Var.d(this) == objC) {
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
