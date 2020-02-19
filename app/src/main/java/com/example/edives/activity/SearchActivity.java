package com.example.edives.activity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.edives.R;
import com.example.edives.adapter.RlvSearchAdapter;
import com.example.edives.adapter.RlvSearchDataAdapter;
import com.example.edives.adapter.RlvSearchTopicAdapter;
import com.example.edives.adapter.RlvShoppingQianshuiAdapter;
import com.example.edives.adapter.RlvShoppingTripsAdapter;
import com.example.edives.adapter.SearchDynamicAdapter;
import com.example.edives.bean.DynamicSearchBean;
import com.example.edives.bean.FollowBean;
import com.example.edives.bean.LikeBean;
import com.example.edives.bean.NotFollowBean;
import com.example.edives.bean.SearchBean;
import com.example.edives.bean.SearchDataBean;
import com.example.edives.bean.SearchDelectBean;
import com.example.edives.bean.SearchDivingBean;
import com.example.edives.bean.SearchShoppingBean;
import com.example.edives.bean.SearchTopicBean;
import com.example.edives.design.CommonTitle;
import com.example.edives.frame.ApiConfig;
import com.example.edives.frame.BaseMvpActivity;
import com.example.edives.local_utils.SharedPrefrenceUtils;
import com.example.edives.model.HomeModel;
import com.example.edives.utils.CloseSearchUtils;
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

public class SearchActivity extends BaseMvpActivity<HomeModel> {

    @BindView(R.id.title)
    CommonTitle mTitle;
    @BindView(R.id.iv_shuaixuan)
    ImageView mIvShuaixuan;
    @BindView(R.id.tv_choess)
    TextView mTvChoess;
    @BindView(R.id.et_search_data)
    EditText mEtSearchData;
    @BindView(R.id.iv_delect)
    ImageView mIvDelect;
    @BindView(R.id.rl)
    RelativeLayout mRl;
    @BindView(R.id.ll)
    LinearLayout mLl;
    @BindView(R.id.rec_shopping)
    RecyclerView mRecShopping;
    @BindView(R.id.rec_huati)
    RecyclerView mRecHuati;
    @BindView(R.id.rec_search)
    RecyclerView mRecSearch;
    @BindView(R.id.rec_diving)
    RecyclerView mRecDiving;
    @BindView(R.id.tv_loct)
    TextView mTvLoct;
    @BindView(R.id.tv_clear)
    TextView mTvClear;
    @BindView(R.id.rec)
    RecyclerView mRec;
    @BindView(R.id.rl_search)
    RelativeLayout mRlSearch;
    /**
     * 动态
     */
    private TextView mTvDynamic;
    private String mTvDynamics = "动态";
    /**
     * 潜水
     */
    private TextView mTvCommodity;
    private String mTvCommoditys = "学证";
    /**
     * 商品
     */
    private TextView mTvDiving;
    private String mTvDivings = "潜水";
    /**
     * 话题
     */
    private TextView mTvConversation;
    private String mTvConversations = "话题";
    private PopupWindow popupWindows;
    private ArrayList<SearchBean.DataBean.ListBean> searchList;
    private RlvSearchDataAdapter dataAdapter;
    private int type;
    private int num = 1;
    private int size = 10;

