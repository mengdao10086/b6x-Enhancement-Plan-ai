package androidx.savedstate;

import a.hn;
import a.i9;
import a.in;
import a.kn;
import a.nq;
import a.pq;
import android.annotation.SuppressLint;
import android.os.Bundle;
import java.util.Map;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@SuppressLint({"RestrictedApi"})
public final class SavedStateRegistry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public i9<String, nq> f8250a = new i9<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Bundle f4450a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f4451a;
    public boolean b;

    public interface a {
        void a(pq pqVar);
    }

    public Bundle a(String str) {
        if (!this.f4451a) {
            throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
        }
        Bundle bundle = this.f4450a;
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = bundle.getBundle(str);
        this.f4450a.remove(str);
        if (this.f4450a.isEmpty()) {
            this.f4450a = null;
        }
        return bundle2;
    }

    public void b(hn hnVar, Bundle bundle) {
        if (this.f4451a) {
            throw new IllegalStateException("SavedStateRegistry was already restored.");
        }
        if (bundle != null) {
            this.f4450a = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
        }
        hnVar.a(new in() { // from class: androidx.savedstate.SavedStateRegistry.1
            @Override // a.in
            public void a(kn knVar, hn.a aVar) {
                SavedStateRegistry savedStateRegistry;
                boolean z;
                if (aVar == hn.a.ON_START) {
                    savedStateRegistry = SavedStateRegistry.this;
                    z = true;
                } else {
                    if (aVar != hn.a.ON_STOP) {
                        return;
                    }
                    savedStateRegistry = SavedStateRegistry.this;
                    z = false;
                }
                savedStateRegistry.b = z;
            }
        });
        this.f4451a = true;
    }

    public void c(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = this.f4450a;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        i9<String, nq>.a aVarD = this.f8250a.d();
        while (aVarD.hasNext()) {
            Map.Entry next = aVarD.next();
            bundle2.putBundle((String) next.getKey(), ((nq) next.getValue()).a());
        }
        bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
    }
}
