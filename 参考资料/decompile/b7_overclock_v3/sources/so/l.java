package so;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class l extends a0 {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public d f50213y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public d f50214z;

    public Map d(gm.y yVar, zn.b bVar, zn.b bVar2, byte[] bArr) {
        HashMap map = new HashMap();
        map.put(d.f50127a, yVar);
        map.put(d.f50130d, bVar);
        map.put(d.f50128b, org.bouncycastle.util.a.p(bArr));
        map.put(d.f50131e, bVar2);
        return map;
    }

    public void e(d dVar) {
        this.f50213y = dVar;
    }

    public void f(d dVar) {
        this.f50214z = dVar;
    }
}
