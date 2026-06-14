package a;

import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.popup.FloatMonitorFPS$setUpView$2$1$3", f = "FloatMonitorFPS.kt", l = {}, m = "invokeSuspend")
public final class cy1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ dy1 f5839a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f452a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cy1(dy1 dy1Var, b62 b62Var) {
        super(2, b62Var);
        this.f5839a = dy1Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        cy1 cy1Var = new cy1(this.f5839a, b62Var);
        cy1Var.f452a = (wd2) obj;
        return cy1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((cy1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        View view = this.f5839a.f625a.f818a.f2481b;
        if (view != null) {
            view.setVisibility(8);
        }
        return m42.f6769a;
    }
}
