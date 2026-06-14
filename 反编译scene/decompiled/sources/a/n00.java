package a;

import android.os.Handler;
import com.google.android.material.snackbar.BaseTransientBottomBar;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class n00 implements z00 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseTransientBottomBar f6857a;

    public n00(BaseTransientBottomBar baseTransientBottomBar) {
        this.f6857a = baseTransientBottomBar;
    }

    @Override // a.z00
    public void a(int i) {
        Handler handler = BaseTransientBottomBar.f8316a;
        handler.sendMessage(handler.obtainMessage(1, i, 0, this.f6857a));
    }

    @Override // a.z00
    public void c() {
        Handler handler = BaseTransientBottomBar.f8316a;
        handler.sendMessage(handler.obtainMessage(0, this.f6857a));
    }
}
