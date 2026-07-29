package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.R;
import com.blankj.utilcode.util.i0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class t {
    public static final int A = -1;
    public static final int B = -2;
    public static final int C = -1;
    public static final int D = 0;
    public static final int E = 1;
    public static final int F = 2;
    public static final String G = "MotionScene";
    public static final String H = "Transition";
    public static final String I = "OnSwipe";
    public static final String J = "OnClick";
    public static final String K = "StateSet";
    public static final String L = "Include";
    public static final String M = "include";
    public static final String N = "KeyFrameSet";
    public static final String O = "ConstraintSet";
    public static final String P = "ViewTransition";
    public static final int Q = 0;
    public static final int R = 1;
    public static final int S = 2;
    public static final int T = 3;
    public static final int U = 4;
    public static final int V = 5;
    public static final int W = 6;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f3901v = "MotionScene";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final boolean f3902w = false;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f3903x = 8;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f3904y = 0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f3905z = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MotionLayout f3906a;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public MotionEvent f3919n;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public MotionLayout.i f3922q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f3923r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final b0 f3924s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f3925t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f3926u;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public androidx.constraintlayout.widget.j f3907b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f3908c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f3909d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ArrayList<b> f3910e = new ArrayList<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b f3911f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ArrayList<b> f3912g = new ArrayList<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public SparseArray<androidx.constraintlayout.widget.d> f3913h = new SparseArray<>();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public HashMap<String, Integer> f3914i = new HashMap<>();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public SparseIntArray f3915j = new SparseIntArray();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f3916k = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f3917l = 400;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f3918m = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f3920o = false;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f3921p = false;

    public class a implements Interpolator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ w.d f3927a;

        public a(final t this$0, final w.d val$easing) {
            this.f3927a = val$easing;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float v10) {
            return (float) this.f3927a.a(v10);
        }
    }

    public t(MotionLayout layout) {
        this.f3906a = layout;
        this.f3924s = new b0(layout);
    }

    public static String A(Context context, int resourceId, XmlPullParser pullParser) {
        return ".(" + c.i(context, resourceId) + ".xml:" + pullParser.getLineNumber() + ") \"" + pullParser.getName() + "\"";
    }

    public static String q0(String id2) {
        if (id2 == null) {
            return "";
        }
        int iIndexOf = id2.indexOf(47);
        return iIndexOf < 0 ? id2 : id2.substring(iIndexOf + 1);
    }

    public float B() {
        b bVar = this.f3908c;
        if (bVar == null || bVar.f3947l == null) {
            return 0.0f;
        }
        return this.f3908c.f3947l.i();
    }

    public float C() {
        b bVar = this.f3908c;
        if (bVar == null || bVar.f3947l == null) {
            return 0.0f;
        }
        return this.f3908c.f3947l.j();
    }

    public boolean D() {
        b bVar = this.f3908c;
        if (bVar == null || bVar.f3947l == null) {
            return false;
        }
        return this.f3908c.f3947l.k();
    }

    public float E(View view, int position) {
        return 0.0f;
    }

    public float F(float dx, float dy) {
        b bVar = this.f3908c;
        if (bVar == null || bVar.f3947l == null) {
            return 0.0f;
        }
        return this.f3908c.f3947l.l(dx, dy);
    }

    public final int G(int stateId) {
        int iE;
        androidx.constraintlayout.widget.j jVar = this.f3907b;
        return (jVar == null || (iE = jVar.e(stateId, -1, -1)) == -1) ? stateId : iE;
    }

    public int H() {
        b bVar = this.f3908c;
        if (bVar == null || bVar.f3947l == null) {
            return 0;
        }
        return this.f3908c.f3947l.m();
    }

    public float I() {
        b bVar = this.f3908c;
        if (bVar == null || bVar.f3947l == null) {
            return 0.0f;
        }
        return this.f3908c.f3947l.n();
    }

    public float J() {
        b bVar = this.f3908c;
        if (bVar == null || bVar.f3947l == null) {
            return 0.0f;
        }
        return this.f3908c.f3947l.o();
    }

    public float K() {
        b bVar = this.f3908c;
        if (bVar == null || bVar.f3947l == null) {
            return 0.0f;
        }
        return this.f3908c.f3947l.p();
    }

    public float L() {
        b bVar = this.f3908c;
        if (bVar == null || bVar.f3947l == null) {
            return 0.0f;
        }
        return this.f3908c.f3947l.q();
    }

    public float M() {
        b bVar = this.f3908c;
        if (bVar != null) {
            return bVar.f3944i;
        }
        return 0.0f;
    }

    public int N() {
        b bVar = this.f3908c;
        if (bVar == null) {
            return -1;
        }
        return bVar.f3939d;
    }

    public b O(int id2) {
        for (b bVar : this.f3910e) {
            if (bVar.f3936a == id2) {
                return bVar;
            }
        }
        return null;
    }

    public int P(int stateId) {
        Iterator<b> it2 = this.f3910e.iterator();
        while (it2.hasNext()) {
            if (it2.next().f3939d == stateId) {
                return 0;
            }
        }
        return 1;
    }

    public List<b> Q(int stateId) {
        int iG = G(stateId);
        ArrayList arrayList = new ArrayList();
        for (b bVar : this.f3910e) {
            if (bVar.f3939d == iG || bVar.f3938c == iG) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    public final boolean R(int key) {
        int i10 = this.f3915j.get(key);
        int size = this.f3915j.size();
        while (i10 > 0) {
            if (i10 == key) {
                return true;
            }
            int i11 = size - 1;
            if (size < 0) {
                return true;
            }
            i10 = this.f3915j.get(i10);
            size = i11;
        }
        return false;
    }

    public boolean S(View view, int position) {
        b bVar = this.f3908c;
        if (bVar == null) {
            return false;
        }
        Iterator it2 = bVar.f3946k.iterator();
        while (it2.hasNext()) {
            Iterator<f> it3 = ((i) it2.next()).d(view.getId()).iterator();
            while (it3.hasNext()) {
                if (it3.next().f3665a == position) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean T() {
        return this.f3922q != null;
    }

    public boolean U(int id2) {
        return this.f3924s.h(id2);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void V(android.content.Context r9, int r10) {
        /*
            Method dump skipped, instruction units count: 432
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.t.V(android.content.Context, int):void");
    }

    public int W(String id2) {
        Integer num = this.f3914i.get(id2);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public String X(int id2) {
        for (Map.Entry<String, Integer> entry : this.f3914i.entrySet()) {
            Integer value = entry.getValue();
            if (value != null && value.intValue() == id2) {
                return entry.getKey();
            }
        }
        return null;
    }

    public void Y(boolean changed, int left, int top2, int right, int bottom) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0096  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int Z(android.content.Context r14, org.xmlpull.v1.XmlPullParser r15) {
        /*
            Method dump skipped, instruction units count: 320
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.t.Z(android.content.Context, org.xmlpull.v1.XmlPullParser):int");
    }

    public final int a0(Context context, int resourceId) {
        XmlResourceParser xml = context.getResources().getXml(resourceId);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                String name = xml.getName();
                if (2 == eventType && "ConstraintSet".equals(name)) {
                    return Z(context, xml);
                }
            }
            return -1;
        } catch (IOException e10) {
            e10.printStackTrace();
            return -1;
        } catch (XmlPullParserException e11) {
            e11.printStackTrace();
            return -1;
        }
    }

    public final void b0(Context context, XmlPullParser mainParser) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(mainParser), R.styleable.include);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i10 = 0; i10 < indexCount; i10++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i10);
            if (index == R.styleable.include_constraintSet) {
                a0(context, typedArrayObtainStyledAttributes.getResourceId(index, -1));
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void c0(Context context, XmlPullParser parser) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(parser), R.styleable.MotionScene);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i10 = 0; i10 < indexCount; i10++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i10);
            if (index == R.styleable.MotionScene_defaultDuration) {
                int i11 = typedArrayObtainStyledAttributes.getInt(index, this.f3917l);
                this.f3917l = i11;
                if (i11 < 8) {
                    this.f3917l = 8;
                }
            } else if (index == R.styleable.MotionScene_layoutDuringTransition) {
                this.f3918m = typedArrayObtainStyledAttributes.getInteger(index, 0);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public void d0(float dx, float dy) {
        b bVar = this.f3908c;
        if (bVar == null || bVar.f3947l == null) {
            return;
        }
        this.f3908c.f3947l.w(dx, dy);
    }

    public void e0(float dx, float dy) {
        b bVar = this.f3908c;
        if (bVar == null || bVar.f3947l == null) {
            return;
        }
        this.f3908c.f3947l.x(dx, dy);
    }

    public void f(MotionLayout motionLayout, int currentState) {
        for (b bVar : this.f3910e) {
            if (bVar.f3948m.size() > 0) {
                Iterator it2 = bVar.f3948m.iterator();
                while (it2.hasNext()) {
                    ((b.a) it2.next()).c(motionLayout);
                }
            }
        }
        for (b bVar2 : this.f3912g) {
            if (bVar2.f3948m.size() > 0) {
                Iterator it3 = bVar2.f3948m.iterator();
                while (it3.hasNext()) {
                    ((b.a) it3.next()).c(motionLayout);
                }
            }
        }
        for (b bVar3 : this.f3910e) {
            if (bVar3.f3948m.size() > 0) {
                Iterator it4 = bVar3.f3948m.iterator();
                while (it4.hasNext()) {
                    ((b.a) it4.next()).a(motionLayout, currentState, bVar3);
                }
            }
        }
        for (b bVar4 : this.f3912g) {
            if (bVar4.f3948m.size() > 0) {
                Iterator it5 = bVar4.f3948m.iterator();
                while (it5.hasNext()) {
                    ((b.a) it5.next()).a(motionLayout, currentState, bVar4);
                }
            }
        }
    }

    public void f0(MotionEvent event, int currentState, MotionLayout motionLayout) {
        MotionLayout.i iVar;
        MotionEvent motionEvent;
        RectF rectF = new RectF();
        if (this.f3922q == null) {
            this.f3922q = this.f3906a.V0();
        }
        this.f3922q.e(event);
        if (currentState != -1) {
            int action = event.getAction();
            boolean z10 = false;
            if (action == 0) {
                this.f3925t = event.getRawX();
                this.f3926u = event.getRawY();
                this.f3919n = event;
                this.f3920o = false;
                if (this.f3908c.f3947l != null) {
                    RectF rectFG = this.f3908c.f3947l.g(this.f3906a, rectF);
                    if (rectFG != null && !rectFG.contains(this.f3919n.getX(), this.f3919n.getY())) {
                        this.f3919n = null;
                        this.f3920o = true;
                        return;
                    }
                    RectF rectFR = this.f3908c.f3947l.r(this.f3906a, rectF);
                    if (rectFR == null || rectFR.contains(this.f3919n.getX(), this.f3919n.getY())) {
                        this.f3921p = false;
                    } else {
                        this.f3921p = true;
                    }
                    this.f3908c.f3947l.A(this.f3925t, this.f3926u);
                    return;
                }
                return;
            }
            if (action == 2 && !this.f3920o) {
                float rawY = event.getRawY() - this.f3926u;
                float rawX = event.getRawX() - this.f3925t;
                if ((rawX == 0.0d && rawY == 0.0d) || (motionEvent = this.f3919n) == null) {
                    return;
                }
                b bVarJ = j(currentState, rawX, rawY, motionEvent);
                if (bVarJ != null) {
                    motionLayout.setTransition(bVarJ);
                    RectF rectFR2 = this.f3908c.f3947l.r(this.f3906a, rectF);
                    if (rectFR2 != null && !rectFR2.contains(this.f3919n.getX(), this.f3919n.getY())) {
                        z10 = true;
                    }
                    this.f3921p = z10;
                    this.f3908c.f3947l.G(this.f3925t, this.f3926u);
                }
            }
        }
        if (this.f3920o) {
            return;
        }
        b bVar = this.f3908c;
        if (bVar != null && bVar.f3947l != null && !this.f3921p) {
            this.f3908c.f3947l.u(event, this.f3922q, currentState, this);
        }
        this.f3925t = event.getRawX();
        this.f3926u = event.getRawY();
        if (event.getAction() != 1 || (iVar = this.f3922q) == null) {
            return;
        }
        iVar.a();
        this.f3922q = null;
        int i10 = motionLayout.E7;
        if (i10 != -1) {
            i(motionLayout, i10);
        }
    }

    public void g(b transition) {
        int iW = w(transition);
        if (iW == -1) {
            this.f3910e.add(transition);
        } else {
            this.f3910e.set(iW, transition);
        }
    }

    public final void g0(int key, MotionLayout motionLayout) {
        androidx.constraintlayout.widget.d dVar = this.f3913h.get(key);
        dVar.f4286c = dVar.f4285b;
        int i10 = this.f3915j.get(key);
        if (i10 > 0) {
            g0(i10, motionLayout);
            androidx.constraintlayout.widget.d dVar2 = this.f3913h.get(i10);
            if (dVar2 == null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("ERROR! invalid deriveConstraintsFrom: @id/");
                sb2.append(c.i(this.f3906a.getContext(), i10));
                return;
            } else {
                dVar.f4286c += fh.a.f28350w + dVar2.f4286c;
                dVar.J0(dVar2);
            }
        } else {
            dVar.f4286c += "  layout";
            dVar.I0(motionLayout);
        }
        dVar.q(dVar);
    }

    public boolean h(int viewTransitionId, o motionController) {
        return this.f3924s.e(viewTransitionId, motionController);
    }

    public void h0(MotionLayout motionLayout) {
        for (int i10 = 0; i10 < this.f3913h.size(); i10++) {
            int iKeyAt = this.f3913h.keyAt(i10);
            if (R(iKeyAt)) {
                return;
            }
            g0(iKeyAt, motionLayout);
        }
    }

    public boolean i(MotionLayout motionLayout, int currentState) {
        b bVar;
        if (T() || this.f3909d) {
            return false;
        }
        for (b bVar2 : this.f3910e) {
            if (bVar2.f3949n != 0 && ((bVar = this.f3908c) != bVar2 || !bVar.L(2))) {
                if (currentState == bVar2.f3939d && (bVar2.f3949n == 4 || bVar2.f3949n == 2)) {
                    MotionLayout.TransitionState transitionState = MotionLayout.TransitionState.FINISHED;
                    motionLayout.setState(transitionState);
                    motionLayout.setTransition(bVar2);
                    if (bVar2.f3949n == 4) {
                        motionLayout.j1();
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                    } else {
                        motionLayout.setProgress(1.0f);
                        motionLayout.A0(true);
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                        motionLayout.setState(transitionState);
                        motionLayout.W0();
                    }
                    return true;
                }
                if (currentState == bVar2.f3938c && (bVar2.f3949n == 3 || bVar2.f3949n == 1)) {
                    MotionLayout.TransitionState transitionState2 = MotionLayout.TransitionState.FINISHED;
                    motionLayout.setState(transitionState2);
                    motionLayout.setTransition(bVar2);
                    if (bVar2.f3949n == 3) {
                        motionLayout.l1();
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                    } else {
                        motionLayout.setProgress(0.0f);
                        motionLayout.A0(true);
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                        motionLayout.setState(transitionState2);
                        motionLayout.W0();
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public void i0(b transition) {
        int iW = w(transition);
        if (iW != -1) {
            this.f3910e.remove(iW);
        }
    }

    public b j(int currentState, float dx, float dy, MotionEvent lastTouchDown) {
        if (currentState == -1) {
            return this.f3908c;
        }
        List<b> listQ = Q(currentState);
        float f10 = 0.0f;
        b bVar = null;
        RectF rectF = new RectF();
        for (b bVar2 : listQ) {
            if (!bVar2.f3950o && bVar2.f3947l != null) {
                bVar2.f3947l.D(this.f3923r);
                RectF rectFR = bVar2.f3947l.r(this.f3906a, rectF);
                if (rectFR == null || lastTouchDown == null || rectFR.contains(lastTouchDown.getX(), lastTouchDown.getY())) {
                    RectF rectFG = bVar2.f3947l.g(this.f3906a, rectF);
                    if (rectFG == null || lastTouchDown == null || rectFG.contains(lastTouchDown.getX(), lastTouchDown.getY())) {
                        float fA = bVar2.f3947l.a(dx, dy);
                        if (bVar2.f3947l.f4003l && lastTouchDown != null) {
                            fA = ((float) (Math.atan2(dy + r10, dx + r9) - Math.atan2(lastTouchDown.getX() - bVar2.f3947l.f4000i, lastTouchDown.getY() - bVar2.f3947l.f4001j))) * 10.0f;
                        }
                        float f11 = fA * (bVar2.f3938c == currentState ? -1.0f : 1.1f);
                        if (f11 > f10) {
                            bVar = bVar2;
                            f10 = f11;
                        }
                    }
                }
            }
        }
        return bVar;
    }

    public void j0(int id2, androidx.constraintlayout.widget.d set) {
        this.f3913h.put(id2, set);
    }

    public void k(boolean disable) {
        this.f3909d = disable;
    }

    public void k0(int duration) {
        b bVar = this.f3908c;
        if (bVar != null) {
            bVar.O(duration);
        } else {
            this.f3917l = duration;
        }
    }

    public void l(int id2, boolean enable) {
        this.f3924s.f(id2, enable);
    }

    public void l0(View view, int position, String name, Object value) {
        b bVar = this.f3908c;
        if (bVar == null) {
            return;
        }
        Iterator it2 = bVar.f3946k.iterator();
        while (it2.hasNext()) {
            Iterator<f> it3 = ((i) it2.next()).d(view.getId()).iterator();
            while (it3.hasNext()) {
                if (it3.next().f3665a == position) {
                    if (value != null) {
                        ((Float) value).floatValue();
                    }
                    name.equalsIgnoreCase("app:PerpendicularPath_percent");
                }
            }
        }
    }

    public int m() {
        b bVar = this.f3908c;
        if (bVar != null) {
            return bVar.f3951p;
        }
        return -1;
    }

    public void m0(boolean rtl) {
        this.f3923r = rtl;
        b bVar = this.f3908c;
        if (bVar == null || bVar.f3947l == null) {
            return;
        }
        this.f3908c.f3947l.D(this.f3923r);
    }

    public int n() {
        b bVar = this.f3908c;
        if (bVar == null || bVar.f3947l == null) {
            return 0;
        }
        return this.f3908c.f3947l.e();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0094  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void n0(int r7, int r8) {
        /*
            r6 = this;
            androidx.constraintlayout.widget.j r0 = r6.f3907b
            r1 = -1
            if (r0 == 0) goto L16
            int r0 = r0.e(r7, r1, r1)
            if (r0 == r1) goto Lc
            goto Ld
        Lc:
            r0 = r7
        Ld:
            androidx.constraintlayout.widget.j r2 = r6.f3907b
            int r2 = r2.e(r8, r1, r1)
            if (r2 == r1) goto L17
            goto L18
        L16:
            r0 = r7
        L17:
            r2 = r8
        L18:
            androidx.constraintlayout.motion.widget.t$b r3 = r6.f3908c
            if (r3 == 0) goto L2b
            int r3 = androidx.constraintlayout.motion.widget.t.b.a(r3)
            if (r3 != r8) goto L2b
            androidx.constraintlayout.motion.widget.t$b r3 = r6.f3908c
            int r3 = androidx.constraintlayout.motion.widget.t.b.c(r3)
            if (r3 != r7) goto L2b
            return
        L2b:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.t$b> r3 = r6.f3910e
            java.util.Iterator r3 = r3.iterator()
        L31:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L6b
            java.lang.Object r4 = r3.next()
            androidx.constraintlayout.motion.widget.t$b r4 = (androidx.constraintlayout.motion.widget.t.b) r4
            int r5 = androidx.constraintlayout.motion.widget.t.b.a(r4)
            if (r5 != r2) goto L49
            int r5 = androidx.constraintlayout.motion.widget.t.b.c(r4)
            if (r5 == r0) goto L55
        L49:
            int r5 = androidx.constraintlayout.motion.widget.t.b.a(r4)
            if (r5 != r8) goto L31
            int r5 = androidx.constraintlayout.motion.widget.t.b.c(r4)
            if (r5 != r7) goto L31
        L55:
            r6.f3908c = r4
            if (r4 == 0) goto L6a
            androidx.constraintlayout.motion.widget.w r7 = androidx.constraintlayout.motion.widget.t.b.l(r4)
            if (r7 == 0) goto L6a
            androidx.constraintlayout.motion.widget.t$b r7 = r6.f3908c
            androidx.constraintlayout.motion.widget.w r7 = androidx.constraintlayout.motion.widget.t.b.l(r7)
            boolean r8 = r6.f3923r
            r7.D(r8)
        L6a:
            return
        L6b:
            androidx.constraintlayout.motion.widget.t$b r7 = r6.f3911f
            java.util.ArrayList<androidx.constraintlayout.motion.widget.t$b> r3 = r6.f3912g
            java.util.Iterator r3 = r3.iterator()
        L73:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L87
            java.lang.Object r4 = r3.next()
            androidx.constraintlayout.motion.widget.t$b r4 = (androidx.constraintlayout.motion.widget.t.b) r4
            int r5 = androidx.constraintlayout.motion.widget.t.b.a(r4)
            if (r5 != r8) goto L73
            r7 = r4
            goto L73
        L87:
            androidx.constraintlayout.motion.widget.t$b r8 = new androidx.constraintlayout.motion.widget.t$b
            r8.<init>(r6, r7)
            androidx.constraintlayout.motion.widget.t.b.d(r8, r0)
            androidx.constraintlayout.motion.widget.t.b.b(r8, r2)
            if (r0 == r1) goto L99
            java.util.ArrayList<androidx.constraintlayout.motion.widget.t$b> r7 = r6.f3910e
            r7.add(r8)
        L99:
            r6.f3908c = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.t.n0(int, int):void");
    }

    public androidx.constraintlayout.widget.d o(int id2) {
        return p(id2, -1, -1);
    }

    public void o0(b transition) {
        this.f3908c = transition;
        if (transition == null || transition.f3947l == null) {
            return;
        }
        this.f3908c.f3947l.D(this.f3923r);
    }

    public androidx.constraintlayout.widget.d p(int id2, int width, int height) {
        int iE;
        if (this.f3916k) {
            System.out.println("id " + id2);
            System.out.println("size " + this.f3913h.size());
        }
        androidx.constraintlayout.widget.j jVar = this.f3907b;
        if (jVar != null && (iE = jVar.e(id2, width, height)) != -1) {
            id2 = iE;
        }
        if (this.f3913h.get(id2) != null) {
            return this.f3913h.get(id2);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Warning could not find ConstraintSet id/");
        sb2.append(c.i(this.f3906a.getContext(), id2));
        sb2.append(" In MotionScene");
        SparseArray<androidx.constraintlayout.widget.d> sparseArray = this.f3913h;
        return sparseArray.get(sparseArray.keyAt(0));
    }

    public void p0() {
        b bVar = this.f3908c;
        if (bVar == null || bVar.f3947l == null) {
            return;
        }
        this.f3908c.f3947l.H();
    }

    public androidx.constraintlayout.widget.d q(Context context, String id2) {
        if (this.f3916k) {
            System.out.println("id " + id2);
            System.out.println("size " + this.f3913h.size());
        }
        for (int i10 = 0; i10 < this.f3913h.size(); i10++) {
            int iKeyAt = this.f3913h.keyAt(i10);
            String resourceName = context.getResources().getResourceName(iKeyAt);
            if (this.f3916k) {
                System.out.println("Id for <" + i10 + "> is <" + resourceName + "> looking for <" + id2 + ">");
            }
            if (id2.equals(resourceName)) {
                return this.f3913h.get(iKeyAt);
            }
        }
        return null;
    }

    public int[] r() {
        int size = this.f3913h.size();
        int[] iArr = new int[size];
        for (int i10 = 0; i10 < size; i10++) {
            iArr[i10] = this.f3913h.keyAt(i10);
        }
        return iArr;
    }

    public boolean r0() {
        Iterator<b> it2 = this.f3910e.iterator();
        while (it2.hasNext()) {
            if (it2.next().f3947l != null) {
                return true;
            }
        }
        b bVar = this.f3908c;
        return (bVar == null || bVar.f3947l == null) ? false : true;
    }

    public ArrayList<b> s() {
        return this.f3910e;
    }

    public boolean s0(MotionLayout layout) {
        return layout == this.f3906a && layout.C1 == this;
    }

    public int t() {
        b bVar = this.f3908c;
        return bVar != null ? bVar.f3943h : this.f3917l;
    }

    public void t0(int id2, View... view) {
        this.f3924s.m(id2, view);
    }

    public int u() {
        b bVar = this.f3908c;
        if (bVar == null) {
            return -1;
        }
        return bVar.f3938c;
    }

    public final int v(Context context, String idString) {
        int identifier;
        if (idString.contains(fh.a.f28350w)) {
            identifier = context.getResources().getIdentifier(idString.substring(idString.indexOf(47) + 1), "id", context.getPackageName());
            if (this.f3916k) {
                System.out.println("id getMap res = " + identifier);
            }
        } else {
            identifier = -1;
        }
        return (identifier != -1 || idString.length() <= 1) ? identifier : Integer.parseInt(idString.substring(1));
    }

    public final int w(b transition) {
        int i10 = transition.f3936a;
        if (i10 == -1) {
            throw new IllegalArgumentException("The transition must have an id");
        }
        for (int i11 = 0; i11 < this.f3910e.size(); i11++) {
            if (this.f3910e.get(i11).f3936a == i10) {
                return i11;
            }
        }
        return -1;
    }

    public Interpolator x() {
        int i10 = this.f3908c.f3940e;
        if (i10 == -2) {
            return AnimationUtils.loadInterpolator(this.f3906a.getContext(), this.f3908c.f3942g);
        }
        if (i10 == -1) {
            return new a(this, w.d.c(this.f3908c.f3941f));
        }
        if (i10 == 0) {
            return new AccelerateDecelerateInterpolator();
        }
        if (i10 == 1) {
            return new AccelerateInterpolator();
        }
        if (i10 == 2) {
            return new DecelerateInterpolator();
        }
        if (i10 == 4) {
            return new BounceInterpolator();
        }
        if (i10 == 5) {
            return new OvershootInterpolator();
        }
        if (i10 != 6) {
            return null;
        }
        return new AnticipateInterpolator();
    }

    public f y(Context context, int type, int target, int position) {
        b bVar = this.f3908c;
        if (bVar == null) {
            return null;
        }
        for (i iVar : bVar.f3946k) {
            for (Integer num : iVar.e()) {
                if (target == num.intValue()) {
                    for (f fVar : iVar.d(num.intValue())) {
                        if (fVar.f3665a == position && fVar.f3668d == type) {
                            return fVar;
                        }
                    }
                }
            }
        }
        return null;
    }

    public void z(o motionController) {
        b bVar = this.f3908c;
        if (bVar != null) {
            Iterator it2 = bVar.f3946k.iterator();
            while (it2.hasNext()) {
                ((i) it2.next()).b(motionController);
            }
        } else {
            b bVar2 = this.f3911f;
            if (bVar2 != null) {
                Iterator it3 = bVar2.f3946k.iterator();
                while (it3.hasNext()) {
                    ((i) it3.next()).b(motionController);
                }
            }
        }
    }

    public static class b {
        public static final int A = -2;
        public static final int B = -1;
        public static final int C = 0;
        public static final int D = 1;
        public static final int E = 2;
        public static final int F = 3;
        public static final int G = 4;
        public static final int H = 5;
        public static final int I = 6;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final int f3928s = 0;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public static final int f3929t = 1;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public static final int f3930u = 2;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public static final int f3931v = 3;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public static final int f3932w = 4;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public static final int f3933x = 1;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public static final int f3934y = 2;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public static final int f3935z = 4;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f3936a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f3937b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f3938c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f3939d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f3940e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f3941f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f3942g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f3943h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public float f3944i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final t f3945j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public ArrayList<i> f3946k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public w f3947l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public ArrayList<a> f3948m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f3949n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f3950o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f3951p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f3952q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f3953r;

        public b(t motionScene, b global) {
            this.f3936a = -1;
            this.f3937b = false;
            this.f3938c = -1;
            this.f3939d = -1;
            this.f3940e = 0;
            this.f3941f = null;
            this.f3942g = -1;
            this.f3943h = 400;
            this.f3944i = 0.0f;
            this.f3946k = new ArrayList<>();
            this.f3947l = null;
            this.f3948m = new ArrayList<>();
            this.f3949n = 0;
            this.f3950o = false;
            this.f3951p = -1;
            this.f3952q = 0;
            this.f3953r = 0;
            this.f3945j = motionScene;
            this.f3943h = motionScene.f3917l;
            if (global != null) {
                this.f3951p = global.f3951p;
                this.f3940e = global.f3940e;
                this.f3941f = global.f3941f;
                this.f3942g = global.f3942g;
                this.f3943h = global.f3943h;
                this.f3946k = global.f3946k;
                this.f3944i = global.f3944i;
                this.f3952q = global.f3952q;
            }
        }

        public int A() {
            return this.f3943h;
        }

        public int B() {
            return this.f3938c;
        }

        public int C() {
            return this.f3936a;
        }

        public List<i> D() {
            return this.f3946k;
        }

        public int E() {
            return this.f3952q;
        }

        public List<a> F() {
            return this.f3948m;
        }

        public int G() {
            return this.f3951p;
        }

        public float H() {
            return this.f3944i;
        }

        public int I() {
            return this.f3939d;
        }

        public w J() {
            return this.f3947l;
        }

        public boolean K() {
            return !this.f3950o;
        }

        public boolean L(int flag) {
            return (flag & this.f3953r) != 0;
        }

        public void M(int id2) {
            a next;
            Iterator<a> it2 = this.f3948m.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it2.next();
                    if (next.f3960b == id2) {
                        break;
                    }
                }
            }
            if (next != null) {
                this.f3948m.remove(next);
            }
        }

        public void N(int type) {
            this.f3949n = type;
        }

        public void O(int duration) {
            this.f3943h = Math.max(duration, 8);
        }

        public void P(boolean enable) {
            Q(enable);
        }

        public void Q(boolean enable) {
            this.f3950o = !enable;
        }

        public void R(int interpolator, String interpolatorString, int interpolatorID) {
            this.f3940e = interpolator;
            this.f3941f = interpolatorString;
            this.f3942g = interpolatorID;
        }

        public void S(int mode) {
            this.f3952q = mode;
        }

        public void T(u onSwipe) {
            this.f3947l = onSwipe == null ? null : new w(this.f3945j.f3906a, onSwipe);
        }

        public void U(int touchUpMode) {
            w wVarJ = J();
            if (wVarJ != null) {
                wVarJ.F(touchUpMode);
            }
        }

        public void V(int arcMode) {
            this.f3951p = arcMode;
        }

        public void W(float stagger) {
            this.f3944i = stagger;
        }

        public void X(int flag) {
            this.f3953r = flag;
        }

        public void t(i keyFrames) {
            this.f3946k.add(keyFrames);
        }

        public void u(int id2, int action) {
            for (a aVar : this.f3948m) {
                if (aVar.f3960b == id2) {
                    aVar.f3961c = action;
                    return;
                }
            }
            this.f3948m.add(new a(this, id2, action));
        }

        public void v(Context context, XmlPullParser parser) {
            this.f3948m.add(new a(context, this, parser));
        }

        public String w(Context context) {
            String resourceEntryName = this.f3939d == -1 ? i0.f11859x : context.getResources().getResourceEntryName(this.f3939d);
            if (this.f3938c == -1) {
                return resourceEntryName + " -> null";
            }
            return resourceEntryName + " -> " + context.getResources().getResourceEntryName(this.f3938c);
        }

        public final void x(t motionScene, Context context, TypedArray a10) {
            int indexCount = a10.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = a10.getIndex(i10);
                if (index == R.styleable.Transition_constraintSetEnd) {
                    this.f3938c = a10.getResourceId(index, -1);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f3938c);
                    if (xc.d.f55101w.equals(resourceTypeName)) {
                        androidx.constraintlayout.widget.d dVar = new androidx.constraintlayout.widget.d();
                        dVar.w0(context, this.f3938c);
                        motionScene.f3913h.append(this.f3938c, dVar);
                    } else if ("xml".equals(resourceTypeName)) {
                        this.f3938c = motionScene.a0(context, this.f3938c);
                    }
                } else if (index == R.styleable.Transition_constraintSetStart) {
                    this.f3939d = a10.getResourceId(index, this.f3939d);
                    String resourceTypeName2 = context.getResources().getResourceTypeName(this.f3939d);
                    if (xc.d.f55101w.equals(resourceTypeName2)) {
                        androidx.constraintlayout.widget.d dVar2 = new androidx.constraintlayout.widget.d();
                        dVar2.w0(context, this.f3939d);
                        motionScene.f3913h.append(this.f3939d, dVar2);
                    } else if ("xml".equals(resourceTypeName2)) {
                        this.f3939d = motionScene.a0(context, this.f3939d);
                    }
                } else if (index == R.styleable.Transition_motionInterpolator) {
                    int i11 = a10.peekValue(index).type;
                    if (i11 == 1) {
                        int resourceId = a10.getResourceId(index, -1);
                        this.f3942g = resourceId;
                        if (resourceId != -1) {
                            this.f3940e = -2;
                        }
                    } else if (i11 == 3) {
                        String string = a10.getString(index);
                        this.f3941f = string;
                        if (string != null) {
                            if (string.indexOf(fh.a.f28350w) > 0) {
                                this.f3942g = a10.getResourceId(index, -1);
                                this.f3940e = -2;
                            } else {
                                this.f3940e = -1;
                            }
                        }
                    } else {
                        this.f3940e = a10.getInteger(index, this.f3940e);
                    }
                } else if (index == R.styleable.Transition_duration) {
                    int i12 = a10.getInt(index, this.f3943h);
                    this.f3943h = i12;
                    if (i12 < 8) {
                        this.f3943h = 8;
                    }
                } else if (index == R.styleable.Transition_staggered) {
                    this.f3944i = a10.getFloat(index, this.f3944i);
                } else if (index == R.styleable.Transition_autoTransition) {
                    this.f3949n = a10.getInteger(index, this.f3949n);
                } else if (index == R.styleable.Transition_android_id) {
                    this.f3936a = a10.getResourceId(index, this.f3936a);
                } else if (index == R.styleable.Transition_transitionDisable) {
                    this.f3950o = a10.getBoolean(index, this.f3950o);
                } else if (index == R.styleable.Transition_pathMotionArc) {
                    this.f3951p = a10.getInteger(index, -1);
                } else if (index == R.styleable.Transition_layoutDuringTransition) {
                    this.f3952q = a10.getInteger(index, 0);
                } else if (index == R.styleable.Transition_transitionFlags) {
                    this.f3953r = a10.getInteger(index, 0);
                }
            }
            if (this.f3939d == -1) {
                this.f3937b = true;
            }
        }

        public final void y(t motionScene, Context context, AttributeSet attrs) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.Transition);
            x(motionScene, context, typedArrayObtainStyledAttributes);
            typedArrayObtainStyledAttributes.recycle();
        }

        public int z() {
            return this.f3949n;
        }

        public static class a implements View.OnClickListener {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public static final int f3954d = 1;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final int f3955e = 17;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public static final int f3956f = 16;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static final int f3957g = 256;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public static final int f3958h = 4096;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final b f3959a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f3960b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f3961c;

            public a(Context context, b transition, XmlPullParser parser) {
                this.f3960b = -1;
                this.f3961c = 17;
                this.f3959a = transition;
                TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(parser), R.styleable.OnClick);
                int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
                for (int i10 = 0; i10 < indexCount; i10++) {
                    int index = typedArrayObtainStyledAttributes.getIndex(i10);
                    if (index == R.styleable.OnClick_targetId) {
                        this.f3960b = typedArrayObtainStyledAttributes.getResourceId(index, this.f3960b);
                    } else if (index == R.styleable.OnClick_clickAction) {
                        this.f3961c = typedArrayObtainStyledAttributes.getInt(index, this.f3961c);
                    }
                }
                typedArrayObtainStyledAttributes.recycle();
            }

            public void a(MotionLayout motionLayout, int i10, b bVar) {
                int i11 = this.f3960b;
                View viewFindViewById = motionLayout;
                if (i11 != -1) {
                    viewFindViewById = motionLayout.findViewById(i11);
                }
                if (viewFindViewById == null) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("OnClick could not find id ");
                    sb2.append(this.f3960b);
                    return;
                }
                int i12 = bVar.f3939d;
                int i13 = bVar.f3938c;
                if (i12 == -1) {
                    viewFindViewById.setOnClickListener(this);
                    return;
                }
                int i14 = this.f3961c;
                boolean z10 = false;
                boolean z11 = ((i14 & 1) != 0 && i10 == i12) | ((i14 & 1) != 0 && i10 == i12) | ((i14 & 256) != 0 && i10 == i12) | ((i14 & 16) != 0 && i10 == i13);
                if ((i14 & 4096) != 0 && i10 == i13) {
                    z10 = true;
                }
                if (z11 || z10) {
                    viewFindViewById.setOnClickListener(this);
                }
            }

            public boolean b(b current, MotionLayout tl2) {
                b bVar = this.f3959a;
                if (bVar == current) {
                    return true;
                }
                int i10 = bVar.f3938c;
                int i11 = this.f3959a.f3939d;
                if (i11 == -1) {
                    return tl2.E7 != i10;
                }
                int i12 = tl2.E7;
                return i12 == i11 || i12 == i10;
            }

            public void c(MotionLayout motionLayout) {
                int i10 = this.f3960b;
                if (i10 == -1) {
                    return;
                }
                View viewFindViewById = motionLayout.findViewById(i10);
                if (viewFindViewById != null) {
                    viewFindViewById.setOnClickListener(null);
                    return;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append(" (*)  could not find id ");
                sb2.append(this.f3960b);
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MotionLayout motionLayout = this.f3959a.f3945j.f3906a;
                if (motionLayout.R0()) {
                    if (this.f3959a.f3939d == -1) {
                        int currentState = motionLayout.getCurrentState();
                        if (currentState == -1) {
                            motionLayout.m1(this.f3959a.f3938c);
                            return;
                        }
                        b bVar = new b(this.f3959a.f3945j, this.f3959a);
                        bVar.f3939d = currentState;
                        bVar.f3938c = this.f3959a.f3938c;
                        motionLayout.setTransition(bVar);
                        motionLayout.j1();
                        return;
                    }
                    b bVar2 = this.f3959a.f3945j.f3908c;
                    int i10 = this.f3961c;
                    boolean z10 = false;
                    boolean z11 = ((i10 & 1) == 0 && (i10 & 256) == 0) ? false : true;
                    boolean z12 = ((i10 & 16) == 0 && (i10 & 4096) == 0) ? false : true;
                    if (z11 && z12) {
                        b bVar3 = this.f3959a.f3945j.f3908c;
                        b bVar4 = this.f3959a;
                        if (bVar3 != bVar4) {
                            motionLayout.setTransition(bVar4);
                        }
                        if (motionLayout.getCurrentState() != motionLayout.getEndState() && motionLayout.getProgress() <= 0.5f) {
                            z10 = z11;
                            z12 = false;
                        }
                    } else {
                        z10 = z11;
                    }
                    if (b(bVar2, motionLayout)) {
                        if (z10 && (this.f3961c & 1) != 0) {
                            motionLayout.setTransition(this.f3959a);
                            motionLayout.j1();
                            return;
                        }
                        if (z12 && (this.f3961c & 16) != 0) {
                            motionLayout.setTransition(this.f3959a);
                            motionLayout.l1();
                        } else if (z10 && (this.f3961c & 256) != 0) {
                            motionLayout.setTransition(this.f3959a);
                            motionLayout.setProgress(1.0f);
                        } else {
                            if (!z12 || (this.f3961c & 4096) == 0) {
                                return;
                            }
                            motionLayout.setTransition(this.f3959a);
                            motionLayout.setProgress(0.0f);
                        }
                    }
                }
            }

            public a(b transition, int id2, int action) {
                this.f3959a = transition;
                this.f3960b = id2;
                this.f3961c = action;
            }
        }

        public b(int id2, t motionScene, int constraintSetStartId, int constraintSetEndId) {
            this.f3936a = -1;
            this.f3937b = false;
            this.f3938c = -1;
            this.f3939d = -1;
            this.f3940e = 0;
            this.f3941f = null;
            this.f3942g = -1;
            this.f3943h = 400;
            this.f3944i = 0.0f;
            this.f3946k = new ArrayList<>();
            this.f3947l = null;
            this.f3948m = new ArrayList<>();
            this.f3949n = 0;
            this.f3950o = false;
            this.f3951p = -1;
            this.f3952q = 0;
            this.f3953r = 0;
            this.f3936a = id2;
            this.f3945j = motionScene;
            this.f3939d = constraintSetStartId;
            this.f3938c = constraintSetEndId;
            this.f3943h = motionScene.f3917l;
            this.f3952q = motionScene.f3918m;
        }

        public b(t motionScene, Context context, XmlPullParser parser) {
            this.f3936a = -1;
            this.f3937b = false;
            this.f3938c = -1;
            this.f3939d = -1;
            this.f3940e = 0;
            this.f3941f = null;
            this.f3942g = -1;
            this.f3943h = 400;
            this.f3944i = 0.0f;
            this.f3946k = new ArrayList<>();
            this.f3947l = null;
            this.f3948m = new ArrayList<>();
            this.f3949n = 0;
            this.f3950o = false;
            this.f3951p = -1;
            this.f3952q = 0;
            this.f3953r = 0;
            this.f3943h = motionScene.f3917l;
            this.f3952q = motionScene.f3918m;
            this.f3945j = motionScene;
            y(motionScene, context, Xml.asAttributeSet(parser));
        }
    }

    public t(Context context, MotionLayout layout, int resourceID) {
        this.f3906a = layout;
        this.f3924s = new b0(layout);
        V(context, resourceID);
        SparseArray<androidx.constraintlayout.widget.d> sparseArray = this.f3913h;
        int i10 = R.id.motion_base;
        sparseArray.put(i10, new androidx.constraintlayout.widget.d());
        this.f3914i.put("motion_base", Integer.valueOf(i10));
    }
}
