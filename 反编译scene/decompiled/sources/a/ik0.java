package a;

import android.widget.TextView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ik0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TextView f6422a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f1378a;

    public ik0(TextView textView, String str) {
        this.f6422a = textView;
        this.f1378a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f6422a.append(this.f1378a);
    }
}
