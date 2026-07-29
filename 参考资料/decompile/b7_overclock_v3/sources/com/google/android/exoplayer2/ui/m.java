package com.google.android.exoplayer2.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.e;
import cd.k0;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.c;
import g.d1;
import g.p0;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f18987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @d1
    public int f18988b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CharSequence f18989c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c.a f18990d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f18991e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a f18992f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f18993g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f18994h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f18995i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @p0
    public k0 f18996j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f18997k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public List<DefaultTrackSelector.SelectionOverride> f18998l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @p0
    public Comparator<Format> f18999m;

    public interface a {
        void a(boolean z10, List<DefaultTrackSelector.SelectionOverride> list);
    }

    public m(Context context, CharSequence charSequence, c.a aVar, int i10, a aVar2) {
        this.f18987a = context;
        this.f18989c = charSequence;
        this.f18990d = aVar;
        this.f18991e = i10;
        this.f18992f = aVar2;
        this.f18998l = Collections.emptyList();
    }

    public static /* synthetic */ void f(DefaultTrackSelector defaultTrackSelector, DefaultTrackSelector.Parameters parameters, int i10, TrackGroupArray trackGroupArray, boolean z10, List list) {
        defaultTrackSelector.M(com.google.android.exoplayer2.trackselection.e.b(parameters, i10, trackGroupArray, z10, list.isEmpty() ? null : (DefaultTrackSelector.SelectionOverride) list.get(0)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(TrackSelectionView trackSelectionView, DialogInterface dialogInterface, int i10) {
        this.f18992f.a(trackSelectionView.getIsDisabled(), trackSelectionView.getOverrides());
    }

    public Dialog c() {
        Dialog dialogD = d();
        return dialogD == null ? e() : dialogD;
    }

    @p0
    public final Dialog d() {
        try {
            Class cls = Integer.TYPE;
            Object objNewInstance = e.a.class.getConstructor(Context.class, cls).newInstance(this.f18987a, Integer.valueOf(this.f18988b));
            View viewInflate = LayoutInflater.from((Context) e.a.class.getMethod("getContext", new Class[0]).invoke(objNewInstance, new Object[0])).inflate(R.layout.exo_track_selection_dialog, (ViewGroup) null);
            DialogInterface.OnClickListener onClickListenerQ = q(viewInflate);
            e.a.class.getMethod("setTitle", CharSequence.class).invoke(objNewInstance, this.f18989c);
            e.a.class.getMethod("setView", View.class).invoke(objNewInstance, viewInflate);
            e.a.class.getMethod("setPositiveButton", cls, DialogInterface.OnClickListener.class).invoke(objNewInstance, Integer.valueOf(android.R.string.ok), onClickListenerQ);
            e.a.class.getMethod("setNegativeButton", cls, DialogInterface.OnClickListener.class).invoke(objNewInstance, Integer.valueOf(android.R.string.cancel), null);
            return (Dialog) e.a.class.getMethod("create", new Class[0]).invoke(objNewInstance, new Object[0]);
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (Exception e10) {
            throw new IllegalStateException(e10);
        }
    }

    public final Dialog e() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f18987a, this.f18988b);
        View viewInflate = LayoutInflater.from(builder.getContext()).inflate(R.layout.exo_track_selection_dialog, (ViewGroup) null);
        return builder.setTitle(this.f18989c).setView(viewInflate).setPositiveButton(android.R.string.ok, q(viewInflate)).setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) null).create();
    }

    public m h(boolean z10) {
        this.f18993g = z10;
        return this;
    }

    public m i(boolean z10) {
        this.f18994h = z10;
        return this;
    }

    public m j(boolean z10) {
        this.f18997k = z10;
        return this;
    }

    public m k(@p0 DefaultTrackSelector.SelectionOverride selectionOverride) {
        return l(selectionOverride == null ? Collections.emptyList() : Collections.singletonList(selectionOverride));
    }

    public m l(List<DefaultTrackSelector.SelectionOverride> list) {
        this.f18998l = list;
        return this;
    }

    public m m(boolean z10) {
        this.f18995i = z10;
        return this;
    }

    public m n(@d1 int i10) {
        this.f18988b = i10;
        return this;
    }

    public void o(@p0 Comparator<Format> comparator) {
        this.f18999m = comparator;
    }

    public m p(@p0 k0 k0Var) {
        this.f18996j = k0Var;
        return this;
    }

    public final DialogInterface.OnClickListener q(View view) {
        final TrackSelectionView trackSelectionView = (TrackSelectionView) view.findViewById(R.id.exo_track_selection_view);
        trackSelectionView.setAllowMultipleOverrides(this.f18994h);
        trackSelectionView.setAllowAdaptiveSelections(this.f18993g);
        trackSelectionView.setShowDisableOption(this.f18995i);
        k0 k0Var = this.f18996j;
        if (k0Var != null) {
            trackSelectionView.setTrackNameProvider(k0Var);
        }
        trackSelectionView.e(this.f18990d, this.f18991e, this.f18997k, this.f18998l, this.f18999m, null);
        return new DialogInterface.OnClickListener() { // from class: cd.l0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                this.f10904a.g(trackSelectionView, dialogInterface, i10);
            }
        };
    }

    public m(Context context, CharSequence charSequence, final DefaultTrackSelector defaultTrackSelector, final int i10) {
        this.f18987a = context;
        this.f18989c = charSequence;
        c.a aVar = (c.a) hd.a.g(defaultTrackSelector.g());
        this.f18990d = aVar;
        this.f18991e = i10;
        final TrackGroupArray trackGroupArrayG = aVar.g(i10);
        final DefaultTrackSelector.Parameters parametersV = defaultTrackSelector.v();
        this.f18997k = parametersV.M(i10);
        DefaultTrackSelector.SelectionOverride selectionOverrideS = parametersV.S(i10, trackGroupArrayG);
        this.f18998l = selectionOverrideS == null ? Collections.emptyList() : Collections.singletonList(selectionOverrideS);
        this.f18992f = new a() { // from class: cd.m0
            @Override // com.google.android.exoplayer2.ui.m.a
            public final void a(boolean z10, List list) {
                com.google.android.exoplayer2.ui.m.f(defaultTrackSelector, parametersV, i10, trackGroupArrayG, z10, list);
            }
        };
    }
}
