package a;

import android.widget.AutoCompleteTextView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class c20 implements AutoCompleteTextView.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e20 f5752a;

    public c20(e20 e20Var) {
        this.f5752a = e20Var;
    }

    @Override // android.widget.AutoCompleteTextView.OnDismissListener
    public void onDismiss() {
        this.f5752a.f649a = true;
        this.f5752a.f5959a = System.currentTimeMillis();
        this.f5752a.C(false);
    }
}
