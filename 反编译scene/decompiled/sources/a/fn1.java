package a;

import android.content.Context;
import android.view.View;
import android.widget.CompoundButton;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class fn1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CompoundButton f6122a;

    public fn1(CompoundButton compoundButton) {
        this.f6122a = compoundButton;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.f6122a.isChecked()) {
            Context context = this.f6122a.getContext();
            f92.c(context, "context");
            new d22(context).h();
        } else {
            Context context2 = this.f6122a.getContext();
            f92.c(context2, "context");
            new d22(context2).f();
        }
    }
}
