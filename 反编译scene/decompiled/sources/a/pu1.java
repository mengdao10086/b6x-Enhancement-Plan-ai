package a;

import a.p80;
import android.content.Context;
import android.view.View;
import android.widget.Switch;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class pu1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kv1 f7150a;

    public pu1(kv1 kv1Var) {
        this.f7150a = kv1Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.Switch");
        }
        Switch r12 = (Switch) view;
        boolean zIsChecked = r12.isChecked();
        if (zIsChecked && !this.f7150a.f1689a.s()) {
            r12.setChecked(false);
            p80.a aVar = p80.f2403a;
            Context contextP = this.f7150a.p();
            f92.b(contextP);
            f92.c(contextP, "context!!");
            String strJ = this.f7150a.J(u61.sorry);
            f92.c(strJ, "getString(R.string.sorry)");
            String strJ2 = this.f7150a.J(u61.schedule_unfinished);
            f92.c(strJ2, "getString(R.string.schedule_unfinished)");
            p80.a.b(aVar, contextP, strJ, strJ2, null, 8, null);
            return;
        }
        if (zIsChecked) {
            zg0 zg0Var = new zg0();
            Context contextP2 = this.f7150a.p();
            f92.b(contextP2);
            f92.c(contextP2, "context!!");
            if (!zg0Var.a(contextP2) && !hz0.f1282a.B()) {
                r12.setChecked(false);
                this.f7150a.X1();
                return;
            }
        }
        hz0.f1282a.K0(zIsChecked);
        z90.b(z90.f8048a, aa0.SCENE_CONFIG, null, 2, null);
    }
}
