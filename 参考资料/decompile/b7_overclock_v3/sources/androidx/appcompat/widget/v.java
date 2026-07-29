package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.appcompat.R;

/* JADX INFO: loaded from: classes2.dex */
public class v extends SeekBar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w f2715a;

    public v(@g.n0 Context context) {
        this(context, null);
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        this.f2715a.h();
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        this.f2715a.l();
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f2715a.g(canvas);
    }

    public v(@g.n0 Context context, @g.p0 AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.seekBarStyle);
    }

    public v(@g.n0 Context context, @g.p0 AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        t0.a(this, getContext());
        w wVar = new w(this);
        this.f2715a = wVar;
        wVar.c(attributeSet, i10);
    }
}
