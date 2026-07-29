package com.blankj.utilcode.util;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import com.blankj.utilcode.util.j1;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class UtilsTransActivity extends androidx.appcompat.app.f {
    public static final Map<UtilsTransActivity, TransActivityDelegate> K0 = new HashMap();

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public static final String f11690k1 = "extra_delegate";

    public static abstract class TransActivityDelegate implements Serializable {
        public boolean a(@g.n0 UtilsTransActivity utilsTransActivity, MotionEvent motionEvent) {
            Objects.requireNonNull(utilsTransActivity, "Argument 'activity' of type UtilsTransActivity (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            return false;
        }

        public void b(@g.n0 UtilsTransActivity utilsTransActivity, int i10, int i11, Intent intent) {
            Objects.requireNonNull(utilsTransActivity, "Argument 'activity' of type UtilsTransActivity (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }

        public void c(@g.n0 UtilsTransActivity utilsTransActivity, @g.p0 Bundle bundle) {
            Objects.requireNonNull(utilsTransActivity, "Argument 'activity' of type UtilsTransActivity (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }

        public void d(@g.n0 UtilsTransActivity utilsTransActivity, @g.p0 Bundle bundle) {
            Objects.requireNonNull(utilsTransActivity, "Argument 'activity' of type UtilsTransActivity (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }

        public void f(@g.n0 UtilsTransActivity utilsTransActivity) {
            Objects.requireNonNull(utilsTransActivity, "Argument 'activity' of type UtilsTransActivity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }

        public void h(@g.n0 UtilsTransActivity utilsTransActivity) {
            Objects.requireNonNull(utilsTransActivity, "Argument 'activity' of type UtilsTransActivity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }

        public void i(@g.n0 UtilsTransActivity utilsTransActivity, int i10, @g.n0 String[] strArr, @g.n0 int[] iArr) {
            Objects.requireNonNull(utilsTransActivity, "Argument 'activity' of type UtilsTransActivity (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            Objects.requireNonNull(strArr, "Argument 'permissions' of type String[] (#2 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            Objects.requireNonNull(iArr, "Argument 'grantResults' of type int[] (#3 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }

        public void k(@g.n0 UtilsTransActivity utilsTransActivity) {
            Objects.requireNonNull(utilsTransActivity, "Argument 'activity' of type UtilsTransActivity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }

        public void l(@g.n0 UtilsTransActivity utilsTransActivity, Bundle bundle) {
            Objects.requireNonNull(utilsTransActivity, "Argument 'activity' of type UtilsTransActivity (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }

        public void m(@g.n0 UtilsTransActivity utilsTransActivity) {
            Objects.requireNonNull(utilsTransActivity, "Argument 'activity' of type UtilsTransActivity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }

        public void n(@g.n0 UtilsTransActivity utilsTransActivity) {
            Objects.requireNonNull(utilsTransActivity, "Argument 'activity' of type UtilsTransActivity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
    }

    public static void Z3(Activity activity, j1.b<Intent> bVar, TransActivityDelegate transActivityDelegate) {
        a4(activity, bVar, transActivityDelegate, UtilsTransActivity.class);
    }

    public static void a4(Activity activity, j1.b<Intent> bVar, TransActivityDelegate transActivityDelegate, Class<?> cls) {
        if (transActivityDelegate == null) {
            return;
        }
        Intent intent = new Intent(j1.a(), cls);
        intent.putExtra(f11690k1, transActivityDelegate);
        if (bVar != null) {
            bVar.accept(intent);
        }
        if (activity != null) {
            activity.startActivity(intent);
        } else {
            intent.addFlags(268435456);
            j1.a().startActivity(intent);
        }
    }

    public static void b4(Activity activity, TransActivityDelegate transActivityDelegate) {
        a4(activity, null, transActivityDelegate, UtilsTransActivity.class);
    }

    public static void c4(j1.b<Intent> bVar, TransActivityDelegate transActivityDelegate) {
        a4(null, bVar, transActivityDelegate, UtilsTransActivity.class);
    }

    public static void d4(TransActivityDelegate transActivityDelegate) {
        a4(null, null, transActivityDelegate, UtilsTransActivity.class);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        TransActivityDelegate transActivityDelegate = K0.get(this);
        if (transActivityDelegate == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (transActivityDelegate.a(this, motionEvent)) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // androidx.fragment.app.g, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        TransActivityDelegate transActivityDelegate = K0.get(this);
        if (transActivityDelegate == null) {
            return;
        }
        transActivityDelegate.b(this, i10, i11, intent);
    }

    @Override // androidx.fragment.app.g, androidx.activity.ComponentActivity, f0.l, android.app.Activity
    public void onCreate(@g.p0 Bundle bundle) {
        overridePendingTransition(0, 0);
        Serializable serializableExtra = getIntent().getSerializableExtra(f11690k1);
        if (!(serializableExtra instanceof TransActivityDelegate)) {
            super.onCreate(bundle);
            finish();
            return;
        }
        TransActivityDelegate transActivityDelegate = (TransActivityDelegate) serializableExtra;
        K0.put(this, transActivityDelegate);
        transActivityDelegate.c(this, bundle);
        super.onCreate(bundle);
        transActivityDelegate.d(this, bundle);
    }

    @Override // androidx.appcompat.app.f, androidx.fragment.app.g, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Map<UtilsTransActivity, TransActivityDelegate> map = K0;
        TransActivityDelegate transActivityDelegate = map.get(this);
        if (transActivityDelegate == null) {
            return;
        }
        transActivityDelegate.f(this);
        map.remove(this);
    }

    @Override // androidx.fragment.app.g, android.app.Activity
    public void onPause() {
        overridePendingTransition(0, 0);
        super.onPause();
        TransActivityDelegate transActivityDelegate = K0.get(this);
        if (transActivityDelegate == null) {
            return;
        }
        transActivityDelegate.h(this);
    }

    @Override // androidx.fragment.app.g, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i10, @g.n0 String[] strArr, @g.n0 int[] iArr) {
        Objects.requireNonNull(strArr, "Argument 'permissions' of type String[] (#1 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(iArr, "Argument 'grantResults' of type int[] (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        super.onRequestPermissionsResult(i10, strArr, iArr);
        TransActivityDelegate transActivityDelegate = K0.get(this);
        if (transActivityDelegate == null) {
            return;
        }
        transActivityDelegate.i(this, i10, strArr, iArr);
    }

    @Override // androidx.fragment.app.g, android.app.Activity
    public void onResume() {
        super.onResume();
        TransActivityDelegate transActivityDelegate = K0.get(this);
        if (transActivityDelegate == null) {
            return;
        }
        transActivityDelegate.k(this);
    }

    @Override // androidx.activity.ComponentActivity, f0.l, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        TransActivityDelegate transActivityDelegate = K0.get(this);
        if (transActivityDelegate == null) {
            return;
        }
        transActivityDelegate.l(this, bundle);
    }

    @Override // androidx.appcompat.app.f, androidx.fragment.app.g, android.app.Activity
    public void onStart() {
        super.onStart();
        TransActivityDelegate transActivityDelegate = K0.get(this);
        if (transActivityDelegate == null) {
            return;
        }
        transActivityDelegate.m(this);
    }

    @Override // androidx.appcompat.app.f, androidx.fragment.app.g, android.app.Activity
    public void onStop() {
        super.onStop();
        TransActivityDelegate transActivityDelegate = K0.get(this);
        if (transActivityDelegate == null) {
            return;
        }
        transActivityDelegate.n(this);
    }
}
