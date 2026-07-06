package a;

import android.widget.TextView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class pa1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TextView f7100a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ CharSequence f2409a;

    public pa1(TextView textView, CharSequence charSequence) {
        this.f7100a = textView;
        this.f2409a = charSequence;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CharSequence text = this.f7100a.getText();
        if (!(text == null || text.length() == 0)) {
            this.f7100a.append("\n");
        }
        this.f7100a.append(this.f2409a);
        this.f7100a.setVisibility(0);
    }
}
