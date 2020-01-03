package com.example.edives.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.edives.R;
import com.example.edives.adapter.RlvDynamicDetailsAdapter;
import com.example.edives.adapter.RlvMessagerPlMAdapter;
import com.example.edives.bean.AllCommentBean;
import com.example.edives.bean.CommentBean;
import com.example.edives.bean.DynamicDetailsBean;
import com.example.edives.bean.FollowBean;
import com.example.edives.bean.LikeBean;
import com.example.edives.bean.NotFollowBean;
import com.example.edives.design.CommonTitle;
import com.example.edives.frame.ApiConfig;
import com.example.edives.frame.BaseMvpActivity;
import com.example.edives.model.HomeModel;
import com.example.edives.utils.CloseSearchUtils;
import com.example.edives.utils.NormalConfig;
import com.example.edives.utils.SharedPrefrenceUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class DynamicDetailsActivity extends BaseMvpActivity<HomeModel> {

    @BindView(R.id.title)
    CommonTitle mTitle;
    @BindView(R.id.rec)
    RecyclerView mRec;
    @BindView(R.id.rec_pl)
    RecyclerView mRecPl;
    @BindView(R.id.sv)
    ScrollView mSv;
    @BindView(R.id.et_text)
    EditText mEtText;
    @BindView(R.id.ll)
    LinearLayout mLl;
    private int pos;
    private ArrayList<DynamicDetailsBean.DataBean> list;
    private RlvDynamicDetailsAdapter adapter;
    private int pagenum = 1;
    private int index ;
    private int pagesize = 5;
    private boolean like = false;
    private ArrayList<AllCommentBean.DataBean.ListBean> commentList;
    private RlvMessagerPlMAdapter plMAdapter;
    private boolean isLastPage;
    private int userType;

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
        return R.layout.activity_dynamic_details;
    }

    @Override
    public void initView() {
        pos = getIntent().getExtras().getInt("pos");
        userType = getIntent().getExtras().getInt("userType");
        final int pl = getIntent().getExtras().getInt("pl");
        if (pl == 1) {
            showSoftInputFromWindow(mEtText);
        }
        //分享
        mTitle.mMoreImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        commentList = new ArrayList<>();
        list = new ArrayList<>();
        final LinearLayoutManager linearLayoutManagers = new LinearLayoutManager(DynamicDetailsActivity.this);
        mRecPl.setLayoutManager(linearLayoutManagers);
        mRecPl.setItemAnimator(new DefaultItemAnimator());
        mRecPl.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    int lastVisiblePosition = linearLayoutManagers.findLastVisibleItemPosition();
                    if (lastVisiblePosition >= linearLayoutManagers.getItemCount() - 1) {
                        if (isLastPage == false) {
                            pagenum++;
                            mPresenter.getData(ApiConfig.APLLCOMMENT, pagenum, pagesize, pos);
                        }

//                        System.out.println("====自动加载");
                    }
                }
            }
        });
        plMAdapter = new RlvMessagerPlMAdapter(DynamicDetailsActivity.this, commentList);
        mRecPl.setAdapter(plMAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(DynamicDetailsActivity.this);
        mRec.setLayoutManager(linearLayoutManager);
        Integer integer = Integer.valueOf(mApplication.userid);

        adapter = new RlvDynamicDetailsAdapter(DynamicDetailsActivity.this, list, commentList, integer);
//        mRec.getItemAnimator().setSupportsChangeAnimations(false); // 取消动画效果
        mRec.setAdapter(adapter);
        adapter.setonclickListent(new RlvDynamicDetailsAdapter.setonclickListent() {
            @Override
            public void setonclickListent(int pos) {
                int userId = list.get(pos).getUserId();
                int userType = list.get(pos).getUserType();
                Intent intent = new Intent(DynamicDetailsActivity.this, UserPersonDestialsActivity.class);
                intent.putExtra("id", userId);
                intent.putExtra("userType", userType);
                startActivity(intent);
            }
        });
        adapter.setonzhuanfa(new RlvDynamicDetailsAdapter.setonzhuanfa() {
            @Override
            public void setonzhuanfa(int pos) {
                showSoftInputFromWindow(mEtText);
            }
        });
        adapter.setlikeonclick(new RlvDynamicDetailsAdapter.setlikeonclick() {
            @Override
            public void setlikeonclick(int pos, View view) {
                int userId = list.get(pos).getId();
                int userType = list.get(pos).getUserType();
                mPresenter.getData(ApiConfig.NEWSLIKE, userId,userType);
            }
        });
        adapter.setnolikeonclick(new RlvDynamicDetailsAdapter.setnolikeonclick() {
            @Override
            public void setnolikeonclick(int pos, View view) {
                int userId = list.get(pos).getId();
                int userType = list.get(pos).getUserType();
                mPresenter.getData(ApiConfig.NOTLIKE, userId,userType);
            }
        });
        adapter.setfollowonclick(new RlvDynamicDetailsAdapter.setfollowonclick() {
            @Override
            public void setfollowonclick(int targetid, int pos) {
                int userId = list.get(pos).getUserId();
                int userType = list.get(pos).getUserType();
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
                mPresenter.getData(ApiConfig.FOLLOWUSER, body);
            }
        });

        adapter.setnotfollowonclick(new RlvDynamicDetailsAdapter.setnotfollowonclick() {
            @Override
            public void setnotfollowonclick(int targetid, int pos) {
                int userId = list.get(pos).getUserId();
                int userType = list.get(pos).getUserType();
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
                mPresenter.getData(ApiConfig.NOTFOLLOWS, body);
            }
        });
//        adapter.setlikeonclick(new RlvDynamicDetailsAdapter.setlikeonclick() {
//            @Override
//            public void setlikeonclick(int pos, View view) {
//                int id = list.get(pos).getId();
//
//                if (like) {
//                    mPresenter.getData(ApiConfig.NOTLIKE,id);
//                }else {
//                    mPresenter.getData(ApiConfig.NEWSLIKE,id);
//                }
//            }
//        });

        mEtText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    String content = mEtText.getText().toString();
                    String icon = SharedPrefrenceUtils.getString(DynamicDetailsActivity.this, NormalConfig.ICON);
                    String name = SharedPrefrenceUtils.getString(DynamicDetailsActivity.this, NormalConfig.NICKNAME);
                    String id = SharedPrefrenceUtils.getString(DynamicDetailsActivity.this, NormalConfig.USER_PHOTO);
                    MediaType type = MediaType.parse("application/json;charset=UTF-8");
                    JSONObject jsonObject = new JSONObject();
                    try {
                        jsonObject.put("commentHeadPortrait", icon);
                        jsonObject.put("commentName", name);
                        jsonObject.put("content", content);
                        jsonObject.put("forDynamicId", pos);
                        jsonObject.put("userId", id);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    String string = jsonObject.toString();
                    RequestBody body = RequestBody.create(type, string);
                    mPresenter.getData(ApiConfig.NEWSDYNAMICDEATILS_COMMENT, body);
                    CloseSearchUtils.hideKeyboard(mEtText);
                }
                return false;
            }
        });
    }

    @Override
    public void initData() {
        mPresenter.getData(ApiConfig.APLLCOMMENT, pagenum, pagesize, pos);
        mPresenter.getData(ApiConfig.DYNAMICDEATILS_DATA_PL, pos,userType);
    }

    @Override
    public HomeModel getModel() {
        return new HomeModel();
    }

    @Override
    public void onError(int whichApi, Throwable e) {
        showToast(e
        .getMessage());
    }

    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.NEWSLIKE:
                LikeBean likeBean = (LikeBean) t[0];
                if (likeBean.getCode() == 200) {
                    showToast(likeBean.getMessage());

                }
                break;
            case ApiConfig.NOTLIKE:
                LikeBean been = (LikeBean) t[0];
                if (been.getCode() == 200) {
                    showToast(been.getMessage());

//                    adapter.notifyDataSetChanged();
                }
                break;
            case ApiConfig.DYNAMICDEATILS_DATA_PL:
                DynamicDetailsBean bean = (DynamicDetailsBean) t[0];
                List<DynamicDetailsBean.DataBean> data = bean.getData();
                list.addAll(data);
                adapter.notifyDataSetChanged();
                plMAdapter.notifyDataSetChanged();
                break;
            case ApiConfig.NEWSDYNAMICDEATILS_COMMENT:
                CommentBean commentBean = (CommentBean) t[0];
                if (commentBean.getCode() == 200) {
                    showToast(commentBean.getMessage());
                    mEtText.setText("");
                    mPresenter.getData(ApiConfig.APLLCOMMENT, pagenum, pagesize, pos);
                }
                break;
            case ApiConfig.APLLCOMMENT:
//                commentList.clear();
                AllCommentBean allCommentBean = (AllCommentBean) t[0];
                List<AllCommentBean.DataBean.ListBean> beanList = allCommentBean.getData().getList();
                if (allCommentBean.getCode() == 200) {
                    isLastPage = allCommentBean.getData().isIsLastPage();
                    commentList.addAll(beanList);
                    adapter.notifyDataSetChanged();
                    plMAdapter.notifyDataSetChanged();
                }
                break;
            case ApiConfig.FOLLOWUSER:
                FollowBean followBean = (FollowBean) t[0];
                if (followBean.getCode() == 200) {
                    showToast("关注成功");

                } else if (followBean.getCode() == 500) {
                    showToast(followBean.getMessage());
                }
                break;
            case ApiConfig.NOTFOLLOWS:
                NotFollowBean notFollowBean = (NotFollowBean) t[0];
                if (notFollowBean.getCode() == 200) {
                    showToast("取消关注");
                }
                break;
        }
    }

    public static void showSoftInputFromWindow(EditText editText) {
        editText.setFocusable(true);
        editText.setFocusableInTouchMode(true);
        editText.requestFocus();
        InputMethodManager inputManager =
                (InputMethodManager) editText.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.showSoftInput(editText, 0);
    }
}
