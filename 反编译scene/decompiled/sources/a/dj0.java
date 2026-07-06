package a;

import android.view.View;
import android.widget.CompoundButton;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class dj0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ fj0 f5907a;

    public dj0(fj0 fj0Var) {
        this.f5907a = fj0Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.CompoundButton");
        }
        CompoundButton compoundButton = (CompoundButton) view;
        if (compoundButton.isChecked()) {
            this.f5907a.e(compoundButton);
        } else {
            this.f5907a.d(compoundButton);
        }
        this.f5907a.f6113a.f(this.f5907a);
    }
}
