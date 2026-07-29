package sr;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public abstract class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f50412a;

    public m(e eVar) {
        this.f50412a = eVar;
    }

    public static List<String> c(Map<String, String> map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (String str : map.keySet()) {
            arrayList.add(str + ": " + map.get(str));
        }
        return arrayList;
    }

    public abstract OutputStream a() throws IOException;

    public e b() {
        return this.f50412a;
    }
}
