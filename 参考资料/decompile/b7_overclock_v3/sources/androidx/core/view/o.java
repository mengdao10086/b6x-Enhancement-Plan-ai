package androidx.core.view;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import androidx.annotation.RestrictTo;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f5054a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Method f5055b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f5056c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Field f5057d;

    public interface a {
        boolean I1(@g.n0 KeyEvent keyEvent);
    }

    public static boolean a(ActionBar actionBar, KeyEvent keyEvent) {
        if (!f5054a) {
            try {
                f5055b = actionBar.getClass().getMethod("onMenuKeyEvent", KeyEvent.class);
            } catch (NoSuchMethodException unused) {
            }
            f5054a = true;
        }
        Method method = f5055b;
        if (method != null) {
            try {
                Object objInvoke = method.invoke(actionBar, keyEvent);
                if (objInvoke == null) {
                    return false;
                }
                return ((Boolean) objInvoke).booleanValue();
            } catch (IllegalAccessException | InvocationTargetException unused2) {
            }
        }
        return false;
    }

    public static boolean b(Activity activity, KeyEvent keyEvent) {
        activity.onUserInteraction();
        Window window = activity.getWindow();
        if (window.hasFeature(8)) {
            ActionBar actionBar = activity.getActionBar();
            if (keyEvent.getKeyCode() == 82 && actionBar != null && a(actionBar, keyEvent)) {
                return true;
            }
        }
        if (window.superDispatchKeyEvent(keyEvent)) {
            return true;
        }
        View decorView = window.getDecorView();
        if (u0.z(decorView, keyEvent)) {
            return true;
        }
        return keyEvent.dispatch(activity, decorView != null ? decorView.getKeyDispatcherState() : null, activity);
    }

    public static boolean c(Dialog dialog, KeyEvent keyEvent) {
        DialogInterface.OnKeyListener onKeyListenerF = f(dialog);
        if (onKeyListenerF != null && onKeyListenerF.onKey(dialog, keyEvent.getKeyCode(), keyEvent)) {
            return true;
        }
        Window window = dialog.getWindow();
        if (window.superDispatchKeyEvent(keyEvent)) {
            return true;
        }
        View decorView = window.getDecorView();
        if (u0.z(decorView, keyEvent)) {
            return true;
        }
        return keyEvent.dispatch(dialog, decorView != null ? decorView.getKeyDispatcherState() : null, dialog);
    }

    public static boolean d(@g.n0 View view, @g.n0 KeyEvent keyEvent) {
        return u0.A(view, keyEvent);
    }

    @SuppressLint({"LambdaLast"})
    public static boolean e(@g.n0 a aVar, @g.p0 View view, @g.p0 Window.Callback callback, @g.n0 KeyEvent keyEvent) {
        if (aVar == null) {
            return false;
        }
        return Build.VERSION.SDK_INT >= 28 ? aVar.I1(keyEvent) : callback instanceof Activity ? b((Activity) callback, keyEvent) : callback instanceof Dialog ? c((Dialog) callback, keyEvent) : (view != null && u0.z(view, keyEvent)) || aVar.I1(keyEvent);
    }

    public static DialogInterface.OnKeyListener f(Dialog dialog) {
        if (!f5056c) {
            try {
                Field declaredField = Dialog.class.getDeclaredField("mOnKeyListener");
                f5057d = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f5056c = true;
        }
        Field field = f5057d;
        if (field == null) {
            return null;
        }
        try {
            return (DialogInterface.OnKeyListener) field.get(dialog);
        } catch (IllegalAccessException unused2) {
            return null;
        }
    }
}
