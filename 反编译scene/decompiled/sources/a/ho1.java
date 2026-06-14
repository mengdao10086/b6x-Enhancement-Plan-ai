package a;

import a.p80;
import android.app.Activity;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.dialogs.DialogPaymentMethods$show$5$1", f = "DialogPaymentMethods.kt", l = {}, m = "invokeSuspend")
public final class ho1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ io1 f6330a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f1200a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ho1(io1 io1Var, b62 b62Var) {
        super(2, b62Var);
        this.f6330a = io1Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        ho1 ho1Var = new ho1(this.f6330a, b62Var);
        ho1Var.f1200a = (wd2) obj;
        return ho1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((ho1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        p80.a aVar = p80.f2403a;
        Activity activity = this.f6330a.f6431a.f1572a;
        View view = (View) this.f6330a.f1394a.f6891a;
        f92.c(view, "view");
        aVar.r(activity, view, true);
        return m42.f6769a;
    }
}
