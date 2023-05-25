package efub.toyproject.twitter.tweet.domain;

import efub.toyproject.twitter.account.domain.Account;
import efub.toyproject.twitter.global.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Tweet extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tweet_id", updatable = false)
    private Long tweetId;

    @Column
    private String content;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account writer;

    @Builder
    public Tweet(Long tweetId, String content, Account writer){
        this.tweetId=tweetId;
        this.content=content;
        this.writer=writer;
    }
}
