package a;

import android.widget.LinearLayout;
import com.omarea.vtools.activities.ActivityModules;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.activities.ActivityModules$refresh$1$1", f = "ActivityModules.kt", l = {}, m = "invokeSuspend")
public final class cd1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wd2 f5781a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActivityModules.b f383a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cd1(ActivityModules.b bVar, b62 b62Var) {
        super(2, b62Var);
        this.f383a = bVar;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        cd1 cd1Var = new cd1(this.f383a, b62Var);
        cd1Var.f5781a = (wd2) obj;
        return cd1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((cd1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        try {
            LinearLayout linearLayout = (LinearLayout) ActivityModules.this._$_findCachedViewById(t61.loading_view);
            f92.c(linearLayout, "loading_view");
            linearLayout.setVisibility(8);
            ActivityModules.this.s();
        } catch (Exception unused) {
        }
        return m42.f6769a;
    }
}
