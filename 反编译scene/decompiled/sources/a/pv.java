package a;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class pv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ia<String, qv> f7151a = new ia<>();
    public final ia<String, PropertyValuesHolder[]> b = new ia<>();

    public static void a(pv pvVar, Animator animator) {
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            pvVar.g(objectAnimator.getPropertyName(), objectAnimator.getValues());
            pvVar.h(objectAnimator.getPropertyName(), qv.b(objectAnimator));
        } else {
            throw new IllegalArgumentException("Animator must be an ObjectAnimator: " + animator);
        }
    }

    public static pv b(Context context, TypedArray typedArray, int i) {
        int resourceId;
        if (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0) {
            return null;
        }
        return c(context, resourceId);
    }

    public static pv c(Context context, int i) {
        try {
            Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(context, i);
            if (animatorLoadAnimator instanceof AnimatorSet) {
                return d(((AnimatorSet) animatorLoadAnimator).getChildAnimations());
            }
            if (animatorLoadAnimator == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(animatorLoadAnimator);
            return d(arrayList);
        } catch (Exception e) {
            Log.w("MotionSpec", "Can't load animation resource ID #0x" + Integer.toHexString(i), e);
            return null;
        }
    }

    public static pv d(List<Animator> list) {
        pv pvVar = new pv();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            a(pvVar, list.get(i));
        }
        return pvVar;
    }

    public qv e(String str) {
        if (f(str)) {
            return this.f7151a.get(str);
        }
        throw new IllegalArgumentException();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof pv) {
            return this.f7151a.equals(((pv) obj).f7151a);
        }
        return false;
    }

    public boolean f(String str) {
        return this.f7151a.get(str) != null;
    }

    public void g(String str, PropertyValuesHolder[] propertyValuesHolderArr) {
        this.b.put(str, propertyValuesHolderArr);
    }

    public void h(String str, qv qvVar) {
        this.f7151a.put(str, qvVar);
    }

    public int hashCode() {
        return this.f7151a.hashCode();
    }

    public String toString() {
        return '\n' + pv.class.getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " timings: " + this.f7151a + "}\n";
    }
}
