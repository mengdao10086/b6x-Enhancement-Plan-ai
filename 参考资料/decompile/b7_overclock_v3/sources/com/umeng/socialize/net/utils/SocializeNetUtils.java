package com.umeng.socialize.net.utils;

import android.os.Bundle;
import android.text.TextUtils;
import com.just.agentweb.DefaultWebClient;
import com.umeng.socialize.Config;
import com.umeng.socialize.utils.ContextUtil;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.UmengText;
import hb.u;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;

/* JADX INFO: loaded from: classes5.dex */
public class SocializeNetUtils {
    private static final String TAG = "SocializeNetUtils";

    public static String convertStreamToString(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            try {
                try {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        sb2.append(line + "/n");
                    } catch (IOException e10) {
                        SLog.error(UmengText.NET.TOOL, e10);
                        inputStream.close();
                    }
                } catch (Throwable th2) {
                    try {
                        inputStream.close();
                    } catch (IOException e11) {
                        SLog.error(UmengText.NET.TOOL, e11);
                    }
                    throw th2;
                }
            } catch (IOException e12) {
                SLog.error(UmengText.NET.TOOL, e12);
            }
        }
        inputStream.close();
        return sb2.toString();
    }

    public static Bundle decodeUrl(String str) {
        Bundle bundle = new Bundle();
        if (str != null) {
            for (String str2 : str.split("&")) {
                String[] strArrSplit = str2.split(u.f30904o);
                try {
                    bundle.putString(URLDecoder.decode(strArrSplit[0], "UTF-8"), URLDecoder.decode(strArrSplit[1], "UTF-8"));
                } catch (UnsupportedEncodingException e10) {
                    SLog.error(UmengText.NET.TOOL, e10);
                }
            }
        }
        return bundle;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x00b4 -> B:94:0x00d5). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:76:0x00e4 -> B:97:0x0105). Please report as a decompilation issue!!! */
    public static byte[] getNetData(String str) throws Throwable {
        ?? byteArrayOutputStream;
        InputStream inputStream;
        HttpURLConnection httpURLConnection;
        byte[] bArr;
        InputStream inputStream2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                httpURLConnection.setInstanceFollowRedirects(true);
                httpURLConnection.setConnectTimeout(Config.connectionTimeOut);
                httpURLConnection.setReadTimeout(Config.readSocketTimeOut);
            } catch (Exception e10) {
                e = e10;
                inputStream = null;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e11) {
            e = e11;
            byteArrayOutputStream = 0;
            inputStream = null;
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = 0;
        }
        if (httpURLConnection.getResponseCode() == 301) {
            String headerField = httpURLConnection.getHeaderField("Location");
            if (!headerField.equals(str)) {
                return getNetData(headerField);
            }
            SLog.E(UmengText.NET.NET_AGAIN_ERROR);
            return null;
        }
        inputStream = httpURLConnection.getInputStream();
        try {
            try {
                SLog.I(UmengText.IMAGE.IMAGEURL + str);
                bArr = new byte[4096];
            } catch (Exception e12) {
                e = e12;
                SLog.error(UmengText.NET.IMAGEDOWN, e);
                try {
                    try {
                    } catch (IOException e13) {
                        String str2 = UmengText.NET.CLOSE;
                        SLog.error(str2, e13);
                        byteArrayOutputStream = str2;
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                            byteArrayOutputStream = byteArrayOutputStream;
                            if (byteArrayOutputStream != 0) {
                                byteArrayOutputStream.close();
                                byteArrayOutputStream = byteArrayOutputStream;
                            }
                        } catch (IOException e14) {
                            SLog.error(UmengText.NET.TOOL, e14);
                            if (byteArrayOutputStream != 0) {
                                byteArrayOutputStream.close();
                                byteArrayOutputStream = byteArrayOutputStream;
                            }
                            return null;
                        }
                    }
                    return null;
                } finally {
                }
            }
        } catch (Throwable th4) {
            th = th4;
            inputStream2 = inputStream;
        }
        while (true) {
            int i10 = inputStream.read(bArr);
            if (i10 == -1) {
                break;
            }
            byteArrayOutputStream.write(bArr, 0, i10);
            th = th4;
            inputStream2 = inputStream;
            try {
                try {
                } finally {
                }
            } catch (IOException e15) {
                SLog.error(UmengText.NET.CLOSE, e15);
                byteArrayOutputStream = e15;
            }
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                    byteArrayOutputStream = byteArrayOutputStream;
                    if (byteArrayOutputStream != 0) {
                        byteArrayOutputStream.close();
                        byteArrayOutputStream = byteArrayOutputStream;
                    }
                } catch (IOException e16) {
                    SLog.error(UmengText.NET.TOOL, e16);
                    byteArrayOutputStream = byteArrayOutputStream;
                    if (byteArrayOutputStream != 0) {
                        byteArrayOutputStream.close();
                        byteArrayOutputStream = byteArrayOutputStream;
                    }
                }
            }
            throw th;
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            try {
                try {
                    inputStream.close();
                    byteArrayOutputStream.close();
                } catch (IOException e17) {
                    SLog.error(UmengText.NET.CLOSE, e17);
                }
            } catch (IOException e18) {
                SLog.error(UmengText.NET.TOOL, e18);
                byteArrayOutputStream.close();
            }
            return byteArray;
        } finally {
            try {
                byteArrayOutputStream.close();
            } catch (IOException e19) {
                SLog.error(UmengText.NET.CLOSE, e19);
            }
        }
    }

    public static boolean isConSpeCharacters(String str) {
        return str.replaceAll("[一-龥]*[a-z]*[A-Z]*\\d*-*_*\\s*", "").length() != 0;
    }

    public static boolean isSelfAppkey(String str) {
        return str.equals("5126ff896c738f2bfa000438") && !ContextUtil.getPackageName().equals("com.umeng.soexample");
    }

    public static Bundle parseUri(String str) {
        try {
            return decodeUrl(new URI(str).getQuery());
        } catch (Exception e10) {
            SLog.error(UmengText.NET.TOOL, e10);
            return new Bundle();
        }
    }

    public static Bundle parseUrl(String str) {
        try {
            URL url = new URL(str);
            Bundle bundleDecodeUrl = decodeUrl(url.getQuery());
            bundleDecodeUrl.putAll(decodeUrl(url.getRef()));
            return bundleDecodeUrl;
        } catch (MalformedURLException e10) {
            SLog.error(UmengText.NET.TOOL, e10);
            return new Bundle();
        }
    }

    public static String request(String str) {
        try {
            URLConnection uRLConnectionOpenConnection = new URL(str).openConnection();
            if (uRLConnectionOpenConnection == null) {
                return "";
            }
            uRLConnectionOpenConnection.connect();
            InputStream inputStream = uRLConnectionOpenConnection.getInputStream();
            return inputStream == null ? "" : convertStreamToString(inputStream);
        } catch (Exception e10) {
            SLog.error(UmengText.NET.TOOL, e10);
            return "";
        }
    }

    public static boolean startWithHttp(String str) {
        return str.startsWith(DefaultWebClient.f21814v) || str.startsWith(DefaultWebClient.f21815w);
    }
}
