package n8;

import android.app.Application;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.display.DisplayManager;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import com.blankj.utilcode.util.j1;
import com.flydigi.base.common.n;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes7.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f41995a = "pc_mode_enable";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f41996b = 1;

    /* JADX INFO: renamed from: n8.a$a, reason: collision with other inner class name */
    public class C0472a implements DisplayManager.DisplayListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DisplayManager f41997a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f41998b;

        public C0472a(DisplayManager displayManager, b bVar) {
            this.f41997a = displayManager;
            this.f41998b = bVar;
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int i10) {
            Display display = this.f41997a.getDisplay(i10);
            if (display == null || display.getDisplayId() == -1 || display.getDisplayId() == 0) {
                return;
            }
            this.f41998b.a();
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i10) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int i10) {
            this.f41998b.b();
        }
    }

    public interface b {
        void a();

        void b();
    }

    public static void a(int[] iArr, View view) {
        if (view.getWidth() == 0 || view.getHeight() == 0) {
            return;
        }
        Display displayB = b(view.getContext(), true);
        displayB.getMetrics(new DisplayMetrics());
        DisplayMetrics displayMetrics = new DisplayMetrics();
        displayB.getRealMetrics(displayMetrics);
        Point point = new Point();
        displayB.getSize(point);
        Point point2 = new Point();
        displayB.getRealSize(point2);
        Rect rect = new Rect();
        displayB.getRectSize(rect);
        n.a("投屏 -------------------------华丽的分割线-----------------");
        n.a("投屏 defaultDisplay localRealMetrics width:" + displayMetrics.widthPixels + ", height:" + displayMetrics.heightPixels);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("投屏 defaultDisplay localRealMetrics densityDpi:");
        sb2.append(displayMetrics.densityDpi);
        n.a(sb2.toString());
        n.a("投屏 defaultDisplay localRealMetrics scaledDensity:" + displayMetrics.scaledDensity);
        n.a("投屏 defaultDisplay localRealMetrics dpi:" + displayMetrics.xdpi + "x" + displayMetrics.ydpi);
        StringBuilder sb3 = new StringBuilder();
        sb3.append("投屏 defaultDisplay size:");
        sb3.append(point.toString());
        n.a(sb3.toString());
        n.a("投屏 defaultDisplay realSize:" + point2.toString());
        n.a("投屏 defaultDisplay rectSize:" + rect.toString());
        Display displayB2 = b(view.getContext(), false);
        displayB2.getMetrics(new DisplayMetrics());
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        displayB2.getRealMetrics(displayMetrics2);
        Point point3 = new Point();
        displayB2.getSize(point3);
        Point point4 = new Point();
        displayB2.getRealSize(point4);
        Rect rect2 = new Rect();
        displayB2.getRectSize(rect2);
        n.a("投屏 -------------------------华丽的分割线-----------------");
        n.a("投屏 remoteDisplay remoteRealMetrics width:" + displayMetrics2.widthPixels + ", height:" + displayMetrics2.heightPixels);
        StringBuilder sb4 = new StringBuilder();
        sb4.append("投屏 remoteDisplay remoteRealMetrics densityDpi:");
        sb4.append(displayMetrics2.densityDpi);
        n.a(sb4.toString());
        n.a("投屏 remoteDisplay remoteRealMetrics scaledDensity:" + displayMetrics2.scaledDensity);
        n.a("投屏 remoteDisplay remoteRealMetrics dpi:" + displayMetrics2.xdpi + "x" + displayMetrics2.ydpi);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("投屏 remoteDisplay size:");
        sb5.append(point3.toString());
        n.a(sb5.toString());
        n.a("投屏 remoteDisplay realSize:" + point4.toString());
        n.a("投屏 remoteDisplay rectSize:" + rect2.toString());
        n.a("投屏 -------------------------华丽的分割线-----------------");
        n.a("投屏 view width:" + view.getWidth() + ", height:" + view.getHeight());
        int i10 = displayMetrics2.widthPixels;
        int i11 = displayMetrics2.heightPixels;
        if (i10 / i11 < displayMetrics.widthPixels / displayMetrics.heightPixels) {
            iArr[1] = (((view.getHeight() * displayMetrics2.heightPixels) / ((int) (i10 * (view.getHeight() / view.getWidth())))) - view.getHeight()) / 2;
        } else {
            iArr[0] = (((view.getWidth() * displayMetrics2.widthPixels) / ((int) (i11 * (view.getWidth() / view.getHeight())))) - view.getWidth()) / 2;
        }
        n.a("投屏 偏移 x:" + iArr[0] + ", y:" + iArr[1]);
    }

    public static Display b(Context context, boolean z10) {
        Display[] displays;
        DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
        if (displayManager != null && (displays = displayManager.getDisplays()) != null && displays.length > 1) {
            for (int length = displays.length - 1; length >= 0; length--) {
                Display display = displays[length];
                if (z10) {
                    if (display.getDisplayId() != -1 && display.getDisplayId() == 0) {
                        return display;
                    }
                } else if (display.getDisplayId() != -1 && display.getDisplayId() != 0) {
                    try {
                        Method declaredMethod = display.getClass().getDeclaredMethod("getType", new Class[0]);
                        declaredMethod.setAccessible(true);
                        int iIntValue = ((Integer) declaredMethod.invoke(display, new Object[0])).intValue();
                        if (iIntValue == 3 || (iIntValue == 2 && display.getName().toUpperCase().startsWith("HDMI"))) {
                            return display;
                        }
                    } catch (IllegalAccessException e10) {
                        e10.printStackTrace();
                    } catch (NoSuchMethodException e11) {
                        e11.printStackTrace();
                    } catch (InvocationTargetException e12) {
                        e12.printStackTrace();
                    }
                }
            }
        }
        return ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
    }

    public static Display[] c(Context context) {
        DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
        return displayManager != null ? displayManager.getDisplays() : new Display[]{((WindowManager) context.getSystemService("window")).getDefaultDisplay()};
    }

    public static float d(int i10, boolean z10) {
        Application applicationA = j1.a();
        float f10 = i10;
        if (!z10 || !f(applicationA)) {
            return f10;
        }
        Display displayB = b(applicationA, false);
        Display displayB2 = b(applicationA, true);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        displayB2.getRealMetrics(displayMetrics);
        displayB.getRealMetrics(displayMetrics2);
        int i11 = displayMetrics2.widthPixels;
        float f11 = i11 / displayMetrics2.heightPixels;
        int i12 = displayMetrics.widthPixels;
        int i13 = displayMetrics.heightPixels;
        if (f11 >= i12 / i13) {
            return f10;
        }
        return (i10 * r3) / (i11 * (i13 / i12));
    }

    public static float e(int i10, boolean z10) {
        Application applicationA = j1.a();
        float f10 = i10;
        if (!z10 || !f(applicationA)) {
            return f10;
        }
        Display displayB = b(applicationA, false);
        Display displayB2 = b(applicationA, true);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        displayB2.getRealMetrics(displayMetrics);
        displayB.getRealMetrics(displayMetrics2);
        int i11 = displayMetrics2.widthPixels;
        int i12 = displayMetrics2.heightPixels;
        float f11 = i11 / i12;
        int i13 = displayMetrics.widthPixels;
        int i14 = displayMetrics.heightPixels;
        if (f11 < i13 / i14) {
            return f10;
        }
        return (i10 * i11) / (i12 * (i13 / i14));
    }

    public static boolean f(Context context) {
        DisplayManager displayManager;
        Display[] displays;
        if (v5.a.j().a() && !v5.a.j().m() && (displayManager = (DisplayManager) context.getSystemService("display")) != null && (displays = displayManager.getDisplays()) != null && displays.length > 1) {
            for (int length = displays.length - 1; length >= 0; length--) {
                Display display = displays[length];
                if (display != null && display.getDisplayId() != -1 && display.getDisplayId() != 0) {
                    try {
                        Method declaredMethod = display.getClass().getDeclaredMethod("getType", new Class[0]);
                        declaredMethod.setAccessible(true);
                        int iIntValue = ((Integer) declaredMethod.invoke(display, new Object[0])).intValue();
                        if (iIntValue == 3 || (iIntValue == 2 && display.getName().toUpperCase().startsWith("HDMI"))) {
                            return true;
                        }
                    } catch (IllegalAccessException e10) {
                        e10.printStackTrace();
                    } catch (NoSuchMethodException e11) {
                        e11.printStackTrace();
                    } catch (InvocationTargetException e12) {
                        e12.printStackTrace();
                    }
                }
            }
        }
        return false;
    }

    public static boolean g(Context context) {
        return Settings.Secure.getInt(context.getContentResolver(), f41995a, 0) == 1;
    }

    public static void h(Context context, b bVar) {
        DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
        if (displayManager != null) {
            displayManager.registerDisplayListener(new C0472a(displayManager, bVar), null);
        }
    }
}
