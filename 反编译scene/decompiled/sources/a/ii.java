package a;

import android.view.Window;
import android.view.WindowInsetsController;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class ii extends ji {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WindowInsetsController f6415a;

    public ii(Window window, ki kiVar) {
        this(window.getInsetsController(), kiVar);
    }

    public ii(WindowInsetsController windowInsetsController, ki kiVar) {
        new ia();
        this.f6415a = windowInsetsController;
    }

    @Override // a.ji
    public void a(int i) {
        this.f6415a.hide(i);
    }

    @Override // a.ji
    public void b(int i) {
        this.f6415a.show(i);
    }
}
