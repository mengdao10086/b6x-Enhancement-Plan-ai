package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.ui.AdapterProcessMini$initAppName$3", f = "AdapterProcessMini.kt", l = {}, m = "invokeSuspend")
public final class d21 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f21 f5852a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f456a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d21(f21 f21Var, b62 b62Var) {
        super(2, b62Var);
        this.f5852a = f21Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        d21 d21Var = new d21(this.f5852a, b62Var);
        d21Var.f456a = (wd2) obj;
        return d21Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((d21) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        this.f5852a.notifyDataSetChanged();
        return m42.f6769a;
    }
}
