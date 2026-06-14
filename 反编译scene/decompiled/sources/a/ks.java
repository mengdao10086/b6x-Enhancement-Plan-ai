package a;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class ks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f6635a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Map<String, Object> f1686a = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ArrayList<as> f1685a = new ArrayList<>();

    public ks(View view) {
        this.f6635a = view;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ks)) {
            return false;
        }
        ks ksVar = (ks) obj;
        return this.f6635a == ksVar.f6635a && this.f1686a.equals(ksVar.f1686a);
    }

    public int hashCode() {
        return (this.f6635a.hashCode() * 31) + this.f1686a.hashCode();
    }

    public String toString() {
        String str = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.f6635a + "\n") + "    values:";
        for (String str2 : this.f1686a.keySet()) {
            str = str + "    " + str2 + ": " + this.f1686a.get(str2) + "\n";
        }
        return str;
    }
}
