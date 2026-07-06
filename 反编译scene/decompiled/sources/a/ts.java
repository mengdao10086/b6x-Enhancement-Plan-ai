package a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class ts implements vs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ss f7528a;

    public ts(Context context, ViewGroup viewGroup, View view) {
        this.f7528a = new ss(context, viewGroup, view, this);
    }

    public static ts e(View view) {
        ViewGroup viewGroupF = f(view);
        if (viewGroupF == null) {
            return null;
        }
        int childCount = viewGroupF.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroupF.getChildAt(i);
            if (childAt instanceof ss) {
                return ((ss) childAt).f7427a;
            }
        }
        return new ms(viewGroupF.getContext(), viewGroupF, view);
    }

    public static ViewGroup f(View view) {
        while (view != null) {
            if (view.getId() == 16908290 && (view instanceof ViewGroup)) {
                return (ViewGroup) view;
            }
            if (view.getParent() instanceof ViewGroup) {
                view = (ViewGroup) view.getParent();
            }
        }
        return null;
    }

    @Override // a.vs
    public void a(Drawable drawable) {
        this.f7528a.a(drawable);
    }

    @Override // a.vs
    public void b(Drawable drawable) {
        this.f7528a.f(drawable);
    }
}
