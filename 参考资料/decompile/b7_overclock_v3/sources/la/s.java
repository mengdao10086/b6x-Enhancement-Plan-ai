package la;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class s extends c<qa.k> {
    public s() {
    }

    public float Q() {
        Iterator it2 = this.f39513i.iterator();
        float f10 = 0.0f;
        while (it2.hasNext()) {
            float fR0 = ((qa.k) it2.next()).r0();
            if (fR0 > f10) {
                f10 = fR0;
            }
        }
        return f10;
    }

    public s(List<qa.k> list) {
        super(list);
    }

    public s(qa.k... kVarArr) {
        super(kVarArr);
    }
}
