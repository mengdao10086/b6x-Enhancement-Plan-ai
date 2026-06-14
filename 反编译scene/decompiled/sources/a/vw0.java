package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.scene_mode.SceneMode$FreezeAppThread$run$1", f = "SceneMode.kt", l = {75}, m = "invokeSuspend")
public final class vw0 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wd2 f7730a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f3309a;
    public int b;

    public vw0(b62 b62Var) {
        super(2, b62Var);
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        vw0 vw0Var = new vw0(b62Var);
        vw0Var.f7730a = (wd2) obj;
        return vw0Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((vw0) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        Object objC = r62.c();
        int i = this.b;
        if (i == 0) {
            h42.b(obj);
            wd2 wd2Var = this.f7730a;
            e50 e50Var = e50.f677a;
            String str = tw0.c;
            this.f3309a = wd2Var;
            this.b = 1;
            if (e50Var.f1(str, this) == objC) {
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
