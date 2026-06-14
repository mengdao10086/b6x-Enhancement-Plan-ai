package a;

import android.widget.Toast;
import com.omarea.Scene;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class t20 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7456a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f2942a;

    public t20(String str, int i) {
        this.f2942a = str;
        this.f7456a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Toast.makeText(Scene.f4798a.c(), this.f2942a, this.f7456a).show();
    }
}
