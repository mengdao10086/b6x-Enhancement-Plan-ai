package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.net.ScenePerf$cloudProfileVersion$1", f = "ScenePerf.kt", l = {}, m = "invokeSuspend")
public final class eo0 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ar0 f6025a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ho0 f775a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f776a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public eo0(ho0 ho0Var, ar0 ar0Var, b62 b62Var) {
        super(2, b62Var);
        this.f775a = ho0Var;
        this.f6025a = ar0Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        eo0 eo0Var = new eo0(this.f775a, this.f6025a, b62Var);
        eo0Var.f776a = (wd2) obj;
        return eo0Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((eo0) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        this.f775a.D(this.f6025a.d(), this.f6025a.c());
        return m42.f6769a;
    }
}
