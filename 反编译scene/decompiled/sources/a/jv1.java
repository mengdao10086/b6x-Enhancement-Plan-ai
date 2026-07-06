package a;

import android.widget.CompoundButton;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class jv1 implements CompoundButton.OnCheckedChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kv1 f6549a;

    public jv1(kv1 kv1Var) {
        this.f6549a = kv1Var;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        LinearLayout linearLayout = (LinearLayout) this.f6549a.w1(t61.first_mode_view);
        f92.c(linearLayout, "first_mode_view");
        linearLayout.setVisibility(z ? 8 : 0);
    }
}
