package a;

import android.view.View;
import com.omarea.vtools.activities.ActivityFpsSession;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.activities.ActivityFpsSession$optionalSet$optionalApply$1$2", f = "ActivityFpsSession.kt", l = {}, m = "invokeSuspend")
public final class ua1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wd2 f7581a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActivityFpsSession.m f3163a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ua1(ActivityFpsSession.m mVar, b62 b62Var) {
        super(2, b62Var);
        this.f3163a = mVar;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        ua1 ua1Var = new ua1(this.f3163a, b62Var);
        ua1Var.f7581a = (wd2) obj;
        return ua1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((ua1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        View view;
        int i;
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        for (n30 n30Var : this.f3163a.f8665a) {
            boolean zC = n30Var.c();
            Object objB = n30Var.b();
            if (zC) {
                if (objB == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.view.View");
                }
                view = (View) objB;
                i = 0;
            } else {
                if (objB == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.view.View");
                }
                view = (View) objB;
                i = 8;
            }
            view.setVisibility(i);
        }
        return m42.f6769a;
    }
}
