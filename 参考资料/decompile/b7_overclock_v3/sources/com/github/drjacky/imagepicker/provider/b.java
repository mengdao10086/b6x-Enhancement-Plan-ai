package com.github.drjacky.imagepicker.provider;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.activity.result.ActivityResult;
import com.flydigi.sdk.bluetooth.l;
import com.github.drjacky.imagepicker.ImagePickerActivity;
import com.github.drjacky.imagepicker.R;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import fa.h;
import java.io.File;
import java.util.ArrayList;
import java.util.Objects;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.z1;
import m0.k;
import xf.j;

/* JADX INFO: loaded from: classes3.dex */
@d0(bv = {}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 (2\u00020\u0001:\u0001)B-\u0012\u0006\u0010\"\u001a\u00020!\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0016\u0012\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00040#¢\u0006\u0004\b&\u0010'J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016J\u0006\u0010\b\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fJ\b\u0010\u000f\u001a\u00020\u0004H\u0014J\u0006\u0010\u0010\u001a\u00020\u0004J\b\u0010\u0011\u001a\u00020\u0004H\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\b\u0010\u0013\u001a\u00020\u0004H\u0002J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u001cR\u0018\u0010 \u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u001f¨\u0006*"}, d2 = {"Lcom/github/drjacky/imagepicker/provider/b;", "Lcom/github/drjacky/imagepicker/provider/a;", "Landroid/os/Bundle;", "outState", "Lkotlin/z1;", "d", "savedInstanceState", "c", "q", "", "requestCode", "n", "Landroidx/activity/result/ActivityResult;", CommonNetImpl.RESULT, l.f16298a, "b", j.f55230b, "i", "p", "o", "Landroid/content/Context;", com.umeng.analytics.pro.d.R, "", k.f40564b, "", "", "k", "(Landroid/content/Context;)[Ljava/lang/String;", "Z", "tryFrontCamera", "Landroid/net/Uri;", "Landroid/net/Uri;", "mCameraUri", "Lcom/github/drjacky/imagepicker/ImagePickerActivity;", androidx.appcompat.widget.c.f2369r, "Lkotlin/Function1;", "Landroid/content/Intent;", "launcher", "<init>", "(Lcom/github/drjacky/imagepicker/ImagePickerActivity;ZLik/l;)V", "e", "a", "imagepicker_release"}, k = 1, mv = {1, 5, 1})
public final class b extends com.github.drjacky.imagepicker.provider.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @yt.k
    public static final String f16562f = "state.camera_uri";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f16565i = 4282;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f16566b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public final ik.l<Intent, z1> f16567c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.l
    public Uri f16568d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.k
    public static final a f16561e = new a(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @yt.k
    public static final String[] f16563g = {"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.CAMERA"};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @yt.k
    public static final String[] f16564h = {"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.CAMERA"};

    @d0(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/github/drjacky/imagepicker/provider/b$a;", "", "", "PERMISSION_INTENT_REQ_CODE", "I", "", "", "REQUIRED_PERMISSIONS", "[Ljava/lang/String;", "REQUIRED_PERMISSIONS_EXTENDED", "STATE_CAMERA_URI", "Ljava/lang/String;", "<init>", "()V", "imagepicker_release"}, k = 1, mv = {1, 5, 1})
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    public /* synthetic */ b(ImagePickerActivity imagePickerActivity, boolean z10, ik.l lVar, int i10, u uVar) {
        this(imagePickerActivity, (i10 & 2) != 0 ? false : z10, lVar);
    }

    @Override // com.github.drjacky.imagepicker.provider.a
    public void b() {
        j();
    }

    @Override // com.github.drjacky.imagepicker.provider.a
    public void c(@yt.l Bundle bundle) {
        this.f16568d = bundle == null ? null : (Uri) bundle.getParcelable(f16562f);
    }

    @Override // com.github.drjacky.imagepicker.provider.a
    public void d(@yt.k Bundle outState) {
        f0.p(outState, "outState");
        outState.putParcelable(f16562f, this.f16568d);
    }

    public final void i() {
        if (m(this)) {
            p();
        } else {
            o();
        }
    }

    public final void j() {
        String path;
        Uri uri = this.f16568d;
        if (uri != null && (path = uri.getPath()) != null) {
            new File(path).delete();
        }
        this.f16568d = null;
    }

    public final String[] k(Context context) {
        String[] strArr = f16563g;
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (fa.k.f28015a.c(context, str)) {
                arrayList.add(str);
            }
        }
        Object[] array = arrayList.toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        return (String[]) array;
    }

    public final void l(@yt.k ActivityResult result) {
        f0.p(result, "result");
        if (result.b() != -1) {
            g();
            return;
        }
        ImagePickerActivity imagePickerActivityA = a();
        Uri uri = this.f16568d;
        f0.m(uri);
        imagePickerActivityA.o4(uri, true);
    }

    public final boolean m(Context context) {
        for (String str : k(context)) {
            if (true ^ fa.k.f28015a.a(context, str)) {
                return false;
            }
        }
        return true;
    }

    public final void n(int i10) {
        if (i10 == 4282) {
            if (m(this)) {
                p();
                return;
            }
            String string = getString(R.string.permission_camera_denied);
            f0.o(string, "getString(errorRes)");
            f(string);
        }
    }

    public final void o() {
        f0.b.J(a(), k(a()), f16565i);
    }

    public final void p() {
        Uri uriK = h.k(h.f28010a, this, null, null, 6, null);
        this.f16568d = uriK;
        if (uriK == null) {
            e(R.string.error_failed_to_create_camera_image_file);
            return;
        }
        ik.l<Intent, z1> lVar = this.f16567c;
        fa.j jVar = fa.j.f28013a;
        lVar.i(fa.j.b(uriK, this.f16566b));
    }

    public final void q() {
        fa.j jVar = fa.j.f28013a;
        if (fa.j.g(this)) {
            i();
        } else {
            e(R.string.error_camera_app_not_found);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public b(@yt.k ImagePickerActivity activity, boolean z10, @yt.k ik.l<? super Intent, z1> launcher) {
        super(activity);
        f0.p(activity, "activity");
        f0.p(launcher, "launcher");
        this.f16566b = z10;
        this.f16567c = launcher;
    }
}
