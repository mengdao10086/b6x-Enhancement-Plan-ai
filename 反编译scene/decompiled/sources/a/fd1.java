package a;

import android.widget.EditText;
import com.omarea.Scene;
import com.omarea.vtools.activities.ActivityOplusORMS;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.activities.ActivityOplusORMS$onOptionsItemSelected$2$1", f = "ActivityOplusORMS.kt", l = {}, m = "invokeSuspend")
public final class fd1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n92 f6095a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f884a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActivityOplusORMS.b f885a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fd1(ActivityOplusORMS.b bVar, n92 n92Var, b62 b62Var) {
        super(2, b62Var);
        this.f885a = bVar;
        this.f6095a = n92Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        fd1 fd1Var = new fd1(this.f885a, this.f6095a, b62Var);
        fd1Var.f884a = (wd2) obj;
        return fd1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((fd1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        ((EditText) ActivityOplusORMS.this._$_findCachedViewById(t61.thermal_config)).setText((String) this.f6095a.f6891a);
        Scene.c.p(Scene.f4798a, "OK, ^_^", 0, 2, null);
        ActivityOplusORMS.k(ActivityOplusORMS.this).c();
        return m42.f6769a;
    }
}
