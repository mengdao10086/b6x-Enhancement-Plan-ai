package a;

import android.view.View;
import com.google.android.material.snackbar.BaseTransientBottomBar;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class q00 implements v00 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseTransientBottomBar f7165a;

    public q00(BaseTransientBottomBar baseTransientBottomBar) {
        this.f7165a = baseTransientBottomBar;
    }

    @Override // a.v00
    public void a(View view, int i, int i2, int i3, int i4) {
        this.f7165a.f4663a.setOnLayoutChangeListener(null);
        this.f7165a.O();
    }
}
