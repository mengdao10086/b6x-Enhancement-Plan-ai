package a;

import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class fe implements hf<ge> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f6096a;

    public fe(String str) {
        this.f6096a = str;
    }

    @Override // a.hf
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(ge geVar) {
        synchronized (he.f1157a) {
            ArrayList<hf<ge>> arrayList = he.f1156a.get(this.f6096a);
            if (arrayList == null) {
                return;
            }
            he.f1156a.remove(this.f6096a);
            for (int i = 0; i < arrayList.size(); i++) {
                arrayList.get(i).a(geVar);
            }
        }
    }
}
