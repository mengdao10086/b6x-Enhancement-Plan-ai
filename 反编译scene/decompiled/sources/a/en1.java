package a;

import android.content.Context;
import android.view.View;
import android.widget.CompoundButton;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class en1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CompoundButton f6024a;

    public en1(CompoundButton compoundButton) {
        this.f6024a = compoundButton;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.f6024a.isChecked()) {
            Context context = this.f6024a.getContext();
            f92.c(context, "context");
            new py1(context).C();
        } else {
            Context context2 = this.f6024a.getContext();
            f92.c(context2, "context");
            new py1(context2).y(true);
        }
    }
}
