package a;

import android.content.Intent;
import com.omarea.Scene;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.library.basic.AccessibleServiceHelper$trySelfActivation$1$1", f = "AccessibleServiceHelper.kt", l = {}, m = "invokeSuspend")
public final class xg0 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wd2 f7887a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ yg0 f3583a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xg0(yg0 yg0Var, b62 b62Var) {
        super(2, b62Var);
        this.f3583a = yg0Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        xg0 xg0Var = new xg0(this.f3583a, b62Var);
        xg0Var.f7887a = (wd2) obj;
        return xg0Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((xg0) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        yg0 yg0Var = this.f3583a;
        if (yg0Var.f3711a.a(yg0Var.f3712a)) {
            try {
                e42 e42Var = g42.f6169a;
                this.f3583a.f3714a.run();
                g42.a(m42.f6769a);
            } catch (Throwable th) {
                e42 e42Var2 = g42.f6169a;
                g42.a(h42.a(th));
            }
        } else {
            try {
                Scene.c cVar = Scene.f4798a;
                String string = this.f3583a.f3712a.getString(u61.accessibility_please_activate);
                f92.c(string, "context.getString(R.stri…sibility_please_activate)");
                cVar.o(string, 0);
                this.f3583a.f3712a.startActivity(new Intent("android.settings.ACCESSIBILITY_SETTINGS"));
            } catch (Exception unused) {
            }
        }
        return m42.f6769a;
    }
}
