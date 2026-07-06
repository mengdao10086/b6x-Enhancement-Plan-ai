package a;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class f7 extends e3 {
    public boolean b;

    public f7(Drawable drawable) {
        super(drawable);
        this.b = true;
    }

    public void c(boolean z) {
        this.b = z;
    }

    @Override // a.e3, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.b) {
            super.draw(canvas);
        }
    }

    @Override // a.e3, android.graphics.drawable.Drawable
    public void setHotspot(float f, float f2) {
        if (this.b) {
            super.setHotspot(f, f2);
        }
    }

    @Override // a.e3, android.graphics.drawable.Drawable
    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        if (this.b) {
            super.setHotspotBounds(i, i2, i3, i4);
        }
    }

    @Override // a.e3, android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        if (this.b) {
            return super.setState(iArr);
        }
        return false;
    }

    @Override // a.e3, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        if (this.b) {
            return super.setVisible(z, z2);
        }
        return false;
    }
}
