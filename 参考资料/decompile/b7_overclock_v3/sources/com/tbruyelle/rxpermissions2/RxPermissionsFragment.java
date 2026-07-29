package com.tbruyelle.rxpermissions2;

import android.annotation.TargetApi;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.g;
import g.n0;
import io.reactivex.subjects.PublishSubject;
import java.util.HashMap;
import java.util.Map;
import wg.b;
import wg.c;

/* JADX INFO: loaded from: classes5.dex */
public class RxPermissionsFragment extends Fragment {

    /* JADX INFO: renamed from: e8, reason: collision with root package name */
    public static final int f22357e8 = 42;

    /* JADX INFO: renamed from: c8, reason: collision with root package name */
    public Map<String, PublishSubject<b>> f22358c8 = new HashMap();

    /* JADX INFO: renamed from: d8, reason: collision with root package name */
    public boolean f22359d8;

    public boolean E5(@n0 String str) {
        return this.f22358c8.containsKey(str);
    }

    public PublishSubject<b> F5(@n0 String str) {
        return this.f22358c8.get(str);
    }

    @TargetApi(23)
    public boolean G5(String str) {
        g gVarW1 = w1();
        if (gVarW1 != null) {
            return gVarW1.checkSelfPermission(str) == 0;
        }
        throw new IllegalStateException("This fragment must be attached to an activity.");
    }

    @TargetApi(23)
    public boolean H5(String str) {
        g gVarW1 = w1();
        if (gVarW1 != null) {
            return gVarW1.getPackageManager().isPermissionRevokedByPolicy(str, w1().getPackageName());
        }
        throw new IllegalStateException("This fragment must be attached to an activity.");
    }

    public void I5(String str) {
        if (this.f22359d8) {
            String str2 = c.f54685b;
        }
    }

    public void J5(String[] strArr, int[] iArr, boolean[] zArr) {
        int length = strArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            I5("onRequestPermissionsResult  " + strArr[i10]);
            PublishSubject<b> publishSubject = this.f22358c8.get(strArr[i10]);
            if (publishSubject == null) {
                String str = c.f54685b;
                return;
            }
            this.f22358c8.remove(strArr[i10]);
            publishSubject.onNext(new b(strArr[i10], iArr[i10] == 0, zArr[i10]));
            publishSubject.onComplete();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void K3(Bundle bundle) {
        super.K3(bundle);
        p5(true);
    }

    @TargetApi(23)
    public void K5(@n0 String[] strArr) {
        O4(strArr, 42);
    }

    public void L5(boolean z10) {
        this.f22359d8 = z10;
    }

    public void M5(@n0 String str, @n0 PublishSubject<b> publishSubject) {
        this.f22358c8.put(str, publishSubject);
    }

    @Override // androidx.fragment.app.Fragment
    @TargetApi(23)
    public void e4(int i10, @n0 String[] strArr, @n0 int[] iArr) {
        super.e4(i10, strArr, iArr);
        if (i10 != 42) {
            return;
        }
        boolean[] zArr = new boolean[strArr.length];
        for (int i11 = 0; i11 < strArr.length; i11++) {
            zArr[i11] = w5(strArr[i11]);
        }
        J5(strArr, iArr, zArr);
    }
}
