package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.library.basic.FormValueHandler$bindInput$8$1", f = "FormValueHandler.kt", l = {}, m = "invokeSuspend")
public final class ei0 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ fi0 f6007a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ i92 f739a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f740a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ei0(fi0 fi0Var, i92 i92Var, b62 b62Var) {
        super(2, b62Var);
        this.f6007a = fi0Var;
        this.f739a = i92Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        ei0 ei0Var = new ei0(this.f6007a, this.f739a, b62Var);
        ei0Var.f740a = (wd2) obj;
        return ei0Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((ei0) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        this.f6007a.f903a.setChecked(this.f739a.b);
        return m42.f6769a;
    }
}
