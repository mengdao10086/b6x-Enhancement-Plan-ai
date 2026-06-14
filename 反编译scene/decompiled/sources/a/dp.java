package a;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class dp implements RecyclerView.s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ np f5923a;

    public dp(np npVar) {
        this.f5923a = npVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    public void a(boolean z) {
        if (z) {
            this.f5923a.E(null, 0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    public boolean c(RecyclerView recyclerView, MotionEvent motionEvent) {
        int iFindPointerIndex;
        mp mpVarR;
        this.f5923a.f2132a.a(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f5923a.f2130a = motionEvent.getPointerId(0);
            this.f5923a.f6939a = motionEvent.getX();
            this.f5923a.b = motionEvent.getY();
            this.f5923a.z();
            np npVar = this.f5923a;
            if (npVar.f2138a == null && (mpVarR = npVar.r(motionEvent)) != null) {
                np npVar2 = this.f5923a;
                npVar2.f6939a -= mpVarR.e;
                npVar2.b -= mpVarR.f;
                npVar2.q(mpVarR.f1973a, true);
                if (this.f5923a.f2143a.remove(mpVarR.f1973a.f4387a)) {
                    np npVar3 = this.f5923a;
                    npVar3.f2133a.c(npVar3.f2141a, mpVarR.f1973a);
                }
                this.f5923a.E(mpVarR.f1973a, mpVarR.f1971a);
                np npVar4 = this.f5923a;
                npVar4.J(motionEvent, npVar4.f2147c, 0);
            }
        } else if (actionMasked == 3 || actionMasked == 1) {
            np npVar5 = this.f5923a;
            npVar5.f2130a = -1;
            npVar5.E(null, 0);
        } else {
            int i = this.f5923a.f2130a;
            if (i != -1 && (iFindPointerIndex = motionEvent.findPointerIndex(i)) >= 0) {
                this.f5923a.n(actionMasked, motionEvent, iFindPointerIndex);
            }
        }
        VelocityTracker velocityTracker = this.f5923a.f2136a;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        return this.f5923a.f2138a != null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    public void d(RecyclerView recyclerView, MotionEvent motionEvent) {
        this.f5923a.f2132a.a(motionEvent);
        VelocityTracker velocityTracker = this.f5923a.f2136a;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        if (this.f5923a.f2130a == -1) {
            return;
        }
        int actionMasked = motionEvent.getActionMasked();
        int iFindPointerIndex = motionEvent.findPointerIndex(this.f5923a.f2130a);
        if (iFindPointerIndex >= 0) {
            this.f5923a.n(actionMasked, motionEvent, iFindPointerIndex);
        }
        np npVar = this.f5923a;
        RecyclerView.d0 d0Var = npVar.f2138a;
        if (d0Var == null) {
            return;
        }
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                if (iFindPointerIndex >= 0) {
                    npVar.J(motionEvent, npVar.f2147c, iFindPointerIndex);
                    this.f5923a.y(d0Var);
                    np npVar2 = this.f5923a;
                    npVar2.f2141a.removeCallbacks(npVar2.f2142a);
                    this.f5923a.f2142a.run();
                    this.f5923a.f2141a.invalidate();
                    return;
                }
                return;
            }
            if (actionMasked != 3) {
                if (actionMasked != 6) {
                    return;
                }
                int actionIndex = motionEvent.getActionIndex();
                if (motionEvent.getPointerId(actionIndex) == this.f5923a.f2130a) {
                    this.f5923a.f2130a = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
                    np npVar3 = this.f5923a;
                    npVar3.J(motionEvent, npVar3.f2147c, actionIndex);
                    return;
                }
                return;
            }
            VelocityTracker velocityTracker2 = npVar.f2136a;
            if (velocityTracker2 != null) {
                velocityTracker2.clear();
            }
        }
        this.f5923a.E(null, 0);
        this.f5923a.f2130a = -1;
    }
}
