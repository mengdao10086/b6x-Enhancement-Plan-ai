package com.flydigi.base.common;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.flydigi.base.common.y;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public class c extends ch.a implements y.a, a {

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public y f13337k1;

    @Override // com.flydigi.base.common.y.a
    public boolean D2(Message message, int i10, boolean z10) {
        return false;
    }

    @Override // com.flydigi.base.common.a
    public Context H1() {
        return this;
    }

    @p0
    public <T extends Fragment> T a4(String str) {
        return (T) n3().s0(str);
    }

    public Handler b4() {
        return c4().b();
    }

    public y c4() {
        if (this.f13337k1 == null) {
            this.f13337k1 = new y(this);
        }
        return this.f13337k1;
    }

    public boolean d4() {
        try {
            if (b.b(this)) {
                return true;
            }
            super.onBackPressed();
            return true;
        } catch (IllegalStateException e10) {
            e10.printStackTrace();
            return true;
        }
    }

    @Override // androidx.fragment.app.g, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, @p0 Intent intent) {
        super.onActivityResult(i10, i11, intent);
        String.format("%s(%d) onActivityResult(requestCode=%d,resultCode=%d)", getClass().getSimpleName(), Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(i10), Integer.valueOf(i11));
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        d4();
    }

    @Override // ch.a, androidx.fragment.app.g, androidx.activity.ComponentActivity, f0.l, android.app.Activity
    public void onCreate(@p0 Bundle bundle) {
        super.onCreate(bundle);
        String.format("%s(%d) onCreate", getClass().getSimpleName(), Integer.valueOf(System.identityHashCode(this)));
    }

    @Override // ch.a, androidx.appcompat.app.f, androidx.fragment.app.g, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        String.format("%s(%d) onDestroy", getClass().getSimpleName(), Integer.valueOf(System.identityHashCode(this)));
        y yVar = this.f13337k1;
        if (yVar != null) {
            yVar.i(false);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        String.format("%s(%d) onNewIntent", getClass().getSimpleName(), Integer.valueOf(System.identityHashCode(this)));
    }

    @Override // ch.a, androidx.fragment.app.g, android.app.Activity
    public void onPause() {
        super.onPause();
        String.format("%s(%d) onPause", getClass().getSimpleName(), Integer.valueOf(System.identityHashCode(this)));
    }

    @Override // androidx.appcompat.app.f, android.app.Activity
    public void onPostCreate(@p0 Bundle bundle) {
        super.onPostCreate(bundle);
        String.format("%s(%d) onPostCreate", getClass().getSimpleName(), Integer.valueOf(System.identityHashCode(this)));
    }

    @Override // androidx.appcompat.app.f, androidx.fragment.app.g, android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        String.format("%s(%d) onPostResume", getClass().getSimpleName(), Integer.valueOf(System.identityHashCode(this)));
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
        String.format("%s(%d) onRestart", getClass().getSimpleName(), Integer.valueOf(System.identityHashCode(this)));
    }

    @Override // ch.a, androidx.fragment.app.g, android.app.Activity
    public void onResume() {
        super.onResume();
        String.format("%s(%d) onResume", getClass().getSimpleName(), Integer.valueOf(System.identityHashCode(this)));
        y yVar = this.f13337k1;
        if (yVar != null) {
            yVar.i(true);
        }
    }

    @Override // androidx.activity.ComponentActivity, f0.l, android.app.Activity
    public void onSaveInstanceState(@n0 Bundle bundle) {
        super.onSaveInstanceState(bundle);
        View viewFindViewById = findViewById(R.id.content);
        if (viewFindViewById != null) {
            viewFindViewById.cancelPendingInputEvents();
        }
    }

    @Override // ch.a, androidx.appcompat.app.f, androidx.fragment.app.g, android.app.Activity
    public void onStart() {
        super.onStart();
        String.format("%s(%d) onStart", getClass().getSimpleName(), Integer.valueOf(System.identityHashCode(this)));
    }

    @Override // ch.a, androidx.appcompat.app.f, androidx.fragment.app.g, android.app.Activity
    public void onStop() {
        super.onStop();
        String.format("%s(%d) onStop", getClass().getSimpleName(), Integer.valueOf(System.identityHashCode(this)));
    }

    @Override // androidx.fragment.app.g
    public void w3(@n0 Fragment fragment) {
        super.w3(fragment);
        String.format("%s(%d) onAttachFragment(%s(%d))", getClass().getSimpleName(), Integer.valueOf(System.identityHashCode(this)), fragment.getClass().getSimpleName(), Integer.valueOf(System.identityHashCode(this)));
    }

    @Override // androidx.fragment.app.g
    public void x3() {
        super.x3();
        String.format("%s(%d) onResumeFragments", getClass().getSimpleName(), Integer.valueOf(System.identityHashCode(this)));
    }
}
