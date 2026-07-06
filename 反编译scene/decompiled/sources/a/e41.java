package a;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class e41 extends ViewOutlineProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f5965a;

    public e41(float f) {
        this.f5965a = f;
    }

    @Override // android.view.ViewOutlineProvider
    public void getOutline(View view, Outline outline) {
        f92.d(view, "view");
        f92.d(outline, "outline");
        outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.f5965a);
    }
}
