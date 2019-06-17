package beautysalon.model.services;

import beautysalon.model.entities.Review;
import beautysalon.model.entities.User;
import beautysalon.model.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewsService {
    @Autowired
    private ReviewRepository reviewRepository;

    public List<Review> getClientReviews(User client) {
        return reviewRepository.findAllByClientId(client);
    }

    public void createReview(Review review) {
        reviewRepository.save(review);
    }
}
