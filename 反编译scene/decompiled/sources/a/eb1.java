package a;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.omarea.vtools.activities.ActivityFpsSession;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.activities.ActivityFpsSession$setData$5$1", f = "ActivityFpsSession.kt", l = {}, m = "invokeSuspend")
public final class eb1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n92 f5987a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f718a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActivityFpsSession.x f719a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public eb1(ActivityFpsSession.x xVar, n92 n92Var, b62 b62Var) {
        super(2, b62Var);
        this.f719a = xVar;
        this.f5987a = n92Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        eb1 eb1Var = new eb1(this.f719a, this.f5987a, b62Var);
        eb1Var.f718a = (wd2) obj;
        return eb1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((eb1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        ((ImageView) ActivityFpsSession.this._$_findCachedViewById(t61.session_logo)).setImageDrawable((Drawable) this.f5987a.f6891a);
        return m42.f6769a;
    }
}
