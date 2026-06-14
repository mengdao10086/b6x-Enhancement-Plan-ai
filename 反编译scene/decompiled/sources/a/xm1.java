package a;

import android.view.View;
import android.widget.TextView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class xm1 implements View.OnFocusChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zm1 f7904a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ TextView f3602a;

    public xm1(zm1 zm1Var, TextView textView) {
        this.f7904a = zm1Var;
        this.f3602a = textView;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z) {
        if (z) {
            return;
        }
        zm1 zm1Var = this.f7904a;
        TextView textView = this.f3602a;
        f92.c(textView, "emailInput");
        zm1Var.f(textView.getText().toString());
    }
}
