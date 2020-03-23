package com.example.edives.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.edives.R;
import com.example.edives.activity.ChatActivity;
import com.example.edives.frame.BaseMvpFragment;
import com.example.edives.model.HomeModel;
import com.tencent.imsdk.TIMConversationType;
import com.tencent.imsdk.TIMGroupManager;
import com.tencent.imsdk.TIMValueCallBack;
import com.tencent.imsdk.ext.group.TIMGroupBaseInfo;
import com.tencent.qcloud.tim.uikit.modules.chat.base.ChatInfo;
import com.tencent.qcloud.tim.uikit.modules.conversation.ConversationLayout;
import com.tencent.qcloud.tim.uikit.modules.conversation.ConversationListLayout;
import com.tencent.qcloud.tim.uikit.modules.conversation.ConversationManagerKit;
import com.tencent.qcloud.tim.uikit.modules.conversation.base.ConversationInfo;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClubFragment extends BaseMvpFragment<HomeModel> {

    private List<ConversationInfo> conversations = new ArrayList<>();
    //    private String url = "https://gank.io/api/data/%E7%A6%8F%E5%88%A9/10/1";
    @BindView(R.id.conversation_layout)
    ConversationLayout conversationLayout;
    @Override
    public int getLayoutId() {
        return R.layout.fragment_club;
    }

    @Override
    public void initView() {
        getGroupList();
        conversationLayout.initDefault();
        conversationLayout.getTitleBar().setVisibility(View.GONE);
        customizeConversation(conversationLayout);
    }

    public void customizeConversation(final ConversationLayout layout) {
        // 从 ConversationLayout 获取会话列表
        ConversationListLayout listLayout = layout.getConversationList();

        listLayout.setItemAvatarRadius(15);// 设置 item 头像是否显示圆角，默认是方形
        listLayout.setOnItemClickListener(new ConversationListLayout.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int i, ConversationInfo conversationInfo) {
                startChatActivity(conversationInfo);
            }
        });
        listLayout.setBackground(R.color.Setting_bg);
    }

    @Override
    public void initData() {
//        mPresenter.getData(ApiConfig.CLUB_DATA,url);
    }

    /**
     * 获取群组列表,并组装空消息
     */
    private void getGroupList(){
        TIMGroupManager.getInstance().getGroupList(new TIMValueCallBack<List<TIMGroupBaseInfo>>() {
            @Override
            public void onError(int i, String s) {

            }

            @Override
            public void onSuccess(List<TIMGroupBaseInfo> timGroupBaseInfos) {
                for (TIMGroupBaseInfo baseInfo : timGroupBaseInfos){
                    ConversationInfo conversationInfo = new ConversationInfo();
                    conversationInfo.setGroup(true);
                    List<Object> face = new ArrayList<>();
                    face.add(baseInfo.getFaceUrl());
                    conversationInfo.setIconUrlList(face);
                    conversationInfo.setId(baseInfo.getGroupId());
                    conversationInfo.setTitle(baseInfo.getGroupName());
                    ConversationManagerKit.getInstance().addConversation(conversationInfo);
                }
            }
        });
    }

    @Override
    public HomeModel getModel() {
        return new HomeModel();
    }

    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi){
//            case ApiConfig.CLUB_DATA:
//                FuBean bean = (FuBean) t[0];
//                List<FuBean.ResultsBean> results = bean.getResults();
//                list.addAll(results);
//                adapter.notifyDataSetChanged();
//                break;
        }
    }

    @Override
    public void onError(int whichApi, Throwable e) {

    }

    private void startChatActivity(ConversationInfo conversationInfo) {
        ChatInfo chatInfo = new ChatInfo();
        chatInfo.setType(conversationInfo.isGroup() ? TIMConversationType.Group : TIMConversationType.C2C);
        chatInfo.setId(conversationInfo.getId());
        chatInfo.setChatName(conversationInfo.getTitle());
        Intent intent = new Intent(getActivity(), ChatActivity.class);
        intent.putExtra("chatinfo", chatInfo);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getActivity().startActivity(intent);
    }
}
