package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import cd.k0;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.c;
import com.google.android.exoplayer2.ui.TrackSelectionView;
import g.p0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: loaded from: classes3.dex */
public class TrackSelectionView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f18671a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LayoutInflater f18672b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CheckedTextView f18673c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CheckedTextView f18674d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f18675e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final SparseArray<DefaultTrackSelector.SelectionOverride> f18676f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f18677g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f18678h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public k0 f18679i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public CheckedTextView[][] f18680j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public c.a f18681k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f18682l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public TrackGroupArray f18683m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f18684n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @p0
    public Comparator<c> f18685o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @p0
    public d f18686p;

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TrackSelectionView.this.g(view);
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f18688a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f18689b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Format f18690c;

        public c(int i10, int i11, Format format) {
            this.f18688a = i10;
            this.f18689b = i11;
            this.f18690c = format;
        }
    }

    public interface d {
        void a(boolean z10, List<DefaultTrackSelector.SelectionOverride> list);
    }

    public TrackSelectionView(Context context) {
        this(context, null);
    }

    public static int[] c(int[] iArr, int i10) {
        int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length + 1);
        iArrCopyOf[iArrCopyOf.length - 1] = i10;
        return iArrCopyOf;
    }

    public static int[] d(int[] iArr, int i10) {
        int[] iArr2 = new int[iArr.length - 1];
        int i11 = 0;
        for (int i12 : iArr) {
            if (i12 != i10) {
                iArr2[i11] = i12;
                i11++;
            }
        }
        return iArr2;
    }

    public static /* synthetic */ int f(Comparator comparator, c cVar, c cVar2) {
        return comparator.compare(cVar.f18690c, cVar2.f18690c);
    }

    public void e(c.a aVar, int i10, boolean z10, List<DefaultTrackSelector.SelectionOverride> list, @p0 final Comparator<Format> comparator, @p0 d dVar) {
        this.f18681k = aVar;
        this.f18682l = i10;
        this.f18684n = z10;
        this.f18685o = comparator == null ? null : new Comparator() { // from class: cd.n0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return TrackSelectionView.f(comparator, (TrackSelectionView.c) obj, (TrackSelectionView.c) obj2);
            }
        };
        this.f18686p = dVar;
        int size = this.f18678h ? list.size() : Math.min(list.size(), 1);
        for (int i11 = 0; i11 < size; i11++) {
            DefaultTrackSelector.SelectionOverride selectionOverride = list.get(i11);
            this.f18676f.put(selectionOverride.f18525a, selectionOverride);
        }
        n();
    }

    public final void g(View view) {
        if (view == this.f18673c) {
            i();
        } else if (view == this.f18674d) {
            h();
        } else {
            j(view);
        }
        m();
        d dVar = this.f18686p;
        if (dVar != null) {
            dVar.a(getIsDisabled(), getOverrides());
        }
    }

    public boolean getIsDisabled() {
        return this.f18684n;
    }

    public List<DefaultTrackSelector.SelectionOverride> getOverrides() {
        ArrayList arrayList = new ArrayList(this.f18676f.size());
        for (int i10 = 0; i10 < this.f18676f.size(); i10++) {
            arrayList.add(this.f18676f.valueAt(i10));
        }
        return arrayList;
    }

    public final void h() {
        this.f18684n = false;
        this.f18676f.clear();
    }

    public final void i() {
        this.f18684n = true;
        this.f18676f.clear();
    }

    public final void j(View view) {
        this.f18684n = false;
        c cVar = (c) hd.a.g(view.getTag());
        int i10 = cVar.f18688a;
        int i11 = cVar.f18689b;
        DefaultTrackSelector.SelectionOverride selectionOverride = this.f18676f.get(i10);
        hd.a.g(this.f18681k);
        if (selectionOverride == null) {
            if (!this.f18678h && this.f18676f.size() > 0) {
                this.f18676f.clear();
            }
            this.f18676f.put(i10, new DefaultTrackSelector.SelectionOverride(i10, i11));
            return;
        }
        int i12 = selectionOverride.f18527c;
        int[] iArr = selectionOverride.f18526b;
        boolean zIsChecked = ((CheckedTextView) view).isChecked();
        boolean zK = k(i10);
        boolean z10 = zK || l();
        if (zIsChecked && z10) {
            if (i12 == 1) {
                this.f18676f.remove(i10);
                return;
            } else {
                this.f18676f.put(i10, new DefaultTrackSelector.SelectionOverride(i10, d(iArr, i11)));
                return;
            }
        }
        if (zIsChecked) {
            return;
        }
        if (zK) {
            this.f18676f.put(i10, new DefaultTrackSelector.SelectionOverride(i10, c(iArr, i11)));
        } else {
            this.f18676f.put(i10, new DefaultTrackSelector.SelectionOverride(i10, i11));
        }
    }

    @RequiresNonNull({"mappedTrackInfo"})
    public final boolean k(int i10) {
        return this.f18677g && this.f18683m.a(i10).f17498a > 1 && this.f18681k.a(this.f18682l, i10, false) != 0;
    }

    public final boolean l() {
        return this.f18678h && this.f18683m.f17502a > 1;
    }

    public final void m() {
        this.f18673c.setChecked(this.f18684n);
        this.f18674d.setChecked(!this.f18684n && this.f18676f.size() == 0);
        for (int i10 = 0; i10 < this.f18680j.length; i10++) {
            DefaultTrackSelector.SelectionOverride selectionOverride = this.f18676f.get(i10);
            int i11 = 0;
            while (true) {
                CheckedTextView[][] checkedTextViewArr = this.f18680j;
                if (i11 < checkedTextViewArr[i10].length) {
                    if (selectionOverride != null) {
                        this.f18680j[i10][i11].setChecked(selectionOverride.a(((c) hd.a.g(checkedTextViewArr[i10][i11].getTag())).f18689b));
                    } else {
                        checkedTextViewArr[i10][i11].setChecked(false);
                    }
                    i11++;
                }
            }
        }
    }

    public final void n() {
        for (int childCount = getChildCount() - 1; childCount >= 3; childCount--) {
            removeViewAt(childCount);
        }
        if (this.f18681k == null) {
            this.f18673c.setEnabled(false);
            this.f18674d.setEnabled(false);
            return;
        }
        this.f18673c.setEnabled(true);
        this.f18674d.setEnabled(true);
        TrackGroupArray trackGroupArrayG = this.f18681k.g(this.f18682l);
        this.f18683m = trackGroupArrayG;
        this.f18680j = new CheckedTextView[trackGroupArrayG.f17502a][];
        boolean zL = l();
        int i10 = 0;
        while (true) {
            TrackGroupArray trackGroupArray = this.f18683m;
            if (i10 >= trackGroupArray.f17502a) {
                m();
                return;
            }
            TrackGroup trackGroupA = trackGroupArray.a(i10);
            boolean zK = k(i10);
            CheckedTextView[][] checkedTextViewArr = this.f18680j;
            int i11 = trackGroupA.f17498a;
            checkedTextViewArr[i10] = new CheckedTextView[i11];
            c[] cVarArr = new c[i11];
            for (int i12 = 0; i12 < trackGroupA.f17498a; i12++) {
                cVarArr[i12] = new c(i10, i12, trackGroupA.a(i12));
            }
            Comparator<c> comparator = this.f18685o;
            if (comparator != null) {
                Arrays.sort(cVarArr, comparator);
            }
            for (int i13 = 0; i13 < i11; i13++) {
                if (i13 == 0) {
                    addView(this.f18672b.inflate(R.layout.exo_list_divider, (ViewGroup) this, false));
                }
                CheckedTextView checkedTextView = (CheckedTextView) this.f18672b.inflate((zK || zL) ? android.R.layout.simple_list_item_multiple_choice : android.R.layout.simple_list_item_single_choice, (ViewGroup) this, false);
                checkedTextView.setBackgroundResource(this.f18671a);
                checkedTextView.setText(this.f18679i.a(cVarArr[i13].f18690c));
                checkedTextView.setTag(cVarArr[i13]);
                if (this.f18681k.h(this.f18682l, i10, i13) == 4) {
                    checkedTextView.setFocusable(true);
                    checkedTextView.setOnClickListener(this.f18675e);
                } else {
                    checkedTextView.setFocusable(false);
                    checkedTextView.setEnabled(false);
                }
                this.f18680j[i10][i13] = checkedTextView;
                addView(checkedTextView);
            }
            i10++;
        }
    }

    public void setAllowAdaptiveSelections(boolean z10) {
        if (this.f18677g != z10) {
            this.f18677g = z10;
            n();
        }
    }

    public void setAllowMultipleOverrides(boolean z10) {
        if (this.f18678h != z10) {
            this.f18678h = z10;
            if (!z10 && this.f18676f.size() > 1) {
                for (int size = this.f18676f.size() - 1; size > 0; size--) {
                    this.f18676f.remove(size);
                }
            }
            n();
        }
    }

    public void setShowDisableOption(boolean z10) {
        this.f18673c.setVisibility(z10 ? 0 : 8);
    }

    public void setTrackNameProvider(k0 k0Var) {
        this.f18679i = (k0) hd.a.g(k0Var);
        n();
    }

    public TrackSelectionView(Context context, @p0 AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TrackSelectionView(Context context, @p0 AttributeSet attributeSet, @g.f int i10) {
        super(context, attributeSet, i10);
        setOrientation(1);
        this.f18676f = new SparseArray<>();
        setSaveFromParentEnabled(false);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{android.R.attr.selectableItemBackground});
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        this.f18671a = resourceId;
        typedArrayObtainStyledAttributes.recycle();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        this.f18672b = layoutInflaterFrom;
        b bVar = new b();
        this.f18675e = bVar;
        this.f18679i = new com.google.android.exoplayer2.ui.c(getResources());
        this.f18683m = TrackGroupArray.f17501d;
        CheckedTextView checkedTextView = (CheckedTextView) layoutInflaterFrom.inflate(android.R.layout.simple_list_item_single_choice, (ViewGroup) this, false);
        this.f18673c = checkedTextView;
        checkedTextView.setBackgroundResource(resourceId);
        checkedTextView.setText(R.string.exo_track_selection_none);
        checkedTextView.setEnabled(false);
        checkedTextView.setFocusable(true);
        checkedTextView.setOnClickListener(bVar);
        checkedTextView.setVisibility(8);
        addView(checkedTextView);
        addView(layoutInflaterFrom.inflate(R.layout.exo_list_divider, (ViewGroup) this, false));
        CheckedTextView checkedTextView2 = (CheckedTextView) layoutInflaterFrom.inflate(android.R.layout.simple_list_item_single_choice, (ViewGroup) this, false);
        this.f18674d = checkedTextView2;
        checkedTextView2.setBackgroundResource(resourceId);
        checkedTextView2.setText(R.string.exo_track_selection_auto);
        checkedTextView2.setEnabled(false);
        checkedTextView2.setFocusable(true);
        checkedTextView2.setOnClickListener(bVar);
        addView(checkedTextView2);
    }
}
