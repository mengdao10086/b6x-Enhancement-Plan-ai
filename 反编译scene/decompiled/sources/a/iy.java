package a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@SuppressLint({"AppCompatCustomView"})
public abstract class iy extends ImageButton {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6452a;

    public iy(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6452a = getVisibility();
    }

    public final void b(int i, boolean z) {
        super.setVisibility(i);
        if (z) {
            this.f6452a = i;
        }
    }

    public final int getUserSetVisibility() {
        return this.f6452a;
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int i) {
        b(i, true);
    }
}
