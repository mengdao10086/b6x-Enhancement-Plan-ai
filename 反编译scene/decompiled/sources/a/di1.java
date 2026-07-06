package a;

import a.p80;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import com.omarea.Scene;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class di1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f5904a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int f565a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Activity f566a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f567a;
    public final int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final String f568b;
    public final String c;

    public di1(Activity activity) {
        f92.d(activity, "context");
        this.f566a = activity;
        this.f567a = "screen_dpi";
        this.f568b = "screen_ratio";
        this.c = "screen_width";
        this.f5904a = 1.7777778f;
        this.f565a = 320;
        this.b = 720;
    }

    public static /* synthetic */ void i(di1 di1Var, Point point, DisplayMetrics displayMetrics, Context context, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = false;
        }
        di1Var.h(point, displayMetrics, context, z);
    }

    public final void g() {
        Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new uh1(this, handler), 2000L);
    }

    @SuppressLint({"ApplySharedPref"})
    public final void h(Point point, DisplayMetrics displayMetrics, Context context, boolean z) {
        SharedPreferences sharedPreferencesG = Scene.f4798a.g();
        if (z || !sharedPreferencesG.contains(this.f568b)) {
            sharedPreferencesG.edit().putFloat(this.f568b, point.y / point.x).commit();
        }
        if (!z && sharedPreferencesG.contains(this.f567a) && sharedPreferencesG.contains(this.c)) {
            return;
        }
        sharedPreferencesG.edit().putInt(this.f567a, displayMetrics.densityDpi).commit();
        sharedPreferencesG.edit().putInt(this.c, point.x).commit();
    }

    public final Activity j() {
        return this.f566a;
    }

    public final int k(int i) {
        SharedPreferences sharedPreferencesG = Scene.f4798a.g();
        int i2 = (sharedPreferencesG.getInt(this.f567a, this.f565a) * i) / sharedPreferencesG.getInt(this.c, this.b);
        if (i2 > 960) {
            return 960;
        }
        if (i2 < 160) {
            return 160;
        }
        return i2;
    }

    public final int l(int i) {
        return (int) (i * Scene.f4798a.g().getFloat(this.f568b, this.f5904a));
    }

    public final void m(Display display, Activity activity) {
        f92.d(display, "display");
        f92.d(activity, "context");
        View viewInflate = LayoutInflater.from(activity).inflate(2131558492, (ViewGroup) null);
        View viewFindViewById = viewInflate.findViewById(t61.dialog_addin_dpi_dpiinput);
        f92.c(viewFindViewById, "dialog.findViewById(R.id…ialog_addin_dpi_dpiinput)");
        EditText editText = (EditText) viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(t61.dialog_addin_dpi_width);
        f92.c(viewFindViewById2, "dialog.findViewById(R.id.dialog_addin_dpi_width)");
        EditText editText2 = (EditText) viewFindViewById2;
        View viewFindViewById3 = viewInflate.findViewById(t61.dialog_addin_dpi_height);
        f92.c(viewFindViewById3, "dialog.findViewById(R.id.dialog_addin_dpi_height)");
        EditText editText3 = (EditText) viewFindViewById3;
        View viewFindViewById4 = viewInflate.findViewById(t61.dialog_addin_dpi_quickchange);
        f92.c(viewFindViewById4, "dialog.findViewById(R.id…og_addin_dpi_quickchange)");
        CheckBox checkBox = (CheckBox) viewFindViewById4;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        display.getMetrics(displayMetrics);
        Point point = new Point();
        display.getRealSize(point);
        i(this, point, displayMetrics, activity, false, 8, null);
        editText.setText(String.valueOf(displayMetrics.densityDpi));
        editText2.setText(String.valueOf(point.x));
        editText3.setText(String.valueOf(point.y));
        if (Build.VERSION.SDK_INT >= 24) {
            checkBox.setChecked(true);
            if (f92.a(e50.f677a.y0(), "adb")) {
                checkBox.setEnabled(false);
            }
        }
        ((Button) viewInflate.findViewById(t61.dialog_dpi_720)).setOnClickListener(new vh1(this, editText2, editText3, editText, displayMetrics, point));
        ((Button) viewInflate.findViewById(t61.dialog_dpi_1080)).setOnClickListener(new wh1(this, editText2, editText3, editText));
        ((Button) viewInflate.findViewById(t61.dialog_dpi_2k)).setOnClickListener(new xh1(this, editText2, editText3, editText));
        ((Button) viewInflate.findViewById(t61.dialog_dpi_4k)).setOnClickListener(new yh1(this, editText2, editText3, editText));
        p80.a aVar = p80.f2403a;
        String string = activity.getString(u61.addin_dpi);
        f92.c(string, "context.getString(R.string.addin_dpi)");
        ((Button) viewInflate.findViewById(t61.dialog_dpi_reset)).setOnClickListener(new ai1(this, aVar.g(activity, string, "", viewInflate, new bi1(this, editText, editText2, editText3, checkBox, activity), ci1.f5797a), display, point, displayMetrics, activity));
    }

    public final void n() {
        s60.f7366a.c("settings put system pointer_location 0");
    }

    public final void o() {
        s60 s60Var = s60.f7366a;
        String str = "wm size reset\nwm density reset\nwm overscan reset\n";
        f92.c(str, "cmd.toString()");
        s60Var.c(str);
    }
}
