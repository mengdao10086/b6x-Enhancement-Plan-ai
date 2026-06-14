package a;

import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class vg implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakHashMap<View, Boolean> f7692a = new WeakHashMap<>();

    public final void a(View view, boolean z) {
        boolean z2 = view.getVisibility() == 0;
        if (z != z2) {
            eh.U(view, z2 ? 16 : 32);
            this.f7692a.put(view, Boolean.valueOf(z2));
        }
    }

    public final void b(View view) {
        view.getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (Build.VERSION.SDK_INT < 28) {
            for (Map.Entry<View, Boolean> entry : this.f7692a.entrySet()) {
                a(entry.getKey(), entry.getValue().booleanValue());
            }
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        b(view);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
    }
}
