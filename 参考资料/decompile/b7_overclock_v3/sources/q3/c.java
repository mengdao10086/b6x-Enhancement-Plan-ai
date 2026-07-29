package q3;

import android.app.Fragment;

/* JADX INFO: loaded from: classes2.dex */
public class c extends Fragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f47113a;

    public void a(a aVar) {
        this.f47113a = aVar;
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        t3.a.a("onDestroy: ");
        a aVar = this.f47113a;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        a aVar = this.f47113a;
        if (aVar != null) {
            aVar.d();
        }
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        t3.a.a("onStart: ");
        a aVar = this.f47113a;
        if (aVar != null) {
            aVar.b();
        }
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        a aVar = this.f47113a;
        if (aVar != null) {
            aVar.c();
        }
    }
}
