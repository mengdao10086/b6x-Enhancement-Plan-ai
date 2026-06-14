package a;

import android.content.Context;
import com.omarea.Scene;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.library.basic.AccessibleServiceHelper$trySelfActivation$1", f = "AccessibleServiceHelper.kt", l = {40, 41}, m = "invokeSuspend")
public final class yg0 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wd2 f7981a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ zg0 f3711a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Context f3712a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f3713a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Runnable f3714a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yg0(zg0 zg0Var, Context context, Runnable runnable, b62 b62Var) {
        super(2, b62Var);
        this.f3711a = zg0Var;
        this.f3712a = context;
        this.f3714a = runnable;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        yg0 yg0Var = new yg0(this.f3711a, this.f3712a, this.f3714a, b62Var);
        yg0Var.f7981a = (wd2) obj;
        return yg0Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((yg0) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        wd2 wd2Var;
        Object objC = r62.c();
        int i = this.b;
        if (i == 0) {
            h42.b(obj);
            wd2Var = this.f7981a;
            this.f3711a.b(Scene.f4798a.c());
            e50.f677a.U0(null);
            this.f3713a = wd2Var;
            this.b = 1;
            if (ke2.a(500L, this) == objC) {
                return objC;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                h42.b(obj);
                return m42.f6769a;
            }
            wd2Var = (wd2) this.f3713a;
            h42.b(obj);
        }
        fg2 fg2VarC = qe2.c();
        xg0 xg0Var = new xg0(this, null);
        this.f3713a = wd2Var;
        this.b = 2;
        if (oc2.g(fg2VarC, xg0Var, this) == objC) {
            return objC;
        }
        return m42.f6769a;
    }
}
