package com.omarea.vtools.activities;

import a.di;
import a.eh;
import a.f92;
import a.g91;
import a.ki;
import a.q32;
import a.t61;
import a.u61;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import com.omarea.ui.ScreenTest;
import java.util.HashMap;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ActivityScreenTest extends g91 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashMap f8868a;

    public static final class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ScreenTest screenTest = (ScreenTest) ActivityScreenTest.this._$_findCachedViewById(t61.display_test);
            f92.c(screenTest, "display_test");
            screenTest.setVisibility(0);
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this.f8868a == null) {
            this.f8868a = new HashMap();
        }
        View view = (View) this.f8868a.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i);
        this.f8868a.put(Integer.valueOf(i), viewFindViewById);
        return viewFindViewById;
    }

    @Override // a.g91, a.v0, a.cl, androidx.activity.ComponentActivity, a.gb, android.app.Activity
    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        setContentView(2131558464);
        StringBuilder sb = new StringBuilder();
        Object systemService = getContext().getSystemService("window");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
        }
        Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        sb.append("# Display Size\n");
        sb.append("  " + point.x + " × " + point.y);
        sb.append("\n\n");
        sb.append("# Display Mode\n");
        Display.Mode[] supportedModes = defaultDisplay.getSupportedModes();
        f92.c(supportedModes, "display.getSupportedModes()");
        for (Display.Mode mode : supportedModes) {
            f92.c(mode, "it");
            mode.getModeId();
            sb.append(mode.getPhysicalWidth() + " × " + mode.getPhysicalHeight() + ' ' + mode.getRefreshRate() + "Hz\n");
        }
        sb.append("\n");
        if (Build.VERSION.SDK_INT >= 29) {
            f92.c(defaultDisplay, "display");
            DisplayCutout cutout = defaultDisplay.getCutout();
            if (cutout != null) {
                sb.append("# Display Cutout\n");
                sb.append("  Top " + cutout.getSafeInsetTop() + '\n');
                sb.append("  Right " + cutout.getSafeInsetRight() + '\n');
                sb.append("  Bottom " + cutout.getSafeInsetBottom() + '\n');
                sb.append("  Left " + cutout.getSafeInsetLeft() + '\n');
                sb.append("\n");
            }
        }
        if (Build.VERSION.SDK_INT >= 24) {
            f92.b(defaultDisplay);
            Display.HdrCapabilities hdrCapabilities = defaultDisplay.getHdrCapabilities();
            sb.append("# Desired Luminance\n");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("  MaxAverage ");
            f92.c(hdrCapabilities, "hdrCapabilities");
            sb2.append(hdrCapabilities.getDesiredMaxAverageLuminance());
            sb2.append("cd/m2\n");
            sb.append(sb2.toString());
            sb.append("  Min " + hdrCapabilities.getDesiredMinLuminance() + "cd/m2\n");
            sb.append("  Max " + hdrCapabilities.getDesiredMaxLuminance() + "cd/m2\n");
            sb.append("\n");
            int[] supportedHdrTypes = hdrCapabilities.getSupportedHdrTypes();
            if (supportedHdrTypes == null) {
                supportedHdrTypes = new int[0];
            }
            sb.append("# Supported HDR Types \n");
            for (int i : supportedHdrTypes) {
                if (i == 1) {
                    str = "  Dolby Vision\n";
                } else if (i == 2) {
                    str = "  HDR10\n";
                } else if (i == 3) {
                    str = "  HLG\n";
                } else if (i == 4) {
                    str = "  HDR10+\n";
                }
                sb.append(str);
            }
            sb.append("\n");
        }
        TextView textView = (TextView) _$_findCachedViewById(t61.display_info);
        f92.c(textView, "display_info");
        textView.setText(sb.toString());
        ((Button) _$_findCachedViewById(t61.display_go)).setOnClickListener(new a());
    }

    @Override // a.v0, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        ScreenTest screenTest = (ScreenTest) _$_findCachedViewById(t61.display_test);
        f92.c(screenTest, "display_test");
        if (screenTest.getVisibility() != 0) {
            onBackPressed();
            return true;
        }
        ScreenTest screenTest2 = (ScreenTest) _$_findCachedViewById(t61.display_test);
        f92.c(screenTest2, "display_test");
        screenTest2.setVisibility(8);
        return true;
    }

    @Override // a.g91, a.cl, android.app.Activity
    public void onResume() {
        super.onResume();
        setTitle(getString(u61.menu_screen_test));
        Window window = getWindow();
        f92.c(window, "window");
        ki kiVarI = eh.I(window.getDecorView());
        if (kiVarI != null) {
            kiVarI.a(di.d());
        }
        q32.a().c(this);
    }
}
