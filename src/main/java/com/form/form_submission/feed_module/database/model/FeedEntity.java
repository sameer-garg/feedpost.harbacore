package com.form.form_submission.feed_module.database.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.Date;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FeedEntity {
    public String name;
    public String image;// to store the image url
    public String content;
    public Date date;

}
