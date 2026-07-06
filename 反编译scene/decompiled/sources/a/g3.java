package a;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@SuppressLint({"RestrictedAPI"})
public abstract class g3 extends d3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f3 f6163a;
    public boolean d;

    public g3(f3 f3Var) {
        if (f3Var != null) {
            h(f3Var);
        }
    }

    @Override // a.d3, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
        onStateChange(getState());
    }

    @Override // a.d3
    public void h(c3 c3Var) {
        super.h(c3Var);
        if (c3Var instanceof f3) {
            this.f6163a = (f3) c3Var;
        }
    }

    public int[] j(AttributeSet attributeSet) {
        int attributeCount = attributeSet.getAttributeCount();
        int[] iArr = new int[attributeCount];
        int i = 0;
        for (int i2 = 0; i2 < attributeCount; i2++) {
            int attributeNameResource = attributeSet.getAttributeNameResource(i2);
            if (attributeNameResource != 0 && attributeNameResource != 16842960 && attributeNameResource != 16843161) {
                int i3 = i + 1;
                if (!attributeSet.getAttributeBooleanValue(i2, false)) {
                    attributeNameResource = -attributeNameResource;
                }
                iArr[i] = attributeNameResource;
                i = i3;
            }
        }
        return StateSet.trimStateSet(iArr, i);
    }

    @Override // a.d3, android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.d) {
            super.mutate();
            if (this == this) {
                this.f6163a.r();
                this.d = true;
            }
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public abstract boolean onStateChange(int[] iArr);
}
