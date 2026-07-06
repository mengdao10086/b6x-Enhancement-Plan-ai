package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.library.basic.FormValueHandler$bindInputDecimal$1$1", f = "FormValueHandler.kt", l = {}, m = "invokeSuspend")
public final class ji0 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j92 f6512a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ki0 f1545a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f1546a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ji0(ki0 ki0Var, j92 j92Var, b62 b62Var) {
        super(2, b62Var);
        this.f1545a = ki0Var;
        this.f6512a = j92Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        ji0 ji0Var = new ji0(this.f1545a, this.f6512a, b62Var);
        ji0Var.f1546a = (wd2) obj;
        return ji0Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((ji0) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        this.f1545a.f1638a.setText(String.valueOf(this.f6512a.f6490a));
        return m42.f6769a;
    }
}
