package a1;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.annotation.RestrictTo;
import g.n0;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends ClickableSpan {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final String f32d = "ACCESSIBILITY_CLICKABLE_SPAN_ID";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f33a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f34b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f35c;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public a(int i10, @n0 d dVar, int i11) {
        this.f33a = i10;
        this.f34b = dVar;
        this.f35c = i11;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(@n0 View view) {
        Bundle bundle = new Bundle();
        bundle.putInt(f32d, this.f33a);
        this.f34b.M0(this.f35c, bundle);
    }
}
