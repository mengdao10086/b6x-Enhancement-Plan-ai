package a;

import android.view.KeyEvent;
import android.widget.TextView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ym1 implements TextView.OnEditorActionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zm1 f7995a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ TextView f3749a;

    public ym1(zm1 zm1Var, TextView textView) {
        this.f7995a = zm1Var;
        this.f3749a = textView;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 5 && i != 6) {
            return false;
        }
        zm1 zm1Var = this.f7995a;
        TextView textView2 = this.f3749a;
        f92.c(textView2, "emailInput");
        zm1Var.f(textView2.getText().toString());
        return false;
    }
}
