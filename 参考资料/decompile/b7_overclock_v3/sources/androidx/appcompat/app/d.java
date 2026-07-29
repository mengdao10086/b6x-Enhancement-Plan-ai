package androidx.appcompat.app;

import android.R;
import android.app.ActionBar;
import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f1623a = "ActionBarDrawerToggleHC";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f1624b = {R.attr.homeAsUpIndicator};

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Method f1625a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Method f1626b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ImageView f1627c;

        public a(Activity activity) {
            try {
                this.f1625a = ActionBar.class.getDeclaredMethod("setHomeAsUpIndicator", Drawable.class);
                this.f1626b = ActionBar.class.getDeclaredMethod("setHomeActionContentDescription", Integer.TYPE);
            } catch (NoSuchMethodException unused) {
                View viewFindViewById = activity.findViewById(16908332);
                if (viewFindViewById == null) {
                    return;
                }
                ViewGroup viewGroup = (ViewGroup) viewFindViewById.getParent();
                if (viewGroup.getChildCount() != 2) {
                    return;
                }
                View childAt = viewGroup.getChildAt(0);
                childAt = childAt.getId() == 16908332 ? viewGroup.getChildAt(1) : childAt;
                if (childAt instanceof ImageView) {
                    this.f1627c = (ImageView) childAt;
                }
            }
        }
    }

    public static Drawable a(Activity activity) {
        TypedArray typedArrayObtainStyledAttributes = activity.obtainStyledAttributes(f1624b);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(0);
        typedArrayObtainStyledAttributes.recycle();
        return drawable;
    }

    public static a b(a aVar, Activity activity, int i10) {
        if (aVar == null) {
            aVar = new a(activity);
        }
        if (aVar.f1625a != null) {
            try {
                aVar.f1626b.invoke(activity.getActionBar(), Integer.valueOf(i10));
            } catch (Exception unused) {
            }
        }
        return aVar;
    }

    public static a c(Activity activity, Drawable drawable, int i10) {
        a aVar = new a(activity);
        if (aVar.f1625a != null) {
            try {
                ActionBar actionBar = activity.getActionBar();
                aVar.f1625a.invoke(actionBar, drawable);
                aVar.f1626b.invoke(actionBar, Integer.valueOf(i10));
            } catch (Exception unused) {
            }
        } else {
            ImageView imageView = aVar.f1627c;
            if (imageView != null) {
                imageView.setImageDrawable(drawable);
            }
        }
        return aVar;
    }
}
