package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.popup.FloatMonitorThreads$startTimer$1$run$1", f = "FloatMonitorThreads.kt", l = {149}, m = "invokeSuspend")
public final class ez1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ fz1 f6056a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f825a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f826a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ez1(fz1 fz1Var, b62 b62Var) {
        super(2, b62Var);
        this.f6056a = fz1Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        ez1 ez1Var = new ez1(this.f6056a, b62Var);
        ez1Var.f825a = (wd2) obj;
        return ez1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((ez1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        Object objC = r62.c();
        int i = this.b;
        if (i == 0) {
            h42.b(obj);
            wd2 wd2Var = this.f825a;
            iz1 iz1Var = this.f6056a.f6151a;
            this.f826a = wd2Var;
            this.b = 1;
            if (iz1Var.n(this) == objC) {
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
