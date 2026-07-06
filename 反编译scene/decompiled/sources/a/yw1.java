package a;

import a.p80;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class yw1 extends g92 implements v72<m42> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ bx1 f8016a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yw1(bx1 bx1Var) {
        super(0);
        this.f8016a = bx1Var;
    }

    public final void a() {
        String strB0 = hz0.f1282a.B0();
        if (strB0 == null) {
            strB0 = "";
        }
        View viewInflate = this.f8016a.w().inflate(2131558541, (ViewGroup) null);
        p80.a aVar = p80.f2403a;
        cl clVarJ = this.f8016a.j();
        f92.b(clVarJ);
        f92.c(clVarJ, "activity!!");
        String strJ = this.f8016a.J(2131886519);
        f92.c(strJ, "getString(R.string.btn_confirm)");
        p80.a.j(aVar, clVarJ, viewInflate, new q80(strJ, new xw1(this, viewInflate, strB0), false, 4, null), null, 8, null);
    }

    @Override // a.v72
    public /* bridge */ /* synthetic */ m42 i() {
        a();
        return m42.f6769a;
    }
}
