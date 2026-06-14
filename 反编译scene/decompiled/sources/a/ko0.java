package a;

import com.omarea.Scene;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.net.SceneServer$ping$1", f = "SceneServer.kt", l = {33}, m = "invokeSuspend")
public final class ko0 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ no0 f6625a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f1670a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f1671a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Runnable f1672a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ko0(no0 no0Var, Runnable runnable, b62 b62Var) {
        super(2, b62Var);
        this.f6625a = no0Var;
        this.f1672a = runnable;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        ko0 ko0Var = new ko0(this.f6625a, this.f1672a, b62Var);
        ko0Var.f1670a = (wd2) obj;
        return ko0Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((ko0) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        Object objC = r62.c();
        int i = this.b;
        if (i == 0) {
            h42.b(obj);
            wd2 wd2Var = this.f1670a;
            no0 no0Var = this.f6625a;
            this.f1671a = wd2Var;
            this.b = 1;
            obj = no0.E(no0Var, null, this, 1, null);
            if (obj == objC) {
                return objC;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            h42.b(obj);
        }
        if (((Boolean) obj).booleanValue()) {
            Scene.f4798a.i(this.f1672a);
        } else {
            Scene.c cVar = Scene.f4798a;
            String string = cVar.c().getString(u61.license_no_response);
            f92.c(string, "Scene.context.getString(…ring.license_no_response)");
            Scene.c.p(cVar, string, 0, 2, null);
        }
        return m42.f6769a;
    }
}
