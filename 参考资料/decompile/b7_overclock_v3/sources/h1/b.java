package h1;

import android.annotation.SuppressLint;
import android.text.Editable;
import androidx.emoji2.text.p;
import g.b0;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends Editable.Factory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f30200a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @b0("INSTANCE_LOCK")
    public static volatile Editable.Factory f30201b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @p0
    public static Class<?> f30202c;

    @SuppressLint({"PrivateApi"})
    public b() {
        try {
            f30202c = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, b.class.getClassLoader());
        } catch (Throwable unused) {
        }
    }

    public static Editable.Factory getInstance() {
        if (f30201b == null) {
            synchronized (f30200a) {
                if (f30201b == null) {
                    f30201b = new b();
                }
            }
        }
        return f30201b;
    }

    @Override // android.text.Editable.Factory
    public Editable newEditable(@n0 CharSequence charSequence) {
        Class<?> cls = f30202c;
        return cls != null ? p.c(cls, charSequence) : super.newEditable(charSequence);
    }
}
