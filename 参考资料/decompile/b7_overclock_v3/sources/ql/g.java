package ql;

import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import java.lang.reflect.Field;
import w.w;

/* JADX INFO: loaded from: classes5.dex */
public class g extends ol.a {
    @Override // ol.a, ol.b
    public void e(Activity activity, ol.d dVar) {
        h(activity, dVar);
    }

    @Override // ol.a, ol.b
    public void f(Activity activity, ol.d dVar) {
        super.f(activity, dVar);
        if (g(activity.getWindow())) {
            Window window = activity.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            try {
                Field field = attributes.getClass().getField("layoutInDisplayCutoutMode");
                field.setAccessible(true);
                field.setInt(attributes, 1);
                window.setAttributes(attributes);
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    @Override // ol.b
    public boolean g(Window window) {
        if (window == null) {
            return false;
        }
        try {
            Resources resources = window.getContext().getResources();
            int identifier = resources.getIdentifier("config_mainBuiltInDisplayCutout", w.b.f53669e, l4.f.f39447b);
            String string = identifier > 0 ? resources.getString(identifier) : null;
            if (string != null) {
                return !TextUtils.isEmpty(string);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // ol.a, ol.b
    public void h(Activity activity, ol.d dVar) {
        super.h(activity, dVar);
        if (g(activity.getWindow())) {
            Window window = activity.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            try {
                Field field = attributes.getClass().getField("layoutInDisplayCutoutMode");
                field.setAccessible(true);
                field.setInt(attributes, 1);
                window.setAttributes(attributes);
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            pl.b.i(activity.getWindow());
        }
    }

    @Override // ol.b
    public int i(Window window) {
        if (g(window)) {
            return pl.b.c(window.getContext());
        }
        return 0;
    }
}
