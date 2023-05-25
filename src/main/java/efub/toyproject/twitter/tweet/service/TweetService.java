package efub.toyproject.twitter.tweet.service;

import efub.toyproject.twitter.account.domain.Account;
import efub.toyproject.twitter.account.service.AccountService;
import efub.toyproject.twitter.tweet.domain.Tweet;
import efub.toyproject.twitter.tweet.dto.TweetRequestDto;
import efub.toyproject.twitter.tweet.repository.TweetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TweetService {
    private final TweetRepository tweetRepository;
    private final AccountService accountService;

    //트윗 생성
    public Tweet addTweet(TweetRequestDto requestDto){
        Account writer = accountService.findAccountById(requestDto.getAccountId());
        return tweetRepository.save(
                Tweet.builder()
                .content(requestDto.getContent())
                .writer(writer)
                .build()
        );
    }

    //트윗 목록 조회
    @Transactional(readOnly = true)
    public List<Tweet> findTweetList(){
        return tweetRepository.findAll();
    }

    //트윗 개별 조회
    @Transactional(readOnly = true)
    public Tweet findTweet(Long tweetId){
        return tweetRepository.findById(tweetId)
                .orElseThrow(()-> new IllegalArgumentException("존재하지 않는 게시글입니다."));
    }

    //트윗 삭제
    public void removeTweet(Long tweetId, Long accountId){
        Tweet tweet = tweetRepository.findByTweetIdAndWriter_AccountId(tweetId, accountId)
                .orElseThrow(()->new IllegalArgumentException("잘못된 접근입니다."));
        tweetRepository.delete(tweet);
    }
}
