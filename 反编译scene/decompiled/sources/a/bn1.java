package a;

import android.content.Context;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class bn1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CompoundButton f5718a;

    public bn1(CompoundButton compoundButton) {
        this.f5718a = compoundButton;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (!this.f5718a.isChecked()) {
            Context context = this.f5718a.getContext();
            f92.c(context, "context");
            new u12(context).m(true);
            return;
        }
        Context context2 = this.f5718a.getContext();
        f92.c(context2, "context");
        if (!new u12(context2).l()) {
            Toast.makeText(this.f5718a.getContext(), this.f5718a.getContext().getString(u61.process_unsupported), 0).show();
            this.f5718a.setChecked(false);
        } else {
            Context context3 = this.f5718a.getContext();
            f92.c(context3, "context");
            new u12(context3).q();
        }
    }
}
