package la;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class g extends c<qa.c> {
    public g() {
    }

    public void Q(float f10) {
        Iterator it2 = this.f39513i.iterator();
        while (it2.hasNext()) {
            ((qa.c) it2.next()).i0(f10);
        }
    }

    public g(qa.c... cVarArr) {
        super(cVarArr);
    }

    public g(List<qa.c> list) {
        super(list);
    }
}
