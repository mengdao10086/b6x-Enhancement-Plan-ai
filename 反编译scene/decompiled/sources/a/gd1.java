package a;

import com.omarea.Scene;
import com.omarea.vtools.activities.ActivityOplusORMS;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.activities.ActivityOplusORMS$onOptionsItemSelected$2$2", f = "ActivityOplusORMS.kt", l = {}, m = "invokeSuspend")
public final class gd1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wd2 f6196a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActivityOplusORMS.b f998a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gd1(ActivityOplusORMS.b bVar, b62 b62Var) {
        super(2, b62Var);
        this.f998a = bVar;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        gd1 gd1Var = new gd1(this.f998a, b62Var);
        gd1Var.f6196a = (wd2) obj;
        return gd1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((gd1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        Scene.c cVar = Scene.f4798a;
        String string = ActivityOplusORMS.this.getString(u61.orms_no_change);
        f92.c(string, "getString(R.string.orms_no_change)");
        Scene.c.p(cVar, string, 0, 2, null);
        ActivityOplusORMS.k(ActivityOplusORMS.this).c();
        return m42.f6769a;
    }
}
