package com.github.dhaval2404.colorpicker;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.e;
import androidx.recyclerview.widget.RecyclerView;
import com.flydigi.sdk.bluetooth.l;
import com.github.dhaval2404.colorpicker.model.ColorShape;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.material.card.MaterialCardView;
import g.c1;
import g.n;
import ik.p;
import java.util.Objects;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.z1;
import xf.j;
import yt.k;

/* JADX INFO: loaded from: classes3.dex */
@d0(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0005BO\b\u0002\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0012\u001a\u00020\n\u0012\u0006\u0010\u0015\u001a\u00020\n\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\b\u0010$\u001a\u0004\u0018\u00010#\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u001e\u001a\u00020\u0019¢\u0006\u0004\b'\u0010(J\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u000f\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0012\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000eR\u0017\u0010\u0015\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u0014\u0010\u000eR\u0019\u0010\u0018\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0017\u0010\u000eR\"\u0010\u001e\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u001a\u001a\u0004\b\u0013\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0019\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u0010\u0010\"R\u0019\u0010$\u001a\u0004\u0018\u00010#8\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b\u0016\u0010&¨\u0006)"}, d2 = {"Lcom/github/dhaval2404/colorpicker/ColorPickerDialog;", "", "Lkotlin/z1;", l.f16298a, "Landroid/content/Context;", "a", "Landroid/content/Context;", "e", "()Landroid/content/Context;", com.umeng.analytics.pro.d.R, "", "b", "Ljava/lang/String;", j.f55230b, "()Ljava/lang/String;", "title", "c", "i", "positiveButton", "d", "h", "negativeButton", "g", "f", "defaultColor", "Lcom/github/dhaval2404/colorpicker/model/ColorShape;", "Lcom/github/dhaval2404/colorpicker/model/ColorShape;", "()Lcom/github/dhaval2404/colorpicker/model/ColorShape;", "k", "(Lcom/github/dhaval2404/colorpicker/model/ColorShape;)V", "colorShape", "Lba/a;", "colorListener", "Lba/a;", "()Lba/a;", "Lba/b;", "dismissListener", "Lba/b;", "()Lba/b;", "<init>", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lba/a;Lba/b;Ljava/lang/String;Lcom/github/dhaval2404/colorpicker/model/ColorShape;)V", "colorpicker_release"}, k = 1, mv = {1, 5, 1})
public final class ColorPickerDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public final Context f16445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @k
    public final String f16446b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @k
    public final String f16447c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @k
    public final String f16448d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.l
    public final ba.a f16449e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @yt.l
    public final ba.b f16450f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @yt.l
    public final String f16451g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @k
    public ColorShape f16452h;

    @d0(bv = {}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010#\u001a\u00020\u001f¢\u0006\u0004\b)\u0010*J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0006\u001a\u00020\u00002\b\b\u0001\u0010\u0003\u001a\u00020\u0005J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0002J\u0010\u0010\t\u001a\u00020\u00002\b\b\u0001\u0010\u0007\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0002J\u0010\u0010\u000b\u001a\u00020\u00002\b\b\u0001\u0010\u0007\u001a\u00020\u0005J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0002J\u0010\u0010\u000e\u001a\u00020\u00002\b\b\u0001\u0010\f\u001a\u00020\u0005J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0012J \u0010\u0017\u001a\u00020\u00002\u0018\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00160\u0015J\u0010\u0010\u0019\u001a\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\u0018J\u0014\u0010\u001b\u001a\u00020\u00002\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00160\u001aJ\u0006\u0010\u001d\u001a\u00020\u001cJ\u0006\u0010\u001e\u001a\u00020\u0016R\u0017\u0010#\u001a\u00020\u001f8\u0006¢\u0006\f\n\u0004\b\u001d\u0010 \u001a\u0004\b!\u0010\"R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010$R\u0016\u0010%\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010$R\u0016\u0010&\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010$R\u0018\u0010'\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010$R\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010(¨\u0006+"}, d2 = {"Lcom/github/dhaval2404/colorpicker/ColorPickerDialog$a;", "", "", "title", "o", "", "n", "text", m0.k.f40564b, l.f16298a, "k", j.f55230b, "color", "g", "f", "Lcom/github/dhaval2404/colorpicker/model/ColorShape;", "colorShape", "e", "Lba/a;", "listener", "c", "Lkotlin/Function2;", "Lkotlin/z1;", "d", "Lba/b;", "h", "Lkotlin/Function0;", "i", "Lcom/github/dhaval2404/colorpicker/ColorPickerDialog;", "a", "p", "Landroid/content/Context;", "Landroid/content/Context;", "b", "()Landroid/content/Context;", com.umeng.analytics.pro.d.R, "Ljava/lang/String;", "positiveButton", "negativeButton", "defaultColor", "Lcom/github/dhaval2404/colorpicker/model/ColorShape;", "<init>", "(Landroid/content/Context;)V", "colorpicker_release"}, k = 1, mv = {1, 5, 1})
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @k
        public final Context f16453a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @k
        public String f16454b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @k
        public String f16455c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @k
        public String f16456d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @yt.l
        public ba.a f16457e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @yt.l
        public ba.b f16458f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @yt.l
        public String f16459g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @k
        public ColorShape f16460h;

        /* JADX INFO: renamed from: com.github.dhaval2404.colorpicker.ColorPickerDialog$a$a, reason: collision with other inner class name */
        @d0(bv = {}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\b"}, d2 = {"com/github/dhaval2404/colorpicker/ColorPickerDialog$a$a", "Lba/a;", "", "color", "", "colorHex", "Lkotlin/z1;", "a", "colorpicker_release"}, k = 1, mv = {1, 5, 1})
        public static final class C0171a implements ba.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ p<Integer, String, z1> f16461a;

            /* JADX WARN: Multi-variable type inference failed */
            public C0171a(p<? super Integer, ? super String, z1> pVar) {
                this.f16461a = pVar;
            }

            @Override // ba.a
            public void a(int i10, @k String colorHex) {
                f0.p(colorHex, "colorHex");
                this.f16461a.r0(Integer.valueOf(i10), colorHex);
            }
        }

        @d0(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"com/github/dhaval2404/colorpicker/ColorPickerDialog$a$b", "Lba/b;", "Lkotlin/z1;", "onDismiss", "colorpicker_release"}, k = 1, mv = {1, 5, 1})
        public static final class b implements ba.b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ik.a<z1> f16462a;

            public b(ik.a<z1> aVar) {
                this.f16462a = aVar;
            }

            @Override // ba.b
            public void onDismiss() {
                this.f16462a.o();
            }
        }

        public a(@k Context context) {
            f0.p(context, "context");
            this.f16453a = context;
            String string = context.getString(R.string.material_dialog_title);
            f0.o(string, "context.getString(R.string.material_dialog_title)");
            this.f16454b = string;
            String string2 = context.getString(R.string.material_dialog_positive_button);
            f0.o(string2, "context.getString(R.string.material_dialog_positive_button)");
            this.f16455c = string2;
            String string3 = context.getString(R.string.material_dialog_negative_button);
            f0.o(string3, "context.getString(R.string.material_dialog_negative_button)");
            this.f16456d = string3;
            this.f16460h = ColorShape.CIRCLE;
        }

        @k
        public final ColorPickerDialog a() {
            return new ColorPickerDialog(this.f16453a, this.f16454b, this.f16455c, this.f16456d, this.f16457e, this.f16458f, this.f16459g, this.f16460h, null);
        }

        @k
        public final Context b() {
            return this.f16453a;
        }

        @k
        public final a c(@k ba.a listener) {
            f0.p(listener, "listener");
            this.f16457e = listener;
            return this;
        }

        @k
        public final a d(@k p<? super Integer, ? super String, z1> listener) {
            f0.p(listener, "listener");
            this.f16457e = new C0171a(listener);
            return this;
        }

        @k
        public final a e(@k ColorShape colorShape) {
            f0.p(colorShape, "colorShape");
            this.f16460h = colorShape;
            return this;
        }

        @k
        public final a f(@n int i10) {
            ca.b bVar = ca.b.f10676a;
            this.f16459g = ca.b.a(i10);
            return this;
        }

        @k
        public final a g(@k String color) {
            f0.p(color, "color");
            this.f16459g = color;
            return this;
        }

        @k
        public final a h(@yt.l ba.b bVar) {
            this.f16458f = bVar;
            return this;
        }

        @k
        public final a i(@k ik.a<z1> listener) {
            f0.p(listener, "listener");
            this.f16458f = new b(listener);
            return this;
        }

        @k
        public final a j(@c1 int i10) {
            String string = this.f16453a.getString(i10);
            f0.o(string, "context.getString(text)");
            this.f16456d = string;
            return this;
        }

        @k
        public final a k(@k String text) {
            f0.p(text, "text");
            this.f16456d = text;
            return this;
        }

        @k
        public final a l(@c1 int i10) {
            String string = this.f16453a.getString(i10);
            f0.o(string, "context.getString(text)");
            this.f16455c = string;
            return this;
        }

        @k
        public final a m(@k String text) {
            f0.p(text, "text");
            this.f16455c = text;
            return this;
        }

        @k
        public final a n(@c1 int i10) {
            String string = this.f16453a.getString(i10);
            f0.o(string, "context.getString(title)");
            this.f16454b = string;
            return this;
        }

        @k
        public final a o(@k String title) {
            f0.p(title, "title");
            this.f16454b = title;
            return this;
        }

        public final void p() {
            a().l();
        }
    }

    @d0(bv = {}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\b"}, d2 = {"com/github/dhaval2404/colorpicker/ColorPickerDialog$b", "Lba/a;", "", "color", "", "colorHex", "Lkotlin/z1;", "a", "colorpicker_release"}, k = 1, mv = {1, 5, 1})
    public static final class b implements ba.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ColorPickerView f16463a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ MaterialCardView f16464b;

        public b(ColorPickerView colorPickerView, MaterialCardView materialCardView) {
            this.f16463a = colorPickerView;
            this.f16464b = materialCardView;
        }

        @Override // ba.a
        public void a(int i10, @k String colorHex) {
            f0.p(colorHex, "colorHex");
            this.f16463a.setColor(i10);
            this.f16464b.setCardBackgroundColor(i10);
        }
    }

    public ColorPickerDialog(Context context, String str, String str2, String str3, ba.a aVar, ba.b bVar, String str4, ColorShape colorShape) {
        this.f16445a = context;
        this.f16446b = str;
        this.f16447c = str2;
        this.f16448d = str3;
        this.f16449e = aVar;
        this.f16450f = bVar;
        this.f16451g = str4;
        this.f16452h = colorShape;
    }

    public /* synthetic */ ColorPickerDialog(Context context, String str, String str2, String str3, ba.a aVar, ba.b bVar, String str4, ColorShape colorShape, u uVar) {
        this(context, str, str2, str3, aVar, bVar, str4, colorShape);
    }

    public static final void m(ColorPickerView colorPickerView, ColorPickerDialog this$0, ca.d sharedPref, DialogInterface dialogInterface, int i10) {
        f0.p(this$0, "this$0");
        f0.p(sharedPref, "$sharedPref");
        int color = colorPickerView.getColor();
        ca.b bVar = ca.b.f10676a;
        String strA = ca.b.a(color);
        ba.a aVarC = this$0.c();
        if (aVarC != null) {
            aVarC.a(color, strA);
        }
        sharedPref.a(strA);
    }

    public static final void n(ba.b listener, DialogInterface dialogInterface) {
        f0.p(listener, "$listener");
        listener.onDismiss();
    }

    @yt.l
    public final ba.a c() {
        return this.f16449e;
    }

    @k
    public final ColorShape d() {
        return this.f16452h;
    }

    @k
    public final Context e() {
        return this.f16445a;
    }

    @yt.l
    public final String f() {
        return this.f16451g;
    }

    @yt.l
    public final ba.b g() {
        return this.f16450f;
    }

    @k
    public final String h() {
        return this.f16448d;
    }

    @k
    public final String i() {
        return this.f16447c;
    }

    @k
    public final String j() {
        return this.f16446b;
    }

    public final void k(@k ColorShape colorShape) {
        f0.p(colorShape, "<set-?>");
        this.f16452h = colorShape;
    }

    public final void l() {
        e.a aVarP = new e.a(this.f16445a).setTitle(this.f16446b).p(this.f16448d, null);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f16445a);
        f0.o(layoutInflaterFrom, "from(context)");
        View viewInflate = layoutInflaterFrom.inflate(R.layout.dialog_color_picker, (ViewGroup) null);
        Objects.requireNonNull(viewInflate, "null cannot be cast to non-null type android.view.View");
        aVarP.setView(viewInflate);
        final ColorPickerView colorPickerView = (ColorPickerView) viewInflate.findViewById(R.id.colorPicker);
        final MaterialCardView materialCardView = (MaterialCardView) viewInflate.findViewById(R.id.colorView);
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R.id.recentColorsRV);
        String str = this.f16451g;
        int color = !(str == null || kotlin.text.u.V1(str)) ? Color.parseColor(this.f16451g) : h0.d.f(this.f16445a, R.color.grey_500);
        materialCardView.setCardBackgroundColor(color);
        colorPickerView.setColor(color);
        colorPickerView.setColorListener(new p<Integer, String, z1>() { // from class: com.github.dhaval2404.colorpicker.ColorPickerDialog$show$1
            {
                super(2);
            }

            public final void b(int i10, @k String noName_1) {
                f0.p(noName_1, "$noName_1");
                materialCardView.setCardBackgroundColor(i10);
            }

            @Override // ik.p
            public /* bridge */ /* synthetic */ z1 r0(Integer num, String str2) {
                b(num.intValue(), str2);
                return z1.f38230a;
            }
        });
        final ca.d dVar = new ca.d(this.f16445a);
        aa.e eVar = new aa.e(dVar.f());
        eVar.s(this.f16452h);
        eVar.r(new b(colorPickerView, materialCardView));
        recyclerView.setLayoutManager(new FlexboxLayoutManager(this.f16445a));
        recyclerView.setAdapter(eVar);
        aVarP.y(this.f16447c, new DialogInterface.OnClickListener() { // from class: com.github.dhaval2404.colorpicker.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                ColorPickerDialog.m(colorPickerView, this, dVar, dialogInterface, i10);
            }
        });
        final ba.b bVar = this.f16450f;
        if (bVar != null) {
            aVarP.v(new DialogInterface.OnDismissListener() { // from class: com.github.dhaval2404.colorpicker.c
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    ColorPickerDialog.n(bVar, dialogInterface);
                }
            });
        }
        androidx.appcompat.app.e eVarCreate = aVarP.create();
        f0.o(eVarCreate, "dialog.create()");
        eVarCreate.show();
        ca.c.a(eVarCreate);
    }
}
