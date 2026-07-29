package o8;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;

/* JADX INFO: loaded from: classes7.dex */
public class a extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Drawable f42808a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f42809b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f42810c;

    public a(Context context) {
        super(context);
        this.f42808a = null;
    }

    public float getX0() {
        return this.f42809b;
    }

    public float getY0() {
        return this.f42810c;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        super.setBackground(drawable);
        this.f42808a = getBackground().mutate();
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        super.setTag(obj);
        if (this.f42808a != null) {
            if (((Integer) getTag()).intValue() == 0) {
                this.f42808a.setAlpha(150);
            } else if (((Integer) getTag()).intValue() == 200) {
                this.f42808a.setAlpha(150);
            } else {
                this.f42808a.clearColorFilter();
                this.f42808a.setAlpha(255);
            }
        }
    }

    public void setX0(float f10) {
        this.f42809b = f10;
    }

    public void setY0(float f10) {
        this.f42810c = f10;
    }
}
