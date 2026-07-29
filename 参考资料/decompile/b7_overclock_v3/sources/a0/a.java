package a0;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f6a = "CustomSupport";

    /* JADX INFO: renamed from: a0.a$a, reason: collision with other inner class name */
    public static /* synthetic */ class C0000a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f7a;

        static {
            int[] iArr = new int[ConstraintAttribute.AttributeType.values().length];
            f7a = iArr;
            try {
                iArr[ConstraintAttribute.AttributeType.INT_TYPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7a[ConstraintAttribute.AttributeType.FLOAT_TYPE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7a[ConstraintAttribute.AttributeType.COLOR_DRAWABLE_TYPE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7a[ConstraintAttribute.AttributeType.COLOR_TYPE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f7a[ConstraintAttribute.AttributeType.STRING_TYPE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f7a[ConstraintAttribute.AttributeType.BOOLEAN_TYPE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f7a[ConstraintAttribute.AttributeType.DIMENSION_TYPE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static int a(int c10) {
        int i10 = (c10 & (~(c10 >> 31))) - 255;
        return (i10 & (i10 >> 31)) + 255;
    }

    public static void b(ConstraintAttribute att, View view, float[] value) {
        Class<?> cls = view.getClass();
        String str = "set" + att.h();
        try {
            boolean z10 = true;
            switch (C0000a.f7a[att.j().ordinal()]) {
                case 1:
                    cls.getMethod(str, Integer.TYPE).invoke(view, Integer.valueOf((int) value[0]));
                    return;
                case 2:
                    cls.getMethod(str, Float.TYPE).invoke(view, Float.valueOf(value[0]));
                    return;
                case 3:
                    Method method = cls.getMethod(str, Drawable.class);
                    int iA = (a((int) (((float) Math.pow(value[0], 0.45454545454545453d)) * 255.0f)) << 16) | (a((int) (value[3] * 255.0f)) << 24) | (a((int) (((float) Math.pow(value[1], 0.45454545454545453d)) * 255.0f)) << 8) | a((int) (((float) Math.pow(value[2], 0.45454545454545453d)) * 255.0f));
                    ColorDrawable colorDrawable = new ColorDrawable();
                    colorDrawable.setColor(iA);
                    method.invoke(view, colorDrawable);
                    return;
                case 4:
                    cls.getMethod(str, Integer.TYPE).invoke(view, Integer.valueOf((a((int) (((float) Math.pow(value[0], 0.45454545454545453d)) * 255.0f)) << 16) | (a((int) (value[3] * 255.0f)) << 24) | (a((int) (((float) Math.pow(value[1], 0.45454545454545453d)) * 255.0f)) << 8) | a((int) (((float) Math.pow(value[2], 0.45454545454545453d)) * 255.0f))));
                    return;
                case 5:
                    throw new RuntimeException("unable to interpolate strings " + att.h());
                case 6:
                    Method method2 = cls.getMethod(str, Boolean.TYPE);
                    Object[] objArr = new Object[1];
                    if (value[0] <= 0.5f) {
                        z10 = false;
                    }
                    objArr[0] = Boolean.valueOf(z10);
                    method2.invoke(view, objArr);
                    return;
                case 7:
                    cls.getMethod(str, Float.TYPE).invoke(view, Float.valueOf(value[0]));
                    return;
                default:
                    return;
            }
        } catch (IllegalAccessException e10) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("cannot access method ");
            sb2.append(str);
            sb2.append(" on View \"");
            sb2.append(androidx.constraintlayout.motion.widget.c.k(view));
            sb2.append("\"");
            e10.printStackTrace();
        } catch (NoSuchMethodException e11) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("no method ");
            sb3.append(str);
            sb3.append(" on View \"");
            sb3.append(androidx.constraintlayout.motion.widget.c.k(view));
            sb3.append("\"");
            e11.printStackTrace();
        } catch (InvocationTargetException e12) {
            e12.printStackTrace();
        }
    }
}
