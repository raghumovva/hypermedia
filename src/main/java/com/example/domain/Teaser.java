package com.example.domain;

import org.springframework.data.rest.core.config.Projection;

/**
 * Created by raghu.movva on 12/21/2016.
 */
@Projection(name = "teaser",types = {Post.class})
public interface Teaser {
    String getTitle();
    String getSlug();
    String getTeaser();
}
