package a;

import android.content.Context;
import android.view.View;
import android.widget.CompoundButton;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class dn1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CompoundButton f5920a;

    public dn1(CompoundButton compoundButton) {
        this.f5920a = compoundButton;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.f5920a.isChecked()) {
            Context context = this.f5920a.getContext();
            f92.c(context, "context");
            new az1(context).z();
        } else {
            Context context2 = this.f5920a.getContext();
            f92.c(context2, "context");
            new az1(context2).v(true);
        }
    }
}
