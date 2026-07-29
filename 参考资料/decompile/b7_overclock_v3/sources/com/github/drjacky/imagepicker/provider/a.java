package com.github.drjacky.imagepicker.provider;

import android.content.ContextWrapper;
import android.os.Bundle;
import android.widget.Toast;
import com.github.drjacky.imagepicker.ImagePickerActivity;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes3.dex */
@d0(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0012¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0004J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0004J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006H\u0004J\b\u0010\u000b\u001a\u00020\u0004H\u0004J\b\u0010\f\u001a\u00020\u0004H\u0014J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0012\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\rH\u0016R\u001a\u0010\u0016\u001a\u00020\u00128\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/github/drjacky/imagepicker/provider/a;", "Landroid/content/ContextWrapper;", "", com.umeng.analytics.pro.d.O, "Lkotlin/z1;", "f", "", "errorRes", "e", "messageRes", "h", "g", "b", "Landroid/os/Bundle;", "outState", "d", "savedInstanceState", "c", "Lcom/github/drjacky/imagepicker/ImagePickerActivity;", "a", "Lcom/github/drjacky/imagepicker/ImagePickerActivity;", "()Lcom/github/drjacky/imagepicker/ImagePickerActivity;", androidx.appcompat.widget.c.f2369r, "<init>", "(Lcom/github/drjacky/imagepicker/ImagePickerActivity;)V", "imagepicker_release"}, k = 1, mv = {1, 5, 1})
public abstract class a extends ContextWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public final ImagePickerActivity f16560a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@k ImagePickerActivity activity) {
        super(activity);
        f0.p(activity, "activity");
        this.f16560a = activity;
    }

    @k
    public final ImagePickerActivity a() {
        return this.f16560a;
    }

    public void b() {
    }

    public void c(@l Bundle bundle) {
    }

    public void d(@k Bundle outState) {
        f0.p(outState, "outState");
    }

    public final void e(int i10) {
        String string = getString(i10);
        f0.o(string, "getString(errorRes)");
        f(string);
    }

    public final void f(@k String error) {
        f0.p(error, "error");
        b();
        this.f16560a.n4(error);
    }

    public final void g() {
        b();
        this.f16560a.q4();
    }

    public final void h(int i10) {
        Toast.makeText(this, i10, 0).show();
    }
}
