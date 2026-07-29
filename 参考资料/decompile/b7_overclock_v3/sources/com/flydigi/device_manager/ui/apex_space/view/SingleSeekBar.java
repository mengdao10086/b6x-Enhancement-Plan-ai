package com.flydigi.device_manager.ui.apex_space.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import c7.v2;
import com.flydigi.device_manager.R;
import hk.i;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes7.dex */
public final class SingleSeekBar extends ConstraintLayout {

    @k
    public final v2 C1;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @i
    public SingleSeekBar(@k Context context) {
        this(context, null, 0, 6, null);
        f0.p(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @i
    public SingleSeekBar(@k Context context, @l AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        f0.p(context, "context");
    }

    public /* synthetic */ SingleSeekBar(Context context, AttributeSet attributeSet, int i10, int i11, u uVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    public final void setOnSeekBarChangeListener(@k SeekBar.OnSeekBarChangeListener listener) {
        f0.p(listener, "listener");
        this.C1.f10530b.setOnSeekBarChangeListener(listener);
    }

    public final void setProgress(int i10) {
        this.C1.f10530b.setProgress(i10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @i
    public SingleSeekBar(@k Context context, @l AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        f0.p(context, "context");
        v2 v2VarD = v2.d(LayoutInflater.from(context), null, false);
        f0.o(v2VarD, "inflate(LayoutInflater.from(context), null, false)");
        this.C1 = v2VarD;
        addView(v2VarD.getRoot(), new ConstraintLayout.b(-1, -1));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SingleSeekBar);
        f0.o(typedArrayObtainStyledAttributes, "context.obtainStyledAttr….styleable.SingleSeekBar)");
        v2VarD.f10532d.setText(String.valueOf(typedArrayObtainStyledAttributes.getInt(R.styleable.SingleSeekBar_ssb_min_value, 0)));
        v2VarD.f10531c.setText(String.valueOf(typedArrayObtainStyledAttributes.getInt(R.styleable.SingleSeekBar_ssb_max_value, 100)));
        TextView textView = v2VarD.f10532d;
        int i11 = R.styleable.SingleSeekBar_ssb_textColor;
        textView.setTextColor(typedArrayObtainStyledAttributes.getColor(i11, -1));
        v2VarD.f10531c.setTextColor(typedArrayObtainStyledAttributes.getColor(i11, -1));
        TextView textView2 = v2VarD.f10532d;
        int i12 = R.styleable.SingleSeekBar_ssb_textSize;
        int i13 = R.dimen.sp_14;
        textView2.setTextSize(0, typedArrayObtainStyledAttributes.getDimensionPixelSize(i12, i13));
        v2VarD.f10531c.setTextSize(0, typedArrayObtainStyledAttributes.getDimensionPixelSize(i12, i13));
        typedArrayObtainStyledAttributes.recycle();
    }
}
