package a;

import android.transition.Transition;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class qm implements Transition.TransitionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ sm f7221a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Object f2578a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ArrayList f2579a;
    public final /* synthetic */ Object b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final /* synthetic */ ArrayList f2580b;
    public final /* synthetic */ Object c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final /* synthetic */ ArrayList f2581c;

    public qm(sm smVar, Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
        this.f7221a = smVar;
        this.f2578a = obj;
        this.f2579a = arrayList;
        this.b = obj2;
        this.f2580b = arrayList2;
        this.c = obj3;
        this.f2581c = arrayList3;
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionCancel(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionEnd(Transition transition) {
        transition.removeListener(this);
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionPause(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionResume(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionStart(Transition transition) {
        Object obj = this.f2578a;
        if (obj != null) {
            this.f7221a.q(obj, this.f2579a, null);
        }
        Object obj2 = this.b;
        if (obj2 != null) {
            this.f7221a.q(obj2, this.f2580b, null);
        }
        Object obj3 = this.c;
        if (obj3 != null) {
            this.f7221a.q(obj3, this.f2581c, null);
        }
    }
}
