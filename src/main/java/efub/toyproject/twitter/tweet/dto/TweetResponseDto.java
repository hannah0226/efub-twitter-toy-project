package efub.toyproject.twitter.tweet.dto;

import efub.toyproject.twitter.tweet.domain.Tweet;
import efub.toyproject.twitter.tweet.repository.TweetRepository;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TweetResponseDto {
    private Long tweetId;
    private Long writerId;
    private String writer;
    private String content;
    private LocalDateTime createDate;

    public TweetResponseDto(Long tweetId, Long writerId, String writer, String content, LocalDateTime createDate){
        this.tweetId=tweetId;
        this.writerId=writerId;
        this.writer=writer;
        this.content=content;
        this.createDate=createDate;
    }

    public static TweetResponseDto from(Tweet tweet){
        return new TweetResponseDto(
                tweet.getTweetId(),
                tweet.getWriter().getAccountId(),
                tweet.getWriter().getNickname(),
                tweet.getContent(),
                tweet.getCreatedDate()
        );
    }
}
