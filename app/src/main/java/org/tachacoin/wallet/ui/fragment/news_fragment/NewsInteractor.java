package org.tachacoin.wallet.ui.fragment.news_fragment;

import org.tachacoin.wallet.model.news.News;
import org.tachacoin.wallet.model.news.RssFeed;

import java.util.List;

import rx.Observable;

public interface NewsInteractor {

    Observable<RssFeed> getMediumRssFeed();

    List<News> getNewses();

    void setNewses(List<News> newses);

    void unSubscribe();
}
