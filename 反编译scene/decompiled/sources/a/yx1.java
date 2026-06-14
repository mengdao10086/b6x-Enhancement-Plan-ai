package a;

import android.view.View;
import android.widget.TextView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class yx1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n92 f8017a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ py1 f3777a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ v72 f3778a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ TextView f3779a;

    public yx1(TextView textView, v72 v72Var, py1 py1Var, n92 n92Var) {
        this.f3779a = textView;
        this.f3778a = v72Var;
        this.f3777a = py1Var;
        this.f8017a = n92Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f3778a.i();
        ((v72) this.f8017a.f6891a).i();
        this.f3777a.b = Integer.parseInt(this.f3779a.getText().toString()) * 60;
        this.f3779a.setAlpha(1.0f);
    }
}
