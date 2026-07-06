package a;

import android.view.View;
import android.widget.TextView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class nn1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l92 f6935a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ln1 f2123a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ TextView f2124a;

    public nn1(l92 l92Var, ln1 ln1Var, TextView textView) {
        this.f6935a = l92Var;
        this.f2123a = ln1Var;
        this.f2124a = textView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.f6935a.f6687a < this.f2123a.c()) {
            this.f6935a.f6687a++;
        }
        this.f2124a.setText(String.valueOf(this.f6935a.f6687a));
    }
}
