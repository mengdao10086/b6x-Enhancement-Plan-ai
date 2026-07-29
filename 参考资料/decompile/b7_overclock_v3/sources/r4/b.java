package r4;

import com.bumptech.glide.load.ImageHeaderParser;
import g.n0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<ImageHeaderParser> f47727a = new ArrayList();

    public synchronized void a(@n0 ImageHeaderParser imageHeaderParser) {
        this.f47727a.add(imageHeaderParser);
    }

    @n0
    public synchronized List<ImageHeaderParser> b() {
        return this.f47727a;
    }
}
