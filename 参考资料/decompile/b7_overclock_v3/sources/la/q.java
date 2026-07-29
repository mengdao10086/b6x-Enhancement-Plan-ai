package la;

import com.github.mikephil.charting.data.Entry;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class q extends k<qa.j> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List<String> f39521j;

    public q() {
    }

    public List<String> Q() {
        return this.f39521j;
    }

    public void R(List<String> list) {
        this.f39521j = list;
    }

    public void S(String... strArr) {
        this.f39521j = Arrays.asList(strArr);
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.github.mikephil.charting.data.Entry] */
    @Override // la.k
    public Entry s(oa.d dVar) {
        return k(dVar.d()).Z((int) dVar.h());
    }

    public q(List<qa.j> list) {
        super(list);
    }

    public q(qa.j... jVarArr) {
        super(jVarArr);
    }
}
