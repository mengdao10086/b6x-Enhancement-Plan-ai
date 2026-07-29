package t1;

import android.media.VolumeProvider;
import android.os.Build;
import androidx.annotation.RestrictTo;
import g.p0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
public abstract class i {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f50849g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f50850h = 1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f50851i = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f50852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f50853b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f50854c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f50855d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c f50856e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public VolumeProvider f50857f;

    public class a extends VolumeProvider {
        public a(int i10, int i11, int i12, String str) {
            super(i10, i11, i12, str);
        }

        @Override // android.media.VolumeProvider
        public void onAdjustVolume(int i10) {
            i.this.f(i10);
        }

        @Override // android.media.VolumeProvider
        public void onSetVolumeTo(int i10) {
            i.this.g(i10);
        }
    }

    public class b extends VolumeProvider {
        public b(int i10, int i11, int i12) {
            super(i10, i11, i12);
        }

        @Override // android.media.VolumeProvider
        public void onAdjustVolume(int i10) {
            i.this.f(i10);
        }

        @Override // android.media.VolumeProvider
        public void onSetVolumeTo(int i10) {
            i.this.g(i10);
        }
    }

    public static abstract class c {
        public abstract void a(i iVar);
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface d {
    }

    public i(int i10, int i11, int i12) {
        this(i10, i11, i12, null);
    }

    public final int a() {
        return this.f50855d;
    }

    public final int b() {
        return this.f50853b;
    }

    public final int c() {
        return this.f50852a;
    }

    @p0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public final String d() {
        return this.f50854c;
    }

    public Object e() {
        if (this.f50857f == null) {
            if (Build.VERSION.SDK_INT >= 30) {
                this.f50857f = new a(this.f50852a, this.f50853b, this.f50855d, this.f50854c);
            } else {
                this.f50857f = new b(this.f50852a, this.f50853b, this.f50855d);
            }
        }
        return this.f50857f;
    }

    public void f(int i10) {
    }

    public void g(int i10) {
    }

    public void h(c cVar) {
        this.f50856e = cVar;
    }

    public final void i(int i10) {
        this.f50855d = i10;
        ((VolumeProvider) e()).setCurrentVolume(i10);
        c cVar = this.f50856e;
        if (cVar != null) {
            cVar.a(this);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public i(int i10, int i11, int i12, @p0 String str) {
        this.f50852a = i10;
        this.f50853b = i11;
        this.f50855d = i12;
        this.f50854c = str;
    }
}
