package androidx.appcompat.widget;

import a.a0;
import a.ak;
import a.c0;
import a.eh;
import a.h8;
import a.j8;
import a.l3;
import a.m7;
import a.o5;
import a.o8;
import a.t;
import a.t8;
import a.uj;
import a.w;
import a.y;
import a.z;
import a.z8;
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
import android.util.Log;
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
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class SearchView extends m7 implements l3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f8159a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public uj f4061a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public SearchableInfo f4062a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Intent f4063a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Rect f4064a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Bundle f4065a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TextWatcher f4066a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public View.OnClickListener f4067a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public View.OnFocusChangeListener f4068a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public View.OnKeyListener f4069a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final View f4070a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final AdapterView.OnItemClickListener f4071a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final AdapterView.OnItemSelectedListener f4072a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ImageView f4073a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final TextView.OnEditorActionListener f4074a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final SearchAutoComplete f4075a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public k f4076a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public l f4077a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public m f4078a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public p f4079a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final CharSequence f4080a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Runnable f4081a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final WeakHashMap<String, Drawable.ConstantState> f4082a;
    public final Intent b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Rect f4083b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final Drawable f4084b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final View.OnClickListener f4085b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final View f4086b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final ImageView f4087b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public CharSequence f4088b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Runnable f4089b;
    public final View c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final ImageView f4090c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public CharSequence f4091c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public int[] f4092c;
    public final View d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public final ImageView f4093d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public CharSequence f4094d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f4095d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public int[] f4096d;
    public final ImageView e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public boolean f4097e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public final int j;

    /* JADX INFO: renamed from: j, reason: collision with other field name */
    public boolean f4098j;
    public final int k;
    public int l;
    public int m;

    public static class SearchAutoComplete extends o5 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8160a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public SearchView f4099a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Runnable f4100a;
        public boolean b;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SearchAutoComplete.this.c();
            }
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, t.autoCompleteTextViewStyle);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.f4100a = new a();
            this.f8160a = getThreshold();
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i = configuration.screenWidthDp;
            int i2 = configuration.screenHeightDp;
            if (i >= 960 && i2 >= 720 && configuration.orientation == 2) {
                return 256;
            }
            if (i < 600) {
                return (i < 640 || i2 < 480) ? 160 : 192;
            }
            return 192;
        }

        public void a() {
            if (Build.VERSION.SDK_INT < 29) {
                SearchView.f8159a.c(this);
                return;
            }
            setInputMethodMode(1);
            if (enoughToFilter()) {
                showDropDown();
            }
        }

        public boolean b() {
            return TextUtils.getTrimmedLength(getText()) == 0;
        }

        public void c() {
            if (this.b) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                this.b = false;
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public boolean enoughToFilter() {
            return this.f8160a <= 0 || super.enoughToFilter();
        }

        @Override // a.o5, android.widget.TextView, android.view.View
        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.b) {
                removeCallbacks(this.f4100a);
                post(this.f4100a);
            }
            return inputConnectionOnCreateInputConnection;
        }

        @Override // android.view.View
        public void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onFocusChanged(boolean z, int i, Rect rect) {
            super.onFocusChanged(z, i, rect);
            this.f4099a.Z();
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
            if (i == 4) {
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
                        this.f4099a.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i, keyEvent);
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            if (z && this.f4099a.hasFocus() && getVisibility() == 0) {
                this.b = true;
                if (SearchView.M(getContext())) {
                    a();
                }
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public void performCompletion() {
        }

        @Override // android.widget.AutoCompleteTextView
        public void replaceText(CharSequence charSequence) {
        }

        public void setImeVisibility(boolean z) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (!z) {
                this.b = false;
                removeCallbacks(this.f4100a);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else {
                if (!inputMethodManager.isActive(this)) {
                    this.b = true;
                    return;
                }
                this.b = false;
                removeCallbacks(this.f4100a);
                inputMethodManager.showSoftInput(this, 0);
            }
        }

        public void setSearchView(SearchView searchView) {
            this.f4099a = searchView;
        }

        @Override // android.widget.AutoCompleteTextView
        public void setThreshold(int i) {
            super.setThreshold(i);
            this.f8160a = i;
        }
    }

    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            SearchView.this.Y(charSequence);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SearchView.this.f0();
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            uj ujVar = SearchView.this.f4061a;
            if (ujVar instanceof j8) {
                ujVar.d(null);
            }
        }
    }

    public class d implements View.OnFocusChangeListener {
        public d() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            SearchView searchView = SearchView.this;
            View.OnFocusChangeListener onFocusChangeListener = searchView.f4068a;
            if (onFocusChangeListener != null) {
                onFocusChangeListener.onFocusChange(searchView, z);
            }
        }
    }

    public class e implements View.OnLayoutChangeListener {
        public e() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            SearchView.this.B();
        }
    }

    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SearchView searchView = SearchView.this;
            if (view == searchView.f4073a) {
                searchView.V();
                return;
            }
            if (view == searchView.f4090c) {
                searchView.R();
                return;
            }
            if (view == searchView.f4087b) {
                searchView.W();
            } else if (view == searchView.f4093d) {
                searchView.a0();
            } else if (view == searchView.f4075a) {
                searchView.H();
            }
        }
    }

    public class g implements View.OnKeyListener {
        public g() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            SearchView searchView = SearchView.this;
            if (searchView.f4062a == null) {
                return false;
            }
            if (searchView.f4075a.isPopupShowing() && SearchView.this.f4075a.getListSelection() != -1) {
                return SearchView.this.X(view, i, keyEvent);
            }
            if (SearchView.this.f4075a.b() || !keyEvent.hasNoModifiers() || keyEvent.getAction() != 1 || i != 66) {
                return false;
            }
            view.cancelLongPress();
            SearchView searchView2 = SearchView.this;
            searchView2.P(0, null, searchView2.f4075a.getText().toString());
            return true;
        }
    }

    public class h implements TextView.OnEditorActionListener {
        public h() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            SearchView.this.W();
            return true;
        }
    }

    public class i implements AdapterView.OnItemClickListener {
        public i() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            SearchView.this.S(i, 0, null);
        }
    }

    public class j implements AdapterView.OnItemSelectedListener {
        public j() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            SearchView.this.T(i);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    public interface k {
        boolean a();
    }

    public interface l {
        boolean a(String str);

        boolean b(String str);
    }

    public interface m {
        boolean a(int i);

        boolean b(int i);
    }

    public static class n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Method f8172a;
        public Method b;
        public Method c;

        @SuppressLint({"DiscouragedPrivateApi", "SoonBlockedPrivateApi"})
        public n() {
            this.f8172a = null;
            this.b = null;
            this.c = null;
            d();
            try {
                Method declaredMethod = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                this.f8172a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            try {
                Method declaredMethod2 = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                this.b = declaredMethod2;
                declaredMethod2.setAccessible(true);
            } catch (NoSuchMethodException unused2) {
            }
            try {
                Method method = AutoCompleteTextView.class.getMethod("ensureImeVisible", Boolean.TYPE);
                this.c = method;
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
            Method method = this.b;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        public void b(AutoCompleteTextView autoCompleteTextView) {
            d();
            Method method = this.f8172a;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        public void c(AutoCompleteTextView autoCompleteTextView) {
            d();
            Method method = this.c;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, Boolean.TRUE);
                } catch (Exception unused) {
                }
            }
        }
    }

    public static class o extends ak {
        public static final Parcelable.Creator<o> CREATOR = new h8();
        public boolean b;

        public o(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.b = ((Boolean) parcel.readValue(null)).booleanValue();
        }

        public o(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.b + "}";
        }

        @Override // a.ak, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeValue(Boolean.valueOf(this.b));
        }
    }

    public static class p extends TouchDelegate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f8173a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Rect f4101a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final View f4102a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f4103a;
        public final Rect b;
        public final Rect c;

        public p(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.f8173a = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            this.f4101a = new Rect();
            this.c = new Rect();
            this.b = new Rect();
            a(rect, rect2);
            this.f4102a = view;
        }

        public void a(Rect rect, Rect rect2) {
            this.f4101a.set(rect);
            this.c.set(rect);
            Rect rect3 = this.c;
            int i = this.f8173a;
            rect3.inset(-i, -i);
            this.b.set(rect2);
        }

        @Override // android.view.TouchDelegate
        public boolean onTouchEvent(MotionEvent motionEvent) {
            boolean z;
            float width;
            int height;
            boolean z2;
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int action = motionEvent.getAction();
            boolean z3 = true;
            if (action != 0) {
                if (action == 1 || action == 2) {
                    z2 = this.f4103a;
                    if (z2 && !this.c.contains(x, y)) {
                        z3 = z2;
                        z = false;
                    }
                } else {
                    if (action == 3) {
                        z2 = this.f4103a;
                        this.f4103a = false;
                    }
                    z = true;
                    z3 = false;
                }
                z3 = z2;
                z = true;
            } else if (this.f4101a.contains(x, y)) {
                this.f4103a = true;
                z = true;
            } else {
                z = true;
                z3 = false;
            }
            if (!z3) {
                return false;
            }
            if (!z || this.b.contains(x, y)) {
                Rect rect = this.b;
                width = x - rect.left;
                height = y - rect.top;
            } else {
                width = this.f4102a.getWidth() / 2;
                height = this.f4102a.getHeight() / 2;
            }
            motionEvent.setLocation(width, height);
            return this.f4102a.dispatchTouchEvent(motionEvent);
        }
    }

    static {
        f8159a = Build.VERSION.SDK_INT < 29 ? new n() : null;
    }

    public SearchView(Context context) {
        this(context, null);
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, t.searchViewStyle);
    }

    public SearchView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f4064a = new Rect();
        this.f4083b = new Rect();
        this.f4092c = new int[2];
        this.f4096d = new int[2];
        this.f4081a = new b();
        this.f4089b = new c();
        this.f4082a = new WeakHashMap<>();
        this.f4085b = new f();
        this.f4069a = new g();
        this.f4074a = new h();
        this.f4071a = new i();
        this.f4072a = new j();
        this.f4066a = new a();
        o8 o8VarV = o8.v(context, attributeSet, c0.SearchView, i2, 0);
        LayoutInflater.from(context).inflate(o8VarV.n(c0.SearchView_layout, z.abc_search_view), (ViewGroup) this, true);
        SearchAutoComplete searchAutoComplete = (SearchAutoComplete) findViewById(y.search_src_text);
        this.f4075a = searchAutoComplete;
        searchAutoComplete.setSearchView(this);
        this.f4070a = findViewById(y.search_edit_frame);
        this.f4086b = findViewById(y.search_plate);
        this.c = findViewById(y.submit_area);
        this.f4073a = (ImageView) findViewById(y.search_button);
        this.f4087b = (ImageView) findViewById(y.search_go_btn);
        this.f4090c = (ImageView) findViewById(y.search_close_btn);
        this.f4093d = (ImageView) findViewById(y.search_voice_btn);
        this.e = (ImageView) findViewById(y.search_mag_icon);
        eh.m0(this.f4086b, o8VarV.g(c0.SearchView_queryBackground));
        eh.m0(this.c, o8VarV.g(c0.SearchView_submitBackground));
        this.f4073a.setImageDrawable(o8VarV.g(c0.SearchView_searchIcon));
        this.f4087b.setImageDrawable(o8VarV.g(c0.SearchView_goIcon));
        this.f4090c.setImageDrawable(o8VarV.g(c0.SearchView_closeIcon));
        this.f4093d.setImageDrawable(o8VarV.g(c0.SearchView_voiceIcon));
        this.e.setImageDrawable(o8VarV.g(c0.SearchView_searchIcon));
        this.f4084b = o8VarV.g(c0.SearchView_searchHintIcon);
        t8.a(this.f4073a, getResources().getString(a0.abc_searchview_description_search));
        this.j = o8VarV.n(c0.SearchView_suggestionRowLayout, z.abc_search_dropdown_item_icons_2line);
        this.k = o8VarV.n(c0.SearchView_commitIcon, 0);
        this.f4073a.setOnClickListener(this.f4085b);
        this.f4090c.setOnClickListener(this.f4085b);
        this.f4087b.setOnClickListener(this.f4085b);
        this.f4093d.setOnClickListener(this.f4085b);
        this.f4075a.setOnClickListener(this.f4085b);
        this.f4075a.addTextChangedListener(this.f4066a);
        this.f4075a.setOnEditorActionListener(this.f4074a);
        this.f4075a.setOnItemClickListener(this.f4071a);
        this.f4075a.setOnItemSelectedListener(this.f4072a);
        this.f4075a.setOnKeyListener(this.f4069a);
        this.f4075a.setOnFocusChangeListener(new d());
        setIconifiedByDefault(o8VarV.a(c0.SearchView_iconifiedByDefault, true));
        int iF = o8VarV.f(c0.SearchView_android_maxWidth, -1);
        if (iF != -1) {
            setMaxWidth(iF);
        }
        this.f4080a = o8VarV.p(c0.SearchView_defaultQueryHint);
        this.f4088b = o8VarV.p(c0.SearchView_queryHint);
        int iK = o8VarV.k(c0.SearchView_android_imeOptions, -1);
        if (iK != -1) {
            setImeOptions(iK);
        }
        int iK2 = o8VarV.k(c0.SearchView_android_inputType, -1);
        if (iK2 != -1) {
            setInputType(iK2);
        }
        setFocusable(o8VarV.a(c0.SearchView_android_focusable, true));
        o8VarV.w();
        Intent intent = new Intent("android.speech.action.WEB_SEARCH");
        this.f4063a = intent;
        intent.addFlags(268435456);
        this.f4063a.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        Intent intent2 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.b = intent2;
        intent2.addFlags(268435456);
        View viewFindViewById = findViewById(this.f4075a.getDropDownAnchor());
        this.d = viewFindViewById;
        if (viewFindViewById != null) {
            viewFindViewById.addOnLayoutChangeListener(new e());
        }
        k0(this.f4095d);
        g0();
    }

    public static boolean M(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(w.abc_search_view_preferred_height);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(w.abc_search_view_preferred_width);
    }

    private void setQuery(CharSequence charSequence) {
        this.f4075a.setText(charSequence);
        this.f4075a.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    public void B() {
        if (this.d.getWidth() > 1) {
            Resources resources = getContext().getResources();
            int paddingLeft = this.f4086b.getPaddingLeft();
            Rect rect = new Rect();
            boolean zB = z8.b(this);
            int dimensionPixelSize = this.f4095d ? resources.getDimensionPixelSize(w.abc_dropdownitem_icon_width) + resources.getDimensionPixelSize(w.abc_dropdownitem_text_padding_left) : 0;
            this.f4075a.getDropDownBackground().getPadding(rect);
            int i2 = rect.left;
            this.f4075a.setDropDownHorizontalOffset(zB ? -i2 : paddingLeft - (i2 + dimensionPixelSize));
            this.f4075a.setDropDownWidth((((this.d.getWidth() + rect.left) + rect.right) + dimensionPixelSize) - paddingLeft);
        }
    }

    public final Intent C(String str, Uri uri, String str2, String str3, int i2, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.f4094d);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        Bundle bundle = this.f4065a;
        if (bundle != null) {
            intent.putExtra("app_data", bundle);
        }
        if (i2 != 0) {
            intent.putExtra("action_key", i2);
            intent.putExtra("action_msg", str4);
        }
        intent.setComponent(this.f4062a.getSearchActivity());
        return intent;
    }

    public final Intent D(Cursor cursor, int i2, String str) {
        int position;
        String strO;
        try {
            String strO2 = j8.o(cursor, "suggest_intent_action");
            if (strO2 == null) {
                strO2 = this.f4062a.getSuggestIntentAction();
            }
            if (strO2 == null) {
                strO2 = "android.intent.action.SEARCH";
            }
            String str2 = strO2;
            String strO3 = j8.o(cursor, "suggest_intent_data");
            if (strO3 == null) {
                strO3 = this.f4062a.getSuggestIntentData();
            }
            if (strO3 != null && (strO = j8.o(cursor, "suggest_intent_data_id")) != null) {
                strO3 = strO3 + "/" + Uri.encode(strO);
            }
            return C(str2, strO3 == null ? null : Uri.parse(strO3), j8.o(cursor, "suggest_intent_extra_data"), j8.o(cursor, "suggest_intent_query"), i2, str);
        } catch (RuntimeException e2) {
            try {
                position = cursor.getPosition();
            } catch (RuntimeException unused) {
                position = -1;
            }
            Log.w("SearchView", "Search suggestions cursor at row " + position + " returned exception.", e2);
            return null;
        }
    }

    public final Intent E(Intent intent, SearchableInfo searchableInfo) {
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, 1073741824);
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f4065a;
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

    public final Intent F(Intent intent, SearchableInfo searchableInfo) {
        Intent intent2 = new Intent(intent);
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        intent2.putExtra("calling_package", searchActivity == null ? null : searchActivity.flattenToShortString());
        return intent2;
    }

    public final void G() {
        this.f4075a.dismissDropDown();
    }

    public void H() {
        if (Build.VERSION.SDK_INT >= 29) {
            this.f4075a.refreshAutoCompleteResults();
        } else {
            f8159a.b(this.f4075a);
            f8159a.a(this.f4075a);
        }
    }

    public final void I(View view, Rect rect) {
        view.getLocationInWindow(this.f4092c);
        getLocationInWindow(this.f4096d);
        int[] iArr = this.f4092c;
        int i2 = iArr[1];
        int[] iArr2 = this.f4096d;
        int i3 = i2 - iArr2[1];
        int i4 = iArr[0] - iArr2[0];
        rect.set(i4, i3, view.getWidth() + i4, view.getHeight() + i3);
    }

    public final CharSequence J(CharSequence charSequence) {
        if (!this.f4095d || this.f4084b == null) {
            return charSequence;
        }
        int textSize = (int) (((double) this.f4075a.getTextSize()) * 1.25d);
        this.f4084b.setBounds(0, 0, textSize, textSize);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
        spannableStringBuilder.setSpan(new ImageSpan(this.f4084b), 1, 2, 33);
        spannableStringBuilder.append(charSequence);
        return spannableStringBuilder;
    }

    public final boolean K() {
        SearchableInfo searchableInfo = this.f4062a;
        if (searchableInfo == null || !searchableInfo.getVoiceSearchEnabled()) {
            return false;
        }
        Intent intent = null;
        if (this.f4062a.getVoiceSearchLaunchWebSearch()) {
            intent = this.f4063a;
        } else if (this.f4062a.getVoiceSearchLaunchRecognizer()) {
            intent = this.b;
        }
        return (intent == null || getContext().getPackageManager().resolveActivity(intent, 65536) == null) ? false : true;
    }

    public boolean L() {
        return this.f4097e;
    }

    public final boolean N() {
        return (this.f || this.i) && !L();
    }

    public final void O(Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            getContext().startActivity(intent);
        } catch (RuntimeException e2) {
            Log.e("SearchView", "Failed launch activity: " + intent, e2);
        }
    }

    public void P(int i2, String str, String str2) {
        getContext().startActivity(C("android.intent.action.SEARCH", null, null, str2, i2, str));
    }

    public final boolean Q(int i2, int i3, String str) {
        Cursor cursorB = this.f4061a.b();
        if (cursorB == null || !cursorB.moveToPosition(i2)) {
            return false;
        }
        O(D(cursorB, i3, str));
        return true;
    }

    public void R() {
        if (!TextUtils.isEmpty(this.f4075a.getText())) {
            this.f4075a.setText("");
            this.f4075a.requestFocus();
            this.f4075a.setImeVisibility(true);
        } else if (this.f4095d) {
            k kVar = this.f4076a;
            if (kVar == null || !kVar.a()) {
                clearFocus();
                k0(true);
            }
        }
    }

    public boolean S(int i2, int i3, String str) {
        m mVar = this.f4078a;
        if (mVar != null && mVar.a(i2)) {
            return false;
        }
        Q(i2, 0, null);
        this.f4075a.setImeVisibility(false);
        G();
        return true;
    }

    public boolean T(int i2) {
        m mVar = this.f4078a;
        if (mVar != null && mVar.b(i2)) {
            return false;
        }
        c0(i2);
        return true;
    }

    public void U(CharSequence charSequence) {
        setQuery(charSequence);
    }

    public void V() {
        k0(false);
        this.f4075a.requestFocus();
        this.f4075a.setImeVisibility(true);
        View.OnClickListener onClickListener = this.f4067a;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    public void W() {
        Editable text = this.f4075a.getText();
        if (text == null || TextUtils.getTrimmedLength(text) <= 0) {
            return;
        }
        l lVar = this.f4077a;
        if (lVar == null || !lVar.a(text.toString())) {
            if (this.f4062a != null) {
                P(0, null, text.toString());
            }
            this.f4075a.setImeVisibility(false);
            G();
        }
    }

    public boolean X(View view, int i2, KeyEvent keyEvent) {
        if (this.f4062a != null && this.f4061a != null && keyEvent.getAction() == 0 && keyEvent.hasNoModifiers()) {
            if (i2 == 66 || i2 == 84 || i2 == 61) {
                return S(this.f4075a.getListSelection(), 0, null);
            }
            if (i2 == 21 || i2 == 22) {
                this.f4075a.setSelection(i2 == 21 ? 0 : this.f4075a.length());
                this.f4075a.setListSelection(0);
                this.f4075a.clearListSelection();
                this.f4075a.a();
                return true;
            }
            if (i2 != 19 || this.f4075a.getListSelection() == 0) {
                return false;
            }
        }
        return false;
    }

    public void Y(CharSequence charSequence) {
        Editable text = this.f4075a.getText();
        this.f4094d = text;
        boolean z = !TextUtils.isEmpty(text);
        j0(z);
        l0(!z);
        e0();
        i0();
        if (this.f4077a != null && !TextUtils.equals(charSequence, this.f4091c)) {
            this.f4077a.b(charSequence.toString());
        }
        this.f4091c = charSequence.toString();
    }

    public void Z() {
        k0(L());
        b0();
        if (this.f4075a.hasFocus()) {
            H();
        }
    }

    public void a0() {
        Intent intentE;
        SearchableInfo searchableInfo = this.f4062a;
        if (searchableInfo == null) {
            return;
        }
        try {
            if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                intentE = F(this.f4063a, searchableInfo);
            } else if (!searchableInfo.getVoiceSearchLaunchRecognizer()) {
                return;
            } else {
                intentE = E(this.b, searchableInfo);
            }
            getContext().startActivity(intentE);
        } catch (ActivityNotFoundException unused) {
            Log.w("SearchView", "Could not find voice search activity");
        }
    }

    @Override // a.l3
    public void b() {
        d0("", false);
        clearFocus();
        k0(true);
        this.f4075a.setImeOptions(this.m);
        this.f4098j = false;
    }

    public final void b0() {
        post(this.f4081a);
    }

    public final void c0(int i2) {
        CharSequence charSequenceA;
        Editable text = this.f4075a.getText();
        Cursor cursorB = this.f4061a.b();
        if (cursorB == null) {
            return;
        }
        if (!cursorB.moveToPosition(i2) || (charSequenceA = this.f4061a.a(cursorB)) == null) {
            setQuery(text);
        } else {
            setQuery(charSequenceA);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void clearFocus() {
        this.h = true;
        super.clearFocus();
        this.f4075a.clearFocus();
        this.f4075a.setImeVisibility(false);
        this.h = false;
    }

    public void d0(CharSequence charSequence, boolean z) {
        this.f4075a.setText(charSequence);
        if (charSequence != null) {
            SearchAutoComplete searchAutoComplete = this.f4075a;
            searchAutoComplete.setSelection(searchAutoComplete.length());
            this.f4094d = charSequence;
        }
        if (!z || TextUtils.isEmpty(charSequence)) {
            return;
        }
        W();
    }

    public final void e0() {
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.f4075a.getText());
        if (!z2 && (!this.f4095d || this.f4098j)) {
            z = false;
        }
        this.f4090c.setVisibility(z ? 0 : 8);
        Drawable drawable = this.f4090c.getDrawable();
        if (drawable != null) {
            drawable.setState(z2 ? ViewGroup.ENABLED_STATE_SET : ViewGroup.EMPTY_STATE_SET);
        }
    }

    @Override // a.l3
    public void f() {
        if (this.f4098j) {
            return;
        }
        this.f4098j = true;
        int imeOptions = this.f4075a.getImeOptions();
        this.m = imeOptions;
        this.f4075a.setImeOptions(imeOptions | 33554432);
        this.f4075a.setText("");
        setIconified(false);
    }

    public void f0() {
        int[] iArr = this.f4075a.hasFocus() ? ViewGroup.FOCUSED_STATE_SET : ViewGroup.EMPTY_STATE_SET;
        Drawable background = this.f4086b.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.c.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    public final void g0() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.f4075a;
        if (queryHint == null) {
            queryHint = "";
        }
        searchAutoComplete.setHint(J(queryHint));
    }

    public int getImeOptions() {
        return this.f4075a.getImeOptions();
    }

    public int getInputType() {
        return this.f4075a.getInputType();
    }

    public int getMaxWidth() {
        return this.l;
    }

    public CharSequence getQuery() {
        return this.f4075a.getText();
    }

    public CharSequence getQueryHint() {
        CharSequence charSequence = this.f4088b;
        if (charSequence != null) {
            return charSequence;
        }
        SearchableInfo searchableInfo = this.f4062a;
        return (searchableInfo == null || searchableInfo.getHintId() == 0) ? this.f4080a : getContext().getText(this.f4062a.getHintId());
    }

    public int getSuggestionCommitIconResId() {
        return this.k;
    }

    public int getSuggestionRowLayout() {
        return this.j;
    }

    public uj getSuggestionsAdapter() {
        return this.f4061a;
    }

    public final void h0() {
        this.f4075a.setThreshold(this.f4062a.getSuggestThreshold());
        this.f4075a.setImeOptions(this.f4062a.getImeOptions());
        int inputType = this.f4062a.getInputType();
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.f4062a.getSuggestAuthority() != null) {
                inputType = inputType | 65536 | 524288;
            }
        }
        this.f4075a.setInputType(inputType);
        uj ujVar = this.f4061a;
        if (ujVar != null) {
            ujVar.d(null);
        }
        if (this.f4062a.getSuggestAuthority() != null) {
            j8 j8Var = new j8(getContext(), this, this.f4062a, this.f4082a);
            this.f4061a = j8Var;
            this.f4075a.setAdapter(j8Var);
            ((j8) this.f4061a).x(this.g ? 2 : 1);
        }
    }

    public final void i0() {
        this.c.setVisibility((N() && (this.f4087b.getVisibility() == 0 || this.f4093d.getVisibility() == 0)) ? 0 : 8);
    }

    public final void j0(boolean z) {
        this.f4087b.setVisibility((this.f && N() && hasFocus() && (z || !this.i)) ? 0 : 8);
    }

    public final void k0(boolean z) {
        this.f4097e = z;
        int i2 = z ? 0 : 8;
        boolean z2 = !TextUtils.isEmpty(this.f4075a.getText());
        this.f4073a.setVisibility(i2);
        j0(z2);
        this.f4070a.setVisibility(z ? 8 : 0);
        this.e.setVisibility((this.e.getDrawable() == null || this.f4095d) ? 8 : 0);
        e0();
        l0(!z2);
        i0();
    }

    public final void l0(boolean z) {
        int i2 = 8;
        if (this.i && !L() && z) {
            this.f4087b.setVisibility(8);
            i2 = 0;
        }
        this.f4093d.setVisibility(i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.f4081a);
        post(this.f4089b);
        super.onDetachedFromWindow();
    }

    @Override // a.m7, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (z) {
            I(this.f4075a, this.f4064a);
            Rect rect = this.f4083b;
            Rect rect2 = this.f4064a;
            rect.set(rect2.left, 0, rect2.right, i5 - i3);
            p pVar = this.f4079a;
            if (pVar != null) {
                pVar.a(this.f4083b, this.f4064a);
                return;
            }
            p pVar2 = new p(this.f4083b, this.f4064a, this.f4075a);
            this.f4079a = pVar2;
            setTouchDelegate(pVar2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004b  */
    @Override // a.m7, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r4, int r5) {
        /*
            r3 = this;
            boolean r0 = r3.L()
            if (r0 == 0) goto La
            super.onMeasure(r4, r5)
            return
        La:
            int r0 = android.view.View.MeasureSpec.getMode(r4)
            int r4 = android.view.View.MeasureSpec.getSize(r4)
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = 1073741824(0x40000000, float:2.0)
            if (r0 == r1) goto L2c
            if (r0 == 0) goto L22
            if (r0 == r2) goto L1d
            goto L39
        L1d:
            int r0 = r3.l
            if (r0 <= 0) goto L39
            goto L30
        L22:
            int r4 = r3.l
            if (r4 <= 0) goto L27
            goto L39
        L27:
            int r4 = r3.getPreferredWidth()
            goto L39
        L2c:
            int r0 = r3.l
            if (r0 <= 0) goto L31
        L30:
            goto L35
        L31:
            int r0 = r3.getPreferredWidth()
        L35:
            int r4 = java.lang.Math.min(r0, r4)
        L39:
            int r0 = android.view.View.MeasureSpec.getMode(r5)
            int r5 = android.view.View.MeasureSpec.getSize(r5)
            if (r0 == r1) goto L4b
            if (r0 == 0) goto L46
            goto L53
        L46:
            int r5 = r3.getPreferredHeight()
            goto L53
        L4b:
            int r0 = r3.getPreferredHeight()
            int r5 = java.lang.Math.min(r0, r5)
        L53:
            int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r4, r2)
            int r5 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r2)
            super.onMeasure(r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SearchView.onMeasure(int, int):void");
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof o)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        o oVar = (o) parcelable;
        super.onRestoreInstanceState(oVar.q());
        k0(oVar.b);
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        o oVar = new o(super.onSaveInstanceState());
        oVar.b = L();
        return oVar;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        b0();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int i2, Rect rect) {
        if (this.h || !isFocusable()) {
            return false;
        }
        if (L()) {
            return super.requestFocus(i2, rect);
        }
        boolean zRequestFocus = this.f4075a.requestFocus(i2, rect);
        if (zRequestFocus) {
            k0(false);
        }
        return zRequestFocus;
    }

    public void setAppSearchData(Bundle bundle) {
        this.f4065a = bundle;
    }

    public void setIconified(boolean z) {
        if (z) {
            R();
        } else {
            V();
        }
    }

    public void setIconifiedByDefault(boolean z) {
        if (this.f4095d == z) {
            return;
        }
        this.f4095d = z;
        k0(z);
        g0();
    }

    public void setImeOptions(int i2) {
        this.f4075a.setImeOptions(i2);
    }

    public void setInputType(int i2) {
        this.f4075a.setInputType(i2);
    }

    public void setMaxWidth(int i2) {
        this.l = i2;
        requestLayout();
    }

    public void setOnCloseListener(k kVar) {
        this.f4076a = kVar;
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.f4068a = onFocusChangeListener;
    }

    public void setOnQueryTextListener(l lVar) {
        this.f4077a = lVar;
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.f4067a = onClickListener;
    }

    public void setOnSuggestionListener(m mVar) {
        this.f4078a = mVar;
    }

    public void setQueryHint(CharSequence charSequence) {
        this.f4088b = charSequence;
        g0();
    }

    public void setQueryRefinementEnabled(boolean z) {
        this.g = z;
        uj ujVar = this.f4061a;
        if (ujVar instanceof j8) {
            ((j8) ujVar).x(z ? 2 : 1);
        }
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.f4062a = searchableInfo;
        if (searchableInfo != null) {
            h0();
            g0();
        }
        boolean zK = K();
        this.i = zK;
        if (zK) {
            this.f4075a.setPrivateImeOptions("nm");
        }
        k0(L());
    }

    public void setSubmitButtonEnabled(boolean z) {
        this.f = z;
        k0(L());
    }

    public void setSuggestionsAdapter(uj ujVar) {
        this.f4061a = ujVar;
        this.f4075a.setAdapter(ujVar);
    }
}
