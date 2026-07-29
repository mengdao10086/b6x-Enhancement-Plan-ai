package hb;

import android.net.Uri;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f30894a = new q() { // from class: hb.o
        @Override // hb.q
        public final k[] a() {
            return p.b();
        }

        @Override // hb.q
        public /* synthetic */ k[] b(Uri uri, Map map) {
            return p.a(this, uri, map);
        }
    };

    k[] a();

    k[] b(Uri uri, Map<String, List<String>> map);
}
