package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.popup.FloatMonitorFPS$stopRecord$1", f = "FloatMonitorFPS.kt", l = {}, m = "invokeSuspend")
public final class jy1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f6555a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ py1 f1585a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f1586a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jy1(py1 py1Var, long j, b62 b62Var) {
        super(2, b62Var);
        this.f1585a = py1Var;
        this.f6555a = j;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        jy1 jy1Var = new jy1(this.f1585a, this.f6555a, b62Var);
        jy1Var.f1586a = (wd2) obj;
        return jy1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((jy1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        d42<String, String> d42VarB = new co0().B(this.f1585a.f2470a.g(this.f6555a));
        if (d42VarB != null) {
            this.f1585a.f2470a.c0(this.f6555a, d42VarB.c());
        }
        return m42.f6769a;
    }
}