    //历史信息
    private View inflate1;
    private RlvSearchAdapter adapter;
    private String userid;
    private ArrayList<SearchDataBean.DataBean> lists;
    private PopupWindow popupWindowss;
    private int ty;
    private ArrayList<DynamicSearchBean.DataBean.ListBean> list;
    private ArrayList<SearchShoppingBean.DataBean.ListBean> arrayList;
    private ArrayList<SearchShoppingBean.DataBean.ListBean> arrayLists;
    private ArrayList<SearchTopicBean.DataBean.ListBean> listBeans;
    private SearchDynamicAdapter adapters;
    private RlvSearchTopicAdapter adaptertopic;
    private RlvShoppingQianshuiAdapter qianshuiAdapter;
    private ArrayList<SearchDivingBean.DataBean.ListBean> DivingList;
    private RlvShoppingTripsAdapter adaptersss;

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
        return R.layout.activity_search;
    }

    @Override
    public void initView() {
        int id = getIntent().getExtras().getInt("id");
        if (id == 0) {
            mTvChoess.setText("商品");
        }
        DivingList = new ArrayList<>();
        userid = SharedPrefrenceUtils.getString(SearchActivity.this, NormalConfig.USER_PHOTO, "");
        lists = new ArrayList<>();
        searchList = new ArrayList<>();
        list = new ArrayList<>();
        arrayList = new ArrayList<>();
        listBeans = new ArrayList<>();
        arrayLists = new ArrayList<>();
        mEtSearchData.setImeOptions(EditorInfo.IME_ACTION_SEARCH);
        mEtSearchData.setInputType(EditorInfo.TYPE_CLASS_TEXT);
        mEtSearchData.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    //do something;
                    String searchdata = mEtSearchData.getText().toString();
                    if (mTvChoess.getText().toString().equals(mTvDynamics)) {
                        type = 1;
                        String userid = mApplication.userid;
                        if (searchdata.isEmpty()) {
                            showToast("搜索信息不能为空");
                        } else {
                            mPresenter.getData(ApiConfig.SEARCH_DATA, searchdata, userid, type, num, size);
                        }
                    } else if (mTvChoess.getText().toString().equals(mTvCommoditys)) {
                        type = 3;
                        String userid = mApplication.userid;
                        if (searchdata.isEmpty()) {
                            showToast("搜索信息不能为空");
                        } else {
                            mPresenter.getData(ApiConfig.SEARCH_DATA_SHOPPING, searchdata, userid, type, num, size);
                        }
                    } else if (mTvChoess.getText().toString().equals(mTvConversations)){
                        type = 4;
                        String userid = mApplication.userid;
                        if (searchdata.isEmpty()) {
                            showToast("搜索信息不能为空");
                        } else {
                            mPresenter.getData(ApiConfig.SEARCH_DATA_TOPIC, searchdata, userid, type, num, size);
                        }
                    } else if (mTvChoess.getText().toString().equals(mTvDivings)) {
                        type = 2;
                        String userid = mApplication.userid;
                        if (searchdata.isEmpty()) {
                            showToast("搜索信息不能为空");
                        } else {
                            mPresenter.getData(ApiConfig.SEARCH_DATA_SHOPPINGSSS, searchdata, userid, type, num, size);
                        }
                    }

                    //关闭软键盘
                    CloseSearchUtils.hideKeyboard(mEtSearchData);
                    return true;
                }
                return false;
            }
        });
    }

    @Override
    public void initData() {
        mPresenter.getData(ApiConfig.SEARCHLOSTIOH_DATA, userid);
    }

    @Override
    public HomeModel getModel() {
        return new HomeModel();
    }

    @Override
    public void onError(int whichApi, Throwable e) {

    }

    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.SEARCH_DATA_SHOPPINGSSS:
                mRlSearch.setVisibility(View.GONE);
                mRecSearch.setVisibility(View.GONE);
                mRecShopping.setVisibility(View.GONE);
                mRecHuati.setVisibility(View.GONE);
                mRecDiving.setVisibility(View.VISIBLE);
                SearchDivingBean divingBean = (SearchDivingBean) t[0];
                if (divingBean.getCode() == 200) {
                    List<SearchDivingBean.DataBean.ListBean> beanList = divingBean.getData().getList();
                    DivingList.addAll(beanList);
                    LinearLayoutManager linearLayoutManagers = new LinearLayoutManager(SearchActivity.this);
                    mRecDiving.setLayoutManager(linearLayoutManagers);
                    adaptersss = new RlvShoppingTripsAdapter(SearchActivity.this, DivingList);
                    mRecDiving.setAdapter(adaptersss);
                    adaptersss.setonclcik(new RlvShoppingTripsAdapter.setonclick() {
                        @Override
                        public void setonclick(int pos) {
                            int id = DivingList.get(pos).getId();
                            Intent intent = new Intent(SearchActivity.this, DivingDestiActivity.class);
                            intent.putExtra("id",id);
                            startActivity(intent);
                        }
                    });
                }else {
                    showToast(divingBean.getMessage());
                }
                break;
            case ApiConfig.SEARCH_DATA_TOPIC:
                listBeans.clear();
                mRlSearch.setVisibility(View.GONE);
                mRecSearch.setVisibility(View.GONE);
                mRecShopping.setVisibility(View.GONE);
                mRecHuati.setVisibility(View.VISIBLE);
                SearchTopicBean searchTopicBean = (SearchTopicBean) t[0];
                if (searchTopicBean.getCode() == 200) {
                    List<SearchTopicBean.DataBean.ListBean> beanList = searchTopicBean.getData().getList();
                    listBeans.addAll(beanList);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(SearchActivity.this);
                    mRecHuati.setLayoutManager(linearLayoutManager);
                    adaptertopic = new RlvSearchTopicAdapter(SearchActivity.this, listBeans);
                    mRecHuati.setAdapter(adaptertopic);
                    adaptertopic.setonclick(new RlvSearchTopicAdapter.setonclick() {
                        @Override
                        public void setonclick(int pos) {
                            int id = listBeans.get(pos).getId();
                            Intent intent = new Intent(SearchActivity.this, TopicDetailsActivity.class);
                            intent.putExtra("id",id);
                            startActivity(intent);
                        }
                    });
//                    Intent intent = new Intent(SearchActivity.this, SearchTopicActivity.class);
//                    intent.putParcelableArrayListExtra("list", listBeans);
//                    startActivity(intent);
                } else {
                    showToast(searchTopicBean.getMessage());
                }
                break;
            case ApiConfig.SEARCH_DATA_SHOPPING:
                arrayList.clear();
                mRlSearch.setVisibility(View.GONE);
                mRecHuati.setVisibility(View.GONE);
                mRecShopping.setVisibility(View.VISIBLE);
                mRecSearch.setVisibility(View.GONE);
                SearchShoppingBean searchShoppingBean = (SearchShoppingBean) t[0];
                if (searchShoppingBean.getCode() == 200) {
                    List<SearchShoppingBean.DataBean.ListBean> beanList = searchShoppingBean.getData().getList();
                    arrayList.addAll(beanList);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(SearchActivity.this);
                    mRecShopping.setLayoutManager(linearLayoutManager);
                    qianshuiAdapter = new RlvShoppingQianshuiAdapter(SearchActivity.this, arrayList);
                    mRecShopping.setAdapter(qianshuiAdapter);
                    qianshuiAdapter.setonclick(new RlvShoppingQianshuiAdapter.setonclick() {
                        @Override
                        public void setonclick(int pos) {
                            int id = arrayList.get(pos).getId();
                            int productNum = arrayList.get(pos).getProductNum();
                            if (productNum == 0) {
                                showToast("此产品暂无信息");
                            }else {
//                                Intent intent = new Intent(SearchActivity.this, DivingCertificateActivity.class);
//                                intent.putExtra("id",id);
//                                startActivity(intent);
                            }
                        }
                    });
                } else {
                    showToast(searchShoppingBean.getMessage());
                }
                break;

            case ApiConfig.SEARCH_DATA:
                mRecSearch.setVisibility(View.VISIBLE);
                mRlSearch.setVisibility(View.GONE);
                mRecShopping.setVisibility(View.GONE);
                mRecHuati.setVisibility(View.GONE);
                searchList.clear();
                SearchBean bean = (SearchBean) t[0];
                if (bean.getCode() == 200) {
                    List<SearchBean.DataBean.ListBean> reult = bean.getData().getList();
                    searchList.addAll(reult);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(SearchActivity.this);
                    mRecSearch.setLayoutManager(linearLayoutManager);
                    String s = mApplication.userid.toString();
                    final Integer integer = Integer.valueOf(s);
                    adapters = new SearchDynamicAdapter(SearchActivity.this, searchList,integer);
                    mRecSearch.setAdapter(adapters);
                    adapters.setonclicklistents(new SearchDynamicAdapter.setonclicklistents() {
                        @Override
                        public void setonclicklistents(int pos) {
                            int userId = searchList.get(pos).getUserId();
                            int userType = searchList.get(pos).getUserType();
                            Intent intent = new Intent(SearchActivity.this, UserPersonDestialsActivity.class);
                            intent.putExtra("id",userId);
                            intent.putExtra("userType",userType);

                            startActivity(intent);
                        }
                    });
                    adapters.setonclickListent(new SearchDynamicAdapter.setonclickListent() {
                        @Override
                        public void setonclickListent(int pos) {
                            Intent intent = new Intent(SearchActivity.this, DynamicDetailsActivity.class);
                            intent.putExtra("pos",searchList.get(pos).getId());
                            intent.putExtra("pl",0);
                            intent.putExtra("userType",searchList.get(pos).getUserType());
                            startActivity(intent);
                        }
                    });
                    adapters.setlikeonclick(new SearchDynamicAdapter.setlikeonclick() {
                        @Override
                        public void setlikeonclick(int pos, View view) {
                            int userId = searchList.get(pos).getId();
                            int userType = searchList.get(pos).getUserType();
                            mPresenter.getData(ApiConfig.NEWSLIKE,userId,userType);
                        }
                    });
                    adapters.setnolikeonclick(new SearchDynamicAdapter.setnolikeonclick() {
                        @Override
                        public void setnolikeonclick(int pos, View view) {
                            int userId = searchList.get(pos).getId();
                            int userType = searchList.get(pos).getUserType();
                            mPresenter.getData(ApiConfig.NOTLIKE,userId,userType);
                        }
                    });
                    adapters.setonguanzhu(new SearchDynamicAdapter.setonguanzhu() {
                        @Override
                        public void setonguanzhu(int pos) {
                            int userId = searchList.get(pos).getUserId();
                            int userType = searchList.get(pos).getUserType();
                            MediaType type = MediaType.parse("application/json;charset=UTF-8");
                            JSONObject jsonObject = new JSONObject();
                            try {
                                jsonObject.put("favoriteType", userType);
                                jsonObject.put("status", 1);
                                jsonObject.put("targetId", userId);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            String string = jsonObject.toString();
                            RequestBody body = RequestBody.create(type, string);
                            mPresenter.getData(ApiConfig.FOLLOWUSER,body);
                        }
                    });

                    adapters.setonnoguanzhu(new SearchDynamicAdapter.setonnoguanzhu() {
                        @Override
                        public void setonnoguanzhu(int pos) {
                            int userId = searchList.get(pos).getUserId();
                            int userType = searchList.get(pos).getUserType();
                            MediaType type = MediaType.parse("application/json;charset=UTF-8");
                            JSONObject jsonObject = new JSONObject();
                            try {
                                jsonObject.put("favoriteType", userType);
                                jsonObject.put("status", 2);
                                jsonObject.put("targetId", userId);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            String string = jsonObject.toString();
                            RequestBody body = RequestBody.create(type, string);
                            mPresenter.getData(ApiConfig.NOTFOLLOWS,body);
                        }
                    });

                } else {
                    showToast(bean.getMessage());
                }



                break;
            case ApiConfig.NEWSLIKE:
                LikeBean likeBean = (LikeBean) t[0];
                if (likeBean.getCode() == 200) {
                    showToast("点赞成功");
                }
                break;
            case ApiConfig.NOTLIKE:
                LikeBean been = (LikeBean) t[0];
                if (been.getCode() == 200) {
                    showToast("取消点赞");
                }
                break;
            case ApiConfig.FOLLOWUSER:
                FollowBean followBean = (FollowBean) t[0];
                if (followBean.getCode() == 200) {
                    showToast("关注成功");
                    searchList.clear();
                    mPresenter.getData(ApiConfig.SEARCH_DATA, mEtSearchData.getText().toString(), userid, type, num, size);
                } else if (followBean.getCode() == 500) {
                    showToast(followBean.getMessage());
                }
                break;
            case ApiConfig.NOTFOLLOWS:
                NotFollowBean notFollowBean = (NotFollowBean) t[0];
                if (notFollowBean.getCode() == 200) {
                    showToast("取消关注");
                    searchList.clear();
                    mPresenter.getData(ApiConfig.SEARCH_DATA, mEtSearchData.getText().toString(), userid, type, num, size);
                }
                break;
            case ApiConfig.SEARCHLOSTIOH_DATA:
                lists.clear();
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(SearchActivity.this);
                mRec.setLayoutManager(linearLayoutManager);
                adapter = new RlvSearchAdapter(SearchActivity.this, lists);
                mRec.setAdapter(adapter);
                SearchDataBean beanss = (SearchDataBean) t[0];
                List<SearchDataBean.DataBean> data = beanss.getData();
                lists.addAll(data);
                adapter.notifyDataSetChanged();
                break;
            case ApiConfig.SEARCHDELECT:
                SearchDelectBean searchDelectBean = (SearchDelectBean) t[0];
                if (searchDelectBean.getCode() == 200) {
                    lists.clear();
                    showToast(searchDelectBean.getMessage());
                    mPresenter.getData(ApiConfig.SEARCHLOSTIOH_DATA, userid);
                } else {
                    showToast(searchDelectBean.getMessage());
                }
                break;
        }
    }

    @OnClick({R.id.tv_choess, R.id.iv_delect, R.id.tv_clear})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.tv_choess:
                View inflate1 = LayoutInflater.from(this).inflate(R.layout.layout_popo_search, null);
                mTvDiving = inflate1.findViewById(R.id.tv_diving);
                mTvDynamic = (TextView) inflate1.findViewById(R.id.tv_dynamic);
                mTvCommodity = (TextView) inflate1.findViewById(R.id.tv_commodity);
                mTvConversation = (TextView) inflate1.findViewById(R.id.tv_conversation);
                final PopupWindow popupWindow = new PopupWindow(inflate1, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                popupWindow.setBackgroundDrawable(new ColorDrawable());
                popupWindow.setOutsideTouchable(true);
                popupWindow.setAnimationStyle(R.style.PopupAnimation);
                // 设置背景颜色变暗
                WindowManager.LayoutParams lps = this.getWindow().getAttributes();
                lps.alpha = 0.7f;
                this.getWindow().setAttributes(lps);
                popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        WindowManager.LayoutParams lp = SearchActivity.this.getWindow().getAttributes();
                        lp.alpha = 1f;
                        SearchActivity.this.getWindow().setAttributes(lp);
                    }
                });

                popupWindow.showAtLocation(inflate1, Gravity.BOTTOM, 0, 0);
                mTvDiving.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mTvChoess.setText(mTvDivings);
                        popupWindow.dismiss();
                    }
                });
                mTvDynamic.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mTvChoess.setText(mTvDynamics);
                        popupWindow.dismiss();
                    }
                });
                mTvCommodity.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mTvChoess.setText(mTvCommoditys);
                        popupWindow.dismiss();
                    }
                });
                mTvConversation.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mTvChoess.setText(mTvConversations);
                        popupWindow.dismiss();
                    }
                });
                break;
            case R.id.iv_delect:
                //清除历史
                String id = SharedPrefrenceUtils.getString(SearchActivity.this, NormalConfig.USER_PHOTO, "");
                mPresenter.getData(ApiConfig.SEARCHDELECT, id);
                break;
            case R.id.tv_clear:
                mEtSearchData.setText("");
                mRecHuati.setVisibility(View.GONE);
                mRlSearch.setVisibility(View.VISIBLE);
                mRecShopping.setVisibility(View.GONE);
                mRecSearch.setVisibility(View.GONE);
                mRecDiving.setVisibility(View.GONE);
                CloseSearchUtils.hideKeyboard(mEtSearchData);
                break;
        }
    }
}
