package a;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.SeekBar;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class f6 extends SeekBar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g6 f6077a;

    public f6(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, t.seekBarStyle);
    }

    public f6(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        k8.a(this, getContext());
        g6 g6Var = new g6(this);
        this.f6077a = g6Var;
        g6Var.c(attributeSet, i);
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        this.f6077a.h();
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        this.f6077a.i();
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f6077a.g(canvas);
    }
}
