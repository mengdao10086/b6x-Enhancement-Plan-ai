package a;

import com.omarea.Scene;
import com.omarea.vtools.activities.ActivityOplusORMS;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.activities.ActivityOplusORMS$onOptionsItemSelected$2$3", f = "ActivityOplusORMS.kt", l = {}, m = "invokeSuspend")
public final class hd1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wd2 f6304a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActivityOplusORMS.b f1155a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hd1(ActivityOplusORMS.b bVar, b62 b62Var) {
        super(2, b62Var);
        this.f1155a = bVar;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        hd1 hd1Var = new hd1(this.f1155a, b62Var);
        hd1Var.f6304a = (wd2) obj;
        return hd1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((hd1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        Scene.c.p(Scene.f4798a, ">_<!", 0, 2, null);
        ActivityOplusORMS.k(ActivityOplusORMS.this).c();
        return m42.f6769a;
    }
}
