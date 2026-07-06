package a;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class hr extends it {
    public hr(int i) {
        i0(i);
    }

    public static float k0(ks ksVar, float f) {
        Float f2;
        return (ksVar == null || (f2 = (Float) ksVar.f1686a.get("android:fade:transitionAlpha")) == null) ? f : f2.floatValue();
    }

    @Override // a.it
    public Animator e0(ViewGroup viewGroup, View view, ks ksVar, ks ksVar2) {
        float fK0 = k0(ksVar, 0.0f);
        return j0(view, fK0 != 1.0f ? fK0 : 0.0f, 1.0f);
    }

    @Override // a.it
    public Animator g0(ViewGroup viewGroup, View view, ks ksVar, ks ksVar2) {
        ys.e(view);
        return j0(view, k0(ksVar, 1.0f), 0.0f);
    }

    @Override // a.it, a.as
    public void j(ks ksVar) {
        super.j(ksVar);
        ksVar.f1686a.put("android:fade:transitionAlpha", Float.valueOf(ys.c(ksVar.f6635a)));
    }

    public final Animator j0(View view, float f, float f2) {
        if (f == f2) {
            return null;
        }
        ys.g(view, f);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, ys.f3769a, f2);
        objectAnimatorOfFloat.addListener(new gr(view));
        a(new fr(this, view));
        return objectAnimatorOfFloat;
    }
}
