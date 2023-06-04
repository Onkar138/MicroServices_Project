package com.lcwd.Rating.Service.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Rating {

    @Id
    private String ratingId;
    private String userId;
    private String hotelId;
    private String feedback;
    private int rating;

}
