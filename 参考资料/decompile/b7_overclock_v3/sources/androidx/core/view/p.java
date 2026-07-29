package androidx.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes2.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f5082a = "LayoutInflaterCompatHC";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Field f5083b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f5084c;

    public static class a implements LayoutInflater.Factory2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final q f5085a;

        public a(q qVar) {
            this.f5085a = qVar;
        }

        @Override // android.view.LayoutInflater.Factory
        public View onCreateView(String str, Context context, AttributeSet attributeSet) {
            return this.f5085a.onCreateView(null, str, context, attributeSet);
        }

        @g.n0
        public String toString() {
            return getClass().getName() + zc.a.f58316d + this.f5085a + zc.a.f58317e;
        }

        @Override // android.view.LayoutInflater.Factory2
        public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
            return this.f5085a.onCreateView(view, str, context, attributeSet);
        }
    }

    public static void a(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
        if (!f5084c) {
            try {
                Field declaredField = LayoutInflater.class.getDeclaredField("mFactory2");
                f5083b = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("forceSetFactory2 Could not find field 'mFactory2' on class ");
                sb2.append(LayoutInflater.class.getName());
                sb2.append("; inflation may have unexpected results.");
            }
            f5084c = true;
        }
        Field field = f5083b;
        if (field != null) {
            try {
                field.set(layoutInflater, factory2);
            } catch (IllegalAccessException unused2) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("forceSetFactory2 could not set the Factory2 on LayoutInflater ");
                sb3.append(layoutInflater);
                sb3.append("; inflation may have unexpected results.");
            }
        }
    }

    @Deprecated
    public static q b(LayoutInflater layoutInflater) {
        LayoutInflater.Factory factory = layoutInflater.getFactory();
        if (factory instanceof a) {
            return ((a) factory).f5085a;
        }
        return null;
    }

    @Deprecated
    public static void c(@g.n0 LayoutInflater layoutInflater, @g.n0 q qVar) {
        layoutInflater.setFactory2(new a(qVar));
    }

    public static void d(@g.n0 LayoutInflater layoutInflater, @g.n0 LayoutInflater.Factory2 factory2) {
        layoutInflater.setFactory2(factory2);
    }
}
