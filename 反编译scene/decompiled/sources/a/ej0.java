package a;

import android.widget.CompoundButton;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ej0 implements CompoundButton.OnCheckedChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ fj0 f6011a;

    public ej0(fj0 fj0Var) {
        this.f6011a = fj0Var;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            fj0 fj0Var = this.f6011a;
            f92.c(compoundButton, "compoundButton");
            fj0Var.e(compoundButton);
        }
    }
}
