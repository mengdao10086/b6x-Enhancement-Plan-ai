package a;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.omarea.ui.NavItem;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class nk0 implements LayoutInflater.Factory2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final mk0 f6926a = new mk0(null);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final sk0 f2102a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f2103a;

    public nk0(Context context, sk0 sk0Var) {
        f92.d(context, "context");
        f92.d(sk0Var, "override");
        this.f2103a = context;
        this.f2102a = sk0Var;
    }

    public static /* synthetic */ int d(nk0 nk0Var, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 255;
        }
        return nk0Var.c(i, i2);
    }

    public final Integer a(AttributeSet attributeSet, String str) {
        int color;
        int attributeCount = attributeSet.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            if (f92.a(str, attributeSet.getAttributeName(i))) {
                String attributeValue = attributeSet.getAttributeValue(i);
                f92.c(attributeValue, "value");
                if (bc2.x(attributeValue, "#", false, 2, null)) {
                    color = Color.parseColor(attributeValue);
                } else if (bc2.x(attributeValue, "?", false, 2, null)) {
                    String strSubstring = attributeValue.substring(1);
                    f92.c(strSubstring, "(this as java.lang.String).substring(startIndex)");
                    int i2 = Integer.parseInt(strSubstring);
                    TypedValue typedValue = new TypedValue();
                    this.f2103a.getTheme().resolveAttribute(i2, typedValue, true);
                    color = typedValue.data;
                } else if (bc2.x(attributeValue, "@", false, 2, null)) {
                    String strSubstring2 = attributeValue.substring(1);
                    f92.c(strSubstring2, "(this as java.lang.String).substring(startIndex)");
                    color = yb.b(this.f2103a, Integer.parseInt(strSubstring2));
                }
                return Integer.valueOf(color);
            }
        }
        return null;
    }

    public final String b(AttributeSet attributeSet, String str) {
        int attributeResourceValue;
        int attributeCount = attributeSet.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            if (f92.a(str, attributeSet.getAttributeName(i)) && (attributeResourceValue = attributeSet.getAttributeResourceValue(i, 0)) != 0) {
                return this.f2103a.getResources().getResourceEntryName(attributeResourceValue);
            }
        }
        return null;
    }

    public final int c(int i, int i2) {
        return ((i >> 24) & 255) == 0 ? Color.argb(i2, (i >> 16) & 255, (i >> 8) & 255, i & 255) : i;
    }

    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        f92.d(str, "name");
        f92.d(context, "context");
        f92.d(attributeSet, "attrs");
        return onCreateView(str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) throws ClassNotFoundException {
        View viewCreateView;
        String str2;
        f92.d(str, "name");
        f92.d(context, "context");
        f92.d(attributeSet, "attrs");
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        if (ec2.C(str, ".", false, 2, null)) {
            viewCreateView = layoutInflaterFrom.createView(str, null, attributeSet);
            str2 = "inflater.createView(name, null, attrs)";
        } else {
            try {
                viewCreateView = layoutInflaterFrom.createView(str, f92.a(str, "WebView") ? "android.webkit." : "android.widget.", attributeSet);
            } catch (ClassNotFoundException unused) {
                viewCreateView = layoutInflaterFrom.createView(str, "android.view.", attributeSet);
            }
            str2 = "try {\n                in…w.\", attrs)\n            }";
        }
        f92.c(viewCreateView, str2);
        if ((viewCreateView instanceof TextView) || (viewCreateView instanceof NavItem)) {
            try {
                e42 e42Var = g42.f6169a;
                String strB = b(attributeSet, "text");
                String strF = strB != null ? this.f2102a.f(strB) : null;
                if (strF != null) {
                    if (viewCreateView instanceof TextView) {
                        ((TextView) viewCreateView).setText(strF);
                    } else if (viewCreateView instanceof NavItem) {
                        ((NavItem) viewCreateView).setText(strF);
                    }
                }
                g42.a(m42.f6769a);
            } catch (Throwable th) {
                e42 e42Var2 = g42.f6169a;
                g42.a(h42.a(th));
            }
            if (viewCreateView instanceof EditText) {
                try {
                    e42 e42Var3 = g42.f6169a;
                    String strB2 = b(attributeSet, "hint");
                    String strF2 = strB2 != null ? this.f2102a.f(strB2) : null;
                    if (strF2 != null) {
                        ((EditText) viewCreateView).setHint(strF2);
                    }
                    g42.a(m42.f6769a);
                } catch (Throwable th2) {
                    e42 e42Var4 = g42.f6169a;
                    g42.a(h42.a(th2));
                }
            }
        } else if (viewCreateView instanceof ImageView) {
            Integer numA = a(attributeSet, "tint");
            if (numA != null) {
                ((ImageView) viewCreateView).setImageTintList(ColorStateList.valueOf(d(this, numA.intValue(), 0, 2, null)));
            }
        } else if (viewCreateView instanceof Spinner) {
            String strB3 = b(attributeSet, "entries");
            String[] strArrG = strB3 != null ? this.f2102a.g(strB3) : null;
            if (strArrG != null) {
                ((Spinner) viewCreateView).setAdapter((SpinnerAdapter) new ArrayAdapter(context, R.layout.simple_spinner_dropdown_item, strArrG));
            }
        }
        return viewCreateView;
    }
}
