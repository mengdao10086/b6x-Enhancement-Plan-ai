package com.omarea.ui;

import a.f92;
import a.g82;
import a.t61;
import a.u31;
import a.v61;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class SeekBar extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g82<? super Integer, String> f8402a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public SeekBar.OnSeekBarChangeListener f4889a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public android.widget.SeekBar f4890a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TextView f4891a;

    public static final class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            SeekBar.this.f();
        }
    }

    public static final class b implements SeekBar.OnSeekBarChangeListener {
        public b() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(android.widget.SeekBar seekBar, int i, boolean z) {
            if (seekBar != null) {
                seekBar.performHapticFeedback(4);
            }
            SeekBar.this.f();
            SeekBar.OnSeekBarChangeListener onSeekBarChangeListener = SeekBar.this.f4889a;
            if (onSeekBarChangeListener != null) {
                onSeekBarChangeListener.onProgressChanged(seekBar, i, z);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(android.widget.SeekBar seekBar) {
            SeekBar.OnSeekBarChangeListener onSeekBarChangeListener = SeekBar.this.f4889a;
            if (onSeekBarChangeListener != null) {
                onSeekBarChangeListener.onStartTrackingTouch(seekBar);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(android.widget.SeekBar seekBar) {
            SeekBar.OnSeekBarChangeListener onSeekBarChangeListener = SeekBar.this.f4889a;
            if (onSeekBarChangeListener != null) {
                onSeekBarChangeListener.onStopTrackingTouch(seekBar);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        f92.d(context, "context");
        this.f8402a = new u31(this);
        e(context, attributeSet);
    }

    public final String d(int i) {
        return String.valueOf(i);
    }

    public final void e(Context context, AttributeSet attributeSet) {
        View viewInflate = LayoutInflater.from(context).inflate(2131558614, (ViewGroup) this, true);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, v61.ProgressBar);
        f92.c(typedArrayObtainStyledAttributes, "context.obtainStyledAttr… R.styleable.ProgressBar)");
        setAlpha(1.0f);
        View viewFindViewById = viewInflate.findViewById(t61.seekbar);
        f92.c(viewFindViewById, "view.findViewById(R.id.seekbar)");
        this.f4890a = (android.widget.SeekBar) viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(t61.value);
        f92.c(viewFindViewById2, "view.findViewById(R.id.value)");
        this.f4891a = (TextView) viewFindViewById2;
        int integer = typedArrayObtainStyledAttributes.getInteger(0, 100);
        int integer2 = typedArrayObtainStyledAttributes.getInteger(1, 0);
        int integer3 = typedArrayObtainStyledAttributes.getInteger(2, 0);
        if (Build.VERSION.SDK_INT >= 26) {
            android.widget.SeekBar seekBar = this.f4890a;
            if (seekBar == null) {
                f92.m("seekBar");
                throw null;
            }
            seekBar.setMin(integer2);
        }
        android.widget.SeekBar seekBar2 = this.f4890a;
        if (seekBar2 == null) {
            f92.m("seekBar");
            throw null;
        }
        seekBar2.setMax(integer);
        android.widget.SeekBar seekBar3 = this.f4890a;
        if (seekBar3 == null) {
            f92.m("seekBar");
            throw null;
        }
        seekBar3.setProgress(integer3);
        android.widget.SeekBar seekBar4 = this.f4890a;
        if (seekBar4 == null) {
            f92.m("seekBar");
            throw null;
        }
        seekBar4.setOnSeekBarChangeListener(new b());
        f();
    }

    public final void f() {
        TextView textView = this.f4891a;
        if (textView != null) {
            textView.setText(this.f8402a.f(Integer.valueOf(getProgress())));
        } else {
            f92.m("textView");
            throw null;
        }
    }

    public final int getMax() {
        android.widget.SeekBar seekBar = this.f4890a;
        if (seekBar != null) {
            return seekBar.getMax();
        }
        f92.m("seekBar");
        throw null;
    }

    public final int getMin() {
        if (Build.VERSION.SDK_INT < 26) {
            return 0;
        }
        android.widget.SeekBar seekBar = this.f4890a;
        if (seekBar != null) {
            return seekBar.getMin();
        }
        f92.m("seekBar");
        throw null;
    }

    public final int getProgress() {
        android.widget.SeekBar seekBar = this.f4890a;
        if (seekBar != null) {
            return seekBar.getProgress();
        }
        f92.m("seekBar");
        throw null;
    }

    public final void setFormatter(g82<? super Integer, String> g82Var) {
        f92.d(g82Var, "formatter");
        this.f8402a = g82Var;
    }

    public final void setMax(int i) {
        android.widget.SeekBar seekBar = this.f4890a;
        if (seekBar != null) {
            seekBar.setMax(i);
        } else {
            f92.m("seekBar");
            throw null;
        }
    }

    public final void setMin(int i) {
        if (Build.VERSION.SDK_INT >= 26) {
            android.widget.SeekBar seekBar = this.f4890a;
            if (seekBar != null) {
                seekBar.setMin(i);
            } else {
                f92.m("seekBar");
                throw null;
            }
        }
    }

    public final void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        f92.d(onSeekBarChangeListener, "listener");
        this.f4889a = onSeekBarChangeListener;
    }

    public final void setProgress(int i) {
        android.widget.SeekBar seekBar = this.f4890a;
        if (seekBar == null) {
            f92.m("seekBar");
            throw null;
        }
        seekBar.setProgress(i);
        post(new a());
    }
}
