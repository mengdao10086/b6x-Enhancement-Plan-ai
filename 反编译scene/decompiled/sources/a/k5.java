package a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.AppCompatImageView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class k5 extends AppCompatImageView implements ActionMenuView.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n5 f6574a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k5(n5 n5Var, Context context) {
        super(context, null, t.actionOverflowButtonStyle);
        this.f6574a = n5Var;
        setClickable(true);
        setFocusable(true);
        setVisibility(0);
        setEnabled(true);
        t8.a(this, getContentDescription());
        setOnTouchListener(new j5(this, this, n5Var));
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a
    public boolean b() {
        return false;
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a
    public boolean c() {
        return false;
    }

    @Override // android.view.View
    public boolean performClick() {
        if (super.performClick()) {
            return true;
        }
        playSoundEffect(0);
        this.f6574a.K();
        return true;
    }

    @Override // android.widget.ImageView
    public boolean setFrame(int i, int i2, int i3, int i4) {
        boolean frame = super.setFrame(i, i2, i3, i4);
        Drawable drawable = getDrawable();
        Drawable background = getBackground();
        if (drawable != null && background != null) {
            int width = getWidth();
            int height = getHeight();
            int iMax = Math.max(width, height) / 2;
            int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
            int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
            kd.l(background, paddingLeft - iMax, paddingTop - iMax, paddingLeft + iMax, paddingTop + iMax);
        }
        return frame;
    }
}
