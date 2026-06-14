package a;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.util.StateSet;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class xx {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ArrayList<wx> f3629a = new ArrayList<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wx f7926a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ValueAnimator f3628a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Animator.AnimatorListener f3627a = new vx(this);

    public void a(int[] iArr, ValueAnimator valueAnimator) {
        wx wxVar = new wx(iArr, valueAnimator);
        valueAnimator.addListener(this.f3627a);
        this.f3629a.add(wxVar);
    }

    public final void b() {
        ValueAnimator valueAnimator = this.f3628a;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f3628a = null;
        }
    }

    public void c() {
        ValueAnimator valueAnimator = this.f3628a;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.f3628a = null;
        }
    }

    public void d(int[] iArr) {
        wx wxVar;
        int size = this.f3629a.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                wxVar = null;
                break;
            }
            wxVar = this.f3629a.get(i);
            if (StateSet.stateSetMatches(wxVar.f3489a, iArr)) {
                break;
            } else {
                i++;
            }
        }
        wx wxVar2 = this.f7926a;
        if (wxVar == wxVar2) {
            return;
        }
        if (wxVar2 != null) {
            b();
        }
        this.f7926a = wxVar;
        if (wxVar != null) {
            e(wxVar);
        }
    }

    public final void e(wx wxVar) {
        ValueAnimator valueAnimator = wxVar.f7831a;
        this.f3628a = valueAnimator;
        valueAnimator.start();
    }
}
