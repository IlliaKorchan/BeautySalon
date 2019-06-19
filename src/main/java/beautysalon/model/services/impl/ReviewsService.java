package beautysalon.model.services.impl;

import beautysalon.model.entities.Review;
import beautysalon.model.entities.User;
import beautysalon.model.repositories.ReviewRepository;
import beautysalon.model.services.ReviewsProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewsService implements ReviewsProcessor {
    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public List<Review> getClientReviews(User client) {
        return reviewRepository.findAllByClientId(client);
    }

    @Override
    public List<Review> getMasterReviews(User master) {
        return reviewRepository.findAllByMasterId(master);
    }

    @Override
    public void createReview(Review review) {
        reviewRepository.save(review);
    }
}
