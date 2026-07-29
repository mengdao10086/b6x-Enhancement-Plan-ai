package f0;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.RestrictTo;
import androidx.core.os.a;
import androidx.core.view.o;
import androidx.lifecycle.Lifecycle;
import g.n0;
import g.p0;
import g.r0;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class l extends Activity implements androidx.lifecycle.y, o.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public androidx.collection.l<Class<? extends a>, a> f27518a = new androidx.collection.l<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public androidx.lifecycle.a0 f27519b = new androidx.lifecycle.a0(this);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public static class a {
    }

    @r0(markerClass = {a.b.class})
    public static boolean V2(@p0 String[] strArr) {
        if (strArr == null || strArr.length <= 0) {
            return false;
        }
        String str = strArr[0];
        str.hashCode();
        switch (str) {
            case "--translation":
                return Build.VERSION.SDK_INT >= 31;
            case "--dump-dumpable":
            case "--list-dumpables":
                return androidx.core.os.a.k();
            case "--contentcapture":
                return Build.VERSION.SDK_INT >= 29;
            case "--autofill":
                return Build.VERSION.SDK_INT >= 26;
            default:
                return false;
        }
    }

    @Override // androidx.core.view.o.a
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean I1(@n0 KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public <T extends a> T S2(Class<T> cls) {
        return (T) this.f27518a.get(cls);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public void T2(a aVar) {
        this.f27518a.put((Class<? extends a>) aVar.getClass(), aVar);
    }

    public final boolean U2(@p0 String[] strArr) {
        return !V2(strArr);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !androidx.core.view.o.d(decorView, keyEvent)) {
            return androidx.core.view.o.e(this, decorView, this, keyEvent);
        }
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !androidx.core.view.o.d(decorView, keyEvent)) {
            return super.dispatchKeyShortcutEvent(keyEvent);
        }
        return true;
    }

    @n0
    public Lifecycle e() {
        return this.f27519b;
    }

    @Override // android.app.Activity
    @SuppressLint({"RestrictedApi"})
    public void onCreate(@p0 Bundle bundle) {
        super.onCreate(bundle);
        androidx.lifecycle.p0.g(this);
    }

    @Override // android.app.Activity
    @g.i
    public void onSaveInstanceState(@n0 Bundle bundle) {
        this.f27519b.n(Lifecycle.State.CREATED);
        super.onSaveInstanceState(bundle);
    }
}
