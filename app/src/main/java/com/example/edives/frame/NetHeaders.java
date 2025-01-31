package com.example.edives.frame;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.util.Base64;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by  on 2019/9/24.
 */
public class NetHeaders {
    private static String url = "password";
//    private static String userAgent;
//    static {
//        if (TextUtils.isEmpty(userAgent))
//            userAgent = getUserAgent();
//    }

    public static Map getMusicMap() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Time-Stamp", String.valueOf(System.currentTimeMillis() / 1000));
//        headers.put("Device-Key", DeviceUtils.getDeviceId(Application10.sApplication));
        headers.put("Version", "6.2.12");
//        headers.put("Authorization", "Basic ZG1kOjEyMzQ1Ng==");
        headers.put("channel", "qihu");
//        headers.put("deviceId", "007");
        return headers;
    }

    public static Map getHeadMap() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Bearer " + BaseApplication.getInstance().Token);
        headers.put("deviceId","007");

//
        return headers;
    }

    public static Map<String, String> signHeader() {
        String path = "/v2/sms/send";
//        String security = SIGN_API_KEY;
        String time = String.valueOf(System.currentTimeMillis() / 1000);
//        String sign = buildSign(path, sUuid, security, SIGN_API_KEY, time);
        Map<String, String> header = new HashMap<>();
//        header.put("api-key", SIGN_API_KEY);
        header.put("time", time);
//        header.put("sign", sign);
        return header;
    }

    /**
     * 拼接签名字符串
     */
    private static String buildSign(String url, String uuid, String security, String apiKey,
                                    String time) {
        String hash = "";
        try {
            String sign = uuid + url + apiKey + time + security;
            Mac mac = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(apiKey.getBytes(), "HmacSHA256");
            mac.init(secret_key);
            hash = Base64.encodeToString(mac.doFinal(sign.getBytes()), Base64.DEFAULT);
            if (TextUtils.isEmpty(hash))
                return hash;
            StringBuffer sb;
            sb = new StringBuffer();
            for (int i = 0; i < hash.length(); i++) {
                int asc = hash.charAt(i);
                if (asc != 10 && asc != 13) {
                    sb.append(hash.subSequence(i, i + 1));
                }
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hash;
    }

    public static String getUserAgent() {
        String s = "Bearer " + BaseApplication.getInstance().Token;
        return s;
    }

    public static String getVersionName() {
        try {
            PackageManager manager = BaseApplication.getInstance().getPackageManager();
            PackageInfo info = manager
                    .getPackageInfo(BaseApplication.getInstance().getPackageName(), 0);
            return info.versionName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "unknown";
    }

    public static int getVersionCode() {
        try {
            PackageManager manager = BaseApplication.getInstance().getPackageManager();
            PackageInfo info = manager
                    .getPackageInfo(BaseApplication.getInstance().getPackageName(), 0);
            return info.versionCode;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }

    @SuppressLint("MissingPermission")
    public static String getLocalUUIDX(Context context) {
       /* String uuid = !TextUtils.isEmpty(Application10.getUuid()) ? Application10.getUuid() : SharedPrefrenceUtils.getString(context, Config.UUIDX, "");
        if (!TextUtils.isEmpty(uuid)) {
            return uuid;
        }
        String deviceId = null;
        String simNumber = null;
        try {
            Object o = context.getSystemService(Context.TELEPHONY_SERVICE);
            if (o != null && o instanceof TelephonyManager) {
                TelephonyManager tm = (TelephonyManager) o;
                if (tm != null) {
                    deviceId = tm.getDeviceId();
                    simNumber = tm.getSimSerialNumber();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        String macAddress = null;
        try {
            WifiManager wifi = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
            if (wifi != null && wifi.getConnectionInfo() != null) {
                macAddress = wifi.getConnectionInfo().getMacAddress();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        String androidId = null;
        try {
            androidId = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String serialNumber = null;
        try {
            serialNumber = Build.SERIAL;
        } catch (Exception e) {
            e.printStackTrace();
        }

        String bluetoothAddress = null;
        try {
            BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
            if (adapter != null) {
                bluetoothAddress = adapter.getAddress();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (TextUtils.isEmpty(deviceId))
            deviceId = "";

        if (TextUtils.isEmpty(simNumber))
            simNumber = "";

        if (TextUtils.isEmpty(macAddress))
            macAddress = "";

        if (TextUtils.isEmpty(androidId))
            androidId = "";

        if (TextUtils.isEmpty(serialNumber))
            serialNumber = "";

        if (TextUtils.isEmpty(bluetoothAddress))
            bluetoothAddress = "";

        uuid = MD5.getMessageDigest((deviceId + simNumber + macAddress).getBytes())
                + MD5.getMessageDigest((androidId + serialNumber + bluetoothAddress).getBytes());
        if (TextUtils.isEmpty(uuid)) {
            uuid = getUUIDXCache(context);
            if (TextUtils.isEmpty(uuid)) {
                String t = UUID.randomUUID().toString();
                uuid = MD5.getMessageDigest(t.getBytes());
            }
        }

        try {
            uuid = "@" + MD5Util.encryptDES(uuid + "zQcN6aR4");
        } catch (Exception e) {
            e.printStackTrace();
        }
        SharedPrefrenceUtils.saveString(context, Config.UUIDX, uuid);*/
        return "";
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static String getUUIDXCache(Context context) {
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
            File file = Environment
                    .getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
            if (file != null) {
                file = new File(file.getAbsolutePath(), ".uuid.x");
            }

            if (file != null && file.exists()) {
                FileInputStream fis = null;
                try {
                    fis = new FileInputStream(file);
                    byte[] bt = new byte[1024];
                    int length = fis.read(bt);
                    String uuid = new String(bt, 0, length);
                    if (!TextUtils.isEmpty(uuid) && uuid.length() == 32)
                        return uuid;
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (fis != null)
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                }
            }
        }
        return null;
    }
}
