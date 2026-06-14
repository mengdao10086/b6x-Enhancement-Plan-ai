package androidx.core.graphics.drawable;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.versionedparcelable.CustomVersionedParcelable;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class IconCompat extends CustomVersionedParcelable {
    public static final PorterDuff.Mode b = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f4185a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f4189b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8192a = -1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public byte[] f4187a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Parcelable f4184a = null;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f4188b = 0;
    public int c = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ColorStateList f4182a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public PorterDuff.Mode f4183a = b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f4186a = null;

    public static Bitmap a(Bitmap bitmap, boolean z) {
        int iMin = (int) (Math.min(bitmap.getWidth(), bitmap.getHeight()) * 0.6666667f);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iMin, iMin, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint(3);
        float f = iMin;
        float f2 = 0.5f * f;
        float f3 = 0.9166667f * f2;
        if (z) {
            float f4 = 0.010416667f * f;
            paint.setColor(0);
            paint.setShadowLayer(f4, 0.0f, f * 0.020833334f, 1023410176);
            canvas.drawCircle(f2, f2, f3, paint);
            paint.setShadowLayer(f4, 0.0f, 0.0f, 503316480);
            canvas.drawCircle(f2, f2, f3, paint);
            paint.clearShadowLayer();
        }
        paint.setColor(-16777216);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        Matrix matrix = new Matrix();
        matrix.setTranslate((-(bitmap.getWidth() - iMin)) / 2, (-(bitmap.getHeight() - iMin)) / 2);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        canvas.drawCircle(f2, f2, f3, paint);
        canvas.setBitmap(null);
        return bitmapCreateBitmap;
    }

    public static int c(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getResId();
        }
        try {
            return ((Integer) icon.getClass().getMethod("getResId", new Class[0]).invoke(icon, new Object[0])).intValue();
        } catch (IllegalAccessException e) {
            Log.e("IconCompat", "Unable to get icon resource", e);
            return 0;
        } catch (NoSuchMethodException e2) {
            Log.e("IconCompat", "Unable to get icon resource", e2);
            return 0;
        } catch (InvocationTargetException e3) {
            Log.e("IconCompat", "Unable to get icon resource", e3);
            return 0;
        }
    }

    public static String e(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getResPackage();
        }
        try {
            return (String) icon.getClass().getMethod("getResPackage", new Class[0]).invoke(icon, new Object[0]);
        } catch (IllegalAccessException e) {
            Log.e("IconCompat", "Unable to get icon package", e);
            return null;
        } catch (NoSuchMethodException e2) {
            Log.e("IconCompat", "Unable to get icon package", e2);
            return null;
        } catch (InvocationTargetException e3) {
            Log.e("IconCompat", "Unable to get icon package", e3);
            return null;
        }
    }

    public static Uri g(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getUri();
        }
        try {
            return (Uri) icon.getClass().getMethod("getUri", new Class[0]).invoke(icon, new Object[0]);
        } catch (IllegalAccessException e) {
            Log.e("IconCompat", "Unable to get icon uri", e);
            return null;
        } catch (NoSuchMethodException e2) {
            Log.e("IconCompat", "Unable to get icon uri", e2);
            return null;
        } catch (InvocationTargetException e3) {
            Log.e("IconCompat", "Unable to get icon uri", e3);
            return null;
        }
    }

    public static String m(int i) {
        switch (i) {
            case 1:
                return "BITMAP";
            case 2:
                return "RESOURCE";
            case 3:
                return "DATA";
            case 4:
                return "URI";
            case 5:
                return "BITMAP_MASKABLE";
            case 6:
                return "URI_MASKABLE";
            default:
                return "UNKNOWN";
        }
    }

    public int b() {
        if (this.f8192a == -1 && Build.VERSION.SDK_INT >= 23) {
            return c((Icon) this.f4185a);
        }
        if (this.f8192a == 2) {
            return this.f4188b;
        }
        throw new IllegalStateException("called getResId() on " + this);
    }

    public String d() {
        if (this.f8192a == -1 && Build.VERSION.SDK_INT >= 23) {
            return e((Icon) this.f4185a);
        }
        if (this.f8192a == 2) {
            return TextUtils.isEmpty(this.f4189b) ? ((String) this.f4185a).split(":", -1)[0] : this.f4189b;
        }
        throw new IllegalStateException("called getResPackage() on " + this);
    }

    public Uri f() {
        if (this.f8192a == -1 && Build.VERSION.SDK_INT >= 23) {
            return g((Icon) this.f4185a);
        }
        int i = this.f8192a;
        if (i == 4 || i == 6) {
            return Uri.parse((String) this.f4185a);
        }
        throw new IllegalStateException("called getUri() on " + this);
    }

    public InputStream h(Context context) {
        StringBuilder sb;
        String str;
        Uri uriF = f();
        String scheme = uriF.getScheme();
        if ("content".equals(scheme) || "file".equals(scheme)) {
            try {
                return context.getContentResolver().openInputStream(uriF);
            } catch (Exception e) {
                e = e;
                sb = new StringBuilder();
                str = "Unable to load image from URI: ";
            }
        } else {
            try {
                return new FileInputStream(new File((String) this.f4185a));
            } catch (FileNotFoundException e2) {
                e = e2;
                sb = new StringBuilder();
                str = "Unable to load image from path: ";
            }
        }
        sb.append(str);
        sb.append(uriF);
        Log.w("IconCompat", sb.toString(), e);
        return null;
    }

    public void i() {
        Parcelable parcelable;
        this.f4183a = PorterDuff.Mode.valueOf(this.f4186a);
        switch (this.f8192a) {
            case -1:
                parcelable = this.f4184a;
                if (parcelable == null) {
                    throw new IllegalArgumentException("Invalid icon");
                }
                break;
            case 0:
            default:
                return;
            case 1:
            case 5:
                parcelable = this.f4184a;
                if (parcelable == null) {
                    byte[] bArr = this.f4187a;
                    this.f4185a = bArr;
                    this.f8192a = 3;
                    this.f4188b = 0;
                    this.c = bArr.length;
                    return;
                }
                break;
            case 2:
            case 4:
            case 6:
                String str = new String(this.f4187a, Charset.forName("UTF-16"));
                this.f4185a = str;
                if (this.f8192a == 2 && this.f4189b == null) {
                    this.f4189b = str.split(":", -1)[0];
                    return;
                }
                return;
            case 3:
                this.f4185a = this.f4187a;
                return;
        }
        this.f4185a = parcelable;
    }

    public void j(boolean z) {
        this.f4186a = this.f4183a.name();
        switch (this.f8192a) {
            case -1:
                if (z) {
                    throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
                }
                break;
            case 0:
            default:
                return;
            case 1:
            case 5:
                if (z) {
                    Bitmap bitmap = (Bitmap) this.f4185a;
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
                    this.f4187a = byteArrayOutputStream.toByteArray();
                    return;
                }
                break;
            case 2:
                this.f4187a = ((String) this.f4185a).getBytes(Charset.forName("UTF-16"));
                return;
            case 3:
                this.f4187a = (byte[]) this.f4185a;
                return;
            case 4:
            case 6:
                this.f4187a = this.f4185a.toString().getBytes(Charset.forName("UTF-16"));
                return;
        }
        this.f4184a = (Parcelable) this.f4185a;
    }

    @Deprecated
    public Icon k() {
        return l(null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002e, code lost:
    
        if (r0 >= 26) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.graphics.drawable.Icon l(android.content.Context r5) {
        /*
            Method dump skipped, instruction units count: 208
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.drawable.IconCompat.l(android.content.Context):android.graphics.drawable.Icon");
    }

    public String toString() {
        int height;
        if (this.f8192a == -1) {
            return String.valueOf(this.f4185a);
        }
        StringBuilder sb = new StringBuilder("Icon(typ=");
        sb.append(m(this.f8192a));
        switch (this.f8192a) {
            case 1:
            case 5:
                sb.append(" size=");
                sb.append(((Bitmap) this.f4185a).getWidth());
                sb.append("x");
                height = ((Bitmap) this.f4185a).getHeight();
                sb.append(height);
                break;
            case 2:
                sb.append(" pkg=");
                sb.append(this.f4189b);
                sb.append(" id=");
                sb.append(String.format("0x%08x", Integer.valueOf(b())));
                break;
            case 3:
                sb.append(" len=");
                sb.append(this.f4188b);
                if (this.c != 0) {
                    sb.append(" off=");
                    height = this.c;
                    sb.append(height);
                }
                break;
            case 4:
            case 6:
                sb.append(" uri=");
                sb.append(this.f4185a);
                break;
        }
        if (this.f4182a != null) {
            sb.append(" tint=");
            sb.append(this.f4182a);
        }
        if (this.f4183a != b) {
            sb.append(" mode=");
            sb.append(this.f4183a);
        }
        sb.append(")");
        return sb.toString();
    }
}
