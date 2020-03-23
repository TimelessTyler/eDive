package com.example.edives.activity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.example.edives.R;
import com.example.edives.frame.BaseActivity;
import com.tencent.imsdk.TIMConversationType;
import com.tencent.qcloud.tim.uikit.component.AudioPlayer;
import com.tencent.qcloud.tim.uikit.component.TitleBarLayout;
import com.tencent.qcloud.tim.uikit.modules.chat.ChatLayout;
import com.tencent.qcloud.tim.uikit.modules.chat.base.ChatInfo;
import com.tencent.qcloud.tim.uikit.modules.chat.layout.message.MessageLayout;
import com.tencent.qcloud.tim.uikit.modules.message.MessageInfo;

public class ChatActivity extends BaseActivity {
    ChatLayout mChatLayout;
    private TitleBarLayout mTitleBar;
    private ChatInfo mChatInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        setDarkTheme();
        mChatLayout = findViewById(R.id.chat_layout);
        initView();
    }

    private void initView() {
        mChatInfo = (ChatInfo) getIntent().getSerializableExtra("chatinfo");
        if (mChatInfo == null) {
            return;
        }
        //单聊组件的默认UI和交互初始化
        mChatLayout.initDefault();

        /*
         * 需要聊天的基本信息
         */
        mChatLayout.setChatInfo(mChatInfo);
        mChatLayout.getMessageLayout().setBackgroundColor(getResources().getColor(R.color.Setting_bg));
        //获取单聊面板的标题栏
        mTitleBar = mChatLayout.getTitleBar();
        //单聊面板标记栏返回按钮点击事件，这里需要开发者自行控制
        mTitleBar.setOnLeftClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        if (mChatInfo.getType() == TIMConversationType.C2C) {
            //点击头像进入个人界面
            mTitleBar.setOnRightClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    Intent intent = new Intent(DemoApplication.instance(), FriendProfileActivity.class);
//                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    intent.putExtra(TUIKitConstants.ProfileType.CONTENT, mChatInfo);
//                    DemoApplication.instance().startActivity(intent);
                }
            });
        }
        mChatLayout.getMessageLayout().setOnItemClickListener(new MessageLayout.OnItemClickListener() {
            @Override
            public void onMessageLongClick(View view, int position, MessageInfo messageInfo) {
                //因为adapter中第一条为加载条目，位置需减1
                mChatLayout.getMessageLayout().showItemPopMenu(position - 1, messageInfo, view);
            }

            @Override
            public void onUserIconClick(View view, int position, MessageInfo messageInfo) {
                if (null == messageInfo) {
                    return;
                }
//                ChatInfo info = new ChatInfo();
//                info.setId(messageInfo.getFromUser());
//                Intent intent = new Intent(DemoApplication.instance(), FriendProfileActivity.class);
//                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                intent.putExtra(TUIKitConstants.ProfileType.CONTENT, info);
//                DemoApplication.instance().startActivity(intent);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();


//        initView();

        // TODO 通过api设置ChatLayout各种属性的样例
//        ChatLayoutHelper helper = new ChatLayoutHelper(getActivity());
//        helper.customizeChatLayout(mChatLayout);
    }

    @Override
    public void onPause() {
        super.onPause();
        AudioPlayer.getInstance().stopPlay();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mChatLayout != null) {
            mChatLayout.exitChat();
        }
    }

    /**
     * 6.0以上设置白的黑字状态栏
     */
    protected void setDarkTheme() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView()
                    .setSystemUiVisibility(
                            View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.white));
        }
    }

}
