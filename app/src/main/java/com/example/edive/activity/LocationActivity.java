package com.example.edive.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;
import com.example.edive.R;
import com.example.edive.adapter.RlvLocationAdapter;
import com.example.edive.bean.LocationInfo;
import com.example.edive.frame.BaseMvpActivity;
import com.example.edive.model.HomeModel;
import com.example.edive.utils.CloseSearchUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LocationActivity extends BaseMvpActivity<HomeModel> implements AMapLocationListener, PoiSearch.OnPoiSearchListener {

    @BindView(R.id.iv_back)
    ImageView mIvBack;
    @BindView(R.id.bt_ok)
    Button mBtOk;
    @BindView(R.id.et_search_data)
    EditText mEtSearchData;
    @BindView(R.id.rec)
    RecyclerView mRec;

    private ArrayList<LocationInfo> list;
    private RlvLocationAdapter adapter;
    private AMapLocationClientOption locationOption = new AMapLocationClientOption();
    public AMapLocationClient mlocationClient = null;
    private String key;
    private String address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//因为不是所有的系统都可以设置颜色的，在4.4以下就不可以。。有的说4.1，所以在设置的时候要检查一下系统版本是否是4.1以上
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.findpassword_bg));
        }
        initGess();
        initLocate();
    }
    private void initGess() {
        if (ContextCompat.checkSelfPermission(LocationActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {//未开启定位权限
            //开启定位权限,200是标识码
            ActivityCompat.requestPermissions(LocationActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 200);
        } else {
            //开始定位
            Toast.makeText(LocationActivity.this, "已开启定位权限", Toast.LENGTH_LONG).show();
        }
    }
    @Override
    public int getLayoutId() {
        return R.layout.activity_location;
    }

    @Override
    public void initView() {
        list = new ArrayList<>();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(LocationActivity.this);
        mRec.setLayoutManager(linearLayoutManager);
        adapter = new RlvLocationAdapter(this, list);
        mRec.setAdapter(adapter);
        adapter.setonclcik(new RlvLocationAdapter.setonclick() {
            @Override
            public void setonclick(int pos) {
                if (pos <0) {
                    address = "不显示位置";
                }else {
                    address = list.get(pos).getAddress();
                }
                Intent intent = new Intent();
                intent.putExtra("lo",address);
                setResult(200,intent);
                finish();
            }
        });

        mEtSearchData.setImeOptions(EditorInfo.IME_ACTION_SEARCH);
        mEtSearchData.setInputType(EditorInfo.TYPE_CLASS_TEXT);
        mEtSearchData.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    //do something;
                    key = mEtSearchData.getText().toString();
                    initLocate();
                    CloseSearchUtils.hideKeyboard(mEtSearchData);
                    return true;
                }
                return false;
            }
        });
    }

    @Override
    public void initData() {

    }

    @Override
    public HomeModel getModel() {
        return new HomeModel();
    }

    @OnClick({R.id.iv_back, R.id.bt_ok})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.iv_back:
                mlocationClient.stopLocation();//停止定位后，本地定位服务并不会被销毁
                mlocationClient.onDestroy();//销毁定位客户端，同时销毁本地定位服务。
                finish();
                break;
            case R.id.bt_ok:
                break;
        }
    }

    @Override
    public void onLocationChanged(AMapLocation amapLocation) {
        if (amapLocation != null) {
            if (amapLocation.getErrorCode() == 0) {
                //定位成功回调信息，设置相关消息
                amapLocation.getLocationType();//获取当前定位结果来源，如网络定位结果，详见定位类型表
                double latitude = amapLocation.getLatitude();//获取纬度
                double longitude = amapLocation.getLongitude();//获取经度
                amapLocation.getAccuracy();//获取精度信息
                Log.e("haha", amapLocation.getAddress());
                LocationInfo locationInfo = new LocationInfo();
                locationInfo.setAddress(amapLocation.getAddress());
                locationInfo.setLatitude(latitude);
                locationInfo.setLonTitude(longitude);
                list.clear();
                list.add(locationInfo);
                adapter.notifyDataSetChanged();
                mlocationClient.stopLocation();


                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = new Date(amapLocation.getTime());
                df.format(date);//定位时间
                PoiSearch.Query query = new PoiSearch.Query(key, "", "");
                query.setPageSize(20);
                PoiSearch search = new PoiSearch(this, query);
                search.setBound(new PoiSearch.SearchBound(new LatLonPoint(latitude, longitude), 10000));
                search.setOnPoiSearchListener(this);
                search.searchPOIAsyn();

            } else {
                //显示错误信息ErrCode是错误码，errInfo是错误信息，详见错误码表。
                Log.e("AmapError", "location Error, ErrCode:"
                        + amapLocation.getErrorCode() + ", errInfo:"
                        + amapLocation.getErrorInfo());
            }
        }
    }

    @Override
    public void onPoiSearched(PoiResult poiResult, int i) {
        PoiSearch.Query query = poiResult.getQuery();
        ArrayList<PoiItem> pois = poiResult.getPois();
        for (PoiItem poi : pois) {
            String name = poi.getCityName();
            String snippet = poi.getSnippet();
            LocationInfo info = new LocationInfo();
            info.setAddress(snippet);
            LatLonPoint point = poi.getLatLonPoint();

            info.setLatitude(point.getLatitude());
            info.setLonTitude(point.getLongitude());
            list.add(info);
            Log.d("haha", "poi" + snippet);
        }
        adapter.notifyDataSetChanged();
        mlocationClient.stopLocation();
    }

    @Override
    public void onPoiItemSearched(PoiItem poiItem, int i) {

    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 200:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                } else {
                    Toast.makeText(this, "未开启定位权限，请手动到设置去开去权限", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void onError(int whichApi, Throwable e) {

    }

    @Override
    public void onResponse(int whichApi, Object[] t) {

    }
    private void initLocate() {
        //声明mLocationOption对象
        AMapLocationClientOption mLocationOption = null;
        mlocationClient = new AMapLocationClient(getApplicationContext());
        //初始化定位参数
        mLocationOption = new AMapLocationClientOption();
        //设置定位监听
        mlocationClient.setLocationListener(this);
        //设置定位模式为高精度模式，Battery_Saving为低功耗模式，Device_Sensors是仅设备模式
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        //设置定位间隔,单位毫秒,默认为2000ms
        mLocationOption.setInterval(1000);
        mLocationOption.setOnceLocationLatest(false);
        mLocationOption.setHttpTimeOut(20000);
        //设置定位参数
        mlocationClient.setLocationOption(mLocationOption);
        // 此方法为每隔固定时间会发起一次定位请求，为了减少电量消耗或网络流量消耗，
        // 注意设置合适的定位时间的间隔（最小间隔支持为2000ms），并且在合适时间调用stopLocation()方法来取消定位请求
        // 在定位结束后，在合适的生命周期调用onDestroy()方法
        // 在单次定位情况下，定位无论成功与否，都无需调用stopLocation()方法移除请求，定位sdk内部会移除
        //启动定位
        mlocationClient.startLocation();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mlocationClient.stopLocation();
        mlocationClient.onDestroy();
    }
}
