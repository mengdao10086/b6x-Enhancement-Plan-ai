package a;

import android.widget.CompoundButton;
import android.widget.LinearLayout;
import com.omarea.Scene;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class su1 implements CompoundButton.OnCheckedChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kv1 f7435a;

    public su1(kv1 kv1Var) {
        this.f7435a = kv1Var;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        Scene.c cVar;
        c92 ru1Var;
        LinearLayout linearLayout = (LinearLayout) this.f7435a.w1(t61.dynamic_control_opts);
        f92.c(linearLayout, "dynamic_control_opts");
        linearLayout.setVisibility(z ? 0 : 8);
        if (z) {
            cVar = Scene.f4798a;
            ru1Var = new ru1(null);
        } else {
            Scene.c cVar2 = Scene.f4798a;
            String strJ = this.f7435a.J(u61.schedule_restore_automatic);
            f92.c(strJ, "getString(R.string.schedule_restore_automatic)");
            cVar2.o(strJ, 1);
            cVar = Scene.f4798a;
            ru1Var = new qu1(this, null);
        }
        cVar.a(ru1Var);
    }
}
