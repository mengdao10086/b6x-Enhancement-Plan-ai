package t4;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;
import t4.f;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a<R> implements g<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g<Drawable> f50864a;

    /* JADX INFO: renamed from: t4.a$a, reason: collision with other inner class name */
    public final class C0577a implements f<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f<Drawable> f50865a;

        public C0577a(f<Drawable> fVar) {
            this.f50865a = fVar;
        }

        @Override // t4.f
        public boolean a(R r10, f.a aVar) {
            return this.f50865a.a(new BitmapDrawable(aVar.getView().getResources(), a.this.b(r10)), aVar);
        }
    }

    public a(g<Drawable> gVar) {
        this.f50864a = gVar;
    }

    @Override // t4.g
    public f<R> a(DataSource dataSource, boolean z10) {
        return new C0577a(this.f50864a.a(dataSource, z10));
    }

    public abstract Bitmap b(R r10);
}
