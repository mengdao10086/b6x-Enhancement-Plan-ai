package a;

import android.widget.TextView;
import com.omarea.sysmbol.PerfOptionsRender;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class nz0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PerfOptionsRender.e f6961a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f2179a;

    public nz0(PerfOptionsRender.e eVar, String str) {
        this.f6961a = eVar;
        this.f2179a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TextView textView = this.f6961a.f4816a;
        f92.c(textView, "itemApps");
        textView.setText(this.f2179a);
    }
}
