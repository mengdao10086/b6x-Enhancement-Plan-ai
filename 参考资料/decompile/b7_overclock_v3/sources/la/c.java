package la;

import com.github.mikephil.charting.data.Entry;
import java.util.List;
import qa.b;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c<T extends qa.b<? extends Entry>> extends k<T> {
    public c() {
    }

    public c(T... tArr) {
        super(tArr);
    }

    public c(List<T> list) {
        super(list);
    }
}
