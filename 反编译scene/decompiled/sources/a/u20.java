package a;

import android.widget.Toast;
import com.omarea.Scene;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class u20 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7558a;
    public final /* synthetic */ int b;

    public u20(int i, int i2) {
        this.f7558a = i;
        this.b = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Toast.makeText(Scene.f4798a.c(), this.f7558a, this.b).show();
    }
}
