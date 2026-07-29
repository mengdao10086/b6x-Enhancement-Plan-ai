package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.widget.i0;
import androidx.core.view.u0;
import androidx.core.widget.NestedScrollView;
import g.p0;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class AlertController {
    public NestedScrollView A;
    public Drawable C;
    public ImageView D;
    public TextView E;
    public TextView F;
    public View G;
    public ListAdapter H;
    public int J;
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public boolean P;
    public Handler R;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f1439b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Window f1440c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f1441d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CharSequence f1442e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CharSequence f1443f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ListView f1444g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f1445h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f1446i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f1447j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f1448k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f1449l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f1450m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Button f1452o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public CharSequence f1453p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Message f1454q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Drawable f1455r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Button f1456s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public CharSequence f1457t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Message f1458u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Drawable f1459v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Button f1460w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public CharSequence f1461x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Message f1462y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Drawable f1463z;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f1451n = false;
    public int B = 0;
    public int I = -1;
    public int Q = 0;
    public final View.OnClickListener S = new a();

    public static class RecycleListView extends ListView {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f1464a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f1465b;

        public RecycleListView(Context context) {
            this(context, null);
        }

        public void a(boolean z10, boolean z11) {
            if (z11 && z10) {
                return;
            }
            setPadding(getPaddingLeft(), z10 ? getPaddingTop() : this.f1464a, getPaddingRight(), z11 ? getPaddingBottom() : this.f1465b);
        }

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RecycleListView);
            this.f1465b = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.RecycleListView_paddingBottomNoButtons, -1);
            this.f1464a = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.RecycleListView_paddingTopNoTitle, -1);
        }
    }

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Message message;
            Message message2;
            Message message3;
            AlertController alertController = AlertController.this;
            Message messageObtain = (view != alertController.f1452o || (message3 = alertController.f1454q) == null) ? (view != alertController.f1456s || (message2 = alertController.f1458u) == null) ? (view != alertController.f1460w || (message = alertController.f1462y) == null) ? null : Message.obtain(message) : Message.obtain(message2) : Message.obtain(message3);
            if (messageObtain != null) {
                messageObtain.sendToTarget();
            }
            AlertController alertController2 = AlertController.this;
            alertController2.R.obtainMessage(1, alertController2.f1439b).sendToTarget();
        }
    }

    public class b implements NestedScrollView.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f1467a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f1468b;

        public b(View view, View view2) {
            this.f1467a = view;
            this.f1468b = view2;
        }

        @Override // androidx.core.widget.NestedScrollView.c
        public void a(NestedScrollView nestedScrollView, int i10, int i11, int i12, int i13) {
            AlertController.g(nestedScrollView, this.f1467a, this.f1468b);
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f1470a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f1471b;

        public c(View view, View view2) {
            this.f1470a = view;
            this.f1471b = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            AlertController.g(AlertController.this.A, this.f1470a, this.f1471b);
        }
    }

    public class d implements AbsListView.OnScrollListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f1473a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f1474b;

        public d(View view, View view2) {
            this.f1473a = view;
            this.f1474b = view2;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i10, int i11, int i12) {
            AlertController.g(absListView, this.f1473a, this.f1474b);
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i10) {
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f1476a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f1477b;

        public e(View view, View view2) {
            this.f1476a = view;
            this.f1477b = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            AlertController.g(AlertController.this.f1444g, this.f1476a, this.f1477b);
        }
    }

    public static class f {
        public int A;
        public int B;
        public int C;
        public int D;
        public boolean[] F;
        public boolean G;
        public boolean H;
        public DialogInterface.OnMultiChoiceClickListener J;
        public Cursor K;
        public String L;
        public String M;
        public boolean N;
        public AdapterView.OnItemSelectedListener O;
        public e P;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f1479a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final LayoutInflater f1480b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Drawable f1482d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public CharSequence f1484f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public View f1485g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public CharSequence f1486h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public CharSequence f1487i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Drawable f1488j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public DialogInterface.OnClickListener f1489k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public CharSequence f1490l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public Drawable f1491m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public DialogInterface.OnClickListener f1492n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public CharSequence f1493o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public Drawable f1494p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public DialogInterface.OnClickListener f1495q;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public DialogInterface.OnCancelListener f1497s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public DialogInterface.OnDismissListener f1498t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public DialogInterface.OnKeyListener f1499u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public CharSequence[] f1500v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public ListAdapter f1501w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public DialogInterface.OnClickListener f1502x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public int f1503y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public View f1504z;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f1481c = 0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f1483e = 0;
        public boolean E = false;
        public int I = -1;
        public boolean Q = true;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public boolean f1496r = true;

        public class a extends ArrayAdapter<CharSequence> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ RecycleListView f1505a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Context context, int i10, int i11, CharSequence[] charSequenceArr, RecycleListView recycleListView) {
                super(context, i10, i11, charSequenceArr);
                this.f1505a = recycleListView;
            }

            @Override // android.widget.ArrayAdapter, android.widget.Adapter
            public View getView(int i10, View view, ViewGroup viewGroup) {
                View view2 = super.getView(i10, view, viewGroup);
                boolean[] zArr = f.this.F;
                if (zArr != null && zArr[i10]) {
                    this.f1505a.setItemChecked(i10, true);
                }
                return view2;
            }
        }

        public class b extends CursorAdapter {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f1507a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final int f1508b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ RecycleListView f1509c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ AlertController f1510d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(Context context, Cursor cursor, boolean z10, RecycleListView recycleListView, AlertController alertController) {
                super(context, cursor, z10);
                this.f1509c = recycleListView;
                this.f1510d = alertController;
                Cursor cursor2 = getCursor();
                this.f1507a = cursor2.getColumnIndexOrThrow(f.this.L);
                this.f1508b = cursor2.getColumnIndexOrThrow(f.this.M);
            }

            @Override // android.widget.CursorAdapter
            public void bindView(View view, Context context, Cursor cursor) {
                ((CheckedTextView) view.findViewById(android.R.id.text1)).setText(cursor.getString(this.f1507a));
                this.f1509c.setItemChecked(cursor.getPosition(), cursor.getInt(this.f1508b) == 1);
            }

            @Override // android.widget.CursorAdapter
            public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                return f.this.f1480b.inflate(this.f1510d.M, viewGroup, false);
            }
        }

        public class c implements AdapterView.OnItemClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ AlertController f1512a;

            public c(AlertController alertController) {
                this.f1512a = alertController;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
                f.this.f1502x.onClick(this.f1512a.f1439b, i10);
                if (f.this.H) {
                    return;
                }
                this.f1512a.f1439b.dismiss();
            }
        }

        public class d implements AdapterView.OnItemClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ RecycleListView f1514a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ AlertController f1515b;

            public d(RecycleListView recycleListView, AlertController alertController) {
                this.f1514a = recycleListView;
                this.f1515b = alertController;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
                boolean[] zArr = f.this.F;
                if (zArr != null) {
                    zArr[i10] = this.f1514a.isItemChecked(i10);
                }
                f.this.J.onClick(this.f1515b.f1439b, i10, this.f1514a.isItemChecked(i10));
            }
        }

        public interface e {
            void a(ListView listView);
        }

        public f(Context context) {
            this.f1479a = context;
            this.f1480b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        public void a(AlertController alertController) {
            View view = this.f1485g;
            if (view != null) {
                alertController.n(view);
            } else {
                CharSequence charSequence = this.f1484f;
                if (charSequence != null) {
                    alertController.s(charSequence);
                }
                Drawable drawable = this.f1482d;
                if (drawable != null) {
                    alertController.p(drawable);
                }
                int i10 = this.f1481c;
                if (i10 != 0) {
                    alertController.o(i10);
                }
                int i11 = this.f1483e;
                if (i11 != 0) {
                    alertController.o(alertController.d(i11));
                }
            }
            CharSequence charSequence2 = this.f1486h;
            if (charSequence2 != null) {
                alertController.q(charSequence2);
            }
            CharSequence charSequence3 = this.f1487i;
            if (charSequence3 != null || this.f1488j != null) {
                alertController.l(-1, charSequence3, this.f1489k, null, this.f1488j);
            }
            CharSequence charSequence4 = this.f1490l;
            if (charSequence4 != null || this.f1491m != null) {
                alertController.l(-2, charSequence4, this.f1492n, null, this.f1491m);
            }
            CharSequence charSequence5 = this.f1493o;
            if (charSequence5 != null || this.f1494p != null) {
                alertController.l(-3, charSequence5, this.f1495q, null, this.f1494p);
            }
            if (this.f1500v != null || this.K != null || this.f1501w != null) {
                b(alertController);
            }
            View view2 = this.f1504z;
            if (view2 != null) {
                if (this.E) {
                    alertController.v(view2, this.A, this.B, this.C, this.D);
                    return;
                } else {
                    alertController.u(view2);
                    return;
                }
            }
            int i12 = this.f1503y;
            if (i12 != 0) {
                alertController.t(i12);
            }
        }

        public final void b(AlertController alertController) {
            ListAdapter hVar;
            RecycleListView recycleListView = (RecycleListView) this.f1480b.inflate(alertController.L, (ViewGroup) null);
            if (this.G) {
                hVar = this.K == null ? new a(this.f1479a, alertController.M, android.R.id.text1, this.f1500v, recycleListView) : new b(this.f1479a, this.K, false, recycleListView, alertController);
            } else {
                int i10 = this.H ? alertController.N : alertController.O;
                if (this.K != null) {
                    hVar = new SimpleCursorAdapter(this.f1479a, i10, this.K, new String[]{this.L}, new int[]{android.R.id.text1});
                } else {
                    hVar = this.f1501w;
                    if (hVar == null) {
                        hVar = new h(this.f1479a, i10, android.R.id.text1, this.f1500v);
                    }
                }
            }
            e eVar = this.P;
            if (eVar != null) {
                eVar.a(recycleListView);
            }
            alertController.H = hVar;
            alertController.I = this.I;
            if (this.f1502x != null) {
                recycleListView.setOnItemClickListener(new c(alertController));
            } else if (this.J != null) {
                recycleListView.setOnItemClickListener(new d(recycleListView, alertController));
            }
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.O;
            if (onItemSelectedListener != null) {
                recycleListView.setOnItemSelectedListener(onItemSelectedListener);
            }
            if (this.H) {
                recycleListView.setChoiceMode(1);
            } else if (this.G) {
                recycleListView.setChoiceMode(2);
            }
            alertController.f1444g = recycleListView;
        }
    }

    public static final class g extends Handler {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f1517b = 1;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<DialogInterface> f1518a;

        public g(DialogInterface dialogInterface) {
            this.f1518a = new WeakReference<>(dialogInterface);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == -3 || i10 == -2 || i10 == -1) {
                ((DialogInterface.OnClickListener) message.obj).onClick(this.f1518a.get(), message.what);
            } else {
                if (i10 != 1) {
                    return;
                }
                ((DialogInterface) message.obj).dismiss();
            }
        }
    }

    public static class h extends ArrayAdapter<CharSequence> {
        public h(Context context, int i10, int i11, CharSequence[] charSequenceArr) {
            super(context, i10, i11, charSequenceArr);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int i10) {
            return i10;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return true;
        }
    }

    public AlertController(Context context, j jVar, Window window) {
        this.f1438a = context;
        this.f1439b = jVar;
        this.f1440c = window;
        this.R = new g(jVar);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, R.styleable.AlertDialog, R.attr.alertDialogStyle, 0);
        this.J = typedArrayObtainStyledAttributes.getResourceId(R.styleable.AlertDialog_android_layout, 0);
        this.K = typedArrayObtainStyledAttributes.getResourceId(R.styleable.AlertDialog_buttonPanelSideLayout, 0);
        this.L = typedArrayObtainStyledAttributes.getResourceId(R.styleable.AlertDialog_listLayout, 0);
        this.M = typedArrayObtainStyledAttributes.getResourceId(R.styleable.AlertDialog_multiChoiceItemLayout, 0);
        this.N = typedArrayObtainStyledAttributes.getResourceId(R.styleable.AlertDialog_singleChoiceItemLayout, 0);
        this.O = typedArrayObtainStyledAttributes.getResourceId(R.styleable.AlertDialog_listItemLayout, 0);
        this.P = typedArrayObtainStyledAttributes.getBoolean(R.styleable.AlertDialog_showTitle, true);
        this.f1441d = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.AlertDialog_buttonIconDimen, 0);
        typedArrayObtainStyledAttributes.recycle();
        jVar.k(1);
    }

    public static boolean B(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogCenterButtons, typedValue, true);
        return typedValue.data != 0;
    }

    public static boolean a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    public static void g(View view, View view2, View view3) {
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            view3.setVisibility(view.canScrollVertically(1) ? 0 : 4);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void A() {
        View viewFindViewById;
        ListAdapter listAdapter;
        View viewFindViewById2;
        View viewFindViewById3 = this.f1440c.findViewById(R.id.parentPanel);
        int i10 = R.id.topPanel;
        View viewFindViewById4 = viewFindViewById3.findViewById(i10);
        int i11 = R.id.contentPanel;
        View viewFindViewById5 = viewFindViewById3.findViewById(i11);
        int i12 = R.id.buttonPanel;
        View viewFindViewById6 = viewFindViewById3.findViewById(i12);
        ViewGroup viewGroup = (ViewGroup) viewFindViewById3.findViewById(R.id.customPanel);
        y(viewGroup);
        View viewFindViewById7 = viewGroup.findViewById(i10);
        View viewFindViewById8 = viewGroup.findViewById(i11);
        View viewFindViewById9 = viewGroup.findViewById(i12);
        ViewGroup viewGroupJ = j(viewFindViewById7, viewFindViewById4);
        ViewGroup viewGroupJ2 = j(viewFindViewById8, viewFindViewById5);
        ViewGroup viewGroupJ3 = j(viewFindViewById9, viewFindViewById6);
        x(viewGroupJ2);
        w(viewGroupJ3);
        z(viewGroupJ);
        boolean z10 = viewGroup.getVisibility() != 8;
        boolean z11 = (viewGroupJ == null || viewGroupJ.getVisibility() == 8) ? 0 : 1;
        boolean z12 = (viewGroupJ3 == null || viewGroupJ3.getVisibility() == 8) ? false : true;
        if (!z12 && viewGroupJ2 != null && (viewFindViewById2 = viewGroupJ2.findViewById(R.id.textSpacerNoButtons)) != null) {
            viewFindViewById2.setVisibility(0);
        }
        if (z11 != 0) {
            NestedScrollView nestedScrollView = this.A;
            if (nestedScrollView != null) {
                nestedScrollView.setClipToPadding(true);
            }
            View viewFindViewById10 = (this.f1443f == null && this.f1444g == null) ? null : viewGroupJ.findViewById(R.id.titleDividerNoCustom);
            if (viewFindViewById10 != null) {
                viewFindViewById10.setVisibility(0);
            }
        } else if (viewGroupJ2 != null && (viewFindViewById = viewGroupJ2.findViewById(R.id.textSpacerNoTitle)) != null) {
            viewFindViewById.setVisibility(0);
        }
        ListView listView = this.f1444g;
        if (listView instanceof RecycleListView) {
            ((RecycleListView) listView).a(z11, z12);
        }
        if (!z10) {
            View view = this.f1444g;
            if (view == null) {
                view = this.A;
            }
            if (view != null) {
                r(viewGroupJ2, view, z11 | (z12 ? 2 : 0), 3);
            }
        }
        ListView listView2 = this.f1444g;
        if (listView2 == null || (listAdapter = this.H) == null) {
            return;
        }
        listView2.setAdapter(listAdapter);
        int i13 = this.I;
        if (i13 > -1) {
            listView2.setItemChecked(i13, true);
            listView2.setSelection(i13);
        }
    }

    public final void b(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }

    public Button c(int i10) {
        if (i10 == -3) {
            return this.f1460w;
        }
        if (i10 == -2) {
            return this.f1456s;
        }
        if (i10 != -1) {
            return null;
        }
        return this.f1452o;
    }

    public int d(int i10) {
        TypedValue typedValue = new TypedValue();
        this.f1438a.getTheme().resolveAttribute(i10, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView e() {
        return this.f1444g;
    }

    public void f() {
        this.f1439b.setContentView(k());
        A();
    }

    public boolean h(int i10, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.A;
        return nestedScrollView != null && nestedScrollView.q(keyEvent);
    }

    public boolean i(int i10, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.A;
        return nestedScrollView != null && nestedScrollView.q(keyEvent);
    }

    @p0
    public final ViewGroup j(@p0 View view, @p0 View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    public final int k() {
        int i10 = this.K;
        return i10 == 0 ? this.J : this.Q == 1 ? i10 : this.J;
    }

    public void l(int i10, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (message == null && onClickListener != null) {
            message = this.R.obtainMessage(i10, onClickListener);
        }
        if (i10 == -3) {
            this.f1461x = charSequence;
            this.f1462y = message;
            this.f1463z = drawable;
        } else if (i10 == -2) {
            this.f1457t = charSequence;
            this.f1458u = message;
            this.f1459v = drawable;
        } else {
            if (i10 != -1) {
                throw new IllegalArgumentException("Button does not exist");
            }
            this.f1453p = charSequence;
            this.f1454q = message;
            this.f1455r = drawable;
        }
    }

    public void m(int i10) {
        this.Q = i10;
    }

    public void n(View view) {
        this.G = view;
    }

    public void o(int i10) {
        this.C = null;
        this.B = i10;
        ImageView imageView = this.D;
        if (imageView != null) {
            if (i10 == 0) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                this.D.setImageResource(this.B);
            }
        }
    }

    public void p(Drawable drawable) {
        this.C = drawable;
        this.B = 0;
        ImageView imageView = this.D;
        if (imageView != null) {
            if (drawable == null) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                this.D.setImageDrawable(drawable);
            }
        }
    }

    public void q(CharSequence charSequence) {
        this.f1443f = charSequence;
        TextView textView = this.F;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public final void r(ViewGroup viewGroup, View view, int i10, int i11) {
        View viewFindViewById = this.f1440c.findViewById(R.id.scrollIndicatorUp);
        View viewFindViewById2 = this.f1440c.findViewById(R.id.scrollIndicatorDown);
        if (Build.VERSION.SDK_INT >= 23) {
            u0.p2(view, i10, i11);
            if (viewFindViewById != null) {
                viewGroup.removeView(viewFindViewById);
            }
            if (viewFindViewById2 != null) {
                viewGroup.removeView(viewFindViewById2);
                return;
            }
            return;
        }
        if (viewFindViewById != null && (i10 & 1) == 0) {
            viewGroup.removeView(viewFindViewById);
            viewFindViewById = null;
        }
        if (viewFindViewById2 != null && (i10 & 2) == 0) {
            viewGroup.removeView(viewFindViewById2);
            viewFindViewById2 = null;
        }
        if (viewFindViewById == null && viewFindViewById2 == null) {
            return;
        }
        if (this.f1443f != null) {
            this.A.setOnScrollChangeListener(new b(viewFindViewById, viewFindViewById2));
            this.A.post(new c(viewFindViewById, viewFindViewById2));
            return;
        }
        ListView listView = this.f1444g;
        if (listView != null) {
            listView.setOnScrollListener(new d(viewFindViewById, viewFindViewById2));
            this.f1444g.post(new e(viewFindViewById, viewFindViewById2));
            return;
        }
        if (viewFindViewById != null) {
            viewGroup.removeView(viewFindViewById);
        }
        if (viewFindViewById2 != null) {
            viewGroup.removeView(viewFindViewById2);
        }
    }

    public void s(CharSequence charSequence) {
        this.f1442e = charSequence;
        TextView textView = this.E;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void t(int i10) {
        this.f1445h = null;
        this.f1446i = i10;
        this.f1451n = false;
    }

    public void u(View view) {
        this.f1445h = view;
        this.f1446i = 0;
        this.f1451n = false;
    }

    public void v(View view, int i10, int i11, int i12, int i13) {
        this.f1445h = view;
        this.f1446i = 0;
        this.f1451n = true;
        this.f1447j = i10;
        this.f1448k = i11;
        this.f1449l = i12;
        this.f1450m = i13;
    }

    public final void w(ViewGroup viewGroup) {
        int i10;
        Button button = (Button) viewGroup.findViewById(android.R.id.button1);
        this.f1452o = button;
        button.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.f1453p) && this.f1455r == null) {
            this.f1452o.setVisibility(8);
            i10 = 0;
        } else {
            this.f1452o.setText(this.f1453p);
            Drawable drawable = this.f1455r;
            if (drawable != null) {
                int i11 = this.f1441d;
                drawable.setBounds(0, 0, i11, i11);
                this.f1452o.setCompoundDrawables(this.f1455r, null, null, null);
            }
            this.f1452o.setVisibility(0);
            i10 = 1;
        }
        Button button2 = (Button) viewGroup.findViewById(android.R.id.button2);
        this.f1456s = button2;
        button2.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.f1457t) && this.f1459v == null) {
            this.f1456s.setVisibility(8);
        } else {
            this.f1456s.setText(this.f1457t);
            Drawable drawable2 = this.f1459v;
            if (drawable2 != null) {
                int i12 = this.f1441d;
                drawable2.setBounds(0, 0, i12, i12);
                this.f1456s.setCompoundDrawables(this.f1459v, null, null, null);
            }
            this.f1456s.setVisibility(0);
            i10 |= 2;
        }
        Button button3 = (Button) viewGroup.findViewById(android.R.id.button3);
        this.f1460w = button3;
        button3.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.f1461x) && this.f1463z == null) {
            this.f1460w.setVisibility(8);
        } else {
            this.f1460w.setText(this.f1461x);
            Drawable drawable3 = this.f1463z;
            if (drawable3 != null) {
                int i13 = this.f1441d;
                drawable3.setBounds(0, 0, i13, i13);
                this.f1460w.setCompoundDrawables(this.f1463z, null, null, null);
            }
            this.f1460w.setVisibility(0);
            i10 |= 4;
        }
        if (B(this.f1438a)) {
            if (i10 == 1) {
                b(this.f1452o);
            } else if (i10 == 2) {
                b(this.f1456s);
            } else if (i10 == 4) {
                b(this.f1460w);
            }
        }
        if (i10 != 0) {
            return;
        }
        viewGroup.setVisibility(8);
    }

    public final void x(ViewGroup viewGroup) {
        NestedScrollView nestedScrollView = (NestedScrollView) this.f1440c.findViewById(R.id.scrollView);
        this.A = nestedScrollView;
        nestedScrollView.setFocusable(false);
        this.A.setNestedScrollingEnabled(false);
        TextView textView = (TextView) viewGroup.findViewById(android.R.id.message);
        this.F = textView;
        if (textView == null) {
            return;
        }
        CharSequence charSequence = this.f1443f;
        if (charSequence != null) {
            textView.setText(charSequence);
            return;
        }
        textView.setVisibility(8);
        this.A.removeView(this.F);
        if (this.f1444g == null) {
            viewGroup.setVisibility(8);
            return;
        }
        ViewGroup viewGroup2 = (ViewGroup) this.A.getParent();
        int iIndexOfChild = viewGroup2.indexOfChild(this.A);
        viewGroup2.removeViewAt(iIndexOfChild);
        viewGroup2.addView(this.f1444g, iIndexOfChild, new ViewGroup.LayoutParams(-1, -1));
    }

    public final void y(ViewGroup viewGroup) {
        View viewInflate = this.f1445h;
        if (viewInflate == null) {
            viewInflate = this.f1446i != 0 ? LayoutInflater.from(this.f1438a).inflate(this.f1446i, viewGroup, false) : null;
        }
        boolean z10 = viewInflate != null;
        if (!z10 || !a(viewInflate)) {
            this.f1440c.setFlags(131072, 131072);
        }
        if (!z10) {
            viewGroup.setVisibility(8);
            return;
        }
        FrameLayout frameLayout = (FrameLayout) this.f1440c.findViewById(R.id.custom);
        frameLayout.addView(viewInflate, new ViewGroup.LayoutParams(-1, -1));
        if (this.f1451n) {
            frameLayout.setPadding(this.f1447j, this.f1448k, this.f1449l, this.f1450m);
        }
        if (this.f1444g != null) {
            ((LinearLayout.LayoutParams) ((i0.b) viewGroup.getLayoutParams())).weight = 0.0f;
        }
    }

    public final void z(ViewGroup viewGroup) {
        if (this.G != null) {
            viewGroup.addView(this.G, 0, new ViewGroup.LayoutParams(-1, -2));
            this.f1440c.findViewById(R.id.title_template).setVisibility(8);
            return;
        }
        this.D = (ImageView) this.f1440c.findViewById(android.R.id.icon);
        if (!(!TextUtils.isEmpty(this.f1442e)) || !this.P) {
            this.f1440c.findViewById(R.id.title_template).setVisibility(8);
            this.D.setVisibility(8);
            viewGroup.setVisibility(8);
            return;
        }
        TextView textView = (TextView) this.f1440c.findViewById(R.id.alertTitle);
        this.E = textView;
        textView.setText(this.f1442e);
        int i10 = this.B;
        if (i10 != 0) {
            this.D.setImageResource(i10);
            return;
        }
        Drawable drawable = this.C;
        if (drawable != null) {
            this.D.setImageDrawable(drawable);
        } else {
            this.E.setPadding(this.D.getPaddingLeft(), this.D.getPaddingTop(), this.D.getPaddingRight(), this.D.getPaddingBottom());
            this.D.setVisibility(8);
        }
    }
}
