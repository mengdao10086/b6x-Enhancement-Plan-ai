package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.ui.AdapterProcess$initAppName$3", f = "AdapterProcess.kt", l = {}, m = "invokeSuspend")
public final class z11 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a21 f8027a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f3788a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z11(a21 a21Var, b62 b62Var) {
        super(2, b62Var);
        this.f8027a = a21Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        z11 z11Var = new z11(this.f8027a, b62Var);
        z11Var.f3788a = (wd2) obj;
        return z11Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((z11) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        this.f8027a.notifyDataSetChanged();
        return m42.f6769a;
    }
}
