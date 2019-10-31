package org.tachacoin.wallet.ui.fragment.news_detail_fragment;

import org.tachacoin.wallet.model.news.News;

public interface NewsDetailInteractor {
    News getNews(int newsPosition);
}
