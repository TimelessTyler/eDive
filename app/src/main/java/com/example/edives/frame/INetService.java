package com.example.edives.frame;



import com.example.edives.bean.AddDynamicBean;
import com.example.edives.bean.AlbumBean;
import com.example.edives.bean.AllCommentBean;
import com.example.edives.bean.BannerInfo;
import com.example.edives.bean.CommentBean;
import com.example.edives.bean.ConversationBean;
import com.example.edives.bean.DelectMydynamicBean;
import com.example.edives.bean.DivingBean;
import com.example.edives.bean.DynamicDetailsBean;
import com.example.edives.bean.FollowBean;
import com.example.edives.bean.HotBean;
import com.example.edives.bean.LikeBean;
import com.example.edives.bean.MyDynamicBean;
import com.example.edives.bean.MyPersonBean;
import com.example.edives.bean.NewDynamicBean;
import com.example.edives.bean.NewsDynamicDeatilsBean;
import com.example.edives.bean.NotFollowBean;
import com.example.edives.bean.PersonalMessagerBean;
import com.example.edives.bean.SearchDynamicBean;
import com.example.edives.bean.TopicBean;
import com.example.edives.bean.TopicByIdBean;
import com.example.edives.bean.TopicHotBean;
import com.example.edives.bean.UpdateCoachMessageBean;
import com.example.edives.bean.UserDatilasBean;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface INetService {
    @POST("shop/shopAdvertise")
    Observable<BannerInfo> getFuData(@Body RequestBody body);
    @GET("ums/coachMessage/find")
    Observable<MyPersonBean> getPersonalDeatials();
    @POST("ums/coachMessage/update")
    Observable<UpdateCoachMessageBean> getUpdateMessagercoach(@Body RequestBody body);
    @GET("topic/selectTopic")
    Observable<TopicBean> getHomeTopic();
    @GET("dynamic/selectDynamicHeat")
    Observable<HotBean> getHotData(@Query("pageNum") int num, @Query("pageSize") int pagesize);
    @GET("dynamic/selectDynamicTime")
    Observable<NewDynamicBean> getNewsDynamicData(@Query("pageNum") int num, @Query("pageSize") int pagesize);
    @GET("topic/selectTopicById?")
    Observable<TopicByIdBean> getTopicDtaaa(@Query("id") int topicid);
    @POST("umsFavorites/attention/save?")
    Observable<FollowBean> getFollow(@Body RequestBody follow);
    @POST("umsFavorites/attentionStatus/update?")
    Observable<NotFollowBean> getNotfollows(@Body RequestBody bodyfollow);
    @GET("topic/selectTopicByDynamicHeat")
    Observable<NewsDynamicDeatilsBean> getHotDetalisData(@Query("pageNum") int num, @Query("pageSize") int size, @Query("id") int idss);
    @GET("dynamic/updateDynamicLikePraise?")
    Observable<LikeBean> getLike(@Query("id") int like, @Query("userType") int userType);
    @GET("dynamic/updateDynamicCancelPraise?")
    Observable<LikeBean> getNotLike(@Query("id") int notlike,@Query("userType") int userType);
    @GET("topic/selectTopicByDynamicTime")
    Observable<NewsDynamicDeatilsBean> getNewsDynamicDetalisData(@Query("id") int id, @Query("pageNum") int num, @Query("pageSize") int size);
    @GET("comment/selectCommentAll?")
    Observable<AllCommentBean> getAllComment(@Query("pageNum") int commentnum, @Query("pageSize") int commentsize, @Query("forDynamicId") int commentid);
    @POST("comment/addComment?")
    Observable<CommentBean> getComment(@Body RequestBody bodys);
    @GET("dynamic/selectDynamicById?")
    Observable<DynamicDetailsBean> getDynamicdatas(@Query("id") int post,@Query("userType") int userTypes);
    @GET("topic/selectTopicName")
    Observable<SearchDynamicBean> getSearchDynaic(@Query("topicName") String data);
    @GET("topic/selectTopicPage?")
    Observable<ConversationBean> getConverSation(@Query("pageNum") int pagenumc, @Query("pageSize") int pagesizec);
    @GET("ums/coachMessage/findAndCount")
    Observable<PersonalMessagerBean> getPersonalMessager();
    @GET("dynamic/updateDynamicDelflag")
    Observable<DelectMydynamicBean> getDelectDynamic(@Query("id") int dynamicid);
    @GET("dynamic/selectDynamicPage")
    Observable<MyDynamicBean> getMyDynamic(@Query("userId") String userid, @Query("pageNum") int nums, @Query("pageSize") int sizes);
    @POST("dynamic/addDynamic")
    Observable<AddDynamicBean> getAddDynamic(@Body RequestBody requestBody);
    @GET("topic/selectTopicByDynamicHeat")
    Observable<TopicHotBean> getHotDatasss(@Query("pageNum") int pnum,@Query("pageSize") int psize,@Query("id") int pid);
    @GET("dynamic/queryUserDetails")
    Observable<UserDatilasBean> getUserPerson(@Query("userId") int userids, @Query("userType") int userType);
    @GET("dynamic/selectDynamicAlbumTimeBean")
    Observable<AlbumBean> getAlbum(@Query("userId") int useridperson, @Query("pageNum") int personnum, @Query("pageSize") int personsize, @Query("userType") int userTypes);
    @POST("pms/divingProductList/find")
    Observable<DivingBean> getDiving(@Body RequestBody ha);
    @GET("dynamic/selectDynamicPage")
    Observable<MyDynamicBean> getMyDynamicS(@Query("userId") String userid,@Query("pageNum") int pageNum,@Query("pageSize") int pageSize,@Query("userType") int usertype);
}
