package a;

import a.v4;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class u1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7553a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public g4 f3093a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public i4 f3094a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Context f3095a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Bundle f3096a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public View f3097a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ViewGroup f3098a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f3099a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public View f3100b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f3101b;
    public int c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f3102c;
    public int d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f3103d;
    public int e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public boolean f3104e = false;
    public int f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public boolean f3105f;

    public u1(int i) {
        this.f7553a = i;
    }

    public w4 a(v4.a aVar) {
        if (this.f3094a == null) {
            return null;
        }
        if (this.f3093a == null) {
            g4 g4Var = new g4(this.f3095a, z.abc_list_menu_item_layout);
            this.f3093a = g4Var;
            g4Var.g(aVar);
            this.f3094a.b(this.f3093a);
        }
        return this.f3093a.c(this.f3098a);
    }

    public boolean b() {
        if (this.f3097a == null) {
            return false;
        }
        return this.f3100b != null || this.f3093a.a().getCount() > 0;
    }

    public void c(i4 i4Var) {
        g4 g4Var;
        i4 i4Var2 = this.f3094a;
        if (i4Var == i4Var2) {
            return;
        }
        if (i4Var2 != null) {
            i4Var2.O(this.f3093a);
        }
        this.f3094a = i4Var;
        if (i4Var == null || (g4Var = this.f3093a) == null) {
            return;
        }
        i4Var.b(g4Var);
    }

    public void d(Context context) {
        TypedValue typedValue = new TypedValue();
        Resources.Theme themeNewTheme = context.getResources().newTheme();
        themeNewTheme.setTo(context.getTheme());
        themeNewTheme.resolveAttribute(t.actionBarPopupTheme, typedValue, true);
        int i = typedValue.resourceId;
        if (i != 0) {
            themeNewTheme.applyStyle(i, true);
        }
        themeNewTheme.resolveAttribute(t.panelMenuListTheme, typedValue, true);
        int i2 = typedValue.resourceId;
        if (i2 == 0) {
            i2 = b0.Theme_AppCompat_CompactMenu;
        }
        themeNewTheme.applyStyle(i2, true);
        m3 m3Var = new m3(context, 0);
        m3Var.getTheme().setTo(themeNewTheme);
        this.f3095a = m3Var;
        TypedArray typedArrayObtainStyledAttributes = m3Var.obtainStyledAttributes(c0.AppCompatTheme);
        this.b = typedArrayObtainStyledAttributes.getResourceId(c0.AppCompatTheme_panelBackground, 0);
        this.f = typedArrayObtainStyledAttributes.getResourceId(c0.AppCompatTheme_android_windowAnimationStyle, 0);
        typedArrayObtainStyledAttributes.recycle();
    }
}
