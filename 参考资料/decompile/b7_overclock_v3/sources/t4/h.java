package t4;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.bumptech.glide.load.DataSource;
import t4.k;

/* JADX INFO: loaded from: classes2.dex */
public class h<R> implements g<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k.a f50877a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f<R> f50878b;

    public static class a implements k.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Animation f50879a;

        public a(Animation animation) {
            this.f50879a = animation;
        }

        @Override // t4.k.a
        public Animation a(Context context) {
            return this.f50879a;
        }
    }

    public static class b implements k.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f50880a;

        public b(int i10) {
            this.f50880a = i10;
        }

        @Override // t4.k.a
        public Animation a(Context context) {
            return AnimationUtils.loadAnimation(context, this.f50880a);
        }
    }

    public h(Animation animation) {
        this(new a(animation));
    }

    @Override // t4.g
    public f<R> a(DataSource dataSource, boolean z10) {
        if (dataSource == DataSource.MEMORY_CACHE || !z10) {
            return e.b();
        }
        if (this.f50878b == null) {
            this.f50878b = new k(this.f50877a);
        }
        return this.f50878b;
    }

    public h(int i10) {
        this(new b(i10));
    }

    public h(k.a aVar) {
        this.f50877a = aVar;
    }
}
