package t4;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;

/* JADX INFO: loaded from: classes2.dex */
public class c implements g<Drawable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f50867a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f50868b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f50869c;

    public static class a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f50870c = 300;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f50871a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f50872b;

        public a() {
            this(300);
        }

        public c a() {
            return new c(this.f50871a, this.f50872b);
        }

        public a b(boolean z10) {
            this.f50872b = z10;
            return this;
        }

        public a(int i10) {
            this.f50871a = i10;
        }
    }

    public c(int i10, boolean z10) {
        this.f50867a = i10;
        this.f50868b = z10;
    }

    @Override // t4.g
    public f<Drawable> a(DataSource dataSource, boolean z10) {
        return dataSource == DataSource.MEMORY_CACHE ? e.b() : b();
    }

    public final f<Drawable> b() {
        if (this.f50869c == null) {
            this.f50869c = new d(this.f50867a, this.f50868b);
        }
        return this.f50869c;
    }
}
