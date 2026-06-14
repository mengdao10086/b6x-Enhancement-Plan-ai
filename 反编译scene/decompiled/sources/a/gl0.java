package a;

import com.omarea.Scene;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.library.shell.BatteryUtils$setCurrentLimitMA$1", f = "BatteryUtils.kt", l = {}, m = "invokeSuspend")
public final class gl0 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wd2 f6218a;
    public int b;
    public final /* synthetic */ int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gl0(int i, b62 b62Var) {
        super(2, b62Var);
        this.c = i;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        gl0 gl0Var = new gl0(this.c, b62Var);
        gl0Var.f6218a = (wd2) obj;
        return gl0Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((gl0) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        synchronized (Scene.f4798a.c()) {
            e50.j1(e50.f677a, "charge-control", this.c + "000", null, 4, null);
            hl0.f1178a = false;
            m42 m42Var = m42.f6769a;
        }
        return m42.f6769a;
    }
}
