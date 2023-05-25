package efub.toyproject.twitter.tweet.repository;

import efub.toyproject.twitter.tweet.domain.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TweetRepository extends JpaRepository<Tweet,Long> {
    Optional<Tweet> findByTweetIdAndWriter_AccountId(Long tweetId, Long accountId);
}
