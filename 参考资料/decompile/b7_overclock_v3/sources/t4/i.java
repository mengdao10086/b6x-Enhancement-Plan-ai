package t4;

import com.bumptech.glide.load.DataSource;
import t4.j;

/* JADX INFO: loaded from: classes2.dex */
public class i<R> implements g<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j.a f50881a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public j<R> f50882b;

    public i(j.a aVar) {
        this.f50881a = aVar;
    }

    @Override // t4.g
    public f<R> a(DataSource dataSource, boolean z10) {
        if (dataSource == DataSource.MEMORY_CACHE || !z10) {
            return e.b();
        }
        if (this.f50882b == null) {
            this.f50882b = new j<>(this.f50881a);
        }
        return this.f50882b;
    }
}
