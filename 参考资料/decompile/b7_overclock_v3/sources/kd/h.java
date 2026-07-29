package kd;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.Property;
import androidx.collection.l;
import g.e1;
import g.n0;
import g.p0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f37179c = "MotionSpec";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l<String, i> f37180a = new l<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l<String, PropertyValuesHolder[]> f37181b = new l<>();

    public static void a(@n0 h hVar, Animator animator) {
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            hVar.l(objectAnimator.getPropertyName(), objectAnimator.getValues());
            hVar.m(objectAnimator.getPropertyName(), i.b(objectAnimator));
        } else {
            throw new IllegalArgumentException("Animator must be an ObjectAnimator: " + animator);
        }
    }

    @p0
    public static h c(@n0 Context context, @n0 TypedArray typedArray, @e1 int i10) {
        int resourceId;
        if (!typedArray.hasValue(i10) || (resourceId = typedArray.getResourceId(i10, 0)) == 0) {
            return null;
        }
        return d(context, resourceId);
    }

    @p0
    public static h d(@n0 Context context, @g.b int i10) {
        try {
            Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(context, i10);
            if (animatorLoadAnimator instanceof AnimatorSet) {
                return e(((AnimatorSet) animatorLoadAnimator).getChildAnimations());
            }
            if (animatorLoadAnimator == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(animatorLoadAnimator);
            return e(arrayList);
        } catch (Exception unused) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Can't load animation resource ID #0x");
            sb2.append(Integer.toHexString(i10));
            return null;
        }
    }

    @n0
    public static h e(@n0 List<Animator> list) {
        h hVar = new h();
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            a(hVar, list.get(i10));
        }
        return hVar;
    }

    @n0
    public final PropertyValuesHolder[] b(@n0 PropertyValuesHolder[] propertyValuesHolderArr) {
        PropertyValuesHolder[] propertyValuesHolderArr2 = new PropertyValuesHolder[propertyValuesHolderArr.length];
        for (int i10 = 0; i10 < propertyValuesHolderArr.length; i10++) {
            propertyValuesHolderArr2[i10] = propertyValuesHolderArr[i10].clone();
        }
        return propertyValuesHolderArr2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof h) {
            return this.f37180a.equals(((h) obj).f37180a);
        }
        return false;
    }

    @n0
    public <T> ObjectAnimator f(@n0 String str, @n0 T t10, @n0 Property<T, ?> property) {
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(t10, g(str));
        objectAnimatorOfPropertyValuesHolder.setProperty(property);
        h(str).a(objectAnimatorOfPropertyValuesHolder);
        return objectAnimatorOfPropertyValuesHolder;
    }

    @n0
    public PropertyValuesHolder[] g(String str) {
        if (j(str)) {
            return b(this.f37181b.get(str));
        }
        throw new IllegalArgumentException();
    }

    public i h(String str) {
        if (k(str)) {
            return this.f37180a.get(str);
        }
        throw new IllegalArgumentException();
    }

    public int hashCode() {
        return this.f37180a.hashCode();
    }

    public long i() {
        int size = this.f37180a.size();
        long jMax = 0;
        for (int i10 = 0; i10 < size; i10++) {
            i iVarO = this.f37180a.o(i10);
            jMax = Math.max(jMax, iVarO.c() + iVarO.d());
        }
        return jMax;
    }

    public boolean j(String str) {
        return this.f37181b.get(str) != null;
    }

    public boolean k(String str) {
        return this.f37180a.get(str) != null;
    }

    public void l(String str, PropertyValuesHolder[] propertyValuesHolderArr) {
        this.f37181b.put(str, propertyValuesHolderArr);
    }

    public void m(String str, @p0 i iVar) {
        this.f37180a.put(str, iVar);
    }

    @n0
    public String toString() {
        return '\n' + getClass().getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " timings: " + this.f37180a + "}\n";
    }
}
