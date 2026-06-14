package a;

import android.R;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import java.lang.reflect.Constructor;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class a2 {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Object[] f16a = new Object[2];

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Class<?>[] f14a = {Context.class, AttributeSet.class};

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final int[] f13a = {R.attr.onClick};

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String[] f15a = {"android.widget.", "android.view.", "android.webkit."};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ia<String, Constructor<? extends View>> f5560a = new ia<>();

    public static Context t(Context context, AttributeSet attributeSet, boolean z, boolean z2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c0.View, 0, 0);
        int resourceId = z ? typedArrayObtainStyledAttributes.getResourceId(c0.View_android_theme, 0) : 0;
        if (z2 && resourceId == 0 && (resourceId = typedArrayObtainStyledAttributes.getResourceId(c0.View_theme, 0)) != 0) {
            Log.i("AppCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead.");
        }
        typedArrayObtainStyledAttributes.recycle();
        return resourceId != 0 ? ((context instanceof m3) && ((m3) context).c() == resourceId) ? context : new m3(context, resourceId) : context;
    }

    public final void a(View view, AttributeSet attributeSet) {
        Context context = view.getContext();
        if (context instanceof ContextWrapper) {
            if (Build.VERSION.SDK_INT < 15 || eh.L(view)) {
                TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f13a);
                String string = typedArrayObtainStyledAttributes.getString(0);
                if (string != null) {
                    view.setOnClickListener(new z1(view, string));
                }
                typedArrayObtainStyledAttributes.recycle();
            }
        }
    }

    public o5 b(Context context, AttributeSet attributeSet) {
        return new o5(context, attributeSet);
    }

    public q5 c(Context context, AttributeSet attributeSet) {
        return new q5(context, attributeSet);
    }

    public r5 d(Context context, AttributeSet attributeSet) {
        return new r5(context, attributeSet);
    }

    public s5 e(Context context, AttributeSet attributeSet) {
        return new s5(context, attributeSet);
    }

    public w5 f(Context context, AttributeSet attributeSet) {
        return new w5(context, attributeSet);
    }

    public y5 g(Context context, AttributeSet attributeSet) {
        return new y5(context, attributeSet);
    }

    public AppCompatImageView h(Context context, AttributeSet attributeSet) {
        return new AppCompatImageView(context, attributeSet);
    }

    public a6 i(Context context, AttributeSet attributeSet) {
        return new a6(context, attributeSet);
    }

    public d6 j(Context context, AttributeSet attributeSet) {
        return new d6(context, attributeSet);
    }

    public e6 k(Context context, AttributeSet attributeSet) {
        return new e6(context, attributeSet);
    }

    public f6 l(Context context, AttributeSet attributeSet) {
        return new f6(context, attributeSet);
    }

    public s6 m(Context context, AttributeSet attributeSet) {
        return new s6(context, attributeSet);
    }

    public w6 n(Context context, AttributeSet attributeSet) {
        return new w6(context, attributeSet);
    }

    public b7 o(Context context, AttributeSet attributeSet) {
        return new b7(context, attributeSet);
    }

    public View p(Context context, String str, AttributeSet attributeSet) {
        return null;
    }

    public final View q(View view, String str, Context context, AttributeSet attributeSet, boolean z, boolean z2, boolean z3, boolean z4) {
        Context context2;
        View viewN;
        context2 = (!z || view == null) ? context : view.getContext();
        if (z2 || z3) {
            context2 = t(context2, attributeSet, z2, z3);
        }
        if (z4) {
            context2 = l8.b(context2);
        }
        switch (str) {
            case "TextView":
                viewN = n(context2, attributeSet);
                u(viewN, str);
                break;
            case "ImageView":
                viewN = h(context2, attributeSet);
                u(viewN, str);
                break;
            case "Button":
                viewN = c(context2, attributeSet);
                u(viewN, str);
                break;
            case "EditText":
                viewN = f(context2, attributeSet);
                u(viewN, str);
                break;
            case "Spinner":
                viewN = m(context2, attributeSet);
                u(viewN, str);
                break;
            case "ImageButton":
                viewN = g(context2, attributeSet);
                u(viewN, str);
                break;
            case "CheckBox":
                viewN = d(context2, attributeSet);
                u(viewN, str);
                break;
            case "RadioButton":
                viewN = j(context2, attributeSet);
                u(viewN, str);
                break;
            case "CheckedTextView":
                viewN = e(context2, attributeSet);
                u(viewN, str);
                break;
            case "AutoCompleteTextView":
                viewN = b(context2, attributeSet);
                u(viewN, str);
                break;
            case "MultiAutoCompleteTextView":
                viewN = i(context2, attributeSet);
                u(viewN, str);
                break;
            case "RatingBar":
                viewN = k(context2, attributeSet);
                u(viewN, str);
                break;
            case "SeekBar":
                viewN = l(context2, attributeSet);
                u(viewN, str);
                break;
            case "ToggleButton":
                viewN = o(context2, attributeSet);
                u(viewN, str);
                break;
            default:
                viewN = p(context2, str, attributeSet);
                break;
        }
        if (viewN == null && context != context2) {
            viewN = s(context2, str, attributeSet);
        }
        if (viewN != null) {
            a(viewN, attributeSet);
        }
        return viewN;
    }

    public final View r(Context context, String str, String str2) {
        String str3;
        Constructor<? extends View> constructor = f5560a.get(str);
        if (constructor == null) {
            if (str2 != null) {
                try {
                    str3 = str2 + str;
                } catch (Exception unused) {
                    return null;
                }
            } else {
                str3 = str;
            }
            constructor = Class.forName(str3, false, context.getClassLoader()).asSubclass(View.class).getConstructor(f14a);
            f5560a.put(str, constructor);
        }
        constructor.setAccessible(true);
        return constructor.newInstance(this.f16a);
    }

    public final View s(Context context, String str, AttributeSet attributeSet) {
        if (str.equals("view")) {
            str = attributeSet.getAttributeValue(null, "class");
        }
        try {
            this.f16a[0] = context;
            this.f16a[1] = attributeSet;
            if (-1 != str.indexOf(46)) {
                return r(context, str, null);
            }
            for (int i = 0; i < f15a.length; i++) {
                View viewR = r(context, str, f15a[i]);
                if (viewR != null) {
                    return viewR;
                }
            }
            return null;
        } catch (Exception unused) {
            return null;
        } finally {
            Object[] objArr = this.f16a;
            objArr[0] = null;
            objArr[1] = null;
        }
    }

    public final void u(View view, String str) {
        if (view != null) {
            return;
        }
        throw new IllegalStateException(getClass().getName() + " asked to inflate view for <" + str + ">, but returned null");
    }
}
