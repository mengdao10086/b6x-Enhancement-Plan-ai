package com.github.dhaval2404.colorpicker;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.e;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.flydigi.sdk.bluetooth.l;
import com.github.dhaval2404.colorpicker.model.ColorShape;
import com.github.dhaval2404.colorpicker.model.ColorSwatch;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.umeng.analytics.pro.an;
import g.c1;
import g.n;
import ik.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.t;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.z1;
import m0.k;
import xf.j;

/* JADX INFO: loaded from: classes3.dex */
@d0(bv = {}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\bBs\b\u0002\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012\u0006\u0010\u0015\u001a\u00020\r\u0012\u0006\u0010\u0018\u001a\u00020\r\u0012\b\u00104\u001a\u0004\u0018\u000103\u0012\b\u00108\u001a\u0004\u0018\u000107\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u001f\u001a\u00020\u001b\u0012\u0006\u0010&\u001a\u00020 \u0012\u0010\b\u0002\u0010+\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010'\u0012\b\b\u0002\u00102\u001a\u00020,¢\u0006\u0004\b;\u0010<J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0004R\u0017\u0010\f\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0012\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0015\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011R\u0017\u0010\u0018\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0017\u0010\u0011R\u0019\u0010\u001a\u001a\u0004\u0018\u00010\r8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000f\u001a\u0004\b\u0019\u0010\u0011R\u0017\u0010\u001f\u001a\u00020\u001b8\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\"\u0010&\u001a\u00020 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b\u0016\u0010#\"\u0004\b$\u0010%R\u001f\u0010+\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010'8\u0006¢\u0006\f\n\u0004\b\u0017\u0010(\u001a\u0004\b)\u0010*R\"\u00102\u001a\u00020,8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0019\u00104\u001a\u0004\u0018\u0001038\u0006¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b\u0013\u00106R\u0019\u00108\u001a\u0004\u0018\u0001078\u0006¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b!\u0010:¨\u0006="}, d2 = {"Lcom/github/dhaval2404/colorpicker/h;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Lkotlin/z1;", an.aB, "p", "Landroid/content/Context;", "a", "Landroid/content/Context;", "g", "()Landroid/content/Context;", com.umeng.analytics.pro.d.R, "", "b", "Ljava/lang/String;", l.f16298a, "()Ljava/lang/String;", "title", "c", "k", "positiveButton", "d", j.f55230b, "negativeButton", "h", "defaultColor", "Lcom/github/dhaval2404/colorpicker/model/ColorSwatch;", "Lcom/github/dhaval2404/colorpicker/model/ColorSwatch;", "e", "()Lcom/github/dhaval2404/colorpicker/model/ColorSwatch;", "colorSwatch", "Lcom/github/dhaval2404/colorpicker/model/ColorShape;", "i", "Lcom/github/dhaval2404/colorpicker/model/ColorShape;", "()Lcom/github/dhaval2404/colorpicker/model/ColorShape;", "n", "(Lcom/github/dhaval2404/colorpicker/model/ColorShape;)V", "colorShape", "", "Ljava/util/List;", "f", "()Ljava/util/List;", "colors", "", "Z", k.f40564b, "()Z", "o", "(Z)V", "isTickColorPerCard", "Lba/a;", "colorListener", "Lba/a;", "()Lba/a;", "Lba/b;", "dismissListener", "Lba/b;", "()Lba/b;", "<init>", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lba/a;Lba/b;Ljava/lang/String;Lcom/github/dhaval2404/colorpicker/model/ColorSwatch;Lcom/github/dhaval2404/colorpicker/model/ColorShape;Ljava/util/List;Z)V", "colorpicker_release"}, k = 1, mv = {1, 5, 1})
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final Context f16492a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final String f16493b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public final String f16494c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public final String f16495d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.l
    public final ba.a f16496e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @yt.l
    public final ba.b f16497f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @yt.l
    public final String f16498g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @yt.k
    public final ColorSwatch f16499h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @yt.k
    public ColorShape f16500i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @yt.l
    public final List<String> f16501j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f16502k;

    @d0(bv = {}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u00105\u001a\u000201¢\u0006\u0004\b?\u0010@J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0006\u001a\u00020\u00002\b\b\u0001\u0010\u0003\u001a\u00020\u0005J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0002J\u0010\u0010\t\u001a\u00020\u00002\b\b\u0001\u0010\u0007\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0002J\u0010\u0010\u000b\u001a\u00020\u00002\b\b\u0001\u0010\u0007\u001a\u00020\u0005J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0002J\u0010\u0010\u000e\u001a\u00020\u00002\b\b\u0001\u0010\f\u001a\u00020\u0005J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0012J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0015J \u0010\u001a\u001a\u00020\u00002\u0018\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00190\u0018J\u0010\u0010\u001c\u001a\u00020\u00002\b\u0010\u0016\u001a\u0004\u0018\u00010\u001bJ\u0014\u0010\u001e\u001a\u00020\u00002\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00190\u001dJ\u0014\u0010!\u001a\u00020\u00002\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00020\u001fJ\u001b\u0010#\u001a\u00020\u00002\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00020\"¢\u0006\u0004\b#\u0010$J\u0014\u0010%\u001a\u00020\u00002\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00050\u001fJ\u000e\u0010'\u001a\u00020\u00002\u0006\u0010 \u001a\u00020&J\u000e\u0010*\u001a\u00020\u00002\u0006\u0010)\u001a\u00020(J\u0006\u0010,\u001a\u00020+J\u0006\u0010-\u001a\u00020\u0019J\u000e\u00100\u001a\u00020\u00192\u0006\u0010/\u001a\u00020.R\u0017\u00105\u001a\u0002018\u0006¢\u0006\f\n\u0004\b,\u00102\u001a\u0004\b3\u00104R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00106R\u0016\u00107\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u00106R\u0016\u00108\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u00106R\u0018\u00109\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u00106R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010:R\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010;R\u001e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010<R\u0016\u0010>\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010=¨\u0006A"}, d2 = {"Lcom/github/dhaval2404/colorpicker/h$a;", "", "", "title", "u", "", "t", "text", SsManifestParser.e.J, "q", "p", "o", "color", l.f16298a, "k", "Lcom/github/dhaval2404/colorpicker/model/ColorShape;", "colorShape", "g", "Lcom/github/dhaval2404/colorpicker/model/ColorSwatch;", "colorSwatch", "h", "Lba/a;", "listener", "c", "Lkotlin/Function2;", "Lkotlin/z1;", "d", "Lba/b;", k.f40564b, "Lkotlin/Function0;", "n", "", "colors", "i", "", j.f55230b, "([Ljava/lang/String;)Lcom/github/dhaval2404/colorpicker/h$a;", "e", "", "f", "", "tickColorPerCard", an.aB, "Lcom/github/dhaval2404/colorpicker/h;", "a", "v", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "w", "Landroid/content/Context;", "Landroid/content/Context;", "b", "()Landroid/content/Context;", com.umeng.analytics.pro.d.R, "Ljava/lang/String;", "positiveButton", "negativeButton", "defaultColor", "Lcom/github/dhaval2404/colorpicker/model/ColorSwatch;", "Lcom/github/dhaval2404/colorpicker/model/ColorShape;", "Ljava/util/List;", "Z", "isTickColorPerCard", "<init>", "(Landroid/content/Context;)V", "colorpicker_release"}, k = 1, mv = {1, 5, 1})
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @yt.k
        public final Context f16503a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @yt.k
        public String f16504b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @yt.k
        public String f16505c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @yt.k
        public String f16506d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @yt.l
        public ba.a f16507e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @yt.l
        public ba.b f16508f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @yt.l
        public String f16509g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @yt.k
        public ColorSwatch f16510h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @yt.k
        public ColorShape f16511i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @yt.l
        public List<String> f16512j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f16513k;

        /* JADX INFO: renamed from: com.github.dhaval2404.colorpicker.h$a$a, reason: collision with other inner class name */
        @d0(bv = {}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\b"}, d2 = {"com/github/dhaval2404/colorpicker/h$a$a", "Lba/a;", "", "color", "", "colorHex", "Lkotlin/z1;", "a", "colorpicker_release"}, k = 1, mv = {1, 5, 1})
        public static final class C0172a implements ba.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ p<Integer, String, z1> f16514a;

            /* JADX WARN: Multi-variable type inference failed */
            public C0172a(p<? super Integer, ? super String, z1> pVar) {
                this.f16514a = pVar;
            }

            @Override // ba.a
            public void a(int i10, @yt.k String colorHex) {
                f0.p(colorHex, "colorHex");
                this.f16514a.r0(Integer.valueOf(i10), colorHex);
            }
        }

        @d0(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"com/github/dhaval2404/colorpicker/h$a$b", "Lba/b;", "Lkotlin/z1;", "onDismiss", "colorpicker_release"}, k = 1, mv = {1, 5, 1})
        public static final class b implements ba.b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ik.a<z1> f16515a;

            public b(ik.a<z1> aVar) {
                this.f16515a = aVar;
            }

            @Override // ba.b
            public void onDismiss() {
                this.f16515a.o();
            }
        }

        public a(@yt.k Context context) {
            f0.p(context, "context");
            this.f16503a = context;
            String string = context.getString(R.string.material_dialog_title);
            f0.o(string, "context.getString(R.string.material_dialog_title)");
            this.f16504b = string;
            String string2 = context.getString(R.string.material_dialog_positive_button);
            f0.o(string2, "context.getString(R.string.material_dialog_positive_button)");
            this.f16505c = string2;
            String string3 = context.getString(R.string.material_dialog_negative_button);
            f0.o(string3, "context.getString(R.string.material_dialog_negative_button)");
            this.f16506d = string3;
            this.f16510h = ColorSwatch._300;
            this.f16511i = ColorShape.CIRCLE;
        }

        @yt.k
        public final h a() {
            return new h(this.f16503a, this.f16504b, this.f16505c, this.f16506d, this.f16507e, this.f16508f, this.f16509g, this.f16510h, this.f16511i, this.f16512j, this.f16513k, null);
        }

        @yt.k
        public final Context b() {
            return this.f16503a;
        }

        @yt.k
        public final a c(@yt.k ba.a listener) {
            f0.p(listener, "listener");
            this.f16507e = listener;
            return this;
        }

        @yt.k
        public final a d(@yt.k p<? super Integer, ? super String, z1> listener) {
            f0.p(listener, "listener");
            this.f16507e = new C0172a(listener);
            return this;
        }

        @yt.k
        public final a e(@yt.k List<Integer> colors) {
            f0.p(colors, "colors");
            ArrayList arrayList = new ArrayList(t.Y(colors, 10));
            Iterator<T> it2 = colors.iterator();
            while (it2.hasNext()) {
                int iIntValue = ((Number) it2.next()).intValue();
                ca.b bVar = ca.b.f10676a;
                arrayList.add(ca.b.a(iIntValue));
            }
            this.f16512j = arrayList;
            return this;
        }

        @yt.k
        public final a f(@yt.k int[] colors) {
            f0.p(colors, "colors");
            ArrayList arrayList = new ArrayList(colors.length);
            for (int i10 : colors) {
                ca.b bVar = ca.b.f10676a;
                arrayList.add(ca.b.a(i10));
            }
            this.f16512j = arrayList;
            return this;
        }

        @yt.k
        public final a g(@yt.k ColorShape colorShape) {
            f0.p(colorShape, "colorShape");
            this.f16511i = colorShape;
            return this;
        }

        @yt.k
        public final a h(@yt.k ColorSwatch colorSwatch) {
            f0.p(colorSwatch, "colorSwatch");
            this.f16510h = colorSwatch;
            return this;
        }

        @yt.k
        public final a i(@yt.k List<String> colors) {
            f0.p(colors, "colors");
            this.f16512j = colors;
            return this;
        }

        @yt.k
        public final a j(@yt.k String[] colors) {
            f0.p(colors, "colors");
            this.f16512j = ArraysKt___ArraysKt.iz(colors);
            return this;
        }

        @yt.k
        public final a k(@n int i10) {
            ca.b bVar = ca.b.f10676a;
            this.f16509g = ca.b.a(i10);
            return this;
        }

        @yt.k
        public final a l(@yt.k String color) {
            f0.p(color, "color");
            this.f16509g = color;
            return this;
        }

        @yt.k
        public final a m(@yt.l ba.b bVar) {
            this.f16508f = bVar;
            return this;
        }

        @yt.k
        public final a n(@yt.k ik.a<z1> listener) {
            f0.p(listener, "listener");
            this.f16508f = new b(listener);
            return this;
        }

        @yt.k
        public final a o(@c1 int i10) {
            String string = this.f16503a.getString(i10);
            f0.o(string, "context.getString(text)");
            this.f16506d = string;
            return this;
        }

        @yt.k
        public final a p(@yt.k String text) {
            f0.p(text, "text");
            this.f16506d = text;
            return this;
        }

        @yt.k
        public final a q(@c1 int i10) {
            String string = this.f16503a.getString(i10);
            f0.o(string, "context.getString(text)");
            this.f16505c = string;
            return this;
        }

        @yt.k
        public final a r(@yt.k String text) {
            f0.p(text, "text");
            this.f16505c = text;
            return this;
        }

        @yt.k
        public final a s(boolean z10) {
            this.f16513k = z10;
            return this;
        }

        @yt.k
        public final a t(@c1 int i10) {
            String string = this.f16503a.getString(i10);
            f0.o(string, "context.getString(title)");
            this.f16504b = string;
            return this;
        }

        @yt.k
        public final a u(@yt.k String title) {
            f0.p(title, "title");
            this.f16504b = title;
            return this;
        }

        public final void v() {
            a().p();
        }

        public final void w(@yt.k FragmentManager fragmentManager) {
            f0.p(fragmentManager, "fragmentManager");
            a().s(fragmentManager);
        }
    }

    public h(Context context, String str, String str2, String str3, ba.a aVar, ba.b bVar, String str4, ColorSwatch colorSwatch, ColorShape colorShape, List<String> list, boolean z10) {
        this.f16492a = context;
        this.f16493b = str;
        this.f16494c = str2;
        this.f16495d = str3;
        this.f16496e = aVar;
        this.f16497f = bVar;
        this.f16498g = str4;
        this.f16499h = colorSwatch;
        this.f16500i = colorShape;
        this.f16501j = list;
        this.f16502k = z10;
    }

    public /* synthetic */ h(Context context, String str, String str2, String str3, ba.a aVar, ba.b bVar, String str4, ColorSwatch colorSwatch, ColorShape colorShape, List list, boolean z10, u uVar) {
        this(context, str, str2, str3, aVar, bVar, str4, colorSwatch, colorShape, list, z10);
    }

    public static final void q(aa.c adapter, h this$0, DialogInterface dialogInterface, int i10) {
        ba.a aVarC;
        f0.p(adapter, "$adapter");
        f0.p(this$0, "this$0");
        String strS = adapter.s();
        if (!(!kotlin.text.u.V1(strS)) || (aVarC = this$0.c()) == null) {
            return;
        }
        ca.b bVar = ca.b.f10676a;
        aVarC.a(ca.b.k(strS), strS);
    }

    public static final void r(ba.b listener, DialogInterface dialogInterface) {
        f0.p(listener, "$listener");
        listener.onDismiss();
    }

    @yt.l
    public final ba.a c() {
        return this.f16496e;
    }

    @yt.k
    public final ColorShape d() {
        return this.f16500i;
    }

    @yt.k
    public final ColorSwatch e() {
        return this.f16499h;
    }

    @yt.l
    public final List<String> f() {
        return this.f16501j;
    }

    @yt.k
    public final Context g() {
        return this.f16492a;
    }

    @yt.l
    public final String h() {
        return this.f16498g;
    }

    @yt.l
    public final ba.b i() {
        return this.f16497f;
    }

    @yt.k
    public final String j() {
        return this.f16495d;
    }

    @yt.k
    public final String k() {
        return this.f16494c;
    }

    @yt.k
    public final String l() {
        return this.f16493b;
    }

    public final boolean m() {
        return this.f16502k;
    }

    public final void n(@yt.k ColorShape colorShape) {
        f0.p(colorShape, "<set-?>");
        this.f16500i = colorShape;
    }

    public final void o(boolean z10) {
        this.f16502k = z10;
    }

    public final void p() {
        e.a aVarP = new e.a(this.f16492a).setTitle(this.f16493b).p(this.f16495d, null);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f16492a);
        f0.o(layoutInflaterFrom, "from(context)");
        View viewInflate = layoutInflaterFrom.inflate(R.layout.dialog_material_color_picker, (ViewGroup) null);
        Objects.requireNonNull(viewInflate, "null cannot be cast to non-null type android.view.View");
        aVarP.setView(viewInflate);
        List<String> listC = this.f16501j;
        if (listC == null) {
            listC = ca.b.f10676a.c(this.f16492a, this.f16499h.getValue());
        }
        final aa.c cVar = new aa.c(listC);
        cVar.v(this.f16500i);
        cVar.x(this.f16502k);
        String str = this.f16498g;
        if (!(str == null || kotlin.text.u.V1(str))) {
            cVar.w(this.f16498g);
        }
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R.id.materialColorRV);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new FlexboxLayoutManager(this.f16492a));
        recyclerView.setAdapter(cVar);
        aVarP.y(this.f16494c, new DialogInterface.OnClickListener() { // from class: com.github.dhaval2404.colorpicker.f
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                h.q(cVar, this, dialogInterface, i10);
            }
        });
        final ba.b bVar = this.f16497f;
        if (bVar != null) {
            aVarP.v(new DialogInterface.OnDismissListener() { // from class: com.github.dhaval2404.colorpicker.g
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    h.r(bVar, dialogInterface);
                }
            });
        }
        androidx.appcompat.app.e eVarCreate = aVarP.create();
        f0.o(eVarCreate, "dialog.create()");
        eVarCreate.show();
        ca.c.a(eVarCreate);
    }

    public final void s(@yt.k FragmentManager fragmentManager) {
        f0.p(fragmentManager, "fragmentManager");
        MaterialColorPickerBottomSheet.O8.a(this).k6(this.f16496e).l6(this.f16497f).Z5(fragmentManager, "");
    }

    public /* synthetic */ h(Context context, String str, String str2, String str3, ba.a aVar, ba.b bVar, String str4, ColorSwatch colorSwatch, ColorShape colorShape, List list, boolean z10, int i10, u uVar) {
        this(context, str, str2, str3, aVar, bVar, str4, colorSwatch, colorShape, (i10 & 512) != 0 ? null : list, (i10 & 1024) != 0 ? false : z10);
    }
}
