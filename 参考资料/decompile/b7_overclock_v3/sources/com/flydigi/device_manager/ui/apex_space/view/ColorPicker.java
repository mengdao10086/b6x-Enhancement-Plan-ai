package com.flydigi.device_manager.ui.apex_space.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import androidx.constraintlayout.widget.ConstraintLayout;
import c7.u2;
import com.flydigi.device_manager.R;
import com.flydigi.device_manager.ui.apex_space.view.ColorPicker;
import com.flydigi.device_manager.ui.apex_space.view.ColorSeekBar;
import hk.i;
import java.util.Arrays;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes7.dex */
public final class ColorPicker extends ConstraintLayout {

    @k
    public final u2 C1;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @i
    public ColorPicker(@k Context context) {
        this(context, null, 0, 6, null);
        f0.p(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @i
    public ColorPicker(@k Context context, @l AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        f0.p(context, "context");
    }

    public /* synthetic */ ColorPicker(Context context, AttributeSet attributeSet, int i10, int i11, u uVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    public static final void O(ColorPicker this$0, int i10) {
        f0.p(this$0, "this$0");
        this$0.C1.f10507b.setColor(i10);
    }

    @k
    public final int[] getColor() {
        int color = this.C1.f10507b.getColor();
        int[] iArr = {Color.red(color), Color.green(color), Color.blue(color)};
        int[] iArr2 = new int[3];
        for (int i10 = 0; i10 < 3; i10++) {
            iArr2[i10] = 0;
        }
        return Arrays.equals(iArr2, iArr) ? new int[]{255, 0, 0} : iArr;
    }

    public final void setColor(final int i10) {
        this.C1.f10507b.post(new Runnable() { // from class: f7.a
            @Override // java.lang.Runnable
            public final void run() {
                ColorPicker.O(this.f27995a, i10);
            }
        });
    }

    public final void setOnColorPickerListener$device_manager_officialRelease(@k ColorSeekBar.a listener) {
        f0.p(listener, "listener");
        this.C1.f10507b.setOnColorChangeListener(listener);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @i
    public ColorPicker(@k Context context, @l AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        f0.p(context, "context");
        u2 u2VarD = u2.d(LayoutInflater.from(context), null, false);
        f0.o(u2VarD, "inflate(LayoutInflater.from(context), null, false)");
        this.C1 = u2VarD;
        addView(u2VarD.getRoot(), new ConstraintLayout.b(-1, -1));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ColorPicker);
        f0.o(typedArrayObtainStyledAttributes, "context.obtainStyledAttr… R.styleable.ColorPicker)");
        u2VarD.f10508c.setText(typedArrayObtainStyledAttributes.getString(R.styleable.ColorPicker_csb_tagText));
        u2VarD.f10508c.setTextColor(typedArrayObtainStyledAttributes.getColor(R.styleable.ColorPicker_csb_textColor, -1));
        u2VarD.f10508c.setTextSize(0, typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ColorPicker_csb_textSize, R.dimen.sp_14));
        typedArrayObtainStyledAttributes.recycle();
    }
}
