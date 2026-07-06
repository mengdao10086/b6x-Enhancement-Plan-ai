package a;

import android.view.View;
import android.widget.CompoundButton;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class tu1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kv1 f7535a;

    public tu1(kv1 kv1Var) {
        this.f7535a = kv1Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.CompoundButton");
        }
        boolean zIsChecked = ((CompoundButton) view).isChecked();
        hz0.f1282a.J0(zIsChecked);
        e50.Q0(e50.f677a, null, 1, null);
        if (zIsChecked) {
            this.f7535a.f1689a.u(wu0.f3480a.n(), wu0.f3480a.q().b(), "manual");
        }
    }
}
