package a;

import android.view.View;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.popup.FloatMonitorFPS$setUpView$2$1$2", f = "FloatMonitorFPS.kt", l = {}, m = "invokeSuspend")
public final class by1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ dy1 f5743a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f311a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public by1(dy1 dy1Var, b62 b62Var) {
        super(2, b62Var);
        this.f5743a = dy1Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        by1 by1Var = new by1(this.f5743a, b62Var);
        by1Var.f311a = (wd2) obj;
        return by1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((by1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        ((v72) this.f5743a.f625a.f6054a.f6891a).i();
        FrameLayout frameLayout = this.f5743a.f625a.f818a.f2475a;
        if (frameLayout != null) {
            frameLayout.setBackground(yb.d(this.f5743a.f625a.f819a, 2131230914));
            frameLayout.setAlpha(0.6f);
        }
        View view = this.f5743a.f625a.f818a.f2481b;
        if (view != null) {
            view.setVisibility(0);
        }
        View view2 = this.f5743a.f627a;
        f92.c(view2, "it");
        view2.setEnabled(true);
        return m42.f6769a;
    }
}
