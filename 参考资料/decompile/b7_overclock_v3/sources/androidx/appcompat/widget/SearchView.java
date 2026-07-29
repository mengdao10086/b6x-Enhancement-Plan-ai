package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.customview.view.AbsSavedState;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class SearchView extends i0 implements l.c {

    /* JADX INFO: renamed from: q8, reason: collision with root package name */
    public static final boolean f2195q8 = false;

    /* JADX INFO: renamed from: r8, reason: collision with root package name */
    public static final String f2196r8 = "SearchView";

    /* JADX INFO: renamed from: s8, reason: collision with root package name */
    public static final String f2197s8 = "nm";

    /* JADX INFO: renamed from: t8, reason: collision with root package name */
    public static final o f2198t8;
    public final SearchAutoComplete B;
    public final View C;
    public final ImageView C1;
    public Rect C2;
    public final View D;
    public int[] E7;
    public int[] F7;
    public final ImageView G7;
    public final Drawable H7;
    public final int I7;
    public final int J7;
    public final ImageView K0;
    public final View K1;
    public Rect K2;
    public final Intent K7;
    public final Intent L7;
    public final CharSequence M7;
    public m N7;
    public l O7;
    public View.OnFocusChangeListener P7;
    public n Q7;
    public View.OnClickListener R7;
    public boolean S7;
    public boolean T7;
    public d1.a U7;
    public boolean V7;
    public CharSequence W7;
    public boolean X7;
    public boolean Y7;
    public int Z7;

    /* JADX INFO: renamed from: a8, reason: collision with root package name */
    public boolean f2199a8;

    /* JADX INFO: renamed from: b8, reason: collision with root package name */
    public CharSequence f2200b8;

    /* JADX INFO: renamed from: c8, reason: collision with root package name */
    public CharSequence f2201c8;

    /* JADX INFO: renamed from: d8, reason: collision with root package name */
    public boolean f2202d8;

    /* JADX INFO: renamed from: e8, reason: collision with root package name */
    public int f2203e8;

    /* JADX INFO: renamed from: f8, reason: collision with root package name */
    public SearchableInfo f2204f8;

    /* JADX INFO: renamed from: g8, reason: collision with root package name */
    public Bundle f2205g8;

    /* JADX INFO: renamed from: h8, reason: collision with root package name */
    public final Runnable f2206h8;

    /* JADX INFO: renamed from: i8, reason: collision with root package name */
    public Runnable f2207i8;

    /* JADX INFO: renamed from: j8, reason: collision with root package name */
    public final WeakHashMap<String, Drawable.ConstantState> f2208j8;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public final View f2209k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public final ImageView f2210k1;

    /* JADX INFO: renamed from: k8, reason: collision with root package name */
    public final View.OnClickListener f2211k8;

    /* JADX INFO: renamed from: l8, reason: collision with root package name */
    public View.OnKeyListener f2212l8;

    /* JADX INFO: renamed from: m8, reason: collision with root package name */
    public final TextView.OnEditorActionListener f2213m8;

    /* JADX INFO: renamed from: n8, reason: collision with root package name */
    public final AdapterView.OnItemClickListener f2214n8;

    /* JADX INFO: renamed from: o8, reason: collision with root package name */
    public final AdapterView.OnItemSelectedListener f2215o8;

    /* JADX INFO: renamed from: p8, reason: collision with root package name */
    public TextWatcher f2216p8;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public final ImageView f2217v1;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public p f2218v2;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f2219c;

        public class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.f2219c + zc.a.f58317e;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeValue(Boolean.valueOf(this.f2219c));
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f2219c = ((Boolean) parcel.readValue(null)).booleanValue();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static class SearchAutoComplete extends androidx.appcompat.widget.d {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f2220e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public SearchView f2221f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f2222g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Runnable f2223h;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SearchAutoComplete.this.e();
            }
        }

        public SearchAutoComplete(Context context) {
            this(context, null);
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i10 = configuration.screenWidthDp;
            int i11 = configuration.screenHeightDp;
            if (i10 >= 960 && i11 >= 720 && configuration.orientation == 2) {
                return 256;
            }
            if (i10 < 600) {
                return (i10 < 640 || i11 < 480) ? 160 : 192;
            }
            return 192;
        }

        public void c() {
            if (Build.VERSION.SDK_INT < 29) {
                SearchView.f2198t8.c(this);
                return;
            }
            k.b(this, 1);
            if (enoughToFilter()) {
                showDropDown();
            }
        }

        public boolean d() {
            return TextUtils.getTrimmedLength(getText()) == 0;
        }

        public void e() {
            if (this.f2222g) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                this.f2222g = false;
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public boolean enoughToFilter() {
            return this.f2220e <= 0 || super.enoughToFilter();
        }

        @Override // androidx.appcompat.widget.d, android.widget.TextView, android.view.View
        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.f2222g) {
                removeCallbacks(this.f2223h);
                post(this.f2223h);
            }
            return inputConnectionOnCreateInputConnection;
        }

        @Override // android.view.View
        public void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onFocusChanged(boolean z10, int i10, Rect rect) {
            super.onFocusChanged(z10, i10, rect);
            this.f2221f.g0();
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public boolean onKeyPreIme(int i10, KeyEvent keyEvent) {
            if (i10 == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                }
                if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.f2221f.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i10, keyEvent);
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onWindowFocusChanged(boolean z10) {
            super.onWindowFocusChanged(z10);
            if (z10 && this.f2221f.hasFocus() && getVisibility() == 0) {
                this.f2222g = true;
                if (SearchView.R(getContext())) {
                    c();
                }
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public void performCompletion() {
        }

        @Override // android.widget.AutoCompleteTextView
        public void replaceText(CharSequence charSequence) {
        }

        public void setImeVisibility(boolean z10) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (!z10) {
                this.f2222g = false;
                removeCallbacks(this.f2223h);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else {
                if (!inputMethodManager.isActive(this)) {
                    this.f2222g = true;
                    return;
                }
                this.f2222g = false;
                removeCallbacks(this.f2223h);
                inputMethodManager.showSoftInput(this, 0);
            }
        }

        public void setSearchView(SearchView searchView) {
            this.f2221f = searchView;
        }

        @Override // android.widget.AutoCompleteTextView
        public void setThreshold(int i10) {
            super.setThreshold(i10);
            this.f2220e = i10;
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, R.attr.autoCompleteTextViewStyle);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i10) {
            super(context, attributeSet, i10);
            this.f2223h = new a();
            this.f2220e = getThreshold();
        }
    }

    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            SearchView.this.f0(charSequence);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SearchView.this.n0();
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d1.a aVar = SearchView.this.U7;
            if (aVar instanceof s0) {
                aVar.b(null);
            }
        }
    }

    public class d implements View.OnFocusChangeListener {
        public d() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z10) {
            SearchView searchView = SearchView.this;
            View.OnFocusChangeListener onFocusChangeListener = searchView.P7;
            if (onFocusChangeListener != null) {
                onFocusChangeListener.onFocusChange(searchView, z10);
            }
        }
    }

    public class e implements View.OnLayoutChangeListener {
        public e() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
            SearchView.this.F();
        }
    }

    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SearchView searchView = SearchView.this;
            if (view == searchView.K0) {
                searchView.c0();
                return;
            }
            if (view == searchView.f2217v1) {
                searchView.Y();
                return;
            }
            if (view == searchView.f2210k1) {
                searchView.d0();
            } else if (view == searchView.C1) {
                searchView.h0();
            } else if (view == searchView.B) {
                searchView.L();
            }
        }
    }

    public class g implements View.OnKeyListener {
        public g() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i10, KeyEvent keyEvent) {
            SearchView searchView = SearchView.this;
            if (searchView.f2204f8 == null) {
                return false;
            }
            if (searchView.B.isPopupShowing() && SearchView.this.B.getListSelection() != -1) {
                return SearchView.this.e0(view, i10, keyEvent);
            }
            if (SearchView.this.B.d() || !keyEvent.hasNoModifiers() || keyEvent.getAction() != 1 || i10 != 66) {
                return false;
            }
            view.cancelLongPress();
            SearchView searchView2 = SearchView.this;
            searchView2.W(0, null, searchView2.B.getText().toString());
            return true;
        }
    }

    public class h implements TextView.OnEditorActionListener {
        public h() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i10, KeyEvent keyEvent) {
            SearchView.this.d0();
            return true;
        }
    }

    public class i implements AdapterView.OnItemClickListener {
        public i() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
            SearchView.this.Z(i10, 0, null);
        }
    }

    public class j implements AdapterView.OnItemSelectedListener {
        public j() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i10, long j10) {
            SearchView.this.a0(i10);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    @g.v0(29)
    public static class k {
        @g.u
        public static void a(AutoCompleteTextView autoCompleteTextView) {
            autoCompleteTextView.refreshAutoCompleteResults();
        }

        @g.u
        public static void b(SearchAutoComplete searchAutoComplete, int i10) {
            searchAutoComplete.setInputMethodMode(i10);
        }
    }

    public interface l {
        boolean a();
    }

    public interface m {
        boolean a(String str);

        boolean b(String str);
    }

    public interface n {
        boolean a(int i10);

        boolean b(int i10);
    }

    public static class o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Method f2235a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Method f2236b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Method f2237c;

        @SuppressLint({"DiscouragedPrivateApi", "SoonBlockedPrivateApi"})
        public o() {
            this.f2235a = null;
            this.f2236b = null;
            this.f2237c = null;
            d();
            try {
                Method declaredMethod = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                this.f2235a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            try {
                Method declaredMethod2 = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                this.f2236b = declaredMethod2;
                declaredMethod2.setAccessible(true);
            } catch (NoSuchMethodException unused2) {
            }
            try {
                Method method = AutoCompleteTextView.class.getMethod("ensureImeVisible", Boolean.TYPE);
                this.f2237c = method;
                method.setAccessible(true);
            } catch (NoSuchMethodException unused3) {
            }
        }

        public static void d() {
            if (Build.VERSION.SDK_INT >= 29) {
                throw new UnsupportedClassVersionError("This function can only be used for API Level < 29.");
            }
        }

        public void a(AutoCompleteTextView autoCompleteTextView) {
            d();
            Method method = this.f2236b;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        public void b(AutoCompleteTextView autoCompleteTextView) {
            d();
            Method method = this.f2235a;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        public void c(AutoCompleteTextView autoCompleteTextView) {
            d();
            Method method = this.f2237c;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, Boolean.TRUE);
                } catch (Exception unused) {
                }
            }
        }
    }

    public static class p extends TouchDelegate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f2238a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Rect f2239b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Rect f2240c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Rect f2241d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f2242e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f2243f;

        public p(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.f2242e = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            this.f2239b = new Rect();
            this.f2241d = new Rect();
            this.f2240c = new Rect();
            a(rect, rect2);
            this.f2238a = view;
        }

        public void a(Rect rect, Rect rect2) {
            this.f2239b.set(rect);
            this.f2241d.set(rect);
            Rect rect3 = this.f2241d;
            int i10 = this.f2242e;
            rect3.inset(-i10, -i10);
            this.f2240c.set(rect2);
        }

        @Override // android.view.TouchDelegate
        public boolean onTouchEvent(MotionEvent motionEvent) {
            boolean z10;
            boolean z11;
            int x10 = (int) motionEvent.getX();
            int y10 = (int) motionEvent.getY();
            int action = motionEvent.getAction();
            boolean z12 = true;
            if (action != 0) {
                if (action == 1 || action == 2) {
                    z11 = this.f2243f;
                    if (z11 && !this.f2241d.contains(x10, y10)) {
                        z12 = z11;
                        z10 = false;
                    }
                } else {
                    if (action == 3) {
                        z11 = this.f2243f;
                        this.f2243f = false;
                    }
                    z10 = true;
                    z12 = false;
                }
                z12 = z11;
                z10 = true;
            } else {
                if (this.f2239b.contains(x10, y10)) {
                    this.f2243f = true;
                    z10 = true;
                }
                z10 = true;
                z12 = false;
            }
            if (!z12) {
                return false;
            }
            if (!z10 || this.f2240c.contains(x10, y10)) {
                Rect rect = this.f2240c;
                motionEvent.setLocation(x10 - rect.left, y10 - rect.top);
            } else {
                motionEvent.setLocation(this.f2238a.getWidth() / 2, this.f2238a.getHeight() / 2);
            }
            return this.f2238a.dispatchTouchEvent(motionEvent);
        }
    }

    static {
        f2198t8 = Build.VERSION.SDK_INT < 29 ? new o() : null;
    }

    public SearchView(@g.n0 Context context) {
        this(context, null);
    }

    public static boolean R(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_height);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_width);
    }

    private void setQuery(CharSequence charSequence) {
        this.B.setText(charSequence);
        this.B.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    public void F() {
        if (this.K1.getWidth() > 1) {
            Resources resources = getContext().getResources();
            int paddingLeft = this.D.getPaddingLeft();
            Rect rect = new Rect();
            boolean zB = h1.b(this);
            int dimensionPixelSize = this.S7 ? resources.getDimensionPixelSize(R.dimen.abc_dropdownitem_icon_width) + resources.getDimensionPixelSize(R.dimen.abc_dropdownitem_text_padding_left) : 0;
            this.B.getDropDownBackground().getPadding(rect);
            this.B.setDropDownHorizontalOffset(zB ? -rect.left : paddingLeft - (rect.left + dimensionPixelSize));
            this.B.setDropDownWidth((((this.K1.getWidth() + rect.left) + rect.right) + dimensionPixelSize) - paddingLeft);
        }
    }

    public final Intent G(String str, Uri uri, String str2, String str3, int i10, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.f2201c8);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        Bundle bundle = this.f2205g8;
        if (bundle != null) {
            intent.putExtra("app_data", bundle);
        }
        if (i10 != 0) {
            intent.putExtra("action_key", i10);
            intent.putExtra("action_msg", str4);
        }
        intent.setComponent(this.f2204f8.getSearchActivity());
        return intent;
    }

    public final Intent H(Cursor cursor, int i10, String str) {
        int position;
        String strU;
        try {
            try {
                String strU2 = s0.u(cursor, "suggest_intent_action");
                if (strU2 == null) {
                    strU2 = this.f2204f8.getSuggestIntentAction();
                }
                if (strU2 == null) {
                    strU2 = "android.intent.action.SEARCH";
                }
                String str2 = strU2;
                String strU3 = s0.u(cursor, "suggest_intent_data");
                if (strU3 == null) {
                    strU3 = this.f2204f8.getSuggestIntentData();
                }
                if (strU3 != null && (strU = s0.u(cursor, "suggest_intent_data_id")) != null) {
                    strU3 = strU3 + fh.a.f28350w + Uri.encode(strU);
                }
                return G(str2, strU3 == null ? null : Uri.parse(strU3), s0.u(cursor, "suggest_intent_extra_data"), s0.u(cursor, "suggest_intent_query"), i10, str);
            } catch (RuntimeException unused) {
                position = -1;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Search suggestions cursor at row ");
                sb2.append(position);
                sb2.append(" returned exception.");
                return null;
            }
        } catch (RuntimeException unused2) {
            position = cursor.getPosition();
            StringBuilder sb22 = new StringBuilder();
            sb22.append("Search suggestions cursor at row ");
            sb22.append(position);
            sb22.append(" returned exception.");
            return null;
        }
    }

    public final Intent I(Intent intent, SearchableInfo searchableInfo) {
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, 1107296256);
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f2205g8;
        if (bundle2 != null) {
            bundle.putParcelable("app_data", bundle2);
        }
        Intent intent3 = new Intent(intent);
        Resources resources = getResources();
        String string = searchableInfo.getVoiceLanguageModeId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageModeId()) : "free_form";
        String string2 = searchableInfo.getVoicePromptTextId() != 0 ? resources.getString(searchableInfo.getVoicePromptTextId()) : null;
        String string3 = searchableInfo.getVoiceLanguageId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageId()) : null;
        int voiceMaxResults = searchableInfo.getVoiceMaxResults() != 0 ? searchableInfo.getVoiceMaxResults() : 1;
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", string);
        intent3.putExtra("android.speech.extra.PROMPT", string2);
        intent3.putExtra("android.speech.extra.LANGUAGE", string3);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", voiceMaxResults);
        intent3.putExtra("calling_package", searchActivity != null ? searchActivity.flattenToShortString() : null);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    public final Intent J(Intent intent, SearchableInfo searchableInfo) {
        Intent intent2 = new Intent(intent);
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        intent2.putExtra("calling_package", searchActivity == null ? null : searchActivity.flattenToShortString());
        return intent2;
    }

    public final void K() {
        this.B.dismissDropDown();
    }

    public void L() {
        if (Build.VERSION.SDK_INT >= 29) {
            k.a(this.B);
            return;
        }
        o oVar = f2198t8;
        oVar.b(this.B);
        oVar.a(this.B);
    }

    public final void M(View view, Rect rect) {
        view.getLocationInWindow(this.E7);
        getLocationInWindow(this.F7);
        int[] iArr = this.E7;
        int i10 = iArr[1];
        int[] iArr2 = this.F7;
        int i11 = i10 - iArr2[1];
        int i12 = iArr[0] - iArr2[0];
        rect.set(i12, i11, view.getWidth() + i12, view.getHeight() + i11);
    }

    public final CharSequence N(CharSequence charSequence) {
        if (!this.S7 || this.H7 == null) {
            return charSequence;
        }
        int textSize = (int) (((double) this.B.getTextSize()) * 1.25d);
        this.H7.setBounds(0, 0, textSize, textSize);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
        spannableStringBuilder.setSpan(new ImageSpan(this.H7), 1, 2, 33);
        spannableStringBuilder.append(charSequence);
        return spannableStringBuilder;
    }

    public final boolean O() {
        SearchableInfo searchableInfo = this.f2204f8;
        if (searchableInfo == null || !searchableInfo.getVoiceSearchEnabled()) {
            return false;
        }
        Intent intent = null;
        if (this.f2204f8.getVoiceSearchLaunchWebSearch()) {
            intent = this.K7;
        } else if (this.f2204f8.getVoiceSearchLaunchRecognizer()) {
            intent = this.L7;
        }
        return (intent == null || getContext().getPackageManager().resolveActivity(intent, 65536) == null) ? false : true;
    }

    public boolean P() {
        return this.S7;
    }

    public boolean Q() {
        return this.T7;
    }

    public boolean S() {
        return this.X7;
    }

    public final boolean T() {
        return (this.V7 || this.f2199a8) && !Q();
    }

    public boolean U() {
        return this.V7;
    }

    public final void V(Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            getContext().startActivity(intent);
        } catch (RuntimeException unused) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Failed launch activity: ");
            sb2.append(intent);
        }
    }

    public void W(int i10, String str, String str2) {
        getContext().startActivity(G("android.intent.action.SEARCH", null, null, str2, i10, str));
    }

    public final boolean X(int i10, int i11, String str) {
        Cursor cursorC = this.U7.c();
        if (cursorC == null || !cursorC.moveToPosition(i10)) {
            return false;
        }
        V(H(cursorC, i11, str));
        return true;
    }

    public void Y() {
        if (!TextUtils.isEmpty(this.B.getText())) {
            this.B.setText("");
            this.B.requestFocus();
            this.B.setImeVisibility(true);
        } else if (this.S7) {
            l lVar = this.O7;
            if (lVar == null || !lVar.a()) {
                clearFocus();
                s0(true);
            }
        }
    }

    public boolean Z(int i10, int i11, String str) {
        n nVar = this.Q7;
        if (nVar != null && nVar.b(i10)) {
            return false;
        }
        X(i10, 0, null);
        this.B.setImeVisibility(false);
        K();
        return true;
    }

    public boolean a0(int i10) {
        n nVar = this.Q7;
        if (nVar != null && nVar.a(i10)) {
            return false;
        }
        j0(i10);
        return true;
    }

    @Override // l.c
    public void b() {
        if (this.f2202d8) {
            return;
        }
        this.f2202d8 = true;
        int imeOptions = this.B.getImeOptions();
        this.f2203e8 = imeOptions;
        this.B.setImeOptions(imeOptions | CommonNetImpl.FLAG_SHARE_JUMP);
        this.B.setText("");
        setIconified(false);
    }

    public void b0(@g.p0 CharSequence charSequence) {
        setQuery(charSequence);
    }

    public void c0() {
        s0(false);
        this.B.requestFocus();
        this.B.setImeVisibility(true);
        View.OnClickListener onClickListener = this.R7;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void clearFocus() {
        this.Y7 = true;
        super.clearFocus();
        this.B.clearFocus();
        this.B.setImeVisibility(false);
        this.Y7 = false;
    }

    @Override // l.c
    public void d() {
        k0("", false);
        clearFocus();
        s0(true);
        this.B.setImeOptions(this.f2203e8);
        this.f2202d8 = false;
    }

    public void d0() {
        Editable text = this.B.getText();
        if (text == null || TextUtils.getTrimmedLength(text) <= 0) {
            return;
        }
        m mVar = this.N7;
        if (mVar == null || !mVar.b(text.toString())) {
            if (this.f2204f8 != null) {
                W(0, null, text.toString());
            }
            this.B.setImeVisibility(false);
            K();
        }
    }

    public boolean e0(View view, int i10, KeyEvent keyEvent) {
        if (this.f2204f8 != null && this.U7 != null && keyEvent.getAction() == 0 && keyEvent.hasNoModifiers()) {
            if (i10 == 66 || i10 == 84 || i10 == 61) {
                return Z(this.B.getListSelection(), 0, null);
            }
            if (i10 == 21 || i10 == 22) {
                this.B.setSelection(i10 == 21 ? 0 : this.B.length());
                this.B.setListSelection(0);
                this.B.clearListSelection();
                this.B.c();
                return true;
            }
            if (i10 == 19) {
                this.B.getListSelection();
                return false;
            }
        }
        return false;
    }

    public void f0(CharSequence charSequence) {
        Editable text = this.B.getText();
        this.f2201c8 = text;
        boolean z10 = !TextUtils.isEmpty(text);
        r0(z10);
        t0(!z10);
        m0();
        q0();
        if (this.N7 != null && !TextUtils.equals(charSequence, this.f2200b8)) {
            this.N7.a(charSequence.toString());
        }
        this.f2200b8 = charSequence.toString();
    }

    public void g0() {
        s0(Q());
        i0();
        if (this.B.hasFocus()) {
            L();
        }
    }

    public int getImeOptions() {
        return this.B.getImeOptions();
    }

    public int getInputType() {
        return this.B.getInputType();
    }

    public int getMaxWidth() {
        return this.Z7;
    }

    public CharSequence getQuery() {
        return this.B.getText();
    }

    @g.p0
    public CharSequence getQueryHint() {
        CharSequence charSequence = this.W7;
        if (charSequence != null) {
            return charSequence;
        }
        SearchableInfo searchableInfo = this.f2204f8;
        return (searchableInfo == null || searchableInfo.getHintId() == 0) ? this.M7 : getContext().getText(this.f2204f8.getHintId());
    }

    public int getSuggestionCommitIconResId() {
        return this.J7;
    }

    public int getSuggestionRowLayout() {
        return this.I7;
    }

    public d1.a getSuggestionsAdapter() {
        return this.U7;
    }

    public void h0() {
        SearchableInfo searchableInfo = this.f2204f8;
        if (searchableInfo == null) {
            return;
        }
        try {
            if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                getContext().startActivity(J(this.K7, searchableInfo));
            } else if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                getContext().startActivity(I(this.L7, searchableInfo));
            }
        } catch (ActivityNotFoundException unused) {
        }
    }

    public final void i0() {
        post(this.f2206h8);
    }

    public final void j0(int i10) {
        Editable text = this.B.getText();
        Cursor cursorC = this.U7.c();
        if (cursorC == null) {
            return;
        }
        if (!cursorC.moveToPosition(i10)) {
            setQuery(text);
            return;
        }
        CharSequence charSequenceA = this.U7.a(cursorC);
        if (charSequenceA != null) {
            setQuery(charSequenceA);
        } else {
            setQuery(text);
        }
    }

    public void k0(CharSequence charSequence, boolean z10) {
        this.B.setText(charSequence);
        if (charSequence != null) {
            SearchAutoComplete searchAutoComplete = this.B;
            searchAutoComplete.setSelection(searchAutoComplete.length());
            this.f2201c8 = charSequence;
        }
        if (!z10 || TextUtils.isEmpty(charSequence)) {
            return;
        }
        d0();
    }

    public final void m0() {
        boolean z10 = true;
        boolean z11 = !TextUtils.isEmpty(this.B.getText());
        if (!z11 && (!this.S7 || this.f2202d8)) {
            z10 = false;
        }
        this.f2217v1.setVisibility(z10 ? 0 : 8);
        Drawable drawable = this.f2217v1.getDrawable();
        if (drawable != null) {
            drawable.setState(z11 ? ViewGroup.ENABLED_STATE_SET : ViewGroup.EMPTY_STATE_SET);
        }
    }

    public void n0() {
        int[] iArr = this.B.hasFocus() ? ViewGroup.FOCUSED_STATE_SET : ViewGroup.EMPTY_STATE_SET;
        Drawable background = this.D.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.f2209k0.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    public final void o0() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.B;
        if (queryHint == null) {
            queryHint = "";
        }
        searchAutoComplete.setHint(N(queryHint));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.f2206h8);
        post(this.f2207i8);
        super.onDetachedFromWindow();
    }

    @Override // androidx.appcompat.widget.i0, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        if (z10) {
            M(this.B, this.C2);
            Rect rect = this.K2;
            Rect rect2 = this.C2;
            rect.set(rect2.left, 0, rect2.right, i13 - i11);
            p pVar = this.f2218v2;
            if (pVar != null) {
                pVar.a(this.K2, this.C2);
                return;
            }
            p pVar2 = new p(this.K2, this.C2, this.B);
            this.f2218v2 = pVar2;
            setTouchDelegate(pVar2);
        }
    }

    @Override // androidx.appcompat.widget.i0, android.view.View
    public void onMeasure(int i10, int i11) {
        int i12;
        if (Q()) {
            super.onMeasure(i10, i11);
            return;
        }
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        if (mode == Integer.MIN_VALUE) {
            int i13 = this.Z7;
            size = i13 > 0 ? Math.min(i13, size) : Math.min(getPreferredWidth(), size);
        } else if (mode == 0) {
            size = this.Z7;
            if (size <= 0) {
                size = getPreferredWidth();
            }
        } else if (mode == 1073741824 && (i12 = this.Z7) > 0) {
            size = Math.min(i12, size);
        }
        int mode2 = View.MeasureSpec.getMode(i11);
        int size2 = View.MeasureSpec.getSize(i11);
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(getPreferredHeight(), size2);
        } else if (mode2 == 0) {
            size2 = getPreferredHeight();
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        s0(savedState.f2219c);
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f2219c = Q();
        return savedState;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        i0();
    }

    public final void p0() {
        this.B.setThreshold(this.f2204f8.getSuggestThreshold());
        this.B.setImeOptions(this.f2204f8.getImeOptions());
        int inputType = this.f2204f8.getInputType();
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.f2204f8.getSuggestAuthority() != null) {
                inputType = inputType | 65536 | 524288;
            }
        }
        this.B.setInputType(inputType);
        d1.a aVar = this.U7;
        if (aVar != null) {
            aVar.b(null);
        }
        if (this.f2204f8.getSuggestAuthority() != null) {
            s0 s0Var = new s0(getContext(), this, this.f2204f8, this.f2208j8);
            this.U7 = s0Var;
            this.B.setAdapter(s0Var);
            ((s0) this.U7).E(this.X7 ? 2 : 1);
        }
    }

    public final void q0() {
        this.f2209k0.setVisibility((T() && (this.f2210k1.getVisibility() == 0 || this.C1.getVisibility() == 0)) ? 0 : 8);
    }

    public final void r0(boolean z10) {
        this.f2210k1.setVisibility((this.V7 && T() && hasFocus() && (z10 || !this.f2199a8)) ? 0 : 8);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int i10, Rect rect) {
        if (this.Y7 || !isFocusable()) {
            return false;
        }
        if (Q()) {
            return super.requestFocus(i10, rect);
        }
        boolean zRequestFocus = this.B.requestFocus(i10, rect);
        if (zRequestFocus) {
            s0(false);
        }
        return zRequestFocus;
    }

    public final void s0(boolean z10) {
        this.T7 = z10;
        int i10 = z10 ? 0 : 8;
        boolean z11 = !TextUtils.isEmpty(this.B.getText());
        this.K0.setVisibility(i10);
        r0(z11);
        this.C.setVisibility(z10 ? 8 : 0);
        this.G7.setVisibility((this.G7.getDrawable() == null || this.S7) ? 8 : 0);
        m0();
        t0(!z11);
        q0();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setAppSearchData(Bundle bundle) {
        this.f2205g8 = bundle;
    }

    public void setIconified(boolean z10) {
        if (z10) {
            Y();
        } else {
            c0();
        }
    }

    public void setIconifiedByDefault(boolean z10) {
        if (this.S7 == z10) {
            return;
        }
        this.S7 = z10;
        s0(z10);
        o0();
    }

    public void setImeOptions(int i10) {
        this.B.setImeOptions(i10);
    }

    public void setInputType(int i10) {
        this.B.setInputType(i10);
    }

    public void setMaxWidth(int i10) {
        this.Z7 = i10;
        requestLayout();
    }

    public void setOnCloseListener(l lVar) {
        this.O7 = lVar;
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.P7 = onFocusChangeListener;
    }

    public void setOnQueryTextListener(m mVar) {
        this.N7 = mVar;
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.R7 = onClickListener;
    }

    public void setOnSuggestionListener(n nVar) {
        this.Q7 = nVar;
    }

    public void setQueryHint(@g.p0 CharSequence charSequence) {
        this.W7 = charSequence;
        o0();
    }

    public void setQueryRefinementEnabled(boolean z10) {
        this.X7 = z10;
        d1.a aVar = this.U7;
        if (aVar instanceof s0) {
            ((s0) aVar).E(z10 ? 2 : 1);
        }
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.f2204f8 = searchableInfo;
        if (searchableInfo != null) {
            p0();
            o0();
        }
        boolean zO = O();
        this.f2199a8 = zO;
        if (zO) {
            this.B.setPrivateImeOptions(f2197s8);
        }
        s0(Q());
    }

    public void setSubmitButtonEnabled(boolean z10) {
        this.V7 = z10;
        s0(Q());
    }

    public void setSuggestionsAdapter(d1.a aVar) {
        this.U7 = aVar;
        this.B.setAdapter(aVar);
    }

    public final void t0(boolean z10) {
        int i10 = 8;
        if (this.f2199a8 && !Q() && z10) {
            this.f2210k1.setVisibility(8);
            i10 = 0;
        }
        this.C1.setVisibility(i10);
    }

    public SearchView(@g.n0 Context context, @g.p0 AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.searchViewStyle);
    }

    public SearchView(@g.n0 Context context, @g.p0 AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.C2 = new Rect();
        this.K2 = new Rect();
        this.E7 = new int[2];
        this.F7 = new int[2];
        this.f2206h8 = new b();
        this.f2207i8 = new c();
        this.f2208j8 = new WeakHashMap<>();
        f fVar = new f();
        this.f2211k8 = fVar;
        this.f2212l8 = new g();
        h hVar = new h();
        this.f2213m8 = hVar;
        i iVar = new i();
        this.f2214n8 = iVar;
        j jVar = new j();
        this.f2215o8 = jVar;
        this.f2216p8 = new a();
        int[] iArr = R.styleable.SearchView;
        y0 y0VarG = y0.G(context, attributeSet, iArr, i10, 0);
        androidx.core.view.u0.z1(this, context, iArr, attributeSet, y0VarG.B(), i10, 0);
        LayoutInflater.from(context).inflate(y0VarG.u(R.styleable.SearchView_layout, R.layout.abc_search_view), (ViewGroup) this, true);
        SearchAutoComplete searchAutoComplete = (SearchAutoComplete) findViewById(R.id.search_src_text);
        this.B = searchAutoComplete;
        searchAutoComplete.setSearchView(this);
        this.C = findViewById(R.id.search_edit_frame);
        View viewFindViewById = findViewById(R.id.search_plate);
        this.D = viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.submit_area);
        this.f2209k0 = viewFindViewById2;
        ImageView imageView = (ImageView) findViewById(R.id.search_button);
        this.K0 = imageView;
        ImageView imageView2 = (ImageView) findViewById(R.id.search_go_btn);
        this.f2210k1 = imageView2;
        ImageView imageView3 = (ImageView) findViewById(R.id.search_close_btn);
        this.f2217v1 = imageView3;
        ImageView imageView4 = (ImageView) findViewById(R.id.search_voice_btn);
        this.C1 = imageView4;
        ImageView imageView5 = (ImageView) findViewById(R.id.search_mag_icon);
        this.G7 = imageView5;
        androidx.core.view.u0.I1(viewFindViewById, y0VarG.h(R.styleable.SearchView_queryBackground));
        androidx.core.view.u0.I1(viewFindViewById2, y0VarG.h(R.styleable.SearchView_submitBackground));
        int i11 = R.styleable.SearchView_searchIcon;
        imageView.setImageDrawable(y0VarG.h(i11));
        imageView2.setImageDrawable(y0VarG.h(R.styleable.SearchView_goIcon));
        imageView3.setImageDrawable(y0VarG.h(R.styleable.SearchView_closeIcon));
        imageView4.setImageDrawable(y0VarG.h(R.styleable.SearchView_voiceIcon));
        imageView5.setImageDrawable(y0VarG.h(i11));
        this.H7 = y0VarG.h(R.styleable.SearchView_searchHintIcon);
        b1.a(imageView, getResources().getString(R.string.abc_searchview_description_search));
        this.I7 = y0VarG.u(R.styleable.SearchView_suggestionRowLayout, R.layout.abc_search_dropdown_item_icons_2line);
        this.J7 = y0VarG.u(R.styleable.SearchView_commitIcon, 0);
        imageView.setOnClickListener(fVar);
        imageView3.setOnClickListener(fVar);
        imageView2.setOnClickListener(fVar);
        imageView4.setOnClickListener(fVar);
        searchAutoComplete.setOnClickListener(fVar);
        searchAutoComplete.addTextChangedListener(this.f2216p8);
        searchAutoComplete.setOnEditorActionListener(hVar);
        searchAutoComplete.setOnItemClickListener(iVar);
        searchAutoComplete.setOnItemSelectedListener(jVar);
        searchAutoComplete.setOnKeyListener(this.f2212l8);
        searchAutoComplete.setOnFocusChangeListener(new d());
        setIconifiedByDefault(y0VarG.a(R.styleable.SearchView_iconifiedByDefault, true));
        int iG = y0VarG.g(R.styleable.SearchView_android_maxWidth, -1);
        if (iG != -1) {
            setMaxWidth(iG);
        }
        this.M7 = y0VarG.x(R.styleable.SearchView_defaultQueryHint);
        this.W7 = y0VarG.x(R.styleable.SearchView_queryHint);
        int iO = y0VarG.o(R.styleable.SearchView_android_imeOptions, -1);
        if (iO != -1) {
            setImeOptions(iO);
        }
        int iO2 = y0VarG.o(R.styleable.SearchView_android_inputType, -1);
        if (iO2 != -1) {
            setInputType(iO2);
        }
        setFocusable(y0VarG.a(R.styleable.SearchView_android_focusable, true));
        y0VarG.I();
        Intent intent = new Intent("android.speech.action.WEB_SEARCH");
        this.K7 = intent;
        intent.addFlags(268435456);
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        Intent intent2 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.L7 = intent2;
        intent2.addFlags(268435456);
        View viewFindViewById3 = findViewById(searchAutoComplete.getDropDownAnchor());
        this.K1 = viewFindViewById3;
        if (viewFindViewById3 != null) {
            viewFindViewById3.addOnLayoutChangeListener(new e());
        }
        s0(this.S7);
        o0();
    }
}
