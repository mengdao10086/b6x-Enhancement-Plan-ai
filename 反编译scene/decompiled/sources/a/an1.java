package a;

import android.content.Context;
import android.view.View;
import android.widget.CompoundButton;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class an1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CompoundButton f5622a;

    public an1(CompoundButton compoundButton) {
        this.f5622a = compoundButton;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.f5622a.isChecked()) {
            Context context = this.f5622a.getContext();
            f92.c(context, "context");
            new ox1(context).u();
        } else {
            Context context2 = this.f5622a.getContext();
            f92.c(context2, "context");
            new ox1(context2).r(true);
        }
    }
}
