package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.scene_mode.SceneMode$FreezeAppThread$run$3", f = "SceneMode.kt", l = {99}, m = "invokeSuspend")
public final class ww0 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l92 f7829a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ n92 f3486a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f3487a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f3488a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ww0(n92 n92Var, l92 l92Var, b62 b62Var) {
        super(2, b62Var);
        this.f3486a = n92Var;
        this.f7829a = l92Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        ww0 ww0Var = new ww0(this.f3486a, this.f7829a, b62Var);
        ww0Var.f3487a = (wd2) obj;
        return ww0Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((ww0) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // a.s62
    public final Object j(Object obj) {
        Object objC = r62.c();
        int i = this.b;
        if (i == 0) {
            h42.b(obj);
            wd2 wd2Var = this.f3487a;
            e50 e50Var = e50.f677a;
            String string = ((StringBuilder) this.f3486a.f6891a).toString();
            f92.c(string, "cmds.toString()");
            int i2 = this.f7829a.f6687a * 1000;
            this.f3488a = wd2Var;
            this.b = 1;
            obj = e50Var.e1(string, i2, this);
            if (obj == objC) {
                return objC;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            h42.b(obj);
        }
        tw0.c = (String) obj;
        return m42.f6769a;
    }
}
