package a;

import a.hn;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.ComponentCallbacks2;
import android.os.Bundle;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class un extends Fragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public tn f7614a;

    public static void e(Activity activity) {
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
            fragmentManager.beginTransaction().add(new un(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
            fragmentManager.executePendingTransactions();
        }
    }

    public final void a(hn.a aVar) {
        ComponentCallbacks2 activity = getActivity();
        if (activity instanceof kn) {
            hn lifecycle = ((kn) activity).getLifecycle();
            if (lifecycle instanceof nn) {
                ((nn) lifecycle).i(aVar);
            }
        }
    }

    public final void b(tn tnVar) {
        if (tnVar != null) {
            tnVar.b();
        }
    }

    public final void c(tn tnVar) {
        if (tnVar != null) {
            tnVar.a();
        }
    }

    public final void d(tn tnVar) {
        if (tnVar != null) {
            tnVar.c();
        }
    }

    @Override // android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        b(this.f7614a);
        a(hn.a.ON_CREATE);
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        a(hn.a.ON_DESTROY);
        this.f7614a = null;
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        a(hn.a.ON_PAUSE);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        c(this.f7614a);
        a(hn.a.ON_RESUME);
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        d(this.f7614a);
        a(hn.a.ON_START);
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        a(hn.a.ON_STOP);
    }
}
