package xa;

import com.github.mikephil.charting.data.Entry;
import java.util.Comparator;

/* JADX INFO: loaded from: classes3.dex */
public class b implements Comparator<Entry> {
    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(Entry entry, Entry entry2) {
        float F = entry.F() - entry2.F();
        if (F == 0.0f) {
            return 0;
        }
        return F > 0.0f ? 1 : -1;
    }
}
