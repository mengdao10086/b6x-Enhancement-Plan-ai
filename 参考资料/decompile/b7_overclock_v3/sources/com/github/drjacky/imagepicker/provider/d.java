package com.github.drjacky.imagepicker.provider;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.activity.result.ActivityResult;
import com.flydigi.sdk.bluetooth.l;
import com.github.drjacky.imagepicker.ImagePickerActivity;
import com.github.drjacky.imagepicker.R;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.Objects;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.z1;
import m0.k;
import xf.j;

/* JADX INFO: loaded from: classes3.dex */
@d0(bv = {}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 !2\u00020\u0001:\u0001\"B#\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007J\b\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0017\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006#"}, d2 = {"Lcom/github/drjacky/imagepicker/provider/d;", "Lcom/github/drjacky/imagepicker/provider/a;", "Lkotlin/z1;", "q", "", "requestCode", "n", "Landroidx/activity/result/ActivityResult;", CommonNetImpl.RESULT, l.f16298a, "i", "p", "o", "Landroid/content/Context;", com.umeng.analytics.pro.d.R, "", k.f40564b, "", "", j.f55230b, "(Landroid/content/Context;)[Ljava/lang/String;", "Landroid/content/Intent;", "data", "k", "c", "[Ljava/lang/String;", "mimeTypes", "Lcom/github/drjacky/imagepicker/ImagePickerActivity;", androidx.appcompat.widget.c.f2369r, "Lkotlin/Function1;", "launcher", "<init>", "(Lcom/github/drjacky/imagepicker/ImagePickerActivity;Lik/l;)V", "d", "a", "imagepicker_release"}, k = 1, mv = {1, 5, 1})
public final class d extends com.github.drjacky.imagepicker.provider.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public static final a f16581d = new a(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.k
    public static final String[] f16582e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f16583f = 4262;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final ik.l<Intent, z1> f16584b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public final String[] f16585c;

    @d0(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/github/drjacky/imagepicker/provider/d$a;", "", "", "PERMISSION_INTENT_REQ_CODE", "I", "", "", "REQUIRED_PERMISSIONS", "[Ljava/lang/String;", "<init>", "()V", "imagepicker_release"}, k = 1, mv = {1, 5, 1})
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    static {
        f16582e = Build.VERSION.SDK_INT <= 28 ? new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"} : new String[]{"android.permission.READ_EXTERNAL_STORAGE"};
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public d(@yt.k ImagePickerActivity activity, @yt.k ik.l<? super Intent, z1> launcher) {
        super(activity);
        f0.p(activity, "activity");
        f0.p(launcher, "launcher");
        this.f16584b = launcher;
        Bundle extras = activity.getIntent().getExtras();
        String[] stringArray = (extras == null ? new Bundle() : extras).getStringArray(com.github.drjacky.imagepicker.b.f16539n);
        this.f16585c = stringArray == null ? new String[0] : stringArray;
    }

    public final void i() {
        if (m(this)) {
            p();
        } else {
            o();
        }
    }

    public final String[] j(Context context) {
        String[] strArr = f16582e;
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

    public final void k(Intent intent) {
        Uri data = intent == null ? null : intent.getData();
        if (data != null) {
            a().o4(data, false);
        } else {
            e(R.string.error_failed_pick_gallery_image);
        }
    }

    public final void l(@yt.k ActivityResult result) {
        f0.p(result, "result");
        if (result.b() == -1) {
            k(result.a());
        } else {
            g();
        }
    }

    public final boolean m(Context context) {
        for (String str : j(context)) {
            if (true ^ fa.k.f28015a.a(context, str)) {
                return false;
            }
        }
        return true;
    }

    public final void n(int i10) {
        if (i10 == 4262) {
            if (fa.k.f28015a.b(this, f16582e)) {
                p();
                return;
            }
            String string = getString(R.string.permission_gallery_denied);
            f0.o(string, "getString(R.string.permission_gallery_denied)");
            f(string);
        }
    }

    public final void o() {
        f0.b.J(a(), j(a()), f16583f);
    }

    public final void p() {
        ik.l<Intent, z1> lVar = this.f16584b;
        fa.j jVar = fa.j.f28013a;
        lVar.i(fa.j.d(a(), this.f16585c));
    }

    public final void q() {
        i();
    }
}
