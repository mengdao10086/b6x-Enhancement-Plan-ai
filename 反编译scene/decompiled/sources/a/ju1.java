package a;

import android.view.View;
import android.widget.CompoundButton;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ju1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ju1 f6547a = new ju1();

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.CompoundButton");
        }
        if (((CompoundButton) view).isChecked()) {
            new hn0().b();
        } else {
            new hn0().e();
        }
    }
}
