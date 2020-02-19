package com.example.edives.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.edives.R;
import com.example.edives.adapter.RlvAddressListAdapter;
import com.example.edives.bean.AddBean;
import com.example.edives.bean.AddressListBean;
import com.example.edives.bean.DelectAddressBean;
import com.example.edives.design.CommonTitle;
import com.example.edives.frame.ApiConfig;
import com.example.edives.frame.BaseMvpActivity;
import com.example.edives.local_utils.SharedPrefrenceUtils;
import com.example.edives.model.PersonModel;
import com.example.edives.utils.NormalConfig;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class ChooesAddaressActivity extends BaseMvpActivity<PersonModel> {

    @BindView(R.id.title)
    CommonTitle mTitle;
    @BindView(R.id.rec)
    RecyclerView mRec;
    @BindView(R.id.bt_add)
    Button mBtAdd;
    private String id;
    private int num = 1;
    private int size = 10;
    private ArrayList<AddressListBean.ResultBean.ListBean> list;
    private RlvAddressListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//因为不是所有的系统都可以设置颜色的，在4.4以下就不可以。。有的说4.1，所以在设置的时候要检查一下系统版本是否是4.1以上
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.app_setting));
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_chooes_addaress;
    }

    @Override
    public void initView() {
        id = SharedPrefrenceUtils.getString(ChooesAddaressActivity.this, NormalConfig.USER_PHOTO, "");
        list = new ArrayList<>();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ChooesAddaressActivity.this);
        mRec.setLayoutManager(linearLayoutManager);
        adapter = new RlvAddressListAdapter(ChooesAddaressActivity.this, list);
        mRec.setAdapter(adapter);
        adapter.setonclickmoren(new RlvAddressListAdapter.setonclickmoren() {
            @Override
            public void setonclickmoren(int pos) {
                int id = list.get(pos).getId();
                mPresenter.getData(ApiConfig.ADDARESSMOREN, id);
            }
        });
        adapter.setonDelect(new RlvAddressListAdapter.setonDelect() {
            @Override
            public void setonDelect(int pos) {
                int id = list.get(pos).getId();
                list.remove(pos);
                mPresenter.getData(ApiConfig.DELECTADDRESS, id);
            }
        });
        adapter.setonbjclick(new RlvAddressListAdapter.setonbjclick() {
            @Override
            public void setonbjclick(int pos) {
                int id = list.get(pos).getId();
                Intent intent = new Intent(ChooesAddaressActivity.this, EditActivity.class);
                intent.putExtra("name", list.get(pos).getReceiverName());
                intent.putExtra("phone", list.get(pos).getReceiverMobileNo());
                intent.putExtra("addaress", list.get(pos).getDetailAddress());
                intent.putExtra("cityname", list.get(pos).getCityName());
                intent.putExtra("provinceName", list.get(pos).getProvinceName());
                intent.putExtra("districtName", list.get(pos).getDistrictName());
                intent.putExtra("id", id);
                intent.putExtra("dount", list.get(pos).getDefaultAddress());
                startActivity(intent);
            }
        });
        adapter.setonclick(new RlvAddressListAdapter.setonclick() {
            @Override
            public void setonclick(int pos) {
                Intent intent = new Intent();
                String name = list.get(pos).getReceiverName();
                String phone = list.get(pos).getReceiverMobileNo();
                String cityName = list.get(pos).getCityName();
                String districtName = list.get(pos).getDistrictName();
                String detailAddress = list.get(pos).getDetailAddress();
                int id = list.get(pos).getId();
                intent.putExtra("id", id);
                intent.putExtra("name", name);
                intent.putExtra("phone", phone);
                intent.putExtra("cityName", cityName);
                intent.putExtra("districtName", districtName);
                intent.putExtra("detailAddress", detailAddress);
                intent.putExtra("wc", 3);
                setResult(200, intent);
                finish();
            }
        });
    }

    @Override
    public void initData() {
        MediaType type = MediaType.parse("application/json;charset=UTF-8");
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("adminId", id);
            jsonObject.put("pageNum", num);
            jsonObject.put("pageSize", size);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        String strings = jsonObject.toString();
        RequestBody body = RequestBody.create(type, strings);
        mPresenter.getData(ApiConfig.ADDRESSLIST, body);
    }

    @Override
    public PersonModel getModel() {
        return new PersonModel();
    }

    @Override
    public void onError(int whichApi, Throwable e) {

    }

    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.ADDRESSLIST:
                list.clear();
                AddressListBean addressListBean = (AddressListBean) t[0];
                if (addressListBean.getCode() == 200) {
                    List<AddressListBean.ResultBean.ListBean> result = addressListBean.getResult().getList();
                    this.list.addAll(result);
                    adapter.notifyDataSetChanged();
                }
                break;
            case ApiConfig.DELECTADDRESS:
                DelectAddressBean addressBean = (DelectAddressBean) t[0];
                if (addressBean.getCode() == 200) {
                    showToast("删除成功");
                    adapter.notifyDataSetChanged();
                }
                break;
            case ApiConfig.ADDARESSMOREN:
                AddBean addBean = (AddBean) t[0];
                if (addBean.getCode() == 200) {
                    showToast("设置成功");
//                    MediaType type = MediaType.parse("application/json;charset=UTF-8");
//                    JSONObject jsonObject = new JSONObject();
//                    try {
//                        jsonObject.put("adminId", id);
//                        jsonObject.put("pageNum", num);
//                        jsonObject.put("pageSize", size);
//
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                    String strings = jsonObject.toString();
//                    RequestBody body = RequestBody.create(type, strings);
//                    mPresenter.getData(ApiConfig.ADDRESSLIST,body);
                } else {
                    showToast(addBean.getMessage());
                }

                break;
        }
    }

    @OnClick(R.id.bt_add)
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.bt_add:
                startActivity(new Intent(ChooesAddaressActivity.this,AddAddressActivity.class));
                break;
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        MediaType type = MediaType.parse("application/json;charset=UTF-8");
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("adminId", id);
            jsonObject.put("pageNum", num);
            jsonObject.put("pageSize", size);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        String strings = jsonObject.toString();
        RequestBody body = RequestBody.create(type, strings);
        mPresenter.getData(ApiConfig.ADDRESSLIST, body);
    }
}
