package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import androidx.annotation.RestrictTo;
import g.p0;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
public abstract class l<E> extends i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @p0
    public final Activity f6006a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final Context f6007b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final Handler f6008c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f6009d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FragmentManager f6010e;

    public l(@g.n0 Context context, @g.n0 Handler handler, int i10) {
        this(context instanceof Activity ? (Activity) context : null, context, handler, i10);
    }

    @Override // androidx.fragment.app.i
    @p0
    public View c(int i10) {
        return null;
    }

    @Override // androidx.fragment.app.i
    public boolean d() {
        return true;
    }

    @p0
    Activity f() {
        return this.f6006a;
    }

    @g.n0
    Context g() {
        return this.f6007b;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @g.n0
    public Handler h() {
        return this.f6008c;
    }

    public void i(@g.n0 String str, @p0 FileDescriptor fileDescriptor, @g.n0 PrintWriter printWriter, @p0 String[] strArr) {
    }

    @p0
    public abstract E j();

    @g.n0
    public LayoutInflater k() {
        return LayoutInflater.from(this.f6007b);
    }

    public int l() {
        return this.f6009d;
    }

    public boolean m() {
        return true;
    }

    @Deprecated
    public void n(@g.n0 Fragment fragment, @g.n0 String[] strArr, int i10) {
    }

    public boolean p(@g.n0 Fragment fragment) {
        return true;
    }

    public boolean q(@g.n0 String str) {
        return false;
    }

    public void r(@g.n0 Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i10) {
        s(fragment, intent, i10, null);
    }

    public void s(@g.n0 Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i10, @p0 Bundle bundle) {
        if (i10 != -1) {
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }
        h0.d.w(this.f6007b, intent, bundle);
    }

    @Deprecated
    public void u(@g.n0 Fragment fragment, @SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i10, @p0 Intent intent, int i11, int i12, int i13, @p0 Bundle bundle) throws IntentSender.SendIntentException {
        if (i10 != -1) {
            throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
        }
        f0.b.R(this.f6006a, intentSender, i10, intent, i11, i12, i13, bundle);
    }

    public void v() {
    }

    public l(@g.n0 g gVar) {
        this(gVar, gVar, new Handler(), 0);
    }

    public l(@p0 Activity activity, @g.n0 Context context, @g.n0 Handler handler, int i10) {
        this.f6010e = new v();
        this.f6006a = activity;
        this.f6007b = (Context) androidx.core.util.o.m(context, "context == null");
        this.f6008c = (Handler) androidx.core.util.o.m(handler, "handler == null");
        this.f6009d = i10;
    }
}
