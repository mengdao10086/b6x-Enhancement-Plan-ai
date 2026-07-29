package sd;

import android.animation.TypeEvaluator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.Property;
import g.l;
import g.n0;
import g.p0;
import sd.d;

/* JADX INFO: loaded from: classes3.dex */
public interface g extends d.a {

    public static class b implements TypeEvaluator<e> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final TypeEvaluator<e> f49682b = new b();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e f49683a = new e();

        @Override // android.animation.TypeEvaluator
        @n0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public e evaluate(float f10, @n0 e eVar, @n0 e eVar2) {
            this.f49683a.b(de.a.f(eVar.f49687a, eVar2.f49687a, f10), de.a.f(eVar.f49688b, eVar2.f49688b, f10), de.a.f(eVar.f49689c, eVar2.f49689c, f10));
            return this.f49683a;
        }
    }

    public static class c extends Property<g, e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Property<g, e> f49684a = new c("circularReveal");

        public c(String str) {
            super(e.class, str);
        }

        @Override // android.util.Property
        @p0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public e get(@n0 g gVar) {
            return gVar.getRevealInfo();
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(@n0 g gVar, @p0 e eVar) {
            gVar.setRevealInfo(eVar);
        }
    }

    public static class d extends Property<g, Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Property<g, Integer> f49685a = new d("circularRevealScrimColor");

        public d(String str) {
            super(Integer.class, str);
        }

        @Override // android.util.Property
        @n0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer get(@n0 g gVar) {
            return Integer.valueOf(gVar.getCircularRevealScrimColor());
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(@n0 g gVar, @n0 Integer num) {
            gVar.setCircularRevealScrimColor(num.intValue());
        }
    }

    public static class e {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final float f49686d = Float.MAX_VALUE;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f49687a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f49688b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f49689c;

        public boolean a() {
            return this.f49689c == Float.MAX_VALUE;
        }

        public void b(float f10, float f11, float f12) {
            this.f49687a = f10;
            this.f49688b = f11;
            this.f49689c = f12;
        }

        public void c(@n0 e eVar) {
            b(eVar.f49687a, eVar.f49688b, eVar.f49689c);
        }

        public e() {
        }

        public e(float f10, float f11, float f12) {
            this.f49687a = f10;
            this.f49688b = f11;
            this.f49689c = f12;
        }

        public e(@n0 e eVar) {
            this(eVar.f49687a, eVar.f49688b, eVar.f49689c);
        }
    }

    void a();

    void b();

    void draw(Canvas canvas);

    @p0
    Drawable getCircularRevealOverlayDrawable();

    @l
    int getCircularRevealScrimColor();

    @p0
    e getRevealInfo();

    boolean isOpaque();

    void setCircularRevealOverlayDrawable(@p0 Drawable drawable);

    void setCircularRevealScrimColor(@l int i10);

    void setRevealInfo(@p0 e eVar);
}
