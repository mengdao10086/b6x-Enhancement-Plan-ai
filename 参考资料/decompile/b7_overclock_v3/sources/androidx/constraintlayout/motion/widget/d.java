package androidx.constraintlayout.motion.widget;

import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class d implements v {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final boolean f3634g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f3635h = "DesignTool";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final HashMap<Pair<Integer, Integer>, String> f3636i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final HashMap<String, String> f3637j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MotionLayout f3638a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public t f3639b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f3640c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f3641d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f3642e = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f3643f = -1;

    static {
        HashMap<Pair<Integer, Integer>, String> map = new HashMap<>();
        f3636i = map;
        HashMap<String, String> map2 = new HashMap<>();
        f3637j = map2;
        map.put(Pair.create(4, 4), "layout_constraintBottom_toBottomOf");
        map.put(Pair.create(4, 3), "layout_constraintBottom_toTopOf");
        map.put(Pair.create(3, 4), "layout_constraintTop_toBottomOf");
        map.put(Pair.create(3, 3), "layout_constraintTop_toTopOf");
        map.put(Pair.create(6, 6), "layout_constraintStart_toStartOf");
        map.put(Pair.create(6, 7), "layout_constraintStart_toEndOf");
        map.put(Pair.create(7, 6), "layout_constraintEnd_toStartOf");
        map.put(Pair.create(7, 7), "layout_constraintEnd_toEndOf");
        map.put(Pair.create(1, 1), "layout_constraintLeft_toLeftOf");
        map.put(Pair.create(1, 2), "layout_constraintLeft_toRightOf");
        map.put(Pair.create(2, 2), "layout_constraintRight_toRightOf");
        map.put(Pair.create(2, 1), "layout_constraintRight_toLeftOf");
        map.put(Pair.create(5, 5), "layout_constraintBaseline_toBaselineOf");
        map2.put("layout_constraintBottom_toBottomOf", "layout_marginBottom");
        map2.put("layout_constraintBottom_toTopOf", "layout_marginBottom");
        map2.put("layout_constraintTop_toBottomOf", "layout_marginTop");
        map2.put("layout_constraintTop_toTopOf", "layout_marginTop");
        map2.put("layout_constraintStart_toStartOf", "layout_marginStart");
        map2.put("layout_constraintStart_toEndOf", "layout_marginStart");
        map2.put("layout_constraintEnd_toStartOf", "layout_marginEnd");
        map2.put("layout_constraintEnd_toEndOf", "layout_marginEnd");
        map2.put("layout_constraintLeft_toLeftOf", "layout_marginLeft");
        map2.put("layout_constraintLeft_toRightOf", "layout_marginLeft");
        map2.put("layout_constraintRight_toRightOf", "layout_marginRight");
        map2.put("layout_constraintRight_toLeftOf", "layout_marginRight");
    }

    public d(MotionLayout motionLayout) {
        this.f3638a = motionLayout;
    }

    public static void j(int dpi, androidx.constraintlayout.widget.d set, View view, HashMap<String, String> attributes, int from, int to2) {
        String str = f3636i.get(Pair.create(Integer.valueOf(from), Integer.valueOf(to2)));
        String str2 = attributes.get(str);
        if (str2 != null) {
            String str3 = f3637j.get(str);
            set.L(view.getId(), from, Integer.parseInt(str2), to2, str3 != null ? k(dpi, attributes.get(str3)) : 0);
        }
    }

    public static int k(int dpi, String value) {
        int iIndexOf;
        if (value == null || (iIndexOf = value.indexOf(100)) == -1) {
            return 0;
        }
        return (int) ((Integer.valueOf(value.substring(0, iIndexOf)).intValue() * dpi) / 160.0f);
    }

    public static void l(int dpi, androidx.constraintlayout.widget.d set, View view, HashMap<String, String> attributes) {
        String str = attributes.get("layout_editor_absoluteX");
        if (str != null) {
            set.W0(view.getId(), k(dpi, str));
        }
        String str2 = attributes.get("layout_editor_absoluteY");
        if (str2 != null) {
            set.X0(view.getId(), k(dpi, str2));
        }
    }

    public static void m(androidx.constraintlayout.widget.d set, View view, HashMap<String, String> attributes, int type) {
        String str = attributes.get(type == 1 ? "layout_constraintVertical_bias" : "layout_constraintHorizontal_bias");
        if (str != null) {
            if (type == 0) {
                set.f1(view.getId(), Float.parseFloat(str));
            } else if (type == 1) {
                set.A1(view.getId(), Float.parseFloat(str));
            }
        }
    }

    public static void n(int dpi, androidx.constraintlayout.widget.d set, View view, HashMap<String, String> attributes, int type) {
        String str = attributes.get(type == 1 ? "layout_height" : "layout_width");
        if (str != null) {
            int iK = str.equalsIgnoreCase("wrap_content") ? -2 : k(dpi, str);
            if (type == 0) {
                set.W(view.getId(), iK);
            } else {
                set.P(view.getId(), iK);
            }
        }
    }

    public String A() {
        if (this.f3640c != null && this.f3641d != null) {
            float fY = y();
            if (fY <= 0.01f) {
                return this.f3640c;
            }
            if (fY >= 0.99f) {
                return this.f3641d;
            }
        }
        return this.f3640c;
    }

    public boolean B() {
        return (this.f3640c == null || this.f3641d == null) ? false : true;
    }

    public void C(Object keyFrame, String tag, Object value) {
        if (keyFrame instanceof f) {
            ((f) keyFrame).j(tag, value);
            this.f3638a.Z0();
            this.f3638a.R7 = true;
        }
    }

    public void D(String id2) {
        if (id2 == null) {
            id2 = "motion_base";
        }
        if (this.f3640c == id2) {
            return;
        }
        this.f3640c = id2;
        this.f3641d = null;
        MotionLayout motionLayout = this.f3638a;
        if (motionLayout.C1 == null) {
            motionLayout.C1 = this.f3639b;
        }
        int iU0 = motionLayout.U0(id2);
        this.f3642e = iU0;
        if (iU0 != 0) {
            if (iU0 == this.f3638a.getStartState()) {
                this.f3638a.setProgress(0.0f);
            } else if (iU0 == this.f3638a.getEndState()) {
                this.f3638a.setProgress(1.0f);
            } else {
                this.f3638a.m1(iU0);
                this.f3638a.setProgress(1.0f);
            }
        }
        this.f3638a.requestLayout();
    }

    public void E(String start, String end) {
        MotionLayout motionLayout = this.f3638a;
        if (motionLayout.C1 == null) {
            motionLayout.C1 = this.f3639b;
        }
        int iU0 = motionLayout.U0(start);
        int iU02 = this.f3638a.U0(end);
        this.f3638a.e1(iU0, iU02);
        this.f3642e = iU0;
        this.f3643f = iU02;
        this.f3640c = start;
        this.f3641d = end;
    }

    public void F(Object view, int debugMode) {
        o oVar;
        if ((view instanceof View) && (oVar = this.f3638a.J7.get(view)) != null) {
            oVar.S(debugMode);
            this.f3638a.invalidate();
        }
    }

    @Override // androidx.constraintlayout.motion.widget.v
    public long a() {
        return this.f3638a.getTransitionTimeMs();
    }

    @Override // androidx.constraintlayout.motion.widget.v
    public int b(int cmd, String type, Object viewObject, float[] in2, int inLength, float[] out, int outLength) {
        o oVar;
        View view = (View) viewObject;
        if (cmd != 0) {
            MotionLayout motionLayout = this.f3638a;
            if (motionLayout.C1 == null || view == null || (oVar = motionLayout.J7.get(view)) == null) {
                return -1;
            }
        } else {
            oVar = null;
        }
        if (cmd == 0) {
            return 1;
        }
        if (cmd == 1) {
            int iT = this.f3638a.C1.t() / 16;
            oVar.f(out, iT);
            return iT;
        }
        if (cmd == 2) {
            int iT2 = this.f3638a.C1.t() / 16;
            oVar.e(out, null);
            return iT2;
        }
        if (cmd != 3) {
            return -1;
        }
        int iT3 = this.f3638a.C1.t() / 16;
        return oVar.l(type, out, outLength);
    }

    @Override // androidx.constraintlayout.motion.widget.v
    public boolean c(Object view, int position, int type, float x10, float y10) {
        if (!(view instanceof View)) {
            return false;
        }
        MotionLayout motionLayout = this.f3638a;
        if (motionLayout.C1 != null) {
            o oVar = motionLayout.J7.get(view);
            MotionLayout motionLayout2 = this.f3638a;
            int i10 = (int) (motionLayout2.M7 * 100.0f);
            if (oVar != null) {
                View view2 = (View) view;
                if (motionLayout2.C1.S(view2, i10)) {
                    float fY = oVar.y(2, x10, y10);
                    float fY2 = oVar.y(5, x10, y10);
                    this.f3638a.C1.l0(view2, i10, "motion:percentX", Float.valueOf(fY));
                    this.f3638a.C1.l0(view2, i10, "motion:percentY", Float.valueOf(fY2));
                    this.f3638a.Z0();
                    this.f3638a.A0(true);
                    this.f3638a.invalidate();
                    return true;
                }
            }
        }
        return false;
    }

    @Override // androidx.constraintlayout.motion.widget.v
    public void d(float position) {
        MotionLayout motionLayout = this.f3638a;
        if (motionLayout.C1 == null) {
            motionLayout.C1 = this.f3639b;
        }
        motionLayout.setProgress(position);
        this.f3638a.A0(true);
        this.f3638a.requestLayout();
        this.f3638a.invalidate();
    }

    @Override // androidx.constraintlayout.motion.widget.v
    public Boolean e(Object keyFrame, Object view, float x10, float y10, String[] attribute, float[] value) {
        if (!(keyFrame instanceof k)) {
            return Boolean.FALSE;
        }
        View view2 = (View) view;
        this.f3638a.J7.get(view2).N(view2, (k) keyFrame, x10, y10, attribute, value);
        this.f3638a.Z0();
        this.f3638a.R7 = true;
        return Boolean.TRUE;
    }

    @Override // androidx.constraintlayout.motion.widget.v
    public void f(Object view, int position, String name, Object value) {
        t tVar = this.f3638a.C1;
        if (tVar != null) {
            tVar.l0((View) view, position, name, value);
            MotionLayout motionLayout = this.f3638a;
            motionLayout.P7 = position / 100.0f;
            motionLayout.N7 = 0.0f;
            motionLayout.Z0();
            this.f3638a.A0(true);
        }
    }

    @Override // androidx.constraintlayout.motion.widget.v
    public void g(int dpi, String constraintSetId, Object opaqueView, Object opaqueAttributes) {
        View view = (View) opaqueView;
        HashMap map = (HashMap) opaqueAttributes;
        int iU0 = this.f3638a.U0(constraintSetId);
        androidx.constraintlayout.widget.d dVarO = this.f3638a.C1.o(iU0);
        if (dVarO == null) {
            return;
        }
        dVarO.E(view.getId());
        n(dpi, dVarO, view, map, 0);
        n(dpi, dVarO, view, map, 1);
        j(dpi, dVarO, view, map, 6, 6);
        j(dpi, dVarO, view, map, 6, 7);
        j(dpi, dVarO, view, map, 7, 7);
        j(dpi, dVarO, view, map, 7, 6);
        j(dpi, dVarO, view, map, 1, 1);
        j(dpi, dVarO, view, map, 1, 2);
        j(dpi, dVarO, view, map, 2, 2);
        j(dpi, dVarO, view, map, 2, 1);
        j(dpi, dVarO, view, map, 3, 3);
        j(dpi, dVarO, view, map, 3, 4);
        j(dpi, dVarO, view, map, 4, 3);
        j(dpi, dVarO, view, map, 4, 4);
        j(dpi, dVarO, view, map, 5, 5);
        m(dVarO, view, map, 0);
        m(dVarO, view, map, 1);
        l(dpi, dVarO, view, map);
        this.f3638a.r1(iU0, dVarO);
        this.f3638a.requestLayout();
    }

    @Override // androidx.constraintlayout.motion.widget.v
    public float h(Object view, int type, float x10, float y10) {
        o oVar;
        if ((view instanceof View) && (oVar = this.f3638a.J7.get((View) view)) != null) {
            return oVar.y(type, x10, y10);
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.motion.widget.v
    public Object i(Object viewObject, float x10, float y10) {
        o oVar;
        View view = (View) viewObject;
        MotionLayout motionLayout = this.f3638a;
        if (motionLayout.C1 == null) {
            return -1;
        }
        if (view == null || (oVar = motionLayout.J7.get(view)) == null) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        return oVar.B(viewGroup.getWidth(), viewGroup.getHeight(), x10, y10);
    }

    public void o(boolean disable) {
        this.f3638a.w0(disable);
    }

    public void p(String set) {
        MotionLayout motionLayout = this.f3638a;
        if (motionLayout.C1 == null) {
            motionLayout.C1 = this.f3639b;
        }
        int iU0 = motionLayout.U0(set);
        System.out.println(" dumping  " + set + " (" + iU0 + ee.a.f26979d);
        try {
            this.f3638a.C1.o(iU0).g0(this.f3638a.C1, new int[0]);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public int q(Object view, float[] key) {
        t tVar = this.f3638a.C1;
        if (tVar == null) {
            return -1;
        }
        int iT = tVar.t() / 16;
        o oVar = this.f3638a.J7.get(view);
        if (oVar == null) {
            return 0;
        }
        oVar.e(key, null);
        return iT;
    }

    public int r(Object view, float[] path, int len) {
        MotionLayout motionLayout = this.f3638a;
        if (motionLayout.C1 == null) {
            return -1;
        }
        o oVar = motionLayout.J7.get(view);
        if (oVar == null) {
            return 0;
        }
        oVar.f(path, len);
        return len;
    }

    public void s(Object view, float[] path) {
        t tVar = this.f3638a.C1;
        if (tVar == null) {
            return;
        }
        int iT = tVar.t() / 16;
        o oVar = this.f3638a.J7.get(view);
        if (oVar == null) {
            return;
        }
        oVar.h(path, iT);
    }

    public String t() {
        int endState = this.f3638a.getEndState();
        if (this.f3643f == endState) {
            return this.f3641d;
        }
        String strI0 = this.f3638a.I0(endState);
        if (strI0 != null) {
            this.f3641d = strI0;
            this.f3643f = endState;
        }
        return strI0;
    }

    public int u(Object view, int type, int[] info) {
        o oVar = this.f3638a.J7.get((View) view);
        if (oVar == null) {
            return 0;
        }
        return oVar.x(type, info);
    }

    public int v(Object view, int[] type, float[] pos) {
        o oVar = this.f3638a.J7.get((View) view);
        if (oVar == null) {
            return 0;
        }
        return oVar.z(type, pos);
    }

    public Object w(int type, int target, int position) {
        MotionLayout motionLayout = this.f3638a;
        t tVar = motionLayout.C1;
        if (tVar == null) {
            return null;
        }
        return tVar.y(motionLayout.getContext(), type, target, position);
    }

    public Object x(Object view, int type, int position) {
        if (this.f3638a.C1 == null) {
            return null;
        }
        int id2 = ((View) view).getId();
        MotionLayout motionLayout = this.f3638a;
        return motionLayout.C1.y(motionLayout.getContext(), type, id2, position);
    }

    public float y() {
        return this.f3638a.getProgress();
    }

    public String z() {
        int startState = this.f3638a.getStartState();
        if (this.f3642e == startState) {
            return this.f3640c;
        }
        String strI0 = this.f3638a.I0(startState);
        if (strI0 != null) {
            this.f3640c = strI0;
            this.f3642e = startState;
        }
        return this.f3638a.I0(startState);
    }
}
