package ie;

import android.graphics.Typeface;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class a extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Typeface f32309a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC0379a f32310b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f32311c;

    /* JADX INFO: renamed from: ie.a$a, reason: collision with other inner class name */
    public interface InterfaceC0379a {
        void a(Typeface typeface);
    }

    public a(InterfaceC0379a interfaceC0379a, Typeface typeface) {
        this.f32309a = typeface;
        this.f32310b = interfaceC0379a;
    }

    @Override // ie.f
    public void a(int i10) {
        d(this.f32309a);
    }

    @Override // ie.f
    public void b(Typeface typeface, boolean z10) {
        d(typeface);
    }

    public void c() {
        this.f32311c = true;
    }

    public final void d(Typeface typeface) {
        if (this.f32311c) {
            return;
        }
        this.f32310b.a(typeface);
    }
}
