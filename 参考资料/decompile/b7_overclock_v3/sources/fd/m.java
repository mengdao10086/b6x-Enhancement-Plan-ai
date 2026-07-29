package fd;

import android.net.Uri;
import g.p0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f28117a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f28118b = new ArrayList();

    public static m h(m mVar, long j10) {
        return mVar.e(l.f28116c, j10);
    }

    public static m i(m mVar, @p0 Uri uri) {
        return uri == null ? mVar.d(l.f28115b) : mVar.f(l.f28115b, uri.toString());
    }

    public final m a(String str, Object obj) {
        this.f28117a.put((String) hd.a.g(str), hd.a.g(obj));
        this.f28118b.remove(str);
        return this;
    }

    public Map<String, Object> b() {
        HashMap map = new HashMap(this.f28117a);
        for (Map.Entry entry : map.entrySet()) {
            Object value = entry.getValue();
            if (value instanceof byte[]) {
                byte[] bArr = (byte[]) value;
                entry.setValue(Arrays.copyOf(bArr, bArr.length));
            }
        }
        return Collections.unmodifiableMap(map);
    }

    public List<String> c() {
        return Collections.unmodifiableList(new ArrayList(this.f28118b));
    }

    public m d(String str) {
        this.f28118b.add(str);
        this.f28117a.remove(str);
        return this;
    }

    public m e(String str, long j10) {
        return a(str, Long.valueOf(j10));
    }

    public m f(String str, String str2) {
        return a(str, str2);
    }

    public m g(String str, byte[] bArr) {
        return a(str, Arrays.copyOf(bArr, bArr.length));
    }
}
