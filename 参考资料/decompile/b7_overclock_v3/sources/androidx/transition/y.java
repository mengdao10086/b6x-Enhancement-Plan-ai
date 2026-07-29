package androidx.transition;

import android.animation.LayoutTransition;
import android.annotation.SuppressLint;
import android.view.ViewGroup;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import g.n0;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f8023a = "ViewGroupUtilsApi14";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f8024b = 4;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static LayoutTransition f8025c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Field f8026d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f8027e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Method f8028f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f8029g;

    public class a extends LayoutTransition {
        @Override // android.animation.LayoutTransition
        public boolean isChangingLayout() {
            return true;
        }
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    public static void a(LayoutTransition layoutTransition) {
        if (!f8029g) {
            try {
                Method declaredMethod = LayoutTransition.class.getDeclaredMethod(CommonNetImpl.CANCEL, new Class[0]);
                f8028f = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            f8029g = true;
        }
        Method method = f8028f;
        if (method != null) {
            try {
                method.invoke(layoutTransition, new Object[0]);
            } catch (IllegalAccessException | InvocationTargetException unused2) {
            }
        }
    }

    public static void b(@n0 ViewGroup viewGroup, boolean z10) {
        boolean z11 = false;
        if (f8025c == null) {
            a aVar = new a();
            f8025c = aVar;
            aVar.setAnimator(2, null);
            f8025c.setAnimator(0, null);
            f8025c.setAnimator(1, null);
            f8025c.setAnimator(3, null);
            f8025c.setAnimator(4, null);
        }
        if (z10) {
            LayoutTransition layoutTransition = viewGroup.getLayoutTransition();
            if (layoutTransition != null) {
                if (layoutTransition.isRunning()) {
                    a(layoutTransition);
                }
                if (layoutTransition != f8025c) {
                    viewGroup.setTag(R.id.transition_layout_save, layoutTransition);
                }
            }
            viewGroup.setLayoutTransition(f8025c);
            return;
        }
        viewGroup.setLayoutTransition(null);
        if (!f8027e) {
            try {
                Field declaredField = ViewGroup.class.getDeclaredField("mLayoutSuppressed");
                f8026d = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f8027e = true;
        }
        Field field = f8026d;
        if (field != null) {
            try {
                boolean z12 = field.getBoolean(viewGroup);
                if (z12) {
                    try {
                        f8026d.setBoolean(viewGroup, false);
                    } catch (IllegalAccessException unused2) {
                    }
                }
                z11 = z12;
            } catch (IllegalAccessException unused3) {
            }
        }
        if (z11) {
            viewGroup.requestLayout();
        }
        int i10 = R.id.transition_layout_save;
        LayoutTransition layoutTransition2 = (LayoutTransition) viewGroup.getTag(i10);
        if (layoutTransition2 != null) {
            viewGroup.setTag(i10, null);
            viewGroup.setLayoutTransition(layoutTransition2);
        }
    }
}
