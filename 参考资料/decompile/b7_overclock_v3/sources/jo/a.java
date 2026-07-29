package jo;

import cs.o;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.bouncycastle.cert.dane.DANEException;

/* JADX INFO: loaded from: classes5.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f36522a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f36523b;

    public a(e eVar, o oVar) {
        this.f36522a = eVar;
        this.f36523b = new g(oVar);
    }

    public List a(String str) throws DANEException {
        f fVarA = this.f36523b.a(str);
        List<b> listA = this.f36522a.a(fVarA.a()).a();
        ArrayList arrayList = new ArrayList(listA.size());
        for (b bVar : listA) {
            if (fVarA.M(bVar)) {
                arrayList.add(bVar.a());
            }
        }
        return Collections.unmodifiableList(arrayList);
    }
}
