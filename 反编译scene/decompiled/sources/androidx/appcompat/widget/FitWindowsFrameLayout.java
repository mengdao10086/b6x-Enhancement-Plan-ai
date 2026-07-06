package androidx.appcompat.widget;

import a.i7;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class FitWindowsFrameLayout extends FrameLayout implements i7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public i7.a f8157a;

    public FitWindowsFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.View
    public boolean fitSystemWindows(Rect rect) {
        i7.a aVar = this.f8157a;
        if (aVar != null) {
            aVar.a(rect);
        }
        return super.fitSystemWindows(rect);
    }

    @Override // a.i7
    public void setOnFitSystemWindowsListener(i7.a aVar) {
        this.f8157a = aVar;
    }
}
