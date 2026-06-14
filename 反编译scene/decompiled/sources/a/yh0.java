package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.library.basic.FormValueHandler$bindInput$3$1", f = "FormValueHandler.kt", l = {}, m = "invokeSuspend")
public final class yh0 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n92 f7983a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f3715a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ zh0 f3716a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yh0(zh0 zh0Var, n92 n92Var, b62 b62Var) {
        super(2, b62Var);
        this.f3716a = zh0Var;
        this.f7983a = n92Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        yh0 yh0Var = new yh0(this.f3716a, this.f7983a, b62Var);
        yh0Var.f3715a = (wd2) obj;
        return yh0Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((yh0) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        this.f3716a.f3848a.setText((String) this.f7983a.f6891a);
        return m42.f6769a;
    }
}
