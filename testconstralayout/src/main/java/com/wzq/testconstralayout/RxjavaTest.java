package com.wzq.testconstralayout;

/**
 * <p>作者：wzq<p>
 * <p>创建时间：2019-09-26<p>
 * <p>文件描述：<p>
 */
public class RxjavaTest {

//  private void loadCategoryData() {
//    RetrofitUtils.create(ApiService.class)
//        .channelsWithFollow()
//        .compose(RxUtils.observableToMain())
//        .subscribe(new Observer<BaseResponse<List<ChannelData>>>() {
//          @Override
//          public void onSubscribe(Disposable d) {
//
//          }
//
//          @Override
//          public void onNext(BaseResponse<List<ChannelData>> listBaseResponse) {
//            if (listBaseResponse.bizCode == ApiService.CODE_SUCCESS) {
//              List<ChannelData> data = listBaseResponse.data;
//              if (data != null && data.size() > 0) {
//
//
//                Iterator<ChannelData> iterator = data.iterator();
//                while (iterator.hasNext()) {
//                  ChannelData next = iterator.next();
//                  if ("World".equals(next.channelName)) {
//                    iterator.remove();
//                    break;
//                  }
//                }
//                categoryListAdapter.setUserChannels(data);
//                loadingViewNew.hide();
//                mGroupCategory.setVisibility(View.VISIBLE);
//              }
//            }
//          }
//
//          @Override
//          public void onError(Throwable e) {
//
//          }
//
//          @Override
//          public void onComplete() {
//            checkResult();
//          }
//        });
//    ////////////////
//    @Override
//    @SuppressLint("CheckResult")
//    public void getData(boolean isRefresh, AdapterContract.OnDataListener<List<ListArticle>> changeListener) {
//
//      Observable<BaseResponse<List<ListArticle>>> responseObservable;
//      if (!TextUtils.isEmpty(homeFollowId) || !TextUtils.isEmpty(awayFollowId)) {
//        responseObservable = RetrofitUtils.create(FootballApiService.class).matchArticles(homeFollowId, awayFollowId, lastId == null ? "first" : lastId, lastId == null ? 50 : 10);
//      } else {
//        responseObservable = mApiService.getFollowArticle(mChannelId, lastId == null ? "first" : lastId, lastId == null ? 50 : 10);
//      }
//      responseObservable.compose(RxUtils.observableToMain())
//          .doOnNext(listBaseResponse -> {
//            if (listBaseResponse.bizCode != ApiService.CODE_SUCCESS) {
//              throw new RuntimeException("code err");
//            }
//          })
//          .flatMap(listBaseResponse -> Observable.fromIterable(listBaseResponse.data))
//          .map(listArticle -> {
//            listArticle.updateTime = System.currentTimeMillis();
//            return listArticle;
//          })
//          .filter(listArticle -> {
//            boolean titleEmpty = TextUtils.isEmpty(listArticle.title);
//            boolean idEmpty = TextUtils.isEmpty(listArticle.id);
//            return !titleEmpty && !idEmpty;
//          })
//          .toList()
//          .subscribe((listArticles, throwable) -> {
//            if (throwable != null) {
//              changeListener.onFailure(throwable);
//              return;
//            }
//            updateCnt = listArticles.size();
//            if (updateCnt > 0) {
//              lastId = listArticles.get(updateCnt - 1).id;
//            }
//            Tasks.post2UI(() -> {
//              changeListener.onGetData(listArticles);
//            });
//          });
//    }
//
//
//  }
}