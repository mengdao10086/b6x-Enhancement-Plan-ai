package androidx.appcompat.app;

import android.R;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.View;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.a0;
import androidx.appcompat.widget.s;
import androidx.appcompat.widget.t;
import androidx.appcompat.widget.v;
import androidx.appcompat.widget.v0;
import androidx.core.view.u0;
import g.n0;
import g.p0;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class k {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f1660h = "AppCompatViewInflater";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object[] f1662a = new Object[2];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Class<?>[] f1654b = {Context.class, AttributeSet.class};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f1655c = {R.attr.onClick};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f1656d = {R.attr.accessibilityHeading};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int[] f1657e = {R.attr.accessibilityPaneTitle};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int[] f1658f = {R.attr.screenReaderFocusable};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String[] f1659g = {"android.widget.", "android.view.", "android.webkit."};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final androidx.collection.l<String, Constructor<? extends View>> f1661i = new androidx.collection.l<>();

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f1663a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f1664b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Method f1665c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Context f1666d;

        public a(@n0 View view, @n0 String str) {
            this.f1663a = view;
            this.f1664b = str;
        }

        public final void a(@p0 Context context) {
            String str;
            Method method;
            while (context != null) {
                try {
                    if (!context.isRestricted() && (method = context.getClass().getMethod(this.f1664b, View.class)) != null) {
                        this.f1665c = method;
                        this.f1666d = context;
                        return;
                    }
                } catch (NoSuchMethodException unused) {
                }
                context = context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : null;
            }
            int id2 = this.f1663a.getId();
            if (id2 == -1) {
                str = "";
            } else {
                str = " with id '" + this.f1663a.getContext().getResources().getResourceEntryName(id2) + "'";
            }
            throw new IllegalStateException("Could not find method " + this.f1664b + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.f1663a.getClass() + str);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(@n0 View view) {
            if (this.f1665c == null) {
                a(this.f1663a.getContext());
            }
            try {
                this.f1665c.invoke(this.f1666d, view);
            } catch (IllegalAccessException e10) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", e10);
            } catch (InvocationTargetException e11) {
                throw new IllegalStateException("Could not execute method for android:onClick", e11);
            }
        }
    }

    public static Context u(Context context, AttributeSet attributeSet, boolean z10, boolean z11) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.appcompat.R.styleable.View, 0, 0);
        int resourceId = z10 ? typedArrayObtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.View_android_theme, 0) : 0;
        if (z11 && resourceId == 0) {
            resourceId = typedArrayObtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.View_theme, 0);
        }
        typedArrayObtainStyledAttributes.recycle();
        return resourceId != 0 ? ((context instanceof l.d) && ((l.d) context).c() == resourceId) ? context : new l.d(context, resourceId) : context;
    }

    public final void a(@n0 Context context, @n0 View view, @n0 AttributeSet attributeSet) {
        if (Build.VERSION.SDK_INT > 28) {
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f1656d);
        if (typedArrayObtainStyledAttributes.hasValue(0)) {
            u0.C1(view, typedArrayObtainStyledAttributes.getBoolean(0, false));
        }
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, f1657e);
        if (typedArrayObtainStyledAttributes2.hasValue(0)) {
            u0.E1(view, typedArrayObtainStyledAttributes2.getString(0));
        }
        typedArrayObtainStyledAttributes2.recycle();
        TypedArray typedArrayObtainStyledAttributes3 = context.obtainStyledAttributes(attributeSet, f1658f);
        if (typedArrayObtainStyledAttributes3.hasValue(0)) {
            u0.n2(view, typedArrayObtainStyledAttributes3.getBoolean(0, false));
        }
        typedArrayObtainStyledAttributes3.recycle();
    }

    public final void b(View view, AttributeSet attributeSet) {
        Context context = view.getContext();
        if ((context instanceof ContextWrapper) && u0.K0(view)) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f1655c);
            String string = typedArrayObtainStyledAttributes.getString(0);
            if (string != null) {
                view.setOnClickListener(new a(view, string));
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @n0
    public androidx.appcompat.widget.d c(Context context, AttributeSet attributeSet) {
        return new androidx.appcompat.widget.d(context, attributeSet);
    }

    @n0
    public AppCompatButton d(Context context, AttributeSet attributeSet) {
        return new AppCompatButton(context, attributeSet);
    }

    @n0
    public AppCompatCheckBox e(Context context, AttributeSet attributeSet) {
        return new AppCompatCheckBox(context, attributeSet);
    }

    @n0
    public androidx.appcompat.widget.f f(Context context, AttributeSet attributeSet) {
        return new androidx.appcompat.widget.f(context, attributeSet);
    }

    @n0
    public androidx.appcompat.widget.j g(Context context, AttributeSet attributeSet) {
        return new androidx.appcompat.widget.j(context, attributeSet);
    }

    @n0
    public androidx.appcompat.widget.n h(Context context, AttributeSet attributeSet) {
        return new androidx.appcompat.widget.n(context, attributeSet);
    }

    @n0
    public AppCompatImageView i(Context context, AttributeSet attributeSet) {
        return new AppCompatImageView(context, attributeSet);
    }

    @n0
    public androidx.appcompat.widget.p j(Context context, AttributeSet attributeSet) {
        return new androidx.appcompat.widget.p(context, attributeSet);
    }

    @n0
    public s k(Context context, AttributeSet attributeSet) {
        return new s(context, attributeSet);
    }

    @n0
    public t l(Context context, AttributeSet attributeSet) {
        return new t(context, attributeSet);
    }

    @n0
    public v m(Context context, AttributeSet attributeSet) {
        return new v(context, attributeSet);
    }

    @n0
    public AppCompatSpinner n(Context context, AttributeSet attributeSet) {
        return new AppCompatSpinner(context, attributeSet);
    }

    @n0
    public AppCompatTextView o(Context context, AttributeSet attributeSet) {
        return new AppCompatTextView(context, attributeSet);
    }

    @n0
    public a0 p(Context context, AttributeSet attributeSet) {
        return new a0(context, attributeSet);
    }

    @p0
    public View q(Context context, String str, AttributeSet attributeSet) {
        return null;
    }

    public final View r(View view, String str, @n0 Context context, @n0 AttributeSet attributeSet, boolean z10, boolean z11, boolean z12, boolean z13) {
        Context context2;
        View viewL;
        context2 = (!z10 || view == null) ? context : view.getContext();
        if (z11 || z12) {
            context2 = u(context2, attributeSet, z11, z12);
        }
        if (z13) {
            context2 = v0.b(context2);
        }
        str.hashCode();
        switch (str) {
            case "RatingBar":
                viewL = l(context2, attributeSet);
                v(viewL, str);
                break;
            case "CheckedTextView":
                viewL = f(context2, attributeSet);
                v(viewL, str);
                break;
            case "MultiAutoCompleteTextView":
                viewL = j(context2, attributeSet);
                v(viewL, str);
                break;
            case "TextView":
                viewL = o(context2, attributeSet);
                v(viewL, str);
                break;
            case "ImageButton":
                viewL = h(context2, attributeSet);
                v(viewL, str);
                break;
            case "SeekBar":
                viewL = m(context2, attributeSet);
                v(viewL, str);
                break;
            case "Spinner":
                viewL = n(context2, attributeSet);
                v(viewL, str);
                break;
            case "RadioButton":
                viewL = k(context2, attributeSet);
                v(viewL, str);
                break;
            case "ToggleButton":
                viewL = p(context2, attributeSet);
                v(viewL, str);
                break;
            case "ImageView":
                viewL = i(context2, attributeSet);
                v(viewL, str);
                break;
            case "AutoCompleteTextView":
                viewL = c(context2, attributeSet);
                v(viewL, str);
                break;
            case "CheckBox":
                viewL = e(context2, attributeSet);
                v(viewL, str);
                break;
            case "EditText":
                viewL = g(context2, attributeSet);
                v(viewL, str);
                break;
            case "Button":
                viewL = d(context2, attributeSet);
                v(viewL, str);
                break;
            default:
                viewL = q(context2, str, attributeSet);
                break;
        }
        if (viewL == null && context != context2) {
            viewL = t(context2, str, attributeSet);
        }
        if (viewL != null) {
            b(viewL, attributeSet);
            a(context2, viewL, attributeSet);
        }
        return viewL;
    }

    public final View s(Context context, String str, String str2) throws InflateException, ClassNotFoundException {
        String str3;
        androidx.collection.l<String, Constructor<? extends View>> lVar = f1661i;
        Constructor<? extends View> constructor = lVar.get(str);
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
            constructor = Class.forName(str3, false, context.getClassLoader()).asSubclass(View.class).getConstructor(f1654b);
            lVar.put(str, constructor);
        }
        constructor.setAccessible(true);
        return constructor.newInstance(this.f1662a);
    }

    public final View t(Context context, String str, AttributeSet attributeSet) {
        if (str.equals("view")) {
            str = attributeSet.getAttributeValue(null, "class");
        }
        try {
            Object[] objArr = this.f1662a;
            objArr[0] = context;
            objArr[1] = attributeSet;
            if (-1 != str.indexOf(46)) {
                return s(context, str, null);
            }
            int i10 = 0;
            while (true) {
                String[] strArr = f1659g;
                if (i10 >= strArr.length) {
                    return null;
                }
                View viewS = s(context, str, strArr[i10]);
                if (viewS != null) {
                    return viewS;
                }
                i10++;
            }
        } catch (Exception unused) {
            return null;
        } finally {
            Object[] objArr2 = this.f1662a;
            objArr2[0] = null;
            objArr2[1] = null;
        }
    }

    public final void v(View view, String str) {
        if (view != null) {
            return;
        }
        throw new IllegalStateException(getClass().getName() + " asked to inflate view for <" + str + ">, but returned null");
    }
}
