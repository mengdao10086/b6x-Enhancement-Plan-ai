package a;

import android.content.Context;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class cn1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CompoundButton f5812a;

    public cn1(CompoundButton compoundButton) {
        this.f5812a = compoundButton;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (!this.f5812a.isChecked()) {
            Context context = this.f5812a.getContext();
            f92.c(context, "context");
            new iz1(context).i();
            return;
        }
        Context context2 = this.f5812a.getContext();
        f92.c(context2, "context");
        if (!new iz1(context2).h()) {
            Toast.makeText(this.f5812a.getContext(), this.f5812a.getContext().getString(u61.process_unsupported), 0).show();
            this.f5812a.setChecked(false);
        } else {
            Context context3 = this.f5812a.getContext();
            f92.c(context3, "context");
            new iz1(context3).j();
        }
    }
}
